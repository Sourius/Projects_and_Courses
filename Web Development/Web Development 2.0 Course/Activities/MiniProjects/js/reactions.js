var start = new Date().getTime();
var count = 0;

function generateNumber(max){
	return Math.floor((Math.random()*max) + 1);
}

function generateColour(){
	var letters = '0123456789ABCDEF';
	var color = '#';
	for (var i = 0; i < 6; i++) {
		color += letters[Math.floor(Math.random() * 16)];
	}
	return color;
}

function applyRandomColor(){
	var element = document.getElementById("shape");
	// random color
	element.style.backgroundColor = generateColour();
}

function generateSquare(){
	var element = document.getElementById("shape");
	var size = generateNumber(200)+20;
	element.style.height=size+"px";
	element.style.width=size+"px";
	element.classList.add("square");
	
}

function generateCircle(height,width){
	var element = document.getElementById("shape");
	element.classList.add("circle");
}

function resetShape(){
	var element = document.getElementById("shape");
	var shape = generateNumber(2);
	
	var top = Math.random() * 300;
	var left = Math.random() * 1000;;
	
	element.style.top = top+"px";
	element.style.left = left+"px";
	
	if(shape == 1) generateCircle();
	generateSquare();
	applyRandomColor();
	element.style.display = "block";
	
}

function resetTime(){
	start = new Date().getTime();
}

document.getElementById("shape").onclick = function(){
	var end = new Date().getTime();
	var takenTime = (end-start)/1000;
	count++;
	
	document.getElementById("timer").innerHTML=takenTime;
	document.getElementById("counter").innerHTML=count;
	
	var element = document.getElementById("shape")
	element.style.display = "none";
	element.className="";
	
	var wait_time = generateNumber(2000);
	setTimeout(resetShape,wait_time);
	setTimeout(resetTime,wait_time);
}
