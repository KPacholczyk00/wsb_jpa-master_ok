package com.capgemini.wsb.service;
import com.capgemini.wsb.persistence.dao.DoctorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.capgemini.wsb.persistence.entity.DoctorEntity;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<DoctorEntity> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public DoctorEntity getDoctorById(Long id) {
        return doctorRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Doctor nie znaleziony z tym id: " + id)
        );
    }
}
