package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

public class ThreeFunctionButtons {
  private JPanel panel;
  private final CustomButton returnMainButton;
  private final CustomButton saveButton;
  private final CustomButton clearButton;
  private JFrame Frame;

  public ThreeFunctionButtons(JFrame Frame) {
    this.Frame = Frame;
    ActionListener Listener = new ButtonListener();

    // Horizontal layout spreading across evenly
    panel =
        new JPanel(
            new MigLayout("insets 10, fillx", "[grow, fill]10[grow, fill]10[grow, fill]", "[40!]"));
    panel.setOpaque(false); // Let parent background show

    returnMainButton = new CustomButton("回主畫面");
    saveButton = new CustomButton("儲存");
    clearButton = new CustomButton("清除");

    // Neutral colors for utility buttons
    returnMainButton.setColors(Theme.TEXT_MUTED, Theme.TEXT_MAIN);
    saveButton.setColors(Theme.SPORT_COLOR, Theme.SPORT_COLOR.darker());
    clearButton.setColors(Theme.ACADEMIC_COLOR, Theme.ACADEMIC_COLOR.darker());

    returnMainButton.addActionListener(Listener);
    saveButton.addActionListener(Listener);
    clearButton.addActionListener(Listener);

    panel.add(returnMainButton);
    panel.add(saveButton);
    panel.add(clearButton);
  }

  private class ButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent a) {
      if (a.getSource() == returnMainButton) {
        new MainGUI();
        Frame.dispose();
      } else if (a.getSource() == saveButton) {
        // save
      } else if (a.getSource() == clearButton) {
        // clear
      }
    }
  }

  public JPanel getPanel() {
    return panel;
  }
}
