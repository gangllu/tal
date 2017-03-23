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
    <div class="box box-success">
            <div class="box-header ui-sortable-handle" style="cursor: move;">
              <i class="fa fa-comments-o"></i>

              <h3 class="box-title">${topic.topicName }</h3>

              <div class="box-tools pull-right" data-toggle="tooltip" title="" data-original-title="Status">
              </div>
            </div>
            <div class="slimScrollDiv" style="position: relative; overflow: hidden; width: auto; height: auto;"><div class="box-body chat" id="chat-box" style="overflow: hidden; width: auto; height: auto;">
              <!-- chat item -->
              <c:forEach items="${replyPage.data }" var="reply" varStatus="status">
              <div class="item box-comment" style="border-bottom:1px solid #f4f4f4;padding-bottom: 5px">
              	<img src="${path }/dist/img/user2-160x160.jpg" alt="user image" class="offline">
              	<p class="message">
                  <a href="#" class="name">
                    <small class="text-muted pull-right"><i class="fa fa-clock-o"></i>
                    <fmt:formatDate value="${reply.replyDt }" pattern="yyyy-MM-dd HH:mm" />
                    </small>
                    ${reply.replyUserName }
                  </a>
                  
                  <!-- 问题的正确答案 -->
                  <c:if test="${status.index == 0 }">
                  	<c:if test="${correctReply != null }">
                  		<div class="attachment">
                  		<h4 style="color: green">正确答案</h4>
                  		作者：${correctReply.replyUserName }发表于<fmt:formatDate value="${reply.replyDt}"  type="both" /><br/>
	                    ${correctReply.replyContent }
	                	</div>
                  	</c:if>
                  </c:if>
                  
                  <!-- 引用他人的回复 -->
                  <c:if test="${reply.referReplyId != null }">
                    <div class="attachment">
	                  	<img src="${path }/dist/img/icon_quote_s.gif"/>
	                    ${reply.referReplyContent }
	                    <img src="${path }/dist/img/icon_quote_e.gif"/>
	                </div>
                    </c:if>
                    <div style="padding-left: 56px">
                    <c:if test="${reply.correct == '1' }">
                    <h4 style="color:green;font-size: 14px;font-weight: 600;">正确答案</h4>
                    </c:if>
	                  ${reply.replyContent }
	                  </div>
	                </p>
                <div style="text-align: right">
                	<button type="button" class="btn btn-primary" id="replyBtn" onclick="showReplyOther(${reply.replyId},'${reply.replyUserName }发表于<fmt:formatDate value="${reply.replyDt}"  type="both" />','${reply.replyContent }')">回复</button>
                	<c:if test="${reply.userId == userInfo.userId }">
                	<button type="button" class="btn btn-primary" id="replyBtn" onclick="showModifyReply(${reply.replyId},'${reply.replyContent }')">编辑</button>
                	</c:if>
                	<c:if test="${topic.userId == userInfo.userId }">
                	<c:if test="${correctReply == null }">
                	<button type="button" class="btn btn-success" id="replyBtn" onclick="correctReply(${reply.replyId},${reply.userId})">标记为解决</button>
                	</c:if>
                	</c:if>
                </div>
              </div>
              </c:forEach>
			<div id="example" style="text-align: center"> <ul id="pageLimit"></ul> </div>
			
					<div class="slimScrollBar" style="background: rgb(0, 0, 0) none repeat scroll 0% 0%; width: 7px; position: absolute; top: 62px; opacity: 0.4; display: none; border-radius: 7px; z-index: 99; right: 1px; height: 187.688px;"></div>
            <div class="slimScrollRail" style="width: 7px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 7px; background: rgb(51, 51, 51) none repeat scroll 0% 0%; opacity: 0.2; z-index: 90; right: 1px;"></div>
            </div>
            <!-- /.chat -->
            <div class="box-footer">
                <textarea id="replyContent" class="form-control" placeholder="回复问题..."></textarea>
				<br/>
                <button type="button" class="btn btn-success" id="replyBtn" onclick="addReply()">回复</button>
              </div>
            </div>
          </div>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
 <!-- 回复他人回复 --> 
