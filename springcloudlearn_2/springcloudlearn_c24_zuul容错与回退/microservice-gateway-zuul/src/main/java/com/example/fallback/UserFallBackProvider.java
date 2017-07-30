package com.example.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;


/**
 * 测试步骤:
 * 1,启动eureka-server,microservice-provider-user,microservice-gateway-zuul服务
 * 2,首先正常的方式访问http://localhost:8040/microservice-provider-user/1
 * 3,然后关闭microservice-provider-user服务,再次访问http://localhost:8040/microservice-provider-user/1,
 *   会返回'用户为服务不可用,请稍后再试.'
 * @author Administrator
 *
 */
@Component
public class UserFallBackProvider implements ZuulFallbackProvider{

	@Override
	public String getRoute() {//表明是为那个服务区提供回退
		return "microservice-provider-user";
	}

	@Override
	public ClientHttpResponse fallbackResponse() {
		return new ClientHttpResponse() {
			
			@Override
			public HttpHeaders getHeaders() {
				// headers设定
				HttpHeaders headers=new HttpHeaders();
				MediaType mt=new MediaType("application","json",Charset.forName("UTF-8"));
				headers.setContentType(mt);
				return headers;
			}
			
			@Override
			public InputStream getBody() throws IOException {
				// 响应体
				return new ByteArrayInputStream("用户为服务不可用,请稍后再试.".getBytes());
			}
			
			@Override
			public String getStatusText() throws IOException {
				// 状态文本,烦列返回的就是ok,详情见httpStatus
				return this.getStatusCode().getReasonPhrase();
			}
			
			@Override
			public HttpStatus getStatusCode() throws IOException {
				// fallback时的状态吗
				return HttpStatus.OK;
			}
			
			@Override
			public int getRawStatusCode() throws IOException {
				// 数字类型的状态吗,本列返回的其实就是200,详见httpStatus
				return this.getStatusCode().value();
			}
			
			@Override
			public void close() {
				
			}
		};
	}

}
