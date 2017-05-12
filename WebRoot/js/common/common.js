var common = {
	myconfirm:function(){
		document.getElementsByName("did")
		if(window.confirm("您确认要删除吗?")){//确认
			return true;
		}else{//不删除
			return false;
		}
	}
};
/**
 * 在页面加载完毕以后，给指定的元素加事件
 */
window.onload = function(){
//	document.getElementById("del").onclick = function(){
//		return common.myconfirm();
//	}
	var ahrefs = document.getElementsByName("del");
	//上述代码得到一个数组，遍历数组，把数组中的每一个元素加onclick事件
	for(var i=0;i<ahrefs.length;i++){
		//ahrefs[i]代表每一个超级链接
		ahrefs[i].onclick = function(){
			//alert(this.id);
			return common.myconfirm();
		};
	}
}
