import java.util.ArrayList;
import java.util.List;

class Patient {
    private String name;
    private List<Doctor> doctors;

    public Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    public String getName() { return name; }

    public void addDoctor(Doctor d) {
        if (!doctors.contains(d)) {
            doctors.add(d);
        }
    }

    public void showDoctors() {
        System.out.println("Patient " + name + " has consulted:");
        for (Doctor d : doctors) {
            System.out.println("  • Dr. " + d.getName());
        }
        System.out.println();
    }
}

class Doctor {
    private String name;
    private String specialty;
    private List<Patient> patients;

    public Doctor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
        this.patients = new ArrayList<>();
    }

    public String getName() { return name; }

    public void consult(Patient p) {
        if (!patients.contains(p)) {
            patients.add(p);
        }
        p.addDoctor(this);
        System.out.println("Dr. " + name + " (" + specialty + ") is consulting patient " + p.getName());
    }

    public void showPatients() {
        System.out.println("Dr. " + name + " has consulted:");
        for (Patient p : patients) {
            System.out.println("  • " + p.getName());
        }
        System.out.println();
    }
}

class Hospital {
    private String name;
    private List<Doctor> doctors;
    private List<Patient> patients;

    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor d) {
        if (!doctors.contains(d)) doctors.add(d);
    }

    public void addPatient(Patient p) {
        if (!patients.contains(p)) patients.add(p);
    }

    public void showHospitalInfo() {
        System.out.println("Hospital: " + name);
        System.out.println("Doctors:");
        for (Doctor d : doctors) System.out.println("  • Dr. " + d.getName());
        System.out.println("Patients:");
        for (Patient p : patients) System.out.println("  • " + p.getName());
        System.out.println();
    }
}

public class HospitalAssociationDemo {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Care Hospital");

        Doctor d1 = new Doctor("Alice", "Cardiologist");
        Doctor d2 = new Doctor("Bob", "Neurologist");

        Patient p1 = new Patient("Charlie");
        Patient p2 = new Patient("Diana");
        Patient p3 = new Patient("Ethan");

        hospital.addDoctor(d1);
        hospital.addDoctor(d2);
        hospital.addPatient(p1);
        hospital.addPatient(p2);
        hospital.addPatient(p3);

        hospital.showHospitalInfo();

        d1.consult(p1);
        d1.consult(p2);
        d2.consult(p2);
        d2.consult(p3);

        d1.showPatients();
        d2.showPatients();
        p1.showDoctors();
        p2.showDoctors();
        p3.showDoctors();
    }
}
