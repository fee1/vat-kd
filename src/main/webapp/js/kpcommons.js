var nsrsbh = "";    //纳税人识别号
var skpbh = "";     //税控盘编号
var fplxdm = "";    //发票类型代码
var dqfpdm = "";   //当前发票代码
var dqfphm = "";    //当前发票号码
var skph = "";      //税控盘号
var zcm = "";      //税控盘号
var timestamp = ""; //当前时间戳
var fpdm = "";      //发票代码
var fphm = "";      //发票号码
var clientstatu = 0;//1:代表自研客户端;2:代表开票通
var kpcommons = {
		
	
		
    //通过开票点代码获取注册码导入xml
    improtZcm: function (kpddm) {
        var xml = "";
        //去数据库查询注册码信息
        $.ajax({
            //请求方式
            type: "POST",
            //请求地址
            url: baseUrl + '/xxfpsh/lskjfpsh/returnXml',
            //数据
            data: {kpddm: kpddm, id: "zcmdr"},
            //同步
            async: false,
            //请求成功
            success: function (result) {
                xml = result.xml;
                zcm = result.kpd.zcm;
                skph = result.kpd.skph;
                timestamp = new Date().getTime();
            }
        });
        //注册码导入
        $.ajax({
            //请求方式
            type: "POST",
            //请求地址
            url: "http://127.0.0.1:15000",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("zjjklx", "drzcm");
            },
            //数据，json字符串 解决跨域问题
            crossDomain: true,
            data: xml,
            //同步
            async: false,
            //请求成功
            success: function (result) {
                var returnmsg = $(result).find("body").children("output").children("returnmsg").text();
                var returncode = $(result).find("body").children("output").children("returncode").text();
            }
        });
    },

    //税控盘信息查询获取当前发票代码 当前发票号码
    getDqfpdmAndDqfphm: function (kpddm, fpzldm) {

        var xml = "";
        //通过开票点代码返回税控盘信息查询xml
        $.ajax({
            type: "POST",
            url: baseUrl + '/xxfpsh/lskjfpsh/returnXml',
            data: {kpddm: kpddm, id: "skpxxcx"},
            async: false,
            //请求成功
            success: function (result) {
                xml = result.xml;
            }
        });
        //获取税控盘信息 获取当前税控盘编号 和纳税人识别号
        $.ajax({
            //请求方式
            type: "POST",
            //请求地址
            url: "http://127.0.0.1:15000",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("zjjklx", "hqskp");
            },
            //数据，json字符串 解决跨域问题
            //dataType: 'json',
            crossDomain: true,
            data: xml,
            //同步
            async: false,
            //请求成功
            success: function (result) {
                var output = $(result).find("body").children("output");
                skpbh = output.children("skpbh").text();
                nsrsbh = output.children("nsrsbh").text();
                fplxdm = output.children("fplxdm").text();
                var returncode = output.children("returncode").text();
                var returnmsg = output.children("returnmsg").text();
                if (returncode !== "00000000") {
                    $.messager.alert(
                        '提示', '获取税控盘信息失败 ' + returnmsg, 'info'
                    );
                    return false;
                }
            }
        });
        //返回购票信息查询的xml
        $.ajax({
            type: "POST",
            url: baseUrl + '/xxfpsh/lskjfpsh/returnXml',
            data: {kpddm: kpddm, id: "gpxxcx", nsrsbh: nsrsbh, fpzldm: fpzldm},
            async: false,
            //请求成功
            success: function (result) {
                xml = result.xml;
            }
        });
        $.ajax({
            //请求方式
            type: "POST",
            //请求地址
            url: "http://127.0.0.1:15000",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("zjjklx", "gpxx");
            },
            //数据，json字符串 解决跨域问题
            crossDomain: true,
            data: xml,
            //同步
            async: false,
            //请求成功
            success: function (result) {
                var output = $(result).find("body").children("output");
                dqfpdm = output.children("dqfpdm").text();
                dqfphm = output.children("dqfphm").text();
                var returncode = output.children("returncode").text();
                var returnmsg = output.children("returnmsg").text();
                if (returncode === "00000000") {

                } else {
                    $.messager.alert(
                        '提示', '获取当前发票代码和发票号码失败 ' + returnmsg, 'info'
                    );
                    return false;
                }
            }
        });
        return [dqfpdm, dqfphm];
    },

    //发票开具
    fpkj: function (jylsh, djh, kpddm) {
        var xml = "";
        $.ajax({
            //请求方式
            type: "POST",
            //请求地址
            url: baseUrl + '/xxfpsh/lskjfpsh/returnXml',
            //数据，json字符串
            data: {"id": "fpkj", "jylsh": jylsh, "djh": djh, "kpddm": kpddm},
            //同步
            async: false,
            //请求成功
            success: function (result) {
                xml = result.xml;
            }
        });
        var returnCode = "";
        //发送报文
        $.ajax({
            //请求方式
            type: "POST",
            //请求地址
            url: "http://127.0.0.1:15000",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("zjjklx", "fpkj");
            },
            //数据，json字符串 解决跨域问题
            crossDomain: true,
            data: xml,
            //同步
            async: false,
            //请求成功
            success: function (result) {
                var output = $(result).find("body").children("output");
                fpdm = output.children("fpdm").text();
                fphm = output.children("fphm").text();
                returnCode = output.children("returncode").text();
                var returnmsg = output.children("returnmsg").text();
                if ("0" === returnCode) {
                    $.ajax({
                        //请求方式
                        type: "POST",
                        //请求地址
                        url: baseUrl + '/xxfpsh/lskjfpsh/saveKpxx',
                        //数据，json字符串
                        data: {
                            "jylsh": jylsh,
                            "djh": djh,
                            "kpddm": kpddm,
                            "fpdm": fpdm,
                            "fphm": fphm,
                            "returnCode": returnCode
                        },
                        //同步
                        async: false,
                        //请求成功
                        success: function (result) {

                        }
                    });
                } else {
                    $.messager.alert(
                        '提示', '开票失败 ' + returnmsg, 'info'
                    );
                }
            }
        });
        return returnCode;
    },
    //发票批量开具
    fpplkj: function (d, kpsqhs, fpnums, kpd) {
        var returnCode = "";
        var returnmsg = "";
        //返回报文去开票
        $.ajax({
            type: "POST",
            url: baseUrl + '/xxfpgl/clfpkj/kpplXml?data=' + encodeURIComponent(d) + '&kpsqhs=' + kpsqhs + '&fpnums=' + fpnums + '&kpd=' + encodeURIComponent(kpd),
            //同步
            async: false,
            dataType: "json",
            success: function (data) {
                var xmls = data.xmls;
                var kpsqharr = kpsqhs.split(",");
                var fpnumsarr = fpnums.split(",");
                for (var i = 0; i < xmls.length; i++) {
                    var xml = xmls[i];
                    //发票开具发送报文
                    $.ajax({
                        //请求方式
                        type: "POST",
                        //请求地址
                        url: "http://127.0.0.1:15000",
                        beforeSend: function (xhr) {
                            xhr.setRequestHeader("zjjklx", "fpplkj");
                        },
                        //数据，json字符串 解决跨域问题
                        crossDomain: true,
                        data: xml,
                        //同步
                        async: false,
                        //请求成功
                        success: function (result) {
                            var output = $(result).find("body").children("output");
                            fpdm = output.children("fpdm").text();
                            fphm = output.children("fphm").text();
                            var fplxdm = output.children("fplxdm").text();
                            var fpzldm = "";
                            if (fplxdm === "004") {
                                fpzldm = "01";
                            } else if (fplxdm === "007") {
                                fpzldm = "02";
                            }
                            returnCode = output.children("returncode").text();
                            returnmsg = output.children("returnmsg").text();
                            if ("0" === returnCode) {
                                $.ajax({
                                    //请求方式
                                    type: "POST",
                                    //请求地址
                                    url: baseUrl + '/xxfpgl/clfpkj/savePlkj',
                                    //数据，json字符串
                                    data: {
                                        "i": (i + 1),
                                        "kpddm": kpd,
                                        "fpdm": fpdm,
                                        "fphm": fphm,
                                        "returnCode": returnCode,
                                        "kpsqh": kpsqharr[i],
                                        "fpnum": fpnumsarr[i]
                                    },
                                    //同步
                                    async: false,
                                    //请求成功
                                    success: function (result) {
                                        kpcommons.fpdy(fpzldm);
                                    }
                                });
                            } else {

                            }
                        }
                    });

                }
            }
        });

        return [returnCode, returnmsg];
    },
    //发票作废
    fpzf: function (kplsh, fplxdm) {
        var xml = "";
        $.ajax({
            //请求方式
            type: "POST",
            //请求地址
            url: baseUrl + '/xxfpgl/fpzfsh/returnXml',
            //数据，json字符串
            data: {"kplsh": kplsh, "fplxdm": fplxdm},
            //同步
            async: false,
            //请求成功
            success: function (result) {
                xml = result.xml;
            }
        });
        //发送报文
        $.ajax({
            //请求方式
            type: "POST",
            //请求地址
            url: "http://127.0.0.1:15000",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("zjjklx", "fpzf");
            },
            //数据，json字符串 解决跨域问题
            crossDomain: true,
            data: xml,
            //同步
            async: false,
            //请求成功
            success: function (result) {
                var output = $(result).find("body").children("output");
                var returnCode = output.children("returncode").text();
                var returnmsg = output.children("returnmsg").text();
                if ("00000000" === returnCode) {
                    $.ajax({
                        //请求方式
                        type: "POST",
                        //请求地址
                        url: baseUrl + '/xxfpgl/fpzfsh/fpzf',
                        //数据，json字符串
                        data: {"kplsh": kplsh},
                        //请求成功
                        //同步
                        async: false,
                        success: function (result) {
                            $.messager.alert(
                                '提示', '发票作废成功 ', 'info'
                            );
                        }
                    });
                } else {
                    $.messager.alert(
                        '提示', '发票作废失败 ' + returnmsg, 'info'
                    );
                }
            }
        });
    },

    //发票红冲
    fphc: function (kplsh, hcsqh) {
        var xml = "";
        $.ajax({
            //请求方式
            type: "POST",
            //请求地址
            url: baseUrl + '/xxfpgl/fphcsh/returnXml',
            //数据，json字符串
            data: {"kplsh": kplsh, "hcsqh": hcsqh},
            //同步
            async: false,
            //请求成功
            success: function (result) {
                xml = result.xml;
            }
        });
        var code = "";
        //发送报文
        $.ajax({
            //请求方式
            type: "POST",
            //请求地址
            url: "http://127.0.0.1:15000",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("zjjklx", "fphc");
            },
            //数据，json字符串 解决跨域问题
            crossDomain: true,
            data: xml,
            //同步
            async: false,
            //请求成功
            success: function (result) {
                var output = $(result).find("body").children("output");
                var returnCode = output.children("returncode").text();
                var returnmsg = output.children("returnmsg").text();
                fpdm = output.children("fpdm").text();
                fphm = output.children("fphm").text();
                if ("0" === returnCode) {
                    $.ajax({
                        //请求方式
                        type: "POST",
                        //请求地址
                        url: baseUrl + '/xxfpgl/fphcsh/hcsq',
                        //数据，json字符串
                        data: {"kplsh": kplsh, "hcsqh": hcsqh, "fpdm1": fpdm, "fphm1": fphm},
                        //同步
                        async: false,
                        //请求成功
                        success: function (result) {

                            code = "0";
                        }
                    });
                } else {
                    $.messager.alert(
                        '提示', '发票红冲失败 ' + returnmsg, 'info'
                    );
                }
            }
        });
        return code;
    },

    //根据发票代码号码查询zcm信息和税控盘号
    queryKpd: function (fpdm, fphm) {
        var skph1 = ""; //查询到的税控盘号
        var kpddm1 = ""; //查询到的开票点代码
        $.ajax({
            //请求方式
            type: "POST",
            //请求地址
            url: baseUrl + '/xxfpsh/lskjfpsh/queryKpd',
            //数据
            data: {fpdm: fpdm, fphm: fphm},
            //同步
            async: false,
            //请求成功
            success: function (result) {
                skph1 = result.kpd.skph;
                kpddm1 = result.kpd.kpddm;
            }
        });
        return [skph1, kpddm1];
    },

    //根据开票点查询开票点信息
    queryKpdByKpddm: function (kpddm) {
        var skph1 = ""; //查询到的税控盘号
        var kpddm1 = ""; //查询到的开票点代码
        $.ajax({
            //请求方式
            type: "POST",
            //请求地址
            url: baseUrl + '/xxfpsh/lskjfpsh/queryKpdByKpddm',
            //数据
            data: {kpddm: kpddm},
            //同步
            async: false,
            //请求成功
            success: function (result) {
                skph1 = result.kpd.skph;
                kpddm1 = result.kpd.kpddm;
            }
        });
        return [skph1, kpddm1];
    },

    //发票打印
    fpdy: function (fpzldm) {
        /*//返回发票页边距设置xml
        $.ajax({
            //请求方式
            type: "POST",
            //请求地址
            url: baseUrl + '/xxfpsh/lskjfpsh/returnXml',
            //数据
            data: {fpzldm: fpzldm, id: "fpsz", "top": "0", "left": "0"},
            //同步
            async: false,
            //请求成功
            success: function (result) {
                xml = result.xml;
            }
        });
        //发送报文
        $.ajax({
            //请求方式
            type: "POST",
            //请求地址
            url: "http://127.0.0.1:15000",
            beforeSend: function (xhr) {
                    xhr.setRequestHeader("zjjklx", "dysz");
                },
            //数据，json字符串 解决跨域问题
            crossDomain: true,
            data: xml,
            //同步
            async: false,
            //请求成功
            success: function (result) {
            }
        });*/
        var returnCode = "";
        //返回发票打印xml
        $.ajax({
            //请求方式
            type: "POST",
            //请求地址
            url: baseUrl + '/xxfpsh/lskjfpsh/returnXml',
            //数据
            data: {fpzldm: fpzldm, id: "fpdy", fpdm: fpdm, fphm: fphm},
            //同步
            async: false,
            //请求成功
            success: function (result) {
                xml = result.xml;
            }
        });
        //发送报文
        $.ajax({
            //请求方式
            type: "POST",
            //请求地址
            beforeSend: function (xhr) {
                xhr.setRequestHeader("zjjklx", "fpdy");
            },
            url: "http://127.0.0.1:15000",
            //数据，json字符串 解决跨域问题
            crossDomain: true,
            data: xml,
            //同步
            async: false,
            //请求成功
            success: function (result) {
                var returnmsg = $(result).find("body").children("output").children("returnmsg").text();
                var returncode = $(result).find("body").children("output").children("returncode").text();
                if (returncode !== "00000000") {
                    $.messager.alert(
                        '提示', '发票打印失败 ' + returnmsg, 'info'
                    );
                }
            }
        });
    },
    //设置fpdm fphm
    setFpdmAndFphm: function (fpdm1, fphm1) {
        fpdm = fpdm1;
        fphm = fphm1;
    },
    checkclicent: function (kpddm) {
        if (clientstatu == 0) {
            var xml = "";
            //去数据库查询注册码信息
            $.ajax({
                //请求方式
                type: "POST",
                //请求地址
                url: baseUrl + '/xxfpsh/lskjfpsh/returnXml',
                //数据
                data: {kpddm: kpddm, id: "zcmdr"},
                //同步
                async: false,
                //请求成功
                success: function (result) {
                    xml = result.xml;
                    zcm = result.kpd.zcm;
                    skph = result.kpd.skph;
                    timestamp = new Date().getTime();
                }
            });
            //注册码导入
            $.ajax({
                //请求方式
                type: "POST",
                //请求地址
                url: "http://127.0.0.1:15000",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("zjjklx", "zcmdr");
                },
                //数据，json字符串 解决跨域问题
                crossDomain: true,
                data: xml,
                //同步
                async: false,
                //请求成功
                success: function (result) {
                    var returnmsg = $(result).find("body").children("output").children("returnmsg").text();
                    var returncode = $(result).find("body").children("output").children("returncode").text();

                    if (returncode !== "0" && returncode !== "00000000") {
                        $.messager.alert(
                            '提示', '注册码导入失败 ' + returnmsg, 'info'
                        );
                    }
                    var code1 = "";
                    var code2 = "";
                    $.ajax({
                        //请求方式
                        type: "POST",
                        //请求地址
                        url: "http://127.0.0.1:15000",
                        beforeSend: function (xhr) {
                            xhr.setRequestHeader("zjjklx", "004");
                        },
                        //数据，json字符串 解决跨域问题
                        crossDomain: true,
                        data: xml,
                        //同步
                        async: false,
                        //请求成功
                        success: function (result) {
                            var output = $(result).find("body").children("output");
                            code1 = output.children("returncode").text();
                        }
                    });
                    $.ajax({
                        //请求方式
                        type: "POST",
                        //请求地址
                        url: "http://127.0.0.1:15000",
                        beforeSend: function (xhr) {
                            xhr.setRequestHeader("zjjklx", "007");
                        },
                        //数据，json字符串 解决跨域问题
                        crossDomain: true,
                        data: xml,
                        //同步
                        async: false,
                        //请求成功
                        success: function (result) {
                            var output = $(result).find("body").children("output");
                            code2 = output.children("returncode").text();
                        }
                    });
                    if (code1 !== "00000000" && code2 !== "00000000") {
                        $.messager.alert(
                            '提示', '页边距未设置，请到客户端设置 ', 'info'
                        );
                    } else if (code1 !== "00000000") {
                        $.messager.alert(
                            '提示', '专票页边距未设置，请到客户端设置 ', 'info'
                        );
                    } else if (code2 !== "00000000") {
                        $.messager.alert(
                            '提示', '普票页边距未设置，请到客户端设置 ', 'info'
                        );
                    } else {
                        clientstatu = 1;
                    }
                },
                error: function (err) {
                    clientstatu = 2;
                }
            });
        }
    },
	//按时间导入fpxx
		improtFpxx:function(xml){
			$.ajax({
	            //请求方式
	            type: "POST",
	            //请求地址
	            url: "http://127.0.0.1:15000",
	            beforeSend: function (xhr) {
	                xhr.setRequestHeader("zjjklx", "drzcm");
	            },
	            //数据，json字符串 解决跨域问题
	            crossDomain: true,
	            data: xml,
	            //同步
	            async: false,
	            //请求成功
	            success: function (result) {
	                var returnmsg = $(result).find("body").children("output").children("returnmsg").text();
	                var returncode = $(result).find("body").children("output").children("returncode").text();
	                //var fpxx=$(result).find("body").children("output").children("fpxx");
	            
	               var fpxx = result.documentElement.innerHTML;
	              
	               //var asd = JSON.stringify(_list);
	              fpxx ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+fpxx;
	             
	              
	                debugger;
	                
	                if(returncode!=="00000000"){
	                    $.messager.alert(
	                            '提示', '获取税控盘信息失败 ' + returnmsg, 'info'
	                        );
	                        return false;
	                }else{
	                	
	                	 $.ajax({
	                         //请求方式
	                         type: "POST",
	                         //请求地址
	                         url: baseUrl +'/xxfpgl/ykfpcx/anYueCunShuJv',
	                         contentType:'text/xml',

	                 		//contentType:'application/json;charset=utf-8',
	                         data: fpxx,
	                         //dataType:'json',
	                         //同步
	                         async: false,
	                         //请求成功
	                         success: function (date) {
	                            
	                             $.messager.alert('提示', date.msg, 'info');
	                             $('#anYueFen').dialog('close');
	                             
	                         }
	                     });
	                }
	                
	                
	            }
	        });
		},
};









