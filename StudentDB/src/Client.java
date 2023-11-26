import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StudentInterface dao = new StudentDAO();
        System.out.println("Welcome to the Student Management System");
        while (true){
            System.out.println("\n1.Add Student" +
                    "\n2.Show All Students" +
                    "\n3.Get student based on roll number" +
                    "\n4.Delete Student"+
                    "\n5.Update Student" +
                    "\n6.Exit");
            System.out.println("Enter your choice");
            int ch = sc.nextInt();
            switch(ch){
                case 1:
                    System.out.println("ADD STUDENT");
                    System.out.printf("Enter roll number: ");
                    int num = sc.nextInt();
                    System.out.printf("Enter student name: ");
                    String name = sc.next();
                    System.out.printf("Enter college name: ");
                    String clgName = sc.next();
                    System.out.printf("Entry city: ");
                    String city = sc.next();
                    System.out.printf("Enter percentage: ");
                    double percentage = sc.nextDouble();
                    Student stu = new Student(num,name,clgName,city,percentage);
                    boolean ans = dao.insertStudent(stu);

                    if (ans)
                        System.out.println("Record saved sucessfully...");
                    else
                        System.out.println("Something went wrong...");
                    break;
                case 2:
                    System.out.println("Details of all students");
                    dao.showAllStudents();
                    break;
                case 3:
                    System.out.println("Get student based on RollNumber");
                    int rollNum = sc.nextInt();
                    boolean b = dao.showStudentById(rollNum);
                    if (!b)
                        System.out.println("No record found with this rollnumber");
                    break;
                case 4:
                    System.out.println("Delete Student");
                    System.out.printf("Enter roll number to delete student: ");
                    int roll = sc.nextInt();
                    boolean bool = dao.delete(roll);
                    if (bool)
                        System.out.println("record deleted sucessfully");
                    else
                        System.out.println("No record found with this rollnumber");
                    break;
                case 5:
                    System.out.printf("Enter what to update \n1.update name\n2.update college Name\n3.update city\n4.update percentage\n");
                    int choice = sc.nextInt();
                    if(choice==1){
                        System.out.printf("Enter roll number: ");
                        int no = sc.nextInt();
                        System.out.println("Enter new name: ");
                        String newName = sc.next();
                        Student std = new Student();
                        std.setName(newName);
                        boolean flag = dao.update(no,newName,choice,std);
                        if (flag)
                            System.out.println("Name updated sucessfully");
                        else
                            System.out.println("Something went wrong");
                    }
                    else if (choice==2) {
                        System.out.println("Enter roll number: ");
                        int no = sc.nextInt();
                        System.out.println("Enter new clgName: ");
                        String newName = sc.next();
                        Student std = new Student();
                        std.setClgName(newName);
                        boolean flag = dao.update(no,newName,choice,std);
                        if (flag)
                            System.out.println("college Name updated sucessfully");
                        else
                            System.out.println("Something went wrong");
                    }
                    else if (choice==3) {
                        System.out.println("Enter roll number: ");
                        int no = sc.nextInt();
                        System.out.println("Enter new city: ");
                        String newName = sc.next();
                        Student std = new Student();
                        std.setCity(newName);
                        boolean flag = dao.update(no,newName,choice,std);
                        if (flag)
                            System.out.println("City updated sucessfully");
                        else
                            System.out.println("Something went wrong");
                    }
                    else if (choice==4) {
                        System.out.println("Enter roll number: ");
                        int no = sc.nextInt();
                        System.out.println("Enter new percentage: ");
                        double newName = sc.nextDouble();
                        Student std = new Student();
                        std.setPercentage(newName);
                        boolean flag = dao.update(no,Double.toString(newName),choice,std);
                        if (flag)
                            System.out.println("Percentage updated sucessfully");
                        else
                            System.out.println("Something went wrong");
                    }
                    break;
                case 6:
                    System.out.println("Thankyou for using student management system");
                    System.exit(0);
                default:
                    System.out.println("Please enter valid choice");
            }
        }
    }
}
