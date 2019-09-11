package com.qf.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class MyZuulFilter extends ZuulFilter {
    /**
     * 过滤类型，根据返回值来判断什么时候执行过滤
     * "pre"     在访问具体的服务之前进行调用， 用的最多
     * "post"    在访问具体的服务之后调用
     * "error"   在访问具体的服务抛出异常
     * "route"   在访问具体的服务执行过程中
     */
    @Override
    public String filterType() {
        return "pre";
    }

    //过滤器执行的顺序
    @Override
    public int filterOrder() {
        return 1;
    }

    // 是否开启该过滤器, 如果返回false, 该过滤器无效
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 执行具体的过滤功能代码,
     * 需求：用户在请求的请求头信息中必须要包含 token 参数名。
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String token = request.getHeader("token");
        if (token == null || "".equals(token.trim())) {
            // 当为false的情况下，直接给用户一个响应，不往下走
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            requestContext.setResponseBody("invalid request.");
        }

        //返回null表示接着往下走
        return null;
    }



}

