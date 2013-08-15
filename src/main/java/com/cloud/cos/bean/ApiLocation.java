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
	@Column(name = "api_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@Column(name = "api", columnDefinition = "varchar(1024)")
	int api;
	
	@Column(name = "host", columnDefinition = "varchar(255)")
	String host;
	
	@Column(name = "port")
	int port;

	

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
