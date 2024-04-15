<%--
  Created by IntelliJ IDEA.
  User: yeoduf
  Date: 4/9/24
  Time: 10:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>배송 정보 삭제</title>
</head>
<body>
<h1>배송 관리</h1>
<h5>배송 정보 삭제</h5>
<form action="./DeliveryDelete.de" method="post" id="delivery_update">
    <div>
        <label for="order_id">주문 번호</label>
        <input type="text" name="order_id" id="order_id" value="${param.order_id}" readonly>
    </div>
    <div>
        <button type="submit">전송</button>
        <button type="reset">취소</button>
    </div>
    <div>
        <a href="./DeliverySelect.de">배송 목록</a>
        <a href="./DeliveryUpdate.de">배송 수정</a>
        <a href="./DeliveryDelete.de?order_id=${deliveryDTO.order_id}">배송 삭제</a>
    </div>
</form>
</body>
</html>
