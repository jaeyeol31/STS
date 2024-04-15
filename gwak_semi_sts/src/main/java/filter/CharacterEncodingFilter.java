package filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    FilterConfig config;

    // Filter 초기화 메서드
    @Override
    public void init(FilterConfig filterConfig) throws SecurityException {
        this.config = filterConfig;
    }

    // 요청 필터링 및 인코딩 설정 메서드
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 요청의 문자 인코딩 설정
        request.setCharacterEncoding(config.getInitParameter("encoding"));
        // 다음 필터로 요청 전달
        chain.doFilter(request, response);
    }

    // Filter 종료 메서드
    @Override
    public void destroy() {
        // 필요한 경우 자원 정리 등의 작업을 수행
    }
}
