/**
 * 전자결재 기안문서함 관련 스크립트
 */

$(function(){
	$('.ajaxVal').on('click', function(){
		var valCheck = $(this).children('a').prop('id');
		console.log(valCheck);
		
		
		// 기안문서의 상태를 구분하여 상태에 맞는 문서를 가져옴
		$.ajax({
			type 		: 'POST',
			data 		: {'valCheck': valCheck},
			url 		: "/signDocument/selectDraftDocument",
			datatype	: 'json',
		
			success : function(data) {
				console.log(JSON.stringify(data));
			}, error : function() {
				console.log("실패");
			}
		});
		
		/* if(valCheck == 'All'){
			alert('전체');
		}else if(valCheck == 'Starting'){
			alert('진행');
		}else if(valCheck == 'End'){
			alert('완료');
		}else if(valCheck == 'Return'){
			alert('반려');
		}else{
			alert('잘못된 접근입니다.');
		} */
	});
});