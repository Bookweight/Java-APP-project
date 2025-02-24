package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.Action;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.FiveFacesSettingGUI;
import GUI.MainGUI;
import GUI.ThreeFunctionButtons;

public class ImplimentGUI {// 實施介面
    private final JFrame appFrame;
    private JPanel functionPanel;
    private final JButton letsGoButton;
    private final JButton backButton;
    private JLabel textLabel;

    public ImplimentGUI() {
        appFrame = new JFrame("Impliment");
        appFrame.setLayout(null);
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appFrame.setSize(640, 900);
        appFrame.setVisible(true);

        ActionListener btnlistener = new ButtonListener();

        textLabel = new JLabel("若滿意結果，按下實施讓我們為你進行排程!");
        textLabel.setBounds(150, 180, 330, 150);
        appFrame.add(textLabel);

        letsGoButton = new JButton("LET'S GO!");// 開始實施
        letsGoButton.setBounds(225, 450, 180, 90);
        letsGoButton.addActionListener(btnlistener);
        appFrame.add(letsGoButton);
        backButton = new JButton("back");// 返回主畫面
        backButton.setBounds(225, 600, 180, 90);
        backButton.addActionListener(btnlistener);
        appFrame.add(backButton);

        functionPanel = new ThreeFunctionButtons(appFrame).getPanel();
        functionPanel.setBounds(0, 810, 640, 60);
        appFrame.add(functionPanel);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent a) {
            if (a.getSource() == letsGoButton) {
                textLabel.setText("實施中......若不滿意可以重新設定權重，然後再次模擬");
                letsGoButton.setText("設定權重");
                letsGoButton.addActionListener(e -> {
                    new FiveFacesSettingGUI();
                    appFrame.dispose();
                    ;
                });

            } else if (a.getSource() == backButton) {
                new MainGUI();
                appFrame.dispose();
            }
        }
    }

}
