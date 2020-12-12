var image = null;
var originalImage = null;

function uploadImage(){
	var imageFile = document.getElementById("imageFile");
	
	if(imageFile.files.length === 0){
		alert("No image has been selected");
	}
	else{
		originalImage = new SimpleImage(imageFile);
		image = new SimpleImage(imageFile);
		drawImage();
	}
}

function drawImage(){
	var myCanvas = document.getElementById("imageCanvas");
	image.drawTo(myCanvas);
}

function getAverage(pixel){
	return (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
}

function convertToGrayScale(){
	for(var pixel of image.values()){
		var avg = getAverage(pixel);
		pixel.setRed(avg);
		pixel.setGreen(avg);
		pixel.setBlue(avg);
	}
	
	drawImage();
}

function convertToRed(){	
	for(var pixel of image.values()){
		var avg = getAverage(pixel);
		
		if(avg < 128){
			pixel.setRed(2*avg);
			pixel.setGreen(0);
			pixel.setBlue(0);
		}
		else{
			pixel.setRed(255);
			pixel.setGreen(2*avg - 255);
			pixel.setBlue(2*avg - 255);
		}
	}
	drawImage();
}

function convertToRainbow(){
	var colorWidth = image.getHeight()/7;
	
	for(var pixel of image.values()){
		var avg = getAverage(pixel);
		var y = pixel.getY();
		/*red*/
		if(y < colorWidth){
			if(avg < 128){
				pixel.setRed(2*avg);
				pixel.setGreen(0);
				pixel.setBlue(0);
			}
			else{
				pixel.setRed(255);
				pixel.setGreen(2*avg - 255);
				pixel.setBlue(2*avg - 255);
			}
		}
		/*orange*/
		else if(y < 2*colorWidth){
			if(avg < 128){
				pixel.setRed(2*avg);
				pixel.setGreen(0.8*avg);
				pixel.setBlue(0);
			}
			else{
				pixel.setRed(255);
				pixel.setGreen(1.2*avg - 51);
				pixel.setBlue(2*avg - 255);
			}
		}
		/*yellow*/
		else if(y < 3*colorWidth){
			if(avg < 128){
				pixel.setRed(2*avg);
				pixel.setGreen(2*avg);
				pixel.setBlue(0);
			}
			else{
				pixel.setRed(255);
				pixel.setGreen(255);
				pixel.setBlue(2*avg - 255);
			}
		}
		/*green*/
		else if(y < 4*colorWidth){
			if(avg < 128){
				pixel.setRed(0);
				pixel.setGreen(2*avg);
				pixel.setBlue(0);
			}
			else{
				pixel.setRed(2*avg - 255);
				pixel.setGreen(255);
				pixel.setBlue(2*avg - 255);
			}
		}
		/*blue*/
		else if(y < 5*colorWidth){
			if(avg < 128){
				pixel.setRed(0);
				pixel.setGreen(0);
				pixel.setBlue(2*avg);
			}
			else{
				pixel.setRed(2*avg - 255);
				pixel.setGreen(2*avg - 255);
				pixel.setBlue(255);
			}
		}
		/*indigo*/
		else if(y < 6*colorWidth){
			if(avg < 128){
				pixel.setRed(0.8*avg);
				pixel.setGreen(0);
				pixel.setBlue(2*avg);
			}
			else{
				pixel.setRed(1.2*avg-51);
				pixel.setGreen(2*avg - 255);
				pixel.setBlue(255);
			}
		}
		/*violet*/
		else{
			if(avg < 128){
				pixel.setRed(1.6*avg);
				pixel.setGreen(0);
				pixel.setBlue(1.6*avg);
			}
			else{
				pixel.setRed(0.4*avg+153);
				pixel.setGreen(2*avg - 255);
				pixel.setBlue(0.4*avg+153);
			}
		}
	}
	drawImage();
}

function resetImage(){	
	for(var pixel of image.values()){
		var x = pixel.getX(), y = pixel.getY();
		var original = originalImage.getPixel(x, y);
		pixel.setRed(original.getRed());
		pixel.setGreen(original.getGreen());
		pixel.setBlue(original.getBlue());
	}
	drawImage();
}