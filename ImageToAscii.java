import magick.ImageInfo;
import magick.MagickImage;
import java.awt.Dimension;

public class ImageToAscii {
	public static void main(String args[]) throws Exception{
		if (args.length >= 1) {
			System.out.println(args[0]);
		}
		ImageInfo image = new ImageInfo("test_photos/photo1.jpg");
		MagickImage mi = new MagickImage(image);
		image.setPing(true);
		System.out.println("\nImage Information: ");
		System.out.println("Units: " + mi.getUnits() + "\nDimensions: " + mi.getDimension() + "\nColor Space: " + mi.getColorspace() + "\nFile Name: " + mi.getFileName() + "\nX and Y: " + mi.getXResolution() + "; " + mi.getYResolution());		
		Dimension imageDimensions = mi.getDimension();
		double width = imageDimensions.getWidth();
		double height = imageDimensions.getHeight();
		System.out.println("\n\nWidth and Height: " + "W: " + width + " _____ "+ "H: " + height);	
	}
}
