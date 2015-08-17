/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facialsystem;


import Settings.SettingFiles;
import face_recognition.EigenFaceCreator;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class Recognizer{
       static String file = "u.jpg";
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
           
    public static String predict(String testFace)
    {
               String matricule =""; 
               
           try {
                EigenFaceCreator creator = new EigenFaceCreator();
                System.out.println("Constructing face-spaces from "+SettingFiles.getFaceDir()+" .....");
                creator.readFaceBundles(SettingFiles.getFaceDir());
                System.out.println(" Identified with Distance "+creator.DISTANCE);
                matricule=creator.checkAgainst(testFace);
             
               
           } catch (Exception ex) {
               Logger.getLogger(Recognizer.class.getName()).log(Level.SEVERE, null, ex);
           }
           return matricule;
    }

}

     

