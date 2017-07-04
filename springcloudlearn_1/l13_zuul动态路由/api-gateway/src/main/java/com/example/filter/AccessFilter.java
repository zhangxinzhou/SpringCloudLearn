package com.example.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class AccessFilter extends ZuulFilter{
	
	private Logger log=LoggerFactory.getLogger(getClass());

	@Override
	public boolean shouldFilter() {
		// 过滤器是否开启(可以使用逻辑动态控制)
		return true;
	}

	@Override
	public Object run() {
		// ctx.setSendZuulResponse(false);过滤请求ctx.setResponseStatusCode(401)设置返回错误码
		RequestContext ctx=RequestContext.getCurrentContext();
		HttpServletRequest request=ctx.getRequest();
		log.info("send [{}] request to [{}]",request.getMethod(),request.getRequestURI().toString());
		Object accessToken=request.getParameter("accessToken");
		if(accessToken==null){
			log.warn("accss token is empty");
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			return null;
		}
		log.info("access token ok");
		return null;
	}

	@Override
	public String filterType() {
		// 过滤类型,pre代表在请求被路由之前执行
		return "pre";
	}

	@Override
	public int filterOrder() {
		// 执行优先级
		return 0;
	}

}
