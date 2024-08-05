package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        String url = ((HttpServletRequest) req).getRequestURI();
        if (url.toLowerCase().endsWith(".js") ||
                url.toLowerCase().endsWith(".css") ||
                url.toLowerCase().endsWith(".ttf")) {
            filterChain.doFilter(req, resp);
            return;
        }

        Object isAuthorised = ((HttpServletRequest) req).getSession().getAttribute("isAuthorised");
        if (isAuthorised == null && url.toLowerCase().endsWith("/login")) {
            filterChain.doFilter(req, resp);
            return;
        }

        if (isAuthorised != null) {
            filterChain.doFilter(req, resp);
            return;
        }

        ((HttpServletResponse)resp).sendRedirect("/login");
    }

    @Override
    public void destroy() {

    }
}
