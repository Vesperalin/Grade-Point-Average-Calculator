package View.SouthPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CenterSubPanel extends JPanel {
    private JButton addCourseButton;
    private JButton clearButton;

    public CenterSubPanel(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        addCourseButton = new JButton("Add new course");
        addCourseButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        clearButton = new JButton("Clear data");
        clearButton.setAlignmentX(JButton.CENTER_ALIGNMENT);

        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(addCourseButton);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(clearButton);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
    }

    public void addAddCourseButtonListener(ActionListener listener){
        addCourseButton.addActionListener(listener);
    }

    public void addClearButtonListener(ActionListener listener){
        clearButton.addActionListener(listener);
    }
}
