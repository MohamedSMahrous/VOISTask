package com.vodafone.iot.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Status {

	@Id
	private int id;
	private String statusName;
	
	public Status() {}
	
	public Status(int id, String statusName) {
		super();
		this.id = id;
		this.statusName = statusName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

}
