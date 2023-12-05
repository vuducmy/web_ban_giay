
<%@page import="bean.danhsachbean"%>
<%@page import="bean.xacnhanbean"%>
<%@page import="bean.dangnhapadminbean"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="bean.loaibean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bo.loaibo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
				<li><a href="#"><span></span>Hi: ${admin.getTenDangNhap()}
				</a></li>
				<li><a href="dangnhapadminController"><span
						class="glyphicon glyphicon-user"></span> Log Out</a></li>
			</ul>
		</div>
	</nav>
	<div>
		<h1 align="center" style="color: red; height: 70px">DANH SÁCH ĐÃ XÁC NHẬN</h1>
	</div>
	
	<table class="table table-bordered">
		<tr  align="center">
			<td>  <b>Họ Tên</b> </td>
			<td > <b> Tên giày</b></td>
			<td> <b>Số lượng mua</b> </td>
			<td> <b>Giá</b> </td>
			<td> <b>Thành tiền</b> </td>
			<td> <b> Hình thức</b> </td>
		</tr>
		<c:forEach var="s" items="${ds}">
			<tr align="center">
				<td>${s.getHoTen()}</td>
				<td>${s.getTenGiay()}</td>
				<td>${s.getSoLuongMua()}</td>
				<td>${s.getGia()}</td>
				<td>${s.getThanhTien()}</td>
				<td>Đã Xác nhận</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

