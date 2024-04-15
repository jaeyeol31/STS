package order.controller;

import control.Controller;
import handler.HandlerAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import order.DAO.OrderDAO;
import order.DTO.OrderDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class OrderDeleteController implements Controller {
    private static Log log = LogFactory.getLog(OrderDeleteController.class);
    @Override
    public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
       String orderlist_num = request.getParameter("orderlist_num");
       log.info(orderlist_num);

        OrderDTO orderDTO = new OrderDTO();
        OrderDAO orderDAO = new OrderDAO();

        orderDTO.setOrderlist_num(orderlist_num);
        request.setAttribute("orderDTO",orderDTO);

        orderDTO = orderDAO.orderDelete(orderlist_num);
        log.info(orderDTO);

        HandlerAdapter handlerAdapter = new HandlerAdapter();
        handlerAdapter.setPath("./WEB-INF/view/order/order_delete_view.jsp");
        return handlerAdapter;
    }
}
