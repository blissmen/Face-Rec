package face_recognition;

/*
 *
 * Copyright (c) 2002 by Konrad Rzeszutek
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 */
import java.io.*;
/**
 * The face-space bundle generated by {@link EigenFaceComputation}.
 * This bundle has all the relevant information to try to match an image
 * The computation to be done (to find the submitted image in this
 * bundles' face-space) is quite fast.
 * For more about the algorithm, consult (<a href="http://www.cs.ucsb.edu/~mturk/Papers/mturk-CVPR91.pdf">http://www.cs.ucsb.edu/~mturk/Papers/mturk-CVPR91.pdf</a>)
 *
 * Each FaceBundle contains
 * sixteen images and their identifying string.
 * <br><b>NOTE</b>: This object is serializable, therefere its possible
 * to cache these face-spaces thus eliminating the computation process
 * in {@link EigenFaceComputation}.
 *
 *
 *
 * @author Konrad Rzeszutek
 * @version 1.0
 */
public class FaceBundle implements Serializable, Comparable {

  private double[] avgFace = null;
  private double[] cmpFace = null;
  private double[][] eigVector = null;
  private double[][] wk = null;
  private String[] id   = null;
  private transient double minD   = Double.MAX_VALUE;
  /**
   * The length of the vector-images stored in the face-space bundle. The
   * submitted image <b>MUST</b> of the same length or greater (if its greater
   * only <code>length</code> will be considered).
   */
  public int length    = Integer.MIN_VALUE;
  private transient boolean computed = false;
  private transient int idx       = Integer.MAX_VALUE;

  /**
   * The face-space object containing:
   *
   * <ol>
   *  <li>An average face array.
   *  <li>Eigenspace of images
   *  <li>Face space of images
   *  <li>List of names identifying each image
   * </ol>
   *
   * @param  avgF Average face (used to normalize the image to be matched against)
   * @param wk  The eigenface componenets (projected onto the eigenspace)
   * @param eigV  The eigenspace (onto which the matched image will be projected too)
   * @param id  A String array representing each of the sixteen images represented
   *  by this face-space.
   *
   */
  public FaceBundle(double[] avgF, double wk[][], double[][] eigV, String[] files) {

    avgFace = new double[avgF.length];
    this.wk = new double[wk.length][wk[0].length];
    eigVector = new double[eigV.length][eigV[0].length];
    //this.id = new String[files.length];
    length = avgFace.length;

    System.arraycopy(avgF,0,this.avgFace,0,avgFace.length);
    System.arraycopy(eigV,0,this.eigVector,0,eigVector.length);
    System.arraycopy(wk,  0,this.wk, 0, wk.length);
    //System.arraycopy(files,  0,this.id, 0, id.length);

    this.id = files;
  }

  /**
   * Submit an image of matching against the face-space.
   * The results are published in <code>distance()</b> and <code>getID()</code>.
   *
   * @param face  The vector-array of the image. The image must be off <b>length</b>
   *
   */
  public void submitFace(byte[] face) {
    // Convert it to double.
    for (int i = 0; i< length;i++)
      cmpFace[i] = (double) (face[i] & 0xFF);

    compute();
  }

  /**
   * Submit an image of matching against the face-space.
   * The results are published in <code>distance()</b> and <code>getID()</code>.
   *
   * @param face  The vector-array of the image. The image must be off <b>length</b>
   *
   */
  public void submitFace(int[] face) {

    for (int i = 0; i< length;i++)
      cmpFace[i] = face[i];

    compute();
  }

  /**
   * Submit an image of matching against the face-space.
   * The results are published in <code>distance()</b> and <code>getID()</code>.
   *
   * @param face  The vector-array of the image. The image must be off <b>length</b>
   *
   */
  public void submitFace(double[] face) {

      this.cmpFace = face;
      compute();


  }
  /**
   * Clear the submitted image from the face-space object.
   */
  public void clearFace() {

    cmpFace = null;
    computed = false;
    idx = Integer.MAX_VALUE;
    minD = Double.MAX_VALUE;
  }

