package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.Image;

import GUI.SubFacesSetting;
import GUI.ThreeFunctionButtons;

public class FiveFacesSettingGUI {
        private JFrame appFrame;
        private JLayeredPane pane;
        private JPanel functionPanel;
        private JLabel backgroundLabel;
        private final JLabel titleLable;
        private final JLabel academicLabel;
        private final JLabel hobbyLabel;
        private final JLabel sportLabel;
        private final JLabel socialLabel;
        private final JLabel relationshipLabel;
        private ImageIcon backgroundIcon;
        private ImageIcon academicIcon;
        private ImageIcon hobbyIcon;
        private ImageIcon sportIcon;
        private ImageIcon socialIcon;
        private ImageIcon relationshipIcon;
        private JTextField academicWeight;
        private JTextField hobbyWeight;
        private JTextField sportWeight;
        private JTextField socialWeight;
        private JTextField relationshipWeight;
        private final JButton academicButton;
        private final JButton hobbyButton;
        private final JButton sportButton;
        private final JButton socailButton;
        private final JButton relationshipButton;

        public FiveFacesSettingGUI() {// 五大參數設定介面
                double h = DynamicSizing.getYourHight();
                double w = DynamicSizing.getYourWidth();
                appFrame = new JFrame("Five faces setting");
                appFrame.setLayout(null);
                appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                appFrame.setSize((int) Math.round(640 * w), (int) Math.round(900 * h));
                appFrame.setVisible(true);

                ActionListener btnlistener = new ButtonListener();
                ActionListener txtListener = new TextFieldListener();

                pane = appFrame.getLayeredPane();

                loadIcons(w, h);

                titleLable = new JLabel("請輸入自訂比重:(1到5)");
                titleLable.setFont(new Font("label", Font.CENTER_BASELINE, 22));
                pane.add(titleLable, 1);
                titleLable.setBounds((int) Math.round(210 * w), (int) Math.round(100 * h), (int) Math.round(330 * w),
                                (int) Math.round(60 * h));

                academicLabel = new JLabel("學業");
                academicLabel.setFont(new Font("", Font.BOLD, 16));
                academicLabel.setOpaque(true);
                academicLabel.setBackground(Color.WHITE);
                academicLabel.setIcon(academicIcon);
                academicLabel.setHorizontalAlignment(JLabel.CENTER);
                academicLabel.setVerticalAlignment(JLabel.CENTER);
                academicLabel.setHorizontalTextPosition(JLabel.CENTER);
                academicLabel.setVerticalTextPosition(JLabel.BOTTOM);
                academicLabel.setBorder(new LineBorder(Color.BLACK));
                pane.add(academicLabel, 1);
                academicLabel.setBounds((int) Math.round(90 * w), (int) Math.round(180 * h), (int) Math.round(90 * w),
                                (int) Math.round(90 * h));
                hobbyLabel = new JLabel("興趣");
                hobbyLabel.setFont(new Font("", Font.BOLD, 16));
                hobbyLabel.setIcon(hobbyIcon);
                hobbyLabel.setOpaque(true);
                hobbyLabel.setHorizontalAlignment(JLabel.CENTER);
                hobbyLabel.setVerticalAlignment(JLabel.CENTER);
                hobbyLabel.setHorizontalTextPosition(JLabel.CENTER);
                hobbyLabel.setVerticalTextPosition(JLabel.BOTTOM);
                hobbyLabel.setBorder(new LineBorder(Color.BLACK));
                pane.add(hobbyLabel, 1);
                hobbyLabel.setBounds((int) Math.round(90 * w), (int) Math.round(300 * h), (int) Math.round(90 * w),
                                (int) Math.round(90 * h));
                sportLabel = new JLabel("運動");
                sportLabel.setFont(new Font("", Font.BOLD, 16));
                sportLabel.setIcon(sportIcon);
                sportLabel.setOpaque(true);
                sportLabel.setHorizontalAlignment(JLabel.CENTER);
                sportLabel.setVerticalAlignment(JLabel.CENTER);
                sportLabel.setHorizontalTextPosition(JLabel.CENTER);
                sportLabel.setVerticalTextPosition(JLabel.BOTTOM);
                sportLabel.setBorder(new LineBorder(Color.BLACK));
                pane.add(sportLabel, 1);
                sportLabel.setBounds((int) Math.round(90 * w), (int) Math.round(420 * h), (int) Math.round(90 * w),
                                (int) Math.round(90 * h));
                socialLabel = new JLabel("社交");
                socialLabel.setFont(new Font("", Font.BOLD, 16));
                socialLabel.setIcon(socialIcon);
                socialLabel.setOpaque(true);
                socialLabel.setHorizontalAlignment(JLabel.CENTER);
                socialLabel.setVerticalAlignment(JLabel.CENTER);
                socialLabel.setHorizontalTextPosition(JLabel.CENTER);
                socialLabel.setVerticalTextPosition(JLabel.BOTTOM);
                socialLabel.setBorder(new LineBorder(Color.BLACK));
                pane.add(socialLabel, 1);
                socialLabel.setBounds((int) Math.round(90 * w), (int) Math.round(560 * h), (int) Math.round(90 * w),
                                (int) Math.round(90 * h));
                relationshipLabel = new JLabel("感情");
                relationshipLabel.setFont(new Font("", Font.BOLD, 16));
                relationshipLabel.setIcon(relationshipIcon);
                relationshipLabel.setOpaque(true);
                relationshipLabel.setHorizontalAlignment(JLabel.CENTER);
                relationshipLabel.setVerticalAlignment(JLabel.CENTER);
                relationshipLabel.setHorizontalTextPosition(JLabel.CENTER);
                relationshipLabel.setVerticalTextPosition(JLabel.BOTTOM);
                relationshipLabel.setBorder(new LineBorder(Color.BLACK));
                pane.add(relationshipLabel, 1);
                relationshipLabel.setBounds((int) Math.round(90 * w), (int) Math.round(680 * h),
                                (int) Math.round(90 * w),
                                (int) Math.round(90 * h));

                academicWeight = new JTextField("0");
                academicWeight.addActionListener(txtListener);
                academicWeight.setFont(new Font("", Font.BOLD, 16));
                pane.add(academicWeight, 1);
                academicWeight.setBounds((int) Math.round(240 * w), (int) Math.round(195 * h),
                                (int) Math.round(150 * w),
                                (int) Math.round(60 * h));
                hobbyWeight = new JTextField("0");
                hobbyWeight.setFont(new Font("", Font.BOLD, 16));
                hobbyWeight.addActionListener(txtListener);
                pane.add(hobbyWeight, 1);
                hobbyWeight.setBounds((int) Math.round(240 * w), (int) Math.round(315 * h), (int) Math.round(150 * w),
                                (int) Math.round(60 * h));
                sportWeight = new JTextField("0");
                sportWeight.setFont(new Font("", Font.BOLD, 16));
                sportWeight.addActionListener(txtListener);
                pane.add(sportWeight, 1);
                sportWeight.setBounds((int) Math.round(240 * w), (int) Math.round(435 * h), (int) Math.round(150 * w),
                                (int) Math.round(60 * h));
                socialWeight = new JTextField("0");
                socialWeight.setFont(new Font("", Font.BOLD, 16));
                socialWeight.addActionListener(txtListener);
                pane.add(socialWeight, 1);
                socialWeight.setBounds((int) Math.round(240 * w), (int) Math.round(575 * h), (int) Math.round(150 * w),
                                (int) Math.round(60 * h));
                relationshipWeight = new JTextField("0");
                relationshipWeight.setFont(new Font("", Font.BOLD, 16));
                relationshipWeight.addActionListener(txtListener);
                pane.add(relationshipWeight, 1);
                relationshipWeight.setBounds((int) Math.round(240 * w), (int) Math.round(695 * h),
                                (int) Math.round(150 * w),
                                (int) Math.round(60 * h));

                academicButton = new JButton();
                academicButton.setFont(new Font("", Font.BOLD, 16));
                academicButton.setText("細項設定");
                academicButton.addActionListener(btnlistener);
                pane.add(academicButton, 1);
                academicButton.setBounds((int) Math.round(420 * w), (int) Math.round(195 * h),
                                (int) Math.round(150 * w),
                                (int) Math.round(60 * h));
                hobbyButton = new JButton();
                hobbyButton.setFont(new Font("", Font.BOLD, 16));
                hobbyButton.setText("細項設定");
                hobbyButton.addActionListener(btnlistener);
                pane.add(hobbyButton, 1);
                hobbyButton.setBounds((int) Math.round(420 * w), (int) Math.round(315 * h), (int) Math.round(150 * w),
                                (int) Math.round(60 * h));
                sportButton = new JButton();
                sportButton.setFont(new Font("", Font.BOLD, 16));
                sportButton.setText("細項設定");
                sportButton.addActionListener(btnlistener);
                pane.add(sportButton, 1);
                sportButton.setBounds((int) Math.round(420 * w), (int) Math.round(435 * h), (int) Math.round(150 * w),
                                (int) Math.round(60 * h));
                socailButton = new JButton();
                socailButton.setFont(new Font("", Font.BOLD, 16));
                socailButton.setText("細項設定");
                socailButton.addActionListener(btnlistener);
                pane.add(socailButton, 1);
                socailButton.setBounds((int) Math.round(420 * w), (int) Math.round(575 * h), (int) Math.round(150 * w),
                                (int) Math.round(60 * h));
                relationshipButton = new JButton();
                relationshipButton.setFont(new Font("", Font.BOLD, 16));
                relationshipButton.setText("細項設定");
                relationshipButton.addActionListener(btnlistener);
                pane.add(relationshipButton, 1);
                relationshipButton.setBounds((int) Math.round(420 * w), (int) Math.round(695 * h),
                                (int) Math.round(150 * w),
                                (int) Math.round(60 * h));

                functionPanel = new ThreeFunctionButtons(appFrame).getPanel();// 底下三個按鈕
                functionPanel.setBounds(0, (int) Math.round(810 * h), (int) Math.round(640 * w),
                                (int) Math.round(60 * h));
                pane.add(functionPanel, 1);

                backgroundLabel = new JLabel(backgroundIcon);
                pane.add(backgroundLabel, -10);
                backgroundLabel.setBounds(0, 0, (int) Math.round(640 * w), (int) Math.round(900 * h));
        }

