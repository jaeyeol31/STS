package delivery.controller;

import control.Controller;
import delivery.DAO.DeliveryDAO;
import delivery.DTO.DeliveryDTO;
import handler.HandlerAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DeliverySelectDetailController implements Controller {
    private static Log log = LogFactory.getLog(DeliverySelectDetailController.class);
    @Override
    public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
        int order_id = Integer.parseInt(request.getParameter("order_id"));
        log.info(order_id);
        DeliveryDTO deliveryDTO = new DeliveryDTO();
        DeliveryDAO deliveryDAO = new DeliveryDAO();

        deliveryDTO = deliveryDAO.deliverySelect(order_id);
        log.info(deliveryDTO);
        request.setAttribute("deliveryDTO",deliveryDTO);
        HandlerAdapter handlerAdapter = new HandlerAdapter();
        log.info("특정 배송 정보 조회");
        handlerAdapter.setPath("/WEB-INF/view/delivery/delivery_select_detail_view.jsp");


        return handlerAdapter;
    }
}
