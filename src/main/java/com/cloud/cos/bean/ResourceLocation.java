package com.cloud.cos.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "resource_location")
public class ResourceLocation implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "resource_id", length = 10)
	@GeneratedValue(strategy = GenerationType.AUTO)
	int resourceId;
	
	@Column(name = "resource_name", columnDefinition = "varchar(255)")
	String resourceName;
	
	@Column(name = "host", columnDefinition = "varchar(255)")
	String host;
	
	@Column(name = "port", columnDefinition = "int(10)")
	int port;

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
}
