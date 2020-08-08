package View.SouthPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class WestSubPanel extends JPanel {
    private JButton calculateButton;
    private JTextField resultField;

    public WestSubPanel(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        calculateButton = new JButton("Calculate grade point average");
        resultField = new JTextField(5);
        resultField.setEditable(false);

        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(calculateButton);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(resultField);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
    }

    public void addCalculateButtonListener(ActionListener listener){
        calculateButton.addActionListener(listener);
    }

    public void resetGPA(){
        resultField.setText(null);
    }

    public void setGPA(String gpa){
        resultField.setText(gpa);
    }
}
