/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.udemy.MichaelPogrebinsky.performanceoptimization </p>
 * <p>File Name: Main.java</p>
 * <p>Create Date: 05-Dec-2024 </p>
 * <p>Create Time: 4:16:28 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.shandar.dotJava.udemy.MichaelPogrebinsky.performanceoptimization;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

/**
 * 
 */
public class ImageProcessingUsingThread {

	public static final String SOURCE_FILE = "D:/data/projects/github/dotJava/src/main/java/org/shandar/dotJava/udemy/MichaelPogrebinsky/performanceoptimization/many-flowers.jpg";// "./resources/many-flowers.jpg";
	public static final String DESTINATION_FILE = "D:/data/projects/github/dotJava/src/main/java/org/shandar/dotJava/udemy/MichaelPogrebinsky/performanceoptimization/many-flowers1.jpg";// "./out/many-flowers.jpg";

	public static void main(String[] args) throws IOException {
		BufferedImage originalImage = ImageIO.read(new File(SOURCE_FILE));
		System.out.println(originalImage);
		BufferedImage resultImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(),
				BufferedImage.TYPE_INT_RGB);

		//recolorSingleThreaded(originalImage, resultImage);
		recolorMultiThreaded(originalImage, resultImage, 4);

		File outputFile = new File(DESTINATION_FILE);
		ImageIO.write(resultImage, "jpg", outputFile);
	}

	public static void recolorMultiThreaded(BufferedImage originalImage, BufferedImage resultImage,
			int numberOfThread) {
		List<Thread> threads = new ArrayList<Thread>();
		int width = originalImage.getWidth();
		int height = originalImage.getHeight() / numberOfThread;

		for (int i = 0; i < numberOfThread; i++) {
			final int threadMultiplier = i;
			Thread thread = new Thread(() -> {
				int leftCorner = 0;
				int topCorner = height * threadMultiplier;
				recolorImage(originalImage, resultImage, leftCorner, topCorner, width, height);
			});
			threads.add(thread);
		}

		for (Thread thread : threads) {
			thread.start();
		}

		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public static void recolorSingleThreaded(BufferedImage originalImage, BufferedImage resultImage) {
		recolorImage(originalImage, resultImage, 0, 0, originalImage.getWidth(), originalImage.getHeight());
	}

	public static void recolorImage(BufferedImage originalImage, BufferedImage resultImage, int leftCorner,
			int topCorner, int width, int height) {

		for (int x = leftCorner; x < leftCorner + width && x < originalImage.getWidth(); x++) {
			for (int y = topCorner; y < leftCorner + width && x < originalImage.getWidth(); x++) {
				recolorPixel(originalImage, resultImage, x, y);
			}
		}

	}

	public static void recolorPixel(BufferedImage originalImage, BufferedImage resultImage, int x, int y) {
		int rgb = originalImage.getRGB(x, y);
		int red = getRed(rgb);
		int green = getGreen(rgb);
		int blue = getBlue(rgb);

		int newRed, newGreen, newBlue;

		if (isShadeOfGray(red, green, blue)) {
			newRed = Math.min(255, red + 10);
			newGreen = Math.max(0, green - 80);
			newBlue = Math.max(0, blue - 20);
		} else {
			newRed = red;
			newGreen = green;
			newBlue = blue;
		}
		int newRgb = createRGBFromColors(newRed, newGreen, newBlue);
		setRGB(resultImage, x, y, newRgb);
	}

	public static void setRGB(BufferedImage image, int x, int y, int rgb) {
		image.getRaster().setDataElements(x, y, image.getColorModel().getDataElements(rgb, null));
	}

	public static Boolean isShadeOfGray(int red, int green, int blue) {
		return Math.abs(red - green) < 30 && Math.abs(red - blue) < 30 && Math.abs(green - blue) < 30;
	}

	// https://stackoverflow.com/questions/14295469/what-does-mean-pipe-equal-operator
	/**
	 * <pre>
	 * |= reads the same way as +=.
	 * notification.defaults |= Notification.DEFAULT_SOUND;
	 * is the same as
	 * notification.defaults = notification.defaults | Notification.DEFAULT_SOUND;
	 * where | is the bit-wise OR operator.
	 * </pre>
	 */
	public static int createRGBFromColors(int red, int green, int blue) {
		int rgb = 0;
		rgb |= blue;
		rgb |= green << 8;
		rgb |= red << 16;
		return rgb;
	}

	public static int getRed(int rgb) {
		return (rgb & 0x00FF0000) >> 16;
	}

	public static int getGreen(int rgb) {
		return (rgb & 0x0000FF00) >> 8;
	}

	public static int getBlue(int rgb) {
		return rgb & 0x000000FF;
	}

}
