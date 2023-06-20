import model.Student;
import service.StudentService;
import view.StudentView;

public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        while (true){
            new StudentView().printMenu();
        }
    }
}
