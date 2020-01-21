/**
 * sidebar 클릭에 따라 active 유지하기
 */
$(document).ready(function(){
	var pathName = $(location).attr('pathname');
	var pathNameUri = $(document).find('a[href="' + pathName + '"]');
	pathNameUri.parents('li.has-treeview').addClass('menu-open');
	pathNameUri.addClass('active');
	
	$(function(){
		var sBtn = $('.nav-treeview');
		
		sBtn.find('a').click(function(){
			sBtn.find('a').removeClass('active');
			$(this).addClass('active');
		});
	});
});