package com.whatever.ofi.config;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomFilter implements Filter {

    private static final String THIRD_PARTY_URI = "/third/party/uri";

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        if(THIRD_PARTY_URI.equals(request.getRequestURI())) {
            chain.doFilter(request, new CustomHttpServletResponseWrapper(response));
        } else {
            chain.doFilter(request, response);
        }
    }
}
