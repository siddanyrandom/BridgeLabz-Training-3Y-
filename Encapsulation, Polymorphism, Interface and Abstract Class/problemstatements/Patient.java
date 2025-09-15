
import java.util.ArrayList;
import java.util.List;

abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public abstract double calculateBill();

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

interface MedicalRecord {
    void addRecord(String record);
    List<String> viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private List<String> records = new ArrayList<>();

    public InPatient(String patientId, String name, int age, int daysAdmitted) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
    }

    public double calculateBill() {
        return daysAdmitted * 500;
    }

    public void addRecord(String record) { records.add(record); }
    public List<String> viewRecords() { return records; }
}

class OutPatient extends Patient implements MedicalRecord {
    private int consultations;
    private List<String> records = new ArrayList<>();

    public OutPatient(String patientId, String name, int age, int consultations) {
        super(patientId, name, age);
        this.consultations = consultations;
    }

    public double calculateBill() {
        return consultations * 100;
    }

    public void addRecord(String record) { records.add(record); }
    public List<String> viewRecords() { return records; }
}

public class HospitalDemo {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();
        InPatient ip = new InPatient("IP101", "Alice", 30, 5);
        OutPatient op = new OutPatient("OP202", "Bob", 25, 2);

        ip.addRecord("Admitted for surgery");
        op.addRecord("Consulted for fever");

        patients.add(ip);
        patients.add(op);

        for (Patient p : patients) {
            p.getPatientDetails();
            System.out.println("Bill: $" + p.calculateBill());
            if (p instanceof MedicalRecord mr) {
                System.out.println("Medical Records: " + mr.viewRecords());
            }
            System.out.println("------------------------");
        }
    }
}
```
