package com.zrain.springcloud.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.zrain.springcloud.servicezuul.constants.Constants;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Idan on 2017/9/24.
 */

@Component
public class MyZuulFilter extends ZuulFilter {

    private static Logger logger = Logger.getLogger(MyZuulFilter.class);

    @Override
    public String filterType() {
        return Constants.FILTER_TYPE_PRE;
    }

    @Override
    public int filterOrder() {
        return Constants.FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        logger.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));

        Object accessToken = request.getParameter("token");
        if (accessToken == null) {
            logger.warn("token is empty");

            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);

            try {
                ctx.getResponse().getWriter().write("token is empty");
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }
        logger.info("ok");
        return null;
    }
}
