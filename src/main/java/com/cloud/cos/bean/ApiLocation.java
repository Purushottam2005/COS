package com.cloud.cos.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "api_location")
public class ApiLocation implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "api_id", length = 10)
	@GeneratedValue(strategy = GenerationType.AUTO)
	int apiId;
	
	@Column(name = "api", columnDefinition = "varchar(1024)")
	int api;
	
	@Column(name = "host", columnDefinition = "varchar(255)")
	String host;
	
	@Column(name = "port", columnDefinition = "int(10)")
	int port;

	public int getApiId() {
		return apiId;
	}

	public void setApiId(int apiId) {
		this.apiId = apiId;
	}

	public int getApi() {
		return api;
	}

	public void setApi(int api) {
		this.api = api;
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
