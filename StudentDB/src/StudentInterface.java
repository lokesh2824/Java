public interface StudentInterface {
    public boolean insertStudent(Student s);
    public boolean delete(int rollno);
    public boolean update(int rollno, String update, int choice, Student s);
    public void showAllStudents();
    public boolean showStudentById(int rollno);
}
