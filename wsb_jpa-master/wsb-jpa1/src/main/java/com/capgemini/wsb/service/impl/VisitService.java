package com.capgemini.wsb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.dao.VisitRepository;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.mapper.VisitMapper;

@Service
public class VisitService {
    private final VisitRepository visitRepository;
    private final VisitMapper visitMapper;

    @Autowired
    public VisitService(VisitRepository visitRepository, VisitMapper visitMapper) {
        this.visitRepository = visitRepository;
        this.visitMapper = visitMapper;
    }

    public List<VisitTO> findAllVisits() {
        return visitRepository.findAll().stream()
                .map(visitMapper::toTO)
                .collect(Collectors.toList());
    }

    public VisitTO findVisitById(Long id) {
        VisitEntity visitEntity = visitRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Visit nie znaleziony z tym id: " + id));
        return visitMapper.toTO(visitEntity);
    }
}
