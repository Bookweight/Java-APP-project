package gui;

import gui.FiveFacesSettingGUI.Faces;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

public class SubFaces {
  private final JFrame appFrame;
  private JPanel mainPanel;
  private final CustomButton returnButton;

  public SubFaces(Faces face) {
    double w = DynamicSizing.getYourWidth();
    double h = DynamicSizing.getYourHight();

    appFrame = new JFrame("Sub-items: " + face);
    appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    appFrame.setSize((int) Math.round(640 * w), (int) Math.round(900 * h));
    appFrame.setLocationRelativeTo(null);

    mainPanel = new JPanel(new MigLayout("insets 40, wrap 1, fillx, gapy 20", "[grow, fill]", ""));
    mainPanel.setBackground(Theme.BG_MAIN);

    JLabel title = new JLabel(face.toString().toUpperCase() + " 細目清單");
    title.setFont(Theme.FONT_TITLE);
    title.setForeground(Theme.TEXT_MAIN);
    mainPanel.add(title, "align center, wrap 40");

    // Example sub-items as "cards"
    for (int i = 1; i <= 3; i++) {
      mainPanel.add(createItemCard("子項目 " + i));
    }

    returnButton = new CustomButton("返回主畫面");
    returnButton.setColors(Theme.TEXT_MUTED, Theme.TEXT_MAIN);
    returnButton.setCornerRadius(20);
    returnButton.addActionListener(
        e -> {
          new MainGUI();
          appFrame.dispose();
        });

    mainPanel.add(returnButton, "h 60!, w 250!, align center, gaptop 30");

    JPanel functionPanel = new ThreeFunctionButtons(appFrame).getPanel();
    mainPanel.add(functionPanel, "growx, pushy, aligny bottom");

    appFrame.setContentPane(mainPanel);
    appFrame.setVisible(true);
  }

  private JPanel createItemCard(String text) {
    JPanel card = new JPanel(new MigLayout("insets 15", "[][grow]", ""));
    card.setBackground(Theme.BG_CARD);
    card.setBorder(new javax.swing.border.LineBorder(Theme.BORDER_COLOR, 1, true));

    JLabel iconPlaceholder = new JLabel(ImageUtil.getScaledIcon("/gui/Icons/starImg.png", 30, 30));
    JLabel nameLabel = new JLabel(text);
    nameLabel.setFont(Theme.FONT_HEADER);
    nameLabel.setForeground(Theme.TEXT_MAIN);

    card.add(iconPlaceholder);
    card.add(nameLabel, "gapleft 15");

    return card;
  }
}
