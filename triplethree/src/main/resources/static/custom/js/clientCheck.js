/**
 * 거래처 스크립트 모아놓은 것 
 */
// 모든곳의 이전 버튼 뒤로가기 

$(function(){
		$('#backBtn').on('click',function(){
		history.go(-1); 
		 });
	});

//거래처 상세보기에서 수정 삭제 가는 부분
$(function(){
	$('#updateBtn').on('click',function(){
		alert('수정화면으로 이동합니다');
		$('.clientDetailForm').attr('action','/goClientInsert');
		$('.clientDetailForm').attr('method','POST');
		$('.clientDetailForm').submit();
		
	});
	$('#deleteBtn').on('click',function(){
		$('.clientDetailForm').attr('action','/goClientInsert');
		$('.clientDetailForm').attr('method','POST');
		$('.clientDetailForm').submit();	
	});
	
});

// 거래처 등록&수정 시 공란 체크 스크립트
$(function(){
	$('#insertBtn').click(function(){
		var accNameCheck = $('input[name=accName]');
		var accCeoNameCheck = $('input[name=accCeoName]');
		var accPhoneCheck = $('input[name=accPhone]');
		var repreNumberCheck = $('input[name=repreNumber]');
		var accEmailCheck = $('input[name=accEmail]');
		var accFaxCheck = $('input[name=accFax]');
		var accPostcodeCheck = $('input[name=accPostcode]');
		var accBlnCheck = $('input[name=accBln]');
		var accAddrCheck = $('input[name=accAddr]');
		var accDetailAddrCheck = $('input[name=accDetailAddr]');
		var accExtraAddrCheck = $('input[name=accExtraAddr]');
		
		if(accNameCheck.val() == ""){
			alert('회사이름을 입력해주세요.');
			accNameCheck.focus();
			return false;
		}
		if(accCeoNameCheck.val() == ""){
			alert('대표자명을 입력해주세요');
			accCeoNameCheck.focus();
			return false;
		}
		if(accPhoneCheck.val() == ""){
			alert('거래처 전화번호를 입력해주세요');
			accPhoneCheck.focus();
			return false;
		}
		if(repreNumberCheck.val() == ""){
			alert('대표자 번호를 입력해주세요.');
			repreNumberCheck.focus();
			return false;
		}
		if(accEmailCheck.val() == ""){
			alert('이메일을 입력해주세요');
			accEmailCheck.focus();
			return false;
		}
		if(accFaxCheck.val() == ""){
			alert('팩스번호를 입력해주세요.');
			accFaxCheck.focus();
			return false;
		}
		if(accBlnCheck.val() == ""){
			alert('사업자번호를 입력해주세요.');
			accBlnCheck.focus();
			return false;
		}
		if(accPostcodeCheck.val() == ""){
			alert('우편번호를 입력해주세요.');
			accPostcodeCheck.focus();
			return false;
		}
		if(accAddrCheck.val() == ""){
			alert('주소를 입력해주세요.');
			accAddrCheck.focus();
			return false;
		}
		if(accDetailAddrCheck.val() == ""){
			alert('상세주소를 입력해주세요.');
			accDetailAddrCheck.focus();
			return false;
		}
		if(accExtraAddr.val() == ""){
			alert('참고주소를 입력해주세요.');
			accExtraAddr.focus();
			return false;
		}
		
	});

});


