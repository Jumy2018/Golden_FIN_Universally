<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
	<head>
    	<title>客户管理页-平台头寸</title>
	    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
	    <meta name="apple-mobile-web-app-capable" content="yes"/>
	    <link href="./css/style1.css" type="text/css" rel="stylesheet"/>
	    <script type="text/javascript">
	    	function searchVariety(){
	    		var varietyCode = document.getElementById("variety");
	    		window.location.herf="index?varietyName="+varietyCode;
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
							<c:forEach items="${varietyList }" var="varietyList">
								<option value="${varietyList.varietyName }">${varietyList.varietyName }</option>
							</c:forEach>
              			</select>
              			<button onclick="searchVariety();">查询</button>
					</div>
					<div class="jingtoucun">
						${statisticsVo.netPosition }(${statisticsVo.netPositionHourly })<br>
						净头寸（一小时头寸）<br>
						多总持仓：${statisticsVo.multipleTotalHolding }<br>
						空总持仓：${statisticsVo.emptyTotalHolding }
					</div>
					<div class="zhongjianjia">
						${statisticsVo.middlePrice }<br>
						中间价<br>
						多总均价：${statisticsVo.multipleTotalAveragePrice }<br>
						空总均价：${statisticsVo.emptyTotalAveragePrice }
					</div>
					<div class="shijia">
						${statisticsVo.marketBuyPrice }(${statisticsVo.marketSellPrice })<br>
						市价<br>
						多爆点：${statisticsVo.multipleDetonatingPoint }<br>
						空爆点：${statisticsVo.emptyDetonatingPoint }
					</div>
					<div class="yingkui">
						${statisticsVo.netPosition }(${statisticsVo.netPositionHourly })<br>
						客户总盈亏<br>
						平仓盈亏：${statisticsVo.multipleTotalHolding }<br>
						持仓盈亏：${statisticsVo.emptyTotalHolding }
					</div>
					<div class="platformTable">
						<table style="height: 100%;width: 100%;"   border=1>
							<tr>
								<td>平台名</td>
								<td>买入手数</td>
								<td>买入价</td>
								<td>卖出手数</td>
								<td>卖出价</td>
								<td>净头寸</td>
								<td>1小时头寸</td>
								<td>中间价</td>
								<td>多爆点</td>
								<td>空爆点</td>
								<td>持仓盈亏</td>
								<td>平仓盈亏</td>
								<td>总盈亏</td>
								<td>操作</td>
							</tr>
							<c:forEach items="${staList }" var="staList">
								<tr>
									<td>${staList.platformName }</td>
									<td>${staList.multipleTotalHolding }</td>
									<td>${staList.multipleTotalAveragePrice }</td>
									<td>${staList.emptyTotalHolding }</td>
									<td>${staList.emptyTotalAveragePrice }</td>
									<td>${staList.netPosition }</td>
									<td>${staList.netPositionHourly }</td>
									<td>${staList.middlePrice }</td>
									<td>${staList.multipleDetonatingPoint }</td>
									<td>${staList.emptyDetonatingPoint }</td>
									<td><fmt:formatNumber pattern="#.0000" value="${staList.opsitionGainAndLoss }"/></td>
									<td><fmt:formatNumber pattern="#.0000" value="${staList.offsetGainAndLoss }"/></td>
									<td><fmt:formatNumber pattern="#.0000" value="${staList.totalProfitAndLoss }"/></td>
									<td>跟单</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div> 
		</div>
	</body>
</html>