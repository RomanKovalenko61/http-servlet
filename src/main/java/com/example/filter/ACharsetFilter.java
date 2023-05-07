package com.example.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;

import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;

@WebFilter(value = "/*",
//        servletNames = {
//                "RegistrationServlet"
//        },
        initParams = {
                @WebInitParam(name = "param1", value = "paramValue")
        },
        dispatcherTypes = DispatcherType.REQUEST)
public class ACharsetFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(UTF_8.name());
        response.setCharacterEncoding(UTF_8.name());
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
}