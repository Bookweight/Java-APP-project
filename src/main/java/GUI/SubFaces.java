package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;
import GUI.FiveFacesSettingGUI.Faces;

public class SubFaces {
    private final JFrame appFrame;
    private JPanel mainPanel;
    private final CustomButton returnButton;

    public SubFaces(Faces face) {
        double w = DynamicSizing.getYourWidth();
        double h = DynamicSizing.getYourHight();
        
        appFrame = new JFrame("Sub-item Details: " + face);
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appFrame.setSize((int) Math.round(640 * w), (int) Math.round(900 * h));
        appFrame.setLocationRelativeTo(null);

        mainPanel = new JPanel(new MigLayout("insets 40, wrap 1, fillx, gapy 20", "[grow, fill]", ""));
        mainPanel.setBackground(Theme.BG_MAIN);

        JLabel title = new JLabel(face.toString().toUpperCase() + " 細項列表");
        title.setFont(Theme.FONT_TITLE);
        title.setForeground(Theme.TEXT_MAIN);
        mainPanel.add(title, "align center, wrap 40");

        // Example sub-items (placeholder logic for original sub-item display)
        for (int i = 1; i <= 3; i++) {
            mainPanel.add(createSubItemCard("子項目 " + i, (int)(Math.random() * 100)));
        }

        returnButton = new CustomButton("返回");
        returnButton.setColors(Theme.TEXT_MUTED, Theme.TEXT_MAIN);
        returnButton.setCornerRadius(20);
        returnButton.addActionListener(e -> {
            new FiveFacesSettingGUI();
            appFrame.dispose();
        });

        mainPanel.add(returnButton, "h 60!, w 200!, align center, gaptop 30");

        JPanel functionPanel = new ThreeFunctionButtons(appFrame).getPanel();
        mainPanel.add(functionPanel, "growx, pushy, aligny bottom");

        appFrame.setContentPane(mainPanel);
        appFrame.setVisible(true);
    }

    private JPanel createSubItemCard(String name, int progress) {
        JPanel card = new JPanel(new MigLayout("insets 15", "[grow][50!]", ""));
        card.setBackground(Theme.BG_CARD);
        card.setBorder(new javax.swing.border.LineBorder(Theme.BORDER_COLOR, 1, true));
        
        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(Theme.FONT_HEADER);
        nameLabel.setForeground(Theme.TEXT_MAIN);
        
        JLabel progressLabel = new JLabel(progress + "%");
        progressLabel.setFont(Theme.FONT_REGULAR);
        progressLabel.setForeground(Theme.PRIMARY);
        
        card.add(nameLabel);
        card.add(progressLabel, "align right");
        
        return card;
    }
}
