package com.example;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;



public class AccessFilter extends ZuulFilter{

	private final Logger log=Logger.getLogger(getClass());
	
	@Override
	public Object run() {
		RequestContext ctx=RequestContext.getCurrentContext();
		HttpServletRequest request=ctx.getRequest();
		System.err.println(request.getMethod());
		System.err.println(request.getRequestURL().toString());
		log.info(String.format("%s request to %s", request.getMethod(),request.getRequestURL().toString()));
		Object accessToken=request.getParameter("accessToken");
		if(accessToken==null){
			System.err.println("access token is empty");
			log.warn("access token is empty");
			ctx.setSendZuulResponse(false);//ctx.setSendZuulResponse(false)令zuul过滤该请求，不对其进行路由
			ctx.setResponseStatusCode(401);//ctx.setResponseStatusCode(401)设置了其返回的错误码
			return null;
		}
		System.err.println("access token ok");
		log.info("access token ok");
		return null;
	}

	@Override
	public boolean shouldFilter() {
		//返回一个boolean类型来判断该过滤器是否要执行，所以通过此函数可实现过滤器的开关
		//返回true，所以该过滤器总是生效
		return true;
	}

	@Override
	public int filterOrder() {
		//通过int值来定义过滤器的执行顺序
		return 0;
	}

	@Override
	public String filterType() {
		//pre：可以在请求被路由之前调用
		//routing：在路由请求时候被调用
		//pre：可以在请求被路由之前调用
		//error：处理请求时发生错误时被调用
		return "pre";
	}

}
