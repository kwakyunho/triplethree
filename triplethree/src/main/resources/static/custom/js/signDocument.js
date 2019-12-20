/**
 * 전자결재 기안문서함 관련 스크립트
 */

$(function(){
	$('.ajaxVal').one('click', function(){
		var valCheck = $(this).children('a').prop('id');
		//console.log(valCheck);
		var code = null; // 작성된 결재문서관리코드
		var writerDay = null; // 작성일자
		var signEndDay = null; // 결재완료일
		var docTitle = null; // 문서명
		var docName = null; // 문서제목
		var deName = null; // 부서명
		var poName = null; // 직급명
		var empName = null; // 사원명
		var docFormCode = null; // 문서양식관리코드
		var signState = null; // 전자결재상태
		var str = null; // 테이블로 뿌리기 위해 필요한 변수
		
		// 기안문서의 상태를 구분하여 상태에 맞는 문서를 가져옴
		$.ajax({
			type 		: 'POST',
			data 		: {'valCheck': valCheck},
			url 		: "/signDocument/selectDraftDocument",
			datatype	: 'json',
			
			success : function(data) {
				str = '<tr>'
					
					// 기안문서함 상단의 메뉴 클릭시 값에 일치하는 리스트를 뿌려주는 작업
					if(valCheck =='All'){
						$.each(data, function(i){
							str += '<td>'+[i+1]+'</td>'
							str += '<td>'+data[i].writerDay+'</td>'
										if(data[i].signEndDay == null){
											str += '<td></td>';
										}else{
											str += '<td>'+data[i].signEndDay+'</td>';
										};
							str	+= '<td>'+data[i].docTitle+'</td>'
							str += '<td>'+data[i].docName+'</td>'
							str += '<td>'+'첨부파일 자리에요'+'</td>'
							str += '<td>'+data[i].deName+'-'+data[i].poName+'-'+data[i].empName+'</td>'
							str += '<td>'+data[i].docFormCode+'</td>'
										if(data[i].signState == 'N'){
											str += '<td><span class="btn bg-gradient-success">진행중</span></td>';
										}else if(data[i].signState == 'Y'){
											str += '<td><span class="btn bg-gradient-secondary">완료</span></td>';
										}else{
											str += '<td><span class="btn bg-gradient-danger">반려</span</td>';
										}								
							str += '</tr>'
						});
					$('#selectAllTr').append(str);
					$('.dateTablePagingAll').DataTable();
					
					}else if(valCheck =='End'){
						$.each(data, function(i){
							str += '<td>'+[i+1]+'</td>'
							str += '<td>'+data[i].writerDay+'</td>'
										if(data[i].signEndDay == null){
											str += '<td></td>';
										}else{
											str += '<td>'+data[i].signEndDay+'</td>';
										};
							str	+= '<td>'+data[i].docTitle+'</td>'
							str += '<td>'+data[i].docName+'</td>'
							str += '<td>'+'첨부파일 자리에요'+'</td>'
							str += '<td>'+data[i].deName+'-'+data[i].poName+'-'+data[i].empName+'</td>'
							str += '<td>'+data[i].docFormCode+'</td>'
										if(data[i].signState == 'N'){
											str += '<td><span class="btn bg-gradient-success">진행중</span></td>';
										}else if(data[i].signState == 'Y'){
											str += '<td><span class="btn bg-gradient-secondary">완료</span></td>';
										}else{
											str += '<td><span class="btn bg-gradient-danger">반려</span</td>';
										}								
							str += '</tr>'
						});
					$('#selectEndTr').append(str);
					$('.dateTablePagingEnd').DataTable();
					
					}else if(valCheck =='Starting'){
						$.each(data, function(i){
							str += '<td>'+[i+1]+'</td>'
							str += '<td>'+data[i].writerDay+'</td>'
										if(data[i].signEndDay == null){
											str += '<td></td>';
										}else{
											str += '<td>'+data[i].signEndDay+'</td>';
										};
							str	+= '<td>'+data[i].docTitle+'</td>'
							str += '<td>'+data[i].docName+'</td>'
							str += '<td>'+'첨부파일 자리에요'+'</td>'
							str += '<td>'+data[i].deName+'-'+data[i].poName+'-'+data[i].empName+'</td>'
							str += '<td>'+data[i].docFormCode+'</td>'
										if(data[i].signState == 'N'){
											str += '<td><span class="btn bg-gradient-success">진행중</span></td>';
										}else if(data[i].signState == 'Y'){
											str += '<td><span class="btn bg-gradient-secondary">완료</span></td>';
										}else{
											str += '<td><span class="btn bg-gradient-danger">반려</span</td>';
										}								
							str += '</tr>'
						});
						$('#selectStartingTr').append(str);
						$('.dateTablePagingStarting').DataTable();
					}
					//$('.dateTablePaging').DataTable();
				}, error : function() {
				console.log("실패");
			}
		});
	});
});