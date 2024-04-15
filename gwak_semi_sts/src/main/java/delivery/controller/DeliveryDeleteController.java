package delivery.controller;

import control.Controller;
import delivery.DAO.DeliveryDAO;
import delivery.DTO.DeliveryDTO;
import handler.HandlerAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DeliveryDeleteController implements Controller {
    private static Log log = LogFactory.getLog(DeliveryDeleteController.class);
    @Override
    public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
        int order_id = Integer.parseInt(request.getParameter("order_id"));
        log.info(order_id);
        DeliveryDAO deliveryDAO = new DeliveryDAO();
        DeliveryDTO deliveryDTO = new DeliveryDTO();

        deliveryDTO.setOrder_id(order_id);

        request.setAttribute("deliveryDTO",deliveryDTO);

        deliveryDTO = deliveryDAO.deliveryDelete(order_id);
        log.info(deliveryDTO);
        HandlerAdapter handlerAdapter = new HandlerAdapter();
        handlerAdapter.setPath("/WEB-INF/view/delivery/delivery_delete_view.jsp");
        return handlerAdapter;
    }
}
