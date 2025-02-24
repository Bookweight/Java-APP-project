package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Image;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.StartSimulationGUI;
import GUI.DynamicSizing;

public class SimulationGUI {// 模擬介面
    private JFrame appFrame;
    private JLayeredPane pane;
    private JLabel backgroundLabel;
    private ImageIcon backgroundIcon;
    private JPanel functionPanel;
    private final JButton startSimulationButton;
    private final JButton resultButton;
    private final JButton returnButton;

    public SimulationGUI() {
        double h = DynamicSizing.getYourHight();
        double w = DynamicSizing.getYourWidth();
        appFrame = new JFrame("Simulation");
        appFrame.setLayout(null);
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appFrame.setSize(640, 900);
        appFrame.setVisible(true);

        ActionListener btnlistener = new ButtonListener();

        pane = appFrame.getLayeredPane();

        loadIcons(w, h);

        startSimulationButton = new JButton("開始模擬");
        startSimulationButton.setFont(new Font("", Font.BOLD, 16));
        startSimulationButton.setBounds((int) Math.round(160 * w), (int) Math.round(240 * h), (int) Math.round(270 * w),
                (int) Math.round(90 * h));
        startSimulationButton.addActionListener(btnlistener);
        pane.add(startSimulationButton, 1);
        resultButton = new JButton("模擬結果");// 模擬結果，需加入辦別是否已模擬
        resultButton.setFont(new Font("", Font.BOLD, 16));
        resultButton.setBounds((int) Math.round(160 * w), (int) Math.round(375 * h), (int) Math.round(270 * w),
                (int) Math.round(90 * h));
        resultButton.addActionListener(btnlistener);
        pane.add(resultButton, 1);
        returnButton = new JButton("返回");
        returnButton.setFont(new Font("", Font.BOLD, 16));
        returnButton.setBounds((int) Math.round(160 * w), (int) Math.round(510 * h), (int) Math.round(270 * w),
                (int) Math.round(90 * h));
        returnButton.addActionListener(btnlistener);
        pane.add(returnButton, 1);

        functionPanel = new ThreeFunctionButtons(appFrame).getPanel();// 加入畫面下方三按鈕(獨立物件)
        functionPanel.setBounds(0, (int) Math.round(810 * h), (int) Math.round(640 * w), (int) Math.round(60 * h));
        pane.add(functionPanel, 1);

        backgroundLabel = new JLabel(backgroundIcon);
        pane.add(backgroundLabel, -10);
        backgroundLabel.setBounds(0, 0, (int) Math.round(640 * w), (int) Math.round(900 * h));
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent a) {
            if (a.getSource() == startSimulationButton) {
                new StartSimulationGUI();// 開始模擬
                appFrame.dispose();
            } else if (a.getSource() == resultButton) {
                new SimulationResultGUI();
                appFrame.dispose();

            } else if (a.getSource() == returnButton) {
                new MainGUI();
                appFrame.dispose();
            }
        }
    }

    private void loadIcons(double w, double h) {
        try {
            Image img = ImageIO.read(getClass().getResourceAsStream("Icons/background3.png"));
            backgroundIcon = new ImageIcon(
                    img.getScaledInstance((int) Math.round(640 * w), (int) Math.round(900 * h), 0));
        } catch (Exception e) {
            System.out.println("academicIcon:" + e);
        }
    }

    public JFrame getFrame() {
        return appFrame;
    }
}
