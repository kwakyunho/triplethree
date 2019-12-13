/**
 * 자산관리 관련 스크립트 보관 장소
 */

// 시설물 관리 수정시 modal에 데이터 넣어주는 스크립트
$(document).ready(function(){
	$('.updateBe').children('input').on('click', function(){
		var uri = $(this).parents('.AssetsListTr')
		
		$('#code').val(uri.children('#upCode').text());
		console.log(uri.children('#upCode').text());
		$('#upName').val(uri.children('#faName').text());
		$('#upLocal').val(uri.children('#faLocal').text());
		$('#upSeat').val(uri.children('#faSeat').text());
		//$('#upImage').val(uri.children('#faImage').text());
		$('#upSt').val(uri.children('#faSt').text());
		
		$('#myModal2').modal();
	});
});

// 시설물 등록 시 공란 체크 스크립트
$(function(){
	$('#inputBeBtn').click(function(){
		var nameCheck = $('input[name=faName]');
		var localCheck = $('input[name=faLocal]');
		var seatCheck = $('input[name=faSeat]');
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
	$('#updateBeBtn').click(function(){
		var nameCheck = $('input[id=upName]');
		var localCheck = $('input[id=upLocal]');
		var seatCheck = $('input[id=upSeat]');
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

//시설물 관리에서 등록,수정,삭제 버튼 클릭시 발생하는 이벤트
$(function(){
	
	$('.inputBeBtn').click(function(){
		if(confirm('등록하시겠습니까?')){
			$('#formInput').attr('action', 'assetsBeInsert').submit();	
		}
	});	
	
	$('#updateBeBtn').click(function(){
		if(confirm('수정하시겠습니까?')){
			$('#formUpdate').attr('action', 'assetsBeUpdate').submit();	
		}
	});	
	
	$('.deleteBeBtn').children('input').on('click', function(){
		var uri = $(this).parents('.AssetsListTr');
		var textValue = uri.children('#upCode').text();
		console.log(textValue);
		uri.children('#upCode').append('<input type="hidden" id="becode" name="code">');
		$('#becode').val(textValue);
		
		if(confirm('삭제하시겠습니까?')){
			$('#deleteForm').attr('action', 'assetsBeDelete').submit();
		 }
	});
});

// 차량 등록시 공란체크 스크립트
$(function(){
	$('#inCarBtn').click(function(){
		var veMakeCheck = $('input[name=veMake]');
		var veNameCheck = $('input[name=veName]');
		var veNunberCheck = $('input[name=veNunber]');
		var veCcCheck = $('input[name=veCc]');
		var faStCheck = $('input[name=faSt]');
		var veUseCheck = $('input[name=veUse]');
		var veBuyCheck = $('input[name=veBuy]');
		var veModelYearCheck = $('input[name=veModelYear]');
		
		if(veMakeCheck.val() == ""){
			alert('제조사를 입력해주세요');
			veMakeCheck.focus();
			return false;
		}
		if(veNameCheck.val() == ""){
			alert('차량명을 입력해주세요');
			veNameCheck.focus();
			return false;
		}
		if(veNunberCheck.val() == ""){
			alert('차량번호를 입력해주세요');
			veNunberCheck.focus();
			return false;
		}
		if(veCcCheck.val() == ""){
			alert('배기량을 입력해주세요');
			veCcCheck.focus();
			return false;
		}
		if(veUseCheck.val() == ""){
			alert('용도를 입력해주세요');
			veUseCheck.focus();
			return false;
		}
		if(faStCheck.val() == ""){
			alert('상태를 입력해주세요');
			faStCheck.focus();
			return false;
		}
		if(veModelYearCheck.val() == ""){
			alert('차량연식을 선택해주세요');
			veModelYearCheck.focus();
			return false;
		}
		if(veBuyCheck.val() == ""){
			alert('구입연도를 선택해주세요');
			veBuyCheck.focus();
			return false;
		}
	});
});

//차량 관리 수정시 modal에 데이터 넣어주는 스크립트
$(document).ready(function(){
	$('.updateCar').children('input').on('click', function(){
		var uri = $(this).parents('.AssetsListTr')
		
		$('#code').val(uri.children('#upCode').text());
		$('#upVeMake').val(uri.children('#veMake').text());
		$('#upVeName').val(uri.children('#veName').text());
		$('#upVeNunber').val(uri.children('#veNunber').text());
		$('#upVeCc').val(uri.children('#veCc').text());
		$('#upVeUse').val(uri.children('#veUse').text());
		$('#upVeBuy').val(uri.children('#veBuy').text());
		$('#upVeModelYear').val(uri.children('#veModelYear').text());
		$('#upFaSt').val(uri.children('#faSt').text());
		
		$('#myModal2').modal();
	});
});

// 차량관리에서 등록,수정,삭제 버튼 클릭시 발생하는 이벤트
$(function(){
	
	$('.insertCarBtn').click(function(){
		if(confirm('등록하시겠습니까?')){
			$('#formInput').attr('action', 'assetsCaInsert').submit();	
		}
	});	
	
	$('#updateCarBtn').click(function(){
		if(confirm('수정하시겠습니까?')){
			$('#formUpdate').attr('action', 'assetsCaUpdate').submit();	
		}
	});	
	
	$('.deleteCarBtn').children('input').on('click', function(){
		
		var uri = $(this).parents('.AssetsListTr');
		var textValue = uri.children('#upCode').text();
		uri.children('#upCode').append('<input type="hidden" id="decode" name="code">');
		$('#decode').val(textValue);
		
		if(confirm('삭제하시겠습니까?')){
			$('#deleteForm').attr('action', 'assetsCaDelete').submit();
		 }
	});
});