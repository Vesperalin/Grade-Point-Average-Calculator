package View.CenterPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CenterPanel extends JPanel {
    private DataPanel westSubPanel;
    private DataPanel centerSubPanel;
    private DataPanel eastSubPanel;

    public CenterPanel(){
        westSubPanel = new WestSubPanel();
        centerSubPanel = new CenterSubPanel();
        eastSubPanel = new EastSubPanel();
        NorthSubPanel northSubPanel = new NorthSubPanel();

        this.setLayout(new BorderLayout());
        this.add(BorderLayout.WEST, westSubPanel);
        this.add(BorderLayout.CENTER, centerSubPanel);
        this.add(BorderLayout.EAST, eastSubPanel);
        this.add(BorderLayout.NORTH, northSubPanel);
    }

    public ArrayList<JTextField> getECTS(){
        return centerSubPanel.getData();
    }

    public ArrayList<JTextField> getGrades(){
        return eastSubPanel.getData();
    }

    public ArrayList<JTextField> getCoursesNames(){
        return westSubPanel.getData();
    }

    public void clearFields(){
        westSubPanel.clearData();
        eastSubPanel.clearData();
        centerSubPanel.clearData();
    }

    public void addCourse(){
        westSubPanel.addData();
        eastSubPanel.addData();
        centerSubPanel.addData();
    }

}
