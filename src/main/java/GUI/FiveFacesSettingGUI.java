package GUI;

import GUI.FiveFacesSettingGUI.Faces;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;

public class FiveFacesSettingGUI {
  private JFrame appFrame;
  private JPanel mainPanel;
  private JPanel functionPanel;
  private final JTextField academicWeight;
  private final JTextField hobbyWeight;
  private final JTextField sportWeight;
  private final JTextField socialWeight;
  private final JTextField relationshipWeight;
  private final CustomButton academicButton;
  private final CustomButton hobbyButton;
  private final CustomButton sportButton;
  private final CustomButton socialButton;
  private final CustomButton relationshipButton;

  private ImageIcon academicIcon;
  private ImageIcon hobbyIcon;
  private ImageIcon sportIcon;
  private ImageIcon socialIcon;
  private ImageIcon relationshipIcon;

  public FiveFacesSettingGUI() {
    double w = DynamicSizing.getYourWidth();
    double h = DynamicSizing.getYourHight();

    appFrame = new JFrame("Five Faces Setting");
    appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    appFrame.setSize((int) Math.round(640 * w), (int) Math.round(900 * h));
    appFrame.setLocationRelativeTo(null);

    loadIcons(w, h);
    ActionListener btnlistener = new ButtonListener();

    mainPanel =
        new JPanel(
            new MigLayout("insets 40, wrap 3, fillx, gapy 20", "[80!][grow, fill][120!]", ""));
    mainPanel.setBackground(Theme.BG_MAIN);

    JLabel title = new JLabel("請輸入自訂比重:(1到5)");
    title.setFont(Theme.FONT_TITLE);
    title.setForeground(Theme.TEXT_MAIN);
    mainPanel.add(title, "span 3, align center, wrap 40");

    academicWeight = createTextField();
    hobbyWeight = createTextField();
    sportWeight = createTextField();
    socialWeight = createTextField();
    relationshipWeight = createTextField();

    academicButton = createDetailButton(btnlistener);
    hobbyButton = createDetailButton(btnlistener);
    sportButton = createDetailButton(btnlistener);
    socialButton = createDetailButton(btnlistener);
    relationshipButton = createDetailButton(btnlistener);

    addCategoryRow("學業", academicIcon, academicWeight, academicButton);
    addCategoryRow("興趣", hobbyIcon, hobbyWeight, hobbyButton);
    addCategoryRow("運動", sportIcon, sportWeight, sportButton);
    addCategoryRow("社交", socialIcon, socialWeight, socialButton);
    addCategoryRow("感情", relationshipIcon, relationshipWeight, relationshipButton);

    functionPanel = new ThreeFunctionButtons(appFrame).getPanel();
    mainPanel.add(functionPanel, "span 3, growx, pushy, aligny bottom");

    appFrame.setContentPane(mainPanel);
    appFrame.setVisible(true);
  }

  private JTextField createTextField() {
    JTextField tf = new JTextField("0");
    tf.setFont(Theme.FONT_HEADER);
    tf.setHorizontalAlignment(JTextField.CENTER);
    return tf;
  }

  private CustomButton createDetailButton(ActionListener listener) {
    CustomButton btn = new CustomButton("細項設定");
    btn.setFont(Theme.FONT_REGULAR);
    btn.setCornerRadius(15);
    btn.setColors(Theme.TEXT_MUTED, Theme.TEXT_MAIN);
    btn.addActionListener(listener);
    return btn;
  }

  private void addCategoryRow(
      String name, ImageIcon icon, JTextField weightField, CustomButton btn) {
    JLabel label = new JLabel(name, icon, SwingConstants.CENTER);
    label.setVerticalTextPosition(JLabel.BOTTOM);
    label.setHorizontalTextPosition(JLabel.CENTER);
    label.setFont(Theme.FONT_BUTTON);
    label.setForeground(Theme.TEXT_MAIN);

    mainPanel.add(label, "align center");
    mainPanel.add(weightField, "growx, h 40!");
    mainPanel.add(btn, "h 40!");
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
      }
    }
  }

  private void loadIcons(double w, double h) {
    int s = (int) Math.round(60 * w);
    academicIcon = ImageUtil.getScaledIcon("/GUI/Icons/academicImg.png", s, s);
    hobbyIcon = ImageUtil.getScaledIcon("/GUI/Icons/hobbyImg.png", s, s);
    sportIcon = ImageUtil.getScaledIcon("/GUI/Icons/sportsImg.png", s, s);
    socialIcon = ImageUtil.getScaledIcon("/GUI/Icons/socialImg.png", s, s);
    relationshipIcon = ImageUtil.getScaledIcon("/GUI/Icons/relationshipImg.png", s, s);
  }

  public JFrame getFrame() {
    return appFrame;
  }

  public enum Faces {
    academic,
    hobby,
    sport,
    socail,
    relationship;
  }
}
