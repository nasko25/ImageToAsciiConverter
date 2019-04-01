import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File; 

public class ImageToAscii {
	public static void main(String args[]) throws Exception{
		if (args.length >= 1) {
			System.out.println(args[0]);
		}
		
		BufferedImage image = ImageIO.read(new File("test_photos/photo1.jpg"));
		double width = image.getWidth(); 
		double height = image.getHeight();	
		System.out.println("\n\nWidth and Height: " + "W: " + width + " _____ "+ "H: " + height);	
	
	}
}
