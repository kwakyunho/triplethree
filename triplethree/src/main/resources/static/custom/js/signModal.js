/** 트리구조 결재 클릭시 active 클래스 요소 추가
 * 2019-12-31 최초 작성 곽윤호
 *
 */

(function($){
	$('.tree').on('click', '.treeSelect', function(){
		$(this).toggleClass("active");
	})
}(jQuery));