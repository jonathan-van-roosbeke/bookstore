package com.cda.Controller;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public abstract class AbstractController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void init(final ServletConfig config) throws ServletException {
        super.init(config);
        WebApplicationContext springContext = WebApplicationContextUtils
                .getRequiredWebApplicationContext(config.getServletContext());
        final AutowireCapableBeanFactory beanFactory = springContext.getAutowireCapableBeanFactory();
        beanFactory.autowireBean(this);
    }
}