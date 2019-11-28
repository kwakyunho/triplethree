/**
 * sidebar 클릭에 따라 active 유지하기
 */
$(document).ready(function(){
	$(function(){
		var sBtn = $(".nav-treeview");
		sBtn.find("a").click(function(){
			sBtn.find("a").removeClass("active");
			$(this).addClass("active");
		});
	});
});