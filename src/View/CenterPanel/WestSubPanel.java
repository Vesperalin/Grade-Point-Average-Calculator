package View.CenterPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class WestSubPanel extends DataPanel {
    private ArrayList<JTextField> courseNames;

    public WestSubPanel(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        prepareLabel();
        courseNames = new ArrayList<>();
        prepareTextFields();
    }

    public void clearData(){
        courseNames.clear();
        this.removeAll();
        prepareLabel();
        prepareTextFields();
        revalidate();
        repaint();
    }

    public void addData(){
        courseNames.add(new JTextField(40));
        this.add(courseNames.get(courseNames.size()-1));
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        revalidate();
        repaint();
    }

    public void prepareLabel(){
        JLabel coursesName = new JLabel("Course Name");
        coursesName.setFont(new Font("Verdena", Font.PLAIN, 15));
        this.add(Box.createRigidArea(new Dimension(0, 5))); //robi przestreznie miedzy elementami
        this.add(coursesName);
    }

    public void prepareTextFields(){
        for(int i=0; i<5; i++){
            courseNames.add(new JTextField(40));
            this.add(courseNames.get(i));
            this.add(Box.createRigidArea(new Dimension(0, 5)));
        }
    }

    public ArrayList<JTextField> getData() {
        return courseNames;
    }
}
