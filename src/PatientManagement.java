
import java.util.List;
import java.util.Scanner;

public class PatientManagement {

    public static void main(String[] args) {
        //create interface constant
        PatientDAO dao = (PatientDAO) PatientDAOImpl.PatientDAOlmpl.getInstance();

        //getAllPatient
        displayAllPatient(dao);
        //Add new Patient
        addPatient (dao);
        //update Patient
        updatePatient (dao);
        //delete Patient
        deletePatient (dao);
        //find Patient
        findPatient (dao);
    }//main
    private static void findPatient(PatientDAO dao) {
        Scanner sc = new Scanner(System.in);
        //input data
        System.out.print("Enter Patient P_name:");
        String p_name = sc.nextLine().trim();
        System.out.print("Enter Patient P_gender:");
        String p_gender = sc.nextLine().trim();
        System.out.print("Enter Patient P_age");
        int p_age = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Enter Patient P_address:");
        String p_address = sc.nextLine().trim();
        System.out.print("Enter Patient P_blood_result:");
        String p_blood_result = sc.nextLine().trim();
        System.out.print("Enter Patient P_ID:");
        int p_id = Integer.parseInt(sc.nextLine().trim());
        //insert data to database
        Patient newPatient = new Patient(p_id, p_name, p_gender, p_age, p_address, p_blood_result);
        dao.addPatient(newPatient);
    }
    private static void deletePatient(PatientDAO dao) {
        Scanner sc = new Scanner(System.in);
        //input data
        System.out.print("Enter Patient P_id:");
        int p_id = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Enter Patient P_name:");
        String p_name = sc.nextLine().trim();
        System.out.print("Enter Patient P_gender:");
        String p_gender = sc.nextLine().trim();
        System.out.print("Enter Patient P_age");
        int p_age = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Enter Patient P_address:");
        String p_address = sc.nextLine().trim();
        System.out.print("Enter Patient P_blood_result:");
        String p_blood_result = sc.nextLine().trim();

        //insert data to database
        Patient newPatient = new Patient(p_id, p_name, p_gender, p_age,p_address,p_blood_result);
        dao.addPatient(newPatient);
    }

    private static void updatePatient(PatientDAO dao) {
        Scanner sc = new Scanner(System.in);
        //input data
        System.out.print("Enter Patient P_name:");
        String p_name = sc.nextLine().trim();
        System.out.print("Enter Patient P_gender:");
        String p_gender = sc.nextLine().trim();
        System.out.print("Enter Patient P_age");
        int p_age = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Enter Patient P_address:");
        String p_address = sc.nextLine().trim();
        System.out.print("Enter Patient P_blood_result;");
        String p_blood_result = sc.nextLine().trim();
        System.out.print("Enter Patient P_ID:");
        int p_ID = Integer.parseInt(sc.nextLine().trim());
        //insert data to database
        Patient newPatient = new Patient(p_ID, p_name, p_gender, p_age,p_address,p_blood_result);
        dao.addPatient(newPatient);
    }
    private static void addPatient(PatientDAO dao) {
        Scanner sc = new Scanner(System.in);
        //input data
        System.out.print("Enter Patient p_ID:");
        int p_ID = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Enter Patient p_name:");
        String p_name = sc.nextLine().trim();
        System.out.print("Enter Patient p_gender:");
        String p_gender = sc.nextLine().trim();
        System.out.print("Enter Patient p_age");
        int p_age =Integer.parseInt(sc.nextLine().trim());
        System.out.print("Enter Patient p_address:");
        String p_address = sc.nextLine().trim();
        System.out.print("Enter Patient p_blood_result:");
        String p_blood_result = sc.nextLine().trim();

        //insert data to database

        Patient newPatient = new Patient(p_ID, p_name, p_gender, p_age,p_address,p_blood_result);
        dao.addPatient(newPatient);
    }

    private static void displayAllPatient(PatientDAO dao) {
        List<Patient> myPatient = dao.getAllPatient();
        for (Patient patient : myPatient) {
            System.out.println(patient.toString());
        }
    }
}//class
