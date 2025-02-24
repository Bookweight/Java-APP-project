package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.lang.model.util.SimpleAnnotationValueVisitor7;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.plaf.InsetsUIResource;
import javax.swing.plaf.OptionPaneUI;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.TitlePaneLayout;
import javax.swing.plaf.synth.ColorType;
import javax.swing.UIManager;

import javax.xml.catalog.Catalog;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.Image;

import GUI.DynamicSizing;
import GUI.FiveFacesSettingGUI;
import GUI.SimulationGUI;

public class MainGUI {// 主畫面
    private JFrame appFrame;
    private JLayeredPane pane;
    private JLabel backgroundLabel;
    private final JButton fiveFacesSettingButton;
    private final JButton simulationButton;
    private final JButton schedulebButton;
    private final JButton implementButton;
    private final JButton pickButton;
    private final JButton settingbButton;
    private ImageIcon backgroundIcon;
    private ImageIcon fiveFaceSettingIcon;
    private ImageIcon simulationButtIcon;
    private ImageIcon schedulebButtonIcon;
    private ImageIcon implementButtonIcon;
    private ImageIcon pickButtonIcon;
    private ImageIcon settingbButtonIcon;

    public MainGUI() {
        double h = DynamicSizing.getYourHight();
        double w = DynamicSizing.getYourWidth();
        appFrame = new JFrame("Main GUI");
        appFrame.setLayout(null);
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appFrame.setSize((int) Math.round(640 * w), (int) Math.round(900 * h));
        appFrame.setVisible(true);
        ActionListener features = new AppFunctions();

        loadIcons(w, h);

        pane = appFrame.getLayeredPane();

        fiveFacesSettingButton = new JButton("Five faces setting", fiveFaceSettingIcon);
        simulationButton = new JButton("Simultion", simulationButtIcon);
        schedulebButton = new JButton("Schedule", schedulebButtonIcon);
        implementButton = new JButton("Implement", implementButtonIcon);
        pickButton = new JButton("Pick", pickButtonIcon);
        settingbButton = new JButton("Setting", settingbButtonIcon);

        fiveFacesSettingButton.setBorder(null);
        fiveFacesSettingButton.setFont(new Font("", Font.BOLD, 16));
        fiveFacesSettingButton.setHorizontalTextPosition(JLabel.CENTER);
        fiveFacesSettingButton.setVerticalTextPosition(JLabel.BOTTOM);
        fiveFacesSettingButton.addActionListener(features);
        pane.add(fiveFacesSettingButton, 1);
        fiveFacesSettingButton.setBounds((int) Math.round(60 * w), (int) Math.round(450 * h), (int) Math.round(150 * w),
                (int) Math.round(150 * h));

        simulationButton.setBorder(null);
        simulationButton.setFont(new Font("", Font.BOLD, 16));
        simulationButton.setHorizontalTextPosition(JLabel.CENTER);
        simulationButton.setVerticalTextPosition(JLabel.BOTTOM);
        simulationButton.addActionListener(features);
        pane.add(simulationButton, 1);
        simulationButton.setBounds((int) Math.round(240 * w), (int) Math.round(450 * h), (int) Math.round(150 * w),
                (int) Math.round(150 * h));

        schedulebButton.setBorder(null);
        schedulebButton.setFont(new Font("", Font.BOLD, 16));
        schedulebButton.setHorizontalTextPosition(JLabel.CENTER);
        schedulebButton.setVerticalTextPosition(JLabel.BOTTOM);
        schedulebButton.addActionListener(features);
        pane.add(schedulebButton, 1);
        schedulebButton.setBounds((int) Math.round(420 * w), (int) Math.round(450 * h), (int) Math.round(150 * w),
                (int) Math.round(150 * h));

        implementButton.setBorder(null);
        implementButton.setFont(new Font("", Font.BOLD, 16));
        implementButton.setHorizontalTextPosition(JLabel.CENTER);
        implementButton.setVerticalTextPosition(JLabel.BOTTOM);
        implementButton.addActionListener(features);
        pane.add(implementButton, 1);
        implementButton.setBounds((int) Math.round(60 * w), (int) Math.round(630 * h), (int) Math.round(150 * w),
                (int) Math.round(150 * h));

        pickButton.setBorder(null);
        pickButton.setFont(new Font("", Font.BOLD, 16));
        pickButton.setHorizontalTextPosition(JLabel.CENTER);
        pickButton.setVerticalTextPosition(JLabel.BOTTOM);
        pickButton.addActionListener(features);
        pane.add(pickButton, 1);
        pickButton.setBounds((int) Math.round(240 * w), (int) Math.round(630 * h), (int) Math.round(150 * w),
                (int) Math.round(150 * h));

        settingbButton.setBorder(null);
        settingbButton.setFont(new Font("", Font.BOLD, 16));
        settingbButton.setHorizontalTextPosition(JLabel.CENTER);
        settingbButton.setVerticalTextPosition(JLabel.BOTTOM);
        settingbButton.addActionListener(features);
        pane.add(settingbButton, 1);
        settingbButton.setBounds((int) Math.round(420 * w), (int) Math.round(630 * h), (int) Math.round(150 * w),
                (int) Math.round(150 * h));

        backgroundLabel = new JLabel(backgroundIcon);
        pane.add(backgroundLabel, -10);
        backgroundLabel.setBounds(0, 0, (int) Math.round(640 * w), (int) Math.round(900 * h));
    }

