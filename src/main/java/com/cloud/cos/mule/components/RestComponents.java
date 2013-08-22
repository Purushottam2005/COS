package com.cloud.cos.mule.components;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@Path("/v1")
public class RestComponents implements ApplicationContextAware{

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		
	}

	@GET
	@Path("/apps/{app_id}/{reduce_count}")
	public Response getData(@Context UriInfo uriInfo) {
		MultivaluedMap<String, String> params = uriInfo.getPathParameters();
		
		String appId = params.getFirst("app_id");
		int reduceCount = Integer.parseInt(params.getFirst("reduce_count"));
		
		System.out.println("###################################");
		System.out.println("appId:               " + appId);
		System.out.println("reduceCount:         " + reduceCount);
		System.out.println("###################################");
		
		return Response.ok().build();
	}
}
