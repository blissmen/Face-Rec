/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facialsystem;


import java.io.File;
import java.io.FilenameFilter;
import java.util.Vector;
import org.opencv.highgui.Highgui;
import static org.opencv.highgui.Highgui.CV_LOAD_IMAGE_GRAYSCALE;
import org.opencv.contrib.FaceRecognizer;
import org.opencv.core.Algorithm;
import static org.opencv.core.CvType.CV_32SC1;
import org.opencv.core.Mat;

/**
 *
 * @author USER
 */
public class Recognizer{
       static Vector<Mat> images = new Vector();
       static int counter =0;
      
       static Vector Labels = new Vector();
       static String trainingDir = "C:\\Users\\USER\\Documents\\NetBeansProjects\\Trainner\\Trainning_Set";
       static  File root = new File(trainingDir);
       static FilenameFilter pngFilter = new FilenameFilter() {
       public boolean accept(File dir, String name) {
            return name.toLowerCase().endsWith(".jpg");
        }
    };
       static File[] imageFiles =  root.listFiles(pngFilter);
       static public String getLabels(File image)
        {
        String name = image.getName().substring(0, image.getName().length()-6);
        return name;
        }
   
       public static void main()
       {
             Mat labels = new Mat(imageFiles.length, 1, CV_32SC1);
       for (File image : imageFiles) {
     
           Mat img = Highgui.imread(image.getAbsolutePath(), CV_LOAD_IMAGE_GRAYSCALE);

            String label = getLabels(image);
           images.add(counter,img);
            Labels.add(counter, label);
            
            Algorithm algo;
           
           // b.train(images,labels);
            double[] confidence ={0.5};
            int[] lbels = {};
            Mat test = Highgui.imread("FE11A166_2");
            //b.predict(test,lbels,confidence);
            System.out.println(" Predicition"+labels.toString());
            //System.out.println(label);
       }
       }
     
}
