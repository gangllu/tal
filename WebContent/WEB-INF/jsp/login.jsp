<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name=”renderer” content=”webkit” />
<meta http-equiv="X-UA-Compatible" content ="IE=edge,chrome=1" /> 
<title>登录</title>
<%
	String path = request.getContextPath();
	request.setAttribute("path", path);
%>
<%@include file="common.jsp"  %>
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="${path }/bootstrap/css/bootstrap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${path }/dist/css/AdminLTE.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="${path }/plugins/iCheck/square/blue.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
    <a href="${path }/index2.html"><b>${systemName }</b></a>
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body">

    <form action="${path }/index2.html" method="post">
      <div class="form-group has-feedback">
        <input id="userName" type="text" class="form-control" placeholder="用户名">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input id="password" type="password" class="form-control" placeholder="密码">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="text-center">
        <div>
          <a class="btn btn-primary btn-block btn-flat" onclick="sigin()">登录</a>
        </div>
        <!-- /.col -->
      </div>
    </form>
    <br/>
    <div class="text-center">
      <a href="showSignUp" class="btn bg-orange btn-block btn-flat">注册</a>
    </div>
    <!-- /.social-auth-links -->
    <br>
    <a href="#">忘记密码</a><br>
    <br/><br/><br/><br/>
  </div>
  <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<!-- jQuery 2.2.3 -->
<script src="${path }/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="${path }/bootstrap/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="${path }/plugins/iCheck/icheck.min.js"></script>
<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' // optional
    });
  });
  
  function signin(){
	  var userName = $("#userName").val();
	  var password = $("#password").val();
	  if(userName == '') {
	    alert('请输入账号！');
	    return false;
	  }
	  if(password == '') {
	    alert('请输入密码！');
	    return false;
	  }
	  
	  $.ajax({  
		   	type: 'POST', 
		      url:'${path}/doLogin',
		      data: JSON.stringify({userName:$("#userName").val(),password:$("#password").val()}),   
		      dataType: 'json',
		      contentType:'application/json;charset=UTF-8',         
		      success: function(result) {   
		      	if(result.indexOf('登陆成功') >= 0){
		      		window.location.href = '${path}/index';
		      	}else{
		      		alert(result);
		      	}
		      },
		      error: function(XMLHttpRequest,textStatus,errorThrown)
		    	{
		      	alert('调用服务器失败，请稍后再试');
		    	}
		   });
  }
</script>
</body>
</html>