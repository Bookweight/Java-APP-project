package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;

public class ScheduleGUI {
  private final JFrame appFrame;
  private JPanel mainPanel;
  private final CustomButton academicButton;
  private final CustomButton hobbyButton;
  private final CustomButton sportButton;
  private final CustomButton socialButton;
  private final CustomButton relationshipButton;
  private final CustomButton returnButton;

  public ScheduleGUI() {
    double w = DynamicSizing.getYourWidth();
    double h = DynamicSizing.getYourHight();

    appFrame = new JFrame("Schedule Overview");
    appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    appFrame.setSize((int) Math.round(640 * w), (int) Math.round(900 * h));
    appFrame.setLocationRelativeTo(null);

    ActionListener btnlistener = new ButtonListener();

    mainPanel =
        new JPanel(
            new MigLayout("insets 40, wrap 3, fillx, gapy 20", "[80!][grow, fill][120!]", ""));
    mainPanel.setBackground(Theme.BG_MAIN);

    JLabel title = new JLabel("行程進度總覽");
    title.setFont(Theme.FONT_TITLE);
    title.setForeground(Theme.TEXT_MAIN);
    mainPanel.add(title, "span 3, align center, wrap 40");

    academicButton = createDetailButton(btnlistener);
    hobbyButton = createDetailButton(btnlistener);
    sportButton = createDetailButton(btnlistener);
    socialButton = createDetailButton(btnlistener);
    relationshipButton = createDetailButton(btnlistener);

    addCategoryRow("學業", 65, Theme.ACADEMIC_COLOR, academicButton);
    addCategoryRow("興趣", 30, Theme.HOBBY_COLOR, hobbyButton);
    addCategoryRow("運動", 85, Theme.SPORT_COLOR, sportButton);
    addCategoryRow("社交", 50, Theme.SOCIAL_COLOR, socialButton);
    addCategoryRow("感情", 15, Theme.RELATIONSHIP_COLOR, relationshipButton);

    returnButton = new CustomButton("返回主畫面");
    returnButton.setColors(Theme.TEXT_MUTED, Theme.TEXT_MAIN);
    returnButton.setCornerRadius(20);
    returnButton.addActionListener(btnlistener);

    mainPanel.add(returnButton, "span 3, h 60!, w 250!, align center, gaptop 30");

    JPanel functionPanel = new ThreeFunctionButtons(appFrame).getPanel();
    mainPanel.add(functionPanel, "span 3, growx, pushy, aligny bottom");

    appFrame.setContentPane(mainPanel);
    appFrame.setVisible(true);
  }

  private CustomButton createDetailButton(ActionListener listener) {
    CustomButton btn = new CustomButton("查看細項");
    btn.setFont(Theme.FONT_REGULAR);
    btn.setCornerRadius(15);
    btn.setColors(Theme.TEXT_MUTED, Theme.TEXT_MAIN);
    btn.addActionListener(listener);
    return btn;
  }

  private void addCategoryRow(String name, int progress, java.awt.Color color, CustomButton btn) {
    JLabel label = new JLabel(name, SwingConstants.CENTER);
    label.setFont(Theme.FONT_BUTTON);
    label.setForeground(Theme.TEXT_MAIN);

    JProgressBar pb = new JProgressBar(0, 100);
    pb.setValue(progress);
    pb.setStringPainted(true);
    pb.setForeground(color);

    mainPanel.add(label, "align center");
    mainPanel.add(pb, "growx, h 30!");
    mainPanel.add(btn, "h 40!");
  }

  private class ButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent a) {
      if (a.getSource() == academicButton) {
        new SubFacesSchedule(FiveFacesSettingGUI.Faces.academic);
        appFrame.dispose();
      } else if (a.getSource() == hobbyButton) {
        new SubFacesSchedule(FiveFacesSettingGUI.Faces.hobby);
        appFrame.dispose();
      } else if (a.getSource() == sportButton) {
        new SubFacesSchedule(FiveFacesSettingGUI.Faces.sport);
        appFrame.dispose();
      } else if (a.getSource() == socialButton) {
        new SubFacesSchedule(FiveFacesSettingGUI.Faces.socail);
        appFrame.dispose();
      } else if (a.getSource() == relationshipButton) {
        new SubFacesSchedule(FiveFacesSettingGUI.Faces.relationship);
        appFrame.dispose();
      } else if (a.getSource() == returnButton) {
        new MainGUI();
        appFrame.dispose();
      }
    }
  }
}
