package order.controller;

import control.Controller;
import handler.HandlerAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import order.DAO.OrderDAO;
import order.DTO.OrderDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class OrderInsertController implements Controller {
    private static Log log = LogFactory.getLog(OrderInsertController.class);

    @Override
    public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
        // 요청 파라미터에서 받은 데이터를 가져옴
        String orderlist_num = request.getParameter("orderlist_num");
        int orderlist_amount = Integer.parseInt(request.getParameter("orderlist_amount"));
        int orderlist_status = Integer.parseInt(request.getParameter("orderlist_status"));
        String orderlist_date = request.getParameter("orderlist_date");
        String order_id = request.getParameter("order_id");

        // OrderDTO 객체에 입력된 데이터를 설정
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderlist_num(orderlist_num);
        orderDTO.setOrderlist_amount(orderlist_amount);
        orderDTO.setOrderlist_status(orderlist_status);
        orderDTO.setOrderlist_date(orderlist_date);
        orderDTO.setOrder_id(order_id);

        // OrderDAO 객체를 생성하고 입력된 주문 정보를 등록
        OrderDAO orderDAO = new OrderDAO();
        orderDTO = orderDAO.orderInsert(orderDTO);

        // 등록된 주문 정보를 로그에 출력
        log.info("등록된 주문 정보: " + orderDTO);

        // 등록된 주문 정보를 request 속성에 설정하여 View로 전달
        request.setAttribute("orderDTO", orderDTO);

        // HandlerAdapter 객체를 생성하여 View의 경로를 설정하여 반환
        HandlerAdapter handlerAdapter = new HandlerAdapter();
        handlerAdapter.setPath("/WEB-INF/view/order/order_insert_view.jsp");
        return handlerAdapter;
    }
}
