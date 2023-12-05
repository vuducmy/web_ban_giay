
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

				<li><a href="ktdksvl"><span
						class="glyphicon glyphicon-user"></span> Sign in</a></li>
				<c:choose>
					<c:when test="${dn == null}">
						<li><a href="ktdnsvl"><span
								class="glyphicon glyphicon-log-in"></span> Login</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="#"><span></span>Hi: ${dn} </a></li>
						<li><a href="ktdnsvl"><span
								class="glyphicon glyphicon-log-out"></span> Log out</a></li>

					</c:otherwise>
				</c:choose> 

			</ul>
		</div>
	</nav>

	<div style='display: flex'>

		<div style='width: 100%'>
			<c:choose>
				<c:when test="${gio != null}">

					<form action="suaxoaController" method="post">
						<table class="table table-hover">
							<thead>
								<tr>
									<th></th>
									<th>Mã giày</th>
									<th>Tên giày</th>
									<th>Ảnh</th>
									<th>Giá</th>
									<th>Số lượng</th>
									<th>Thành tiền</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
							    
								<c:forEach var="s" items="${gio}">
										<tr>
											<td><input name="check" type="checkbox"
												value="${s.getMaGiay()}"></td>
											<td>${s.getMaGiay()}</td>
											<td>${s.getTenGiay()}</td>
											<td> <img class='img' width="70" height="70" src="${s.getAnh()}"></td>
											<td>${s.getGia()}</td>
											<td>${s.getSoLuong()}</td>
											<td>
												<div style="display: flex">
													<div>
														<input class="form-control" style="width: 80px"
															name="t${s.getMaGiay()}" type="number"
															min="1">
													</div>
													<div>
														<button style="margin: 0 5px 0 5px" type="submit"
															name="butsua" class="btn btn-info"
															value="${s.getMaGiay()}">Cập nhật</button>
													</div>
													<div>
														<button name="butxoa" type="submit"
															class="btn btn-warning" value="${s.getMaGiay()}">Xóa</button>
													</div>
												</div>
											</td>

										</tr> 
									
								</c:forEach>
								
								<tr>
								</tr>
							</tbody>
						</table>
						<div class="contain" style="display: flex">
							<%-- <div>
								<b>Tổng tiền: ${gio.TongTien() }</b>
							</div> --%>

							<div style="margin-left: 10px">
								<button name="btnxoatatca" type="submit" class="btn btn-danger"
									value="haha">Xóa tất cả</button>
							</div>
							<div></div>
						</div>
					</form>
					<form action="datmuaController" method="post">
						<div style="margin-left: 300px">
								<button name="but1" type="submit" class="btn btn-info"
									value="haha">Xác nhận</button>
							</div>
					</form>
				</c:when>
				<c:otherwise>
					 Giỏ hàng đang trống, mời bạn <a href="htgiayController">Chọn mua hàng</a>
				</c:otherwise>
			</c:choose>

		</div>
	</div>

</body>
</html>