/**
 * 자산관리 관련 스크립트 보관 장소
 */

// 시설물 관리 수정시 modal에 데이터 넣어주는 스크립트
$(function(){
	$('.AssetsListTr').click(function(){
		
		$('#myModal2').modal();	
		
		var code  = $(this).children('#upCode').text();
		var faName  = $(this).children('#faName').text();
		var faLocal  = $(this).children('#faLocal').text();
		var faSeat  = $(this).children('#faSeat').text();
		var faDate  = $(this).children('#faDate').text();
		var faSt  = $(this).children('#faSt').text();
		$('#Code').val(code);
		$('#upName').val(faName);
		$('#upLocal').val(faLocal);
		$('#upSeat').val(faSeat);
		$('#upDatd').val(faDate);
		$('#upSt').val(faSt);
	});
});

// 시설물 등록 시 공란 체크 스크립트
$(function(){
	$('#inputBtn').click(function(){
		var nameCheck = $('input[name=faName]');
		var localCheck = $('input[name=faLocal]');
		var seatCheck = $('input[name=faSeat]');
		var dateCheck = $('input[name=faDate]');
		var stCheck = $('input[name=faSt]');
		var imageCheck = $('input[name=faImage]');
		
		if(nameCheck.val() == ""){
			alert('시설명을 입력해주세요.');
			nameCheck.focus();
			return false;
		}
		if(localCheck.val() == ""){
			alert('위치를 입력해주세요');
			localCheck.focus();
			return false;
		}
		if(seatCheck.val() == ""){
			alert('수용인원을 입력해주세요');
			seatCheck.focus();
			return false;
		}
		if(dateCheck.val() == ""){
			alert('이용날짜를 선택해주세요.');
			dateCheck.focus();
			return false;
		}
		if(stCheck.val() == ""){
			alert('상태를 입력해주세요');
			stCheck.focus();
			return false;
		}
		if(imageCheck.val() == ""){
			alert('이미지를 삽입해주세요.');
			imageCheck.focus();
			return false;
		}
	});
});

//시설물 수정 시 공란 체크 스크립트
$(function(){
	$('#updateBtn').click(function(){
		var nameCheck = $('input[id=upName]');
		var localCheck = $('input[id=upLocal]');
		var seatCheck = $('input[id=upSeat]');
		var dateCheck = $('input[id=upDatd]');
		var stCheck = $('input[id=upSt]');
		var imageCheck = $('input[id=upImage]');
		
		if(nameCheck.val() == ""){
			alert('시설명을 입력해주세요.');
			nameCheck.focus();
			return false;
		}
		if(localCheck.val() == ""){
			alert('위치를 입력해주세요');
			localCheck.focus();
			return false;
		}
		if(seatCheck.val() == ""){
			alert('수용인원을 입력해주세요');
			seatCheck.focus();
			return false;
		}
		if(dateCheck.val() == ""){
			alert('이용날짜를 선택해주세요.');
			dateCheck.focus();
			return false;
		}
		if(stCheck.val() == ""){
			alert('상태를 입력해주세요');
			stCheck.focus();
			return false;
		}
		/*if(imageCheck.val() == ""){
			alert('이미지를 삽입해주세요.');
			imageCheck.focus();
			return false;
		}*/
	});
});

//시설물 등록 유효성 검사(1 = 중복 / 0 != 중복)
$("#inName").blur(function() {
	
	var name = $('#inName').val();
	console.log(name + " <- 시설명이에요.");
	
		$.ajax({
			type 		: 'POST',
		data 		: {'name': name},
		url 		: "beNameCheck",
		datatype	: 'json',
		
			success : function(data) {
			console.log("1 = 중복o / 0 = 중복x : "+ data);							
			
			if (data == 1) {
			// 1 : 아이디가 중복되는 문구
			$('#name_checkBe').text('사용중인 시설명입니다.');
			$('#name_checkBe').css('color', 'red');
			$('#reg_submit').attr('disabled', true);
				} 
			// 0: 아이디가 중복되지 않을때 문구
			else {
			$('#name_checkBe').text('사용가능한 시설명입니다.');
			$('#name_checkBe').css('color', 'green')	          					
				}
			}, error : function() {
				console.log("실패");
			}
	});
});

//시설물 수정 유효성 검사(1 = 중복 / 0 != 중복)
$("#upName").blur(function() {
	
	var name = $('#upName').val();
	console.log(name + " <- 시설명이에요.");
	
		$.ajax({
			type 		: 'POST',
		data 		: {'name': name},
		url 		: "beNameCheck",
		datatype	: 'json',
		
			success : function(data) {
			console.log("1 = 중복o / 0 = 중복x : "+ data);							
			
			if (data == 1) {
			// 1 : 아이디가 중복되는 문구
			$('#name_check').text('사용중인 시설명입니다.');
			$('#name_check').css('color', 'red');
			$('#reg_submit').attr('disabled', true);
				} 
			// 0: 아이디가 중복되지 않을때 문구
			else {
			$('#name_check').text('사용가능한 시설명입니다.');
			$('#name_check').css('color', 'green')	          					
				}
			}, error : function() {
				console.log("실패");
			}
	});
});
