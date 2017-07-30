package com.example.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class PreRequestLogFilter extends ZuulFilter{
	
	private final Logger logger=LoggerFactory.getLogger(getClass());

	@Override
	public boolean shouldFilter() {//是否执行
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx=RequestContext.getCurrentContext();
		HttpServletRequest request=ctx.getRequest();
		logger.info(String.format("send %s request to %s", request.getMethod(),request.getRequestURL().toString()));
		return null;
	}

	@Override
	public String filterType() {//四种类型"pre","route","post","error"
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
