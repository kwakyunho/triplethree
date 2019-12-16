/**
 * input 박스의 공란 체크 및 유효성 검사 진행 하는 스크립트
 */

// 부서등록 공란체크
$(function() {
	$('#inputBtn').click(function() {
		var nameCheck = $('input[name=departmentNameBe]');
		var levelCheck = $('input[name=departmentLevel]');
		var sauCheck = $('input[name=departmentSau]');

		if (nameCheck.val() == "") {
			alert('부서명을 입력 해주세요.');
			nameCheck.focus();
			return false;
		}
		if (levelCheck.val() == "") {
			alert('레벨을 입력 해주세요.');
			levelCheck.focus();
			return false;
		}
		if (sauCheck.val() == "") {
			alert('사유를 입력 해주세요.');
			sauCheck.focus();
			return false;
		}
	});
});

// 부서수정 공란체크
$(function() {
	$('#updateBtn').click(function() {
		var nameBeCheck = $('input[id=departmentNameBeUp]');
		var nameAfCheck = $('input[name=departmentNameAf]');
		var levelCheck = $('input[id=departmentLevelUp]');
		var upCodeCheck = $('input[name=departmentUpcode]');
		var sauCheck = $('input[id=departmentSauUp]');

		if (nameBeCheck.val() == "") {
			alert('변경전 부서명을 입력해주세요.');
			nameBeCheck.focus();
			return false;
		}
		if (nameAfCheck.val() == "") {
			alert('변경후 부서명을 입력해주세요.');
			nameAfCheck.focus();
			return false;
		}
		if (levelCheck.val() == "") {
			alert('레벨을 입력해주세요.');
			levelCheck.focus();
			return false;
		}
		if (upCodeCheck.val() == "") {
			alert('상위부서를 입력해주세요.');
			upCodeCheck.focus();
			return false;
		}
		if (sauCheck.val() == "") {
			alert('사유를 입력해주세요.');
			sauCheck.focus();
			return false;
		}
	});
});

//부서 등록 유효성 검사(1 = 중복 / 0 != 중복)
$("#inputTitle").blur(function() {
	
	var title = $('#inputTitle').val();
	console.log(title + " <- 부서명이에요.");
	
		$.ajax({
		type 		: 'POST',
		data 		: {'title': title},
		url 		: "deNameCheck",
		datatype	: 'json',
		
			success : function(data) {
			console.log("1 = 중복o / 0 = 중복x : "+ data);							
			
			if (data == 1) {
			// 1 : 아이디가 중복되는 문구
			$('#id_checkBe').text('사용중인 부서명입니다.');
			$('#id_checkBe').css('color', 'red');
			$('#reg_submit').attr('disabled', true);
				} 
			// 0: 아이디가 중복되지 않을때 문구
			else {
			$('#id_checkBe').text('사용가능한 부서명입니다.');
			$('#id_checkBe').css('color', 'green')	          					
				}
			}, error : function() {
				console.log("실패");
			}
	});
});

//부서 수정 유효성 검사(1 = 중복 / 0 != 중복)
$("#departmentNameAf").blur(function() {
	
	var title = $('#departmentNameAf').val();
	console.log(title + " <- 부서명이에요.");
	
		$.ajax({
			type 		: 'POST',
		data 		: {'title': title},
		url 		: "deNameCheck",
		datatype	: 'json',
		
			success : function(data) {
			console.log("1 = 중복o / 0 = 중복x : "+ data);							
			
			if (data == 1) {
			// 1 : 아이디가 중복되는 문구	
			$('#id_checkAf').text('사용중인 부서명입니다.');
			$('#id_checkAf').css('color', 'red');
			$('#reg_submit').attr('disabled', true);
				} 
			// 0: 아이디가 중복되지 않을때 문구
			else {        					
			$('#id_checkAf').text('변경가능한 부서명입니다.');
			$('#id_checkAf').css('color', 'green')	          					
				}
			}, error : function() {
				console.log("실패");
			}
	});
});

//리스트에서 부서명 클릭시 변경전 부서명 input 박스에 값이 들어가는 스크립트
$(document).ready(function(){
	$('.groupListTr').on('click', function(){
		var uri = $(this);
		var check = uri.children('#departmentYesNO').text();
		console.log(check);
		if(check == 'Y'){
			var departmentCode = $(this).children('#departmentCode').text();
			var departmentNameBe = $(this).children('#departmentNameBe').text();
			$('#departmentNameBeUp').val(departmentNameBe);
		}else{
			alert('사용하지 않는 부서는 수정 할 수 없습니다.');
		}
	});
});

// 부서 등록/수정/삭제 클릭시 실행되는 이벤트
$(function(){
	
	$('.inputDeBtn').click(function(){
		if(confirm('등록하시겠습니까?')){
			$('#formInput').attr('action', 'teamNameInsert').submit();	
		}
	});	
	
	$('#updateBtn').click(function(){
		if(confirm('수정하시겠습니까?')){
			$('#formUpdate').attr('action', 'teamNameUpdate').submit();	
		}
	});	
	
	$('.deleteDeBtn').children('input').on('click', function(){
		
		var uri = $(this).parents('.groupListTr');
		var textValue = uri.children('#departmentCode').text();
		uri.children('#departmentCode').append('<input type="hidden" id="decode" name="departmentCode">');
		$('#decode').val(textValue);
		
		if(confirm('삭제하시겠습니까?')){
			$('#deleteForm').attr('action', 'teamNameDelete').submit();
		 }
	});
});

