package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

public class ImplementGUI {
  private final JFrame appFrame;
  private JPanel mainPanel;
  private final CustomButton letsGoButton;
  private final CustomButton backButton;
  private final JLabel textLabel;

  public ImplementGUI() {
    double w = DynamicSizing.getYourWidth();
    double h = DynamicSizing.getYourHight();

    appFrame = new JFrame("Implement Schedule");
    appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    appFrame.setSize((int) Math.round(640 * w), (int) Math.round(900 * h));
    appFrame.setLocationRelativeTo(null);

    mainPanel = new JPanel(new MigLayout("insets 40, wrap 1, fillx, gapy 30", "[grow, fill]", ""));
    mainPanel.setBackground(Theme.BG_MAIN);

    JLabel title = new JLabel("行程實施");
    title.setFont(Theme.FONT_TITLE);
    title.setForeground(Theme.TEXT_MAIN);
    mainPanel.add(title, "align center, wrap 50");

    textLabel = new JLabel("若滿意結果，按下實施讓我們為你進行排程!");
    textLabel.setFont(Theme.FONT_HEADER);
    textLabel.setHorizontalAlignment(JLabel.CENTER);
    mainPanel.add(textLabel, "align center, wrap 50");

    ActionListener btnlistener = new ButtonListener();

    letsGoButton = new CustomButton("LET'S GO!");
    letsGoButton.setFont(Theme.FONT_TITLE);
    letsGoButton.setCornerRadius(20);
    letsGoButton.addActionListener(btnlistener);

    backButton = new CustomButton("返回主畫面");
    backButton.setColors(Theme.TEXT_MUTED, Theme.TEXT_MAIN);
    backButton.setCornerRadius(20);
    backButton.addActionListener(btnlistener);

    mainPanel.add(letsGoButton, "h 100!, w 250!, align center");
    mainPanel.add(backButton, "h 80!, w 250!, align center");

    JPanel functionPanel = new ThreeFunctionButtons(appFrame).getPanel();
    mainPanel.add(functionPanel, "growx, pushy, aligny bottom");

    appFrame.setContentPane(mainPanel);
    appFrame.setVisible(true);
  }

  private class ButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent a) {
      if (a.getSource() == letsGoButton) {
        textLabel.setText("<html><center>實施中......<br>若不滿意可以重新設定權重，然後再次模擬</center></html>");
        letsGoButton.setText("重新設定權重");
        // Remove the old listener and add a redirect
        for (ActionListener al : letsGoButton.getActionListeners()) {
          letsGoButton.removeActionListener(al);
        }
        letsGoButton.addActionListener(
            e -> {
              new FiveFacesSettingGUI();
              appFrame.dispose();
            });
      } else if (a.getSource() == backButton) {
        new MainGUI();
        appFrame.dispose();
      }
    }
  }
}
