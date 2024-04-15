function order_select() {
    var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
    table = document.getElementById("orderTable");
    switching = true;
    dir = document.getElementById("sortOrder").value; // 셀렉트 박스에서 선택한 값 가져오기
    while (switching) {
        switching = false;
        rows = table.rows;
        for (i = 1; i < (rows.length - 1); i++) {
            shouldSwitch = false;
            x = rows[i].getElementsByTagName("TD")[3]; // 주문 일시 컬럼에 해당하는 열 인덱스(0부터 시작)
            y = rows[i + 1].getElementsByTagName("TD")[3]; // 다음 행의 주문 일시 컬럼에 해당하는 열 인덱스(0부터 시작)
            if (dir === "asc") {
                if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                    shouldSwitch = true;
                    break;
                }
            } else if (dir === "desc") {
                if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                    shouldSwitch = true;
                    break;
                }
            }
        }
        if (shouldSwitch) {
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
            switchcount++;
        } else {
            if (switchcount === 0 && dir === "desc") {
                dir = "asc"; // 내림차순일 때만 오름차순으로 변경하여 다시 정렬
                switching = true;
            }
        }
    }
}

//주문상태에 따라 보기

function filterOrders() {
    var selectBox = document.getElementById("orderStatus");
    var selectedStatus = selectBox.value;
    var table = document.getElementById("orderTable");
    var rows = table.rows;

    for (var i = 1; i < rows.length; i++) {
        var row = rows[i];
        var statusCell = row.cells[2]; // 주문 상태가 있는 셀의 인덱스(0부터 시작)
        var statusText = statusCell.innerText.trim(); // 문자열 앞뒤 공백 제거

        // 주문 상태를 숫자로 변환하여 처리
        var statusValue;
        switch (statusText) {
            case "입금대기중(무통장)":
                statusValue = 1;
                break;
            case "결제완료":
                statusValue = 2;
                break;
            case "상품 준비중":
                statusValue = 3;
                break;
            case "배송중":
                statusValue = 4;
                break;
            case "배송완료":
                statusValue = 5;
                break;
            case "환불":
                statusValue = 6;
                break;
            default:
                statusValue = 0; // 알 수 없는 상태는 0으로 설정
                break;
        }

        if (selectedStatus === "all" || statusValue === parseInt(selectedStatus)) {
            row.style.display = ""; // 선택한 상태가 "전체"이거나 선택한 상태에 해당하는 주문 상태인 경우 표시
        } else {
            row.style.display = "none"; // 그렇지 않은 경우 숨김
        }
    }
}


