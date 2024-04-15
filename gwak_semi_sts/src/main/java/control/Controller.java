package control;

import handler.HandlerAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
    //비즈니스 요청을 수행하고 결괏값을 반환하는 공통기능인 execute 메서드를 설정한다.
    public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response);
}

