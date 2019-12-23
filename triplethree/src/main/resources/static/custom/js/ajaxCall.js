/** ajax 공통 모듈
 * 2019-12-18 최초 작성 곽윤호
 *
 * *** 호출시 필수 입력 조건
 * var sendData = {};
 * sendData.ajaxType = 'POST';	// 전송타입
 * sendData.ajaxUrl = '/ajax';	// 호출 주소
 * sendData.ajaxDataType = 'json';	// 리턴 타입
 */

(function($){
	$.fn.ajaxCall = function(sendData, fn){
		
		$.ajax({
			async: true,
			type : sendData.ajaxType,
			data : sendData,
			url : sendData.ajaxUrl,
			dataType : sendData.ajaxDataType,
			success : function(result) {
				fn(result);
			},
			error : function(error) {
				//alert("error : " + error);
			fn('error');
			}
		});
	}
}(jQuery));