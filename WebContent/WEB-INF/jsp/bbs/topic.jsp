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
                <div class="btn-group" data-toggle="btn-toggle">
                  <button type="button" class="btn btn-default btn-sm"><i class="fa fa-square text-green"></i>
                  </button>
                  <button type="button" class="btn btn-default btn-sm active"><i class="fa fa-square text-red"></i></button>
                </div>
              </div>
            </div>
            <div class="slimScrollDiv" style="position: relative; overflow: hidden; width: auto; height: auto;"><div class="box-body chat" id="chat-box" style="overflow: hidden; width: auto; height: auto;">
              <!-- chat item -->
              <div class="item">
                <img src="${path }/dist/img/user4-128x128.jpg" alt="user image" class="online">

                <p class="message">
                  <a href="#" class="name">
                    <small class="text-muted pull-right"><i class="fa fa-clock-o"></i> 2:15</small>
                    Mike Doe
                  </a>
                  I would like to meet you to discuss the latest news about
                  the arrival of the new theme. They say it is going to be one the
                  best themes on the market
                </p>
                <div class="attachment">
                  <h4>Attachments:</h4>
                  <p class="filename">
                    Theme-thumbnail-image.jpg
                  </p>
                </div>
                <!-- /.attachment -->
              </div>
              <!-- /.item -->
              <!-- chat item -->
              <div class="item">
                <img src="${path }/dist/img/user3-128x128.jpg" alt="user image" class="offline">

                <p class="message">
                  <a href="#" class="name">
                    <small class="text-muted pull-right"><i class="fa fa-clock-o"></i> 5:15</small>
                    Alexander Pierce
                  </a>
                  I would like to meet you to discuss the latest news about
                  the arrival of the new theme. They say it is going to be one the
                  best themes on the market
                </p>
              </div>
              <!-- /.item -->
              <!-- chat item -->
              <div class="item">
                <img src="${path }/dist/img/user2-160x160.jpg" alt="user image" class="offline">

                <p class="message">
                  <a href="#" class="name">
                    <small class="text-muted pull-right"><i class="fa fa-clock-o"></i> 5:30</small>
                    Susan Doe
                  </a>
                  I would like to meet you to discuss the latest news about
                  the arrival of the new theme. They say it is going to be one the
                  best themes on the market
                </p>
              </div>
              <!-- /.item -->
              <c:forEach items="${replyPage.data }" var="reply">
              <div class="item">
              	<img src="${path }/dist/img/user2-160x160.jpg" alt="user image" class="offline">
              	<p class="message">
                  <a href="#" class="name">
                    <small class="text-muted pull-right"><i class="fa fa-clock-o"></i>
                    <fmt:formatDate value="${reply.replyDt }" pattern="yyyy-MM-dd HH:mm" />
                    </small>
                    ${reply.replyUserName }
                  </a>
                  ${reply.replyContent }
                </p>
                <div style="text-align: right">
                	<button type="button" class="btn btn-primary" id="replyBtn" onclick="shwoReplyOther">回复</button>
                	<c:if test="${reply.userId == userInfo.userId }">
                	<button type="button" class="btn btn-primary" id="replyBtn" onclick="showModifyReply(${reply.replyId},'${reply.replyContent }')">编辑</button>
                	</c:if>
                	<c:if test="${topic.userId == userInfo.userId }">
                	<button type="button" class="btn btn-success" id="replyBtn" onclick="addReply()">标记为解决</button>
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
                        <iframe id="submitFrame" name="submitFrame" height="0" style="visibility: hidden;"></iframe>
                        <form class="form-horizontal" role="form" action="${path }/bbs/addOrUpdateBbsTopic" method="post" id="addForm">
                            <div class="modal-body">
                                <input type="hidden" name="workId" id="workId" value="" >
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" id="topicTitle">${topic.topicName }</label>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" id="referContent"></label>
                                </div>
                                <div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">回复内容：</label>
								<textarea id="replyContent" name="replyContent" class="form-control" rows="5" placeholder=""></textarea>
								</div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default"
                                        data-dismiss="modal">关闭
                                </button>
                                <button type="submit" class="btn btn-primary" id="addSaveBtn">
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
	
	function shwoReplyOther(replyId,referContent){
		$('#myModal-reply-info').modal('show');
	};
	
	function showModifyReply(replyId,replyContent){
		$('#myModal-modify-info').modal('show');
		$('#myReplyContent').val(replyContent);
		$('#myReplyId').val(replyId);
	};
	
	function modifyReply(){
		$.post(path + '/bbs/modifyReply', {replyId:'${topic.topicId}',replyContent:$('#myReplyContent').val()}, function(result) {
        	showTips(result.message);
            if(result.status == '1'){
            	location.reload();
            }
        }, 'json');
	};
</script>
<script src="${path}/js/common.js"></script>
</body>
</html>