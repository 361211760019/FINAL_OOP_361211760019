import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class PatientDAOImpl {

    public abstract List<Patient> getALLPatient();
    public abstract void deletPatient(int id);
    public static abstract class PatientDAOlmpl implements PatientDAO {
        public static String driverName = "org.sqlite.JDBC";
        public static String url = "jdbc:sqlite:D:/Ben/FINAL_OOP_361211760019/Hospital.sqlite";
        public static Connection conn = null;

        //constant operators
        //CRUD
        public static final String GET_ALL_PATIENT = "select*from Patient";
        public static final String ADD_PATIENT = "insert into Patient" +
                "(p_ID,p_name,p_gender,p_age,p_address,p_blood_result)values(?,?,?,?,?,?)";
        public static final String UPDATE_PATIENT = "update Patient dat" +
                "p_name = ?,p_age = ?,p_address = ?,p_blood_result = ?, where p_id = ?";
        public static final String DELETE_PATIENT = "delate from Patient" +
                "where p_ID = ?";
        public static final String FIND_PATIENT_BY_ID = "selsct*from Patient" +
                "where p_ID = ?";

        //create class instant
        private static PatientDAOImpl instant = new PatientDAOImpl() {
            @Override
            public List<Patient> getALLPatient() {
                return null;
            }

            @Override
            public void deletPatient(int id) {

            }
        };

        public static PatientDAOImpl getInstance() {
            return instant;
        }

        public PatientDAOlmpl() {
            try {
                Class.forName(driverName);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("Driver load successfully.");
        }

        @Override
        public void addPatient(Patient newptt) {
            try {
                conn = DriverManager.getConnection(url);
                PreparedStatement ps = conn.prepareStatement(ADD_PATIENT);
                //set parameter
                ps.setInt(1, newptt.getP_id());
                ps.setString(2, newptt.getP_name());
                ps.setString(3, newptt.getP_gender());
                ps.setInt(4, newptt.getP_age());
                ps.setString(5, newptt.getP_address());
                ps.setString(6, newptt.getP_blood_result());

                boolean rs = ps.execute();
                if (rs == true) {
                    System.out.println("Could not add data to database.");
                    System.exit(1);
                }
                System.out.println("Already add your data to database.");
                //close connection
                ps.close();
                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }//addEmp

        @Override
        public void updatePatient(Patient patient) {
            try {
                conn = DriverManager.getConnection(url);
                PreparedStatement ps = conn.prepareStatement(UPDATE_PATIENT);

                //set parameter
                ps.setString(1, patient.getP_name());
                ps.setInt(2, patient.getP_age());
                ps.setString(3, patient.getP_gender());
                ps.setString(3, patient.getP_address());
                ps.setString(4, patient.getP_blood_result());
                ps.setInt(5, patient.getP_id());

                int rs = ps.executeUpdate();
                if (rs != 0) {
                    System.out.println("Data with p_ID" +
                            patient.getP_id() + "was update.");
                } else {

                    System.out.println("Cloud not update data with p_ID"
                            + patient.getP_id());
                }

                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }//update

        @Override
        public void deletePatient(int id) {

            try {
                conn = DriverManager.getConnection(url);
                PreparedStatement ps = conn.prepareStatement(DELETE_PATIENT);
                //set parameter
                ps.setInt(1, id);
                int rs = ps.executeUpdate();
                if (rs != 0) {
                    System.out.println("Patient wiht p_ID"
                            + id + "was delete.");
                } else {
                    System.out.println("Could not delete Patient"
                            + "was p_ID." + id);

                }
                ps.close();
                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }//delete

        @Override
        public Patient findPatient(int id) {
            Patient patient = null;
            try {
                conn = DriverManager.getConnection(url);
                PreparedStatement ps = conn.prepareStatement(FIND_PATIENT_BY_ID);
                //set parameter
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int p_id = rs.getInt(1);
                    String p_name = rs.getString(2);
                    String p_gender = rs.getString(3);
                    int p_age = rs.getInt(4);
                    String p_address = rs.getString(5);
                    String p_blood_result = rs.getString(6);
                    patient = new Patient(p_id, p_name, p_gender, p_age, p_address, p_blood_result);
                } else {
                    System.out.println("Clocd not found Patient" +
                            "with p_ID" + id);
                }
                rs.close();
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return patient;

        }//find
    }
}
