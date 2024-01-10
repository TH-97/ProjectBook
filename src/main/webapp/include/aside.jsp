<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<aside>
	<style>
		body {
			height: 5000px;
		}
	
		.aside_right {
			position: absolute;
			width: 200px;
			height: auto;
			right: 100px;
			top: 300px;
			border: 1px solid #e3e3e3;
			padding: 20px;
			background-color: gray;
			edge: shadow;
		}
		
		@media (max-width: 900px) {
			.aside_right {
				display: none;
			}
		}
		
		
	</style>
	<script>
		window.addEventListener('scroll', () => {
			//let a = document.getElementById("custom_side").scrollTop;
			//console.log(a)
			if(window.scrollY >= 190) {
				document.getElementById("custom_side").style.position = "fixed";
				document.getElementById("custom_side").style.top = "93px";
			} else {
				document.getElementById("custom_side").style.position = "absolute";
				document.getElementById("custom_side").style.top = "300px";
			}
			
		})
	</script>
</aside>

</body>
<div class="aside_right" id="custom_side">
	
		<h3>빠르게 구매하깅</h3>
		<hr>
	
		<a href="">[장바구니]</a><br>

		<a href="">[예치금 충전]</a>
	</div>
</html>