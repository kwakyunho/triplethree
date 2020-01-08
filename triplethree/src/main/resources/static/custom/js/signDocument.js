/**
 * 전자결재 기안문서함/결재문서함 관련 스크립트
 */

// 기안문서함 상단 메뉴 클릭시 실행되는 이벤트
$(function(){
	$('.ajaxVal').on('click', function(){
		var valCheck = $(this).children('a').prop('id');
		console.log('기안문서함이에요.'+valCheck);
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
		
		//$('#select'+valCheck+'Tr').init();
		// 기안문서의 상태를 구분하여 상태에 맞는 문서를 가져옴
		$.ajax({
			type 		: 'POST',
			data 		: {'valCheck': valCheck},
			url 		: "/signDocument/selectDraftDocument",
			datatype	: 'json',
			
			success : function(data) {
				//$('#select'+valCheck+'Tr').empty();
				//$('#select'+valCheck+'Tr').init();
				str = '<tr>'
					if(data.length != 0){
						// 기안문서함 상단의 메뉴 클릭시 값에 일치하는 리스트를 뿌려주는 작업
						// 결재 완료 문서에 대한 스크립트
						if(valCheck == 'End'){
							$.each(data, function(i){
								str += '<td>'+[i+1]+'</td>'
								str += '<td>'+data[i].writerDay+'</td>'
								str += '<td>'+data[i].signEndDay+'</td>'
								str	+= '<td>'+data[i].docTitle+'</td>'
								str += '<td>'+data[i].docName+'</td>'
								str += '<td>'+'첨부파일 자리에요'+'</td>'
								str += '<td>'+data[i].deName+'-'+data[i].poName+'-'+data[i].empName+'</td>'
								str += '<td>'+data[i].docFormCode+'</td>'
								str += '<td><span class="btn bg-gradient-secondary" style=" font-size: small;">완료</span></td>'						
									str += '</tr>'
							});
							$('#selectEndTr').html('');
							$('#selectEndTr').append(str);
							//$('.dateTablePagingEnd').DataTable();
							$('#dateTablePaging'+valCheck+'').DataTable();
							
							// 결재 진행중인 문서에 대한 스크립트
						}else if(valCheck == 'Starting'){
							$.each(data, function(i){
								str += '<td>'+[i+1]+'</td>'
								str += '<td>'+data[i].writerDay+'</td>'
								str	+= '<td>'+data[i].docTitle+'</td>'
								str += '<td>'+data[i].docName+'</td>'
								str += '<td>'+'첨부파일 자리에요'+'</td>'
								str += '<td>'+data[i].deName+'-'+data[i].poName+'-'+data[i].empName+'</td>'
								str += '<td>'+data[i].docFormCode+'</td>'
								str += '<td><span class="btn bg-gradient-success" style=" font-size: small;">진행중</span></td>';							
								str += '</tr>'
							});
							$('#selectStartingTr').html('');
							$('#selectStartingTr').append(str);
							//$('.dateTablePagingStarting').DataTable();
							$('#dateTablePaging'+valCheck+'').DataTable();
							
							// 반려 문서에 대한 스크립트
						}else if(valCheck == 'Return'){
							$.each(data, function(i){
								str += '<td>'+[i+1]+'</td>'
								str += '<td>'+data[i].writerDay+'</td>'
								str += '<td>'+data[i].reDocDate+'</td>'
								str	+= '<td>'+data[i].docTitle+'</td>'
								str += '<td>'+data[i].docName+'</td>'
								str += '<td>'+'첨부파일 자리에요'+'</td>'
								str += '<td>'+data[i].comments+'</td>'
								str += '<td>'+data[i].deName+'-'+data[i].poName+'-'+data[i].empName+'</td>'
								str += '<td>'+data[i].docFormCode+'</td>'
								str += '<td><span class="btn bg-gradient-danger" style=" font-size: small;">반려</span</td>'							
									str += '</tr>'
							});
							$('#selectReturnTr').html('');
							$('#selectReturnTr').append(str);
							//$('.dateTablePagingReturn').DataTable();
							$('#dateTablePaging'+valCheck+'').DataTable();
						}
					}else{
						str += '<td colspan="10"><span>해당된 문서가 없습니다.</span></td>'							
						str += '</tr>'
						$('#select'+valCheck+'Tr').html('');
						$('#select'+valCheck+'Tr').append(str);
					}
				}, error : function() {
				console.log("실패");
			}
		});
	});
});

