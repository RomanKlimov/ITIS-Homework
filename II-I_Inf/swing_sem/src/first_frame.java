import javax.swing.*;
import java.awt.*;

public class first_frame {
    public static void main(String[] args) {
        JFrame f = new JFrame("Title");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(new JButton("Click me"));
        f.setBounds(300, 300, 500, 500);
        f.setVisible(true);
        f.setResizable(false);
    }
}
