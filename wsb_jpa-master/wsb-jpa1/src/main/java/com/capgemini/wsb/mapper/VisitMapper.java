package com.capgemini.wsb.mapper;

import org.springframework.stereotype.Component;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import java.util.stream.Collectors;

@Component
public class VisitMapper {

    public VisitTO toTO(VisitEntity entity) {
        if (entity == null) {
            return null;
        }
        VisitTO visitTO = new VisitTO();
        visitTO.setId(entity.getId());
        visitTO.setVisitTime(entity.getTime());

        if (entity.getDoctor() != null) {
            DoctorMapper doctorMapper = new DoctorMapper();
            visitTO.setDoctor(doctorMapper.toTO(entity.getDoctor()));
        }
        visitTO.setPatientId(entity.getPatient().getId());

        return visitTO;
    }
}
