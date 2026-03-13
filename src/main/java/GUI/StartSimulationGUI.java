package GUI;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import GUI.FiveFacesSettingGUI;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.AnnotatedWildcardType;
import java.nio.file.FileAlreadyExistsException;
import java.util.EventListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Image;

import GUI.DynamicSizing;

public class StartSimulationGUI {

    private JFrame appFrame;
    private JLayeredPane pane;
    private JPanel functionPanel;
    private JLabel hiddenLable;
    private final JLabel firstLabel;
    private final JLabel daysLabel;
    private final JLabel nextLabel;
    private final JLabel hourLabel;
    private JLabel backgroundLabel;
    private ImageIcon daysIcon;
    private ImageIcon hourIcon;
    private ImageIcon backgroundIcon;
    private JTextField daysTextField;
    private JTextField hourTestField;
    private final JButton nextButton;
    private final JButton returnButton;

    public StartSimulationGUI() {// 開始模擬畫
        double h = DynamicSizing.getYourHight();
        double w = DynamicSizing.getYourWidth();
        appFrame = new JFrame("Simulation");
        appFrame.setLayout(null);
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appFrame.setSize((int) Math.round(640 * w), (int) Math.round(900 * h));
        appFrame.setVisible(true);

        ActionListener btnlistener = new ButtonListener();
        ActionListener txtListener = new TextFieldListener();

        loadIcons(w, h);

        pane = appFrame.getLayeredPane();

        firstLabel = new JLabel("1.請輸入實行總天數:");
        firstLabel.setFont(new Font("", Font.BOLD, 16));
        firstLabel.setBounds((int) Math.round(210 * w), (int) Math.round(150 * h), (int) Math.round(270 * w),
                (int) Math.round(60 * h));
        pane.add(firstLabel, 1);
        daysLabel = new JLabel("Days");
        daysLabel.setFont(new Font("", Font.BOLD, 16));
        daysLabel.setOpaque(true);
        daysLabel.setIcon(daysIcon);
        daysLabel.setHorizontalAlignment(JLabel.CENTER);
        daysLabel.setVerticalAlignment(JLabel.CENTER);
        daysLabel.setHorizontalTextPosition(JLabel.CENTER);
        daysLabel.setVerticalTextPosition(JLabel.BOTTOM);
        daysLabel.setBorder(new LineBorder(Color.BLACK));
        daysLabel.setBounds((int) Math.round(210 * w), (int) Math.round(240 * h), (int) Math.round(90 * w),
                (int) Math.round(90 * h));
        pane.add(daysLabel, 1);
        nextLabel = new JLabel("2.請輸入每天工作時數:");
        nextLabel.setFont(new Font("", Font.BOLD, 16));
        nextLabel.setBounds((int) Math.round(210 * w), (int) Math.round(360 * h), (int) Math.round(270 * w),
                (int) Math.round(60 * h));
        pane.add(nextLabel, 1);
        hourLabel = new JLabel("Hours");
        hourLabel.setFont(new Font("", Font.BOLD, 16));
        hourLabel.setOpaque(true);
        hourLabel.setIcon(hourIcon);
        hourLabel.setHorizontalAlignment(JLabel.CENTER);
        hourLabel.setVerticalAlignment(JLabel.CENTER);
        hourLabel.setHorizontalTextPosition(JLabel.CENTER);
        hourLabel.setVerticalTextPosition(JLabel.BOTTOM);
        hourLabel.setBorder(new LineBorder(Color.BLACK));
        hourLabel.setBounds((int) Math.round(210 * w), (int) Math.round(450 * h), (int) Math.round(90 * w),
                (int) Math.round(90 * h));
        pane.add(hourLabel, 1);

        daysTextField = new JTextField();
        daysTextField.setBounds((int) Math.round(318 * w), (int) Math.round(252 * h), (int) Math.round(81 * w),
                (int) Math.round(66 * h));
        daysTextField.addActionListener(txtListener);
        pane.add(daysTextField, 1);
        hourTestField = new JTextField();
        hourTestField.setBounds((int) Math.round(318 * w), (int) Math.round(462 * h), (int) Math.round(81 * w),
                (int) Math.round(66 * h));
        hourTestField.addActionListener(txtListener);
        pane.add(hourTestField, 1);

        nextButton = new JButton("下一步");
        nextButton.setFont(new Font("", Font.BOLD, 16));
        nextButton.setBounds((int) Math.round(210 * w), (int) Math.round(600 * h), (int) Math.round(180 * w),
                (int) Math.round(60 * h));
        nextButton.addActionListener(btnlistener);
        pane.add(nextButton, 1);
        returnButton = new JButton("返回");
        returnButton.setFont(new Font("", Font.BOLD, 16));
        returnButton.setBounds((int) Math.round(210 * w), (int) Math.round(690 * h), (int) Math.round(180 * w),
                (int) Math.round(60 * h));
        returnButton.addActionListener(btnlistener);
        pane.add(returnButton, 1);

        functionPanel = new ThreeFunctionButtons(appFrame).getPanel();
        functionPanel.setBounds(0, (int) Math.round(810 * h), (int) Math.round(640 * w), (int) Math.round(60 * h));
        pane.add(functionPanel, 1);

        backgroundLabel = new JLabel(backgroundIcon);
        pane.add(backgroundLabel, -10);
        backgroundLabel.setBounds(0, 0, (int) Math.round(640 * w), (int) Math.round(900 * h));
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent a) {
            if (a.getSource() == nextButton) {// 按"下一步"
                appFrame.remove(firstLabel);// 將輸入欄位等移除
                appFrame.remove(daysLabel);
                appFrame.remove(daysTextField);
                appFrame.remove(nextLabel);
                appFrame.remove(hourLabel);
                appFrame.remove(hourTestField);
                SwingUtilities.updateComponentTreeUI(appFrame);
                hiddenLable = new JLabel("Continue.......");// 加入文字
                hiddenLable.setBounds(200, 390, 210, 60);
                appFrame.add(hiddenLable);// 在此新增模擬函式，之後再跳轉到模擬結果頁面
                new SimulationResultGUI();
                appFrame.dispose();
            } else if (a.getSource() == returnButton) {
                new SimulationGUI();
                appFrame.dispose();
            }
        }
    }

    private class TextFieldListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent a) {
            if (a.getSource() == daysTextField) {// 讀取參數

            } else if (a.getSource() == hourTestField) {

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
        try {
            Image img = ImageIO.read(getClass().getResourceAsStream("Icons/dailyImg.png"));
            daysIcon = new ImageIcon(
                    img.getScaledInstance((int) Math.round(60 * w), (int) Math.round(60 * h), 0));
        } catch (Exception e) {
            System.out.println("academicIcon:" + e);
        }
        try {
            Image img = ImageIO.read(getClass().getResourceAsStream("Icons/hourImg.png"));
            hourIcon = new ImageIcon(
                    img.getScaledInstance((int) Math.round(60 * w), (int) Math.round(60 * h), 0));
        } catch (Exception e) {
            System.out.println("hobbyIcon:" + e);
        }
    }

    public JFrame getFrame() {
        return appFrame;
    }
}
