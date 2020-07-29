<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file='../../public/include/header.jsp'%>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="../../easyui/themes/metro/easyui.css">
    <link rel="stylesheet" type="text/css" href="../../easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="../../css/TableZB.css">
    <script type="text/javascript" src="../../js/echarts.common.min.js"></script>
    <script type="text/javascript" src="../../easyui/jquery.min.js"></script>
    <script type="text/javascript" src="../../easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="../../fusioncharts/fusioncharts.js"></script>
    <script type="text/javascript" src="../../fusioncharts/themes/fusioncharts.theme.fint.js"></script>
    
</head>
<body>
<div id="p" class="easyui-panel" title="我的统计图表"
     style="width:100%;height:auto;padding:2px;margine:10px;line-height:right;color"
     data-options="collapsible:true">
     <div style="width: 50%;height:500px;float:left;">
		<div id="main" style="width: 100%;height:90%;"></div>
		 <div style="text-align: center;font-size: 20px;height:10%;">近12期用票情况一览</div>
	 </div>
	 <div style="width: 50%;height:500px;float:right;">
		<div id="main1" style="width: 99%;height:90%;"></div>
		 <div style="text-align: center;font-size: 20px;height:10%;">本周用票情况一览</div>
	 </div>
<script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
        var option = {
        		color: ['#3398DB'],
        	    tooltip : {
        	        trigger: 'axis',
        	        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
        	            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
        	        }
        	    },
        	    grid: {
        	        left: '3%',
        	        right: '4%',
        	        bottom: '3%',
        	        containLabel: true
        	    },
        	    xAxis : [
        	        {
        	            type : 'category',
        	            data : ['1月', '2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月',],
        	            axisTick: {
        	                alignWithLabel: true
        	            }
        	        }
        	    ],
        	    yAxis : [
        	        {
        	            type : 'value'
        	        }
        	    ],
        	    series : [
        	        {
        	            name:'开票',
        	            type:'bar',
        	            barWidth: '60%',
        	            data:[10, 52, 200, 334, 390, 330, 220, 200, 200, 200, 200, 200]
        	        }
        	    ]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main1'));

        // 指定图表的配置项和数据
        var option = {
        	    title: {
        	        text: '',
        	        left: 'center'
        	    },
        	    tooltip: {
        	        trigger: 'item',
        	        formatter: '{a} <br/>{b} : {c}'
        	    },
        	    legend: {
        	        left: 'left',
        	        data: ['红冲数', '作废数', '开票数']
        	    },
        	    xAxis: {
        	        type: 'category',
        	        name: '',
        	        splitLine: {show: true},
        	        data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
        	    },
        	    grid: {
        	        left: '3%',
        	        right: '4%',
        	        bottom: '3%',
        	        containLabel: true
        	    },
        	    yAxis: {
        	        type: 'log',
        	        name: ''
        	    },
        	    series: [
        	        {
        	            name: '红冲数',
        	            type: 'line',
        	            data: [1,1,1,1,1,1,2]
        	        },
        	        {
        	            name: '作废数',
        	            type: 'line',
        	            data: [1, 1, 1, 3, 4, 4, 5]
        	        },
        	        {
        	            name: '开票数',
        	            type: 'line',
        	            data: [1, 3, 6, 9, 12, 15, 18]
        	        }
        	    ]
        	};

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>
</div>
<p></p>




<div id="p2" class="easyui-panel" title="销方信息一览" style="width:100%;height:auto;"
     data-options="collapsible:true">


    <!-- <p style=" color: #2f80d1;">名称:XX银行上海分行 纳税人识别号:*********** 税控盘编号:499000135630</p> -->
    <table border="1" cellpadding="1" style="width: 100%;border-collapse:collapse:collapse;" cellspacing="0"
           align="center"
           id="one" class="TableStyleZB">
        <tbody>
        <tr>
           	<td class="titleTd">机构编码</td>
            <td class="titleTd">发票种类</td>
            
            <td class="titleTd">专票最大金额</td>
			<td class="titleTd">普票最大金额</td>
            <td class="titleTd">发票份数</td>
            <td class="titleTd">剩余份数</td>

        </tr>
        <tr>
       		<td style="text-align: center;">456834</td>
            <td style="text-align: center;">增值税专票</td>
         
            <td style="text-align: right;">99999.99</td>
			<td style="text-align: right;">99999.99</td>
            <td style="text-align: center;">500</td>
            <td style="text-align: center;">500</td>
      
        </tr>
        <tr>
       		<td style="text-align: center;">543345</td>
            <td style="text-align: center;">增值税普票</td>
      
            <td style="text-align: right;">99999.99</td>
			<td style="text-align: right;">99999.99</td>
            <td style="text-align: center;">500</td>
            <td style="text-align: center;">499</td>
     
        </tr>
        </tbody>
    </table>
    
</div>
<div id="p2" class="easyui-panel" title="待开票交易流水一览" style="width:100%;height:auto;"
     data-options="collapsible:true">


    <!-- <p style=" color: #2f80d1;">名称:XX银行上海分行 纳税人识别号:*********** 税控盘编号:499000135630</p> -->
    <table border="1" cellpadding="1" style="width: 100%;border-collapse:collapse:collapse;" cellspacing="0"
           align="center"
           id="one" class="TableStyleZB">
        <tbody style="width:100%">
        <tr>
           	<td class="titleTd">交易流水号</td>
            <td class="titleTd">开票类型</td>
            <td class="titleTd">操作类型</td>
            <td class="titleTd">含税标志</td>
			<td class="titleTd">客户税号</td>
            <td class="titleTd">客户名称</td>
            <td class="titleTd">交易时间</td>
			<td class="titleTd">交易金额</td>
			<td class="titleTd">交易税额</td>
			<td class="titleTd">价税合计</td>
			<td class="titleTd">交易说明</td>
			<td class="titleTd">数据来源</td>
			<td class="titleTd">录入人员</td>
			<td class="titleTd">录入时间</td>
        </tr>
        <tr>
       		<td style="text-align: center;">456834</td>
            <td style="text-align: center;">增值税专票</td>
            <td style="text-align: center;">自动处理</td>
         	<td style="text-align: center;">含税</td>
            <td style="text-align: center;">52618975</td>
			<td style="text-align: center;">A公司</td>
            <td style="text-align: center;">2016-7-11</td>
            <td style="text-align: right;">500.00</td>
            <td style="text-align: center;">0.3</td>
            <td style="text-align: right;">562896.00</td>
            <td style="text-align: center;">无</td>
            <td style="text-align: center;">数据库</td>
            <td style="text-align: center;">张三</td>
            <td style="text-align: center;">2016-7-11</td>
      
        </tr>
        <tr>
       		<td style="text-align: center;">543345</td>
            <td style="text-align: center;">增值税普票</td>
      		<td style="text-align: center;">手动处理</td>
         	<td style="text-align: center;">不含税</td>
            <td style="text-align: center;">52618975</td>
			<td style="text-align: center;">B公司</td>
            <td style="text-align: center;">2016-7-11</td>
            <td style="text-align: right;">230.00</td>
            <td style="text-align: center;">0.3</td>
            <td style="text-align: right;">6532.00</td>
            <td style="text-align: center;">无</td>
            <td style="text-align: center;">数据库</td>
            <td style="text-align: center;">李四</td>
            <td style="text-align: center;">2016-7-11</td>
     
        </tr>
        </tbody>
    </table>
</div>

</body>
</html>