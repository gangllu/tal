<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
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
    <h2 class="page-header">
	${work.workTile}
	</h2>
	<pre class="prettyprint">
	<code class="html">${work.workText1}</code>
	</pre>
	<div class="">
	<a class="btn btn-primary" href="http://almsaeedstudio.com/download/AdminLTE-dist">
	<i class="fa fa-download"></i>
	下载作业
	</a>
	作业完成截止日期：<code><fmt:formatDate value="${work.completeDt }" pattern="yyyy年MM月dd日" /></code> 
	</div>
	
	<h4>填写作业</h4>
	<form action="${path }/work/addOrUpdateStudentWork" method="post" id="form1" enctype="multipart/form-data" onsubmit="return submitForm();">
	<script id="editor" type="text/plain" style="width:100%;height:500px;"></script>
	<textarea rows="" cols="" name="workContent" id="workContent" style="display: none;"></textarea>
	</br>
	<input type="file" id="studentWorkFile"  name="studentWorkFile" />
	<input type="hidden" name="workId" value="${work.workId }">
	</br>
	<button type="submit" class="btn btn-primary" id="addSaveBtn">
                                    提交
    </button>
	</form>
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
<script type="text/javascript">
var path = '${path}';
var UEDITOR_HOME_URL = path + "/plugins/ueditor/";
</script>
<script type="text/javascript" charset="utf-8" src="${path}/plugins/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${path}/plugins/ueditor/ueditor.all.min.js"> </script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="${path}/plugins/ueditor/lang/zh-cn/zh-cn.js"></script>
    
<script type="text/javascript">
	
	var ue = UE.getEditor('editor');
	
	function submitForm(){
		document.getElementById('workContent').value = UE.getEditor('editor').getContent();
    	alert(UE.getEditor('editor').getContent());
    	return true;	 
	}
	
	$('#form1').bootstrapValidator({message: '验证不通过',
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
	    });
</script>
<script src="${path}/js/common.js"></script>
<script src="${path}/js/work.js"></script>
</body>
</html>