package service;

import model.Student;
import ultil.SerializationUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//model -> Student 1 lan

//service -> findAll

// View -> hien thi danh sach Student

//service -> create student

// View -> create Student.

//

// service noi thao them sua xoa data cua minh
public class StudentService implements BaseCRUDService<Student> {
    private static List<Student> students;

    private static int idCurrent;

    static {
        try {
            students = (List<Student>) SerializationUtil.deserialize( "demo.txt");;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void create(Student student) {
        student.setId(++idCurrent);
        students.add(student);
    }

    @Override
    public void update(Student student) {

    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public void delete(Student student) {

    }

    public static void writeData() throws IOException {
        SerializationUtil.serialize(students, "demo.txt");
    }


}
