//급여 선택시 기본급,식대 추가
$(function(){
	
	$('.choiceBtn').on('click', function(){
		var basicPay = $(this).parents('.insertPay').children('.basicPay');		
		var beneFit = $(this).parents('.insertPay').children('.beneFit');		
		var holidayPay = $(this).parents('.insertPay').children('.holidayPay');		
		var overtimePay = $(this).parents('.insertPay').children('.overtimePay');		
		var positionBenefit = $(this).parents('.insertPay').children('.positionBenefit');		
		var selfDriPay = $(this).parents('.insertPay').children('.selfDriPay');		
		var comPay = $(this).parents('.insertPay').children('.comPay');		
		var childPay = $(this).parents('.insertPay').children('.childPay');		
		var mealCost = $(this).parents('.insertPay').children('.mealCost');		
		var nationPer = $(this).parents('.insertPay').children('.nationPer');		
		var healthPer = $(this).parents('.insertPay').children('.healthPer');		
		var longCare = $(this).parents('.insertPay').children('.longCare');		
		var inseurPer = $(this).parents('.insertPay').children('.inseurPer');		
		var incomePer = $(this).parents('.insertPay').children('.incomePer');		
		var residentTax = $(this).parents('.insertPay').children('.residentTax');		
		
		$('#basicPay').val(basicPay.html('input').val());
		$('#beneFit').val(beneFit.html('input').val());
		$('#holidayPay').val(holidayPay.html('input').val());
		$('#overtimePay').val(overtimePay.html('input').val());
		$('#positionBenefit').val(positionBenefit.html('input').val());
		$('#selfDriPay').val(selfDriPay.html('input').val());
		$('#comPay').val(comPay.html('input').val());
		$('#childPay').val(childPay.html('input').val());
		$('#mealCost').val(mealCost.html('input').val());
		$('#nationPer').val(nationPer.html('input').val());
		$('#healthPer').val(healthPer.html('input').val());
		$('#longCare').val(longCare.html('input').val());
		$('#longCare').val(longCare.html('input').val());
		$('#inseurPer').val(inseurPer.html('input').val());
		$('#incomePer').val(incomePer.html('input').val());
		$('#residentTax').val(residentTax.html('input').val());

		//.children('input[type="hidden"]').val();
		var basicPay=document.getElementById("basicPay"); //기본급
		var beneFit=document.getElementById("beneFit");	  //야간근무수당
		var holidayPay=document.getElementById("holidayPay");//휴일근무수당
		var overtimePay=document.getElementById("overtimePay");//연장근무수당
		var positionBenefit=document.getElementById("positionBenefit");//직책수당
		var selfDriPay=document.getElementById("selfDriPay");//자가운전보조금
		var comPay=document.getElementById("comPay");//통신수당
		var childPay=document.getElementById("childPay");//육아수당
		var mealCost=document.getElementById("mealCost");//식대
		
		var sum1=document.getElementById("sum1"); //과세
		var sum2=document.getElementById("sum2"); //비과세
		var sum3=document.getElementById("sum3"); //지급액 계
		var add=parseInt(basicPay.value)+parseInt(beneFit.value)+parseInt(holidayPay.value)
		+parseInt(overtimePay.value)+parseInt(positionBenefit.value)+parseInt(comPay.value);
		sum1.value =add;
		var add2=parseInt(selfDriPay.value)+parseInt(childPay.value)+parseInt(mealCost.value);
		sum2.value=add2;
		var add3=add+add2;
		sum3.value=add3;
	})
	
});
