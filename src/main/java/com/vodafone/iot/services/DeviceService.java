package com.vodafone.iot.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vodafone.iot.helpers.Constants;
import com.vodafone.iot.models.Device;
import com.vodafone.iot.models.Status;
import com.vodafone.iot.models.UpdatedDeviceRequest;
import com.vodafone.iot.repositories.DeviceRepository;
import com.vodafone.iot.repositories.StatusRepositories;

@Service
public class DeviceService {

	@Autowired
	DeviceRepository deviceRepository;

	@Autowired
	StatusRepositories statusRepositories;

	public List<Device> getAllReadyDevicesWaitingActivation() {
		List<Device> waitingForActivationList = deviceRepository.findAll().stream()
				.filter(device -> device.getStatus().getId() == Constants.WAITING_FOR_ACTIVATION_STATUS)
				.collect(Collectors.toList());
		return waitingForActivationList;
	}

	public boolean removeDevice(int deviceId) {
		Optional<Device> returnedDevice = deviceRepository.findById(deviceId);
		if (returnedDevice.isPresent()) {
			deviceRepository.delete(returnedDevice.get());
			return true;
		} else {
			return false;
		}
	}

	public boolean updateDeviceStatus(UpdatedDeviceRequest updatedDeviceRequest) throws Exception {
		Status targetStatus = new Status();

		Optional<Status> newStatus = statusRepositories.findById(updatedDeviceRequest.getNewStatusId());

		if (newStatus.isPresent())
			targetStatus = newStatus.get();
		else
			throw new Exception("Wrong Status");

		Optional<Device> returnedDevice = deviceRepository.findById(updatedDeviceRequest.getDeviceId());

		if (returnedDevice.isPresent()) {
			Device device = returnedDevice.get();
			device.setStatus(targetStatus);
			deviceRepository.save(device);
		} else {
			throw new Exception("Device Not Found");
		}

		return true;
	}

	public List<Device> getAllDevicesReadyForSale() {

		List<Device> readyForSaleList = deviceRepository.findAll().stream()
				.filter(device -> device.getStatus().getId() == Constants.ACTIVE_STATUS)
				.collect(Collectors.toList());
		return readyForSaleList;

	}

}
