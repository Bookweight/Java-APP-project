package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;

import GUI.FiveFacesSettingGUI;
import GUI.DynamicSizing;
import GUI.MainGUI;
import GUI.ThreeFunctionButtons;

public class ImplementGUI {// 實施介面
    private final JFrame appFrame;
    private JLayeredPane pane;
    private JPanel functionPanel;
    private final JButton letsGoButton;
    private final JButton backButton;
    private JLabel textLabel;
    private JLabel backgroundLabel;
    private ImageIcon backgroundIcon;

    public ImplementGUI() {
        double h = DynamicSizing.getYourHight();
        double w = DynamicSizing.getYourWidth();
        appFrame = new JFrame("Impliment");
        appFrame.setLayout(null);
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appFrame.setSize((int) Math.round(640 * w), (int) Math.round(900 * h));
        appFrame.setVisible(true);

        ActionListener btnlistener = new ButtonListener();

        loadIcons(w, h);

        pane = appFrame.getLayeredPane();

        textLabel = new JLabel("若滿意結果，按下實施讓我們為你進行排程!");
        textLabel.setFont(new Font("", Font.BOLD, 20));
        textLabel.setBounds((int) Math.round(115 * w), (int) Math.round(180 * h), (int) Math.round(400 * w),
                (int) Math.round(150 * h));
        pane.add(textLabel, 1);

        letsGoButton = new JButton("LET'S GO!");// 開始實施
        letsGoButton.setFont(new Font("", Font.BOLD, 20));
        letsGoButton.setBounds((int) Math.round(225 * w), (int) Math.round(450 * h), (int) Math.round(180 * w),
                (int) Math.round(90 * h));
        letsGoButton.addActionListener(btnlistener);
        pane.add(letsGoButton, 1);
        backButton = new JButton("back");// 返回主畫面
        backButton.setFont(new Font("", Font.BOLD, 20));
        backButton.setBounds((int) Math.round(225 * w), (int) Math.round(600 * h), (int) Math.round(180 * w),
                (int) Math.round(90 * h));
        backButton.addActionListener(btnlistener);
        pane.add(backButton, 1);

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
            if (a.getSource() == letsGoButton) {
                textLabel.setText("<html>實施中......若不滿意可以重新設定權重，然後再次模擬</html>");
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
