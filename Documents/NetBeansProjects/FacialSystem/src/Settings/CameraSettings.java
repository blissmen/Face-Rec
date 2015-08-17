/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Settings;

/**
 *
 * @author USER
 */
public class CameraSettings {
    static int CamaraID=0;
    static int frameserSec=33;
    static String imageOutputFormat="jpg";

    public static String getImageOutputFormat() {
        return imageOutputFormat;
    }

    public static void setImageOutputFormat(String imageOutputFormat) {
        CameraSettings.imageOutputFormat = imageOutputFormat;
    }
    public static int getFrameserSec() {
        return frameserSec;
    }

    public static void setFrameserSec(int frameserSec) {
        CameraSettings.frameserSec = frameserSec;
    }
    public static int getCamaraID() {
        return CamaraID;
    }

    public static void setCamaraID(int CamaraID) {
        CameraSettings.CamaraID = CamaraID;
    }

    public static String getResolution() {
        return resolution;
    }

    public static void setResolution(String resolution) {
        CameraSettings.resolution = resolution;
    }

    public static int getImageHeight() {
        return imageHeight;
    }

    public static void setImageHeight(int imageHeight) {
        CameraSettings.imageHeight = imageHeight;
    }

    public static int getImageWidth() {
        return imageWidth;
    }

    public static void setImageWidth(int imageWidth) {
        CameraSettings.imageWidth = imageWidth;
    }
    static String resolution ;
    static int imageHeight;
    static int imageWidth;
}
