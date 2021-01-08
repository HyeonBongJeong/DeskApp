<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KIVIEW &mdash; �۾���</title>
<!-- SmartEditor2 ���̺귯�� -->
<script type="text/javascript"
	src="./resources/src/se/js/HuskyEZCreator.js" charset="utf-8"></script>
<!-- Jquery CDN -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
	<!-- SmartEditor2 -->
	<div class="jsx-2303464893 editor">
		<div class="fr-box fr-basic fr-top" role="application">
			<div class="fr-wrapper show-placeholder" dir="auto"
				style="overflow: scroll;">
				<textarea name="annual_content" id="smartEditor"
					style="width: 100%; height: 412px;"></textarea>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		var oEditors = [];
		nhn.husky.EZCreator.createInIFrame({
			oAppRef : oEditors,
			elPlaceHolder : "smartEditor",
			sSkinURI : "./resources/src/se/SmartEditor2Skin.html", //��θ� �� �����ּ���! 
			fCreator : "createSEditor2",
			htParams : { // ���� ��� ���� (true:���/ false:������� ����)
				bUseToolbar : true, // �Է�â ũ�� ������ ��� ���� (true:���/ false:������� ����) 
				bUseVerticalResizer : false, // ��� ��(Editor | HTML | TEXT) ��� ���� (true:���/ false:������� ����) 
				bUseModeChanger : false
			}
		});
		$(function() {
			$("#savebutton").click(function() {
								oEditors.getById["smartEditor"].exec("UPDATE_CONTENTS_FIELD", []);
								$("#frm").submit();
							});
		})
	</script>
</body>
</html>

