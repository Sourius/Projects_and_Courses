package module3;

import processing.core.*;

public class MyPApplet extends PApplet{
	private String url ="https://mk0cs00242yfx7ww7i54.kinstacdn.com/wp-content/uploads/sites/5/nepal-village.jpg";
	private PImage bgImage;
	
	@Override
	public void setup() {
		size(400, 400);
		background(255);
		stroke(0);
		bgImage = loadImage(url,"jpg");
	}
	
	@Override
	public void draw() {
		bgImage.resize(0,height);
		image(bgImage,0,0);
		int[] color = sunColorSec(second());
		fill(color[0], color[1], color[2]);
		ellipse(width/4, height/5, width/4, height/5);
	}
	
	public int[] sunColorSec(float seconds) {
		int[] rgb = new int[3];
		// Scale the brightness of the yellow based on the seconds.  0 seconds 
		// is bright yellow.  30 seconds is black.
		float diffFrom30 = Math.abs(30-seconds);
		
		float ratio = diffFrom30/30;
		rgb[0] = (int)(255*ratio);
		rgb[1] = (int)(255*ratio);
		rgb[2] = 0;
		
		//System.out.println("R" + rgb[0] + " G" + rgb[1] + " B" + rgb[2]);
		return rgb;
	}
}
