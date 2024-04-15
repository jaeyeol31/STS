package order.frontcontroller;

import java.io.*;

import control.Controller;
import handler.HandlerAdapter;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import order.controller.*;
import org.apache.commons.logging.*;


public class OrderDispatcherServlet extends HttpServlet implements Servlet {

    private static Log log = LogFactory.getLog(OrderDispatcherServlet.class);
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        String contextPath = request.getContextPath();

        String pathURL = requestURI.substring(contextPath.length());
        log.info("매핑명 조회 - " + pathURL);

        HandlerAdapter handlerAdapter = null;

        Controller controller = null;

        if (pathURL.equals("/OrderSelect.od")) {
            controller = new OrderSelectController();
            handlerAdapter = controller.execute(request, response);
            log.info("주문내역 조회 확인 " + handlerAdapter);

        } else if (pathURL.equals("/OrderSelectDetail.od")) {
            controller = new OrderSelectDetailController();
            handlerAdapter = controller.execute(request, response);
            log.info("주문내역 상세 조회 확인 " + handlerAdapter);

        } else if (pathURL.equals("/OrderInsertView.od")) {
            handlerAdapter = new HandlerAdapter();
            handlerAdapter.setPath("/WEB-INF/view/order/order_insert.jsp");
            log.info("배송 등록 화면 뷰 확인 - " + handlerAdapter);

        } else if (pathURL.equals("/OrderInsert.od")) {
            controller = new OrderInsertController();
            handlerAdapter = controller.execute(request, response);
            log.info("주문내역 등록 확인 " + handlerAdapter);

        } else if (pathURL.equals("/OrderUpdateView.od")) {
            controller = new OrderUpdateViewController();
            handlerAdapter = controller.execute(request, response);
            log.info("주문 수정 화면 뷰"+ handlerAdapter);

        } else if (pathURL.equals("/OrderUpdate.od")) {
            controller = new OrderUpdateController();
            handlerAdapter = controller.execute(request, response);
            log.info("주문내역 수정 확인"+ handlerAdapter);

        } else if (pathURL.equals("/OrderDeleteView.od")) {
            handlerAdapter = new HandlerAdapter();
            handlerAdapter.setPath("/WEB-INF/view/order/order_delete.jsp");
            log.info("주문내역 삭제 화면 뷰"+ handlerAdapter);

        } else if (pathURL.equals("/OrderDelete.od")) {
            controller = new OrderDeleteController();
            handlerAdapter = controller.execute(request, response);
            log.info("주문내역 삭제 확인 " + handlerAdapter);
        }

        if (handlerAdapter != null) {
            if (handlerAdapter.isRedirect()) {
                response.sendRedirect(handlerAdapter.getPath());
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher(handlerAdapter.getPath());
                dispatcher.forward(request, response);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        service(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        service(request, response);
    }
}