package View.CenterPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EastSubPanel extends DataPanel {
    private ArrayList<JTextField> gradesFields;

    public EastSubPanel(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        gradesFields = new ArrayList<>();
        prepareLabel();
        prepareTextFields();
    }

    public void clearData(){
        gradesFields.clear();
        this.removeAll();
        prepareLabel();
        prepareTextFields();
        revalidate();
        repaint();
    }

    public void addData(){
        gradesFields.add(new JTextField(5));
        this.add(gradesFields.get(gradesFields.size()-1));
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        revalidate();
        repaint();
    }

    public void prepareLabel(){
        JLabel label = new JLabel("Grade");
        label.setFont(new Font("Verdena", Font.PLAIN, 15));
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(label);
    }

    public void prepareTextFields(){
        for(int i=0; i<5; i++){
            gradesFields.add(new JTextField(5));
            this.add(gradesFields.get(i));
            this.add(Box.createRigidArea(new Dimension(0, 5)));
        }
    }

    public ArrayList<JTextField> getData() {
        return gradesFields;
    }
}
