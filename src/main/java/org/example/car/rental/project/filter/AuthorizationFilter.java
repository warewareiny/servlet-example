package org.example.car.rental.project.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Set;

@WebFilter("/*")
public class AuthorizationFilter implements Filter {

    private static final Set<String> PUBLIC_PATHS = Set.of(
            "/login",
            "/registration"
    );

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String requestURI = req.getRequestURI();
        String contextPath = req.getContextPath();

        if (isPublicPath(requestURI, contextPath)) {
            chain.doFilter(request, response);
            return;
        }

        HttpSession session = req.getSession(false);
        boolean isLoggedIn = session != null && session.getAttribute("user") != null;

        if (isLoggedIn) {
            chain.doFilter(request, response);
        } else {
            resp.sendRedirect(contextPath + "/login");
        }
    }

    private boolean isPublicPath(String requestURI, String contextPath) {
        String path = requestURI.substring(contextPath.length());

        return PUBLIC_PATHS.stream()
                .anyMatch(publicPath -> path.startsWith(publicPath) || path.equals(""));
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}
}