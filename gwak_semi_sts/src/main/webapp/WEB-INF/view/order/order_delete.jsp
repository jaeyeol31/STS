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
    <title>주문 내역 삭제</title>
</head>
<body>
<h1>주문 내역 관리</h1>
<h5>주문 내역 삭제</h5>
<form action="./OrderDelete.od" method="post">
    <fieldset>
        <div>
            <label for="orderlist_num">주문 내역 번호</label>
            <input type="text" name="orderlist_num" id="orderlist_num" value="${param.orderlist_num}" readonly>
        </div>
        <div>
            <button type="submit">삭제</button>
            <button type="reset">취소</button>
        </div>
    </fieldset>
</form>
</body>
</html>
