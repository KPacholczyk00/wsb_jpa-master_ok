package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.dao.PatientRepository;
import com.capgemini.wsb.mapper.PatientMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import com.capgemini.wsb.dto.VisitTO;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class PatientServiceTest {

    @Mock
    private PatientRepository patientRepository;

    @Mock
    private PatientMapper patientMapper;

    @InjectMocks
    private PatientService patientService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deletePatient_shouldDeletePatientAndRelatedVisitsButNotDoctors() {
        // test usuniecia pacjenta
        Long patientId = 1L;
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patientId);

        when(patientRepository.findById(patientId)).thenReturn(Optional.of(patientEntity));

        patientService.deletePatient(patientId);

        verify(patientRepository).delete(patientEntity);
    }

    @Test
    void findPatientById_shouldReturnPatientDTOWithExpectedFields() {
        // Given
        Long patientId = 1L;
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patientId);
        LocalDate dateOfBirth = LocalDate.of(1985,07,10);
        LocalDate lastVisitDate = LocalDate.now();
        List<VisitTO> visits = new ArrayList<>();
        String additionalInfo = "Test additional info";

        PatientTO patientTO = new PatientTO(patientId, "Anna", "Nowak", dateOfBirth, lastVisitDate, visits, additionalInfo);

        when(patientRepository.findById(patientId)).thenReturn(Optional.of(patientEntity));
        when(patientMapper.toTO(patientEntity)).thenReturn(patientTO);

        // When
        PatientTO result = patientService.findById(patientId);

        // Then
        assertNotNull(result);
        assertEquals(patientId, result.getId());
        assertEquals("Anna", result.getFirstName());
        assertEquals("Nowak", result.getLastName());
        assertEquals(dateOfBirth, result.getDateOfBirth());
        assertEquals(lastVisitDate, result.getLastVisitDate());
        assertEquals(additionalInfo, result.getAdditionalInfo());
    }

}
