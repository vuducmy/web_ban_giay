
<%@page import="bean.dangnhapadminbean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="bean.loaibean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bo.loaibo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Quản lý giày</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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
      <li>
      <%if(session.getAttribute("admin")==null){ %>
      <a href="dangnhapadminController">
      <span class="glyphicon glyphicon-log-in"></span>
       Login
       </a>
       <%}else{ %>
       <a href="#">
	      <span class="glyphicon glyphicon-log-in"></span>
	       Hi: <%
	       dangnhapadminbean kh =(dangnhapadminbean)session.getAttribute("admin");
	        out.print(kh.getTenDangNhap());
	       %>
	       </a>
	       <%} %>
       </li>
        <li><a href="dangnhapadminController	"><span class="glyphicon glyphicon-user"></span> Log Out</a></li>
    </ul>
  </div>
</nav>
  
<table class="table" width="1000" align="center">
	</table>
</body>
</html>
