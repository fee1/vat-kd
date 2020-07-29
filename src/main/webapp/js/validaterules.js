$(function(){
	$.extend($.fn.validatebox.defaults.rules,{				
		 minLength: {
             validator: function (value, param) {
                 return value.length >= param[0];
             },
             message: '请输入至少{0}个字符.'
         },
         maxLength: {
             validator: function (value, param) {
                 return value.length <= param[0];
             },
             message: '请输入最多{0}个字符.'
         },
         length: { validator: function (value, param) {
             var len = $.trim(value).length;
             return len >= param[0] && len <= param[1];
         },
             message: "输入内容长度必须介于{0}和{1}之间."
         },

		integer: {// 验证整数 
            validator: function (value) {
                return /^[+]?[1-9]+\d*$/i.test(value);

            //    return /^([+]?[0-9])|([-]?[0-9])+\d*$/i.test(value);
            },
            message: '请输入整数'
        },
        english: {// 验证英语
            validator: function (value) {
                return /^[A-Za-z]+$/i.test(value);
            },
            message: '请输入英文'
        },

        intOrFloat: {// 验证整数或小数
            validator: function (value) {
                return /^\d+(\.\d+)?$/i.test(value);
            },
            message: '请输入数字，并确保格式正确'
        },

        ip : {// 验证IP地址  
            validator : function(value) {  
                var reg = /^((1?\d?\d|(2([0-4]\d|5[0-5])))\.){3}(1?\d?\d|(2([0-4]\d|5[0-5])))$/ ;  
                return reg.test(value);  
            },  
            message : 'IP地址格式不正确'  
        } ,
        selectValueRequired: {   
            validator: function(value,param){             
                 if (value == "" || value.indexOf('请选择') >= 0) {   
                    return false;  
                 }else {  
                    return true;  
                 }    
            },   
            message: '该下拉框为必选项'   
        },   
        zip : {// 验证邮政编码  
            validator : function(value) {  
                return /^[1-9]\d{5}$/i.test(value);  
            },  
            message : '邮政编码格式不正确'  
        },
        idcard : {// 验证身份证  
            validator : function(value) {  
                return /^\d{15}(\d{2}[A-Za-z0-9])?$/i.test(value) || /^\d{18}(\d{2}[A-Za-z0-9])?$/i.test(value);  
            },  
            message : '身份证号码格式不正确'  
        }, 
        phoneAndMobile : {// 电话号码或手机号码  
            validator : function(value) {  
                return /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i.test(value) || /^(13|15|18)\d{9}$/i.test(value);  
            },  
            message : '电话号码或手机号码格式不正确'  
        },
        checkyhk: {// 验证整数 
            validator: function (value) {
                //return /^[+]?[0-9]+\d*$/i.test(value);
            	return /^[+]?[A-Za-z0-9]*$/i.test(value);

            //    return /^([+]?[0-9])|([-]?[0-9])+\d*$/i.test(value);
            },
            message: '请输入正确的银行账号'
        },
        yearmonths: {// 验证整数 
            validator: function (value) {
            var year = value.substr(0,4);
            var month = value.substr(4,6);
            return /^0[1-9]|1[0-2]$/i.test(month) && /^(20|30)\d{2}$/i.test(year);
            },
            message: '请输入201501这样的格式'
        },
        englishAndNumber: {// 验证非中文
            validator : function(value,param) {
            	return /^[_a-zA-Z0-9]+$/g.test(value);
            },
            message : '请输入英文,数字或下划线'
        },
        gysshcheck : {
        	   validator : function(value,param) {
               	return /^[a-zA-Z0-9]+$/g.test(value);
               },
               message : '请输入正确的供应商税号'
        },
		shuzi: {// 验证整数 
            validator: function (value) {
                return /^[+]?[1-9]+\d*$/i.test(value);

            //    return /^([+]?[0-9])|([-]?[0-9])+\d*$/i.test(value);
            },
            message: '只能输入数字'
        },
        zhengshu: {// 验证整数 
            validator: function (value) {
                return /^([+]?[0-9])|([-]?[0-9])+\d*$/i.test(value);
            },
            message: '只能输入整数'
        },
        nashuirenshibiehao: {// 验证非中文
            validator : function(value,param) {
            	//return /^[_a-zA-Z0-9]+$/g.test(value);
            	return /^[0-9]+[0-9|a-zA-Z]{1}$/g.test(value);
            },
            message : '请输入正确的纳税人识别号'
        },
        nsrsbmyh: {// 验证非中文
            validator : function(value,param) {
            	//return /^[_a-zA-Z0-9]+$/g.test(value);
            	return /^[0-9|a-zA-Z]{15}$/g.test(value);
            },
            message : '请输入正确的纳税人识别号,15位'
        },
        shtymyh: {// 验证非中文
            validator : function(value,param) {
            	//return /^[_a-zA-Z0-9]+$/g.test(value);
            	return /^[0-9|a-zA-Z]{18}$/g.test(value);
            },
            message : '请输入正确的社会信用统一码,18位'
        },
        fpdmyz: {// 验证非中文
            validator : function(value,param) {
            	//return /^[_a-zA-Z0-9]+$/g.test(value);
            	return /^[0-9|a-zA-Z]{10}$/g.test(value);
            },
            message : '请输入正确的发票代码,10位'
        },
        fphmyz: {// 验证非中文
            validator : function(value,param) {
            	//return /^[_a-zA-Z0-9]+$/g.test(value);
            	return /^[0-9]{8}$/g.test(value);
            },
            message : '请输入正确的发票代码,8位整数'
        },
        fpyz:{//验证0到100的数字
        	 validator : function(value,param) {
             	//return /^[_a-zA-Z0-9]+$/g.test(value);
             	return /^[+]?[\d]+(([\.]{1}[\d]+)|([\d]*))$/g.test(value);
             },
             message : '请输入大于0的数字'
        },
        fphs:{//验证1到8的整数
       	 validator : function(value,param) {
            	//return /^[_a-zA-Z0-9]+$/g.test(value);
            	return /^([1-8])$/g.test(value);
            },
            message : '请输入1到8的整数'
       }
	});
});













