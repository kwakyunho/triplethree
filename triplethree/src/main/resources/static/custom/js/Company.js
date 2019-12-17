$(function(){
	
	$('.deleteCoBtn').children('input').on('click', function(){
		
		var uri = $(this).parents('.companyList');
		var textValue = uri.children('#coName').text();
		uri.children('#coName').append('<input type="hidden" id="co_name" name="coName">');
		$('#co_name').val(textValue);		
		if(confirm('상태를 변경하시겠습니까?')){
			$('#deleteForm').attr('action', 'deleteCompany').submit();
		 }
	});
});