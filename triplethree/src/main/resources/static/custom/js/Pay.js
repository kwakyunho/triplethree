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
		var nationPer=document.getElementById("nationPer"); //국민연금요율
		var healthPer=document.getElementById("healthPer"); //건강보험요율
		var longCare=document.getElementById("longCare"); //장기요양보험요율
		var inseurPer=document.getElementById("inseurPer"); //고용보험요율
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
			
		//국민연금 계산 소득월액*요율(9%)/2
		//최대치 최저치 있으니까 나중에 참고
		var nation1=parseFloat(nationPer.value)*parseInt(sum1.value);
		var nation=Math.ceil(nation1/2);
		console.log(nation);
		nationPer.value=Math.floor(nation/10)*10;﻿//예를 들어 10으로 나누면 100.5 floor 함수로 소수점을 버리면 100, 다시 10을 곱하면 1000
		
		
		if (add > 4680000){
			alert("국민연금 최대치 218700");
			nationPer.value==218700;
		}else if (add < 310000){
			alert("국민연금 최저지0");
			nationPer.value==0;
		}
		
		//건강보험 계산 
		var health1=parseFloat(healthPer.value)*parseInt(sum1.value);
		var health=Math.ceil(health1/2);
		console.log(health);
		healthPer.value=Math.floor(health/10)*10;
		
		var healthPer=healthPer.value;
		
		//장기요양보험 계산		
		var longCare1=healthPer*parseFloat(longCare.value);
		var long=Math.ceil(longCare1/2);
		console.log(long);
		longCare.value=Math.floor(long/10)*10;
	
		//고용보험 계산
		var inseurper=parseFloat(inseurPer.value)*parseInt(sum1.value);
		var inseur=Math.ceil(inseurper/2);
		console.log(inseur);
		inseurPer.value=Math.floor(inseur/10)*10;		
		});	
	
	});
