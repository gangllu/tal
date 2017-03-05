var lessonTable;
$(document).ready(function() {
    lessonTable = $('#lessonTable').on( 'init.dt', function () {
    	$("div.toolbar").html('<div class="row"><div class="col-sm-1"><button id="addBtn" type="button" class="btn btn-primary">新增</button></div></div>');
    	
    	$(document).delegate('#addBtn','click',function() {
    		$('#myModal-add-info').modal('show');
    		$('#opType').html('新增');
    		$("#year").val('');
			$("#lessonNameForm").val('');
			$("#year").val('');
    	});
    	
    	//设置父iframe的高度
	    var main = $(window.parent.document).find("#menuFrame");
	    var thisheight = $(document).height() + 90;
	    main.height(thisheight);
    }).DataTable( {
    	"processing": true,
        "serverSide": true,
        searching :false,
        "dom": '<"toolbar">frtipl',
        "pagingType": "full_numbers",
        "language": {
            "url": path + "/plugins/datatables/Chinese.json"
        },
        "ajax": {"url": path + '/lesson/list',
        		 //"dataSrc" : "rows"	,
        		"type": "POST",
        		 data : function(d){
        			 d.lessonName = $('#lessonName').val();
        		 }
        	},
        "columns": [
                    { "data": "lessonId" },
                    { "data": "year" },
                    { "data": "lessonName" },
                    {   "data" : "lessonId",
						"orderable" : false, // 禁用排序
						"sDefaultContent" : '',
						"sWidth" : "15%",
					    "render":function(data, type, full, meta){
					    	return	'<button id="modifyOne" class="btn btn-warning btn-sm" data-id='+data+'>修 改</button>&nbsp;&nbsp;<button id="deleteOne" class="btn btn-danger btn-sm" data-id='+data+'>删 除</button>';
				    }} 
                ],
         columnDefs: [
                      { targets: [0], visible: false},
                      { targets: '_all', visible: true ,"orderable": false}
                  ]
    });
    
    $(document).delegate('#deleteOne','click',function() {
    	var id = $(this).data("id");
    	Ewin.confirm({ message: "确认要删除选择的数据吗？" }).on(function (e) {
    		 if (!e) {
    		  return;
    		 }
    		 $.ajax({
    		  type: "get",
    		  url: path + "/lesson/deleteLesson?lessonId=" + id,
    		  success: function (data, status) {
    		  if (status == "success") {
    			  if(data.status == '1'){
    				  showTips(data.message);
    				  lessonTable.ajax.reload();
    			  }else{
    				  showError(data.message);
    			  }
    		  }
    		  },
    		  error: function () {
    			  toastr.error('Error');
    		  },
    		  complete: function () {
    		  }
    		 });
    		 });
 	   });
    
    $(document).delegate('#modifyOne','click',function() {
    	$('#myModal-add-info').modal('show');
    	var id = $(this).data("id");
		$('#opType').html('修改');
		 $.ajax({
		  type: "get",
		  url: path + "/lesson/getLessonById?lessonId=" + id,
		  success: function (data, status) {
		  if (status == "success") {
			  $("#year").val(data.year);
			  $("#lessonNameForm").val(data.lessonName);
		  }
		  },
		  error: function () {
		  },
		  complete: function () {
		 
		  }
		 });
 	   });
    
    
    $(document).delegate('#searchBtn','click',function() {
    	lessonTable.ajax.reload();
	});
    
    /*$('.datepicker').datepicker({
        format: 'yyyy-mm-dd',
        language: 'zh-CN',
        autoclose:true,
        todayHighlight:true,
        enableOnReadonly:true
    }); */
    $(".form_datetime").datetimepicker(
    		{format: 'yyyy-mm-dd',
    		 autoclose: true,	
    		 language:'zh-CN',
    		 minView: 2,
    		});
    
    $('#addForm').bootstrapValidator({message: '验证不通过',
      feedbackIcons: {valid: 'glyphicon glyphicon-ok',
    	  			  invalid: 'glyphicon glyphicon-remove',
    	  			  validating: 'glyphicon glyphicon-refresh'
      },
        fields: {
        	workTitle: {
                message: '作业题目验证失败',
                validators: {
                    notEmpty: {
                        message: '作业题目不能为空'
                    },
                    stringLength: {
                        min: 1,
                        max: 50,
                        message: '作业题目长度不能超过50'
                    },
                }
            },
            workText1: {
                validators: {
                    notEmpty: {
                        message: '作业内容不能为空'
                    },stringLength: {
                        min: 1,
                        max: 500,
                        message: '作业内容长度不能超过500'
                    },
                }
            }
        }
    });
});

/* $(window.parent.document).find("#menuFrame").load(function () {
    var main = $(window.parent.document).find("#menuFrame");
    var thisheight = $(document).height() + 80;
    main.height(thisheight);
}); */