var topicTable;
$(document).ready(function() {
    topicTable = $('#topicTable').on( 'init.dt', function () {
    	$("div.toolbar").html('<div class="row"><div class="col-sm-1"><button id="addBtn" type="button" class="btn btn-primary">发布问题</button></div></div>');
    	
    	$(document).delegate('#addBtn','click',function() {
    		$('#myModal-add-info').modal('show');
    	});
    	
    	//设置父iframe的高度
	    var main = $(window.parent.document).find("#menuFrame");
	    var thisheight = $(document).height() + 90;
	    main.height(thisheight);
    }).DataTable( {
    	"processing": true,
        "serverSide": true,
        searching :false,
        "dom": role == 'teacher' ? 'frtipl' : 'frti<"toolbar">pl',
        "pagingType": "full_numbers",
        "language": {
            "url": path + "/plugins/datatables/Chinese.json"
        },
        "ajax": {"url": path + (page == 'myBbs' ? '/bbs/listMyBbsTopic' : '/bbs/listBbsTopic'),
        		 //"dataSrc" : "rows"	,
        		"type": "POST",
        		 data : function(d){
        			 d.topicName = $('#topicName').val();
        		 }
        	},
        "columns": [
                    { "data": "topicId" },
                    { "data": "correct" },
                    { "data": "topicId" ,
                    	"sWidth" : "16px",
                    	render:function(data, type, full, meta){
                    	   if(full.correct == '1'){
                    		   return '<span class="question-img discussion-correct"></span>';
                    	   }else{
                    		   return '<span class="question-img discussion-question"></span>';
                    	   }
                        }
                    },
                    { "data": "topicName",
                      "sWidth" : "60%",
                       render:function(data, type, full, meta){
                    	   return '<a target="menuFrame" href="' + path + '/bbs/viewTopic?start=0&length=10&topicId=' + full.topicId + '">' + data + '</a>';
                       }
                    },
                    { "data": "topicUserName" },
                    { "data": "topicDt" }
                ],
         columnDefs: [
                      { targets: [0,1], visible: false},
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
    		  url: path + "/work/deleteWork?workId=" + id,
    		  success: function (data, status) {
    		  if (status == "success") {
    			  if(data.status == '1'){
    				  showTips(data.message);
    				  topicTable.ajax.reload();
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
    	topicTable.ajax.reload();
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
            	topicTable.ajax.reload();
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