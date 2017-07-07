package com.example.fliter;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class PostFilter extends ZuulFilter{
	
	private final Logger logger=LoggerFactory.getLogger(getClass());

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		logger.info("this is a post filter : Receive response");
		HttpServletResponse response=RequestContext.getCurrentContext().getResponse();
		try {
			response.getOutputStream().print(", iam PostFilter");
			response.flushBuffer();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return null;
	}

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 2000;
	}

}
