package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.text.AttributeSet.ColorAttribute;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;

import GUI.FiveFacesSettingGUI.Faces;
import GUI.DynamicSizing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;

public class SubFacesSetting {// 設定各細項(新增、刪除)
        double h = DynamicSizing.getYourHight();
        double w = DynamicSizing.getYourWidth();
        private final JFrame appFrame;
        private JLayeredPane pane;
        private JPanel functionPanel;
        private final JButton returnButton;
        private final JButton startSimButton;
        private final JLabel SubFacesLabrel;
        private final JLabel weightLabel;
        private final JLabel successHourLabel;
        private final JLabel setLabel;
        private JLabel backgroundLabel;
        private ImageIcon backgroundIcon;
        private JPanel subFacesPanel;
        private JScrollPane subScrollPane;

        public SubFacesSetting(Faces f) {// 建構子(需項目類型)
                appFrame = new JFrame("Five faces setting");
                appFrame.setLayout(null);
                appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                appFrame.setSize(640, 900);
                appFrame.setVisible(true);

                ActionListener btnlistener = new ButtonListener();

                loadIcons(w, h);

                pane = appFrame.getLayeredPane();

                returnButton = new JButton("返回");
                returnButton.setFont(new Font("", Font.BOLD, 16));
                returnButton.addActionListener(btnlistener);
                pane.add(returnButton, 1);
                returnButton.setBounds((int) Math.round(60 * w), (int) Math.round(60 * h), (int) Math.round(90 * w),
                                (int) Math.round(30 * h));
                startSimButton = new JButton("開始模擬");
                startSimButton.setFont(new Font("", Font.BOLD, 16));
                startSimButton.addActionListener(btnlistener);
                pane.add(startSimButton, 1);
                startSimButton.setBounds((int) Math.round(165 * w), (int) Math.round(60 * h), (int) Math.round(120 * w),
                                (int) Math.round(30 * h));

                SubFacesLabrel = new JLabel("細項");
                SubFacesLabrel.setFont(new Font("", Font.BOLD, 16));
                pane.add(SubFacesLabrel, 1);
                SubFacesLabrel.setBounds((int) Math.round(60 * w), (int) Math.round(165 * h), (int) Math.round(135 * w),
                                (int) Math.round(30 * h));
                weightLabel = new JLabel("權重");
                weightLabel.setFont(new Font("", Font.BOLD, 16));
                pane.add(weightLabel, 1);
                weightLabel.setBounds((int) Math.round(195 * w), (int) Math.round(165 * h), (int) Math.round(105 * w),
                                (int) Math.round(30 * h));
                successHourLabel = new JLabel("成功時數");
                successHourLabel.setFont(new Font("", Font.BOLD, 16));
                pane.add(successHourLabel, 1);
                successHourLabel.setBounds((int) Math.round(300 * w), (int) Math.round(165 * h),
                                (int) Math.round(105 * w),
                                (int) Math.round(30 * h));
                setLabel = new JLabel();
                setLabel.setFont(new Font("", Font.BOLD, 16));
                pane.add(setLabel, 1);
                setLabel.setBounds((int) Math.round(405 * w), (int) Math.round(165 * h), (int) Math.round(135 * w),
                                (int) Math.round(30 * h));

                subFacesPanel = new JPanel();// 在此新增事件
                subScrollPane = new JScrollPane(subFacesPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                subScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                subScrollPane.setBorder(new LineBorder(Color.BLACK));
                subScrollPane.setBounds((int) Math.round(60 * w), (int) Math.round(210 * h), (int) Math.round(500 * w),
                                (int) Math.round(540 * h));
                pane.add(subScrollPane, 1);

                functionPanel = new ThreeFunctionButtons(appFrame).getPanel();// 畫面下方三個按鈕
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
                        if (a.getSource() == returnButton) {
                                new FiveFacesSettingGUI();// 返回五大參數設定介面
                                appFrame.dispose();
                        } else if (a.getSource() == startSimButton) {// 跳轉到模擬介面
                                new StartSimulationGUI();
                                appFrame.dispose();
                        }
                }
        }

        private void loadIcons(double w, double h) {
                try {
                        Image img = ImageIO.read(getClass().getResourceAsStream("Icons/subfaceImg.png"));
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
