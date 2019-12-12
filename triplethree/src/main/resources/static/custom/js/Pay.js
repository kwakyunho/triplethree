$(function(){
	
	$('.choiceBtn').on('click', function(){
		var basicPay = $(this).parents('.insertPay').children('.basicPay');
		$('#basicPay').val(basicPay.html('input').val());
		//.children('input[type="hidden"]').val();
	});
	
});