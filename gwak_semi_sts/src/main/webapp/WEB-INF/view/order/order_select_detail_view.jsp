<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>상세 주문 내역 정보</title>
</head>
<body>
<h1>주문 내역 관리</h1>
<h5>상세 주문내역 정보</h5>
<table border="1">
    <thead>
    <tr>
        <th>주문 내역 번호</th>
        <th>상품명</th>
        <th>수량</th>
        <th>주문 총 금액</th>
        <th>주문 상태</th>
        <th>주문 일시</th>
        <th>배송 번호</th>
        <th>운송장 번호</th>
        <th>배송 상태</th>
        <th>배송 상세보기</th>

    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${orderDTO.orderlist_num}</td>
        <td><%--상품명--%> </td>
        <td><%--수량--%> </td>
        <td><fmt:formatNumber value="${orderDTO.orderlist_amount}" type="currency"/></td>
        <td>
            <c:choose>
                <c:when test="${orderDTO.orderlist_status eq 1}">입금대기중(무통장)</c:when>
                <c:when test="${orderDTO.orderlist_status eq 2}">결제완료</c:when>
                <c:when test="${orderDTO.orderlist_status eq 3}">상품 준비중</c:when>
                <c:when test="${orderDTO.orderlist_status eq 4}">배송중</c:when>
                <c:when test="${orderDTO.orderlist_status eq 5}">배송완료</c:when>
                <c:when test="${orderDTO.orderlist_status eq 6}">환불</c:when>
                <c:otherwise>Unknown</c:otherwise>
            </c:choose>
        </td>
        <td>${orderDTO.orderlist_date}</td>
        <td>${orderDTO.order_id}</td>
        <td><%--운송장 번호--%> </td>
        <td><%--배송상태--%> </td>
        <td>
            <a  href="./DeliverySelect.de">
                배송 상세 보기
            </a>
        </td>

    </tr>
    </tbody>
</table>
<a href="./OrderSelect.od">주문 내역 목록</a>
<a href="./OrderUpdate.od?orderlist_num=${orderDTO.orderlist_num}">주문 내역 수정</a>
<a href="./OrderDelete.od?orderlist_num=${orderDTO.orderlist_num}">주문 내역 삭제</a>
</body>
</html>
