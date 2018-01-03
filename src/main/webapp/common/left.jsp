<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
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
<div class="div3">
	<ul id="accordion" class="accordion">
		<li>
			<div class="link"><i class="fa fa-paint-brush"></i>客户管理<i class="fa fa-chevron-down"></i></div>
			<ul class="submenu">
				<li><a href="/Golden_FIN_Universally/index">我的客户</a></li>
			</ul>
		</li>
		<li>
			<div class="link"><i class="fa fa-code"></i>跟单管理<i class="fa fa-chevron-down"></i></div>
			<ul class="submenu">
				<li><a href="/Golden_FIN_Universally">我的跟单</a></li>
			</ul>
		</li>
	</ul>
</div>> 