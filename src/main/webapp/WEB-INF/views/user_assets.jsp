
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
* {
	list-style: none;
	text-decoration: none;
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

body {
	background: rgb(192, 144, 144);
}

.wrapper {
	margin: 0 10px;
}

.wrapper_inner {
	position: relative;
	max-width: 1250px;
	width: 100%;
	height: 700px;
	background: #fff;
	margin: 30px auto;
	border-radius: 25px;
	display: flex;
}

.vertical_wrap {
	position: relative;
	height: 100%;
}

.vertical_bar {
	width: 250px;
	background: lightblue;
	height: 100%;
	border-top-left-radius: 25px;
	border-bottom-left-radius: 25px;
	position: relative;
}

.vertical_bar .profile_info {
	text-align: center;
	padding: 50px 25px;
}

.vertical_bar .profile_info img {
	width: 75px;
}

.vertical_bar .profile_info .title {
	font-size: 16px;
	letter-spacing: 2px;
	color: rgb(192, 144, 144);
	font-weight: 700;
	margin-bottom: 3px;
}

.vertical_bar .menu {
	padding-left: 25px;
}

.vertical_bar .menu li a {
	display: block;
	padding: 15px;
	text-transform: uppercase;
	color: #000;
	font-weight: bold;
	letter-spacing: 2px;
	border-top-left-radius: 25px;
	border-bottom-left-radius: 25px;
	margin-bottom: 1px;
	margin-left: 30px;
}

.vertical_bar .menu li a:hover {
	background: #fff;
	font-weight: bolder;
	color: #000;
}

.vertical_bar .menu li a:active {
	background: #fefefe;
	font-weight: bolder;
	color: #0000;
}

.vertical_bar .social {
	width: 100%;
	display: flex;
	justify-content: center;
	position: absolute;
	bottom: 50px;
}

.vertical_bar .social li a {
	width: 70px;
	height: 60px;
	color: #fff;
	border: 1px solid #fff;
	display: inline-block;
	text-align: center;
	line-height: 30px;
	margin-left: 10px;
}

.vertical_bar .social li a:hover {
	color: rgb(192, 144, 144);
	background: #fff;
}

.main_container {
	width: calc(100% - 250px);
}

.main_container .top_bar {
	height: 60px;
	background: rgb(38, 169, 212);
	border-top-right-radius: 25px;
	padding: 15px 25px;
	display: flex;
	align-items: center;
}

.top_bar .hamburger {
	color: #fff;
	font-size: 24px;
	cursor: pointer;
	display: none;
	margin-right: 25px;
}

.top_bar .logo {
	font-size: 24px;
	font-weight: 700;
	text-transform: uppercase;
	color: darkgray;
}

.top_bar .logo span {
	color: #fff;
}

.main_container .container {
	padding: 25px;
	height: calc(100% - 60px);
	overflow: auto;
}

.main_container .container .item {
	background: #e3f2f1;
	padding: 50px;
	margin-bottom: 25px;
}

.main_container .container .item [type="submit"] {
	display: inline-block;
	background-color: lightblue;
	height: 40px;
	border-radius: 10px;
	border: 4px double #cccccc;
	color: #eeeeee;
	text-align: center;
	font-size: 22px;
	padding-top: 0px;
	width: 258px;
	-webkit-transition: all 0.5s;
	-moz-transition: all 0.5s;
	-o-transition: all 0.5s;
	transition: all 0.5s;
	cursor: pointer;
	margin-top: 10px;
}

.main_container .container .item [type="submit"]:hover {
	cursor: pointer;
	background-color: rgb(52, 168, 207);
	font-size: 30;
	font-weight: bold;
}

.main_container .container .item input[type="text"] {
	display: inline-block;
	font-size: 22px;
	width: 180px;
	height: 32px;
}

.main_container .container .item input[type="number"] {
	display: inline-block;
	font-size: 22px;
	width: 180px;
	height: 32px;
	margin-bottom: 8px;
}

.main_container .container .item p {
	font-size: 24px;
	margin-bottom: 8px;
}

@media ( max-width : 768px) {
	.top_bar .hamburger {
		display: inline-block;
	}
	.vertical_wrap {
		position: absolute;
		top: 0;
		left: 0;
		width: 100%;
		visibility: hidden;
	}
	.vertical_bar {
		position: absolute;
		top: 0;
		left: -100%;
		transition: left 0.2s linear;
	}
	.vertical_wrap .backdrop {
		position: absolute;
		top: 0;
		left: 0;
		border-radius: 25px;
		width: 100%;
		height: 100%;
		background: rgba(0, 0, 0, 0.5);
	}
	.main_container {
		width: 100%;
	}
	.main_container .top_bar {
		border-top-left-radius: 25px;
	}
	.wrapper.active .vertical_wrap {
		visibility: visible;
	}
	.wrapper.active .vertical_bar {
		left: 0;
		transition: left 0.2s linear;
	}
}
</style>
