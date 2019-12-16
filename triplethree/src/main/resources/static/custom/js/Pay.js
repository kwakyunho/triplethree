//급여 선택시 기본급,식대 추가
$(function(){
	
	$('.choiceBtn').on('click', function(){
		var basicPay = $(this).parents('.insertPay').children('.basicPay');		
		var mealCost = $(this).parents('.insertPay').children('.mealCost');		
		$('#basicPay').val(basicPay.html('input').val());
		$('#mealCost').val(mealCost.html('input').val());
	
		//.children('input[type="hidden"]').val();
		var basicPay=document.getElementById("basicPay");
		var mealCost=document.getElementById("mealCost");
		var sum1=document.getElementById("sum1");
		var add=parseInt(basicPay.value)+parseInt(mealCost.value);
		sum1.value =add;
	});
	
});
