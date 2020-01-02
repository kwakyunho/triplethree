/** 트리구조 결재 클릭시 active 클래스 요소 추가
 * 2019-12-31 최초 작성 곽윤호
 *
 */

(function($){
	$('.tree').on('click', '.treeSelect', function(){
		$(this).toggleClass("active");
	})
	
	$(document).ready(function(){
		
		$.ajax({
			async: true,
			type : 'POST',
			data : sendData,
			url : sendData.ajaxUrl,
			dataType : sendData.ajaxDataType,
			processData : true,
			success : function(data) {

				data.forEach(function(e, i) {
					var codeNm = e.codeNm;
					var codeId = e.codeId;
					var parentId = e.parentId;
					var codeLvl = e.codeLvl;
					var li = '<li id="'+ codeId +'" lvl="' + codeLvl + '"><a class="file code">'+ codeNm +'</a></li>';
				
					// 1레벨은 그냥 추가
					// 다음 레벨부터는 상위 li의 클래스를 폴더로 바꾸고 자기 자신을 추가
					if(codeLvl == 1) {
						lvl0.append(li);
					} else {
						var parentLi = $("li[id='"+ parentId +"']");
						parentLi.find("a").removeClass("file");
						parentLi.find("a").addClass("folder");
						var bUl = parentLi.find("ul");
				
						// 하위 그룹이 없으면 li로 추가
						// 하위 그룹이 있으면 ul로 추가
						if(bUl.length == 0) {
							li = "<ul>" + li + "</ul>";
							parentLi.append(li);
						} else {
							bUl.append(li);
						}
					}
				});
			},
			error : function(error) {
				console.log('error');
			}
		});
	})
}(jQuery));