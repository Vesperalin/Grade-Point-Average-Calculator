package View.ReportFrames;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;

public class PersonalDataFrame extends JFrame {
    private JTextField studentsID;
    private JTextField studentsName;
    private JTextField studentsSurname;
    private JButton confirmButton;

    public PersonalDataFrame(){
        super("Personal Data");

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel IDLabel = new JLabel("Student's index number");
        IDLabel.setFont(new Font("Verdena", Font.PLAIN, 15));
        IDLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        mainPanel.add(IDLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        studentsID=new JTextField(20);
        mainPanel.add(studentsID);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel nameLabel = new JLabel("Student's name");
        nameLabel.setFont(new Font("Verdena", Font.PLAIN, 15));
        nameLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        mainPanel.add(nameLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        studentsName = new JTextField(20);
        mainPanel.add(studentsName);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel surnameLabel = new JLabel("Student's Surname");
        surnameLabel.setFont(new Font("Verdena", Font.PLAIN, 15));
        surnameLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        mainPanel.add(surnameLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        studentsSurname = new JTextField(20);
        mainPanel.add(studentsSurname);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        confirmButton = new JButton("Confirm");
        confirmButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        mainPanel.add(confirmButton);

        this.getContentPane().add(mainPanel);

        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setVisible(true);
    }

    public void addConfirmButtonListener(ActionListener listener){
        confirmButton.addActionListener(listener);
    }

    public JTextField getStudentsID() {
        return studentsID;
    }

    public JTextField getStudentsName() {
        return studentsName;
    }

    public JTextField getStudentsSurname() {
        return studentsSurname;
    }
}
