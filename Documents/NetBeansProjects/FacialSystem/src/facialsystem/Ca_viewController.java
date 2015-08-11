/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facialsystem;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.dialog.Dialogs;
import org.opencv.contrib.FaceRecognizer;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.opencv.imgproc.Imgproc;
import static org.opencv.imgproc.Imgproc.equalizeHist;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.objdetect.Objdetect;
import static org.opencv.objdetect.Objdetect.CASCADE_SCALE_IMAGE;

import General.ControlledScreen;
import General.GeneralFunctions;
import General.ScreensController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class Ca_viewController implements Initializable,ControlledScreen {
    @FXML
    private ImageView imagepath;
    private int absoluteFaceSize;
    boolean cameraActive;
    VideoCapture capture_obj;
    private TimerTask frameGrabber;
    int amount = 4;
    private Mat frame;
    private Rect rect1;
    private Timer timer;
    private Image CamStream;
    private CascadeClassifier faceCascade;
    private Mat imFrame;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         this.faceCascade = new CascadeClassifier();
	this.absoluteFaceSize = 0;
         capture_obj = new VideoCapture(0);
        startCamera();
    }    
     protected void startCamera() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (!this.cameraActive) {
			// disable setting checkboxes
            
            // start the video capture
            this.capture_obj.open(0);

            // is the video stream available?
            if (this.capture_obj.isOpened()) {
                this.cameraActive = true;
                System.out.println("hello camara up");
                // grab a frame every 33 ms (30 frames/sec)
                frameGrabber = new TimerTask() {
                    @Override
                    public void run() {
                        CamStream = grabFrame();
//                                    System.out.println(CamStream.toString());
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                imagepath.setImage(CamStream);
                                imagepath.setSmooth(true);
                                imagepath.setMouseTransparent(true);
                                imagepath.setFitWidth(600);
                                imagepath.setPreserveRatio(true);
                            }
                        });
                    }
                };
                this.timer = new Timer();
                this.timer.schedule(frameGrabber, 0, 33);

            } else {
                System.err.println("Failed to open the camera connection...");
            }
        } else {
            // the camera is not active at this point
            this.cameraActive = false;
			// update again the button content
            //this.capture.setText("Capture Next");
            // enable setting checkboxes

            // stop the timer
            if (this.timer != null) {
                this.timer.cancel();
                this.timer = null;
            }
            // release the camera
            this.capture_obj.release();
            // clean the image area
            imagepath.setImage(null);
        }

    }
     
 private void detectAndDisplay(Mat frames)
	{
		// init
		MatOfRect faces = new MatOfRect();
		Mat grayFrame = new Mat();
		
		// convert the frame in gray scale
		Imgproc.cvtColor(frames, grayFrame, Imgproc.COLOR_BGR2YUV_I420);
		// equalize the frame histogram to improve the result
		Imgproc.equalizeHist(grayFrame, grayFrame);
		int flags = CASCADE_SCALE_IMAGE;
		// compute minimum face size (20% of the frame height)
		if (this.absoluteFaceSize == 0)
		{
			int height = grayFrame.rows();
			if (Math.round(height * 0.2f) > 0)
			{
				this.absoluteFaceSize = Math.round(height * 0.2f);
			}
		}
		
		// detect faces
		this.faceCascade.detectMultiScale(grayFrame, faces, 1.1, 3, 0 | Objdetect.CASCADE_SCALE_IMAGE, new Size(
				this.absoluteFaceSize, this.absoluteFaceSize), new Size());
		
		// each rectangle in faces is a face
		Rect[] facesArray = faces.toArray();
                Rect rect_crop=null;
             
                for (Rect rect : facesArray) {
                    rect1=rect;
                    Core.rectangle(frames, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
                    new Scalar(0, 255, 0));
                    Tick(frame);
                    
        }	
            
        
        }       

    private Image grabFrame() {
        // init everything
        Image imageToShow = null;
        frame = new Mat();

        // check if the capture is open
        if (this.capture_obj.isOpened()) {
            try {
                // read the current frame
                this.capture_obj.read(frame);

                // if the frame is not empty, process it
                if (!frame.empty()) {
					
                    
                    MatOfRect faces = new MatOfRect();
                    Mat grayFrame = new Mat();

                    // convert the frame in gray scale
                    Imgproc.cvtColor(frame, grayFrame, Imgproc.COLOR_BGR2GRAY);
                   
                    // equalize the frame histogram to improve the result
                   Imgproc.equalizeHist(grayFrame, grayFrame);
                    // convert the Mat object (OpenCV) to Image (JavaFX)
                    this.detectAndDisplay(frame);
                  //  Imgproc.equalizeHist(frame, frame);
                    imageToShow = mat2Image(frame);
//                    boolean file = new File(user.getTainingDir()).mkdir();
                    

                }
            } catch (Exception e) {
                // log the (full) error
                System.err.print("ERROR");
                e.printStackTrace();
            }

        }
        return imageToShow;
    }

    private Image mat2Image(Mat frame) {
        //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        MatOfByte buffer = new MatOfByte();
        // encode the frame in the buffer, according to the PNG format
        Highgui.imencode(".jpg", frame, buffer);
		// build and return an Image created from the image encoded in the
        // buffer
        return new Image(new ByteArrayInputStream(buffer.toArray()));
    }

        

    @Override
    public void setScreenParent(ScreensController pane) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void Tick(Mat frame)
    {
    Rect rect_crop = new Rect(rect1.x, rect1.y, rect1.width, rect1.height);
                    Mat image_roi= new Mat(imFrame,rect_crop);
    String TestFace ="test.jpg";
                Highgui.imwrite(TestFace, frame);
        
        String mat = Recognizer.predict(TestFace);
       General.GeneralFunctions function = new GeneralFunctions();
//       function.saveStuClass(mat);
    
    }
    
}