        private class ButtonListener implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent a) {// 各細項設定
                        if (a.getSource() == academicButton) {
                                new SubFacesSetting(Faces.academic);
                                appFrame.dispose();
                                ;
                        } else if (a.getSource() == hobbyButton) {
                                new SubFacesSetting(Faces.hobby);
                                appFrame.dispose();
                        } else if (a.getSource() == sportButton) {
                                new SubFacesSetting(Faces.sport);
                                appFrame.dispose();
                        } else if (a.getSource() == socailButton) {
                                new SubFacesSetting(Faces.socail);
                                appFrame.dispose();
                        } else if (a.getSource() == relationshipButton) {
                                new SubFacesSetting(Faces.relationship);
                                appFrame.dispose();
                        }
                }
        }

        private class TextFieldListener implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent a) {// 權重設定
                        if (a.getSource() == academicWeight) {

                        } else if (a.getSource() == hobbyWeight) {

                        } else if (a.getSource() == sportWeight) {

                        } else if (a.getSource() == socialWeight) {

                        } else if (a.getSource() == relationshipWeight) {

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
                        Image img = ImageIO.read(getClass().getResourceAsStream("Icons/academicImg.png"));
                        academicIcon = new ImageIcon(
                                        img.getScaledInstance((int) Math.round(60 * w), (int) Math.round(60 * h), 0));
                } catch (Exception e) {
                        System.out.println("academicIcon:" + e);
                }
                try {
                        Image img = ImageIO.read(getClass().getResourceAsStream("Icons/hobbyImg.png"));
                        hobbyIcon = new ImageIcon(
                                        img.getScaledInstance((int) Math.round(60 * w), (int) Math.round(60 * h), 0));
                } catch (Exception e) {
                        System.out.println("hobbyIcon:" + e);
                }
                try {
                        Image img = ImageIO.read(getClass().getResourceAsStream("Icons/sportsImg.png"));
                        sportIcon = new ImageIcon(
                                        img.getScaledInstance((int) Math.round(60 * w), (int) Math.round(60 * h), 0));
                } catch (Exception e) {
                        System.out.println("sportIcon:" + e);
                }
                try {
                        Image img = ImageIO.read(getClass().getResourceAsStream("Icons/socialImg.png"));
                        socialIcon = new ImageIcon(
                                        img.getScaledInstance((int) Math.round(60 * w), (int) Math.round(60 * h), 0));
                } catch (Exception e) {
                        System.out.println("socialIcon:" + e);
                }
                try {
                        Image img = ImageIO.read(getClass().getResourceAsStream("Icons/relationshipImg.png"));
                        relationshipIcon = new ImageIcon(
                                        img.getScaledInstance((int) Math.round(60 * w), (int) Math.round(60 * h), 0));
                } catch (Exception e) {
                        System.out.println("fiveFaceSettingIcon:" + e);
                }

        }

        public JFrame getFrame() {
                return appFrame;
        }

        public enum Faces {// 五大細項的enum物件
                academic, hobby, sport, socail, relationship;
        }
}
