import java.awt.Dimension;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File; 
import javax.imageio.ImageIO;

public class ImageToAscii {
	public static void main(String args[]) throws Exception{
		if (args.length >= 1) {
			System.out.println(args[0]);
		}
		
		BufferedImage image = ImageIO.read(new File("test_photos/photo1.jpg"));
		double width = image.getWidth(); 
		double height = image.getHeight();	
		System.out.println("\n\nWidth and Height: " + "W: " + width + " _____ "+ "H: " + height);	

		for (int w = 0; w < width; w++) {
			for (int h = 0; h < height; h++) {
				Color color = new Color(image.getRGB(w, h));
				System.out.println("{ " + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() + " }");
			}
		}	
	}
}
