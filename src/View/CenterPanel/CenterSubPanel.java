package View.CenterPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CenterSubPanel extends DataPanel {
    private ArrayList<JTextField> ECTSFields;

    public CenterSubPanel(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        prepareLabel();
        ECTSFields = new ArrayList<>();
        prepareTextFields();
    }

    public void clearData(){
        ECTSFields.clear();
        this.removeAll();
        prepareLabel();
        prepareTextFields();
        revalidate();
        repaint();
    }

    public void addData(){
        ECTSFields.add(new JTextField(5));
        this.add(ECTSFields.get(ECTSFields.size()-1));
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        revalidate();
        repaint();
    }

    public void prepareLabel(){
        JLabel label = new JLabel("ECTS");
        label.setFont(new Font("Verdena", Font.PLAIN, 15));
        this.add(Box.createRigidArea(new Dimension(0, 5))); //robi przestreznie miedzy elementami
        this.add(label);
    }

    public void prepareTextFields(){
        for(int i=0; i<5; i++){
            ECTSFields.add(new JTextField(5));
            this.add(ECTSFields.get(i));
            this.add(Box.createRigidArea(new Dimension(0, 5)));
        }
    }

    public ArrayList<JTextField> getData() {
        return ECTSFields;
    }
}
