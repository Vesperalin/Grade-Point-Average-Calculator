package View.SouthPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EastSubPanel extends JPanel {
    private JButton reportButton;

    public EastSubPanel(){
        reportButton = new JButton("Create report");
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(reportButton);
    }

    public void addReportButtonListener(ActionListener listener){
        reportButton.addActionListener(listener);
    }
}
