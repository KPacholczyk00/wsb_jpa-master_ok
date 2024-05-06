package com.capgemini.wsb.dto;

import java.time.LocalDateTime;

public class VisitTO {
    private Long id;
    private LocalDateTime visitTime;
    private DoctorTO doctor;
    private Long patientId;

    public VisitTO() {
    }

    public VisitTO(Long id, LocalDateTime visitTime, DoctorTO doctor, Long patientId) {
        this.id = id;
        this.visitTime = visitTime;
        this.doctor = doctor;
        this.patientId = patientId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(LocalDateTime visitTime) {
        this.visitTime = visitTime;
    }

    public DoctorTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorTO doctor) {
        this.doctor = doctor;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
}
