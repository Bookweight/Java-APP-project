package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.security.auth.login.AppConfigurationEntry;
import javax.swing.Action;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;

import GUI.SubFacesSetting;

public class ThreeFunctionButtons {// 畫面下方的三個功能按鈕
    private JFrame targetFrame;
    private JPanel mainPanel;
    private JButton setWeightButton;
    private JButton mainGUIButton;
    private JButton progressButton;

    public ThreeFunctionButtons(JFrame appFrame) {
        targetFrame = appFrame;
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1, 3));

        ActionListener btnlistener = new ButtonListener();

        setWeightButton = new JButton("設定權重");
        setWeightButton.setFont(new Font("", Font.BOLD, 16));
        setWeightButton.addActionListener(btnlistener);
        mainPanel.add(setWeightButton);
        mainGUIButton = new JButton("主畫面");
        mainGUIButton.setFont(new Font("", Font.BOLD, 16));
        mainGUIButton.addActionListener(btnlistener);
        mainPanel.add(mainGUIButton);
        progressButton = new JButton("進度");
        progressButton.setFont(new Font("", Font.BOLD, 16));
        progressButton.addActionListener(btnlistener);
        mainPanel.add(progressButton);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent a) {
            if (a.getSource() == setWeightButton) {// 跳到五大參數頁面
                new FiveFacesSettingGUI();
                targetFrame.dispose();
            } else if (a.getSource() == mainGUIButton) {// 跳回主頁面
                new MainGUI();
                targetFrame.dispose();
            } else if (a.getSource() == progressButton) {// 跳到進度頁面
                new ScheduleGUI();
                targetFrame.dispose();
            }
        }
    }

    public JPanel getPanel() {
        return mainPanel;
    }
}
