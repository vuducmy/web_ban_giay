
<%@page import="bean.giohangbean"%>
<%@page import="bo.giohangbo"%>
<%@page import="bean.khachangbean"%>
<%@page import="bean.loaibean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bo.loaibo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.payment {
	width: 100%;
	height: 150px;
	display: flex;
	justify-content: flex-start;
	position: fixed;
	bottom: -50px;
	border-top: 1px solid #ccc;
	background-color: #blue;
}
.text-right{
	width:50%;
}
</style>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">

			<ul class="nav navbar-nav">
				<li class="active"><a href="htgiayController">Trang chủ</a></li>

				<li><a href="htgioController">Giỏ hàng</a></li>

				<li><a href="lichsumuahangController">Lịch sử mua hàng</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">

				<li><a href="ktdkController"><span
						class="glyphicon glyphicon-user"></span> Sign in</a></li>
				<c:choose>
					<c:when test="${dn == null}">
						<li><a href="ktdnController"><span
								class="glyphicon glyphicon-log-in"></span> Login</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="#"><span></span>Hi: ${dn} </a></li>
						<li><a href="ktdnController"><span
								class="glyphicon glyphicon-log-out"></span> Log out</a></li>

					</c:otherwise>
				</c:choose>

			</ul>
		</div>
	</nav>
	<div>
		<h1 align="center" style="color: red; height: 70px">GIỎ HÀNG</h1>
	</div>

	<form action="suaxoaController" method="post">

		<table class="table table-bordered">
			<tr align="center">
				<td><b>Check box</b></td>
				<td><b>Mã Giày</b></td>
				<td><b>Tên Giày</b></td>
				<td><b>Ảnh</b></td>
				<td><b>Giá</b></td>
				<td><b>Số lượng</b></td>
				<td width="100"><b>Chức Năng</b></td>
				<td><b>Thành tiền</b></td>
			</tr>
			<c:forEach var="s" items="${gio}">
			<tr align="center">
				<td><input type="checkbox" name="check"
					value="${s.getMaGiay()}"></td>
				<td>${s.getMaGiay()}</td>
				<td>${s.getTenGiay()}</td>
				<td><img class='img' width="70" height="70"
					src="${s.getAnh()}"></td>
				<td>${s.getGia()}</td>
				<td>${s.getSoLuong()}</td>
				<td><input type="number" min="0" name="${s.getMaGiay()}">
					<button name="butsua" value="${s.getMaGiay()}" class="btn-link"
						type="submit">
						<b>Update</b>
					</button>
					<button name="butxoa" value="${s.getMaGiay()}" class="btn-link"
						type="submit">
						<b>Delete</b>
					</button></td>
				<td>${s.getThanhTien()}VNĐ</td>					
			</tr>
			</c:forEach>
		</table>
				<div align="center">
					<h2><b style="color: #ee4d2d">Tổng tiền:</b> <b style="color: #ee4d2d">${giohang.TongTien()}</b> <b style="color: #ee4d2d">vnđ</b></h2>	
				</div> 	

	</form>
 
	
	<div class="payment" align="center">
		<div class=" text-right" >
			<a  class="btn" href="suaxoaController?btnxoatatca=alo" 
				style= "margin: 10px; background-color: #ee4d2d; color: white; border-color: black; border-radius: 10px">Xóa tất cả</a>
			<a class="btn" href="htgiayController"
				style="margin: 10px; background-color: #ee4d2d; color: white; border-color: black; border-radius: 10px">Tiếp
				tục mua hàng</a>	
				<a class="btn" href="datmuaController"
					style="margin: 10px; background-color: #ee4d2d; color: white; border-color: black; border-radius: 10px">Xác
					nhận đặt mua</a>	
		</div>
	</div>



</body>
</html>
