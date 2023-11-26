import java.sql.*;

public class StudentDAO implements StudentInterface{

    @Override
    public boolean insertStudent(Student s){
        boolean flag = false;
        try{
            Connection connect = DBconnection.createConnection();
            String query = "insert into studentDetails (rollno, name, clgName, city, percentage) values (?,?, ?, ?, ?)";
            PreparedStatement st = connect.prepareStatement(query);
            st.setInt(1,s.getRollno());
            st.setString(2,s.getName());
            st.setString(3,s.getClgName());
            st.setString(4,s.getCity());
            st.setDouble(5,s.getPercentage());
            st.executeUpdate();
            flag = true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return  flag;
    }

    @Override
    public boolean delete(int rollno) {
        boolean flag = false;
        try{
            Connection connect = DBconnection.createConnection();
            String query = "delete from studentDetails where rollno="+rollno;
            PreparedStatement st = connect.prepareStatement(query);
            st.executeUpdate();
            flag=true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return flag;
    }

    @Override
    public boolean update(int rollno, String update, int choice, Student s) {
        boolean flag = false;
        try{
            if (choice == 1){
                Connection connect = DBconnection.createConnection();
                String query = "update studentDetails set name=? where rollno=?";
                PreparedStatement st = connect.prepareStatement(query);
                st.setString(1,update);
                st.setInt(2,rollno);
                st.executeUpdate();
                flag=true;
            }
            else if (choice == 2){
                Connection connect = DBconnection.createConnection();
                String query = "update studentDetails set clgName=? where rollno=?";
                PreparedStatement st = connect.prepareStatement(query);
                st.setString(1,update);
                st.setInt(2,rollno);
                st.executeUpdate();
                flag=true;
            }
            else if (choice==3){
                Connection connect = DBconnection.createConnection();
                String query = "update studentDetails set city=? where rollno=?";
                PreparedStatement st = connect.prepareStatement(query);
                st.setString(1,update);
                st.setInt(2,rollno);
                st.executeUpdate();
                flag=true;
            }
            else if (choice==4){
                Connection connect = DBconnection.createConnection();
                String query = "update studentDetails set percentage=? where rollno=?";
                PreparedStatement st = connect.prepareStatement(query);
                st.setDouble(1,Double.parseDouble(update));
                st.setInt(2,rollno);
                st.executeUpdate();
                flag=true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return flag;
    }

    @Override
    public void showAllStudents() {
        boolean flag = false;
        try{
            Connection connect = DBconnection.createConnection();
            String query = "select * from studentDetails";
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                System.out.println("RollNumber: "+rs.getInt(1)+"\n"+
                        "Name: "+rs.getString(2)+"\n"+
                        "CollegeName: "+rs.getString(3)+"\n"+
                        "City: "+rs.getString(4)+"\n"+
                        "Percentage: "+rs.getDouble(5));
                System.out.println("-------------------------------------------");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public boolean showStudentById(int rollno) {
        boolean flag = false;
        try{
            Connection connect = DBconnection.createConnection();
            String query = "select * from studentDetails where rollno="+rollno;
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                System.out.println("RollNumber: "+rs.getInt(1)+"\n"+
                        "Name: "+rs.getString(2)+"\n"+
                        "CollegeName: "+rs.getString(3)+"\n"+
                        "City: "+rs.getString(4)+"\n"+
                        "Percentage: "+rs.getDouble(5));
                flag=true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return flag;
    }

}
