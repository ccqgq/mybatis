function get(page,search,select) {
		if(page==null){
			page=1;
		}
		var	search = $("#Search").val();
		var	select = $("#select").val();
		$.ajax({
			url:"/fwpt/admin/tea?page="+page+"&"+select+"="+search,
			type:"get",
			dataType:"json",
			scriptCharset: "utf-8",
			success:function(data){
				//alert(data.list.length);
				var table =$("#table")[0];
				var inn = "<tr>"+
						  "<td>姓名</td>"+
						  "<td>职工号</td>"+
						  "<td>性别</td>"+
						  "<td>所在学院</td>"+
						  "<td>职称</td>"+
						  "<td>操作</td>"+
						  "<tr>";
 				 for(var i=0 ;i<data.list.length ; i++) {
					inn+= "<tr>"+
						  "<td>"+data.list[i].name+"</td>"+
						  "<td>"+data.list[i].number+"</td>"+
						  "<td>"+data.list[i].sxe+"</td>"+
						  "<td>"+data.list[i].academe+"</td>"+
						  "<td>"+data.list[i].title+"</td>"+
						  "<td><a>修改</a><a>删除</a></td>"+
						  "</tr>";
				} 
				table.innerHTML=inn; 
				fenye(data);
			}
		});
	}
get();