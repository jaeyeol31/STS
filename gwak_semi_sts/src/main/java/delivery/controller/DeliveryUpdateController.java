package delivery.controller;

import control.Controller;
import handler.HandlerAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delivery.DAO.DeliveryDAO;
import delivery.DTO.DeliveryDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DeliveryUpdateController implements Controller {
    private static Log log = LogFactory.getLog(DeliveryUpdateController.class);
    @Override
    public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
        int order_id = Integer.parseInt(request.getParameter("order_id"));
        log.info(order_id);
        System.out.println(order_id);
        DeliveryDTO deliveryDTO = new DeliveryDTO();
        DeliveryDAO deliveryDAO = new DeliveryDAO();

        deliveryDTO = deliveryDAO.deliverySelect(order_id);

        request.setAttribute("order_id",order_id);
        HandlerAdapter handlerAdapter = new HandlerAdapter();
        log.info("특정 배송정보 조회");

        handlerAdapter.setPath("/WEB-INF/view/delivery/delivery_update.jsp");
        return handlerAdapter;
    }
}
