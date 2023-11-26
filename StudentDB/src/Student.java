public class Student {
    private int rollno;
    private String name;
    private String clgName;
    private String city;
    private double percentage;

    public  Student(){}

    public  Student(String name, String clgName, String city, double percentage){
        this.name = name;
        this.clgName = clgName;
        this.city = city;
        this.percentage = percentage;
    }

    public  Student(int rollno, String name, String clgName, String city, double percentage){
        this.rollno = rollno;
        this.name = name;
        this.clgName = clgName;
        this.city = city;
        this.percentage = percentage;
    }
    // rollnumber
    public int getRollno(){ return rollno; }
    public void setRollno(int rollno){
        this.rollno = rollno;
    }

    // name
    public String getName(){ return name; }
    public void setName(String name){
        this.name = name;
    }

    //clgName
    public  String getClgName(){
        return clgName;
    }
    public void setClgName(String clgName){
        this.clgName = clgName;
    }

    // city
    public String getCity(){
        return city;
    }
    public void setCity(String city){
        this.city = city;
    }

    //percentage
    public double getPercentage(){
        return percentage;
    }
    public void setPercentage(double percentage){
        this.percentage = percentage;
    }

    @Override
    public String toString(){
        return "Student{" +
                "rollNum=" + rollno +
                ", name='" + name + '\'' +
                ", clgName='" + clgName + '\'' +
                ", city='" + city + '\'' +
                ", percentage=" + percentage +
                '}';
    }
}
