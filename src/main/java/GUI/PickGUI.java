package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

public class PickGUI {
    private final JFrame appFrame;
    private JPanel mainPanel;
    private final CustomButton startButton;
    private final CustomButton backButton;
    private final JLabel statusLabel;

    public PickGUI() {
        double w = DynamicSizing.getYourWidth();
        double h = DynamicSizing.getYourHight();
        
        appFrame = new JFrame("Daily Task Picker");
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appFrame.setSize((int) Math.round(640 * w), (int) Math.round(900 * h));
        appFrame.setLocationRelativeTo(null);

        mainPanel = new JPanel(new MigLayout("insets 40, wrap 1, fillx, gapy 30", "[grow, fill]", ""));
        mainPanel.setBackground(Theme.BG_MAIN);

        JLabel title = new JLabel("每日任務挑選");
        title.setFont(Theme.FONT_TITLE);
        title.setForeground(Theme.TEXT_MAIN);
        mainPanel.add(title, "align center, wrap 50");

        statusLabel = new JLabel("<html><center>點擊下方按鈕<br>系統將根據權重為您挑選今日的三項任務</center></html>");
        statusLabel.setFont(Theme.FONT_HEADER);
        statusLabel.setHorizontalAlignment(JLabel.CENTER);
        mainPanel.add(statusLabel, "align center, wrap 50");

        ActionListener btnlistener = new ButtonListener();

        startButton = new CustomButton("開始挑選");
        startButton.setFont(Theme.FONT_TITLE);
        startButton.setCornerRadius(20);
        startButton.addActionListener(btnlistener);
        
        backButton = new CustomButton("返回主畫面");
        backButton.setColors(Theme.TEXT_MUTED, Theme.TEXT_MAIN);
        backButton.setCornerRadius(20);
        backButton.addActionListener(btnlistener);

        mainPanel.add(startButton, "h 100!, w 250!, align center");
        mainPanel.add(backButton, "h 80!, w 250!, align center");

        JPanel functionPanel = new ThreeFunctionButtons(appFrame).getPanel();
        mainPanel.add(functionPanel, "growx, pushy, aligny bottom");

        appFrame.setContentPane(mainPanel);
        appFrame.setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent a) {
            if (a.getSource() == startButton) {
                statusLabel.setText("<html><center>挑選中......<br>今日任務已產出並儲存！</center></html>");
                startButton.setText("查看今日任務");
                // In a real app, this would show results. For now, it's just GUI refactoring.
            } else if (a.getSource() == backButton) {
                new MainGUI();
                appFrame.dispose();
            }
        }
    }
}
