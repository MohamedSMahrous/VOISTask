package com.vodafone.iot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vodafone.iot.models.Status;

@Repository
public interface StatusRepositories extends JpaRepository<Status, Integer>{

}
