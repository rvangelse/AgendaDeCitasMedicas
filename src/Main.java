
import model.Doctor;
import model.User;

public class Main {
    public static void main(String[] args) throws Exception {

        User doctor = new Doctor("rvangelse", "1504");
        doctor.setPassword("2601");
        System.out.println(doctor.toString());

        



    }
}