// 직급등록 공란체크
$(function(){
	$('#inputPoBtn').click(function(){
		var nameCheck = $('input[name=positionNameBe]');
		var levelCheck = $('input[name=positionLevel]');
		var sauCheck = $('input[name=positionSau]');
		
		if(nameCheck.val() == ""){
			alert('직급명을 입력해주세요.');
			nameCheck.focus();
			return false;
		}
		if(levelCheck.val() == ""){
			alert('레벨을 입력해주세요.');
			levelCheck.focus();
			return false;
		}
		if(sauCheck.val() == ""){
			alert('사유를 입력해주세요.');
			sauCheck.focus();
			return false;
		}
	});
});

// 직급수정 공란체크
$(function(){
	$('#updatePoBtn').click(function(){
		var nameBeCheck = $('input[id=positionNameBeUp]');
		var nameAfCheck = $('input[id=positionNameAfUp]');
		var levelCheck = $('input[id=positionLevelUp]');
		var sauCheck = $('input[id=positionSauUp]');
		
		if(nameBeCheck.val() == ""){
			alert('변경전 직급명을 입력해주세요.');
			nameBeCheck.focus();
			return false;
		}
		if(nameAfCheck.val() == ""){
			alert('변경후 직급명을 입력해주세요.');
			nameAfCheck.focus();
			return false;
		}
		if(levelCheck.val() == ""){
			alert('레벨을 입력해주세요.');
			levelCheck.focus();
			return false;
		}
		if(sauCheck.val() == ""){
			alert('사유를 입력해주세요.');
			sauCheck.focus();
			return false;
		}
	});
});

//직급 등록 유효성 검사(1 = 중복 / 0 != 중복)
$("#positionNameBeIn").blur(function() {
	
	var name = $('#positionNameBeIn').val();
	console.log(name + " <- 직급명이에요.");
	
		$.ajax({
			type 		: 'POST',
		data 		: {'name': name},
		url 		: "poNameCheck",
		datatype	: 'json',
		
			success : function(data) {
			console.log("1 = 중복o / 0 = 중복x : "+ data);							
			
			if (data == 1) {
			// 1 : 아이디가 중복되는 문구
			$('#name_checkBe').text('사용중인 직급명입니다.');
			$('#name_checkBe').css('color', 'red');
			$('#reg_submit').attr('disabled', true);
				} 
			// 0: 아이디가 중복되지 않을때 문구
			else {
			$('#name_checkBe').text('사용가능한 직급명입니다.');
			$('#name_checkBe').css('color', 'green')	          					
				}
			}, error : function() {
				console.log("실패");
			}
	});
});

//직급 수정 유효성 검사(1 = 중복 / 0 != 중복)
$("#positionNameAfUp").blur(function() {
	
	var name = $('#positionNameAfUp').val();
	console.log(name + " <- 직급명이에요.");
	
		$.ajax({
			type 		: 'POST',
		data 		: {'name': name},
		url 		: "poNameCheck",
		datatype	: 'json',
		
			success : function(data) {
			console.log("1 = 중복o / 0 = 중복x : "+ data);							
			
			if (data == 1) {
			// 1 : 아이디가 중복되는 문구	
			$('#name_checkAf').text('사용중인 직급명입니다.');
			$('#name_checkAf').css('color', 'red');
			$('#reg_submit').attr('disabled', true);
				} 
			// 0: 아이디가 중복되지 않을때 문구
			else {        					
			$('#name_checkAf').text('변경가능한 직급명입니다.');
			$('#name_checkAf').css('color', 'green')	          					
				}
			}, error : function() {
				console.log("실패");
			}
	});
});

//리스트에서 직급명 클릭시 변경전 직급명 input 박스에 값이 들어가는 스크립트
$(document).ready(function(){
	$('.positionListTr').on('click', function(){
		var uri = $(this);
		var check = uri.children('#positionYesNO').text();
		console.log(check);
		if(check == 'Y'){
			var positionNameBe = $(this).children('#positionNameBe').text();
			$('#positionNameBeUp').val(positionNameBe);
		}else{
			alert('사용하지 않는 직급은 수정 할 수 없습니다.');
		}
	});
});

//직급 등록/수정/삭제 클릭시 실행되는 이벤트
$(function(){
	
	$('.insertPoBtn').click(function(){
		if(confirm('등록하시겠습니까?')){
			$('#formInput').attr('action', 'positionInsert').submit();	
		}
	});	
	
	$('#updatePoBtn').click(function(){
		if(confirm('수정하시겠습니까?')){
			$('#formUpdate').attr('action', 'positionUpdate').submit();	
		}
	});	
	
	$('.deletePoBtn').children('input').on('click', function(){
		var uri = $(this).parents('.positionListTr');
		var textValue = uri.children('#positionCode').text();
		uri.children('#positionCode').append('<input type="hidden" id="decode" name="positionCode">');
		$('#decode').val(textValue);
		
		if(confirm('삭제하시겠습니까?')){
			$('#deleteForm').attr('action', 'positionListDelete').submit();
		 }
	});
});