<div class="modal fade" id="myModal-reply-info" tabindex="-1" role="dialog"
                 aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header bg-primary">
                            <button type="button" class="close"
                                    data-dismiss="modal" aria-hidden="true">
                                &times;
                            </button>
                            <h4 class="modal-title" id="myModalLabel">
                                <i class="icon-pencil"></i><span id="opType">参与回复主题</span>	
                            </h4>
                        </div>
                        <form class="form-horizontal" role="form" action="${path }/bbs/addOrUpdateBbsTopic" method="post" id="addForm">
                            <div class="modal-body">
                                <input type="hidden" name="workId" id="workId" value="" >
                                <div>
                                    <label id="topicTitle">${topic.topicName }</label>
                                </div>
                                <div>
                                    <img src="${path }/dist/img/qa.gif">
                                    <input type="hidden" id="referId"/>
                                    <label id="referUser"></label><br/>
                                    <span style="width:14px">&nbsp;</span><label id="referContent"></label>
                                    <img src="${path }/dist/img/qz.gif">
                                </div>
								<label class="col-sm-3 control-label no-padding-left">回复内容：</label>
								<textarea id="replyOtherContent" name="replyOtherContent" class="form-control" rows="5" placeholder=""></textarea>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default"
                                        data-dismiss="modal">关闭
                                </button>
                                <button type="button" class="btn btn-primary" onclick="replyWithOther()">
                                    提交
                                </button>
                            </div>
                        </form>
                    </div><!-- /.modal-content -->
                </div>
            </div>
            
            <!-- 编辑自己的回复 -->
            <div class="modal fade" id="myModal-modify-info" tabindex="-1" role="dialog"
                 aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header bg-primary">
                            <button type="button" class="close"
                                    data-dismiss="modal" aria-hidden="true">
                                &times;
                            </button>
                            <h4 class="modal-title" id="myModalLabel">
                                <i class="icon-pencil"></i><span id="opType">编辑回复</span>	
                            </h4>
                        </div>
                        <form class="form-horizontal" role="form"  method="post" id="addForm">
                            <div class="modal-body">
                                <input type="hidden" name="myReplyId" id="myReplyId" value="" >
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" id="topicTitle">问题：${topic.topicName }</label>
                                </div>
                                <div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">回复内容：</label>
								<textarea id="myReplyContent" name="myReplyContent" class="form-control" rows="5" placeholder=""></textarea>
								</div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default"
                                        data-dismiss="modal">关闭
                                </button>
                                <button type="button" class="btn btn-primary" onclick="modifyReply()">
                                    提交
                                </button>
                            </div>
                        </form>
                    </div><!-- /.modal-content -->
                </div>
            </div>
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
<script type="text/javascript">
	var path = '${path}';
	var role = '${userInfo.role}';
	var topicId = ${topic.topicId};
	
	$('#pageLimit').bootstrapPaginator({    
	    currentPage: '${reply.page.currentPage}',    
	    totalPages: ${replyPage.recordsTotal/10} < 1 ? 1 : Math.ceil(${replyPage.recordsTotal/10}),    
	    size:"normal",    
	    bootstrapMajorVersion: 3,    
	    alignment:"right",    
	    numberOfPages:5,
	    pageUrl: function(type, page, current){
	    	
            return path + "/bbs/viewTopic?page="+page + '&topicId=' + topicId + '&start=' + ((page - 1) * 10 + 1) + '&length=' + 10;
        },
	    itemTexts: function (type, page, current) {        
	        switch (type) {            
	        case "first": return "首页";            
	        case "prev": return "上一页";            
	        case "next": return "下一页";            
	        case "last": return "末页";            
	        case "page": return page;
	        }
	    }
	});
	
	function addReply(){
		$.post(path + '/bbs/addBbsReply', {topicId:'${topic.topicId}',replyContent:$('#replyContent').val()}, function(result) {
        	showTips(result.message);
            if(result.status == '1'){
            	location.reload();
            }
        }, 'json');
	};
	
	function showReplyOther(replyId,referUser,referContent){
		$('#myModal-reply-info').modal('show');
		$('#referUser').html(referUser);
		$('#referContent').html(referContent);
		$('#referId').val(replyId);
	};
	
	/**
	回复他人回复
	*/
	function replyWithOther(){
		$.post(path + '/bbs/replyWithOther', {
			referReplyId:$('#referId').val(),replyContent:$('#replyOtherContent').val(),
			topicId:topicId}, 
			function(result) {
				if(result.status == '1'){
	            	showTips(result.message);
	            	location.reload();
	            }else{
	            	showError(result.message);
	            }
        }, 'json');
	}
	
	function showModifyReply(replyId,replyContent){
		$('#myModal-modify-info').modal('show');
		$('#myReplyContent').val(replyContent);
		$('#myReplyId').val(replyId);
	};
	
	function modifyReply(){
		$.post(path + '/bbs/modifyReply', {replyId:$('#myReplyId').val(),replyContent:$('#myReplyContent').val()}, function(result) {
            if(result.status == '1'){
            	showTips(result.message);
            	location.reload();
            }else{
            	showError(result.message);
            }
        }, 'json');
	};
	
	function correctReply(replyId,userId){
		$.post(path + '/bbs/correctReply', {replyId:replyId,userId:userId}, function(result) {
            if(result.status == '1'){
            	showTips(result.message);
            	location.reload();
            }else{
            	showError(result.message);
            }
        }, 'json');
	};
</script>
<script src="${path}/js/common.js"></script>
</body>
</html>