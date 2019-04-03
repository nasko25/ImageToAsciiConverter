import java.util.ArrayList;
import java.util.Collections;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.io.File; 
import java.lang.Float;
import java.lang.Math;
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


	public static BufferedImage rescale(BufferedImage original, double scaleFactor) {
		BufferedImage newImage = null;
		if(original != null) {
			newImage = new BufferedImage((int)(original.getWidth()*scaleFactor), (int)(original.getHeight()*scaleFactor), original.getType());
			Graphics2D g2d = newImage.createGraphics();
			AffineTransform at = AffineTransform.getScaleInstance(scaleFactor, scaleFactor);
			g2d.drawRenderedImage(original, at);
		}
		return newImage;
	}

	public static void main(String args[]) throws Exception{
		if (args.length >= 1) {
			System.out.println(args[0]);
		}
			// TODO the user should be able to select images, and probably the scale factor
		BufferedImage image = ImageIO.read(new File("test_photos/photo2.jpg"));
		image = rescale(image, 0.2);
		int width = (int)image.getWidth(); 
		int height = (int)image.getHeight();	
		System.out.println("\n\nWidth and Height: " + "W: " + width + " _____ "+ "H: " + height);	
		
		// assigning it a method depending on what arguments the user provides	
		final Interface ref;

		if (args.length > 1 && args[1].equals("--average")) { ref = ImageToAscii::getAverage; }
		else if (args.length > 1 && args[1].equals("--lightness")) { ref = ImageToAscii::getLightness; }
		else { ref = ImageToAscii::getLuminance; }

		ArrayList<Float> brightnessValues = new ArrayList<>(); 
		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				Color color = new Color(image.getRGB(w, h));
				brightnessValues.add(ref.getAlgorithmResult(color));
			}
		}

		String characters = "`^\",:;Il!i~+_-?][}{1)(|\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$";
		
		// map the brightness values to the characters
		float maxBrightness = Collections.max(brightnessValues);
		float minBrightness = Collections.min(brightnessValues);
		float brightnessLength = (float) (Math.ceil(maxBrightness) - Math.floor(minBrightness));

		float c = ( brightnessLength / ((float) characters.length()));

		// to map the brightness vales to the characters, you need to divide the brightness value to c, and floor the result
		// the result corresponds to the index of the charater in the String characters
		
		ArrayList<Character> convertedCharacters = new ArrayList<>();
		int indexOfCharacter;
		int maxWidth = 0;
		for (int i = 0; i < height*width; i++) {
			indexOfCharacter = (int) Math.floor((brightnessValues.get(i))/c);
			if (indexOfCharacter >= 65) { indexOfCharacter = 64; }
			for (int count = 0; count < 3; count++) {
				System.out.print(characters.charAt(indexOfCharacter));
			}
			maxWidth++;
			if (maxWidth == width) {System.out.println(); maxWidth = 0;}
		}
		
		// TODO print 3 characters instead of 1. because the image looks squashed
	}

	public static interface Interface {
		float getAlgorithmResult(Color color);
	}
}
