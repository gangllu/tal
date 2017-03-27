<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>作业</title>
<%@ include file="common.jsp" %>
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
              <c:if test="${userInfo.role == 'student' }">待完成作业列表</c:if>
              <c:if test="${userInfo.role == 'teacher' }">待批阅作业列表</c:if>
              </h3>

              <div class="box-tools pull-right">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
              </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
            <c:if test="${userInfo.role == 'student' }">
            	<div class="table-responsive">
                <table class="table no-margin">
                  <thead>
                  <tr>
                    <th>作业</th>
                    <th>完成截止日期</th>
                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${workList }" var="work">
                  <tr>
                    <td><a href="${path}/work/showDoWork?workId=${work.workId }">${work.workTile }</a></td>
                    <td><fmt:formatDate value="${work.completeDt }" /></td>
                  </tr>
                  </c:forEach>
                  </tbody>
                  </table>
                  </div>
            </c:if>
            <c:if test="${userInfo.role == 'teacher' }">
            	<div class="table-responsive">
                <table class="table no-margin">
                  <thead>
                  <tr>
                    <th>作业</th>
                    <th>学生</th>
                    <th>作业完成日期</th>
                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${studentWorkList }" var="swork">
                  <tr>
                    <td><a href="${path }/work/viewWork?workId=${swork.workId }&id=${swork.id}">${swork.workTile }</a></td>
                    <td>${swork.userName }</td>
                    <td><fmt:formatDate value="${swork.workDt }" type="both"/></td>
                  </tr>
                  </c:forEach>
                  </tbody>
                  </table>
                  </div>
            </c:if>
              <!-- /.table-responsive -->
            </div>
            <!-- /.box-body -->
            <div class="box-footer clearfix">
              <a href="${path }/work/listPage" class="btn btn-sm btn-info btn-flat pull-left">作业管理</a>
            </div>
            <!-- /.box-footer -->
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
<!-- page script -->
</body>
</html>