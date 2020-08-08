package View.CenterPanel;

import javax.swing.*;
import java.util.ArrayList;

public abstract class DataPanel extends JPanel {
    public abstract void clearData();
    public abstract void addData();
    public abstract void prepareLabel();
    public abstract void prepareTextFields();
    public abstract ArrayList<JTextField> getData();
}
