function swapColors(){
	//alert("Button was clicked");
	var choice = confirm("Are you sure?");
	if(choice){
		var el1 = document.getElementById("first-div");
		var el2 = document.getElementById("second-div");
		
		if(el1.classList.contains("brownDiv")){
			el1.classList.remove("brownDiv");
			el1.classList.add("yellowDiv");
			
			el2.classList.remove("yellowDiv");
			el2.classList.add("brownDiv");
			
		}
		else{
			el1.classList.remove("yellowDiv");
			el1.classList.add("brownDiv");
			
			el2.classList.remove("brownDiv");
			el2.classList.add("yellowDiv");
		}
	}
	else{
		alert("You have pressed canceled");
	}
}

function swapText(){
	var choice = confirm("Are you sure?");
	if(choice){
		var el1 = document.getElementById("first-div");
		var el2 = document.getElementById("second-div");
		
		var aux = el1.innerHTML;
		
		el1.innerHTML = el2.innerHTML;
		el2.innerHTML = aux;
	}
	else{
		alert("You have pressed canceled");
	}
}

function changeBackGroundColor(){
	var colorPicker = document.getElementById("colorInput");
	var canvas = document.getElementById("myCanvas");
	var ctx = canvas.getContext("2d");
	ctx.fillStyle = colorPicker.value;
	ctx.fillRect(0, 0, canvas.width, canvas.height);
}

function drawCube(){
	var canvas = document.getElementById("myCanvas");
	var ctx = canvas.getContext("2d");
	var sliderElement = document.getElementById("cubeSlider");
	var size = sliderElement.value;
	var colorPicker = document.getElementById("colorInput");
	ctx.fillStyle = colorPicker.value;
	ctx.clearRect(0,0,canvas.width, canvas.height);
	ctx.fillRect(10, 10, size, size);
}