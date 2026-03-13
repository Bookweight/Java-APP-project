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

import GUI.SimulationGUI;
import GUI.SimulationResultGUI;
import GUI.StartSimulationGUI;
import GUI.FiveFacesSettingGUI.Faces;
import GUI.DynamicSizing;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimulationResultSubFacesGUI {
    double h = DynamicSizing.getYourHight();
    double w = DynamicSizing.getYourWidth();
    private final JFrame appFrame;
    private JLayeredPane pane;
    private JPanel functionPanel;
    private final JButton returnButton;
    private final JButton reSimButton;
    private final JLabel SubFacesLabrel;
    private final JLabel timeSpentLabel;
    private final JLabel weightLabel;
    private final JLabel successRateLabel;
    private JLabel backgroundLabel;
    private ImageIcon backgroundIcon;
    private JPanel subFacesPanel;
    private JScrollPane subScrollPane;
    private String faces;

    public SimulationResultSubFacesGUI(Faces f) {// 各細項模擬結果
        appFrame = new JFrame("Simulation");
        appFrame.setLayout(null);
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appFrame.setSize((int) Math.round(640 * w), (int) Math.round(900 * h));
        appFrame.setVisible(true);

        ActionListener btnlistener = new ButtonListener();

        faces = fToFaces(f);

        loadIcons(w, h);

        pane = appFrame.getLayeredPane();

        returnButton = new JButton("返回");
        returnButton.setFont(new Font("", Font.BOLD, 16));
        returnButton.addActionListener(btnlistener);
        returnButton.setBounds((int) Math.round(60 * w), (int) Math.round(60 * h), (int) Math.round(90 * w),
                (int) Math.round(30 * h));
        pane.add(returnButton, 1);
        reSimButton = new JButton("重新計算");
        reSimButton.setFont(new Font("", Font.BOLD, 16));
        reSimButton.addActionListener(btnlistener);
        reSimButton.setBounds((int) Math.round(165 * w), (int) Math.round(60 * h), (int) Math.round(120 * w),
                (int) Math.round(30 * h));
        pane.add(reSimButton, 1);

        SubFacesLabrel = new JLabel(faces + "細項");
        SubFacesLabrel.setFont(new Font("", Font.BOLD, 16));
        SubFacesLabrel.setBounds((int) Math.round(60 * w), (int) Math.round(165 * h), (int) Math.round(135 * w),
                (int) Math.round(30 * h));
        pane.add(SubFacesLabrel, 1);
        timeSpentLabel = new JLabel("投入時間");
        timeSpentLabel.setFont(new Font("", Font.BOLD, 16));
        timeSpentLabel.setBounds((int) Math.round(195 * w), (int) Math.round(165 * h), (int) Math.round(135 * w),
                (int) Math.round(30 * h));
        pane.add(timeSpentLabel, 1);

        weightLabel = new JLabel("權重");
        weightLabel.setFont(new Font("", Font.BOLD, 16));
        pane.add(weightLabel, 1);
        weightLabel.setBounds((int) Math.round(330 * w), (int) Math.round(165 * h), (int) Math.round(105 * w),
                (int) Math.round(30 * h));
        successRateLabel = new JLabel("成功率");
        successRateLabel.setFont(new Font("", Font.BOLD, 16));
        successRateLabel.setBounds((int) Math.round(435 * w), (int) Math.round(165 * h), (int) Math.round(105 * w),
                (int) Math.round(30 * h));
        pane.add(successRateLabel, 1);

        subFacesPanel = new JPanel();// 在此新增各細項模擬結果
        subScrollPane = new JScrollPane(subFacesPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        subScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        subScrollPane.setBorder(new LineBorder(Color.BLACK));
        subScrollPane.setBounds((int) Math.round(60 * w), (int) Math.round(210 * h), (int) Math.round(500 * w),
                (int) Math.round(540 * h));
        pane.add(subScrollPane, 1);

        functionPanel = new ThreeFunctionButtons(appFrame).getPanel();
        functionPanel.setBounds(0, (int) Math.round(810 * h), (int) Math.round(640 * w), (int) Math.round(60 * h));
        pane.add(functionPanel, 1);

        backgroundLabel = new JLabel(backgroundIcon);
        pane.add(backgroundLabel, -10);
        backgroundLabel.setBounds(0, 0, (int) Math.round(640 * w), (int) Math.round(900 * h));
    }

    private String fToFaces(Faces f) {// 將enum物件轉成字串
        if (f == Faces.academic) {
            return "學業";
        } else if (f == Faces.hobby) {
            return "興趣";
        } else if (f == Faces.sport) {
            return "運動";
        } else if (f == Faces.socail) {
            return "社交";
        } else if (f == Faces.relationship) {
            return "愛情";
        } else
            return "";
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent a) {
            if (a.getSource() == returnButton) {// 返回
                new SimulationResultGUI();
                appFrame.dispose();
            } else if (a.getSource() == reSimButton) {// 重新計算
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
