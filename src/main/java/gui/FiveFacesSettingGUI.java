package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

public class FiveFacesSettingGUI {
  private final JFrame appFrame;
  private JPanel mainPanel;
  private final CustomButton academicButton;
  private final CustomButton hobbyButton;
  private final CustomButton sportButton;
  private final CustomButton socialButton;
  private final CustomButton relationshipButton;
  private final CustomButton returnButton;

  public enum Faces {
    academic,
    hobby,
    sport,
    socail,
    relationship
  }

  public FiveFacesSettingGUI() {
    double w = DynamicSizing.getYourWidth();
    double h = DynamicSizing.getYourHight();

    appFrame = new JFrame("Five Faces Setting");
    appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    appFrame.setSize((int) Math.round(640 * w), (int) Math.round(900 * h));
    appFrame.setLocationRelativeTo(null);

    ActionListener btnlistener = new ButtonListener();

    mainPanel =
        new JPanel(new MigLayout("insets 40, wrap 2, fillx, gapy 20", "[80!][grow, fill]", ""));
    mainPanel.setBackground(Theme.BG_MAIN);

    JLabel title = new JLabel("五大面向權重設定");
    title.setFont(Theme.FONT_TITLE);
    title.setForeground(Theme.TEXT_MAIN);
    mainPanel.add(title, "span 2, align center, wrap 40");

    academicButton = createCategoryButton("學業", Theme.ACADEMIC_COLOR, btnlistener);
    hobbyButton = createCategoryButton("興趣", Theme.HOBBY_COLOR, btnlistener);
    sportButton = createCategoryButton("運動", Theme.SPORT_COLOR, btnlistener);
    socialButton = createCategoryButton("社交", Theme.SOCIAL_COLOR, btnlistener);
    relationshipButton = createCategoryButton("感情", Theme.RELATIONSHIP_COLOR, btnlistener);

    addCategoryControl("學業 (Academic)", academicButton);
    addCategoryControl("興趣 (Hobby)", hobbyButton);
    addCategoryControl("運動 (Sport)", sportButton);
    addCategoryControl("社交 (Social)", socialButton);
    addCategoryControl("感情 (Relationship)", relationshipButton);

    returnButton = new CustomButton("返回主畫面");
    returnButton.setColors(Theme.TEXT_MUTED, Theme.TEXT_MAIN);
    returnButton.setCornerRadius(20);
    returnButton.addActionListener(btnlistener);

    mainPanel.add(returnButton, "span 2, h 60!, w 250!, align center, gaptop 30");

    JPanel functionPanel = new ThreeFunctionButtons(appFrame).getPanel();
    mainPanel.add(functionPanel, "span 2, growx, pushy, aligny bottom");

    appFrame.setContentPane(mainPanel);
    appFrame.setVisible(true);
  }

  private CustomButton createCategoryButton(
      String text, java.awt.Color color, ActionListener listener) {
    CustomButton btn = new CustomButton("設定權重");
    btn.setFont(Theme.FONT_REGULAR);
    btn.setCornerRadius(15);
    btn.setBackgroundColor(color);
    btn.addActionListener(listener);
    return btn;
  }

  private void addCategoryControl(String title, CustomButton btn) {
    JLabel label = new JLabel(title);
    label.setFont(Theme.FONT_HEADER);
    label.setForeground(Theme.TEXT_MAIN);
    mainPanel.add(label);
    mainPanel.add(btn, "h 45!");
  }

  private class ButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent a) {
      if (a.getSource() == academicButton) {
        new SubFacesSetting(Faces.academic);
        appFrame.dispose();
      } else if (a.getSource() == hobbyButton) {
        new SubFacesSetting(Faces.hobby);
        appFrame.dispose();
      } else if (a.getSource() == sportButton) {
        new SubFacesSetting(Faces.sport);
        appFrame.dispose();
      } else if (a.getSource() == socialButton) {
        new SubFacesSetting(Faces.socail);
        appFrame.dispose();
      } else if (a.getSource() == relationshipButton) {
        new SubFacesSetting(Faces.relationship);
        appFrame.dispose();
      } else if (a.getSource() == returnButton) {
        new MainGUI();
        appFrame.dispose();
      }
    }
  }
}
