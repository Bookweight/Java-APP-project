package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.Action;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.Image;

import GUI.SimulationResultSubFacesGUI;
import GUI.FiveFacesSettingGUI.Faces;
import GUI.ThreeFunctionButtons;
import GUI.DynamicSizing;

public class SimulationResultGUI {
        private JFrame appFrame;
        private JLayeredPane pane;
        private JPanel functionPanel;
        private final JLabel academicLabel;
        private final JLabel hobbyLabel;
        private final JLabel sportLabel;
        private final JLabel socialLabel;
        private final JLabel relationshipLabel;
        private JLabel backgroundLabel;
        private ImageIcon academicIcon;
        private ImageIcon hobbyIcon;
        private ImageIcon sportIcon;
        private ImageIcon socialIcon;
        private ImageIcon relationshipIcon;
        private ImageIcon backgroundIcon;
        private final JLabel academicresult;
        private final JLabel hobbyresult;
        private final JLabel sportresult;
        private final JLabel socialresult;
        private final JLabel relationshipresult;
        private final JButton academicButton;
        private final JButton hobbyButton;
        private final JButton sportButton;
        private final JButton socailButton;
        private final JButton relationshipButton;

        public SimulationResultGUI() {// 模擬結果畫面
                double h = DynamicSizing.getYourHight();
                double w = DynamicSizing.getYourWidth();
                appFrame = new JFrame("Simulation");
                appFrame.setLayout(null);
                appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                appFrame.setSize((int) Math.round(640 * w), (int) Math.round(900 * h));
                appFrame.setVisible(true);

                ActionListener btnlistener = new ButtonListener();

                loadIcons(w, h);

                pane = appFrame.getLayeredPane();

                academicLabel = new JLabel("學業");
                academicLabel.setOpaque(true);
                academicLabel.setFont(new Font("", Font.BOLD, 16));
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
                hobbyLabel.setOpaque(true);
                hobbyLabel.setFont(new Font("", Font.BOLD, 16));
                hobbyLabel.setIcon(hobbyIcon);
                hobbyLabel.setHorizontalAlignment(JLabel.CENTER);
                hobbyLabel.setVerticalAlignment(JLabel.CENTER);
                hobbyLabel.setHorizontalTextPosition(JLabel.CENTER);
                hobbyLabel.setVerticalTextPosition(JLabel.BOTTOM);
                hobbyLabel.setBorder(new LineBorder(Color.BLACK));
                pane.add(hobbyLabel, 1);
                hobbyLabel.setBounds((int) Math.round(90 * w), (int) Math.round(300 * h), (int) Math.round(90 * w),
                                (int) Math.round(90 * h));
                sportLabel = new JLabel("運動");
                sportLabel.setOpaque(true);
                sportLabel.setFont(new Font("", Font.BOLD, 16));
                sportLabel.setIcon(sportIcon);
                sportLabel.setHorizontalAlignment(JLabel.CENTER);
                sportLabel.setVerticalAlignment(JLabel.CENTER);
                sportLabel.setHorizontalTextPosition(JLabel.CENTER);
                sportLabel.setVerticalTextPosition(JLabel.BOTTOM);
                sportLabel.setBorder(new LineBorder(Color.BLACK));
                pane.add(sportLabel, 1);
                sportLabel.setBounds((int) Math.round(90 * w), (int) Math.round(420 * h), (int) Math.round(90 * w),
                                (int) Math.round(90 * h));
                socialLabel = new JLabel("社交");
                socialLabel.setOpaque(true);
                socialLabel.setFont(new Font("", Font.BOLD, 16));
                socialLabel.setIcon(socialIcon);
                socialLabel.setHorizontalAlignment(JLabel.CENTER);
                socialLabel.setVerticalAlignment(JLabel.CENTER);
                socialLabel.setHorizontalTextPosition(JLabel.CENTER);
                socialLabel.setVerticalTextPosition(JLabel.BOTTOM);
                socialLabel.setBorder(new LineBorder(Color.BLACK));
                pane.add(socialLabel, 1);
                socialLabel.setBounds((int) Math.round(90 * w), (int) Math.round(560 * h), (int) Math.round(90 * w),
                                (int) Math.round(90 * h));
                relationshipLabel = new JLabel("感情");
                relationshipLabel.setOpaque(true);
                relationshipLabel.setFont(new Font("", Font.BOLD, 16));
                relationshipLabel.setIcon(relationshipIcon);
                relationshipLabel.setHorizontalAlignment(JLabel.CENTER);
                relationshipLabel.setVerticalAlignment(JLabel.CENTER);
                relationshipLabel.setHorizontalTextPosition(JLabel.CENTER);
                relationshipLabel.setVerticalTextPosition(JLabel.BOTTOM);
                relationshipLabel.setBorder(new LineBorder(Color.BLACK));
                pane.add(relationshipLabel, 1);
                relationshipLabel.setBounds((int) Math.round(90 * w), (int) Math.round(680 * h),
                                (int) Math.round(90 * w),
                                (int) Math.round(90 * h));

                academicresult = new JLabel();// 在此寫入模擬後的小時數
                academicresult.setBounds((int) Math.round(270 * w), (int) Math.round(195 * h),
                                (int) Math.round(150 * w),
                                (int) Math.round(60 * h));
                pane.add(academicresult, 1);
                hobbyresult = new JLabel();
                hobbyresult.setBounds((int) Math.round(270 * w), (int) Math.round(315 * h), (int) Math.round(150 * w),
                                (int) Math.round(60 * h));
                pane.add(hobbyresult, 1);
                sportresult = new JLabel();
                sportresult.setBounds((int) Math.round(270 * w), (int) Math.round(435 * h), (int) Math.round(150 * w),
                                (int) Math.round(60 * h));
                pane.add(sportresult, 1);
                socialresult = new JLabel();
                socialresult.setBounds((int) Math.round(270 * w), (int) Math.round(555 * h), (int) Math.round(150 * w),
                                (int) Math.round(60 * h));
                pane.add(socialresult, 1);
                relationshipresult = new JLabel();
                relationshipresult.setBounds((int) Math.round(270 * w), (int) Math.round(675 * h),
                                (int) Math.round(150 * w),
                                (int) Math.round(60 * h));
                pane.add(relationshipresult, 1);

                academicButton = new JButton();
                academicButton.setText("細項觀看");
                academicButton.setFont(new Font("", Font.BOLD, 16));
                academicButton.addActionListener(btnlistener);
                pane.add(academicButton, 1);
                academicButton.setBounds((int) Math.round(420 * w), (int) Math.round(195 * h),
                                (int) Math.round(150 * w),
                                (int) Math.round(60 * h));
                hobbyButton = new JButton();
                hobbyButton.setText("細項觀看");
                hobbyButton.setFont(new Font("", Font.BOLD, 16));
                hobbyButton.addActionListener(btnlistener);
                pane.add(hobbyButton, 1);
                hobbyButton.setBounds((int) Math.round(420 * w), (int) Math.round(315 * h), (int) Math.round(150 * w),
                                (int) Math.round(60 * h));
                sportButton = new JButton();
                sportButton.setText("細項觀看");
                sportButton.setFont(new Font("", Font.BOLD, 16));
                sportButton.addActionListener(btnlistener);
                pane.add(sportButton, 1);
                sportButton.setBounds((int) Math.round(420 * w), (int) Math.round(435 * h), (int) Math.round(150 * w),
                                (int) Math.round(60 * h));
                socailButton = new JButton();
                socailButton.setText("細項觀看");
                socailButton.setFont(new Font("", Font.BOLD, 16));
                socailButton.addActionListener(btnlistener);
                pane.add(socailButton, 1);
                socailButton.setBounds((int) Math.round(420 * w), (int) Math.round(575 * h), (int) Math.round(150 * w),
                                (int) Math.round(60 * h));
                relationshipButton = new JButton();
                relationshipButton.setText("細項觀看");
                relationshipButton.setFont(new Font("", Font.BOLD, 16));
                relationshipButton.addActionListener(btnlistener);
                pane.add(relationshipButton, 1);
                relationshipButton.setBounds((int) Math.round(420 * w), (int) Math.round(695 * h),
                                (int) Math.round(150 * w),
                                (int) Math.round(60 * h));

                functionPanel = new ThreeFunctionButtons(appFrame).getPanel();
                functionPanel.setBounds(0, (int) Math.round(810 * h), (int) Math.round(640 * w),
                                (int) Math.round(60 * h));
                pane.add(functionPanel, 1);

                backgroundLabel = new JLabel(backgroundIcon);
                pane.add(backgroundLabel, -10);
                backgroundLabel.setBounds(0, 0, (int) Math.round(640 * w), (int) Math.round(900 * h));
        }

        private class ButtonListener implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent a) {
                        if (a.getSource() == academicButton) {
                                new SimulationResultSubFacesGUI(Faces.academic);// 各主項目的細項
                                appFrame.dispose();
                                ;
                        } else if (a.getSource() == hobbyButton) {
                                new SimulationResultSubFacesGUI(Faces.hobby);
                                appFrame.dispose();
                        } else if (a.getSource() == sportButton) {
                                new SimulationResultSubFacesGUI(Faces.sport);
                                appFrame.dispose();
                        } else if (a.getSource() == socailButton) {
                                new SimulationResultSubFacesGUI(Faces.socail);
                                appFrame.dispose();
                        } else if (a.getSource() == relationshipButton) {
                                new SimulationResultSubFacesGUI(Faces.relationship);
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
}
