package gui;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

public class MainGUI {
  private JFrame appFrame;
  private JPanel mainPanel;
  private final CustomButton fiveFacesSettingButton;
  private final CustomButton simulationButton;
  private final CustomButton scheduleButton;
  private final CustomButton implementButton;
  private final CustomButton pickButton;
  private final CustomButton settingButton;
  private ImageIcon fiveFaceSettingIcon;
  private ImageIcon simulationButtIcon;
  private ImageIcon scheduleButtonIcon;
  private ImageIcon implementButtonIcon;
  private ImageIcon pickButtonIcon;
  private ImageIcon settingButtonIcon;

  public static void main(String[] args) {
    FlatLightLaf.setup();
    new MainGUI();
  }

  public MainGUI() {
    double h = DynamicSizing.getYourHight();
    double w = DynamicSizing.getYourWidth();
    appFrame = new JFrame("Java Daily Schedule Planner");
    appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    appFrame.setSize((int) Math.round(640 * w), (int) Math.round(900 * h));
    appFrame.setLocationRelativeTo(null); // Center on screen

    mainPanel =
        new JPanel(
            new MigLayout(
                "wrap 3, insets 40, align center", "[150!]40[150!]40[150!]", "[][150!]40[150!]"));
    mainPanel.setBackground(Theme.BG_MAIN);

    loadIcons(w, h);
    ActionListener features = new AppFunctions();

    // Header Label
    JLabel headerLabel = new JLabel("Daily Schedule Manager");
    headerLabel.setFont(Theme.FONT_TITLE);
    headerLabel.setForeground(Theme.TEXT_MAIN);
    mainPanel.add(headerLabel, "span 3, align center, wrap 50");

    fiveFacesSettingButton = createMenuButton("Five faces setting", fiveFaceSettingIcon, features);
    simulationButton = createMenuButton("Simulation", simulationButtIcon, features);
    scheduleButton = createMenuButton("Schedule", scheduleButtonIcon, features);
    implementButton = createMenuButton("Implement", implementButtonIcon, features);
    pickButton = createMenuButton("Pick", pickButtonIcon, features);
    settingButton = createMenuButton("Setting", settingButtonIcon, features);

    mainPanel.add(fiveFacesSettingButton, "w 150!, h 150!");
    mainPanel.add(simulationButton, "w 150!, h 150!");
    mainPanel.add(scheduleButton, "w 150!, h 150!");

    mainPanel.add(implementButton, "w 150!, h 150!");
    mainPanel.add(pickButton, "w 150!, h 150!");
    mainPanel.add(settingButton, "w 150!, h 150!");

    appFrame.setContentPane(mainPanel);
    appFrame.setVisible(true);
  }

  private CustomButton createMenuButton(String text, ImageIcon icon, ActionListener listener) {
    CustomButton btn = new CustomButton(text, icon);
    btn.setFont(Theme.FONT_BUTTON);
    btn.setHorizontalTextPosition(JLabel.CENTER);
    btn.setVerticalTextPosition(JLabel.BOTTOM);
    btn.setCornerRadius(20);
    btn.addActionListener(listener);
    return btn;
  }

  private class AppFunctions implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent a) {
      if (a.getSource() == fiveFacesSettingButton) {
        new FiveFacesSettingGUI();
        appFrame.dispose();
      } else if (a.getSource() == simulationButton) {
        new SimulationGUI();
        appFrame.dispose();
      } else if (a.getSource() == scheduleButton) {
        new ScheduleGUI();
        appFrame.dispose();
      } else if (a.getSource() == implementButton) {
        new ImplementGUI();
        appFrame.dispose();
      } else if (a.getSource() == pickButton) {
        new PickGUI();
        appFrame.dispose();
      } else if (a.getSource() == settingButton) {
      }
    }
  }

  private void loadIcons(double w, double h) {
    fiveFaceSettingIcon =
        ImageUtil.getScaledIcon(
            "/gui/Icons/fiveFacesSettingButtonImg.png",
            (int) Math.round(75 * w),
            (int) Math.round(75 * h));
    simulationButtIcon =
        ImageUtil.getScaledIcon(
            "/gui/Icons/simulationButtonImg.png",
            (int) Math.round(75 * w),
            (int) Math.round(75 * h));
    scheduleButtonIcon =
        ImageUtil.getScaledIcon(
            "/gui/Icons/schedulebButtonImg.png",
            (int) Math.round(75 * w),
            (int) Math.round(75 * h));
    implementButtonIcon =
        ImageUtil.getScaledIcon(
            "/gui/Icons/implementButtonImg.png",
            (int) Math.round(75 * w),
            (int) Math.round(75 * h));
    pickButtonIcon =
        ImageUtil.getScaledIcon(
            "/gui/Icons/pickButtonImg.png", (int) Math.round(75 * w), (int) Math.round(75 * h));
    settingButtonIcon =
        ImageUtil.getScaledIcon(
            "/gui/Icons/settingbButtonImg.png", (int) Math.round(75 * w), (int) Math.round(75 * h));
  }

  public JFrame getFrame() {
    return appFrame;
  }
}
