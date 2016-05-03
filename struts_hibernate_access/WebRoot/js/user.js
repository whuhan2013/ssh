//$()=$("document")
$().ready(function(){
	var arrayA = $("a[aa='aa']");
	arrayA.click(function(){
		if(!window.confirm("您确认要删除吗?")){
			return false;
		}
	});
});
