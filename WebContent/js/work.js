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
        "ajax": {"url": path + '/work/list'//,
        		 //"dataSrc" : "rows"	
        	},
        "columns": [
                    { "data": "workId" },
                    { "data": "workTile" },
                    { "data": "workDate1" }
                ],
         columnDefs: [
                      { targets: [0], visible: false},
                      { targets: '_all', visible: true }
                  ]
    });
    
    
});

/* $(window.parent.document).find("#menuFrame").load(function () {
    var main = $(window.parent.document).find("#menuFrame");
    var thisheight = $(document).height() + 80;
    main.height(thisheight);
}); */