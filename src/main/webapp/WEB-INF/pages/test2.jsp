<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
	<head>
    	<title>跟单管理页-跟单组合</title>
	    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
	    <meta name="apple-mobile-web-app-capable" content="yes"/>
	    <link href="./css/style1.css" type="text/css" rel="stylesheet"/>
	    <script src="./scripts/jquery-1.7.1.min.js"></script>
    	<script src="./scripts/jquery-ui-1.8.10.custom.min.js"></script>
	    <script type="text/javascript">
	    	function searchVariety(){
	    		var varietyCode = document.getElementById("variety");
	    		window.location.herf="index?varietyName="+varietyCode;
	    	}
	    	$(function() {
	    		var Accordion = function(el, multiple) {
	    			this.el = el || {};
	    			this.multiple = multiple || false;

	    			// Variables privadas
	    			var links = this.el.find('.link');
	    			// Evento
	    			links.on('click', {el: this.el, multiple: this.multiple}, this.dropdown)
	    		}

	    		Accordion.prototype.dropdown = function(e) {
	    			var $el = e.data.el;
	    				$this = $(this),
	    				$next = $this.next();

	    			$next.slideToggle();
	    			$this.parent().toggleClass('open');

	    			if (!e.data.multiple) {
	    				$el.find('.submenu').not($next).slideUp().parent().removeClass('open');
	    			};
	    		}	

	    		var accordion = new Accordion($('#accordion'), false);
	    	});
	    </script>
	</head>
	<body>
		<!-- 整体大背景的div -->
		<div id="page">
			<%@ include file="/common/header.jsp"%>
			<%@ include file="/common/left.jsp"%>
			<div class="div4">
				<div class="lishipcyk">
					<div class="font1">
						<font size="6px">111</font>
					</div>
					<div class="font2">
						历史平仓盈亏
					</div>
					<div class="font3">
						平仓总盈利/亏损 87581/27193
					</div>
				</div>
				<div class="gjccyk">
					<div class="font1">
						<font size="6px">2100/400</font>
					</div>
					<div class="font2">
						跟进中平仓/持仓盈亏
					</div>
					<div class="font3">
						平仓总盈利/亏损 13847/6511<br>
  						持仓总盈利/亏损 817/1228
					</div>
				</div>
				<div class="huibaolv">
					<div class="font1">
						<font size="6px">43.4%</font>
					</div>
					<div class="font2">平仓回报率</div>
					<div class="font3">
						总入金 100201<br>
				 		手续费 26381
					</div>
				</div>
				<div class="shenglv">
					<div class="font1">
						<font size="6px">69.3%</font>
						<font size="3px">(499/770)</font>
					</div>
					<div class="font2">胜率</div>
					<div class="font3">
						盈利次数 499<br>
						亏损次数 271
					</div>
				</div>
				<div class="search2"></div>
				<div class="notice1">
					<font style="color: brown" size="3px">注意：数据实时更新，需手动刷新，最近刷新时间：2017.11.7 11:59:17</font>
				</div>
				<table class="platformTable2"></table>
			</div>
		</div>
	</body>
</html>