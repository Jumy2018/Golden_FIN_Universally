<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
    	<title>客户管理页-平台头寸</title>
	    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
	    <meta name="apple-mobile-web-app-capable" content="yes"/>
	    <link href="./css/style1.css" type="text/css" rel="stylesheet"/>
	    <script type="text/javascript">
	    	function searchVariety(){
	    		var varietyCode = document.getElementById("variety");
	    		window.location.herf="Golden_FIN_Universally/index?varietyName="+varietyCode;
	    	}
	    </script>
	</head>
	<body>
		<!-- 整体大背景的div -->
		<div id="page">
			<!-- 把页面分成上下两个部分 -->
			<div class="div1">
				<p><span style="font-family:'微软雅黑'; color: white;">金政通智能跟单平台</span></p>
			</div> 
			<div class="div2">
				<!-- 把div2分成左右两个部分 -->
				<div class="div3"></div>
				<div class="div4">
					<!-- 品种查询div -->
					<div class="search1">
						<p><span style="font-family:'微软雅黑';">品种：</span></p>
						<select id="variety">
              			</select>
              			<button onclick="searchVariety();">查询</button>
					</div>
					<div class="jingtoucun">100</div>
					<div class="zhongjianjia">2</div>
					<div class="shijia">4</div>
					<div class="yingkui">5</div>
					<div class="platformTable">
						<table style="height: 100%;width: 100%;"   border=1>
							<tr><td></td><td></td><td></td><td></td><td></td><td></td></tr>
							<tr><td></td><td></td><td></td><td></td><td></td><td></td></tr>
							<tr><td></td><td></td><td></td><td></td><td></td><td></td></tr>
							<tr><td></td><td></td><td></td><td></td><td></td><td></td></tr>
						</table>
					</div>
				</div>
			</div> 
		</div>
	</body>
</html>