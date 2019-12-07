/**
 * 자산관리 관련 스크립트 보관 장소
 */

// 시설물 관리 수정시 modal에 데이터 넣어주는 스크립트
$(function(){
	$('.update').on('click',function(){
		$('#myModal2').modal();	
		var code = $('#upCode').text();
		var faName = $('#faName').text();
		var faLocal = $('#faLocal').text();
		var faSeat = $('#faSeat').text();
		var faDate = $('#faDate').text();
		var faSt = $('#faSt').text();
		/* var length = $('.AssetsListTr').length;
		console.log(length); */
		$('#Code').attr('value', code);
		$('#upName').attr('value', faName);
		$('#upLocal').attr('value', faLocal);
		$('#upSeat').attr('value', faSeat);
		$('#upDatd').attr('value', faDate);
		$('#upSt').attr('value', faSt);
	})
});

