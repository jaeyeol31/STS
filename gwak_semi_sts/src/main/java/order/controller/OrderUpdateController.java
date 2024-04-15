package order.controller;

import control.Controller;
import handler.HandlerAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import order.DAO.OrderDAO;
import order.DTO.OrderDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class OrderUpdateController implements Controller {
    private static Log log = LogFactory.getLog(OrderUpdateController.class);

    @Override
    public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
        String  orderlist_num = request.getParameter("orderlist_num");
        log.info(orderlist_num);

        System.out.println(orderlist_num);
        OrderDTO orderDTO = new OrderDTO();
        OrderDAO orderDAO = new OrderDAO();

        orderDTO = orderDAO.orderSelect(orderlist_num);

        request.setAttribute("orderDTO", orderDTO);
        HandlerAdapter handlerAdapter = new HandlerAdapter();
        log.info("특정 주문정보 조회");

        handlerAdapter.setPath("/WEB-INF/view/order/order_update.jsp");
        return handlerAdapter;
    }
}
