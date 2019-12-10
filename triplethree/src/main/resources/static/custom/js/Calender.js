/**
 * 캘린더 이벤트
 */
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
        right : 'dayGridMonth'
      },
      
      /*구글캘린더 추가 시작*/
      googleCalendarApiKey: "AIzaSyAroDyz92eDMv-R9QsGLfcuA40KJF46764",                             
      events:{
        googleCalendarId:"446519400056-chkp1jpu6t4l2k47red8neetulk7s2sk.apps.googleusercontent.com"
      },
      /*구글캘린더 추가 끝*/
      
      editable  : true,
      navLinks  : false,
      eventLimet: false,
      droppable : true, // this allows things to be dropped onto the calendar !!!
      //Random default events
      events    : function(dateObject, callback){
    	  
    	  var getStartStr = dateObject.startStr.substring(0, 10);
    	  var getEndStr = dateObject.endStr.substring(0, 10);
    	      	  
    	  //console.log(getStartStr, getEndStr)
    	  
    	  $.ajax({
    		  async : true,
    		  type : 'POST',
    		  data : {'startDate' : getStartStr, 'endDate' : getEndStr},
    		  url : "companySchedule",
    		  datetype : "json",
    		  success : function(data){
    			  if(data != undefined && data.length > 0){
    				  //console.log(data)
    				  var dateArray = [];
    				  for(var i=0; i < data.length; i++){
    					  var dataObj = data[i];
    					  var code = dataObj.code;    
    					  var sortation = dataObj.sortation;
    					  //console.log(sortation);
    					  var start = dataObj.start;
    					  var end = moment(dataObj.end).add(1,'day').format('YYYY-MM-DD');
    					  var title = (sortation +'\n'+ dataObj.title);
    					  var color = dataObj.color;
    					  var backgroundColor = dataObj.backgroundColor;
    					  //console.log(code);
    					  var dateObject = {
    						  	  id				: code,
    							  title 			: title,
    							  start 			: new Date(start),
    							  end 				: new Date(end),
		    					  allDay         	: true,
		    					  editable			: false,
		    					  className			: 'calendarDayClickEv',
		    					  textColor			: color,
		    			          backgroundColor	: backgroundColor
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
    	  
    	    // 일정 클릭시 수정&삭제 이벤트 실행
       		  //$('#myModal2').modal('show');
       		  
       		  // 일정 클릭시 수정가능한 일정인지 확인
       		/*  $.ajax({
        		  async : true,
        		  type : 'POST',
        		  data : {"sid" : sid},
        		  url : "checkSID",
        		  datetype : "json",
        		  success : function(data){
        			  console.log(data);
        		  },
        		  error : function(error){ 
        		  }
       		  });*/
       		  
       		  // 일정 클릭시 db조회하여 일치하는 값을 셋팅해준다.
        	  $.ajax({
        		  async : true,
        		  type : 'POST',
        		  data : {code : code, sid : sid},
        		  url : "selectUpdate",
        		  datetype : "json",
        		  success : function(data){
        			  console.log(sid);
        			  console.log(data.sid);
        			  if(sid == data.sid){
        				$('#myModal2').modal('show');
        			  // input 창에 data에서 조회한 값을 처리해준다.
        			  $('input[name=title]').attr('value', data.title);
        			  $('input[name=start]').attr('value', data.start);
        			  $('input[name=end]').attr('value', data.end);
        			  $('input[name=code]').attr('value', data.code);
        			  }else{
        				  alert('수정할수 없습니다.')
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