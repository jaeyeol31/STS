package order.controller;

import control.Controller;
import handler.HandlerAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import order.DAO.OrderDAO;
import order.DTO.OrderDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class OrderUpdateViewController implements Controller {
    private static Log log = LogFactory.getLog(OrderUpdateViewController.class);

    @Override
    public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {

        String orderlist_num = request.getParameter("orderlist_num");
        log.info(orderlist_num);

        int orderlist_amount = Integer.parseInt(request.getParameter("orderlist_amount"));
        log.info(orderlist_amount);

        int orderlist_status = Integer.parseInt(request.getParameter("orderlist_status"));
        log.info(orderlist_status);

        String orderlist_date = request.getParameter("orderlist_date");
        log.info(orderlist_date);

        String  order_id = request.getParameter("order_id");
        log.info(order_id);

        OrderDAO orderDAO = new OrderDAO();
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setOrderlist_num(orderlist_num);
        orderDTO.setOrderlist_amount(orderlist_amount);
        orderDTO.setOrderlist_status(orderlist_status);
        orderDTO.setOrderlist_date(orderlist_date);
        orderDTO.setOrder_id(order_id);

        orderDTO = orderDAO.orderUpdate(orderDTO);
        log.info(orderDTO);

        request.setAttribute("orderDTO", orderDTO);
        HandlerAdapter handlerAdapter = new HandlerAdapter();

        handlerAdapter.setPath("/WEB-INF/view/order/order_update_view.jsp");
        return handlerAdapter;
    }
}
