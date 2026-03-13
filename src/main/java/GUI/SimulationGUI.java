package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

public class SimulationGUI {
  private JFrame appFrame;
  private JPanel mainPanel;
  private JPanel functionPanel;
  private final CustomButton startSimulationButton;
  private final CustomButton resultButton;
  private final CustomButton returnButton;

  public SimulationGUI() {
    double w = DynamicSizing.getYourWidth();
    double h = DynamicSizing.getYourHight();

    appFrame = new JFrame("Simulation Dashboard");
    appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    appFrame.setSize((int) Math.round(640 * w), (int) Math.round(900 * h));
    appFrame.setLocationRelativeTo(null);

    ActionListener btnlistener = new ButtonListener();

    mainPanel = new JPanel(new MigLayout("insets 40, wrap 1, fillx, gapy 30", "[grow, fill]", ""));
    mainPanel.setBackground(Theme.BG_MAIN);

    JLabel title = new JLabel("Simulation Dashboard");
    title.setFont(Theme.FONT_TITLE);
    title.setForeground(Theme.TEXT_MAIN);
    mainPanel.add(title, "align center, wrap 50");

    startSimulationButton = createMenuButton("開始模擬", btnlistener);
    resultButton = createMenuButton("模擬結果", btnlistener);
    returnButton = createMenuButton("返回", btnlistener);

    mainPanel.add(startSimulationButton, "h 80!");
    mainPanel.add(resultButton, "h 80!");
    mainPanel.add(returnButton, "h 80!");

    functionPanel = new ThreeFunctionButtons(appFrame).getPanel();
    mainPanel.add(functionPanel, "growx, pushy, aligny bottom");

    appFrame.setContentPane(mainPanel);
    appFrame.setVisible(true);
  }

  private CustomButton createMenuButton(String text, ActionListener listener) {
    CustomButton btn = new CustomButton(text);
    btn.setFont(Theme.FONT_HEADER);
    btn.setCornerRadius(20);
    btn.addActionListener(listener);
    return btn;
  }

  private class ButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent a) {
      if (a.getSource() == startSimulationButton) {
        new StartSimulationGUI();
        appFrame.dispose();
      } else if (a.getSource() == resultButton) {
        new SimulationResultGUI();
        appFrame.dispose();
      } else if (a.getSource() == returnButton) {
        new MainGUI();
        appFrame.dispose();
      }
    }
  }

  public JFrame getFrame() {
    return appFrame;
  }
}
