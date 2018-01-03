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
			//关闭弹窗
/* 			$('.cancelBtn').click(function(){
				$('#dialogBg').fadeOut(300,function(){
					$('#dialog').addClass('bounceOutUp').fadeOut();
					$('#platformStrategyDiv').addClass('bounceOutUp').fadeOut();
				});
			}); */
		});
		//编辑交易账户
		function editAccount(obj){
			className = $(this).attr('class');
			$('#dialogBg').fadeIn(300);
			$('#dialog').removeAttr('class').addClass('animated '+className+'').fadeIn();
			var platformId = $(obj).closest("tr").find("#platformIdVal").val();
			var username = $(obj).closest("tr").find("#usernameVal").val();
			var password = $(obj).closest("tr").find("#passwordVal").val();
			var id = $(obj).closest("tr").find("#accountIdVal").val();
			
			var usernameObj = $('#dialog').find("input[name='username']");
			$(usernameObj[0]).val(username);

			var passwordObj = $('#dialog').find("input[name='password']");
			$(passwordObj[0]).val(password);

			var platformIdObj = $('#dialog').find("select[name='platform.id']");
			$(platformIdObj[0]).val(platformId);

			var idObj = $('#dialog').find("input[name='id']");
			$(idObj[0]).val(id);
		}
		function closeEditAccount(){
			$('#dialogBg').fadeOut(300,function(){
				$('#dialog').addClass('bounceOutUp').fadeOut();
			});
		}
		//删除交易账号(还没做确认删除弹层)
		function delAccount(accId){
			if(confirm("是否删除该账户？")){
				window.location="account/del?accountId="+accId;
			}
		}
		//编辑平台跟单策略
		function editPlatformStrategy(selectedPlatformId , selectedPlatformName){
			className = $(this).attr('class');
			$('#dialogBg').fadeIn(300);
			$('#platformStrategyDiv').removeAttr('class').addClass('animated '+className+'').fadeIn();
			//提供平台名称
			$('#platformNameSpan').html(selectedPlatformName);
			var platformHiddens = $("input[name='platform.id']");
			$(platformHiddens[0]).val(selectedPlatformId);
		}
		function closeEditPlatformStrategy(){
			$('#dialogBg').fadeOut(300,function(){
				$('#platformStrategyDiv').addClass('bounceOutUp').fadeOut();
			});
		}
		/*初始化单笔最大止盈，单笔最大止损，最大止损的值*/
		function initValue(){
			//单笔最大止盈
			var singleProfitLimitFlag = $($("input[name='singleProfitLimitFlag']:checked")[0]);
			var singleProfitLimit = $($("input[name='singleProfitLimit']")[0]);
			if(singleProfitLimitFlag.val() != "-1"){
				singleProfitLimit.val($("#singleProfitLimitVal").val());
			}else{
				singleProfitLimit.val("-1");
			}
			//单笔最大止损
			var singleLoseLimitFlag = $($("input[name='singleLoseLimitFlag']:checked")[0]);
			var singleLoseLimit = $($("input[name='singleLoseLimit']")[0]);
			if(singleLoseLimitFlag.val() != "-1"){
				singleLoseLimit.val($("#singleLoseLimitVal").val());
			}else{
				singleLoseLimit.val("-1");
			}
			//最大止损
			var orderLostLimitFlag = $($("input[name='orderLostLimitFlag']:checked")[0]);
			var orderLostLimit = $($("input[name='orderLostLimit']")[0]);
			if(orderLostLimitFlag.val() != "-1"){
				orderLostLimit.val($("#orderLostLimitVal").val());
			}else{
				orderLostLimit.val("-1");
			}
		}
	</script>
	</head>
	<body>
		<!-- 整体大背景的div -->
		<div id="page">
			<%@ include file="/common/header.jsp"%>
			<%@ include file="/common/left.jsp"%>
			<div class="div4">
				<!-- 品种查询div -->
				<div class="search1">
					<p>
						<span style="font-family: '微软雅黑'; position: absolute; top:33%; left: 5%; color: black">品种：</span>
					</p>
					<select id="variety" style="font-family: '微软雅黑'; position: absolute; top:33%; left: 8%; width: 10%;">
						<c:forEach items="${varietyList }" var="varietyList">
							<option value="${varietyList.varietyName }">${varietyList.varietyName }</option>
						</c:forEach>
					</select>
					<button onclick="searchVariety();" class="button1"><span style="font-family: '微软雅黑'; color: white">查询</span></button>
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
							<td>${staList.customerPlatform.name}</td>
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
							<td>
								<span style="cursor: pointer;color: blue;" onclick="editPlatformStrategy('${staList.customerPlatform.id}','${staList.customerPlatform.name}')">跟单</span>
							</td>
						</tr>
					</c:forEach>
				</table>
				<div class="addAccountDivClass" align="right">
					<input type="button" value="添加交易账号" style="width: 200px;height: 30px" onclick="editAccount()"/>
				</div>
				<table class="accountTable">
					<tr style="background-color: #c0c0c0" align="center">
						<td><strong>平台名</strong></td>
						<td><strong>账户名</strong></td>
						<td><strong>操作</strong></td>
					</tr>
					<c:forEach items="${allAccounts}" var="account">
						<tr align="center">
							<td>${account.platformName}</td>
							<td>${account.username}</td>
							<td hidden="hidden">
								<input hidden="hidden" value="${account.id}" id="accountIdVal"/>
								<input hidden="hidden" value="${account.platformId}" id="platformIdVal"/>
								<input hidden="hidden" value="${account.username}" id="usernameVal"/>
								<input hidden="hidden" value="${account.password}" id="passwordVal"/>
							</td>
							<td>
								<span style="cursor: pointer;color: blue;" onclick="editAccount(this)">修改</span> 
								<span style="cursor: pointer;color: blue;" onclick="delAccount('${account.id}')">删除</span>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div id="dialogBg"></div>
		<div id="dialog" class="animated">
			<div class="dialogTop">
				<div align="left"><span>账号管理</span></div>
			</div>
			<form action="account/add" method="post" id="editForm">
				<ul class="editInfos">
					<li hidden="hidden">
						<input hidden="hidden" name="id"/>
					</li>
					<li>
						<label><br><br>
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
						<input type="button" value="取消" onclick="closeEditAccount()" class="cancelBtn" />
					</li>
				</ul>
			</form>
		</div>

		<!-- 跟单策略弹层 -->
		<div id="platformStrategyDiv" class="animated">
			<div class="dialogTop">
				<div align="left"><span style="font-size: 25;">平台跟单</span></div>
			</div>
			<form action="strategy/platform/add" method="post" id="editForm"  onsubmit="initValue()">
				<table style="font-family: '微软雅黑'; font-size: 14; border-collapse:separate; border-spacing:0px 10px;">
					<tr></tr>
					<tr>
						<td width="25%" align="right">
							平台：<span id="platformNameSpan"></span>
							<input type="hidden" name="platform.id"/>
						</td>
						<td width="20">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td width="10%" align="right">品种：
								<input type="hidden" value="${seletedVariety.id}" name="variety.id"/>
							</td>
						<td width="45%">&nbsp;&nbsp;&nbsp;&nbsp;${seletedVariety.varietyName}</td>
					</tr>
					<tr>
						<td align="right">是否跟单：</td>
						<td colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="direction" value="1" class="ipt"/>正向跟单
							<input type="radio" name="direction" value="-1" class="ipt"/>反向跟单
						</td>
					</tr>
					<tr>
						<td align="right">下单手数：</td>
						<td colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;
							后台净头寸每变化<input type="text" value="10" style="width: 40px" name="netPositionChangedFrequency"/>
								手，跟单<input type="text" value="1" style="width: 25px" name="followingCount"/>手
						</td>
					</tr>
					<tr>
						<td align="right">单笔最大止盈：</td>
						<td colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="singleProfitLimitFlag" value="-1" class="ipt" checked="checked"/>不设
							<input type="radio" name="singleProfitLimitFlag" class="ipt"/>
							<input type="text" id="singleProfitLimitVal" style="width:80px;"/>美金
							<input type="hidden" name="singleProfitLimit"/>
						</td>
					</tr>
					<tr>
						<td align="right">单笔最大止损：</td>
						<td colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="singleLoseLimitFlag" value="-1" class="ipt" checked="checked"/>不设
							<input type="radio" name="singleLoseLimitFlag" class="ipt"/>
							<input type="text" id="singleLoseLimitVal" style="width: 80px"/>美金
							<input type="hidden" name="singleLoseLimit"/>
						</td>
					</tr>
					<tr>
						<td align="right">跟单止损：</td>
						<td colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="orderLostLimitFlag" value="-1" class="ipt" checked="checked"/>不设
							<input type="radio" name="orderLostLimitFlag" class="ipt"/>
							<input type="text" id="orderLostLimitVal" style="width: 80px"/>美金
							<input type="hidden" name="orderLostLimit">
						</td>
					</tr>
					<tr>
						<td align="right">跟单账号：</td>
						<td colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;
							<select style="width: 15%" name="account.id">			
								<c:forEach items="${allAccounts}" var="account">
									<option value="${account.id}">${account.platformName}-${account.username}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td  align="center" colspan="4">
							<input type="submit" value="完成" class="submitBtn"/>
							<input type="button" value="取消" onclick="closeEditPlatformStrategy()" class="cancelBtn" />
						</td>
					</tr>
				</table>
			</form>	
		</div>
	</body>
</html>