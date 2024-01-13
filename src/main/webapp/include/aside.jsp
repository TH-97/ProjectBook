<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<aside>
	<style>
		body {
			height: 10px;
		}
	
		.aside_right {
			box-shadow: 0 0 20px #795cfa, 0 0 40px #b5a5fa;
			padding: 15px 0px;
			background-color: none;
			position: absolute;
			width: 100px;
			height: auto;
			right: 100px;
			top: 300px;
			border: 1px solid #e3e3e3;
			padding: 20px;
			background-color: none;
			boarder-radius: 0.5rem;
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
			if(window.scrollY >= 190) {hiy 
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
	
		<h3>님 </h3>
		<h3>환영합니다</h3>
		<h3>^0^</h3>
		<hr>
	</div>
</html>