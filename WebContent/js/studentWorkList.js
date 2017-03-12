var workTable;
$(document).ready(function() {
	editor = new $.fn.dataTable.Editor( {
        ajax: {edit: {url: path + "/work/scoreStudentWork?id=_id_",type: 'POST'}},
        table: "#workTable",
        idSrc:  'id',
        fields: [ {
                label: "分数",
                name: "score"
            }, {
                label: "评语",
                name: "teacherComment"
            }
        ]
    } );
 
    // Activate an inline edit on click of a table cell
    $('#workTable').on( 'click', 'tbody td:not(:first-child)', function (e) {
        editor.inline( this );
    } );
    
    workTable = $('#workTable').on( 'init.dt', function () {
    	$("div.toolbar").html('<div class="row"><div class="col-sm-1"><button id="addBtn" type="button" class="btn btn-primary">保存</button></div></div>');
    	
    	$(document).delegate('#addBtn','click',function() {
  		  
    		$('#myModal-add-info').modal('show');
    		$('#opType').html('新增');
    	});
    	
    	//设置父iframe的高度
	    var main = $(window.parent.document).find("#menuFrame");
	    var thisheight = $(document).height() + 90;
	    main.height(thisheight);
    }).DataTable( {
    	"processing": true,
        "serverSide": true,
        searching :false,
        "dom": '<"toolbar">Bfrtipl',
        "pagingType": "full_numbers",
        "language": {
            "url": path + "/plugins/datatables/Chinese.json"
        },
        "ajax": {"url": path + '/work/studentWorkList?workId=' + workId,
        		 //"dataSrc" : "rows"	,
        		"type": "POST",
        		 data : function(d){
        			 
        		 }
        	},
        "columns": [
                    { "data": "id" },
                    { "data": "userName"},
                    { "data": "score" },
                    { "data": "teacherComment" },
                    {   "data" : "workId",
						"orderable" : false, // 禁用排序
						"sDefaultContent" : '',
						"sWidth" : "15%",
					    "render":function(data, type, full, meta){
					    	return	'<button id="modifyOne" class="btn btn-warning btn-sm" data-id='+data+'>下载作业附件</button>';
				    }} 
                ],
         columnDefs: [
                      { targets: [0], visible: false},
                      { targets: '_all', visible: true, "orderable": false}
                  ],
                  select: {
                      style:    'os',
                      selector: 'td:first-child'
                  },
                  buttons: [
                      { extend: "create", editor: editor },
                      { extend: "edit",   editor: editor },
                      { extend: "remove", editor: editor }
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
    		  url: path + "/work/deleteWork?workId=" + id,
    		  success: function (data, status) {
    		  if (status == "success") {
    			  if(data.status == '1'){
    				  showTips(data.message);
    				  workTable.ajax.reload();
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
		$('#workId').val(id);
		 $.ajax({
		  type: "get",
		  url: path + "/work/getWorkById?workId=" + id,
		  success: function (data, status) {
		  if (status == "success") {
			  $("#workTitleForm").val(data.workTile);
			  $("#completeDt").val(data.completeDt);
			  $("#workText1").val(data.workText1);
		  }
		  },
		  error: function () {
		  },
		  complete: function () {
		 
		  }
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
            },
            completeDt :{
            	validators: {
                    notEmpty: {
                        message: '截止日期不能为空'
                    }
            	}
            }
        }
    });
    /*.on('success.form.bv', function(e) {
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
    });*/
});

/* $(window.parent.document).find("#menuFrame").load(function () {
    var main = $(window.parent.document).find("#menuFrame");
    var thisheight = $(document).height() + 80;
    main.height(thisheight);
}); */