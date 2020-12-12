var image;

function uploadImage(){
	var imageFile = document.getElementById("imageFile");
	var myCanvas = document.getElementById("imageCanvas");
	
	if(imageFile.files.length === 0){
		alert("No image has been selected");
	}
	else{
		image = new SimpleImage(imageFile);
		image.drawTo(myCanvas);
	}
}

function convertToGrayScale(){
	var avg;
	var grayScaleCanvas = document.getElementById("grayScaleCanvas");
	
	for(var pixel of image.values()){
		avg = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
		pixel.setRed(avg);
		pixel.setGreen(avg);
		pixel.setBlue(avg);
	}
	image.drawTo(grayScaleCanvas);
}