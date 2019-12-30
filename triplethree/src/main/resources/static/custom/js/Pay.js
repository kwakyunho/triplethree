
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
		var one = $(this).parents('.insertPay').children('.one');		//소득세
		var inCode = $(this).parents('.insertPay').children('.inCode');		//소득세
		var residentTax = $(this).parents('.insertPay').children('.residentTax'); //지방소득세		
		var empName = $(this).parents('.insertPay').children('.empName');
			console.log(empName);
		var empCode = $(this).parents('.insertPay').children('.empCode');
			console.log(empCode);
		//var empName=document.getElementById("empName").innerHTML;
			//alert('선택된 사원명은 : '+empName +'입니다');
		alert('선택된 사원명은 : '+empName.text()+'입니다');
		$('#empCode').val(empCode.html('input').val());
			
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
		$('#one').val(one.html('input').val());
		$('#residentTax').val(residentTax.html('input').val());
		$('#inCode').val(inCode.html('input').val());

		
	
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
		var one=document.getElementById("one"); //소득세
		var residentTax=document.getElementById("residentTax"); //지방소득세
		var inCode=document.getElementById("inCode"); //소득세
		var sum1=document.getElementById("sum1"); //과세
		var sum2=document.getElementById("sum2"); //비과세
		var sum3=document.getElementById("sum3"); //지급액 계
		var sum4=document.getElementById("sum4"); //공제액 계
		var deductHap=document.getElementById("deductHap"); //차인지급액
	
		
		//과세
		var add=parseInt(basicPay.value)+parseInt(beneFit.value)+parseInt(holidayPay.value)
		+parseInt(overtimePay.value)+parseInt(positionBenefit.value)+parseInt(comPay.value);
		sum1.value =add;
		//비과세
		var add2=parseInt(selfDriPay.value)+parseInt(childPay.value)+parseInt(mealCost.value);
		sum2.value=add2;
		//지급액계
		var add3=add+add2;
		sum3.value=add3;
			
		//국민연금 계산 소득월액*요율(9%)/2
		//최대치 최저치 있으니까 나중에 참고
		var nation1=parseFloat(nationPer.value)*parseInt(sum1.value);
		var nation=Math.ceil(nation1/2);
		console.log(nation);
		nationPer.value=Math.floor(nation/10)*10;﻿//예를 들어 10으로 나누면 100.5 floor 함수로 소수점을 버리면 100, 다시 10을 곱하면 1000
		
		if (add > 4860000){
			alert("기준소득월액 4,860,000원이상은 국민연금 최대납부액 대상자입니다");
			$('#nationPer').val(parseInt(218700));
		
		}else if (add < 310000){
			alert("기준소득월액 310,000원이하는 국민연금 최저납부액이 0원입니다");
			$('#nationPer').val(0);
		}
		var nationPer=nationPer.value;
		
		//건강보험 계산 
		var health1=parseFloat(healthPer.value)*parseInt(sum1.value);
		var health=Math.ceil(health1/2);
		console.log(health);
		healthPer.value=Math.floor(health/10)*10;
		
		if(add > 99250000){
			alert("기준소득월액 99,250,000원이상은 건강보험료 최대납부액은 대상자입니다");
			$('#healthPer').val(parseInt(3205770));
		}else if (add < 280000){
			alert("기준소득월액 280,000원이하는 건강보험료 최저납부액이 0원입니다");
			$('#healthPer').val(0);
		}
		var healthPer=healthPer.value;
		
		//고용보험 계산
		var inseurper=parseFloat(inseurPer.value)*parseInt(sum1.value);
		var inseur=Math.ceil(inseurper/2);
		console.log(inseur);
		inseurPer.value=Math.floor(inseur/10)*10;
		var inseurPer=inseurPer.value;
		
		//장기요양보험 계산		
		var longCare1=parseInt(healthPer)*parseFloat(longCare.value);
		var long=Math.ceil(longCare1);
		console.log(long);
		longCare.value=Math.floor(long/10)*10;
		var longCare=longCare.value;
		
		//장기요양 최저치 알아봐야 함
		if(healthPer >= 3205770){	
			$('#longCare').val(272810);
		}else if(healthPer <=9040){
			
			('#longCare').val(0);
		}
		
		var one =one.value;
		
		if(one >=0){
			
			$('#residentTax').val(parseInt(one/10));
		}
		if(sum1.value < 1060000){
			alert('어디니');
			$('#one').val(parseInt(0));
			$('#residentTax').val(parseInt(0));
		}
		
		var residentTax=residentTax.value;
		console.log(residentTax);
		//공제액 합 		
		var add4=parseInt(nationPer)+parseInt(healthPer)+parseInt(longCare)+parseInt(inseurPer)+parseInt(one)+parseInt(residentTax);
		sum4.value =add4;
		
		//차인지급액
		var deductHap1=parseInt(sum3.value)-parseInt(sum4.value);
		deductHap.value=deductHap1;
		
		});	
	
	});


	
