<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>배송 정보 입력</title>
    <script src="../../js/jquery-3.5.1.min.js" type="text/javascript"></script>
</head>
<body>
<h1>배송 관리</h1>
<h5>배송 정보 입력</h5>
<form action="./DeliveryInsert.de" method="post" id="delivery_info">
    <fieldset>
        <div>
            <label for="order_id">주문 번호</label>
            <input type="text" name="order_id" id="order_id">
        </div>
        <div>
            <label for="delivery_custname">주문자명</label>
            <input type="text" name="delivery_custname" id="delivery_custname">
        </div>
        <div>
            <label for="delivery_phon">전화번호</label>
            <input type="text" name="delivery_phon" id="delivery_phon">
        </div>
        <div>
            <label for="delivery_addr">배송 주소</label>
            <input type="text" name="delivery_addr" id="delivery_addr">
        </div>
        <div>
            <label for="delivery_busnum">업체 번호</label>
            <input type="text" name="delivery_busnum" id="delivery_busnum">
        </div>
        <div>
            <label for="delivery_comment">배송 요청 사항</label>
            <textarea name="delivery_comment" id="delivery_comment"></textarea>
        </div>
        <div>
            <label for="orderlist_num">주문 목록 번호</label>
            <input type="text" name="orderlist_num" id="orderlist_num">
        </div>
        <div>
            <button type="submit">등록</button>
            <button type="reset">취소</button>
        </div>
    </fieldset>
</form>
<div>
    <a href="./DeliverySelect.de">배송 목록</a>
</div>
</body>
</html>
