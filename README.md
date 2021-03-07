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
