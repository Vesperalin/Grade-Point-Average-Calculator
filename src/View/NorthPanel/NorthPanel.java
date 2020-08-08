package View.NorthPanel;

import javax.swing.*;
import java.awt.*;

public class NorthPanel extends JPanel {
    public NorthPanel(){
        ImageIcon icon = new ImageIcon(this.getClass().getResource("bookIcon.png"));
        JLabel helpLabel = new JLabel(icon);
        this.add(helpLabel);
        JLabel titleLabel = new JLabel("    Grade Calculator   ");
        titleLabel.setFont(new Font("Verdena", Font.BOLD, 30));
        this.add(titleLabel);
    }
}