// 결재문서함 상단메뉴 클릭시 실행되는 이벤트

	$('.ajaxVal2').on('click', function(){
		var valCheck = $(this).children('a').prop('id');
		console.log('결재 문서함이에요.'+valCheck);
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

		// 결재문서의 상태를 구분하여 상태에 맞는 문서를 가져옴
		$.ajax({
			type 		: 'POST',
			data 		: {'valCheck': valCheck},
			url 		: "/signDocument/signStandByDocument",
			datatype	: 'json',
			
			success : function(data) {
				//console.log(data.length === 0);
				str = '<tr>'
					
					if(data.length != 0){
						// 기안문서함 상단의 메뉴 클릭시 값에 일치하는 리스트를 뿌려주는 작업					
						// 결재 완료 문서에 대한 스크립트
						if(valCheck =='End'){
							$.each(data, function(i){
								str += '<td>'+[i+1]+'</td>'
								str += '<td>'+data[i].writerDay+'</td>'
								str += '<td>'+data[i].signEndDay+'</td>'
								str	+= '<td>'+data[i].docTitle+'</td>'
								str += '<td>'+data[i].docName+'</td>'
								str += '<td>'+'첨부파일 자리에요'+'</td>'
								str += '<td>'+data[i].deName+'-'+data[i].poName+'-'+data[i].empName+'</td>'
								str += '<td>'+data[i].docFormCode+'</td>'
								str += '<td><span class="btn bg-gradient-secondary" style=" font-size: small;">완료</span></td>'						
								str += '</tr>'
							});
							$('#selectEndTr').html('');
							$('#selectEndTr').append(str);
							$('#dateTablePagingEnd').DataTable();
								
						// 결재 진행중인 문서에 대한 스크립트
						}else if(valCheck =='Starting'){
							$.each(data, function(i){
								str += '<td>'+[i+1]+'</td>'
								str += '<td>'+data[i].writerDay+'</td>'
								str	+= '<td>'+data[i].docTitle+'</td>'
								str += '<td>'+data[i].docName+'</td>'
								str += '<td>'+'첨부파일 자리에요'+'</td>'
								str += '<td>'+data[i].deName+'-'+data[i].poName+'-'+data[i].empName+'</td>'
								str += '<td>'+data[i].docFormCode+'</td>'
								str += '<td><span class="btn bg-gradient-success" style=" font-size: small;">진행중</span></td>';							
								str += '</tr>'
							});
							$('#selectStartingTr').html('');
							$('#selectStartingTr').append(str);
							$('#dateTablePagingStarting').DataTable();
							
						// 반려 문서에 대한 스크립트
						}else if(valCheck =='Return'){
							
							$.each(data, function(i){
								str += '<td>'+[i+1]+'</td>'
								str += '<td>'+data[i].writerDay+'</td>'
								str += '<td>'+data[i].reDocDate+'</td>'
								str	+= '<td>'+data[i].docTitle+'</td>'
								str += '<td>'+data[i].docName+'</td>'
								str += '<td>'+'첨부파일 자리에요'+'</td>'
								str += '<td>'+data[i].comments+'</td>'
								str += '<td>'+data[i].deName+'-'+data[i].poName+'-'+data[i].empName+'</td>'
								str += '<td>'+data[i].docFormCode+'</td>'
								str += '<td><span class="btn bg-gradient-danger" style=" font-size: small;">반려</span></td>'							
								str += '</tr>'
							});
							$('#selectReturnTr').html('');
							$('#selectReturnTr').append(str);
							$('#dateTablePagingReturn').DataTable();
						}
					}else {
						//console.log(valCheck);
						str += '<td colspan="10"><span>해당된 문서가 없습니다.</span></td>'							
						str += '</tr>'
						$('#select'+valCheck+'Tr').html('');
						$('#select'+valCheck+'Tr').append(str);
					}
				}, error : function() {
				console.log("실패");
			}
		});
	});
//});