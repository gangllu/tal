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
    <div class="box">
	  <div class="box-header with-border">
	    <h3 class="box-title">${work.workTile}</h3>
	    <div class="box-tools pull-right">
	      <!-- Buttons, labels, and many other things can be placed here! -->
	      <!-- Here is a label for example -->
	      作业完成截止日期：<code><fmt:formatDate value="${work.completeDt }" pattern="yyyy年MM月dd日" /></code>
	      <c:if test="${not empty work.workFile}">
	      <a class="btn btn-primary" href="${path }/work/downloadWork?workId=${work.workId}">
			<i class="fa fa-download"></i>
			下载作业
			</a>
		  </c:if>
	    </div><!-- /.box-tools -->
	  </div><!-- /.box-header -->
	  <div class="box-body" style="height: 200px">
	    ${work.workText1}
	  </div><!-- /.box-body -->
	  <!--<div class="box-footer">
	    The footer of the box
	  </div> box-footer -->
	</div><!-- /.box -->
	
	<br/>
	<div class="box box-primary">
	  <div class="box-header with-border">
	    <h3 class="box-title">${studentWork.userName }的作业</h3>
	    <div class="box-tools pull-right">
	      <!-- Buttons, labels, and many other things can be placed here! -->
	      <!-- Here is a label for example -->
	      上传作业日期：<code><fmt:formatDate value="${studentWork.workDt }" pattern="yyyy-MM-dd HH:mm:ss" /></code>
	      <c:if test="${userInfo.userId ==  studentWork.userId}">
	      <a class="btn btn-primary" href="${path }/work/editWork?workId=${work.workId}&id=${studentWork.id}">
			<i class="fa fa-download"></i>
			修改作业
			</a>
		  </c:if>
	    </div><!-- /.box-tools -->
	  </div><!-- /.box-header -->
	  <div class="box-body" style="height: 500px;overflow:auto">
	    ${studentWork.workContent }
	  </div><!-- /.box-body -->
	  <div class="box-footer">
	    作业附件： <c:if test="${not empty studentWork.workFileName}"><a href="${path }/work/downloadStudentWork?id=${studentWork.id}">下载作业</a></c:if> <br/>
	 <c:if test="${userInfo.role == 'student' }">  
	 分数：${studentWork.score }
	  老师评语：${studentWork.teacherComment }<br/>
	 </c:if>
	   <c:if test="${userInfo.role == 'teacher' }">  
	 分数：<input type="text" value="${studentWork.score }" id="score"/>
	 <input type="hidden" value="${studentWork.id }" id="id"/><br/>
	  老师评语：<input type="text" value="${studentWork.teacherComment }" id="teacherComment"/><br/>
	 <button type="button" class="btn btn-primary" id="addSaveBtn" onclick="scoreWork()">
                                    提交
     </button>
	 </c:if>
	  </div> <!--box-footer -->
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
<script type="text/javascript" src="${path}/plugins/datetimepicker/js/bootstrap-datetimepicker.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="${path}/plugins/datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script type="text/javascript" src="${path}/validator/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="${path}/plugins/jNotify/jNotify.jquery.js"></script>
<script src="${path}/js/common.js"></script>
<script type="text/javascript">
var path = '${path}';

function scoreWork(){
	var score = $('#score').val();
	if(isNaN(score)){
		alert('分数必须是数字');
		return;
	}
	$.post(path + '/work/scoreWork', 
			{id:$('#id').val(),score:$('#score').val(),teacherComment:$('#teacherComment').val()}, 
			function(result) {
        if(result.status == '1'){
    		showTips(result.message);
        }else{
        	showError(result.message);
        }
    }, 'json');
}
</script>
<script type="text/javascript" charset="utf-8" src="${path}/plugins/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${path}/plugins/ueditor/ueditor.all.min.js"> </script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="${path}/plugins/ueditor/lang/zh-cn/zh-cn.js"></script>
    
<script type="text/javascript">
	
	/*$('#form1').bootstrapValidator({message: '验证不通过',
	      feedbackIcons: {valid: 'glyphicon glyphicon-ok',
	    	  			  invalid: 'glyphicon glyphicon-remove',
	    	  			  validating: 'glyphicon glyphicon-refresh'
	      },
	        fields: {
	        	workContent: {
	                message: '作业内容验证失败',
	                validators: {
	                    notEmpty: {
	                        message: '作业内容不能为空'
	                    },
	                    stringLength: {
	                        min: 1,
	                        max: 4000,
	                        message: '作业内容长度不能超过4000'
	                    },
	                }
	            }
	        }
	    }).on('success.form.bv', function(e) {
	    	document.getElementById('workContent').value = UE.getEditor('editor').getContent();
        	alert(UE.getEditor('editor').getContent());
        	$('#form1').submit();	        
	    });*/
</script>

<script src="${path}/js/work.js"></script>
</body>
</html>