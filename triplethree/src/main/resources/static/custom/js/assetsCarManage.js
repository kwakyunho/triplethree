/**
 * 차량 예약 관리 스크립트
 */

//달력 스크립트 시작 
$(function () {

    /* initialize the external events
     -----------------------------------------------------------------*/
    function ini_events(ele) {
      ele.each(function () {

        // create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
        // it doesn't need to have a start or end
        var eventObject = {
          title: $.trim($(this).text()) // use the element's text as the event title
        }

        // store the Event Object in the DOM element so we can get to it later
        $(this).data('eventObject', eventObject)

        // make the event draggable using jQuery UI
        $(this).draggable({
          zIndex        : 1070,
          revert        : true, // will cause the event to go back to its
          revertDuration: 0  //  original position after the drag
        })

      })
    }

    ini_events($('#external-events div.external-event'))

    /* initialize the calendar
     -----------------------------------------------------------------*/
  
    var Calendar = FullCalendar.Calendar;
    var Draggable = FullCalendarInteraction.Draggable;

    var containerEl = document.getElementById('external-events');
    var checkbox = document.getElementById('drop-remove');
    var calendarEl = document.getElementById('calendar');

    // initialize the external events
    // -----------------------------------------------------------------

    new Draggable(containerEl, {
      itemSelector: '.external-event',
      eventData: function(eventEl) {
        //console.log(eventEl);
        return {
          title: eventEl.innerText,
          backgroundColor: window.getComputedStyle( eventEl ,null).getPropertyValue('background-color'),
          borderColor: window.getComputedStyle( eventEl ,null).getPropertyValue('background-color'),
          textColor: window.getComputedStyle( eventEl ,null).getPropertyValue('color'),
        };
      }
    });

    var calendar = new Calendar(calendarEl, {
    locale: 'ko',
      plugins: [ 'bootstrap', 'interaction', 'dayGrid', 'timeGrid' ],
      header    : {
        left  : 'prev,next today',
        center: 'title',
        //right : 'dayGridMonth'
        right : ''
      },
      
      editable  : true,
      navLinks  : false,
      eventLimet: false,
      droppable : true, // this allows things to be dropped onto the calendar !!!
      //Random default events
      events    : function(dateObject, callback){
    	  
    	  var getStartStr = dateObject.startStr.substring(0, 10);
    	  var getEndStr = dateObject.endStr.substring(0, 10);
    	      	  
    	  //console.log(getStartStr, getEndStr)
    	  
    	  // 캘린더에 일정 뿌려주기
    	  $.ajax({
    		  async : true,
    		  type : 'POST',
    		  data : {'startDate' : getStartStr, 'endDate' : getEndStr},
    		  url : "assetsManageCaSelect",
    		  datetype : "json",
    		  success : function(data){
    			  if(data != undefined && data.length > 0){
    				  //console.log(data)
    				  var dateArray = [];
    				  for(var i=0; i < data.length; i++){
    					  var dataObj = data[i];
    					  var code = dataObj.code;    
    					  //var sortation = dataObj.sortation;
    					  //console.log(sortation);
    					  var start = dataObj.reStart;
    					  var end = moment(dataObj.reEnd);
    					  //var end = moment(dataObj.reEnd).add(1,'day').format('YYYY-MM-DD');
    					  var name = (dataObj.deName+'\-'+dataObj.empName+'\n예약차량:'+dataObj.veName+'\n'+'예약시작:'+moment(start).format('A.HH시mm분')+'\n예약끝:'+moment(end).format('A.HH시mm분'));
    					  var color = 'white';
    					  var backgroundColor = 'black';
    					  //console.log(code);
    					  //console.log(start);
    					  //console.log(end);
    					  //console.log(name);
    					  //console.log(color);
    					  //console.log(backgroundColor);
    					  var dateObject = {
    						  	  id				: code
    							  ,title 			: name
    							  ,start 			: new Date(start)
    							  ,end 				: new Date(end)
		    					  ,allDay         	: true
		    					  ,editable			: false
		    					  ,className		: 'calendarDayClickEv'
		    					  ,textColor		: color
		    			          ,backgroundColor	: backgroundColor
    					  }; 
    					  dateArray.push(dateObject);
    				  }    
    				  callback(dateArray);	
    			  }		  
    		  },
    		  error : function(error){
    			  
    		  }
    		  
    	  });
    	  
    	  
    	  
      },
     drop      : function(info) {
        // is the "remove after drop" checkbox checked?
        if (checkbox.checked) {
          // if so, remove the element from the "Draggable Events" list
          info.draggedEl.parentNode.removeChild(info.draggedEl);
        }
      },
            
      // 일정 클릭시 발생하는 이벤트
      eventClick: function(info) {
    	  // id(code) 값이 있다면 ajax로 값을 보여주면서 modal을 띄워주고
    	  // id(code) 값이 없다면 ajax로 값을 입력해주도로고 modal을 띄워준다.
    	  var code = info.event.id;
    	    //console.log(code)	  
       		  
       		  // 일정 클릭시 db조회하여 일치하는 값을 셋팅해준다.
        	  $.ajax({
        		  async : true,
        		  type : 'POST',
        		  data : {code : code, sid : sid},
        		  url : "selectCarUpdate",
        		  datetype : "json",
        		  success : function(data){
        			  //console.log(code);
        			  //console.log(sid);
        			  //console.log(data.empCode);
        			  //console.log(data.reStart);
        			  //console.log(data.reEnd);
        			  if(sid == data.empCode){
        				$('#myModal2').modal('show');
        			  // input 창에 data에서 조회한 값을 처리해준다.
        			  $('input[name=reStart]').attr('value', moment(data.reStart).format("HH-mm"));
        			  $('input[name=reEnd]').attr('value', data.reEnd);
        			  $('input[name=code]').attr('value', data.code)
        			  }else{
        				  alert('본인 예약만 수정 할 수 있습니다.')
        			  }
        			  
        		  },
        		  error : function(error){ 
        		  }
        	  });
        },
      
        // 일정 빈공간 클릭시 발생하는 이벤트
      	dateClick: function(info) {
    		// 캘린더 날짜부분을 클릭시 모달이벤트 실행
			$('#myModal1').modal('show');
			$('.inputValue').val('');
				
    	  },
    });

    calendar.render();
    // $('#calendar').fullCalendar()

    /* ADDING EVENTS */
    var currColor = '#3c8dbc' //Red by default
    //Color chooser button
    var colorChooser = $('#color-chooser-btn')
    $('#color-chooser > li > a').click(function (e) {
      e.preventDefault()
      //Save color
      currColor = $(this).css('color')
      //Add color effect to button
      $('#add-new-event').css({
        'background-color': currColor,
        'border-color'    : currColor
      })
    })
    $('#add-new-event').click(function (e) {
      e.preventDefault()
      //Get value and make sure it is not null
      var val = $('#new-event').val()
      if (val.length == 0) {
        return
      }

      //Create events
      var event = $('<div />')
      event.css({
        'background-color': currColor,
        'border-color'    : currColor,
        'color'           : '#fff'
      }).addClass('external-event')
      event.html(val)
      $('#external-events').prepend(event)

      //Add draggable funtionality
      ini_events(event)

      //Remove event from text input
      $('#new-event').val('')
    })
  })
//달력 스크립트 끝 
  
// 등록,수정,삭제 버튼 이벤트
$(function () {
	  
	$('#insertBtn').click(function(){
		  if(confirm('예약 하시겠습니까?')){
		  $('#formInsert').attr('action', 'assetsManageCaInsert').submit();
		  }
	});
	  
	$('#updateBtn').click(function(){
		  if(confirm('예약 내용을 수정하시겠습니까?')){
		  $('#formUpdateId').attr('action', 'assetsManageCaUpdate').submit();
		  }
	});
	  
	  $('#deleteBtn').click(function(){
		  if(confirm('예약을 취소하시겠습니까?')){
		  $('#formId').attr('action', 'assetsManageCaDelete').submit();
		  }
	});	 
});
 
// 시설,차량 셀렉트 박스 클릭에 따른 하위 내용 뿌려주기 위한 스크립트
$(function(){
	$('#veCode').change(function(){
		console.log('값이 변경 되었어요.');
		// option의 경우 select박스에 속한것으로 children으로 해서 value를 뽑지 않는다.
		var check = $('#veCode').val();
		console.log(check);
		
	 });
});
