<%@page import="com.tal.model.TbWork"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>作业</title>
<%@ include file="../common.jsp" %>
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="${path}/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="${path}/dist/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="${path}/dist/css/ionicons.min.css">
  <!-- DataTables -->
  <link rel="stylesheet" href="${path}/plugins/datatables/dataTables.bootstrap.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${path}/dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="${path}/dist/css/skins/_all-skins.min.css">
  
  <link rel="stylesheet" href="${path}/validator/bootstrapValidator.min.css">
  <link rel="stylesheet" href="${path}/plugins/datetimepicker/css/bootstrap-datetimepicker.min.css">
  <link rel="stylesheet" href="${path}/plugins/jNotify/jNotify.jquery.css">
  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition skin-blue">
<div class="wrapper">

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper" style="margin-left: 0;">
    <!-- Content Header (Page header) -->

    <!-- Main content -->
    <section class="content">
    <div class="box box-info">
            <div class="box-header with-border">
              <h3 class="box-title">
              课程成绩
              </h3>
              <div class="box-tools pull-right">
                <button type="button" class="btn btn-primary" onclick="download()">导出</i>
                </button>
              </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
    <div class="table-responsive">
	    <table class="table no-margin">
	      <thead>
	      <tr>
	        <th>学生</th>
	        <c:forEach items="${workList }" var="work">
	        	<th>${work.workTile }</th>
	        </c:forEach>
	      </tr>
	      </thead>
	      <tbody>
	      <%
	      	List<TbWork> workList = (List<TbWork>)request.getAttribute("workList");
			List<Map<String,String>> studentWorkList = (List<Map<String,String>>)request.getAttribute("studentWorkList");
	      	for(Map<String,String> s : studentWorkList){
	      		out.println("<tr>");
	      		out.println("<td>" + s.get("userName") + "</td>" );
	      		for(TbWork w : workList){
	      			out.println("<td>" + (s.get(w.getWorkTile()).equals("null") ? "" : s.get(w.getWorkTile())) + "</td>" );
	      		}
	      		out.println("</tr>");
	      	}
	      %>
	      
	      </tbody>
	      </table>
      </div>
      </div>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
            
  <!-- Control Sidebar -->
  
  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
</div>
<!-- ./wrapper -->

<!-- jQuery 2.2.3 -->
<script src="${path}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="${path}/bootstrap/js/bootstrap.min.js"></script>
<!-- DataTables -->
<script src="${path}/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${path}/plugins/datatables/dataTables.bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="${path}/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="${path}/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="${path}/dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${path}/dist/js/demo.js"></script>
<!-- <script src="${path}/plugins/datepicker/bootstrap-datepicker.js"></script> -->
<script type="text/javascript" src="${path }/plugins/datetimepicker/js/bootstrap-datetimepicker.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="${path }/plugins/datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script type="text/javascript" src="${path}/validator/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="${path}/plugins/jNotify/jNotify.jquery.js"></script>
<script type="text/javascript" src="${path }/plugins/paginator/bootstrap-paginator.min.js"></script>
<%
	String server = request.getServerName()  +  ":"  +  request.getServerPort();
	request.setAttribute("server", server);
%>
<script type="text/javascript">
	var path = '${path}';
	
    //将消息显示在网页上
    function showMsg(json){
    	var chatPosition = 'right';
    	var namePosition = 'right';
    	var timePosition = 'left';
    	
    	chatHtml = '<div class="direct-chat-msg ' + chatPosition + '">' +
        '<div class="direct-chat-info clearfix">' +
	    '<span class="direct-chat-name pull-' + namePosition + '">' + json.userName + '</span>' +
	    '<span class="direct-chat-timestamp pull-' + timePosition + '">' + json.dt + '</span>' +
	  '</div>' +
	  '<img class="direct-chat-img" src="${path }/dist/img/user1-128x128.jpg" alt="message user image">' +
	  '<div class="direct-chat-text">' 
	     + json.msg +
	  '</div>' +
	'</div>';
        $('#messages').append(chatHtml);
        var main = $(window.parent.document).find("#menuFrame");
	    var thisheight = $(document).height();
	    if(thisheight > 450){
	    	main.height(thisheight);
	    }
    }
     
    //发送消息
    function send(){
        var message = document.getElementById('msg').value;
        
        $.post(path + '/bbs/sendMsg', {toUserid:'${toUserid}',msg:message}, function(result) {
            showMsg(result);
            $('#msg').val('');
        }, 'json');
    }
    
    function download(){
    	window.open('${path}/lesson/downloadLessonScore');
    }
</script>
<script src="${path}/js/common.js"></script>
</body>
</html>