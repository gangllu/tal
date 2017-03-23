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
    <div class="box box-primary box-solid direct-chat direct-chat-primary">
        <div class="box-header">
          <h3 class="box-title">即时讨论</h3>
          <div class="box-tools pull-right">
            <span data-toggle="tooltip" title="3 New Messages" class="badge bg-light-blue"></span>
            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
            <button class="btn btn-box-tool" data-toggle="tooltip" title="Contacts" data-widget="chat-pane-toggle"><i class="fa fa-comments"></i></button>
          </div>
        </div><!-- /.box-header -->
        <div class="box-body">
          <!-- Conversations are loaded here -->
          <div class="direct-chat-messages" id="messages" style="height:auto;min-height: 340px">
            <!-- Message. Default to the left -->
            
            <c:forEach items="${list }"  var="chat">
            	<div class="direct-chat-msg <c:if test="${userInfo.userId == chat.userId }">right</c:if>">
	              <div class="direct-chat-info clearfix">
	                <span class="direct-chat-name pull-<c:if test="${userInfo.userId == chat.userId }">right</c:if><c:if test="${userInfo.userId != chat.userId }">left</c:if>">${chat.userName }</span>
	                <span class="direct-chat-timestamp pull-<c:if test="${userInfo.userId != chat.userId }">right</c:if><c:if test="${userInfo.userId == chat.userId }">left</c:if>"><fmt:formatDate value="${chat.dt}" type="both" /></span>
	              </div><!-- /.direct-chat-info -->
	              <img class="direct-chat-img" src="${path }/dist/img/user1-128x128.jpg" alt="message user image"><!-- /.direct-chat-img -->
	              <div class="direct-chat-text">
	                ${chat.msg }
	              </div><!-- /.direct-chat-text -->
	            </div>
            </c:forEach>

          </div><!--/.direct-chat-messages-->

          <!-- Contacts are loaded here -->
          <div class="direct-chat-contacts">
            <ul class="contacts-list">
              <li>
                <a href="#">
                  <img class="contacts-list-img" src="../dist/img/user1-128x128.jpg" alt="Contact Avatar">
                  <div class="contacts-list-info">
                    <span class="contacts-list-name">
                      Count Dracula	
                      <small class="contacts-list-date pull-right">2/28/2015</small>
                    </span>
                    <span class="contacts-list-msg">How have you been? I was...</span>
                  </div><!-- /.contacts-list-info -->
                </a>
              </li><!-- End Contact Item -->
            </ul><!-- /.contatcts-list -->
          </div><!-- /.direct-chat-pane -->
        </div><!-- /.box-body -->
        <div class="box-footer">
          <form action="#" method="post">
            <div class="input-group">
              <input name="msg" id="msg" placeholder="发言 ..." class="form-control" type="text">
              <span class="input-group-btn">
                <button type="button" class="btn btn-primary btn-flat" onclick="send()">Send</button>
              </span>
            </div>
          </form>
        </div><!-- /.box-footer-->
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
	
	
	
	function addReply(){
		$.post(path + '/bbs/addBbsReply', {topicId:'${topic.topicId}',replyContent:$('#replyContent').val()}, function(result) {
        	showTips(result.message);
            if(result.status == '1'){
            	location.reload();
            }
        }, 'json');
	};
	
	var websocket = null;
    
    //判断当前浏览器是否支持WebSocket
    if('WebSocket' in window){
        websocket = new WebSocket("ws://" + "${server}" + "${path}/websocket");
    }
    else{
        alert('Not support websocket')
    }
     
    //连接发生错误的回调方法
    websocket.onerror = function(){
        setMessageInnerHTML("error");
    };
     
    //连接成功建立的回调方法
    websocket.onopen = function(event){
        //setMessageInnerHTML("open");
    }
     
    //接收到消息的回调方法
    websocket.onmessage = function(event){
        setMessageInnerHTML(event.data);
    }
     
    //连接关闭的回调方法
    websocket.onclose = function(){
        //setMessageInnerHTML("close");
    }
     
    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function(){
        websocket.close();
    }
     
    //将消息显示在网页上
    function setMessageInnerHTML(msg){
    	var json = eval('(' + msg + ')'); 
    	//alert(JSON.stringify(json));
    	
    	var chatPosition = json.userId == '${userInfo.userId}' ? 'right' : '';
    	var namePosition = json.userId == '${userInfo.userId}' ? 'right' : 'left';
    	var timePosition = json.userId == '${userInfo.userId}' ? 'left' : 'right';
    	
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
     
    //关闭连接
    function closeWebSocket(){
        websocket.close();
    }
     
    //发送消息
    function send(){
        var message = document.getElementById('msg').value;
        websocket.send('${lessonId};${userInfo.userId};${userInfo.userName};' + message);
    }
</script>
<script src="${path}/js/common.js"></script>
</body>
</html>