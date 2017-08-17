<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" >
	$(function(){
		
		$("#txtName").blur(function(){
			$.post("ajax.do",{'name':$("#txtName").val()},function(data){
				alert(data);
			});
		});
		
		$("#btn").click(function(){
			$.post("json.do",function(data){
				alert(data);
				var html="";
				for(var i=0;i<data.length;i++){
					html+="<tr><td>"+data[i].id+"</td><td>"+data[i].name+"</td><td>"+data[i].pwd+"</td></tr>"
				}
				$("#tbody").html(html);
			});
		});
	});
</script>
</head>
<body>
	用户名：<input type="text" name="txtName" id="txtName">
	
	<input type="button" id="btn" value="get..."/>
	
	<table width="80%" align="center">
		<thead>
			<tr>
				<td>编号</td>
				<td>用户名</td>
				<td>密码</td>
			</tr>
		</thead>
		<tbody id="tbody">
		
		</tbody>
	</table>
	
</body>
</html>