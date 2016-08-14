import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

public class Detector {

	public static void main(String arg[]) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		// Anlýkolarakyakalanankameragörüntülerinigöstereceðimiz frame ve panel
		JFrame cameraFrame = new JFrame("Anlýk kamera görüntüsü");
		cameraFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cameraFrame.setSize(640, 480);
		cameraFrame.setBounds(0, 0, cameraFrame.getWidth(), cameraFrame.getHeight());
		Panel panelCamera = new Panel();
		cameraFrame.setContentPane(panelCamera);
		cameraFrame.setVisible(true);

		// Ýþlenecekgörüntünün threshold uygulandýktan sonraki halini
		// göstereceðimiz frame ve panel
		JFrame thresholdFrame = new JFrame("Threshold görüntü");
		thresholdFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		thresholdFrame.setSize(640, 480);
		thresholdFrame.setBounds(0, 0, cameraFrame.getWidth(), cameraFrame.getHeight());
		Panel panelThreshold = new Panel();
		thresholdFrame.setContentPane(panelThreshold);
		thresholdFrame.setVisible(true);

		// Video akýþýiçin, 0 ilevarsayýlankamerayýbaþlatacaðýz
		VideoCapture capture = new VideoCapture(0);
		// Parametreleri atýyoruz
		/*capture.set(3, 1366);
		capture.set(4, 768);
		capture.set(15, -2);*/
		// Saf kameragörünrüsü
		Mat webcam_image = new Mat();
		// Hsv renk uzayýnda görüntüsü
		Mat hsv_image = new Mat();
		// 1. ve 2. threshold
		Mat thresholded = new Mat();
		Mat thresholded2 = new Mat();
		// Kameradan görüntü oku
		capture.read(webcam_image);
		// Kameradan alýnan görüntüleri gösterecek olduðumuz frame boyutlarý
		// kameradan okunang örüntüye göre ayarlanýyor.

		cameraFrame.setSize(webcam_image.width() + 50, webcam_image.height() + 50);
		thresholdFrame.setSize(webcam_image.width() + 50, webcam_image.height() + 50);

		Mat array255 = new Mat(webcam_image.height(), webcam_image.width(), CvType.CV_8UC1);
		array255.setTo(new Scalar(255));
		Mat distance = new Mat(webcam_image.height(), webcam_image.width(), CvType.CV_8UC1);

		List<Mat> lhsv = new ArrayList<Mat>(3);
		Mat circles = new Mat();
		// Renktespitiburadabelirttiðimizminve max deðerleregöreyapýlacak
		// hsvuzayýndaverdiðimizrenktonlarýarasýndaki her renktespitedilecektir.
		// Renkaralýklarýiçinhsvrenktablolarýnagözatabilirsiniz.

		Scalar minColor = new Scalar(5, 100, 100, 0);
		Scalar maxColor = new Scalar(10, 255, 255, 0);
		// Kamera aygýtý çalýþýyor ise
		if (capture.isOpened()) {
			while (true) {
				capture.read(webcam_image);
				// Bir görüntü okunmuþ ve boþdeðilse
				if (!webcam_image.empty()) {
					// Kameradan okunan görüntü hsv renk uzayýna dönüþtürülür
					Imgproc.cvtColor(webcam_image, hsv_image, Imgproc.COLOR_BGR2HSV);
					Core.inRange(hsv_image, minColor, maxColor, thresholded);

					// Erode ve dilate iþlemi uygulanýr yapýsal element ölçüleri
					// iki iþlemdede aynýdýr
					Imgproc.erode(thresholded, thresholded,
							Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(8, 8)));
					Imgproc.dilate(thresholded, thresholded,
							Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(8, 8)));
					/*
					 * Split metodu
					 * ilegörüntüüzerindekihistogramlarýparçalýyoruz. Matrisin
					 * her boyutu ayrý ayrý nesnelere atanýyor.
					 */
					Core.split(hsv_image, lhsv);
					Mat S = lhsv.get(1);
					Mat V = lhsv.get(2);
					// dizilerarasý element farklarýhesaplýyoruz
					Core.subtract(array255, S, S);
					Core.subtract(array255, V, V);
					S.convertTo(S, CvType.CV_32F);
					V.convertTo(V, CvType.CV_32F);
					// 2 boyutluvektörlerimizinbüyüklüðünühesaplýyoruz
					Core.magnitude(S, V, distance);
					/*
					 * Verilendeðerlerarasýnda thresholding uyguluyor.
					 * pikselindeðeriverilendeðerlerarasýndaise o
					 * piksel,beyazdeðilsesiyahyapýlýyor.
					 */
					Core.inRange(distance, new Scalar(0.0), new Scalar(200.0), thresholded2);
					Core.bitwise_and(thresholded, thresholded2, thresholded);
					// thresholded içingaussian blur filtresiuyguluyoruz
					Imgproc.GaussianBlur(thresholded, thresholded, new Size(9, 9), 0, 0);
					// Þeklindýþhatlarý
					List<MatOfPoint> contours = new ArrayList<MatOfPoint>();
					Imgproc.HoughCircles(thresholded, circles, Imgproc.CV_HOUGH_GRADIENT, 2, thresholded.height() / 8,
							200, 100, 0, 0);
					// thresholding sonrasýnesnenin binary
					// haliüzerindebaðlýnoktalarýtesiðediyoruz
					Imgproc.findContours(thresholded, contours, thresholded2, Imgproc.RETR_LIST,
							Imgproc.CHAIN_APPROX_SIMPLE);
					// Nesneninkonumunaaþaðýdakirenkileçiziyoruz
					Imgproc.drawContours(webcam_image, contours, -2, new Scalar(10, 0, 0), 4);

					/*
					 * Panellerüzerinegörünrüleriatayýp frame'lerin
					 * tekrardançizilmesinisaðlýyoruz
					 */
					panelCamera.setimagewithMat(webcam_image);
					panelThreshold.setimagewithMat(thresholded);
					cameraFrame.repaint();
					thresholdFrame.repaint();

				} else {
					JOptionPane.showMessageDialog(null, "Kamera aygýtýna baðlanýlamadý!");
					break;
				}
			}
		}

	}

}