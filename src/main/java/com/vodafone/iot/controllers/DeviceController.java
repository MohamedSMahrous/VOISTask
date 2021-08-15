package com.vodafone.iot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vodafone.iot.models.Device;
import com.vodafone.iot.models.UpdatedDeviceRequest;
import com.vodafone.iot.services.DeviceService;

@RestController
public class DeviceController {

	@Autowired
	DeviceService deviceService;

	@RequestMapping(path = "/getAllWaiting", method = RequestMethod.GET)
	public ResponseEntity<?> getAllReadyDevicesWaitingActivation() {

		List<Device> allReadyDevicesWaitingActivation = deviceService.getAllReadyDevicesWaitingActivation();

		return new ResponseEntity<List<Device>>(allReadyDevicesWaitingActivation, HttpStatus.OK);
	}

	@RequestMapping(path = "/deleteDevice",method = RequestMethod.DELETE)
	public ResponseEntity<?> removeDevice(@RequestParam int deviceId) {

		boolean deleted = deviceService.removeDevice(deviceId);

		if (deleted) {
			System.out.println("Device Deleted Successfully ==> " + deleted);

			return new ResponseEntity<String>("Device Deleted Successfully", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<String>("Device Not Exist", HttpStatus.OK);
		}
	}

	@RequestMapping(path = "/updateDeviceStatus", method = RequestMethod.POST)
	public ResponseEntity<?> updateDeviceStatus(@RequestBody UpdatedDeviceRequest updatedDeviceRequest) {
		boolean updated = false;
		try {
			updated = deviceService.updateDeviceStatus(updatedDeviceRequest);
			System.out.println("Device Updated Successfully ==> " + updated);

		} catch (Exception exception) {
			return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<String>("Device Updated Successfully", HttpStatus.OK);
	}

	@RequestMapping(path = "/getAllReadyForSale", method = RequestMethod.GET)
	public ResponseEntity<?> getAllDevicesReadyForSale() {
		List<Device> allDevicesReadyForSale = deviceService.getAllDevicesReadyForSale();
		return new ResponseEntity<List<Device>>(allDevicesReadyForSale, HttpStatus.OK);
	}

}
