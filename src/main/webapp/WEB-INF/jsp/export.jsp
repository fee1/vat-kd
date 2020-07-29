<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file='/src/main/webapp/public/include/header.jsp'%>
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript">  
window.onload=function(){  
    document.getElementById("hlf").value=parent.exportString;   
};  
  
  
function btnExcel(){  
	  document.getElementById("type").value="excel";  
    $('#formAction').form('submit', {
	    url: "/TaxEasy/comm/doUpload", 
	    onSubmit: function(){    	    	
		    },    
		    success:function(data){		    			    	
		    }    
		 }); 
  // $('#formAction').submit();  
}  
function btnWord(){  
    document.getElementById("type").value="word"; 
 
    $('#formAction').form('submit', {
						    url: "/TaxEasy/comm/doUpload", 
						    onSubmit: function(){    					    	
							    },    
							    success:function(data){    							      
							    }    
							 }); 
  //  $('#formAction').submit();  
    
   
}  
</script>
</head>
<body style="padding: 20px; align: center">
<form id='formAction' method="post">
           文件名称: <input id="wjmc" class="easyui-textbox" name="wjmc"> 
   <font size="3px">&nbsp;&nbsp;&nbsp;&nbsp;请选择导出文件类型</font>
   <input id="dc1"  type="button"
	 style="margin-left: 60px;" value="Excel" onclick="btnExcel()" /> 
	 <input id="dc2"  type="button" style="margin-left: 60px;" value="Word" onclick="btnWord()" />
	 <input id="hlf" name='hfs' type="hidden" /> 
	 <input id="type" name='type'  type="hidden" /></form>
</body>
</html>
