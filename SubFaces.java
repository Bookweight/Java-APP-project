package GUI;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.FileAlreadyExistsException;
import java.util.EventListener;
import java.awt.FlowLayout;

import GUI.FiveFacesSettingGUI.Faces;

public class SubFaces extends JPanel {
    private boolean setted = false;
    private Faces facestype;
    private JPanel subFacesPanel;
    private JLabel subFacesNameLabel;
    private JLabel subFacesWeightLabel;
    private JLabel successTimeLabel;
    private JButton addButton;

    public void subFaces(JPanel targetPanel) {
        subFacesPanel = new JPanel();
        subFacesPanel.setLayout(new FlowLayout());
        subFacesPanel.setSize(480, 60);

        ActionListener set = new ButtonListener();

        subFacesNameLabel = new JLabel();
        subFacesNameLabel.setSize(135, 60);
        subFacesPanel.add(subFacesNameLabel);
        subFacesWeightLabel = new JLabel();
        subFacesWeightLabel.setSize(105, 60);
        subFacesPanel.add(subFacesWeightLabel);
        successTimeLabel = new JLabel();
        successTimeLabel.setSize(105, 60);
        subFacesPanel.add(successTimeLabel);

        addButton = new JButton("設定");
        addButton.setSize(135, 60);
        subFacesPanel.add(addButton);
        targetPanel.add(subFacesPanel);
    }

    public void setType(Faces f) {
        this.facestype = f;
    }

    public void setName(String name) {
        this.subFacesNameLabel.setText(name);
    }

    public void setWeight(int w) {
        this.subFacesWeightLabel.setText(Integer.toString(w));
    }

    public void setTime(int t) {
        this.successTimeLabel.setText(Integer.toString(t));
    }

    public Faces getType() {
        return facestype;
    }

    public String getName() {
        return subFacesNameLabel.getText();
    }

    public int getWeight() {

        return Integer.parseInt(subFacesWeightLabel.getText());
    }

    private int getTime() {
        return Integer.parseInt(successTimeLabel.getText());
    }

    private class ButtonListener implements ActionListener {
        private JFrame tempFrame;
        private JTextField nameField;
        private JTextField weighField;
        private JTextField successtimeField;
        private JButton confermButton;
        private JButton returnButton;
        private JButton deleteButton;

        @Override
        public void actionPerformed(ActionEvent a) {
            tempFrame = new JFrame("新增細項");
            tempFrame.setSize(500, 300);
            tempFrame.setVisible(true);
            tempFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            nameField = new JTextField();
            nameField.setBounds(50, 100, 100, 50);
            tempFrame.add(nameField);
            weighField = new JTextField();
            weighField.setBounds(200, 100, 100, 50);
            tempFrame.add(weighField);
            successtimeField = new JTextField();
            successtimeField.setBounds(350, 100, 100, 50);
            tempFrame.add(successtimeField);

            confermButton = new JButton("確認");
            confermButton.setBounds(62, 175, 75, 50);
            tempFrame.add(confermButton);
            returnButton = new JButton("返回");
            returnButton.addActionListener(e -> tempFrame.dispose());
            returnButton.setBounds(212, 175, 75, 50);
            tempFrame.add(returnButton);
            deleteButton = new JButton("刪除此項");
            deleteButton.setBounds(372, 175, 75, 50);
            deleteButton.addActionListener(e -> {
            });
        }
    }
}
