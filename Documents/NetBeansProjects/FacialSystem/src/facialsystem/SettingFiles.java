/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facialsystem;

/**
 *
 * @author USER
 */
public class SettingFiles {
    static String FaceDir="";

    public static String getFaceDir() {
        return FaceDir;
    }

    public static void setFaceDir(String FaceDir) {
        SettingFiles.FaceDir = FaceDir;
    }
}
