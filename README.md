## :pushpin: DESK APP :pushpin:
협업을 위한 그룹웨어

2020.12 ~ 2021.01

## :mag: Project

#### 개요
사내에서 사용하는 업무메신저를 확장하여 각각의 프로젝트에 인원을 추가할수 있고 진행상황과 서로의 스케줄을 공유하기 위해 만들었습니다. 

#### 주요기능
- **프로젝트 협업기능**
- 근태관리
- 인사관리
- 전자결제
- 메신저


##  👀 기술스택
![캡처](https://user-images.githubusercontent.com/69295153/106429174-6fa2eb80-64ad-11eb-9810-c02000325b36.PNG)

#### 그 외 API

| 라이브러리                      | 버전       |
| ------------------------------ | ---------- |
| jstl                           | 1.2        |
| JSON-simple                    | **^16.11** |
| JdataPicker                    | **^5.1**   |
| Spring WebSocket               | **3.3**    |
| Lombok Maven Plugin            | **^4.4**   |
| Mybatis Spring                 | **3.6**    |
| ojdbc6                         | **4.1.5**  |
| Apache commons Fileupload      | **4.1.5**  |
| Naver Smart editer             | 2.2        |

## 👩‍💻 Member


#### 정현봉
- 프로젝트 협업기능(프로젝트 추가, 삭제, 수정, 일정차트, 진행도, 댓글, 대댓글, 파일 업.다운로드)
- 회원추가 기능
- 주소록 

## 🔧설정 파일

#### header.js
 ```jsx
<!-- Global site tag (gtag.js) - Google Analytics -->
<script async
	src="https://www.googletagmanager.com/gtag/js?id=UA-119386393-1"></script>
<script>
	window.dataLayer = window.dataLayer || [];
	function gtag() {
		dataLayer.push(arguments);
	}
	gtag('js', new Date());
	gtag('config', 'UA-119386393-1');
</script>
```
gtag로 화면 전환시 로딩 페이지를 보여주었습니다. 

#### project.jsp script
![projectList](https://user-images.githubusercontent.com/59170160/110252588-7ef3e800-7fc9-11eb-999f-d3efad313bf9.png)
![prj-add](https://user-images.githubusercontent.com/59170160/110252615-9f23a700-7fc9-11eb-9221-169664e91385.png)
 ```jsx
/* 사원추가 */
 $(document).ready(function() {
	 $("#prj-add-member").click(function() {
			$.ajax({
			    url : "${pageContext.request.contextPath}/memeberList",
			    type : "POST",
			    contentType : "application/json; charset=utf-8;",
			    dataType : "json",
			    success : function(data) {
			    	
			       for (var i = 0; i < data.length; i++) {
			    	   if(data[i].dept_name == '인사팀'){
			    		 if($('.insa1').length == 0){
				      	 $('.ref').append('<ul id="insa" class="insa1"><span>'+data[i].dept_name+'</span></ul>');		       			 
			    		 }
			    	   }else if(data[i].dept_name == '경영팀'){
			    		   if($('.gyeonyoung1').length == 0){
				      	 		$('.ref').append('<ul id="gyeonyoung" class="gyeonyoung1"><span>'+data[i].dept_name+'</span></ul>');		       			   
			    		   }
			    	   }else if(data[i].dept_name == '개발팀'){
			    		   if($('.geabal1').length == 0){
				      	 		$('.ref').append('<ul id="geabal" class="geabal1"><span>'+data[i].dept_name+'</span></ul>');		       			   
			   		   }	   
			    	   }
			       }
			       for (var i = 0; i < data.length; i++) {
			    	   if(data[i].position == '사장'){
			      			  continue; 
			      		}else{
			      			if(data[i].dept_name == '인사팀'){
				    	      	 $('.insa1').append('<li class="add-person1" value = "' + data[i].name + '" ><a href="#"> ['+data[i].dept_name+']'  + data[i].name + '('+data[i].position+')</a><input class="member_id" type="hidden" name="member_id" value="'+data[i].id+'"></li>');		   
				        	   }else if(data[i].dept_name == '경영팀'){
				    	      	 $('.gyeonyoung1').append('<li class="add-person1" value = "' + data[i].name + '" ><a href="#"> ['+data[i].dept_name+']'  + data[i].name + '('+data[i].position+')</a><input class="member_id" type="hidden" name="member_id" value="'+data[i].id+'"></li>');		   
				        	   }else if(data[i].dept_name == '개발팀'){
				    	      	 $('.geabal1').append('<li class="add-person1" value = "' + data[i].name + '" ><a href="#"> ['+data[i].dept_name+']' + data[i].name + '('+data[i].position+')</a><input class="member_id" type="hidden" name="member_id" value="'+data[i].id+'"></li>');		   
				        	   }	
			      		}
			         }
			       
			       
			    },
			    error : function() {
			       alert("restController err");  
			    }
			 });
			
		});
		
		
});
```
프로젝트 추가시에 사원을 추가 하기 위해 ajax로 사원의 목록을 가져왔습니다.

 ```jsx
 	//프로젝트 날짜 지정
	$("#datepicker").datepicker({
		language : 'ko'
	});

	//프로젝트 작업 날짜 지정
	datePickerSet($("#datepicker1"), $("#datepicker2"), true); //다중은 시작하는 달력 먼저, 끝달력 2번째
	datePickerSet($("#datepicker5"), $("#datepicker6"), true); //다중은 시작하는 달력 먼저, 끝달력 2번째


	function datePickerSet(sDate, eDate, flag) {

		//시작 ~ 종료 2개 짜리 달력 datepicker	
		if (!isValidStr(sDate) && !isValidStr(eDate) && sDate.length > 0
				&& eDate.length > 0) {
			var sDay = sDate.val();
			var eDay = eDate.val();
			

			if (flag && !isValidStr(sDay) && !isValidStr(eDay)) { //처음 입력 날짜 설정, update...			
				var sdp = sDate.datepicker().data("datepicker");
				sdp.selectDate(new Date(sDay.replace(/-/g, "/"))); //익스에서는 그냥 new Date하면 -을 인식못함 replace필요

				var edp = eDate.datepicker().data("datepicker");
				edp.selectDate(new Date(eDay.replace(/-/g, "/"))); //익스에서는 그냥 new Date하면 -을 인식못함 replace필요
				
				
			}

			//시작일자 세팅하기 날짜가 없는경우엔 제한을 걸지 않음
			if (!isValidStr(eDay)) {
				sDate.datepicker({
					maxDate : new Date(eDay.replace(/-/g, "/"))
				});
			}
			sDate.datepicker({
				language : 'en',
				dateFormat : 'yyyy-mm-dd',
				autoClose : true,
				onSelect : function() {
					datePickerSet(sDate, eDate);
				}
			});
			
			

			//종료일자 세팅하기 날짜가 없는경우엔 제한을 걸지 않음
			if (!isValidStr(sDay)) {
				eDate.datepicker({
					minDate : new Date(sDay.replace(/-/g, "/"))
				});
			}
			eDate.datepicker({
				language : 'en',
				dateFormat : 'yyyy-mm-dd',
				autoClose : true,
				onSelect : function() {
					datePickerSet(sDate, eDate);
				}
			});
			
			//한개짜리 달력 datepicker
		} else if (!isValidStr(sDate)) {
			var sDay = sDate.val();
			if (flag && !isValidStr(sDay)) { //처음 입력 날짜 설정, update...			
				var sdp = sDate.datepicker().data("datepicker");
				sdp.selectDate(new Date(sDay.replace(/-/g, "/"))); //익스에서는 그냥 new Date하면 -을 인식못함 replace필요
			}

			sDate.datepicker({
				language : 'en',
				dateFormat : 'yyyy-mm-dd',
				autoClose : true
			});
		}

            function isValidStr(str) {
                if (str == null || str == undefined || str == "")
                    return true;
                else
                    return false;
            }
        }
			
			

		function datePickerSets(sDate2, eDate2, flag) {

			//시작 ~ 종료 2개 짜리 달력 datepicker	
			if (!isValidStr(sDate2) && !isValidStr(eDate2) && sDate2.length > 0
					&& eDate2.length > 0) {
				var sDay2 = sDate2.val();
				var eDay2 = eDate2.val();
				var std_date = $("#datepicker1").val();
				var end_date = $("#datepicker2").val();
				console.log(std_date);
				console.log(end_date);
			
				

				if (flag && !isValidStr(sDay2) && !isValidStr(eDay2)) { //처음 입력 날짜 설정, update...			
					var sdp2 = sDate2.datepicker().data("datepicker");
					sdp2.selectDate(new Date(sDay2.replace(/-/g, "/"))); //익스에서는 그냥 new Date하면 -을 인식못함 replace필요

					var edp2 = eDate2.datepicker().data("datepicker");
					edp2.selectDate(new Date(eDay2.replace(/-/g, "/"))); //익스에서는 그냥 new Date하면 -을 인식못함 replace필요
					
					
				}

				//시작일자 세팅하기 날짜가 없는경우엔 제한을 걸지 않음
						
				
				
				sDate2.datepicker({
					language : 'en',
					dateFormat : 'yyyy-mm-dd',
					minDate : new Date(std_date.replace(/-/g, "/")),
					maxDate : new Date(end_date.replace(/-/g, "/")),
					autoClose : true,
					onSelect : function() {
						datePickerSets(sDate2, eDate2);
					}
				});
				
				

				//종료일자 세팅하기 날짜가 없는경우엔 제한을 걸지 않음
				
					
					
						
				eDate2.datepicker({
					language : 'en',
					dateFormat : 'yyyy-mm-dd',
					minDate : new Date(sDay2.replace(/-/g, "/")),
					maxDate : new Date(end_date.replace(/-/g, "/")),
					autoClose : true,
					onSelect : function() {
						datePickerSets(sDate2, eDate2);
					}
				});
				
				
				
				
				
				
				
				

				//한개짜리 달력 datepicker
			} 

	            function isValidStr(str) {
	                if (str == null || str == undefined || str == "")
	                    return true;
	                else
	                    return false;
	            }
	        }
 ```
 프로젝트를 만들 시에는 프로젝트의 시작일과 종료일을 정해주기 위해 JDatePicker 두개를 사용하여 날을 지정해 주었습니다.
 그리고 프로젝트 내의 작업을 지정할 때도 JDatePicker 2개를 이용하였습니다.
 이때 프로젝트 종료일은 시작일 전이 될 수 없게 하였습니다.
 그리고 작업의 시작일과 종료일은 프로젝트 기간 안에서 정할 수 있도록 하였고 프로젝트와 동일하게 종료일은 시작일 전이 될 수 없게 하였습니다.
  ```jsx
  /*프로젝트 종료일 input val 비어있는 지 확인*/
  $("#datepicker2").focusout(function() {
		var prj_std = $("#datepicker1").val();
		var prj_etd = $("#datepicker2").val();
		if(!prj_etd){
			alert('프로젝트 종료일을 입력해 주세요.');
		}else{
		datePickerSets($("#datepicker3"), $("#datepicker4"), true); //다중은 시작하는 달력 먼저, 끝달력 2번째
			
		}
	});
 ```
 프로젝트의 종료일이 정해지지 않았다면 아래의 작업일을 정할 수 없도록 하였습니다.
  ```jsx
  /*주소록 회원 고르기*/
		$(document).on("click",".add-person1", function() {
			console.log($(this).children(".member_id").val());
			var member_id = $(this).children(".member_id").val();
			var member_name = $(this).text();
			$('#set-name').append('<div class="setting-name" style="display:block; left=10px; margin-right:10px;">'+member_name+'&nbsp;&nbsp;<input type="hidden" name="members_id" value="'+member_id+'"></div>');
		})
 ```
 프로젝트의 작업에 참여할 인원을 주소록에서 고르는 코드입니다.
  ```jsx
  /*주소록 회원 고르기 취소*/
		$('#clear-set-name').click(function() {
			$("#set-name").empty();
		});
 ```
 추가된 인원을 정정할 때 사용하는 코드입니다.
  ```jsx
  		/*프로젝트 생성시 유효성 검증*/
		$('#prj-add-project').click(function() {
			if($('.setting-name').length == 0){
				alert('인원을 한명 이상 골라주세요');
			}else if($('.setting-name').length > 3){
				alert('인원은 세명까지 고를 수 있습니다.');
			}else{
				if($('.prj-member-list').length < 3){
						var member_list = $(".setting-name").get();						
						var members_id = $("input[name=members_id][type=hidden]").get();
						console.log($('.prj-member-list').length);
					$('#set-name').empty();
					for(var i = 0; i < member_list.length; i++){
						var member_name = $(member_list[i]).text();
						var member_id = $(members_id[i]).val();
						console.log(member_id);
						$('.fa-hover').append('<div class="prj-member-list" style="width:600px; margin-top:15px; margin-left:10px;">'+member_name+'<a class="del-person" href="javascript:void(0);">x</a><input type="hidden" name="prj_member_id" value="'+member_id+'"><div>');						
					}
					$('#Medium-modal').modal('toggle');
					$('.modal-backdrop').remove(); 
				}else{
					$('#set-name').empty();
					alert('인원은 세명까지 고를 수 있습니다.');
					$('#Medium-modal').modal('toggle');
					$('.modal-backdrop').remove(); 
				}	
			}
			
			
			
			
		});
 ```
 인원을 추가하지 않거나 이미 고른 인원이 3명이 넘었을 때를 검증하는 코드입니다.
 ```jsx
  /*모달을 닫았을 때 clear*/
		$('#prj-clear').click(function() {
			$('#project_title').val('');
			$('#datepicker1').val('');
			$('#datepicker2').val('');
			$('#project_sub_title').val('');
			$('#result').empty();
			$('#bd-example-modal-lg').modal("toggle");
			$('.modal-backdrop').remove(); 
		});
 ```
 프로젝트 추가 모달을 닫았을 때 모든 항목이 지워지는 코드입니다.
  ```jsx
   /*작업의 모든 항목 입력후 유효성 체크*/
		 $('#prj-add-person').click(function() {
			var project_title = $('.project_title').val();
			var project_std_date = $('.project_std_date').val();
			var project_end_date = $('.project_end_date').val();
			var project_sub_title = $('.project_sub_title').val();
			var prj_member_list = $('.prj-member-list').get();
			var member_id_group = $("input[name=prj_member_id][type=hidden]").get();
			var project_sub_std_date = $("input[name=project_std_dates][type=text]").val();
			var project_sub_end_date = $("input[name=project_end_dates][type=text]").val();
			var important = $("#important option:selected").val();
			if(important == "" || important == null){
				alert("중요도를 선택해 주세요")
			}

	
			
		
			
			
			if(project_title == ""||project_std_date == ""||project_end_date == ""||project_sub_title == ""||project_sub_std_date == ""||project_sub_end_date == ""||prj_member_list.length == 0){
				alert("항목을 모두 입력해 주세요");
			}else{
				var i = 0;
			$('.prj-member-result').append('<div class="prj-sub-group"></div>');
			$('.prj-sub-group').last().append('<div class="prj-sub">'+project_sub_title+'<input type="hidden" name="project_sub_title" value="'+project_sub_title+'"></div>');
			
			for(i = 0; i < prj_member_list.length; i++){
				var sub_member = $(prj_member_list[i]).text();
				var sub_members = sub_member.replace(/\x/g,'');
				var prj_member_id = $(member_id_group[i]).val();
				
				
			$('.prj-sub-group').last().append('<div class="prj-sub-member">'+sub_members+'<input type="hidden" name="id" value="'+prj_member_id+'"></div>');
				
			}
			$('.prj-sub-group').last().append('<div class="prj-sub-dates">'+project_sub_std_date+'<input type="hidden" name="project_sub_std_date" value="'+project_sub_std_date+'"></div>');
			$('.prj-sub-group').last().append('<div class="prj-sub-dates">'+project_sub_end_date+'<input type="hidden" name="project_sub_end_date" value="'+project_sub_end_date+'"></div>');
			$('.prj-sub-group').last().append('<div class="importants">'+important+'<input type="hidden" name="project_sub_important" value="'+important+'"></div>');
			
			$('.prj-sub-group').last().append('<input type="hidden" name="prj_members_id_count" value="'+i+'"></div>')
			
			
			$('.prj-sub-group').last().append('<a class="del-sub-group" href="javascript:void(0);">x</a>');
			$('#project_sub_title').val('');
			$('input[name=project_std_dates][type=text]').val('');
			$('input[name=project_end_dates][type=text]').val('');
			$('.prj-member-list').remove();
			}
			
		
		})
 ```
 프로젝트 내의 작업을 추가할 때 비어있는 곳이 있는지 검증하는 코드입니다.
 
  ```jsx
  /*작업 인원 삭제*/
		$(document).on("click",".del-person", function() {
			$(this).parent().remove();
			
		})
		/*작업 삭제*/
		$(document).on("click",".del-sub-group", function() {
			$(this).parent().remove();
			
		})
 ```
 작업인원이나 작업을 삭제,수정 할 수 있는 코드입니다.
  ```jsx
  /*프로젝트 삭제*/
		$(".prj-del").click(function(){
			var projectP = $(this).parent();
			var projectDiv = projectP.find('input[name=prj-id]').val();
			console.log(projectDiv);
		    if(confirm("정말 삭제하시겠습니까 ?") == true){
				$.ajax({
					url : "${pageContext.request.contextPath}/projectDelete.do",
					method : "POST",
					data : {
						project_id : projectDiv
					},
					success : function(data) {
						alert(data);
						projectP.parent().parent().parent().remove();
					},
					error : function(request, status,
							error) {

						alert("code:" + request.status
								+ "\n" + "message:"
								+ request.responseText
								+ "\n" + "error:"
								+ error);
					}
				});
		    }
		    else{
		        return ;
		    }
		});
		 /*프로젝트 수정*/
		$('.prj-update').click(function() {
			var projectP = $(this).parent().parent(); 
			var prj_title = projectP.find('h2').text();
			var prj_std_date = projectP.find('input[name=p_std]').val();
			var prj_end_date = projectP.find('input[name=p_end]').val();
			var prj_status = projectP.find('div[id=prj-set-status]').text();
			var prj_id = projectP.find('input[name=prj-id]').val();
			$("#project_update_title").val(prj_title);
			$("#datepicker5").val(prj_std_date);
			$("#datepicker6").val(prj_end_date);
			if($('input[name=prj_update_id]').val() != null){
				$('input[name=prj_update_id]').val(prj_id)
							
			}else{
				$('input[name=prj_update_id]').val(prj_id)
			}
			
			console.log(prj_title);
			console.log(prj_status);
			})
 ```
 만들어진 프로젝트를 수정하거나 삭제하는 코드입니다. 
 ajax를 통해 비동기로 처리하였습니다.
 자신이 만든 프로젝트가 아니라면 삭제/수정 버튼을 보이지 않게 구현하였습니다.

#### projectDetail.jsp script
![prj-detail](https://user-images.githubusercontent.com/59170160/110252616-a054d400-7fc9-11eb-828b-a4cbb50d3028.png)
  ```jsx
// 차트 생성
am4core.ready(function() {

// Themes begin
am4core.useTheme(am4themes_animated);
// Themes end

var chart = am4core.create("chartdiv", am4charts.XYChart);
chart.hiddenState.properties.opacity = 0; // this creates initial fade-in

chart.paddingRight = 30;
chart.dateFormatter.inputDateFormat = "yyyy-MM-dd";

var colorSet = new am4core.ColorSet();
colorSet.saturation = 0.4;
var result = Math.floor(Math.random() * 30) + 1;

console.log(result);
//차트에 들어갈 데이터
chart.data = [ 
<c:forEach items="${projectSubList}" var="pvo" varStatus="s" >	

{
  "category": "${pvo.project_sub_title}",
  "start": "${pvo.project_sub_std_date}",
  "end": "${pvo.project_sub_end_date}",
  "color": colorSet.getIndex(${s.index}),
  "task": "${pvo.project_sub_title}"
},
</c:forEach>
];



chart.dateFormatter.dateFormat = "yyyy-MM-dd";
chart.dateFormatter.inputDateFormat = "yyyy-MM-dd";

var categoryAxis = chart.yAxes.push(new am4charts.CategoryAxis());
categoryAxis.dataFields.category = "category";
categoryAxis.renderer.grid.template.location = 0;
categoryAxis.renderer.inversed = true;

var dateAxis = chart.xAxes.push(new am4charts.DateAxis());
dateAxis.renderer.minGridDistance = 50;
dateAxis.baseInterval = { count: 40, timeUnit: "day" };
dateAxis.max = new Date().getTime();
//dateAxis.strictMinMax = true;
dateAxis.renderer.tooltipLocation = 0;

var series1 = chart.series.push(new am4charts.ColumnSeries());
series1.columns.template.height = am4core.percent(70);
series1.columns.template.tooltipText = "{task}: [bold]{openDateX}[/] - [bold]{dateX}[/]";

series1.dataFields.openDateX = "start";
series1.dataFields.dateX = "end";
series1.dataFields.categoryY = "category";
series1.columns.template.propertyFields.fill = "color"; // get color from data
series1.columns.template.propertyFields.stroke = "color";
series1.columns.template.strokeOpacity = 1;

chart.scrollbarX = new am4core.Scrollbar();

}); // end am4core.ready()
 ```
AM Chart로 프로젝트에 대한 상세일정을 간트차트로 구현한 코드입니다.
화면이 넘어올 때 가져온 데이터를 jstl을 활용하여 시작일과 종료일을 정하여 차트에 뿌려주었습니다.

#### projectHistory.jsp script
![prj-history](https://user-images.githubusercontent.com/59170160/110252617-a0ed6a80-7fc9-11eb-8eca-31b0dd44f06f.png)

 ```jsx
 /* 히스토리 추가시 검증*/
			$("#histryAddBtn").click(function(){
				var content = $('textarea[name=project_datail_content]').val().trim();				
				var status = $("#stauts option:selected").val().trim();
				
			
				
				if(content == ""){
					$('textarea[name=project_datail_content]').css("border","2px solid red");
					alert('내용을 입력해 주세요');
					return false;
				}else if(status == ""){
					alert('현재상태를 정해 주세요');	
					return false;
				}
				
				if(content != ""){
					$('textarea[name=prj-content]').css("border","1px solid black");
				}
			
			
			});
 ```
 작업에 대한 히스토리를 추가할 경우에 필요한 항목이 비어있는지 확인하는 코드입니다.
 ```jsx
 //히스토리 댓글달기 눌렀을 때 불러오기
			$(document).on("click", ".comment", function() {
				
			
				var commentArea = $(this).parent().parent().find('.commentArea');
				
				var project_datail_id = commentArea.find('input[name=project_datail_id]').val();
				var sessionId = commentArea.find('input[name=sessionId]').val();
				var commentList = commentArea.find('.commentList');
				var chk_content_id = commentList.find('.comments');
				
				commentArea.css("display","block");
				
				 $.ajax({
		                url : "${pageContext.request.contextPath}/projecthistoryCommentList.do",
		                type : 'POST',
		                dataType : 'json',
		                data : {
		                project_datail_id : project_datail_id,
		               	id : sessionId
		                },
		                beforeSend : function() {
		                    console.log('Ajax submit 보내기전');
		                },
		                success : function(data) {
		                	if(chk_content_id.length >= data.commentList.length){
		                	}else{
		                		for(var i = 0; i<data.commentList.length; i++){
			                    	a = chk_content_id.length;
			                		console.log(a.length);
			                		commentList.append('<div class="comments" style="width: 100%; display: block;">'
				    						+'<div class="comments_block" style="width: 100%; display: flex">'
		                					+	'<div style="width: 5%; text-align: center;">'
				    						+		'<img src="${pageContext.request.contextPath}/resources/profileImg/'+data.commentList[i].profile+'" style="width: 30px; height:30px; border-radius: 50%;">'
				    						+		'<input type="hidden" name="sessionIds" value="'+data.commentList[i].id+'">'
				    						+		'<input type="hidden" name="project_detail_id" value="'+data.commentList[i].project_detail_id+'">'
				    						+'</div>'
				    						+	'<div class="commentPrints" style="width: 70%; word-break:break-all;">'
				    						+	'<div class="comment_user_name" style="font-size: 12px; font-weight: bold;">'+data.commentList[i].name+'</div>'
				    						+	'<div class="comment_content">'+data.commentList[i].project_comment_content+'</div>'
 				    						+	'<input type="hidden" name="project_comment_ids" value="'+data.commentList[i].project_comment_id+'">'
				    						+'</div>'
					    						+'<div class="comment-nav" style="width: 22%; margin-left: 2%;">'
					    						+	'<label class="commnet_delete" style="margin-left:135px; text-decoration: underline; color:red; font-size: 10px; cursor: pointer;">삭제하기</label>'
					    						+'</div>'
				    						+'</div>'
			    						+'<div class="recommentWriteFMArgin" style="margin-left:5%">'
										+'<div class="recommentWriteF" style="width: 90%; display: none;">'
										+	'<img src="${pageContext.request.contextPath}/resources/profileImg/${sessionScope.loginProfile }" style="width: 30px; height:30px; border-radius: 50%;">'
										+	'<input type="hidden" name="sessionIdse" value="${sessionScope.loginId}">'
										+	'<input type="hidden" name="project_comment_id" value="'+data.commentList[i].project_comment_id+'">'
										+	'<input type="text" name="recommentWrite" style="width:90%; height: 40px;">'
										+	'<input class="recommentWriteOk" type="button" style="margin-left: 5px; margin-bottom:20px; width: 65px; height: 40px; background-color: #0b132b; border-radius: 5%; color:white; font-size: 13px; text-align: center; line-height:40px;" value="전송">'
						 				+'</div> '
						 				+'</div> '
						 				+'<label class="addReComment" style="margin-left:40px; font-size:10px; cursor:pointer; text-decoration:underline;">댓글 더보기</label>'
						 				+'<div class="recomments" style="margin-left:5% display:block">'
						 				+'</div>'
			    						+'</div>'
			    						+'<hr>');
			                		
			                  
			                		
			                  	}
			                	chk_content_id = null;
			                	
			                	/* 댓글 ajax */
		                	}
		                	
		                	
		                }, 
		                error : function(data) {
		                    console.log('Ajax submit error');
		                },
		                complete : function() {
		                	
		                    console.log('Ajax submit complete');
		                }
		            });	 

			});
 ```
 댓글은 댓글 달기를 눌렀을 때 가져오도록 구현하였습니다. 
 ajax를 통해 비동기로 처리하였습니다.
 ```jsx 
 			//히스토리 댓글 닫기
			$('.closeCommnetArea').click(function() {
				var closeCommentArae = $(this).parent();
				var recommentFrm_block = $(this).parent().parent().parent().parent().find('.recommentWriteF');
				
				closeCommentArae.css("display","none")
				recommentFrm_block.css("display","none");
				
			})
 ```
 프로젝트 댓글은 접었다 펼칠 수 있어 닫는 기능도 구현하였습니다.
 ```jsx 
 //히스토리 대댓글 펼칠때 대댓글 불러오기
		 	$(document).on("click",".addReComment", function() {
		 		var recommentFrm_block = $(this).parent().find('.recommentWriteF');
		 		var recomments = $(this).parent().find('.recomments');
		 		var project_comment_id = $(this).parent().find('input[name=project_comment_id]').val();
				console.log(project_comment_id);
				console.log(recomments);
		 		var text = $(this).text();
				if(text == '댓글 더보기'){
					console.log('aaaaaa');
					
					 $.ajax({
			                url : "${pageContext.request.contextPath}/projecthistoryReCommentList.do",
			                type : 'POST',
			                dataType : 'json',
			                data : {
			                	project_comment_id : project_comment_id
			                	
			                },
			                beforeSend : function() {
			                    console.log('Ajax submit 보내기전');
			                },
			                success : function(data) {
			                	for(var i = 0; i<data.recommentList.length; i++){
			                 	recomments.prepend(
			                			'<div class="recommnet_Print" style="margin-left: 2%; margin-top: 10px; width: 100%; display: flex;">'
										+'	<div style="width: 5%; text-align: center;">'
										+'			<img src="${pageContext.request.contextPath}/resources/profileImg/'+data.recommentList[i].profile+'" style="width: 30px; height:30px; border-radius: 50%;">'
										+'			<input type="hidden" name="user_id" value="'+data.recommentList[i].id+'">'
										+'	</div>'
										+'	<div class="recommentPrints" style="width: 98%; word-break:break-all;">'
										+'		<input type="hidden" name="project_recomment_id" value="'+data.recommentList[i].project_recomment_id+'">'
										+'		<div class="recomment_user_name" style="font-size: 12px; font-weight: bold;">'+data.recommentList[i].name+'</div>'
										+'		<div class="recomment_content">'+data.recommentList[i].project_recomment_content+'</div>'
										+'		<label class="recommnet_delete" style="text-decoration: underline; color:red; font-size: 10px; cursor: pointer;">삭제하기</label>'
										+'	</div>'
										
										
										+'</div>'
										);
			                	
			                	}
			                 
			                	console.log('성공');
			                
			                }, error : function(data) {
			                    console.log('Ajax submit error');
			                
			                }, complete : function() {
			                    console.log('Ajax submit complete');
			                }
					  }); 
					
					
					recommentFrm_block.css("display","flex");
					$(this).text('닫기');
					
					
				
					
					
					
				}else{
					$(this).text('댓글 더보기');
					recommentFrm_block.css("display","none");
					recomments.empty();
				}
			})
 ```
 대댓글 또한 댓글과 마찬가지로 접었다 펼칠 수 있게 구현하였고 펼칠때마다 비동기로 대댓글을 다시 불러오도록 구현하였습니다.
 ```jsx 
 //히스토리 게시물 수정
			$(".update").click(function() {
				var closeCommentArae = $(this).parent().parent().find('.project_datail_id').val();
				var sessionId = $('input[name=sessionId]').val();
				var user_id = $(this).parent().parent().find('input[name=user_id]').val();
				if(sessionId != user_id){
					alert("작성자만 수정가능합니다.")
			
				}else{
					$(".update").attr({"data-toggle":"modal", "data-target":"#Medium-modal"});
					$('#Medium-modal').modal('show');
				$('input[name=pdid]').val(closeCommentArae);
				console.log(closeCommentArae);
					
				}
			})
 ```
 수정권한은 자신이 작성한 히스토리에 관해서만 수정버튼이 보이도록 하였고 수정버튼을 눌렀을 때 수정 모달이 뜨도록 구현하였습니다.
 ```jsx 
 			//히스토리 게시물 삭제
			$(".delete").click(function() {
				var sessionId = $('input[name=sessionId]').val();
				var user_id = $(this).parent().parent().find('input[name=user_id]').val();
				var project_datail_id = $(this).parent().parent().find('.project_datail_id').val();
				var li = $(this).parent().parent().parent();
				
				console.log(li);
				
				
				if(sessionId != user_id){
					alert("작성자만 삭제가능합니다.")
				}else{
					if(confirm("정말 삭제하시겠습니까 ?") == true){
						
						
		 	 		$.ajax({
							url : "${pageContext.request.contextPath}/projectHistoryDelete.do",
							method : "POST",
							data : {
								project_datail_id : project_datail_id
							},
							success : function(data) {
								li.remove();
								var a = data.sucess;
								alert(a);
							},
							error : function(request, status,
									error) {

								alert("code:" + request.status
										+ "\n" + "message:"
										+ request.responseText
										+ "\n" + "error:"
										+ error);
							}
						});	 
					}
						
				else{
					return;
					}
				}
			})
			
			
			//대댓글 삭제
			$(document).on("click",".recommnet_delete", function() {
				var project_recomment_id = $(this).parent().parent().find('input[name=project_recomment_id]').val();
				console.log(project_recomment_id);
				var id = $(this).parent().parent().find('input[name=user_id]').val();
				console.log(id);
				var recommnet_Print = $(this).parent().parent().parent();
				console.log(recommnet_Print);
				if(confirm("정말 삭제하시겠습니까 ?") == true){ 
					 $.ajax({
						url : "${pageContext.request.contextPath}/projectReCommentDelete.do",
						method : "POST",
						data : {
							project_recomment_id : project_recomment_id,
							id : id
						},
						success : function(data) {
						if(data.fail){
							alert(data.fail);
							
						}else{
							alert(data.sucess);
							recommnet_Print.remove();
						}
						},
						error : function(request, status,
								error) {

							alert("code:" + request.status
									+ "\n" + "message:"
									+ request.responseText
									+ "\n" + "error:"
									+ error);
						}
					});	  
				}else{
					return;
				}  
				
				
				
			})
			
			
			
			
			
			//댓글 삭제
			$(document).on("click",".commnet_delete", function() {
				var project_comment_id = $(this).parent().parent().parent().find('input[name=project_comment_ids]').val();
				var id = $(this).parent().parent().parent().find('input[name=sessionIds]').val();
				var comments = $(this).parent().parent().parent();
				console.log(comments);
				console.log(project_comment_id);
				console.log(id);
				if(confirm("정말 삭제하시겠습니까 ?") == true){
					$.ajax({
						url : "${pageContext.request.contextPath}/projectCommentDelete.do",
						method : "POST",
						data : {
							project_comment_id : project_comment_id,
							id : id
						},
						success : function(data) {
						if(data.fail){
							alert(data.fail);
						}else{
							comments.remove();
						}
						},
						error : function(request, status,
								error) {

							alert("code:" + request.status
									+ "\n" + "message:"
									+ request.responseText
									+ "\n" + "error:"
									+ error);
						}
					});	 
				}else{
					return;
				}
				
				
				
			})
 ```
 히스토리와 히스토리에 관련된 댓글 대댓글의 삭제는 모두 비동기로 처리하였습니다.
 ```jsx 
 //대댓글 작성
			$(document).on("click", ".recommentWriteOk", function() {
				var project_recomment_content = $(this).parent().parent().parent().find('input[name=recommentWrite]').val();
				var comments = $(this).parent().parent().parent().find('.recomments');
				var project_comment_id = $(this).parent().parent().parent().find('input[name=project_comment_id]').val();
				var id = $(this).parent().parent().parent().parent().parent().find('input[name=sessionId]').val();
				if(project_recomment_content == null || project_recomment_content == ''){
					alert('답글을 입력해 주세요.'); 
				}else{
					
					  $.ajax({
			                url : "${pageContext.request.contextPath}/projecthistoryReCommentInsert.do",
			                type : 'POST',
			                dataType : 'json',
			                data : {
			                	project_recomment_content : project_recomment_content,
			                	project_comment_id : project_comment_id,
			                	id : id
			                },
			                beforeSend : function() {
			                    console.log('Ajax submit 보내기전');
			                },
			                success : function(data) {
			                	console.log(data.recommentList.length)
			                	comments.prepend(
			                			'<div class="recommnet_Print" style="margin-left: 2%; margin-top: 10px; width: 100%; display: flex;">'
										+'	<div style="width: 5%; text-align: center;">'
										+'			<img src="${pageContext.request.contextPath}/resources/profileImg/'+data.recommentList[0].profile+'" style="width: 30px; height:30px; border-radius: 50%;">'
										+'			<input type="hidden" name="user_id" value="'+data.recommentList[0].id+'">'
										+'	</div>'
										+'	<div class="recommentPrints" style="width: 98%; word-break:break-all;">'
										+'		<input type="hidden" name="project_recomment_id" value="'+data.recommentList[0].project_recomment_id+'">'
										+'		<div class="recomment_user_name" style="font-size: 12px; font-weight: bold;">'+data.recommentList[0].name+'</div>'
										+'		<div class="recomment_content">'+data.recommentList[0].project_recomment_content+'</div>'
										+'		<label class="recommnet_delete" style="text-decoration: underline; color:red; font-size: 10px; cursor: pointer;">삭제하기</label>'
										+'	</div>'
										
										
										+'</div>'
										);
			                	
			                	
			                 	$('input[name=recommentWrite]').val('');	
			                	
			                
			                }, error : function(data) {
			                    console.log('Ajax submit error');
			                
			                }, complete : function() {
			                    console.log('Ajax submit complete');
			                }
					  }); 
					
				}
			});
			
			
			//댓글 작성
			$(document).on("click", ".commentWriteSubmit", function() {
				var comment = $(this).parent().find('input[name=commentWrite]').val();
				var project_datail_id = $(this).parent().find('input[name=project_datail_id]').val();
				var sessionId = $(this).parent().find('input[name=sessionId]').val();
				var commentList = $(this).parent().parent().find('.commentList');
				console.log("인서트"+sessionId);
				
	            $.ajax({
	                url : "${pageContext.request.contextPath}/projecthistoryComment.do",
	                type : 'POST',
	                dataType : 'json',
	                data : {
	                project_comment_content : comment,
	                project_datail_id : project_datail_id,
	               	id : sessionId
	                },
	                beforeSend : function() {
	                    console.log('Ajax submit 보내기전');
	                },
	                success : function(data) {
	                	var a = 0;
	                	if(!data.commentList){
	                		console.log("못받아옴");
	                	}else{
	                		for(var i = 0; i<data.commentList.length; i++){
	                			commentList.append(
	                					'<div class="comments" style="width: 100%; display: block;">'
				    						+'<div class="comments_block" style="width: 100%; display: flex">'
		                					+	'<div style="width: 5%; text-align: center;">'
				    						+		'<img src="${pageContext.request.contextPath}/resources/profileImg/'+data.commentList[i].profile+'" style="width: 30px; height:30px; border-radius: 50%;">'
 				    						+		'<input type="hidden" name="commentIds" value="'+data.commentList[i].id+'">' 
				    						+		'<input type="hidden" name="sessionIds" value="${sessionScope.loginId}">'
				    						+'</div>'
				    						+	'<div class="commentPrints" style="width: 70%; word-break:break-all;">'
				    						+	'<div class="comment_user_name" style="font-size: 12px; font-weight: bold;">'+data.commentList[i].name+'</div>'
				    						+	'<div class="comment_content">'+data.commentList[i].project_comment_content+'</div>'
				    						+		'<input type="hidden" name="project_comment_id" value="'+data.commentList[i].project_comment_id+'">'
				    						+'</div>'
					    						+'<div class="comment-nav" style="width: 22%; margin-left: 2%;">'
					    						+	'<label class="commnet_delete" style="margin-left:135px; text-decoration: underline; color:red; font-size: 10px; cursor: pointer;">삭제하기</label>'
					    						+'</div>'
				    						+'</div>'
			    						
				    				
			    						+'<div class="recommentWriteFMArgin" style="margin-left:5%">'
										+'<div class="recommentWriteF" style="width: 90%; display: none;">'
										+	'<img src="${pageContext.request.contextPath}/resources/profileImg/'+data.commentList[i].profile+'" style="width: 30px; height:30px; border-radius: 50%;">'
										+	'<input type="hidden" name="sessionIdse" value="'+data.commentList[i].id+'">'
										+	'<input type="hidden" name="project_comment_id" value="'+data.commentList[i].project_comment_id+'">'
										+	'<input type="text" name="recommentWrite" style="width:90%; height: 40px;">'
										+	'<input class="recommentWriteOk" type="button" style="margin-left: 5px; margin-bottom:20px; width: 65px; height: 40px; background-color: #0b132b; border-radius: 5%; color:white; font-size: 13px; text-align: center; line-height:40px;" value="전송">'
						 				+'</div> '
						 				+'</div> '	
						 				+'<label class="addReComment" style="margin-left:40px; font-size:10px; cursor:pointer; text-decoration:underline;">댓글 더보기</label>'
						 				+'<div class="recomments" style="margin-left:5% display:block">'
						 				+'</div>'
			    						+'</div>'
		               		
							);
		                  
		                  	$('input[name=commentWrite]').val('');	
		                  	}
	                	}
	                	
	                	
	                }, 
	                error : function(data) {
	                    console.log('Ajax submit error');
	                },
	                complete : function() {
	                    console.log('Ajax submit complete');
	                }
	            });
	     
				
			})
 ```
 댓글과 대댓글도 비동기로 처리하여 작성하면 바로 추가되도록 구현하였습니다.
 ## insertmember.jsp script
 ![insertmember](https://user-images.githubusercontent.com/59170160/110252618-a0ed6a80-7fc9-11eb-912d-76aa76fa6256.png)
 ```jsx 
 //이메일 유효성 검증
	$('input[name=email]').on("change", function() {
		const regEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
		var email = $('input[name=email]').val();
		if(regEmail.test(email)){
			$('input[name=email]').css("border","1px solid black");
			 $.ajax({
	                url : "${pageContext.request.contextPath}/emailChk.do",
	                type : 'POST',
	                dataType : 'json',
	                data : {
	                	email : email
	                	
	                },
	                beforeSend : function() {
	                    console.log('Ajax submit 보내기전');
	                },
	                success : function(data) {
	                	console.log(data);
	                 if(data == 0){
	                	 $('input[name=email]').css("border","1px solid green");
	                 }else{
	                	 alert("이미 존재하는 이메일 입니다.");
	                	 $('input[name=email]').css("border","1px solid red");
	                	 $('input[name=email]').focus();
	                 }
	               
	                }, error : function(data) {
	                    console.log('Ajax submit error');
	                    $('input[name=email]').focus();
	                }, complete : function() {
	                    console.log('Ajax submit complete');
	                }
			  }); 
		}else if(!regEmail.test(email)){
			alert("이메일 형식에 알맞게 적어주세요");
			$('input[name=email]').css("border","1px solid red");
			$('input[name=email]').val('');
			$('input[name=email]').focus();
			
		}
		
	})
	//비밀번호 유효성검증
	$('input[name=phone]').on("focusout", function() {
		const regPhone = /^01([0|1|6|7|8|9])?([0-9]{3,4})?([0-9]{4})$/;
		var phone = $('input[name=phone]').val();
		console.log(phone);
		if(regPhone.test(phone)){
			$('input[name=phone]').css("border","1px solid black");
		}else if(!regPhone.test(phone)){
			$('input[name=phone]').css("border","1px solid red");
			$('input[name=phone]').focus();
		}
		
		
	});
 ```
 비밀번호와 이메일, 비밀번호에 대한 유효성 검증 코드입니다.
 정규식으로 검증 한 후에 중복된 데이터가 있는지 비동기로 처리하였습니다.
 ```jsx 
 //정보수정 비어있는 곳 검증
	$('input[type=submit][name=submit]').click(function() {
		
	
		

		var name = $('input[name=name]').val();
		console.log(name);
		var birth = $('input[name=birth]').val();
		var phone = $('input[name=phone]').val();
		var address = $('input[name=address]').val();
		var email = $('input[name=email]').val();
		var dept_no = $('#dept_no option:selected').val();
		var position = $('#position option:selected').val();
		
		var file = $('input[name=file]').val();
		
		
		if(!name || !birth || !phone || !email || !dept_no || !position || !address){

			alert('항목을 모두 채워주세요')
			return false;
		}else{
			$('input[name=position]').val(position);
			$('input[name=dept_no]').val(dept_no);
			$('form').submit(function() {
				return true;
			})		
			
			
		}

	});
 ```
 회원 정보를 수정할 때에 필수 항목 칸에 비어있는 곳이 있는지 확인하는 코드입니다.
  ```jsx
  /* 도로명주소 api */
	    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById("sample4_roadAddress").value = roadAddr;
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
  ```
  도로명 주소 api를 활용해 주소칸에 자동으로 입력되게 하는 코드입니다.

#### DB 
![rj-erd](https://user-images.githubusercontent.com/59170160/110253000-5ff65580-7fcb-11eb-97a4-bf345173816c.png)
- member table은 모든 사원의 정보를 담고 있는 테이블입니다.
- dept table은 각 부서에 대한 부서명을 가지고 있고 각 회원마다 하나의 부서가 주어집니다.
- project table은 프로젝트명과 시작일과 종료일 그리고 현재 상태의 정보를 가지고 있습니다.
- project memner table은 프로젝트에 참여하는 인원들의 정보가 담겨있습니다.
- project-Detail table은 프로젝트에 할당된 작업에 관한 정보를 담고있습니다.
- project-sub table은 작업에 대한 작업내용을 담고 있습니다.
- project-comment table은 작업내용에 대한 작업 참여인원들 간의 댓글을 담을 수 있는 테이블입니다.
- project-recomment table은 댓글에 대한 대댓글을 담고 있는 테이블입니다. 

##project-mapper.xml
```jsx
<!-- 프로젝트 전체 조회 -->
	<select id="projectList" resultType="arraylist"
		resultMap="resultProject" parameterType="Project">
    	select distinct project.*, project_member.project_member_grade,  project_member.id
		from project, project_member 
		where project.project_id = project_member.project_id and project_member.id = #{id} and project.project_status = '진행중' or project.project_status = '진행예정'
	</select>
	
	<!-- 프로젝트 프로그레스 용 상태 조회 -->
	<select id="projectProgress" resultType="arraylist"
		resultMap="resultProjectSub" parameterType="ProjectSub">
    		select project_sub_status from project_sub where project_id = #{project_id}
    </select>
	
	<!-- 종료 프로젝트 전체 조회 -->
	<select id="projectEndList" resultType="arraylist"
		resultMap="resultProject" parameterType="Project">
    select distinct project.*, project_member.project_member_grade
		from project, project_member 
		where project.project_id = project_member.project_id and project_member.id = #{id} and project.project_status = '종료'
	</select>
	<!-- 프로젝트 삭제 -->
	<delete id="projectDelete" flushCache="true" statementType="PREPARED" timeout="20" parameterType="Project">
		delete from project where project_id = #{project_id}
	</delete>
	<!-- 프로젝트 삭제 -->
	<delete id="projectSubDelete" flushCache="true" statementType="PREPARED" timeout="20" parameterType="ProjectSub">
		delete from project_sub where project_sub_id = #{project_sub_id}
	</delete>
	
	<!-- 프로젝트 수정 -->
	<update id="updateProject" flushCache="true" statementType="PREPARED" timeout="20" parameterType="Project">
		update project 
		set project_title = #{project_title},
		project_std_date = #{project_std_date},
		project_end_date = #{project_end_date},
		project_status = #{project_status}
		where
		project_id = #{project_id}
	</update>
	<!-- 프로젝트 수정 -->
	<update id="updateTitleProject" flushCache="true" statementType="PREPARED" timeout="20" parameterType="Project">
		update project 
		set project_title = #{project_title}
		where
		project_id = #{project_id}
	</update>
	
	<!-- 프로젝트 작업 조회 -->
	<select id="projectSubList" resultType="arraylist"
		resultMap="resultProjectSub" parameterType="string">
		   select 
		   ps.*, 
		   pm.id, 
		   pm.project_member_grade, 
		   p.project_color,  
		   m.name 
		   from project_sub ps, PROJECT_MEMBER pm,  member m, project p 
		   where ps.project_sub_id = pm.project_sub_id 
		   and p.project_id  = pm.project_id 
		   and pm.id = m.id 
		   and ps.project_id = #{project_id}  
	</select>
	
	
	<!-- 프로젝트 작업 관리자 조회 -->
	<select id="projectSubChkGrade" resultType="string" parameterType="string">
		  select distinct
		  a.project_member_grade  
		  from 
		  project_member a, project b 
		  where 
		  a.project_id = b.project_id 
		  and a.id = #{id} 
		  and a.project_member_grade = 1
	</select>
	<!-- 프로젝트 작업 이름 조회 -->
		<select id="projectSubTitles" resultType="arraylist"
		resultMap="resultProjectSub" parameterType="string">
		   select 
		   project_sub_title
		   from
		   project_sub
		   where
		   project_sub_id = #{subid}
	</select>
	
	<!-- 프로젝트 히스토리 로그인한 애 사진 조회 -->
		<select id="projectMemberImg" resultType="string"
			resultMap="resultMember" parameterType="Member">
		   select 
		   profile,
		   name,
		   id
		   from
		   member
		   where
		   id = #{id}
		</select>

	<!-- 프로젝트 날짜 조회 -->
	<select id="projectDate" resultType="arraylist"
		resultMap="resultProject" parameterType="string">
		   select
		   project_id,
		   project_title, 
		   project_std_date,
		   project_end_date
		   from project
		   where project_id = #{project_id}  
	</select>
	<!--히스토리 인원체크 -->
		<select id="projectMemberChk" resultType="arraylist"
		resultMap="resultProjectMember" parameterType="ProjectMember">
		   select
		   id
		   from project_member
		   where project_sub_id = #{project_sub_id}   
	</select>
		<!--히스토리 인원체크 -->
		<select id="projectChk" resultType="arraylist"
		resultMap="resultProjectMember" parameterType="ProjectMember">
		   select
		   id
		   from project_member
		   where project_id = #{project_id}   
	</select>



		<!-- 프로잭트 삽입 -->
	<insert id="projectInsert" flushCache="true" statementType="PREPARED" parameterType="Project">
		insert into project(PROJECT_ID,PROJECT_TITLE,PROJECT_STD_DATE,PROJECT_END_DATE,PROJECT_STATUS,PROJECT_COLOR)
		values (WEFER_PRJ_SEQ.NEXTVAL,#{project_title},#{project_std_date},#{project_end_date},#{project_status},#{project_color})
		
	</insert>
	<!-- 서브 프로젝트 삽입 -->
	<insert id="projectSubInsert" flushCache="true" statementType="PREPARED" parameterType="ProjectSub">
		insert into project_sub(PROJECT_SUB_ID, PROJECT_SUB_TITLE, PROJECT_SUB_STD_DATE, PROJECT_SUB_END_DATE, PROJECT_SUB_IMPORTANT, PROJECT_SUB_STATUS, PROJECT_ID) 
		values (WEFER_PRJ_SUB_SEQ.NEXTVAL, #{project_sub_title}, #{project_sub_std_date}, #{project_sub_end_date}, #{project_sub_important}, #{project_sub_status}, WEFER_PRJ_SEQ.CURRVAL)
	</insert>
	
		<!-- 프로젝트 멤버 삽입 -->
	<insert id="projectSubMember" flushCache="true" statementType="PREPARED" parameterType="ProjectMember">
		insert into project_member(PROJECT_MEMBER_ID, PROJECT_ID, PROJECT_SUB_ID, ID, PROJECT_MEMBER_GRADE) 
		values (WEFER_PRJ_MEMBER_SEQ.NEXTVAL, WEFER_PRJ_SEQ.CURRVAL, WEFER_PRJ_SUB_SEQ.CURRVAL, #{id}, #{project_member_grade})
	</insert>
	<!-- 서브 프로젝트 추가-->
	<insert id="projectSubAdd" flushCache="true" statementType="PREPARED" parameterType="ProjectSub">
		insert into project_sub(PROJECT_SUB_ID, PROJECT_SUB_TITLE, PROJECT_SUB_STD_DATE, PROJECT_SUB_END_DATE, PROJECT_SUB_IMPORTANT, PROJECT_SUB_STATUS, PROJECT_ID) 
		values (WEFER_PRJ_SUB_SEQ.NEXTVAL, #{project_sub_title}, #{project_sub_std_date}, #{project_sub_end_date}, #{project_sub_important}, #{project_sub_status}, #{project_id})
	</insert>
			<!-- 프로젝트 멤버 추가 -->
	<insert id="projectSubAddMember" flushCache="true" statementType="PREPARED" parameterType="ProjectMember">
		insert into project_member(PROJECT_MEMBER_ID, PROJECT_ID, PROJECT_SUB_ID, ID, PROJECT_MEMBER_GRADE) 
		values (WEFER_PRJ_MEMBER_SEQ.NEXTVAL, #{project_id}, WEFER_PRJ_SUB_SEQ.CURRVAL, #{id}, #{project_member_grade})
	</insert>
	<!-- 작업수정 -->
	<update id="projectSubUpdate" flushCache="true" statementType="PREPARED" timeout="20" parameterType="ProjectSub">
		update project_sub 
		set 
		project_sub_title = #{project_sub_title},
		project_sub_std_date = #{project_sub_std_date},
		project_sub_end_date = #{project_sub_end_date},
		project_sub_status = #{project_sub_status}
		where
		project_sub_id = #{project_sub_id}
	</update>

		<!-- 프로젝트 멤버 추가 -->
	<insert id="projectSubUpdateInsertMember" flushCache="true" statementType="PREPARED" parameterType="ProjectMember">
		insert into project_member(PROJECT_MEMBER_ID, PROJECT_ID, PROJECT_SUB_ID, ID, PROJECT_MEMBER_GRADE) 
		values (WEFER_PRJ_MEMBER_SEQ.NEXTVAL, #{project_id}, #{project_sub_id}, #{id}, #{project_member_grade})
	</insert>


	<!--  히스토리 추가  -->
	<insert id="historyInsert" flushCache="true" statementType="PREPARED" parameterType="ProjectDetail">
		insert into 
		project_datail
		(PROJECT_DATAIL_ID, 
		PROJECT_DATAIL_CONTENT, 
		PROJECT_DATAIL_WRITE_DATE, 
		PROJECT_DATAIL_FILE, 
		ID,
		PROJECT_ID,
		PROJECT_SUB_ID,
		PROJECT_DATAIL_STATUS) 
		values 
		(WEFER_PRJ_DATAIL_SEQ.NEXTVAL,
		 #{project_datail_content}, 
		 current_date, 
		 #{project_datail_file}, 
		 #{id},
		 #{project_id},
		 #{project_sub_id},
		 #{project_datail_status})
	</insert>
	
	<!-- 히스토리 리스트 가져오기 -->
	<select id="projectHistoryList" resultType="arraylist"
		resultMap="resultProjectDetail" parameterType="ProjectDetail">
		select project_datail.*, member.profile, member.name  
		from  project_datail, member where
		project_datail.id  = member.id 
		and project_datail.project_id = #{project_id} 
		and project_datail.project_sub_id = #{project_sub_id} order by project_datail.project_datail_write_date desc
	</select>
	
	<!-- 지울 파일이름 가져오기 -->
	<select id="historyFileName" resultType="string" parameterType="string">
		select project_datail_file from project_datail where project_datail_id = #{project_datail_id}
	</select>
	

	<!-- 히스토리 수정 -->
	<update id="historyUpdateFile" flushCache="true" statementType="PREPARED" timeout="20" parameterType="ProjectDetail">
		update project_datail 
		set 
		<choose>
			<when test="project_datail_content != null and project_datail_content !=''">
				project_datail_content = #{project_datail_content}
			</when>
			<when test="project_datail_file != null and project_datail_file != ''">
				project_datail_file = #{project_datail_file}
			</when>
			<when test="project_datail_status != null and project_datail_status != ''">
				project_datail_status = #{project_datail_status}
			</when>
			<otherwise>
				project_datail_content = #{project_datail_content},
				project_datail_status = #{project_datail_status},
				project_datail_file = #{project_datail_file}
			</otherwise>
		</choose>
		
		where
		project_datail_id = #{project_datail_id}
	</update>
	
	<!-- 히스토리 삭제 -->
	<delete id="projectHistoryDelete" flushCache="true" statementType="PREPARED" timeout="20" parameterType="ProjectDetail">
		delete from project_datail where project_datail_id = #{project_datail_id}
	</delete>

	
	<!-- 댓글 인서트 -->
	<insert id = "projectCommentWirte" flushCache="true" statementType="PREPARED" parameterType="ProjectComment">
		insert into project_comment(project_comment_id, project_comment_content, project_comment_writedate, project_datail_id, id)
		values(WEFER_PRJ_COMMENT_SEQ.NEXTVAL, #{project_comment_content}, current_date, #{project_datail_id}, #{id})
		
	</insert>
	
	
		<!-- 댓글 가져오기 -->
	<select id="projectCommentList" resultType="arraylist" parameterType="ProjectComment" resultMap="resultProjectComment">
		select a.*, b.name, b.profile from project_comment a, member b where a.id = b.id and a.project_datail_id=#{project_datail_id}
	</select>
	<!-- 인서트한 댓글 가져오기 -->
	<select id="projectCommentInsertList" resultType="arraylist" parameterType="ProjectComment" resultMap="resultProjectComment">
		select a.*, b.name, b.profile from project_comment a, member b 
		where a.id = b.id and a.project_datail_id=#{project_datail_id} and a.project_comment_id =(select max(project_comment_id) from project_comment)
	</select>
	<!-- 대댓글 인서트 -->
	<insert id = "projecthistoryReCommentInsert" flushCache="true" statementType="PREPARED" parameterType="ProjectReComment">
		insert into project_recomment(project_recomment_id, project_recomment_content, project_recomment_date, project_comment_id, id)
		values(WEFER_PRJ_RECOMMENT_SEQ.NEXTVAL, #{project_recomment_content}, current_date, #{project_comment_id}, #{id})
	</insert>
	<!-- 인서트한 댓글 가져오기 -->
	<select id="projectreReCommentInsertList" resultType="arraylist" parameterType="ProjectReComment" resultMap="resultProjectReComment">
		select a.*, b.name, b.profile from project_recomment a, member b 
		where a.id = b.id and a.project_comment_id=#{project_comment_id} and a.project_recomment_id =(select max(project_recomment_id) from project_recomment)
	</select>
		<!-- 대댓글 가져오기 -->
	<select id="projectReCommentList" resultType="arraylist" parameterType="ProjectReComment" resultMap="resultProjectReComment">
		select a.*, m.name, m.profile from project_recomment a, member m where a.id = m.id and project_comment_id = #{project_comment_id} order by a.project_recomment_date asc
	</select>
	
	<!-- 댓글 삭제 -->
	<delete id="projectCommentDelete" flushCache="true" statementType="PREPARED" timeout="20" parameterType="ProjectComment">
		delete from project_comment where project_comment_id = #{project_comment_id}
	</delete>
	<!-- 댓글 삭제 -->
	<delete id="projectReCommentDelete" flushCache="true" statementType="PREPARED" timeout="20" parameterType="ProjectReComment">
		delete from project_recomment where project_recomment_id = #{project_recomment_id}
	</delete>
	
	<!-- 프로젝트 상태 업데이트 -->
	<update id="updateStatus" flushCache="true" statementType="PREPARED" timeout="20" parameterType="Project">
		update project 
		set 
		<choose>
			<when test="project_status == '종료'">
				project_status = #{project_status}
			</when>
			<when test="project_status == '진행예정'">
				project_status = #{project_status}
			</when>
		</choose>
		
		where
		project_id = #{project_id}
	</update>
```
프로젝트 협업 관련 mapper 쿼리문 입니다.

```jsx
<!-- 사원추가 인서트 문 -->
<insert id="insertMember"  parameterType="Member"  statementType="PREPARED">
		insert into member(
			id,
			password,
			name,
			birth,
			phone,
			email,
			position,
			profile,
			status,
			annual,
			dept_no,
			employ_date,
			address)
    	values(
    		'WE'||TO_CHAR(SYSDATE,'RRMMDD')||LPAD(WEFER_MEMBER_SEQ.NEXTVAL,2,#{dept_no}),
    		1234,
    		#{name},
    		#{birth},
    		#{phone},
    		#{email},
    		#{position},
    		#{profile},
    		'퇴근',
    		'12',
    		#{dept_no},
    		SYSDATE,
    		#{address})
	</insert>
	<!-- 회원가입 이메일 중복검사 -->
	<select id="emailChk" parameterType="Member" resultType="arraylist" resultMap="resultMember">
		select email from member where email = #{email} 
	</select>
```
member-maaper에 있는 사원 추가 쿼리문 입니다.

#### ProjectController.java
```jsx
package com.kh.wefer.project.controller;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.kh.wefer.member.model.domain.Member;
import com.kh.wefer.project.model.domain.Project;
import com.kh.wefer.project.model.domain.ProjectComment;
import com.kh.wefer.project.model.domain.ProjectDetail;
import com.kh.wefer.project.model.domain.ProjectMember;
import com.kh.wefer.project.model.domain.ProjectReComment;
import com.kh.wefer.project.model.domain.ProjectSub;
import com.kh.wefer.project.model.service.ProjectService;

import net.sf.json.JSONObject;

@Controller
public class ProjectController {
	@Autowired
	private ProjectService pService;
	
	
	private static final String FILE_SERVER_PATH = "../../.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/wefer/resources/projectFiles";
	//프로젝트 리스트 출력
	@RequestMapping(value = "/projectlist.do", method = RequestMethod.GET)
	public ModelAndView projectList(HttpServletRequest request, ModelAndView mv, ProjectMember pm, ProjectSub ps, Project pid,HttpSession session) {
		String id = (String) session.getAttribute("loginId");
		
		pm.setId(id);
		List<Project> projectLists = new ArrayList<Project>();
		List<ProjectSub> projectSubLists = new ArrayList<ProjectSub>();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
		
		java.sql.Date today = new java.sql.Date(date.getTime());
		System.out.println(today);
		
		
		projectLists = pService.projectList(pm);
		System.out.println(projectLists);
		
		for(int a = 0; a<projectLists.size(); a++) {
			if(projectLists.get(a).getProject_end_date().compareTo(today) < 0) {
				pid.setProject_id(projectLists.get(a).getProject_id());
				pid.setProject_status("종료");
				pService.updateStatus(pid);
			}else if(projectLists.get(a).getProject_end_date().compareTo(today) > 0) {
				pid.setProject_id(projectLists.get(a).getProject_id());
				pid.setProject_status("진행예정");
				pService.updateStatus(pid);
			}

			
		}
		int progress = 0;
		for(int i = 0; i<projectLists.size(); i++) {
			progress = 0;
			ps.setProject_id(projectLists.get(i).getProject_id());
		
			
			projectSubLists = pService.projectProgress(ps);
			int status_range = 100/projectSubLists.size();
			
			for(int a = 0; a<projectSubLists.size(); a++) {
				if(projectSubLists.get(a).getProject_sub_status().equals("진행중")) {
					progress = progress + status_range/2;
				}else if(projectSubLists.get(a).getProject_sub_status().equals("종료")) {
					progress = progress + status_range;
				}else if(projectSubLists.get(a).getProject_sub_status().equals("진행예정")){
					progress = progress + 0;
				}
				
				
			}
			projectLists.get(i).setProgress(progress);
		}
	
		
		mv.addObject("projectLists", projectLists);
		mv.addObject("progress", progress);
		
		mv.setViewName("project/projectList");
		return mv;
	}
	
	
	
	
	
	
	//종료된 프로젝트 리스트 출력
		@RequestMapping(value = "/projectEndlist.do", method = RequestMethod.GET)
		public ModelAndView projectEndlist(HttpServletRequest request, ModelAndView mv, ProjectMember pm, HttpSession session) {
			String id = (String) session.getAttribute("loginId");
			pm.setId(id);
			List<Project> projectLists = new ArrayList<Project>();
			projectLists = pService.projectEndList(pm);
			mv.addObject("projectLists", projectLists);
			mv.setViewName("project/projectEndList");
			return mv;
		}
	
	
	//프로젝트 삭제
	@RequestMapping(value = "/projectDelete.do", method = RequestMethod.POST)
	public void projectDelete(HttpServletResponse response, Project p) {
		PrintWriter out = null;
		JSONObject job = new JSONObject();
		try {
			job.put("ack", pService.projectDelete(p));
			out = response.getWriter();
			out.append(job.toString());
		} catch (Exception e) {
			job.put("ack", -1);
		} finally {
			out.flush();
			out.close();
		}
	}
	//프로젝트 삭제
	@RequestMapping(value = "/projectSubDelete.do", method = RequestMethod.POST)
	public void projectSubDelete(HttpServletResponse response, ProjectSub ps) {
		PrintWriter out = null;
		JSONObject job = new JSONObject();
		try {
			job.put("ack", pService.projectSubDelete(ps));
			System.out.println(response);
			out = response.getWriter();
			out.append(job.toString());
		} catch (Exception e) {
			job.put("ack", -1);
		} finally {
			out.flush();
			out.close();
		}
	}

	//작업출력
	@RequestMapping(value = "/projectDetail.do", method = RequestMethod.GET)
	public ModelAndView projectDetail(@RequestParam(name="id", required = false) String project_id, HttpServletRequest request,
			ModelAndView mv, HttpSession session,HttpServletResponse response, ProjectMember pm, ProjectSub ps, Project p) {
		System.out.println(project_id);
		System.out.println(pService.projectSubList(project_id));
		System.out.println(pService.projectDate(project_id));
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PrintWriter out = null;
		
		int result = 0;
		String id = (String) session.getAttribute("loginId");
		pm.setId(id);
		pm.setProject_id(project_id);
		List<ProjectMember> projectChk = new ArrayList<ProjectMember>();
		List<ProjectMember> projectsub = new ArrayList<ProjectMember>();
		projectChk = pService.projectChk(pm);
	
//		String grade = pService.projectSubChkGrade(id);
//		System.out.println("grade " +  grade);
//		mv.addObject("grade",grade);
		for(int i=0; i<projectChk.size(); i++) {
			if(id.equals(projectChk.get(i).getId().toString())) {
				result = 1;
				break;
			}
			
		}
		if(result == 1) {
			projectsub = pService.projectSubList(project_id);
			
			mv.addObject("projectSubList",projectsub);
			mv.addObject("projectDate", pService.projectDate(project_id));
//			mv.addObject("projectSubMemberList", pService.projectSubMemberList(project_id));
			mv.setViewName("project/projectDetail");
		}else {
			try {
				out = response.getWriter();
				out.append("<script>alert('수정완료.');location.href='projectlist.do'</script>");
				
				out.flush();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
		
		
		return mv;
	}
	//히스토리 화면이동
	@RequestMapping(value = "/projectHistory.do", method = RequestMethod.GET)
	public ModelAndView projectHistory(HttpServletRequest request, HttpServletResponse response,
			HttpSession session, ModelAndView mv, ProjectMember pm, Member m, ProjectDetail pd,
			@RequestParam(name="subid") String subid, @RequestParam(name="pid") String project_id) {
		
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		String id = (String) session.getAttribute("loginId");
		m.setId(id);
		System.out.println(id);
		PrintWriter out = null;
		pm.setProject_sub_id(subid);
		List<ProjectMember> projectMemChk = new ArrayList<ProjectMember>();
		projectMemChk = pService.projectMemberChk(pm);
		int result = 0;

		for(int i = 0; i<projectMemChk.size(); i++) {
			System.out.println(projectMemChk.get(i).getId());
			String a = projectMemChk.get(i).getId();
			if(id.equals(a)) {
				result = 1;
				break;
			}
		}
		System.out.println(result);
		if(result == 1) {
			pd.setProject_id(project_id);
			pd.setProject_sub_id(subid);
			mv.addObject("projectHistoryList", pService.projectHistoryList(pd));
			System.out.println(pService.projectHistoryList(pd));
			System.out.println(pd);
			mv.addObject("projectMemberImg",pService.projectMemberImg(m));
			mv.addObject("projectSubList", pService.projectSubTitles(subid));
			mv.addObject("projectDate", pService.projectDate(project_id));
			mv.addObject("subid",subid);
			mv.setViewName("project/projectHistory");	
			System.out.println("redirect:projectHistory.do?subid="+subid+"&pid="+project_id+"");
		}else {
			try {
				out = response.getWriter();
				out.append("<script>alert('작업인원에 포함되지 않았습니다.');location.href='projectDetail.do?id="+project_id+"'</script>");
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	

		
		//		else {

//		}
			
			

			
		
		return mv;
	}
	
	
	
	
	
	//프로젝트 생성
	@RequestMapping(value = "/projectInsert.do", method = RequestMethod.POST)
	public ModelAndView projectInsert(HttpServletRequest request,HttpSession session, ModelAndView mv, Project p, ProjectSub ps, ProjectMember pm,
			@RequestParam(name="project_title", required = false)String project_title,@RequestParam(name="project_color")String project_color,
			@RequestParam(name="project_std_date")String project_std_date, @RequestParam(name="project_end_date")String project_end_date,
			@RequestParam(name="project_sub_title")String sub_work,@RequestParam(name="id", required = false)String prj_members_id,
			@RequestParam(name="prj_members_id_count")String prj_members_id_count, @RequestParam(name="project_sub_std_date")String project_sub_std_date,
			@RequestParam(name="project_sub_end_date")String project_sub_end_date,@RequestParam(name="project_sub_important")String important) {
		try {
			
	
			String sessoinId = (String) session.getAttribute("loginId");
			
			Date prjEndDate; // 삭제 시작일
			Date prjStartDate; // 삭제 시작일
			Date currentDate; // 현재날짜 Date
			String oTime = ""; // 현재날짜
			String prjStatus = null;

			SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy-MM-dd", Locale.KOREA );

			Date currentTime = new Date();

			oTime = mSimpleDateFormat.format ( currentTime ); //현재시간 (String)

			prjStartDate = mSimpleDateFormat.parse( project_std_date );

			prjEndDate = mSimpleDateFormat.parse( project_end_date );

			currentDate =  mSimpleDateFormat.parse( oTime );

								

			int endCompare = currentDate.compareTo( prjEndDate ); // 날짜비교
			int stdCompare = currentDate.compareTo( prjStartDate ); // 날짜비교
			System.out.println("시작일이 오늘날짜보다 ? " +stdCompare);
			System.out.println("종료일이 오늘날짜보다 ? " +endCompare);

// -1 전     1 후      0 오늘
		
			if (endCompare >= 0 && stdCompare >0){ // 현재날짜가 삭제 시작일 후 인 경우
				prjStatus = "종료";					

			} else if (endCompare < 0 && stdCompare >= 0) { // 현재날짜가 삭제 시작일 전 인 경우

				prjStatus = "진행중";


			} else if(stdCompare <0 && endCompare < 0) { // 현재날짜가 삭제일 인 경우

				prjStatus = "진행예정";
			}
			
			System.out.println("프로젝트 이름" +project_title);
			System.out.println("프로젝트 색" +project_color);
			System.out.println("프로젝트 시작일" +project_std_date);
			System.out.println("프로젝트 종료일" +project_end_date);
			System.out.println("프로젝트 상태" +prjStatus);
			p.setProject_status(prjStatus);
			pService.projectInsert(p);
			

			
			
			//작업제목
			String prj_titles = sub_work.substring(1);
			String[] prj_sub_titles = prj_titles.split(",");
			ArrayList<String> prj_sub_title = new ArrayList<String>(Arrays.asList(prj_sub_titles));
			System.out.println("all: " +prj_sub_title.toString() + prj_sub_title.size());
			
			//작업 중요도
			String[] prj_sub_important = important.split(",");
			ArrayList<String> prj_sub_importants = new ArrayList<String>(Arrays.asList(prj_sub_important));
			System.out.println("all: " +prj_sub_importants.toString());
			

			
			//시작일
			String project_sub_std_dates[] = project_sub_std_date.split(",");
			ArrayList<String> project_sub_std_dates2 = new ArrayList<String>(Arrays.asList(project_sub_std_dates));
			System.out.println("all: " + project_sub_std_dates2.toString());
			
			//종료일
			String project_end_dates[] = project_sub_end_date.split(",");
			ArrayList<String> project_sub_end_dates2 = new ArrayList<String>(Arrays.asList(project_end_dates));
			System.out.println("all: " + project_sub_end_dates2.toString());
			
			
			//작업자
			String prj_members_ids[] = prj_members_id.split(",");
			ArrayList<String> prj_members_group = new ArrayList<String>(Arrays.asList(prj_members_ids));
			System.out.println("all: " + prj_members_group.toString());
			
			//작업자 수
			String prj_members_id_counts[] = prj_members_id_count.split(",");
	
			
			Date prjStartDate2; // 삭제 시작일
			Date prjEndDate2; // 삭제 시작일
			Date currentDate2; // 현재날짜 Date
			String oTime2 = ""; // 현재날짜
			String prjStatus2 = null;

			SimpleDateFormat mSimpleDateFormat2 = new SimpleDateFormat ( "yyyy-MM-dd", Locale.KOREA );

			Date currentTime2 = new Date();

			
			
			

			System.out.println("eee :"+ prj_sub_title.size());
			for(int i = 0; i < prj_sub_title.size(); i++) {
				oTime2 = mSimpleDateFormat2.format ( currentTime2 ); //현재시간 (String)



				prjStartDate2 = mSimpleDateFormat2.parse( project_sub_std_dates2.get(i) );
				prjEndDate2 = mSimpleDateFormat2.parse( project_sub_end_dates2.get(i) );

				currentDate2=  mSimpleDateFormat2.parse( oTime2 );

									

				int stdCompare2 = currentDate2.compareTo( prjStartDate2 ); // 날짜비교
				int endCompare2 = currentDate2.compareTo( prjEndDate2 ); // 날짜비교

				if (endCompare2 >= 0 && stdCompare2 >0){ // 현재날짜가 삭제 시작일 후 인 경우
					prjStatus2 = "종료";					

				} else if (endCompare2 < 0 && stdCompare2 >= 0) { // 현재날짜가 삭제 시작일 전 인 경우

					prjStatus2 = "진행중";


				} else if(stdCompare2 <0 && endCompare2 < 0) { // 현재날짜가 삭제일 인 경우

					prjStatus2 = "진행예정";
				}


				
				String std = project_sub_std_dates2.get(i);
				String end = project_sub_end_dates2.get(i);
				Date tempDate = null;
				Date tempDate2 = null;
				
				SimpleDateFormat datetransfer = new SimpleDateFormat("yyyy-mm-dd");
				tempDate = datetransfer.parse(std);
				
				tempDate2 = datetransfer.parse(end);
				
				
				System.out.println("aaa" + tempDate);
				System.out.println("bbb" + tempDate2);
				String toTempDate = datetransfer.format(tempDate);
				String toTempDate2 = datetransfer.format(tempDate2);

				java.sql.Date reTempDate = java.sql.Date.valueOf(toTempDate);
				java.sql.Date reTempDate2 = java.sql.Date.valueOf(toTempDate2);
				ps.setProject_sub_title(prj_sub_title.get(i));
				ps.setProject_sub_important(prj_sub_importants.get(i));
				ps.setProject_sub_std_date(reTempDate);
				ps.setProject_sub_end_date(reTempDate2);
				ps.setProject_sub_status(prjStatus2);
				pService.projectSubInsert(ps);
				
					
				int a[] = null;
			
					a = new int[prj_sub_title.size()];
					a[i] = Integer.parseInt(prj_members_id_counts[i]); //2 3
					
					for(int j=0; j<a[i]; j++) {
						System.out.println(prj_members_group.get(0));
						pm.setId(prj_members_group.get(0));
						//여기서 세션아이디 비교
						if(prj_members_group.get(0).equals(sessoinId)) {
							pm.setProject_member_grade(1);
							
						}else {
							pm.setProject_member_grade(0);							
						}
						pService.projectSubMember(pm);
						prj_members_group.remove(0); 
						
					}

				
			}
			

			System.out.println("성공");
			mv.setViewName("redirect:projectlist.do");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("실패");
			mv.addObject("message", e.getMessage());
			mv.setViewName("project/projectlist.do");
		}

		return mv;
	}
	
	//프로젝트  작업 수정
		@RequestMapping(value = "/projectSubUpdate.do", method = RequestMethod.POST)
		public ModelAndView projectSubUpdate(HttpServletRequest request, ModelAndView mv, ProjectSub ps, ProjectMember pm, Project p,
				@RequestParam(name="p_pid") String p_pid, 
				@RequestParam(name="project_sub_id_update") String prj_update_id, 
				@RequestParam(name="project_sub_title_update") String project_update_title, 
				@RequestParam(name="project_std_date_update") String project_std_update_date,
				@RequestParam(name="project_end_date_update") String project_end_update_date,
				@RequestParam(name="update_important") String update_important,
				@RequestParam(name="prj_member_id_update",required = false) String prj_member_id_update
				){
				
				
				
			Date prjStartDate; // 삭제 시작일
			Date prjEndDate; // 삭제 시작일
			Date currentDate; // 현재날짜 Date
			String oTime = ""; // 현재날짜
			String prjStatus = null;

			SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy-MM-dd", Locale.KOREA );

			Date currentTime = new Date();
			try {
			
				java.sql.Date project_std_update =java.sql.Date.valueOf(project_std_update_date);	
				java.sql.Date project_end_update =java.sql.Date.valueOf(project_end_update_date);	
				oTime = mSimpleDateFormat.format ( currentTime ); //현재시간 (String)
	
				
				prjEndDate = mSimpleDateFormat.parse( project_end_update_date );
				prjStartDate = mSimpleDateFormat.parse(project_std_update_date);

				currentDate =  mSimpleDateFormat.parse( oTime );

									

				int stdCompare = currentDate.compareTo( prjStartDate ); // 날짜비교
				int endCompare = currentDate.compareTo( prjEndDate ); // 날짜비교


				if (endCompare >= 0 && stdCompare >0){ // 현재날짜가 삭제 시작일 후 인 경우
					prjStatus = "종료";					

				} else if (endCompare < 0 && stdCompare >= 0) { // 현재날짜가 삭제 시작일 전 인 경우

					prjStatus = "진행중";


				} else if(stdCompare <0 && endCompare < 0) { // 현재날짜가 삭제일 인 경우

					prjStatus = "진행예정";
				}
				
				if(prj_member_id_update == null || prj_member_id_update.equals("")) {
					ps.setProject_id(p_pid);
					ps.setProject_sub_id(prj_update_id);
					ps.setProject_sub_title(project_update_title);
					ps.setProject_sub_std_date(project_std_update);
					ps.setProject_sub_end_date(project_end_update);
					ps.setProject_sub_important(update_important);
					ps.setProject_sub_status(prjStatus);
					System.out.println("멤버없음");
					pService.projectSubUpdate(ps);
					
				}else {
					ps.setProject_id(p_pid);
					ps.setProject_sub_id(prj_update_id);
					ps.setProject_sub_title(project_update_title);
					ps.setProject_sub_std_date(project_std_update);
					ps.setProject_sub_end_date(project_end_update);
					ps.setProject_sub_important(update_important);
					ps.setProject_sub_status(prjStatus);
					pService.projectSubUpdate(ps);
					
					//프로잭트 멤버 추가
					pm.setId(prj_member_id_update);
					pm.setProject_sub_id(prj_update_id);
					pm.setProject_id(p_pid);
					pService.projectSubUpdateInsertMember(pm);
				}
				
				
				mv.setViewName("redirect:projectDetail.do?id="+p_pid+"");
			

				System.out.println("성공");
				
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("실패");
				mv.addObject("message", e.getMessage());
				mv.setViewName("redirect:projectlist.do");
			}

			return mv;
		}
		
		//작업 추가
		@RequestMapping(value = "/projectSubInsert.do", method = RequestMethod.POST)
		public ModelAndView projectSubInsert(HttpServletRequest request, HttpSession session, RedirectAttributes redirect, ModelAndView mv, ProjectSub ps, ProjectMember pm,
				@RequestParam(name="pid") String project_id,
				@RequestParam(name="project_sub_title")String sub_work,
				@RequestParam(name="id", required = false)String prj_members_id,
				@RequestParam(name="prj_members_id_count")String prj_members_id_count,
				@RequestParam(name="project_sub_std_date")String project_sub_std_date,
				@RequestParam(name="project_sub_end_date")String project_sub_end_date,
				@RequestParam(name="project_sub_important")String important) {
				System.out.println(project_id);
				System.out.println(sub_work);
				System.out.println(prj_members_id);
				System.out.println(prj_members_id_count);
				System.out.println(project_sub_std_date);
				System.out.println(project_sub_end_date);
				System.out.println(important);
				
				//작업제목
				String prj_titles = sub_work.substring(1);
				String[] prj_sub_titles = prj_titles.split(",");
				ArrayList<String> prj_sub_title = new ArrayList<String>(Arrays.asList(prj_sub_titles));
				System.out.println("all: " +prj_sub_title.toString() + prj_sub_title.size());
				
				//작업 중요도
				String[] prj_sub_important = important.split(",");
				ArrayList<String> prj_sub_importants = new ArrayList<String>(Arrays.asList(prj_sub_important));
				System.out.println("all: " +prj_sub_importants.toString());
				

				
				//시작일
				String project_sub_std_dates[] = project_sub_std_date.split(",");
				ArrayList<String> project_sub_std_dates2 = new ArrayList<String>(Arrays.asList(project_sub_std_dates));
				System.out.println("all: " + project_sub_std_dates2.toString());
				
				//종료일
				String project_end_dates[] = project_sub_end_date.split(",");
				ArrayList<String> project_sub_end_dates2 = new ArrayList<String>(Arrays.asList(project_end_dates));
				System.out.println("all: " + project_sub_end_dates2.toString());
				
				
				//작업자
				String prj_members_ids[] = prj_members_id.split(",");
				ArrayList<String> prj_members_group = new ArrayList<String>(Arrays.asList(prj_members_ids));
				System.out.println("all: " + prj_members_group.toString());
				
				//작업자 수
				String prj_members_id_counts[] = prj_members_id_count.split(",");
		
				
				Date prjStartDate2; // 삭제 시작일
				Date prjEndDate2; // 삭제 시작일
				Date currentDate2; // 현재날짜 Date
				String oTime2 = ""; // 현재날짜
				String prjStatus2 = null;

				SimpleDateFormat mSimpleDateFormat2 = new SimpleDateFormat ( "yyyy-MM-dd", Locale.KOREA );

				Date currentTime2 = new Date();

				
				
				

				



					try {
						for(int i = 0; i < prj_sub_title.size(); i++) {
						oTime2 = mSimpleDateFormat2.format ( currentTime2 ); //현재시간 (String)
						
						prjStartDate2 = mSimpleDateFormat2.parse( project_sub_std_dates2.get(i) );
						prjEndDate2 = mSimpleDateFormat2.parse( project_sub_end_dates2.get(i) );
						
						currentDate2=  mSimpleDateFormat2.parse( oTime2 );
						int stdCompare2 = currentDate2.compareTo( prjStartDate2 ); // 날짜비교
						int endCompare2 = currentDate2.compareTo( prjEndDate2 ); // 날짜비교
						
						
						
						

						if (endCompare2 >= 0 && stdCompare2 >0){ // 현재날짜가 삭제 시작일 후 인 경우
							prjStatus2 = "종료";					

						} else if (endCompare2 < 0 && stdCompare2 >= 0) { // 현재날짜가 삭제 시작일 전 인 경우

							prjStatus2 = "진행중";


						} else if(stdCompare2 <0 && endCompare2 < 0) { // 현재날짜가 삭제일 인 경우

							prjStatus2 = "진행예정";
						}


						
						
						String std = project_sub_std_dates2.get(i);
						String end = project_sub_end_dates2.get(i);
						Date tempDate = null;
						Date tempDate2 = null;
						
						SimpleDateFormat datetransfer = new SimpleDateFormat("yyyy-mm-dd");
						tempDate = datetransfer.parse(std);
						
						tempDate2 = datetransfer.parse(end);
						
						
						System.out.println("aaa2" + tempDate);
						System.out.println("bbb2" + tempDate2);
						String toTempDate = datetransfer.format(tempDate);
						String toTempDate2 = datetransfer.format(tempDate2);

						java.sql.Date reTempDate = java.sql.Date.valueOf(toTempDate);
						java.sql.Date reTempDate2 = java.sql.Date.valueOf(toTempDate2);
						ps.setProject_id(project_id);
						ps.setProject_sub_title(prj_sub_title.get(i));
						ps.setProject_sub_important(prj_sub_importants.get(i));
						ps.setProject_sub_std_date(reTempDate);
						ps.setProject_sub_end_date(reTempDate2);
						ps.setProject_sub_status(prjStatus2);
						pService.projectSubAdd(ps);
						
							
						int a[] = null;
						String loginId = (String) session.getAttribute("loginId");
							a = new int[prj_sub_title.size()];
							a[i] = Integer.parseInt(prj_members_id_counts[i]); //2 3
							
	
							for(int j=0; j<a[i]; j++) {
								System.out.println(prj_members_group.get(0));
								pm.setId(prj_members_group.get(0));
								pm.setProject_id(project_id);
								//여기서 세션아이디 비교
								if(loginId.equals(prj_members_group.get(0))) {
									pm.setProject_member_grade(1);									
								}else {
									pm.setProject_member_grade(0);
								}
								pService.projectSubAddMember(pm);
								prj_members_group.remove(0); 
								
							}
							 redirect.addAttribute("id", project_id); 
							
							mv.setViewName("redirect:projectDetail.do");

						
					}
					} catch (ParseException e) {
						System.out.println("aaaaaa");
						e.printStackTrace();
					}


										

					
				
				
			return mv;
		}
		
		//프로젝트 수정
				@RequestMapping(value = "/projectUpdate.do", method = RequestMethod.POST)
				public ModelAndView projectUpdate(HttpServletRequest request, ModelAndView mv, ProjectSub ps, ProjectMember pm, Project p,
						@RequestParam(name="prj_update_id") String prj_update_id, 
						@RequestParam(name="project_update_title") String project_update_title, 
						@RequestParam(name="project_std_update_date") String project_std_update_date,
						@RequestParam(name="project_end_update_date") String project_end_update_date
						){
						
					if(project_std_update_date == null || project_end_update_date == null) {
						p.setProject_id(prj_update_id);
						p.setProject_title(project_update_title);
						pService.updateTitleProject(p);
					}else {
						Date prjStartDate; // 삭제 시작일
						Date prjEndDate; // 삭제 시작일
						Date currentDate; // 현재날짜 Date
						String oTime = ""; // 현재날짜
						String prjStatus = null;
	
						SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy-MM-dd", Locale.KOREA );
	
						Date currentTime = new Date();
						try {
							
								java.sql.Date project_std_update =java.sql.Date.valueOf(project_std_update_date);	
								java.sql.Date project_end_update =java.sql.Date.valueOf(project_end_update_date);	
								oTime = mSimpleDateFormat.format ( currentTime ); //현재시간 (String)
	
	
	
						
								
								
								prjEndDate = mSimpleDateFormat.parse( project_end_update_date );
								prjStartDate = mSimpleDateFormat.parse(project_std_update_date);
	
								currentDate =  mSimpleDateFormat.parse( oTime );
	
													
	
								int stdCompare = currentDate.compareTo( prjStartDate ); // 날짜비교
								int endCompare = currentDate.compareTo( prjEndDate ); // 날짜비교
	
								if (endCompare >= 0 && stdCompare >0){ // 현재날짜가 삭제 시작일 후 인 경우
									prjStatus = "종료";					
	
								} else if (endCompare < 0 && stdCompare >= 0) { // 현재날짜가 삭제 시작일 전 인 경우
	
									prjStatus = "진행중";
	
	
								} else if(stdCompare <0 && endCompare < 0) { // 현재날짜가 삭제일 인 경우
	
									prjStatus = "진행예정";
								}
								
									p.setProject_id(prj_update_id);
									p.setProject_title(project_update_title);
									p.setProject_std_date(project_std_update);
									p.setProject_end_date(project_end_update);
									p.setProject_status(prjStatus);
									pService.updateProject(p);
									
									mv.setViewName("redirect:projectlist.do");
							
						
	
							System.out.println("성공");
							
						}catch (Exception e) {
							e.printStackTrace();
							System.out.println("실패");
							mv.addObject("message", e.getMessage());
							mv.setViewName("project/projectlist.do");
						}
					
					}

					return mv;
				}
				
				
				//프로젝트 히스토리 작성
				@RequestMapping(value = "/historyInsert.do", method = RequestMethod.POST)
				public ModelAndView historyInsert(ProjectDetail pd, 
						@RequestParam(name = "upload_project_file", required = false) MultipartFile report, @RequestParam(name="pid") String pid,
						@RequestParam(name="psid", required = false) String psid, 
						@RequestParam(name="sessionId") String id, 
						@RequestParam(name="project_datail_content") String project_datail_content,
						@RequestParam(name="stauts") String stauts,
						HttpServletRequest request, ModelAndView mv) {
					try {
						if (report != null && !report.equals("")) {
							saveFile(report, request);
							System.out.println(pid);
							System.out.println(psid);
						
							pd.setProject_datail_file(report.getOriginalFilename());
							pd.setId(id);
							pd.setProject_datail_status(stauts);
							pd.setProject_datail_content(project_datail_content);
							pd.setProject_id(pid);
							pd.setProject_sub_id(psid);
							System.out.println("pdpd : " +pd);
							pService.historyInsert(pd);
							
							mv.setViewName("redirect:projectHistory.do?subid="+psid+"&pid="+pid+"");
						}else {
							pd.setId(id);
							pd.setProject_datail_status(stauts);
							pd.setProject_datail_content(project_datail_content);
							pd.setProject_id(pid);
							pd.setProject_sub_id(psid);
							pService.historyInsert(pd);
							mv.setViewName("redirect:projectHistory.do?subid="+psid+"&pid="+pid+"");
						}
							
					} catch (Exception e) {
						e.printStackTrace();
					}
					return mv;
				}
				
				//프로젝트 히스토리 업데이트
				@RequestMapping(value = "/projectHistoryUpdate.do", method = RequestMethod.POST)
				public ModelAndView projectHistoryUpdate(ProjectDetail pd, 
						@RequestParam(name = "update_file", required = false) MultipartFile report, 
						@RequestParam(name="pid") String pid,
						@RequestParam(name="subid", required = false) String subid,
						@RequestParam(name="update_content") String project_datail_content,
						@RequestParam(name="update_stauts") String stauts,
						@RequestParam(name="pdid") String project_datail_id,
						HttpServletRequest request, ModelAndView mv) {
					try {
						
						//현재 project_datail_id에 저장된 파일명을 가져와지운다
						//view에서 가져온 파일명을 업데이트(저장) 시켜준다.
						//리스트에 반환한다.
						
						String befor_file = pService.historyFileName(project_datail_id);
						System.out.println("befor_file : "+befor_file);
						if (report != null && !report.equals("")) {
							removeFile(befor_file, request);
							saveFile(report, request);
							System.out.println(pid);
							System.out.println(subid);
						
							pd.setProject_datail_file(report.getOriginalFilename());
							pd.setProject_datail_status(stauts);
							pd.setProject_datail_content(project_datail_content);
							pd.setProject_datail_id(project_datail_id);
							pService.historyUpdateFile(pd);
							mv.setViewName("redirect:projectHistory.do?subid="+subid+"&pid="+pid+"");
						}else {
							mv.setViewName("redirect:projectHistory.do?subid="+subid+"&pid="+pid+"");							
						}
							
					} catch (Exception e) {
						e.printStackTrace();
					}
					return mv;
				}

					//히스토리 삭제
					@RequestMapping(value = "/projectHistoryDelete.do", method = RequestMethod.POST)
					@ResponseBody
					public Map<String, Object> projectHistoryDelete(HttpServletResponse response, HttpServletRequest request, ProjectDetail pd) {
						Map<String, Object> map = new HashMap<String, Object>();
						try {
							request.setCharacterEncoding("UTF-8");
							response.setContentType("text/html; charset=UTF-8");
							String project_datail_id = pd.getProject_datail_file();
							String file = pService.historyFileName(project_datail_id);
							removeFile(file, request);
							pService.projectHistoryDelete(pd);
							map.put("sucess", "성공");
							
							
						} catch (Exception e) {
							map.put("fail", "실패");
							
						}
						return map;
					}
					//댓글삭제
					@RequestMapping(value = "/projectCommentDelete.do", method = RequestMethod.POST)
					@ResponseBody
					public Map<String, Object> projectCommentDelete(HttpServletResponse response,HttpSession session, HttpServletRequest request, ProjectComment pc) {
						Map<String, Object> map = new HashMap<String, Object>();
						try {
							String name = (String) session.getAttribute("loginId");
							System.out.println("세션이름" + name);
							
							request.setCharacterEncoding("UTF-8");
							response.setContentType("text/html; charset=UTF-8");
							String project_comment_id = pc.getProject_comment_id();
							System.out.println(project_comment_id);
							System.out.println(pc.getId());
							if(name.equals(pc.getId())) {
								int delAck = pService.projectCommentDelete(pc);
								if(delAck == 1) {
									map.put("sucess", "삭제되었습니다");								
								}else {
									map.put("fail", "실패하였습니다");								
									
								}
							}else {
								map.put("fail", "작성자만 삭제 할 수 있습니다.");			
							}
							
							
							
						} catch (Exception e) {
							map.put("fail", "실패하였습니다.");
							
						}
						return map;
					}
					//대댓글삭제
					@RequestMapping(value = "/projectReCommentDelete.do", method = RequestMethod.POST)
					@ResponseBody
					public Map<String, Object> projectReCommentDelete(HttpServletResponse response,HttpSession session, HttpServletRequest request, ProjectReComment prc) {
						Map<String, Object> map = new HashMap<String, Object>();
						try {
							String name = (String) session.getAttribute("loginId");
							System.out.println("세션이름" + name);
							
							request.setCharacterEncoding("UTF-8");
							response.setContentType("text/html; charset=UTF-8");
							String project_recomment_id = prc.getProject_recomment_id();
							System.out.println(project_recomment_id);
							System.out.println(prc.getId());
							if(name.equals(prc.getId())) {
								int delAck = pService.projectReCommentDelete(prc);
								if(delAck == 1) {
									map.put("sucess", "삭제되었습니다");								
								}else {
									map.put("fail", "실패하였습니다");								
									
								}
							}else {
								map.put("fail", "작성자만 삭제 할 수 있습니다.");			
							}
							
							
							
						} catch (Exception e) {
							map.put("fail", "실패하였습니다.");
							
						}
						return map;
					}
					
					//댓글입력
					@RequestMapping(value = "/projecthistoryComment.do", method = RequestMethod.POST)
					@ResponseBody
					public Map<String, Object> projecthistoryComment(HttpServletResponse response, HttpServletRequest request, ProjectComment pc) {
						Map<String, Object> map = new HashMap<String, Object>();
						try {
							request.setCharacterEncoding("UTF-8");
							response.setContentType("text/html; charset=UTF-8");
							if(pc.getProject_comment_content()== null || pc.getProject_comment_content().equals("")) {
								map.put("fail", "댓글을 입력해 주세요.");
							}else {
								String getProject_comment_content = pc.getProject_comment_content();
								String getProject_datail_id = pc.getProject_datail_id();
								String getId = pc.getId();
								
								System.out.println(getProject_comment_content);
								System.out.println(getProject_datail_id);
								System.out.println(getId);
								List<ProjectComment> pcList = new ArrayList<ProjectComment>();
								int a = pService.projectCommentWirte(pc);
								System.out.println("성공?: "  +a);
								if(a == 1) {
									pcList = pService.projectCommentInsertList(pc);
									System.out.println(pcList);
									map.put("success", "성공");
									map.put("commentList", pcList);
									
								}else if(a==0) {
									map.put("fail", "실패");
								}
							}
							
							
							
							
							
						} catch (UnsupportedEncodingException e) {
							map.put("fail", "실패");						
						}
						
						return map;
					}
					
					//댓글리스트
					@RequestMapping(value = "/projecthistoryCommentList.do", method = RequestMethod.POST)
					@ResponseBody
					public Map<String, Object> projecthistoryCommentList(HttpServletResponse response, HttpServletRequest request, ProjectComment pc) {
						Map<String, Object> map = new HashMap<String, Object>();
						try {
							request.setCharacterEncoding("UTF-8");
							response.setContentType("text/html; charset=UTF-8");
								String getProject_datail_id = pc.getProject_datail_id();
								String getId = pc.getId();
								
								System.out.println(getProject_datail_id);
								System.out.println(getId);
								List<ProjectComment> pcList = new ArrayList<ProjectComment>();
								
									pcList = pService.projectCommentList(pc);
									System.out.println(pcList);
									map.put("success", "성공");
									
									map.put("commentList", pcList);
									/*
									 * select a.*, b.name, r.project_recomment_content, b.profile from
									 * project_recomment r, project_comment a, member b where r.id = b.id and
									 * a.project_comment_id = r.project_comment_id and a.project_datail_id='64';
									 */

						} catch (UnsupportedEncodingException e) {
							map.put("fail", "실패");						
						}
						
						return map;
					}
					
					
					//대댓글 입력
					@RequestMapping(value = "/projecthistoryReCommentInsert.do", method = RequestMethod.POST)
					@ResponseBody
					public Map<String, Object> projecthistoryReCommentInsert(HttpServletResponse response, HttpServletRequest request, ProjectReComment prc) {
						Map<String, Object> map = new HashMap<String, Object>();
						try {
							request.setCharacterEncoding("UTF-8");
							response.setContentType("text/html; charset=UTF-8");
							if(prc.getProject_recomment_content()== null || prc.getProject_recomment_content().equals("")) {
								map.put("fail", "댓글을 입력해 주세요.");
							}else {
								String getProject_comment_id = prc.getProject_recomment_content();
								String project_recomment_content = prc.getProject_comment_id();
								String getId = prc.getId();
								
								System.out.println(getProject_comment_id);
								System.out.println(project_recomment_content);
								System.out.println(getId);
								List<ProjectReComment> prcList = new ArrayList<ProjectReComment>(); 
								try {
									pService.projecthistoryReCommentInsert(prc);
									System.out.println("인서트 성공!");
									prcList =pService.projectreReCommentInsertList(prc); 
									System.out.println(prcList);
									System.out.println("aaa");
									  map.put("success", "성공");
									  map.put("recommentList", prcList);
								}catch (Exception e) {
									 map.put("fail", "실패"); 
								}
								
								  
								  
								 
							}
							
							
							
							
							
						} catch (UnsupportedEncodingException e) {
							map.put("fail", "실패");						
						}
						
						return map;
					}
				
					//대댓글 리스트 ajax
					@RequestMapping(value = "/projecthistoryReCommentList.do", method = RequestMethod.POST)
					@ResponseBody
					public Map<String, Object> projecthistoryReCommentList(HttpServletResponse response, HttpServletRequest request, ProjectReComment prc) {
						Map<String, Object> map = new HashMap<String, Object>();
						try {
								request.setCharacterEncoding("UTF-8");
								response.setContentType("text/html; charset=UTF-8");
							
								String getProject_comment_id = prc.getProject_comment_id();
								
								System.out.println("a" + getProject_comment_id);
								
								List<ProjectReComment> prcList = new ArrayList<ProjectReComment>();
								prcList = pService.projectReCommentList(prc);
								System.out.println("댓글 리스트 : " + prcList.size());
								map.put("recommentList", prcList);

						} catch (UnsupportedEncodingException e) {
							map.put("fail", "실패");						
						}
						
						return map;
					}
					
					
				//파일저장
				private void saveFile(MultipartFile report, HttpServletRequest request) {
					String root = request.getSession().getServletContext().getRealPath("resources");
					String savePath = root + "\\projectFiles";
					File folder = new File(savePath);
					if (!folder.exists()) {
						folder.mkdir(); // 폴더가 없다면 생성한다.
					}
					String filePath = null;
					try {
						// 파일 저장
						
						filePath = folder + "\\" + report.getOriginalFilename();
						report.transferTo(new File(filePath)); // 파일을 저장한다
						
					} catch (Exception e) {
						
					}
				}
				//파일삭제
				private void removeFile(String project_file, HttpServletRequest request) {
					String root = request.getSession().getServletContext().getRealPath("resources");
					String savePath = root + "\\uploadFiles";

					String filePath = savePath + "\\" + project_file;
					try {
						// 파일 저장
						File delFile = new File(filePath);
						delFile.delete();

						System.out.println("파일 삭제가 완료되었습니다.");
					} catch (Exception e) {
						System.out.println("파일 삭제 에러 : " + e.getMessage());
					}
				}
				//파일 다운로드
				@RequestMapping("/download.do")
				public ModelAndView download(@RequestParam HashMap<Object, Object> params, ModelAndView mv) {
					String fileName = (String) params.get("fileName");
					String fullPath = FILE_SERVER_PATH + "/" + fileName;
					File file = new File(fullPath);
					
					mv.setViewName("downloadView");
					mv.addObject("downloadFile", file);
					return mv;
				}
}

```

프로젝트 관련 Controller 소스코드입니다. Service나 Dao에서의 작업은 없어 Controller소스만 올리겠습니다.
주로 프로젝트 기간 관련된 계산으로 진행중인지 종료중인 프로젝트인지 나누는 소스코드와 삭제 수정 불러오기 코드들이 있습니다.
파일 업로드 다운로드 기능도 구현하였습니다.
#### MemberController.java
```jsx
	 //이메일 중복확인 ajax
	 @RequestMapping(value = "/emailChk.do", method = RequestMethod.POST)
	 @ResponseBody
	 public Object emailChk(HttpServletResponse response, HttpServletRequest request, Member m) {
		List<Member> mlist = new ArrayList<Member>();
		int result = 0;
		mlist = mService.emailChk(m);
		System.out.println("호출");
		System.out.println(mlist.size());
		if(mlist.size() > 0) {
			result = 1;
		}
		return result;
	}

	//사원 입력 메서드
	@RequestMapping(value = "/insertmember.do", method = RequestMethod.POST)
	public ModelAndView insertmember(Member m,HttpServletRequest request,@RequestParam(name="profileimg")MultipartFile report, ModelAndView mv) throws IOException {
		
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\profileImg";
		File folder = new File(savePath);
		saveFile(report, request);
		String filePath = null;
		filePath = folder + "\\" + report.getOriginalFilename();
		try {
			// 파일저장
			System.out.println(report.getOriginalFilename() + "을 저장합니다.");
			System.out.println("저장 경로 : " + savePath);
			filePath = folder + "\\" + report.getOriginalFilename();
			report.transferTo(new File(filePath)); // 파일을 저장한다
			System.out.println("파일명 : " + report.getOriginalFilename());
			System.out.println("파일 경로 : " + filePath);
			System.out.println("파일 전송이 완료되었습니다.");
		} catch (Exception e) {
			System.out.println("파일 전송 에러 : " + e.getMessage());
		}
		m.setProfile(report.getOriginalFilename());
		mService.insertMember(m);
		mv.setViewName("redirect:memberlist");
		return mv;
	}
```
이메일 중복확인 메서드는 비동기로 통신하여 요청단에 0과 1의 결과값을 전달하도록 구현하였습니다.
사원정보 입력을 위한 메서드 입니다. 
입력 시 회원의 프로필 사진을 가져와 저장 하도록 구현 하였습니다.


