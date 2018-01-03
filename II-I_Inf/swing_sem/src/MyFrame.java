import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class MyFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setSize(500, 600);

// create the status bar panel and shove it down the bottom of the frame
        JPanel statusPanel = new JPanel();
        JPanel sideBar = new JPanel();
        statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        sideBar.setBorder(new BevelBorder(BevelBorder.LOWERED));
        frame.add(statusPanel, BorderLayout.SOUTH);
        frame.add(sideBar, BorderLayout.EAST);
        statusPanel.setPreferredSize(new Dimension(frame.getWidth(), 16));
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
        JLabel statusLabel = new JLabel("status");
        statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
        statusPanel.add(statusLabel);

        frame.setVisible(true);
    }
}
