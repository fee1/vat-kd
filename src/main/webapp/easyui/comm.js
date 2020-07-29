$.ajaxSetup({ 
//	error: function (XMLHttpRequest, textStatus, errorThrown){
//			if(XMLHttpRequest.status==404){
//				alert('找不到该资源');
//				return false;
//			}
//		},  
     complete:function(XMLHttpRequest,textStatus){   
    	var msgtag=XMLHttpRequest.getResponseHeader("msgtag"); //通过XMLHttpRequest取得响应头,sessionstatus， 
            if(msgtag=='ajaxerror'){
                  //如果超时就处理 ，指定要跳转的页面  
    		     //var top = getTopWinow(); //获取当前页面的顶层窗口对象
    		     var msg=XMLHttpRequest.responseText;
    		     $.messager.alert('发生错误，请联系管理员',msg);
    		     return ;
    	     }else if(msgtag=='noPrivilege'){
    	    	 var msg=XMLHttpRequest.responseText;
    		     $.messager.alert('权限不足',msg);
    		     return ;
    	     }  
            
            /*if(textStatus=='success'){
            	if(this.url.indexOf('update')>0){
            		$.messager.alert('提示','修改成功!'+this.url);
            	}else if(this.url.indexOf('save')>0){
            		$.messager.alert('提示','保存成功!'+this.url);
            	}else if(this.url.indexOf('destroy')>0 || this.url.indexOf('delect')>0){
            		$.messager.alert('提示','删除成功!'+this.url);
            	}else if(this.url.indexOf('get')>0){
            	}else{
            		$.messager.alert('提示','操作成功!'+this.url);
            	}
            }*/
     }
}); 

	/** 
	* 在页面中任何嵌套层次的窗口中获取顶层窗口 
	* @return 当前页面的顶层窗口对象 
	*/
	function getTopWinow(){  
	var p = window;  
	while(p != p.parent){  
	    p = p.parent;  
	}  
	return p;  
	}  