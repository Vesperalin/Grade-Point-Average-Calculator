package Model;

public class Course {
    private String name;
    private Float grade;
    private Integer ECTS;

    public Course(String name, Float grade, Integer ECTS){
        this.name=name;
        this.grade=grade;
        this.ECTS=ECTS;
    }

    public String getName() {
        return name;
    }

    public Float getGrade() {
        return grade;
    }

    public Integer getECTS() {
        return ECTS;
    }
}
