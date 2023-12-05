<%@page import="bean.giaybean"%>
<%@page import="bean.dangnhapadminbean"%>
<%@page import="bean.loaibean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bo.loaibo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Quản lý giày</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<style>
body {
	width: 100%;
	overflow-x: hidden;
}

* {
	box-sizing: border-box;
}

.box {
	display: flex;
}

.box__item {
	display: flex;
	flex-direction: column;
}

.img {
	margin-right: 16px;
}

.header {
	position: fixed;
	top: 0;
	right: 0;
	left: 0;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}

.table {
	width: 100vw;
}

.table__item {
	margin-top: 40px;
}

.paddingBottom {
	padding-bottom: 8px;
}

.container {
	display: flex;
	width: 100vw;
}

.containerItem {
	width: 200px;
}

.containerItem.maxWidth {
	flex: 1;
}

.pagination {
	display: flex;
	justify-content: center;
	width: 100%;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	border-radius: 5px;
	transition: background-color .3s;
	border: 1px solid #ddd; /* Gray */
	margin: 0 2px;
	cursor: pointer;
	text-align: center;
	text-decoration: none;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}

.navContent {
	display: flex;
	flex-direction: column;
}

.box {
	display: flex;
}

.navItem {
	width: 100%;
	padding: 8px 0;
	border-bottom: 1px solid #ccc;
	text-decoration: none;
	text-transform: none;
}

a:hover {
	color: #23527c;
	text-decoration: none;
}

.flexBox {
	display: flex;
	flex-wrap: wrap;
	width: 100%;
}

.flexItem {
	width: calc(100%/ 3);
	padding: 8px;
	margin-bottom: 16px;
}

.flexItemMargin {
	border: 1px solid #ccc;
	border-radius: 4px;
	display: flex;
	justify-content: center;
	flex-direction: column;
	align-items: center;
	padding: 8px;
	text-align: center;
	transition: .2s;
}

.flexItemMargin:hover {
	background-color: rgba(0, 0, 0, .05);
}

.text {
	overflow: hidden;
	text-overflow: ellipsis;
	-webkit-line-clamp: 1;
	display: -webkit-box;
	-webkit-box-orient: vertical;
}

.btnBuy {
	width: 100%;
	outline: none;
	border-radius: 4px;
	color: #fff;
	background-color: #2e8b57;
	transition: .2s;
	text-align: center;
	padding: 6px 16px;
	font-size: 16px;
	cursor: pointer;
	font-weight: 600;
	border: 3px solid #2e8b57;
	text-decoration: none;
}

.btnBuy:hover {
	color: #2e8b57;
	background-color: #fff;
}
</style>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">

			<ul class="nav navbar-nav">
				<li class="active"><a href="adminController">Trang chủ</a></li>

				<li><a href="quanlyloaiadminController">Quản lý loại</a></li>
				<li><a href="quanlygiayadminController">Quản lý giày</a></li>
				<li><a href="xacnhanController">Danh sách cần xác nhận</a></li>
				<li><a href="danhsachController">Danh sách đã xác nhận</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span></span>Hi: ${admin.getTenDangNhap()} </a></li>
				<li><a href="dangnhapadminController"><span class="glyphicon glyphicon-user"></span> Log Out</a></li>
			</ul>
		</div>
	</nav>
	
<div align="right" class="container-fluid">
	<h1  align="center"  style="color: red; height: 70px"> QUẢN LÝ GIÀY	</h1>
</div>
<div  align="right" class="container-fluid">
	<form action="themgiayadminController">
		<button name="btnThem" ><img src="them.png"  width="40" height="30"></button>
	</form>
</div>
				<table style=" margin-left: 10px;"  class="table table-bordered">
					<tr  align="center">
			
						<td width="100"><b>HÌNH ẢNH</b></td>
						<td width="300"><b>MÃ LOẠI</b> </td>
						<td width="300"><b>MÃ GIÀY</b> </td>
						<td width="300"><b>TÊN GIÀY</b> </td>
						<td> <b>GIÁ</b> </td>
						<td width="100"> <b>SỐ LƯỢNG</b> </td>
						<td> <b>NGÀY NHẬP</b> </td>
						<td align="center"><b>CHỨC NĂNG</b></td	>
					</tr>
					<c:forEach var="s" items="${dsgiay}">
						<tr align="center">
							<td><img src="${s.getAnh()}" height="100"></td>
							<td>${s.getMaLoai()}</td>
							<td>${s.getMaGiay()}</td>
							<td>${s.getTenGiay()}</td>
							<td>${s.getGia()}</td>
							<td>${s.getSoLuong()}</td>
							<td>${s.getNgayNhap()}</td>	
							<td style="width: 200px" class="text-center">
								<a href='htsuagiayController?mg=${s.getMaGiay()}' class="btn btn-success">Sửa</a>
								<a href='xoagiayadminController?mg=${s.getMaGiay()}'class="btn btn-danger">Xóa</a>
							</td>
					
					</tr>		
					</c:forEach>
				</table>
					<nav aria-label="...">
		<ul class="pagination">
			<c:if test="${index > 1}">
				<li class="page-item disabled"><a class="page-link"
					href="quanlygiayadminController?index=${	 - 1}" tabindex="-1">Pre</a></li>
			</c:if>

			<c:forEach begin="1" end="${endP }" var="i">
				<li class="${index == i ? "page-item active" : "page-item" }"><a
					class="page-link" href="quanlygiayadminController?index=${i}">${i}</a></li>
			</c:forEach>
			<c:if test="${index < endP }">
				<li class="page-item"><a class="page-link"
					href="quanlygiayadminController?index=${index + 1}">Next</a></li>
			</c:if>

		</ul>
	</nav>
</body>
</html>
