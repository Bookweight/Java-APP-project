package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.io.FileNotFoundException;

import GUI.DynamicSizing;

public class PickGUI {
    double h = DynamicSizing.getYourHight();
    double w = DynamicSizing.getYourWidth();
    private final JFrame appFrame;
    private JLayeredPane pane;
    private JLabel backgroundLabel;
    private ImageIcon backgroundIcon;
    private JPanel functionPanel;
    private final JPanel buttonPanel;
    private JButton firstButton;
    private JButton secondButtton;
    private JButton thirdButton;
    private JButton forthButton;
    private JButton fifthButton;

    public PickGUI() {// 五選三介面
        double h = DynamicSizing.getYourHight();
        double w = DynamicSizing.getYourWidth();
        appFrame = new JFrame("Pick");
        appFrame.setLayout(null);
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appFrame.setSize((int) Math.round(640 * w), (int) Math.round(900 * h));
        appFrame.setVisible(true);

        ActionListener btnlistener = new ButtonListener();

        loadIcons(w, h);

        pane = appFrame.getLayeredPane();

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 5));
        buttonPanel.setBounds((int) Math.round(90 * w), (int) Math.round(180 * h), (int) Math.round(460 * w),
                (int) Math.round(540 * h));
        buttonPanel.setBorder(new LineBorder(Color.BLACK));
        pane.add(buttonPanel, 1);

        firstButton = new JButton("選項一");
        firstButton.addActionListener(btnlistener);
        firstButton.setBackground(Color.WHITE);
        buttonPanel.add(firstButton);
        secondButtton = new JButton("選項二");
        secondButtton.addActionListener(btnlistener);
        secondButtton.setBackground(Color.WHITE);
        buttonPanel.add(secondButtton);
        thirdButton = new JButton("選項三");
        thirdButton.addActionListener(btnlistener);
        thirdButton.setBackground(Color.WHITE);
        buttonPanel.add(thirdButton);
        forthButton = new JButton("選項四");
        forthButton.addActionListener((btnlistener));
        forthButton.setBackground(Color.WHITE);
        buttonPanel.add(forthButton);
        fifthButton = new JButton("選項五");
        fifthButton.addActionListener(btnlistener);
        fifthButton.setBackground(Color.WHITE);
        buttonPanel.add(fifthButton);

        functionPanel = new ThreeFunctionButtons(appFrame).getPanel();// 底下三個按鈕
        functionPanel.setBounds(0, (int) Math.round(810 * h), (int) Math.round(640 * w), (int) Math.round(60 * h));
        pane.add(functionPanel, 1);

        backgroundLabel = new JLabel(backgroundIcon);
        pane.add(backgroundLabel, -10);
        backgroundLabel.setBounds(0, 0, (int) Math.round(640 * w), (int) Math.round(900 * h));
    }

    private class ButtonListener implements ActionListener {
        private boolean b1picked = false;// 是否已選取
        private boolean b2picked = false;
        private boolean b3picked = false;
        private boolean b4picked = false;
        private boolean b5picked = false;
        private int pickednum = 0;

        @Override
        public void actionPerformed(ActionEvent a) {
            if (a.getSource() == firstButton) {
                if (b1picked == true) {
                    b1picked = false;
                    firstButton.setBackground(Color.WHITE);
                    pickednum -= 1;
                } else if (pickednum <= 2) {// 不能超過三個
                    b1picked = true;
                    firstButton.setBackground(Color.GRAY);// 目前先以灰色代表選取
                    pickednum += 1;
                }
            } else if (a.getSource() == secondButtton) {
                if (b2picked == true) {
                    b2picked = false;
                    secondButtton.setBackground(Color.WHITE);
                    pickednum -= 1;
                } else if (pickednum <= 2) {
                    b2picked = true;
                    secondButtton.setBackground(Color.GRAY);
                    pickednum += 1;
                }
            } else if (a.getSource() == thirdButton) {
                if (b3picked == true) {
                    b3picked = false;
                    thirdButton.setBackground(Color.WHITE);
                    pickednum -= 1;
                } else if (pickednum <= 2) {
                    b3picked = true;
                    thirdButton.setBackground(Color.GRAY);
                    pickednum += 1;
                }
            } else if (a.getSource() == forthButton) {
                if (b4picked == true) {
                    b4picked = false;
                    forthButton.setBackground(Color.WHITE);
                    pickednum -= 1;
                } else if (pickednum <= 2) {
                    b4picked = true;
                    forthButton.setBackground(Color.GRAY);
                    pickednum += 1;
                }
            } else if (a.getSource() == fifthButton) {
                if (b5picked == true) {
                    b5picked = false;
                    fifthButton.setBackground(Color.WHITE);
                    pickednum -= 1;
                } else if (pickednum <= 2) {
                    b5picked = true;
                    fifthButton.setBackground(Color.GRAY);
                    pickednum += 1;
                }
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
}
