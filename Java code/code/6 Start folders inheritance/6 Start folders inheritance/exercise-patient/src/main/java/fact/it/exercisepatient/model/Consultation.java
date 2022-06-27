package fact.it.exercisepatient.model;

import java.time.LocalDate;

public class Consultation {
    private Doctor doctor;
    private Patient patient;

    public Consultation(Doctor doctor, Patient patient) {
        this.doctor = doctor;
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString(){
        String doctorText = "Doctor: Dr. "  + getDoctor().getName() + ", " + getDoctor().getSpecialization();
        String patientText = "Patient: Name: " + getPatient().getName() + " (national number: " + getPatient().getNationalNumber() + ")";

        return doctorText + "\n" + patientText + "\n" + "Consultation: " + LocalDate.now();
    }
}
