$(function(){
	
	$('.deleteCoBtn').children('input').on('click', function(){
		
		var uri = $(this).parents('.companyList');
		var textValue = uri.children('#Code').text();
		uri.children('#Code').append('<input type="hidden" id="code" name="Code">');
		$('#code').val(textValue);
		
		if(confirm('상태를 변경하시겠습니까?')){
			$('#deleteForm').attr('action', 'deleteCompany').submit();
		 }
	});
});