package order.controller;

import control.Controller;
import handler.HandlerAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import order.DAO.OrderDAO;
import order.DTO.OrderDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;

public class OrderSelectController implements Controller {
    private static Log log = LogFactory.getLog(OrderSelectController.class);
    @Override
    public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
        OrderDTO orderDTO  = new OrderDTO();
        OrderDAO orderDAO  = new OrderDAO();
        log.info(orderDTO);

        ArrayList<OrderDTO> orderList = new ArrayList<OrderDTO>();
        orderList = orderDAO.orderSelectAll();
        log.info(orderList);

        request.setAttribute("orderList",orderList);
        HandlerAdapter handlerAdapter = new HandlerAdapter();
        log.info("주문내역 정보 조회");

        handlerAdapter.setPath("/WEB-INF/view/order/order_select_view.jsp");
        return handlerAdapter;
    }
}
