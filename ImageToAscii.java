import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File; 
import java.lang.Float;
import javax.imageio.ImageIO;

public class ImageToAscii {

	public static int getMax(int a, int b, int c) {
		int max = a;
		if (max < b) { max = b; }
		if (max < c) { max = c; }
		return max;
	}

	public static int getMin(int a, int b, int c) {
		int min = a;
		if (min > b) { min = b; }
		if (min > c) { min = c; }
		return min;
	}
	
	// 3 algorithms for converting RGB to brightness numbers
	public static float getAverage(Color color) {
		return (((float)color.getRed() + color.getGreen() + color.getBlue()))/3.0f;
	}

	public static float getLightness(Color color) {
		int red = color.getRed();
		int green = color.getGreen();
		int blue = color.getBlue();
		return ((float)(getMin(red, green, blue) + getMax(red, green, blue)))/2.0f;
	}

	public static float getLuminance(Color color) {
		float red = (float) color.getRed();
		float green = (float) color.getGreen();
		float blue = (float) color.getBlue();

		return (0.2126f * red + 0.7152f * green + 0.0722f * blue); 
	}

	public static void main(String args[]) throws Exception{
		if (args.length >= 1) {
			System.out.println(args[0]);
		}
		
		BufferedImage image = ImageIO.read(new File("test_photos/photo1.jpg"));
		double width = image.getWidth(); 
		double height = image.getHeight();	
		System.out.println("\n\nWidth and Height: " + "W: " + width + " _____ "+ "H: " + height);	
		
		// assigning it a method depending on what arguments the user provides	
		final Interface ref;

		if (args.length > 1 && args[1].equals("--average")) { ref = ImageToAscii::getAverage; }
		else if (args.length > 1 && args[1].equals("--lightness")) { ref = ImageToAscii::getLightness; }
		else { ref = ImageToAscii::getLuminance; }

		ArrayList<Float> brightnessValues = new ArrayList<>(); 
		for (int w = 0; w < width; w++) {
			for (int h = 0; h < height; h++) {
				Color color = new Color(image.getRGB(w, h));
				brightnessValues.add(ref.getAlgorithmResult(color));
			}
		}
	}

	public static interface Interface {
		float getAlgorithmResult(Color color);
	}
}
