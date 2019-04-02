import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File; 
import javax.imageio.ImageIO;

public class ImageToAscii {

	public static float Average(Color color) {
		return (((float)color.getRed() + color.getGreen() + color.getBlue()))/3.0f;
	}



	public static void main(String args[]) throws Exception{
		if (args.length >= 1) {
			System.out.println(args[0]);
		}
		
		BufferedImage image = ImageIO.read(new File("test_photos/photo1.jpg"));
		double width = image.getWidth(); 
		double height = image.getHeight();	
		System.out.println("\n\nWidth and Height: " + "W: " + width + " _____ "+ "H: " + height);	

		ArrayList<Color> colors = new ArrayList<>(); 
		for (int w = 0; w < width; w++) {
			for (int h = 0; h < height; h++) {
				Color color = new Color(image.getRGB(w, h));
				colors.add(color);
			}
		}
		System.out.println(colors.size());
	}
}
