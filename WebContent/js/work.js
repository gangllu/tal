$(document).ready(function() {
    var workTable = $('#workTable').on( 'init.dt', function () {
    	$("div.toolbar").html('<div class="row"><div class="col-sm-1"><button id="addBtn" type="button" class="btn btn-primary">新增</button></div><button  type="button" class="btn btn-danger">删除</button></div>');
    	
    	$(document).delegate('#addBtn','click',function() {
  		  
    		$('#myModal-add-info').modal('show');
    	});
    }).DataTable( {
    	"processing": true,
        "serverSide": true,
        searching :false,
        "dom": '<"toolbar">frtipl',
        "pagingType": "full_numbers",
        "language": {
            "url": path + "/plugins/datatables/Chinese.json"
        },
        "ajax": {"url": path + '/work/list',
        		 //"dataSrc" : "rows"	,
        		"type": "POST",
        		 data : function(d){
        			 d.workTitle = $('#workTitle').val();
        			 d.workDate1Start = $('#workDate1Start').val();
        			 d.workDate1End = $('#workDate1End').val();
        		 }
        	},
        "columns": [
                    { "data": "workId" },
                    { "data": "workTile" },
                    { "data": "workDate1" },
                    {   "Data" : "workId",
						"orderable" : false, // 禁用排序
						"sDefaultContent" : '',
						"sWidth" : "10%",
					    "render":function(data, type, full, meta){
					    	return	data='<button id="deleteOne" class="btn btn-danger btn-sm" data-id='+data+'>删 除</button>';
				    }}
                ],
         columnDefs: [
                      { targets: [0], visible: false},
                      { targets: '_all', visible: true }
                  ]
    });
    
    $(document).delegate('#deleteOne','click',function() {
    	var id = $(this).data("id");
    	alert(id);
    	Ewin.confirm({ message: "确认要删除选择的数据吗？" }).on(function (e) {
    		 if (!e) {
    		  return;
    		 }
    		 $.ajax({
    		  type: "post",
    		  url: "/api/DepartmentApi/Delete",
    		  data: { "": JSON.stringify(arrselections) },
    		  success: function (data, status) {
    		  if (status == "success") {
    		   toastr.success('提交数据成功');
    		   $("#tb_departments").bootstrapTable('refresh');
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
    
    
    $(document).delegate('#searchBtn','click',function() {
    	workTable.ajax.reload();
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
    
    $('#addForm').bootstrapValidator({
　　　　　message: '验证不通过',
         feedbackIcons: {
　　　　　　　　valid: 'glyphicon glyphicon-ok',
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
            	workTable.ajax.reload();
            	$('#myModal-add-info').modal('hide');
            }
        }, 'json');
    });;
});

/* $(window.parent.document).find("#menuFrame").load(function () {
    var main = $(window.parent.document).find("#menuFrame");
    var thisheight = $(document).height() + 80;
    main.height(thisheight);
}); */