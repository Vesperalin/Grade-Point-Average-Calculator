package View.SouthPanel;

import javax.swing.*;
import java.awt.*;

public class SouthPanel extends JPanel {
    private CenterSubPanel centerSubPanel;
    private EastSubPanel eastSubPanel;
    private WestSubPanel westSubPanel;

    public SouthPanel(){
        centerSubPanel = new CenterSubPanel();
        eastSubPanel = new EastSubPanel();
        westSubPanel = new WestSubPanel();

        this.setLayout(new BorderLayout());
        this.add(BorderLayout.CENTER, centerSubPanel);
        this.add(BorderLayout.EAST, eastSubPanel);
        this.add(BorderLayout.WEST, westSubPanel);
    }

    public CenterSubPanel getCenterSubPanel() {
        return centerSubPanel;
    }

    public EastSubPanel getEastSubPanel() {
        return eastSubPanel;
    }

    public WestSubPanel getWestSubPanel() {
        return westSubPanel;
    }
}
