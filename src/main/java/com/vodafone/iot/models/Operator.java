package com.vodafone.iot.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Operator {

	@Id
	private int id;
	private int operatorId;
	private String operatorName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

}
