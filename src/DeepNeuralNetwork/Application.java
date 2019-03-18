
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args)
    {
        System.loadLibrary("opencv_java340");
        DeepNeuralNetworkProcessor processor = new DeepNeuralNetworkProcessor();
        List<DnnObject> detectObject = new ArrayList<>();
        VideoCapture capturre = new VideoCapture(0);
        while (true)
        {
           Mat frame = new Mat();
           capturre.read(frame);
           detectObject = processor.getObjectsInFrame(frame, false);
           for (DnnObject obj: detectObject)
           {
               Imgproc.rectangle(frame,obj.getLeftBottom(),obj.getRightTop(),new Scalar(255,0,0),1);
           }
           Imgcodecs.imwrite("DetectedObject.jpg",frame);
        }

    }
}
