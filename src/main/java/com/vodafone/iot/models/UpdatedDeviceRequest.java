package com.vodafone.iot.models;

public class UpdatedDeviceRequest {

	private int deviceId;
	private int newStatusId;

	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public int getNewStatusId() {
		return newStatusId;
	}

	public void setNewStatusId(int newStatusId) {
		this.newStatusId = newStatusId;
	}

}
