<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
	<head>
	<title>客户管理页-平台头寸</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<link href="./css/style1.css" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" href="./css/common.css"/>
	<script type="text/javascript" src="./scripts/jquery-1.7.1.min.js"></script>
	<script type="text/javascript">
		function searchVariety() {
			var varietyCode = document.getElementById("variety");
			window.location.herf = "index?varietyName=" + varietyCode;
		}
		//以下的函数为添加账号的弹出框需要
		var w,h,className;
		function getSrceenWH(){
			w = $(window).width();
			h = $(window).height();
			$('#dialogBg').width(w).height(h);
		}
		window.onresize = function(){  
			getSrceenWH();
		}  
		$(window).resize();  
		$(function(){
			getSrceenWH();
			
			//显示弹框
			$("#addAccount").click(function(){
				className = $(this).attr('class');
				$('#dialogBg').fadeIn(300);
				$('#dialog').removeAttr('class').addClass('animated '+className+'').fadeIn();
			});
			
			//关闭弹窗
			$('.cancelBtn').click(function(){
				$('#dialogBg').fadeOut(300,function(){
					$('#dialog').addClass('bounceOutUp').fadeOut();
				});
			});
		});
		//END
	</script>
	</head>
	<body>
		<!-- 整体大背景的div -->
		<div id="page">
			<%@ include file="/common/header.jsp"%>
				<div class="div3"></div>
				<div class="div4">
					<!-- 品种查询div -->
					<div class="search1">
						<p>
							<span style="font-family: '微软雅黑';">品种：</span>
						</p>
						<select id="variety">
							<c:forEach items="${varietyList }" var="varietyList">
								<option value="${varietyList.varietyName }">${varietyList.varietyName }</option>
							</c:forEach>
						</select>
						<button onclick="searchVariety();">查询</button>
					</div>
					<div class="jingtoucun">
						<div class="font1">
							<font size="6px">${statisticsVo.netPosition }</font>
							<font size="3px">(${statisticsVo.netPositionHourly })</font>
						</div>
						<div class="font2">
							净头寸(一小时头寸)
						</div>
						<div class="font3">
							多总持仓：${statisticsVo.multipleTotalHolding }<br>
							空总持仓：${statisticsVo.emptyTotalHolding }
						</div>
					</div>
					<div class="zhongjianjia">
						<div class="font1">
							<font size="6px"><fmt:formatNumber pattern="#.00" value="${statisticsVo.middlePrice}"/></font>
						</div>
						<div class="font2">
							中间价
						</div>
						<div class="font3">
							多总均价：${statisticsVo.multipleTotalAveragePrice }<br>
							空总均价：${statisticsVo.emptyTotalAveragePrice }
						</div>
					</div>
					<div class="shijia">
						<div class="font1">
							<font size="6px">${statisticsVo.marketBuyPrice }</font>
							<font size="3px">(${statisticsVo.marketSellPrice })</font>
						</div>
						<div class="font2">市价</div>
						<div class="font3">
							多爆点：${statisticsVo.multipleDetonatingPoint }<br>
							空爆点：${statisticsVo.emptyDetonatingPoint }
						</div>
					</div>
					<div class="yingkui">
						<div class="font1">
							<font size="6px"><fmt:formatNumber pattern="#.####" value="${statisticsVo.totalProfitAndLoss }"/></font>
						</div>
						<div class="font2">客户总盈亏</div>
						<div class="font3">
							平仓盈亏：<fmt:formatNumber pattern="#.####" value="${statisticsVo.offsetGainAndLoss }"/><br>
							持仓盈亏：<fmt:formatNumber pattern="#.####" value="${statisticsVo.opsitionGainAndLoss }"/>
						</div>
					</div>
						<table class="platformTable" >
							<tr style="background-color: #c0c0c0" align="center">
								<td><strong>平台名</strong></td>
								<td><strong>买入手数</strong></td>
								<td><strong>买入价</strong></td>
								<td><strong>卖出手数</strong></td>
								<td><strong>卖出价</strong></td>
								<td><strong>净头寸</strong></td>
								<td><strong>1小时头寸</strong></td>
								<td><strong>中间价</strong></td>
								<td><strong>多爆点</strong></td>
								<td><strong>空爆点</strong></td>
								<td><strong>持仓盈亏</strong></td>
								<td><strong>平仓盈亏</strong></td>
								<td><strong>总盈亏</strong></td>
								<td><strong>操作</strong></td>
							<c:forEach items="${staList }" var="staList">
								<tr align="center">
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
									<td><fmt:formatNumber pattern="#.####" value="${staList.opsitionGainAndLoss }"/></td>
									<td><fmt:formatNumber pattern="#.####" value="${staList.offsetGainAndLoss }"/></td>
									<td><fmt:formatNumber pattern="#.####" value="${staList.totalProfitAndLoss }"/></td>
									<td>跟单</td>
								</tr>
							</c:forEach>
						</table>
						<div class="addAccountDivClass" align="right">
							<input type="button" value="添加交易账号" style="width: 200px;height: 30px" id="addAccount"/>
						</div>
						<table class="accountTable">
							<tr style="background-color: #c0c0c0" align="center">
								<td><strong>平台名</strong></td>
								<td><strong>账户名</strong></td>
								<td><strong>操作</strong></td>
							</tr>
							<c:forEach items="${allAccounts }" var="account">
								<tr align="center">
									<td>${account.platformName}</td>
									<td>${account.userName}</td>
									<td><a>修改</a> <a>删除</a></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
			
			
		<div id="dialogBg"></div>
		<div id="dialog" class="animated">
			<div class="dialogTop">
				<div align="left"><span>账号管理</span></div>
			</div>
			<form action="account/add" method="post" id="editForm">
				<ul class="editInfos">
					<li>
						<label>
							<font color="#ff0000">* </font>
							平台：<select id="platform" name="platform.id" class="ipt" style="widows: 200px">
									<c:forEach items="${tradePlatformList}" var="platform">
										<option value="${platform.id}">${platform.name}</option>
									</c:forEach>
								</select>
						</label>
					</li>
					<li><label><font color="#ff0000">* </font>账户：<input type="text" name="username" required value="" class="ipt" /></label></li>
					<li><label><font color="#ff0000">* </font>密码：<input type="text" name="password" required value="" class="ipt" /></label></li>
					<li>
						<input type="submit" value="保存" class="submitBtn" />
						<input type="submit" value="取消" class="cancelBtn" />
					</li>
				</ul>
			</form>
		</div>
			
			
	</body>
</html>