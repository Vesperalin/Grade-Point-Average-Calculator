package View.CenterPanel;

import javax.swing.*;
import java.awt.*;

public class NorthSubPanel extends JPanel {

    public NorthSubPanel(){
        JLabel information = new JLabel("If needed, your grades should be given with dot, not with coma (e.g: 3.5)");
        information.setFont(new Font("Verdena", Font.PLAIN, 12));
        this.add(information);
    }
}
