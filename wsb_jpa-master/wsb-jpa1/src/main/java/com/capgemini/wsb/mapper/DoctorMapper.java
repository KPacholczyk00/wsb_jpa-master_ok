package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import java.util.stream.Collectors;

public class DoctorMapper {

    public DoctorTO toTO(DoctorEntity entity) {
        return new DoctorTO(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getSpecialization(),
                entity.getTelephoneNumber(),
                entity.getEmail(),
                entity.getAddresses().stream().map(address -> address.getAddressDetail()).collect(Collectors.toList())
        );
    }

    public DoctorEntity toEntity(DoctorTO dto) {
        DoctorEntity entity = new DoctorEntity();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setSpecialization(dto.getSpecialization());
        entity.setTelephoneNumber(dto.getTelephoneNumber());
        entity.setEmail(dto.getEmail());
        // Implementacja mapowania listy adresów z DTO na encje

        return entity;
    }
}
