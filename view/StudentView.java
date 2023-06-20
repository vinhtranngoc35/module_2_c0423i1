package view;

import model.Student;
import service.StudentService;
import ultil.GetValue;

import java.util.List;
import java.util.Scanner;
// hien thi menu + lay cac gia tri cua nguoi dung
public class StudentView {
    Scanner scanner = new Scanner(System.in);
    StudentService studentService = new StudentService();
    public void printMenu(){
        System.out.println("1. Danh sach hoc sinh");
        System.out.println("2. Them hoc sinh");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                printStudents();
                break;
            case 2:
                createStudent();
                break;
        }

    }

    private void printStudents(){
        List<Student> students = studentService.findAll();
        for (Student student: students){
            System.out.println(student);
        }
    }
    private void createStudent(){
        studentService
                .create(new Student(GetValue.getString("Nhap Ten"),
                        GetValue.getString("Nhap Email")));
    }
}
