/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Settings;

import org.opencv.core.Size;

/**
 *
 * @author USER
 */
public class CameraSettings {
    public int CamaraID=0;
    public int frameserSec=33;
    public String imageOutputFormat="jpg";
    public String CascadesFile="resources/haarcascades/haarcascade_frontalface_alt";
    public String resolution ;
    public int imageHeight;
    public Size  minFeatureSize = new Size(20, 20); 
     public float searchScaleFactor = 1.1f; // How many sizes to search.
    public int minNeighbors = 4;


    public Size getMinFeatureSize() {
        return minFeatureSize;
    }

    public void setMinFeatureSize(Size minFeatureSize) {
        this.minFeatureSize = minFeatureSize;
    }

    public float getSearchScaleFactor() {
        return searchScaleFactor;
    }

    public void setSearchScaleFactor(float searchScaleFactor) {
        this.searchScaleFactor = searchScaleFactor;
    }

    public int getMinNeighbors() {
        return minNeighbors;
    }

    public void setMinNeighbors(int minNeighbors) {
        this.minNeighbors = minNeighbors;
    }
   
    public int getCamaraID() {
        return CamaraID;
    }

    public void setCamaraID(int CamaraID) {
        this.CamaraID = CamaraID;
    }

    public int getFrameserSec() {
        return frameserSec;
    }

    public void setFrameserSec(int frameserSec) {
        this.frameserSec = frameserSec;
    }

    public String getImageOutputFormat() {
        return imageOutputFormat;
    }

    public void setImageOutputFormat(String imageOutputFormat) {
        this.imageOutputFormat = imageOutputFormat;
    }

    public String getCascadesFile() {
        return CascadesFile;
    }

    public void setCascadesFile(String CascadesFile) {
        this.CascadesFile = CascadesFile;
    }

    public  String getResolution() {
        return resolution;
    }

    public  void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public  int getImageHeight() {
        return imageHeight;
    }

    public  void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    public  int getImageWidth() {
        return imageWidth;
    }

    public  void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }
    public int imageWidth=800;

    void SelectCascadeFile(String cascadefile) {
        
       switch(cascadefile)
       {
           case "Haar Classifier":
               this.setCascadesFile("resources/haarcascades/haarcascade_frontalface_default.xml");
               break;
           case "Lbp Classifier":
               this.setCascadesFile("resources/lbpcascades/lbpcascade_frontalface.xml");
               break;
           default:
               this.setCascadesFile(CascadesFile);
       }
        
        
    }
}