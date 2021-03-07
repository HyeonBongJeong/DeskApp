- # fine semiPrj
## :pushpin: DESK APP :pushpin:
협업을 위한 그룹웨어

2020.12 ~ 2021.01

## :mag: Project

#### 개요
사내에서 사용하는 업무메신저를 확장하여 각각의 프로젝트에 인원을 추가할수 있고 진행상황과 서로의 스케줄을 공유하기 위해 만들었습니다. 

#### 주요기능
- 


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
 ### insertmember.jsp script
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
 ![Display_3](https://user-images.githubusercontent.com/69295153/106435685-8bf75600-64b6-11eb-81c4-ad88c39d3b55.png)
 payment_confirm테이블과 payment_comment테이블은 payment테이블의 payment_id가 외래키로 있으며 해당 게시글을 들어갔을때 출력되는 테이블입니다. 
 annual테이블과 conference테이블은 작성자 id로 외래키가 걸려있으며, 작성자 id는 멤버테이블의 컬럼입니다. 
 anuual테이블 혹은 conference테이블에서 글을 작성했을시 작성자 id가 payment테이블의 id에 등록되며, 자동으로 payment_id시퀀스가 증가합니다. 
 payment를 작성했을시 결재를 참조해줄 참조자 3인이 payment_confirm테이블의 S_member에 각각 들어가며, 한명이 승인을 해줄때마다 confrim의 값이 +2가되어 confirm 컬럼의 값이 6이되면
 payment의 status가 진행중에서 승인으로 update됩니다.  

```jsx

```
로그인한 사용자가 작성하거나, 수신받은 결재리스트를 뽑아오는 쿼리문입니다. paymentList에서는 현재 로그인한 사용자가 발신한 모든 결재를 출력하며, receive-paymentList에서는 payment-confirm테이블에 로그인한 사용자의 이름이 하나라도 있는 경우 출력하는 쿼리문입니다. 

```jsx
	
```
결재 승인여부를 확인하고 상태를 변경하는 쿼리문입니다. S_member가 한명씩 승인할때마다 2씩카운트를하며 전체의 총합이 6이되면 진행중에서 승인으로 변경되도록 했습니다. 
```jsx

```
annual인서트시, 로그인한 사용자의 아이디 값과, 외래키로 적용되어있는 payment_id를 모두 파라메터로 들고가야하는 애로사항이 있었습니다. 
따라서 insert시 SEQ_PAYMENT_ANNUAL 시퀀스만을 select한후 아래와 같이 DAO와 Sevice에서 적용시켰습니다. 
#### AnnualDao.java
```jsx

```
AnnualService.java
```jsx

```
#### EchoHandler.java
```jsx

```
사용자가 접속했다면 모든 사용자에게 접속중임을 알리며, 수신 참조자로 선택됐을시에는 해당 사용자에게만 알림을 보내는 소스 코드입니다. 
