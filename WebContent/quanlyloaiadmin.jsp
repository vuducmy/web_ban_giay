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
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">

			<ul class="nav navbar-nav">
				<li class="active"><a href="adminController">Trang chủ</a></li>

				<li><a href="quanlyloaiadminController">Quản lý loại</a></li>
				<li><a href="quanlygiayadminController">Quản lý giày</a></li>
				<li><a href="xacnhanController">Danh sách cần xác nhận</a></li>
				<li><a href="danhsachController">Danh sách đã xác nhận </a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span></span>Hi: ${admin.getTenDangNhap()}
				</a></li>
				<li><a href="dangnhapadminController"><span
						class="glyphicon glyphicon-user"></span> Log Out</a></li>
			</ul>
		</div>
	</nav>
	<div align="right" class="container-fluid">
		<h1 align="center" style="color: red; height: 70px">QUẢN LÝ LOẠI
		</h1>
	</div>
	<div align="right" class="container-fluid">
		<form action="themgiayadminController">
			<button name="btnThem">
				<img src="them.png" width="40" height="30">
			</button>
		</form>
	</div>
	<table style="margin-left: 10px;" class="table table-bordered">
		<tr align="center">
			<td><b>MÃ LOẠI</b></td>
			<td><b>TÊN LOẠI</b></td>
			<td><b>CHỨC NĂNG</b></td>
		</tr>
		<c:forEach var="s" items="${dsloai}">
			<tr align="center">
				<td>${s.getMaLoai()}</td>
				<td>${s.getTenLoai()}</td>
				<td align="center"><a
					href='sualoaiadminController?ml=${s.getMaLoai()}&tenloai=${s.getTenLoai()}'
					class="btn btn-success">Sửa</a> <a
					href='xoaloaiadminController?maloai=${s.getMaLoai()}'
					class="btn btn-danger">Xóa</a></td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>
