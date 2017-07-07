package com.example.fliter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class PreFilter extends ZuulFilter{
	
	private final Logger logger=LoggerFactory.getLogger(getClass());

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		HttpServletRequest request=RequestContext.getCurrentContext().getRequest();
		logger.info("this is a pre filter : Send [{}] to [{}]",request.getMethod(),request.getRequestURL());
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1000;
	}

}
