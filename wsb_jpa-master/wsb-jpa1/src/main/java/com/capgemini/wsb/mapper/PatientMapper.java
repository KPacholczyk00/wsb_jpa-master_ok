package com.capgemini.wsb.mapper;

import org.springframework.stereotype.Component;
import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import java.util.stream.Collectors;
import java.util.List;

@Component
public class PatientMapper {

    // Mapowanie PatientEntity na PatientTO
    public PatientTO toTO(PatientEntity entity) {
        return new PatientTO(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getDateOfBirth(),
                entity.getLastVisitDate(),
                entity.getVisits().stream().map(this::toVisitTO).collect(Collectors.toList()),
                entity.getAdditionalInfo()
        );
    }

    // Mapowanie PatientTO na PatientEntity
    public PatientEntity toEntity(PatientTO dto) {
        PatientEntity entity = new PatientEntity();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setDateOfBirth(dto.getDateOfBirth());
        entity.setLastVisitDate(dto.getLastVisitDate());
        entity.setVisits(dto.getVisits().stream().map(this::toEntityVisit).collect(Collectors.toSet()));
        entity.setAdditionalInfo(dto.getAdditionalInfo());
        return entity;
    }

    // Mapowanie VisitEntity na VisitTO
    private VisitTO toVisitTO(VisitEntity entity) {
        DoctorEntity doctor = entity.getDoctor();
        DoctorTO doctorTO = null;
        if (doctor != null) {
            List<String> addresses = doctor.getAddresses().stream()
                    .map(AddressEntity::toString)
                    .collect(Collectors.toList());
            doctorTO = new DoctorTO(doctor.getId(), doctor.getFirstName(), doctor.getLastName(),
                    doctor.getSpecialization(), doctor.getTelephoneNumber(),
                    doctor.getEmail(), addresses);
        }
        return new VisitTO(
                entity.getId(),
                entity.getTime(),
                doctorTO,
                entity.getPatient().getId()
        );
    }

    // Mapowanie VisitTO na VisitEntity
    private VisitEntity toEntityVisit(VisitTO dto) {
        VisitEntity entity = new VisitEntity();
        entity.setId(dto.getId());
        entity.setTime(dto.getVisitTime());
        return entity;
    }
}
