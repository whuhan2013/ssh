var privilege = {
	initEvent:function(){
		$("input[name='add']").unbind("click");
		$("input[name='add']").bind("click",function(){
			alert($("select[name='rid1']:option selected").val());
		});
		
		$("input[name='add_all']").unbind("click");
		$("input[name='add_all']").bind("click",function(){
			
		});
		
		$("input[name='remove']").unbind("click");
		$("input[name='remove']").bind("click",function(){
			
		});
		
		
		$("input[name='remove_all']").unbind("click");
		$("input[name='remove_all']").bind("click",function(){
			
		});
	}
};
$().ready(function(){
	privilege.initEvent();
});
