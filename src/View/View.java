package View;

import View.CenterPanel.CenterPanel;
import View.NorthPanel.NorthPanel;
import View.ReportFrames.PersonalDataFrame;
import View.SouthPanel.SouthPanel;
import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private CenterPanel centerPanel;
    private SouthPanel southPanel;
    private PersonalDataFrame personalDataFrame;

    public View(){
        super("Grade Calculator");
        NorthPanel northPanel = new NorthPanel();
        centerPanel = new CenterPanel();
        southPanel = new SouthPanel();

        this.getContentPane().add(BorderLayout.NORTH, northPanel);
        this.getContentPane().add(BorderLayout.CENTER, centerPanel);
        this.getContentPane().add(BorderLayout.SOUTH, southPanel);

        JScrollPane scroll = new JScrollPane(centerPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.add(scroll);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setVisible(true);
    }

    public void runPersonalDataFrame(){
        personalDataFrame = new PersonalDataFrame();
    }

    public PersonalDataFrame getPersonalDataFrame(){
        return personalDataFrame;
    }

    public CenterPanel getCenterPanel() {
        return centerPanel;
    }

    public SouthPanel getSouthPanel() {
        return southPanel;
    }

    public void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }

    public void setGPA(String gpa){
        southPanel.getWestSubPanel().setGPA(gpa);
    }

}