    private class AppFunctions implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent a) {
            if (a.getSource() == fiveFacesSettingButton) {
                new FiveFacesSettingGUI();
                appFrame.dispose();
            } else if (a.getSource() == simulationButton) {
                new SimulationGUI();
                appFrame.dispose();
            } else if (a.getSource() == schedulebButton) {
                new ScheduleGUI();
                appFrame.dispose();
            } else if (a.getSource() == implementButton) {
                new ImplementGUI();
                appFrame.dispose();
            } else if (a.getSource() == pickButton) {
                new PickGUI();
                appFrame.dispose();
            } else if (a.getSource() == settingbButton) {
            }
        }
    }

    private void loadIcons(double w, double h) {// 讀圖示
        try {
            Image img = ImageIO.read(getClass().getResourceAsStream("Icons/backGround.png"));
            backgroundIcon = new ImageIcon(
                    img.getScaledInstance((int) Math.round(640 * w), (int) Math.round(900 * h), 0));
        } catch (Exception e) {
            System.out.println("fiveFaceSettingIcon:" + e);
        }
        try {
            Image img = ImageIO.read(getClass().getResource("Icons/fiveFacesSettingButtonImg.png"));
            fiveFaceSettingIcon = new ImageIcon(
                    img.getScaledInstance((int) Math.round(75 * w), (int) Math.round(75 * h), 0));// 按鈕的圖示
        } catch (Exception e) {
            System.out.println("fiveFaceSettingIcon:" + e);
        }
        try {
            Image img = ImageIO.read(getClass().getResource("Icons/simulationButtonImg.png"));
            simulationButtIcon = new ImageIcon(
                    img.getScaledInstance((int) Math.round(75 * w), (int) Math.round(75 * h), 0));
        } catch (Exception e) {
            System.out.println("simulationButtIcon:" + e);
        }
        try {
            Image img = ImageIO.read(getClass().getResource("Icons/schedulebButtonImg.png"));
            schedulebButtonIcon = new ImageIcon(
                    img.getScaledInstance((int) Math.round(75 * w), (int) Math.round(75 * h), 0));
        } catch (Exception e) {
            System.out.println("schedulebButtonIcon:" + e);
        }
        try {
            Image img = ImageIO.read(getClass().getResource("Icons/implementButtonImg.png"));
            implementButtonIcon = new ImageIcon(
                    img.getScaledInstance((int) Math.round(75 * w), (int) Math.round(75 * h), 0));
        } catch (Exception e) {
            System.out.println("implementButtonIcon:" + e);
        }
        try {
            Image img = ImageIO.read(getClass().getResource("Icons/pickButtonImg.png"));
            pickButtonIcon = new ImageIcon(
                    img.getScaledInstance((int) Math.round(75 * w), (int) Math.round(75 * h), 0));
        } catch (Exception e) {
            System.out.println("pickButtonIcon:" + e);
        }
        try {
            Image img = ImageIO.read(getClass().getResource("Icons/settingbButtonImg.png"));
            settingbButtonIcon = new ImageIcon(
                    img.getScaledInstance((int) Math.round(75 * w), (int) Math.round(75 * h), 0));
        } catch (Exception e) {
            System.out.println("settingbButtonIcon:" + e);
        }
    }

    public JFrame getFrame() {
        return appFrame;
    }
}
