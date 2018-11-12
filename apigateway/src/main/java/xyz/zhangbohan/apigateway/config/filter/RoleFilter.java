/*
 * Copyright (c) 2018. zhangbohan.dell@gmail.com ,All Rights Reserved
 *
 */

package xyz.zhangbohan.apigateway.config.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.log4j.Log4j;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;

/**
 * file encoding: utf-8
 * Function :
 * Create : 2018/10/17 13:51
 *
 * @author : zhangbohan.dell@gmail.com
 * @version : 1.0
 */
@Log4j
public class RoleFilter extends ZuulFilter {
    /**
     * 过滤器类型，决定过滤器在请求的哪个周期中执行
     * 定义为pre，在请求被路由之前执行
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器的执行顺序，当一个阶段中存在多个过滤器的时候，根据该方法返回值一次执行
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断该过滤器是否需要执行。这里我们直接返回true，因此该过滤器对所有请求都生效。实际中利用该函数来指定过滤器的有效范围
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        log.info(String.format("send %s request to %s",request.getMethod(),request.getRequestURL().toString()));
        String accessToken = request.getParameter("accessToken");
        if (accessToken == null) {
            log.warn("access token is empty");
            currentContext.setSendZuulResponse(false); //设置不对其进行路由
            currentContext.setResponseStatusCode(401); //设置错误返回码
            currentContext.setResponseBody("没有access token");  //设置返回的body内容
            return null;
        }
        log.info("access token ok");
        return null;
    }
}
