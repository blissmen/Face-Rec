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
import java.lang.*;
import java.io.*;



public class TestFaceRecognition  {

    public static void main(String testFace) {


//        String dir = "C:\\Users\\USER\\Documents\\NetBeansProjects\\Trainner\\Trainning_Set";
//        String file = "u.jpg";

      try {
          
        String dir = "C:\\Users\\USER\\Documents\\NetBeansProjects\\Trainner\\Trainning_Set";
        String file = testFace;
        EigenFaceCreator creator = new EigenFaceCreator();

        //creator.USE_CACHE = -1;
        System.out.println("Constructing face-spaces from "+dir+" ...");
        creator.readFaceBundles(dir);

        System.out.println("Comparing "+file+" ...");
        String result = creator.checkAgainst(file);

        System.out.println("Most closly reseambling: "+result+" with "+creator.DISTANCE+" distance.");
          
      } catch (Exception e) { e.printStackTrace(); }
    }

    
    

}
