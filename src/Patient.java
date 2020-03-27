public class Patient {
    //attrbutes
    private int p_id;
    private String p_name;
    private String p_gender;
    private int p_age;
    private String p_address;
    private String p_blood_result;

    //constructor
    public Patient(int p_id, String p_name, String p_gender, int p_age, String p_address, String p_blood_result) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.p_gender = p_gender;
        this.p_age = p_age;
        this.p_address = p_address;
        this.p_blood_result = p_blood_result;
    }

    //getter and setter

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_gender() {
        return p_gender;
    }

    public void setP_gender(String p_gender) {
        this.p_gender = p_gender;
    }

    public int getP_age() {
        return p_age;
    }

    public void setP_age(int p_age) {
        this.p_age = p_age;
    }

    public String getP_address() {
        return p_address;
    }

    public void setP_address(String p_address) {
        this.p_address = p_address;
    }

    public String getP_blood_result() {
        return p_blood_result;
    }

    public void setP_blood_result(String p_blood_result) {
        this.p_blood_result = p_blood_result;
    }

    //tostring

    @Override
    public String toString() {
        return "Patient{" +
                "p_id=" + p_id +
                ", p_name='" + p_name + '\'' +
                ", p_gender='" + p_gender + '\'' +
                ", p_age=" + p_age +
                ", p_address='" + p_address + '\'' +
                ", p_blood_result='" + p_blood_result + '\'' +
                '}';
    }

}
