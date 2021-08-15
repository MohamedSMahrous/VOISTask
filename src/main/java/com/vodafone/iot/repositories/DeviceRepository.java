package com.vodafone.iot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vodafone.iot.models.Device;


@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {
}
