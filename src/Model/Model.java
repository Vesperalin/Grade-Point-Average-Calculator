package Model;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Course> courses;
    private Float gradePointAverage;
    private String studentName;
    private String studentSurname;
    private Long studentID;

    public Model(){
        clear();
    }

    public void updateCourses(ArrayList<String> names, ArrayList<Integer> ECTS, ArrayList<Float> grades){
        clear();
        for(int i=0; i<names.size(); i++){
            courses.add(new Course(names.get(i), grades.get(i), ECTS.get(i)));
        }
    }

    public void calculateGPA(){
        gradePointAverage=0f;
        int ectsAmount=0;
        for(Course c: courses){
            gradePointAverage+=(c.getGrade()*c.getECTS());
            ectsAmount+=c.getECTS();
        }
        gradePointAverage/=ectsAmount;
    }

    public void clear(){
        courses=new ArrayList<Course>();
        gradePointAverage=0f;
        studentName=null;
        studentSurname=null;
        studentID=null;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Float getGradePointAverage() {
        return gradePointAverage;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }
}
