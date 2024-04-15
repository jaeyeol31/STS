<%--
  Created by IntelliJ IDEA.
  User: yeoduf
  Date: 4/9/24
  Time: 9:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>배송 상세 보기</title>
</head>
<body>
<h1>배송 관리</h1>
<h5>배송 상세 보기</h5>
<table border="1">
    <thead>
    <tr>
        <th>주문 번호</th>
        <th>수령자</th>
        <th>수령자 전화번호</th>
        <th>주소</th>
        <th>배송 업체 번호</th>
        <th>요청 사항</th>
        <th>주문 내역 번호</th>
    </tr>
    </thead>
    <tbody>
    <td>${deliveryDTO.order_id}</td>
    <td>${deliveryDTO.delivery_custname}</td>
    <td>${deliveryDTO.delivery_phon}</td>
    <td>${deliveryDTO.delivery_addr}</td>
    <td>${deliveryDTO.delivery_busnum}</td>
    <td>${deliveryDTO.delivery_comment}</td>
    <td>${deliveryDTO.orderlist_num}</td>
    </tbody>
</table>
<div>
    <a href="./DeliverySelect.de?order_id=${deliveryDTO.order_id}">배송 목록</a>
    <a href="./DeliveryUpdate.de?order_id=${deliveryDTO.order_id}">배송 수정</a>
    <a href="./DeliveryDelete.de?order_id=${deliveryDTO.order_id}">배송 삭제</a>
</div>
</body>
</html>
