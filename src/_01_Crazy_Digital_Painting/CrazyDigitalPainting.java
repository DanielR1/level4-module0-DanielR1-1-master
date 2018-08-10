package _01_Crazy_Digital_Painting;

import java.awt.Color;
import java.util.Random;

public class CrazyDigitalPainting {
	//1. Create two final static integers for the width and height of the display.
	final static int width = 1024;
	final static int height = 1024;
	
	//2. Create a 2D array of Color objects. You will need to import
	Color[][] colorArray = new Color[width][height];
	//java.awt.Color. Initialize the size of the array using the 
	//integers created in step 1.
	
	
	
	public CrazyDigitalPainting() {
		//3. Open the crazy_digital_painting.png file and look at the image.
		
		//4. Iterate through the 2D array and initialize each Color object
		//   to a new color. The sample image was created using the following 
		//   pattern:
		//   colors[i][j] = new Color(i % 256, (i * j) % 256, j % 256);
		for (int i = 0; i < colorArray.length; i++) {
			for (int j = 0; j < colorArray[i].length; j++) {
				int r=i*j/4096;
				int g=(int) ((i*Math.abs(Math.sin(j)))%256);
				int b=(int) (j*Math.abs(Math.cos(i))/4);
				colorArray[i][j]=new Color(r,g,b);
			}
			
		}
		
		//5. Come up with your own pattern to make a cool crazy image.
		
		//6. Use the ColorArrayDisplayer class to call the displayColorsAsImage method 
		//   to show off your picture.
		ColorArrayDisplayer.displayColorsAsImage(colorArray);
	}
	
	public static void main(String[] args) {
		new CrazyDigitalPainting();
	}
}
