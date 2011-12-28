$(document).ready(function(){
	
	positionFooter(); 
	$(window)
		.scroll(positionFooter)
		.resize(positionFooter)
	

	$('#coda-slider-1').codaSlider(1);
	$('#coda-slider-2').codaSlider(2);
        $("#slide-2").addClass("hidden");



	$("#suggestions").click(function(){
		hideSlide(1);
		showSlide(2);
		$(this).find("li mark").addClass("active");
		$("#results").find("li mark").removeClass("active");
	});
	
	$("#results").click(function(){
		hideSlide(2);
		showSlide(1);
		$(this).find("li mark").addClass("active");
		$("#suggestions").find("li mark").removeClass("active");
	});

        
	$('input[type=text]').click(function(){
		$(this).val("");
	});
		
	//$('input[type=text]').blur(function(){
		//$(this).val("Semantic Search");
	//});
	
	//$('form').submit(function(){
		//$("input[type=text]").val("Semantic Search");
	//});


});
	
	
function positionFooter(){
		$("footer").css({
			position: "fixed",
			top:($(window).scrollTop()+$(window).height()-$("footer").height())+"px"
		})
	}
	
function hideSlide(slideID){
	
	$("#slide-"+slideID).slideUp("fast",function(){
		
		})
}

function showSlide(slideID){
	
	$("#slide-"+slideID).slideDown("fast",function(){
		
		})
}
