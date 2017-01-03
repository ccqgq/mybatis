/*	 function fenye(data) {
	  		var ul=$("#ul")[0];
	    	var inn1='';
	    	if(data.page!=1){
	    		inn1+='<li><button type="button" class="btn btn-default" onclick="get('+(data.page-1)+');">&laquo;</button></li>';
	    	}else{
	    		inn1+='<li><button type="button" class="btn btn-default">&laquo;</button></li>';
	    	}
	    	for(var j =1; j<=data.totalPage;j++){
	    		inn1+='<li><button type="button" class="btn btn-default" onclick="get('+j+');">'+j+'</button></li>';
	    	}
	    	if(data.totalPage!=data.page){
	    		inn1+='<li><button type="button" class="btn btn-default" onclick="get('+(data.page+1)+');">&raquo;</button></li>';
	    	}else{
	    		inn1+='<li><button type="button" class="btn btn-default">&raquo;</button></li>'
	    	}
	    	ul.innerHTML=inn1;
	} */
	 function fenye(data) {
	  		var ul=$("#ul")[0];
	    	var inn1='';
	    	if(data.page!=1){
	    		inn1+='<li><a  onclick="get('+(data.page-1)+');">&laquo;</a></li>';
	    	}else{
	    		inn1+='<li><a >&laquo;</a></li>';
	    	}
	    	for(var j =1; j<=data.totalPage;j++){
	    		inn1+='<li><a   onclick="get('+j+');">'+j+'</a></li>';
	    	}
	    	if(data.totalPage!=data.page){
	    		inn1+='<li><a  onclick="get('+(data.page+1)+');">&raquo;</a></li>';
	    	}else{
	    		inn1+='<li><a >&raquo;</a></li>'
	    	}
	    	ul.innerHTML=inn1;
	} 
function session() {
	var juese = $(window.parent.document).find("#juese").text();
	$.ajax({
		url:"/fwpt/getSession",
        type:"POST",
        dataType:"json",
        data:"juese="+juese,
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',//防止乱码
        success:function(data){
        	var user=$("#user")[0];
        	user.innerHTML=data.name;
        },
        error:function(data){
        	window.location.href = "/fwpt/web/index.html";
        }
	});
}
session();