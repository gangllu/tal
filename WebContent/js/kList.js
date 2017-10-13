var kTable;
var teacherWithAnswer = [
                         { "data": "id" },
                         { "data": "title",
                           "sWidth" : "50%",
                            render:function(data, type, full, meta){
                         	   return '<a target="menuFrame" href="' + path + '/k/viewK?id=' + full.id + '">' + data + '</a>';
                            }
                         },
                         { "data": "answer",
                        	 render:function(data, type, full, meta){
	                       	   return '<a target="menuFrame" href="' + path + '/k/viewKWithAnswer?id=' + full.id + '">查看答案</a>';
	                         } 
                         },
                         { "data": "createDt" },
                         {   "data" : "id",
     						"orderable" : false, // 禁用排序
     						"sDefaultContent" : '',
     						"sWidth" : "15%",
     					    "render":function(data, type, full, meta){
     					    	return	'<button id="modifyOne" class="btn btn-warning btn-sm" data-id='+data+'>修 改</button>&nbsp;&nbsp;<button id="deleteOne" class="btn btn-danger btn-sm" data-id='+data+'>删 除</button>';
     				    }}
                     ];
var teacherNoAnswer = [
                       { "data": "id" },
                       { "data": "title",
                         "sWidth" : "60%",
                          render:function(data, type, full, meta){
                       	   return '<a target="menuFrame" href="' + path + '/k/viewK?id=' + full.id + '">' + data + '</a>';
                          }
                       },
                       { "data": "createDt" },
                       {   "data" : "id",
   						"orderable" : false, // 禁用排序
   						"sDefaultContent" : '',
   						"sWidth" : "15%",
   					    "render":function(data, type, full, meta){
   					    	return	'<button id="modifyOne" class="btn btn-warning btn-sm" data-id='+data+'>修 改</button>&nbsp;&nbsp;<button id="deleteOne" class="btn btn-danger btn-sm" data-id='+data+'>删 除</button>';
   				    }}
                   ];
var studentWithAnswer = [{ "data": "id" },
                         { "data": "title",
    "sWidth" : "50%",
     render:function(data, type, full, meta){
  	   return '<a target="menuFrame" href="' + path + '/k/viewK?id=' + full.id + '">' + data + '</a>';
     }
  },
  { "data": "answer",
 	 render:function(data, type, full, meta){
    	   return '<a target="menuFrame" href="' + path + '/k/viewKWithAnswer?id=' + full.id + '">查看答案</a>';
      } 
  },
  { "data": "createDt" }];
var studentNoAnswer = [{ "data": "id" },
                       { "data": "title",
    "sWidth" : "60%",
     render:function(data, type, full, meta){
  	   return '<a target="menuFrame" href="' + path + '/k/viewK?id=' + full.id + '">' + data + '</a>';
     }
  },
  { "data": "createDt" }];

var columnDefObj;
if(ktype == 3 && role == 'teacher'){
	columnDefObj = teacherWithAnswer;
}else if(ktype != 3 && role == 'teacher'){
	columnDefObj = teacherNoAnswer;
}else if(ktype == 3 && role == 'student'){
	columnDefObj = studentWithAnswer;
}else{
	columnDefObj = studentNoAnswer;
}

$(document).ready(function() {
    kTable = $('#kTable').on( 'init.dt', function () {
    	if(role == 'teacher'){
    		$("div.toolbar").html('<div class="row"><div class="col-sm-1"><button id="addBtn" type="button" class="btn btn-primary">新增</button></div></div>');
    	}else{
    		$("div.toolbar").html('');
    	}
    	
    	$(document).delegate('#addBtn','click',function() {
    		if(ktype == 3){
    			location.href = path + '/k/showEditWithAnswer?ktype=' + ktype;
    		}else{
    			location.href = path + '/k/showEdit?ktype=' + ktype;
    		}
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
        "ajax": {"url": path + '/k/listK?ktype=' + ktype,
        		 //"dataSrc" : "rows"	,
        		"type": "POST",
        		 data : function(d){
        			 d.title = $('#title').val();
        		 }
        	},
        "columns": columnDefObj,
         columnDefs: [
                      { targets: [0], visible: false},
                      { targets: '_all', visible: true, "orderable": false}
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
    		  url: path + "/k/deleteK?id=" + id,
    		  success: function (data, status) {
    		  if (status == "success") {
    			  if(data.status == '1'){
    				  showTips(data.message);
    				  kTable.ajax.reload();
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
    	
    	if(ktype == 3){
    		location.href = path + '/k/showEditWithAnswer?id=' + id;
    	}else{
    		location.href = path + '/k/showEdit?id=' + id;
    	}
 	});
    
    
    $(document).delegate('#searchBtn','click',function() {
    	kTable.ajax.reload();
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
        	topicName: {
                message: '标题验证失败',
                validators: {
                    notEmpty: {
                        message: '问题标题不能为空'
                    },
                    stringLength: {
                        min: 1,
                        max: 50,
                        message: '问题标题长度不能超过50'
                    },
                }
            },
            replyContent: {
                validators: {
                    notEmpty: {
                        message: '问题内容不能为空'
                    },stringLength: {
                        min: 1,
                        max: 500,
                        message: '问题内容长度不能超过500'
                    },
                }
            }
        }
    }).on('success.form.bv', function(e) {
        // Prevent form submission
        e.preventDefault();

        // Get the form instance
        var $form = $(e.target);

        // Get the BootstrapValidator instance
        var bv = $form.data('bootstrapValidator');

        // Use Ajax to submit form data
        $.post($form.attr('action'), $form.serialize(), function(result) {
        	showTips(result.message);
            if(result.status == '1'){
            	//成功就刷新表格，关闭对话框
            	kTable.ajax.reload();
            	$('#myModal-add-info').modal('hide');
            }
        }, 'json');
    });
});

/* $(window.parent.document).find("#menuFrame").load(function () {
    var main = $(window.parent.document).find("#menuFrame");
    var thisheight = $(document).height() + 80;
    main.height(thisheight);
}); */