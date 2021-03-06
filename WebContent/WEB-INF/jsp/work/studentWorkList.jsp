<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  <link rel="stylesheet" href="${path}/plugins/datatables.Editor/editor/1.6.1/css/editor.dataTables.min.css">
  
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
          <!-- /.box -->
<br/>
          <div class="box">
            <!-- /.box-header -->
            <div class="box-body">
              <table id="workTable" class="table table-bordered table-striped">
                <thead>
                <tr>
                  <th>ID</th>
                  <th>workFilePath</th>	
                  <th>学生姓名</th>
                  <th>分数</th>
                  <th>评语</th>
                  <th>操作</th>
                </tr>
                </thead>
                
              </table>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
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

<!--新增页面开始-->
            <div class="modal fade" id="myModal-add-info" tabindex="-1" role="dialog"
                 aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header bg-primary">
                            <button type="button" class="close"
                                    data-dismiss="modal" aria-hidden="true">
                                &times;
                            </button>
                            <h4 class="modal-title" id="myModalLabel">
                                <i class="icon-pencil"></i><span id="opType">新增</span>	
                            </h4>
                        </div>
                        <iframe id="submitFrame" name="submitFrame" height="0" style="visibility: hidden;"></iframe>
                        <form class="form-horizontal" role="form" action="${path }/work/addOrUpdateWork" method="post" id="addForm" target="submitFrame"  enctype="multipart/form-data">
                            <div class="modal-body">
                            <%-- 
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" >图 片：</label>
                                    <div class="col-sm-5">
                                        <input  type="file" name="img1" class="file" id="img1"  style="width:180px; float: left" />
                                    </div>
                                    <div class="col-sm-3">
                                        <input class="btn btn-sm btn-info" type="button" value="上传" id="uploadimg"/><span id="t"></span>
                                    </div>
                                    <input name="categoryImg" type="hidden" id="imageUrl" />
                                </div>
                                --%>
                                <input type="hidden" name="workId" id="workId" value="" >
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" >作业： </label>

                                    <div class="col-sm-9">
                                        <input type="text"  class="form-control" id="workTitleForm"  name="workTitle" style="width: 350px" maxlength="50" placeholder="" />
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                	<label class="col-sm-3 control-label" style="">作业截止时间：</label>
								    <div class="col-sm-4">
								      <input type="text" class="form-control form_datetime"  id="completeDt" name="completeDt" >
								    </div>
								</div>
                                <div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">作业内容：</label>
								<textarea id="workText1" name="workText1" class="form-control" rows="5" placeholder=""></textarea>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="file">作业附件：</label>
                                    <input type="file" id="workFile"  name="workFile" />
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
<script type="text/javascript" src="${path}/plugins/datatables.Editor/buttons/1.2.4/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" src="${path}/plugins/datatables.Editor/select/1.2.1/js/dataTables.select.min.js"></script>
<script type="text/javascript" src="${path}/plugins/datatables.Editor/editor/1.6.1/js/dataTables.editor.min.js"></script>
<script type="text/javascript">
	var path = '${path}';
	var role = '${userInfo.role}';
	var workId = ${workId};
</script>
<script src="${path}/js/common.js"></script>
<script src="${path}/js/studentWorkList.js"></script>
</body>
</html>