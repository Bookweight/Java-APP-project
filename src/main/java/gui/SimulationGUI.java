package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

public class SimulationGUI {
  private final JFrame appFrame;
  private JPanel mainPanel;
  private final CustomButton startSimulationButton;
  private final CustomButton viewResultButton;
  private final CustomButton returnButton;

  public SimulationGUI() {
    double w = DynamicSizing.getYourWidth();
    double h = DynamicSizing.getYourHight();

    appFrame = new JFrame("Simulation Dashbord");
    appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    appFrame.setSize((int) Math.round(640 * w), (int) Math.round(900 * h));
    appFrame.setLocationRelativeTo(null);

    mainPanel = new JPanel(new MigLayout("insets 40, wrap 1, fillx, gapy 30", "[grow, fill]", ""));
    mainPanel.setBackground(Theme.BG_MAIN);

    JLabel title = new JLabel("模擬儀表板");
    title.setFont(Theme.FONT_TITLE);
    title.setForeground(Theme.TEXT_MAIN);
    mainPanel.add(title, "align center, wrap 50");

    ActionListener btnlistener = new ButtonListener();

    startSimulationButton = new CustomButton("開始全新模擬");
    startSimulationButton.setFont(Theme.FONT_HEADER);
    startSimulationButton.setCornerRadius(20);
    startSimulationButton.addActionListener(btnlistener);

    viewResultButton = new CustomButton("查看上次模擬結果");
    viewResultButton.setColors(Theme.PRIMARY, Theme.TEXT_MAIN);
    viewResultButton.setCornerRadius(20);
    viewResultButton.addActionListener(btnlistener);

    returnButton = new CustomButton("返回主畫面");
    returnButton.setColors(Theme.TEXT_MUTED, Theme.TEXT_MAIN);
    returnButton.setCornerRadius(20);
    returnButton.addActionListener(btnlistener);

    mainPanel.add(startSimulationButton, "h 80!, align center");
    mainPanel.add(viewResultButton, "h 80!, align center");
    mainPanel.add(returnButton, "h 60!, w 250!, align center, gaptop 30");

    JPanel functionPanel = new ThreeFunctionButtons(appFrame).getPanel();
    mainPanel.add(functionPanel, "growx, pushy, aligny bottom");

    appFrame.setContentPane(mainPanel);
    appFrame.setVisible(true);
  }

  private class ButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent a) {
      if (a.getSource() == startSimulationButton) {
        new StartSimulationGUI();
        appFrame.dispose();
      } else if (a.getSource() == viewResultButton) {
        new SimulationResultGUI();
        appFrame.dispose();
      } else if (a.getSource() == returnButton) {
        new MainGUI();
        appFrame.dispose();
      }
    }
  }
}
