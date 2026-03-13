package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

public class ThreeFunctionButtons {
  private JPanel panel;
  private final CustomButton subFaceButton;
  private final CustomButton backButton;
  private final CustomButton closeButton;
  private final JFrame parentFrame;

  public ThreeFunctionButtons(JFrame parentFrame) {
    this.parentFrame = parentFrame;

    panel =
        new JPanel(
            new MigLayout("insets 10, gapx 20", "[grow, fill][grow, fill][grow, fill]", "h 60!"));
    panel.setBackground(Theme.BG_MAIN);

    subFaceButton =
        new CustomButton("子目錄", ImageUtil.getScaledIcon("/gui/Icons/subfaceImg.png", 25, 25));
    backButton =
        new CustomButton("上一頁", ImageUtil.getScaledIcon("/gui/Icons/continueImg.png", 25, 25));
    closeButton = new CustomButton("關閉程式");

    styleButton(subFaceButton);
    styleButton(backButton);
    styleButton(closeButton);
    closeButton.setBackgroundColor(new java.awt.Color(255, 107, 107)); // Override with soft red

    subFaceButton.addActionListener(
        e -> {
          new SubFaces(FiveFacesSettingGUI.Faces.academic);
          parentFrame.dispose();
        });

    backButton.addActionListener(
        e -> {
          new MainGUI();
          parentFrame.dispose();
        });

    closeButton.addActionListener(e -> System.exit(0));

    panel.add(subFaceButton);
    panel.add(backButton);
    panel.add(closeButton);
  }

  private void styleButton(CustomButton btn) {
    btn.setFont(Theme.FONT_BUTTON);
    btn.setCornerRadius(15);
  }

  public JPanel getPanel() {
    return panel;
  }
}
