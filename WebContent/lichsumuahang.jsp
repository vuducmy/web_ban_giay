
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style>

	body{
		width: 100%;
		overflow-x: hidden;
	}
	*{
		box-sizing: border-box;
	}

	.box{
		display: flex;
	}
	
	.box__item{
		display: flex;
		flex-direction: column;
	}
	.img{
		margin-right: 16px;
	}
	
	.header{
		position: fixed;
		top: 0;
		right: 0;
		left: 0;
		border-top-left-radius: 0;
		border-top-right-radius: 0;
	}
	
	.table{
		width: 100vw;
	}
	
	.table__item{
		margin-top: 40px;
	}
	
	.paddingBottom{
		padding-bottom: 8px;
	}
	
	.container{
		display: flex;
		width: 100vw;
	}
	
	.containerItem{
		width: 200px;
		
	}
	
	.containerItem.maxWidth{
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
	
	.pagination a:hover:not(.active) {background-color: #ddd;}
	.navContent{
		display: flex;
		flex-direction: column;
	}
	
	.box{
		display: flex;
		
	}
	
	.navItem{
		width: 100%;
		padding: 8px 0;
		border-bottom: 1px solid #ccc;
		text-decoration: none;
		text-transform: none;
	}
	
	a:hover{
		color: #23527c;
    	text-decoration: none;
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
		<h1 align="center" style="color: red; height: 70px">LỊCH SỬ MUA HÀNG</h1>
	</div>
			<c:choose>
				<c:when test="${dslsmh != null}">			
				<table class="table table-bordered">
					<tr align="center">
						<td> <b>Mã khách hàng</b></td>
					    <td> <b>Tên giày</b> </td>
					    <td> <b>Ngày mua</b> </td>
						<td> <b>Số lượng</b></td>
					    <td> <b>Giá</b> </td>
					    <td> <b>Thanh tiền</b> </td>
						<td> <b>Tình trạng</b> </td>
					</tr>
					
						<c:forEach var="item" items="${dslsmh}">
							<tr align="center">
								<td>${item.getMaKhachHang() }</td>
								<td>${item.getTenGiay() }</td>
								<td>${item.getNgayMua() }</td>
								<td>${item.getSoLuongMua() }</td>
								<td>${item.getGia() }</td>
								<td>${item.getThanhTien() }</td>
								<td>${item.isDaMua() ? "Đã thanh toán" : "Chưa thanh toán" }</td>
							</tr>
						</c:forEach>		
				</table>
				</c:when>
				<c:otherwise>
					 Bạn chưa có đơn hàng, mời bạn <a href="giohangController">Đặt mua hàng</a>
				</c:otherwise>
			</c:choose>
</body>
</html>