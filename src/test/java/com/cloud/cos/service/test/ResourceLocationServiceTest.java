package com.cloud.cos.service.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cloud.cos.bean.ResourceLocation;
import com.cloud.cos.service.ResourceLocationService;

public class ResourceLocationServiceTest {

	@Autowired
	private ResourceLocationService resourceService;
	
	@Test
	public void test() {
		ResourceLocation resourceLocation = resourceService.getResourceLocation(1);
		System.out.println("###################################");
		System.out.println("id:                        " + resourceLocation.getResourceId());
		System.out.println("name:                      " + resourceLocation.getName());
		System.out.println("host:                      " + resourceLocation.getHost());
		System.out.println("port:                      " + resourceLocation.getPort());
		System.out.println("protocol:                  " + resourceLocation.getProtocol());
		System.out.println("###################################");
	}

}