  /**
   * The distance of how far away the submitted image is in this
   * face-space object. Consult <code>getID()</code> for the name
   * of the image that it was most near too.
   *
   * @return  >= 0 or if no image has been submitted: <code>Double.MAX_VALUE</code>
   */
  public double distance() {

    return minD;
  }

  /**
   * The ID of the submitted image in this face-space object.
   *
   * @return  A string, but if no image has been submitted a ArrayOutOfBoundException
   *
   * @throws  ArrayOutOfBoundException if there has been no image submitted.
   */
  public String getID() {

    return this.id[idx];
  }

  /**
   * All the names of the images in this face-space.
   *
   * @return  getNames().length == 16
   */
  public String[] getNames() {
    return id;
  }

  /**
   * Compare this face-space bundle to another. If this bundle has
   * a smaller distance than the other, -1 is returned. 1 if its opposite.
   * <b>NOTE</b>: There is no checking if the other face-space bundle
   * has computed its values for the same image.
   */
  public int compareTo(Object o) {


    if (((FaceBundle)o).minD > minD)
      return 1;
    if (((FaceBundle)o).minD < minD)
      return -1;

    return 0;
  }

  /**
   * Get a string representation.
   */
  public String toString() {

    if (computed)
      return "["+id[idx] + "] with "+minD;
    return "No image supplied";
  }

  /**
   * Do the computation..
   *
   */
  private void compute() {


    double[] inputFace = new double[length];
    int nrfaces = eigVector.length;
    int MAGIC_NR = wk[0].length;
    int j, pix, image;

    computed = false;
    System.arraycopy(cmpFace,0,inputFace,0,length);

    for ( pix = 0; pix < inputFace.length; pix++) {
        inputFace[pix] = inputFace[pix] - avgFace[pix];
    }

    //System.out.println(nrfaces+" "+inputFace.length);
    double[] input_wk = new double[MAGIC_NR];
    double temp = 0;
    /* Subtract the image from the average image */
    for (j = 0; j < MAGIC_NR; j++) {
      temp = 0.0;
      for ( pix=0; pix <length; pix++)
        temp += eigVector[j][pix] * inputFace[pix];

      input_wk[j] = Math.abs( temp );
    }

    /*
     * Find the minimun distance from the input_wk as compared to wk
     */


    double[] distance = new double[MAGIC_NR];
    double[] minDistance = new double[MAGIC_NR];
    idx = 0;
    for (image = 0; image < nrfaces; image++) {
        temp = 0.0;
        for (j = 0; j < MAGIC_NR; j++) {
          distance[j] = Math.abs(input_wk[j] - wk[image][j]);
          //System.out.print(distance[j]+"\t");
        }
        //System.out.println();
        if (image == 0)
          System.arraycopy(distance,0,minDistance,0,MAGIC_NR);
        if (sum(minDistance) > sum(distance)) {

          this.idx = image;
          System.arraycopy(distance,0,minDistance,0,MAGIC_NR);
        }
    }


    /*
     * Normalize our minimum distance.
     */

    if (max(minDistance) > 0.0)
      divide(minDistance, max(minDistance));

    minD = sum(minDistance);

    computed = true;


  }
/**
   * Divide each element in <code>v</code> by <code>b</code>
   * No checking for division by zero.
   *
   * @param v vector containing numbers.
   * @param b scalar used to divied each element in the v vector
   *
   * @return  a vector having each element divided by <code>b</code> scalar.
   *
   */
    static void divide(double[] v, double b) {

    for (int i = 0; i< v.length; i++)
      v[i] = v[i] / b;


  }
   /**
   * The sum of the vector.
   *
   * @param a vector with numbers
   * @return  a scalar with the sum of each element in the <code>a</code> vector
   */
  static double sum(double[] a) {

    double b = a[0];
    for (int i = 0; i < a.length; i++)
      b += a[i];

    return b;

  }
   /**
   * The max of the vector a.
   *
   * @param a the vector
   *
   * @return  the sum of all the elements on <code>a</code>
   */
  static double max(double[] a) {
    double b = a[0];
    for (int i = 0; i < a.length; i++)
      if (a[i] > b) b = a[i];

    return b;
  }

}


