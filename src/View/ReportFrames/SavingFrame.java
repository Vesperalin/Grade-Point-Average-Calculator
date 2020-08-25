package View.ReportFrames;

import javax.swing.*;
import java.io.File;

public class SavingFrame extends JFrame {
    public File getPaht(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify where to save file");
        int userSelection = fileChooser.showSaveDialog(this);
        File fileToSave;
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            fileToSave = fileChooser.getSelectedFile();
        }else{
            JOptionPane.showMessageDialog(this, "Something went wrong!");
            fileToSave=null;
        }
        return fileToSave;
    }
}
