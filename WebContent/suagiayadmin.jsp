<%@page import="java.util.ArrayList"%>

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

.form-container{
	display: flex;
	flex-direction: column;
	width: 60vw;
	margin-left: auto;
	margin-right: auto;
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
		</div>
	</nav>
	<a href='quanlygiayadminController' class="btn btn-primary" style='margin-left: 20px;'><i class="fa-solid fa-circle-left"></i> Quay lại</a>
	<c:set var="giay" scope="request" value="${giay}" />
	<c:forEach var="giay" items="${giay }">
		<form action="suagiayadminController2?mg=${giay.getMaGiay() }" method="post" enctype="multipart/form-data" class='form-container'>
			<div class="form-row">
				<div class="form-group col-md-12">
					<label for="inputPassword4">Tên giày</label> 
					<input name="tg"
						type="text" class="form-control" id="inputPassword4"
						required="required"  value="${giay.getTenGiay() }">
				</div>
				<div class="form-group col-md-6">
					<label for="inputEmail4">Số lượng</label> <input type="text"
						name="sl" name="" class="form-control" id="inputEmail4"
						required="required" value="${giay.getSoLuong() }">
				</div>
				<div class="form-group col-md-6">
					<label for="inputPassword4">Giá</label> <input type="text"
						name="gia" name="" class="form-control" id="inputPassword4"
						required="required" value="${giay.getGia() }">
				</div>
					<div class="form-group col-md-6">
					<label for="inputPassword4">Ngày nhập</label> <input type="date"
						name="ngaynhap" class="form-control" id="inputPassword4"
						required="required"  value="${giay.getNgayNhap() }">
				</div>
				<div class="form-group col-md-6">
					<label for="inputState">Mã loại</label> <select id="inputState"
						name="ml" class="form-control" required="required"  value="${giay.getMaLoai() }">
						<c:forEach var="s" items="${dsloai }">
							<option ${ giay.getMaLoai().equals(s.getMaLoai()) ? "selected" : ""} value="${s.getMaLoai() }">${s.getTenLoai() }</option>
						</c:forEach>
					</select>
				</div>
								
				
				<div class="form-group col-md-12">
					<label for="inputPassword4">Ảnh</label> <input type="file"
						name="txtfile" accept="image/png, image/jpeg"
						class="form-control-file" id="exampleFormControlFile1"
						required="required" value="${giay.getAnh()}">
				</div>
			</div>
				
			<button type="submit" class="btn btn-primary" name="btnSave">
				<i class="fa-solid fa-floppy-disk"></i> Sửa giày
			</button>
	
		</form>
	</c:forEach>
<script>
	const fileInput = document.querySelector('#exampleFormControlFile1')
	let fileName = fileInput.getAttribute('value')
	let file = new File([new Blob()], fileName,{type:"image/jpeg", lastModified:new Date().getTime()}, 'utf-8');
	const dataTransfer = new DataTransfer();
	dataTransfer.items.add(file);
    fileInput.files = dataTransfer.files;
</script>
</body>
</html>