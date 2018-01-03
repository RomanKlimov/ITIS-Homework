
import javafx.scene.layout.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.FontUIResource;

public class App {

    private static JFrame frame;
    private static JDialog dialog;
    private static JLabel status;

    public static JPanel createRightSidePanel() {

        JPanel buttonPanel = new JPanel();

        JButton[] buttons = {new JButton("Button1"), new JButton("Button2"), new JButton("Button3")};

        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
        buttonPanel.setBorder(new BevelBorder(BevelBorder.RAISED));

        for (JButton button : buttons) {


            button.setBackground(Color.BLUE);
            button.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseEntered(MouseEvent me) {
                    status.setText("Mouse on " + button.getText());
                }

                @Override
                public void mouseExited(MouseEvent me) {
                    status.setText("Status");
                }

            });

            buttonPanel.add(button);
            buttonPanel.setBackground(Color.GRAY  );
            buttonPanel.add(Box.createVerticalStrut(3));

        }

        return buttonPanel;
    }

    public static JMenuBar createMenuBar() {

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu("Help");

        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem aboutItem = new JMenuItem("About");

        exitItem.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        aboutItem.addActionListener((ActionEvent e) -> {
            dialog.setVisible(true);
        });

        fileMenu.add(exitItem);
        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        return menuBar;
    }

    public static JPanel createStatusBar() {

        JPanel statusBar = new JPanel();

        status = new JLabel("Status");

        statusBar.setLayout(new BorderLayout());
        statusBar.setBorder(new BevelBorder(BevelBorder.LOWERED));

        statusBar.add(status, BorderLayout.SOUTH);

        return statusBar;
    }

    public static JPanel createFormPanel() throws IOException {

        JPanel panel = new JPanel();
//        BufferedImage image = ImageIO.read(new File("E:\\Univ\\java_projects\\swing_sem\\src\\rainbow-background-3-big.jpg"));
//        JLabel label = new JLabel(new ImageIcon(image ));
//        panel.add(label);

        GroupLayout layout = new GroupLayout(panel);

        JLabel label1 = new JLabel("Label 1");
        JLabel label2 = new JLabel("Label 2");

        JButton submitButton = new JButton("Submit");

        JTextField textField1 = new JTextField(10);
        JTextField textField2 = new JTextField(10);

        submitButton.addActionListener((ActionEvent e) -> {
            if (textField1.getText().trim().length() == 0) {
                textField1.setBackground(Color.red);
            } else {
                textField1.setBackground(Color.green);
            }
            if (textField2.getText().trim().length() == 0) {
                textField2.setBackground(Color.red);
            } else {
                textField2.setBackground(Color.green);
            }
        });

        textField1.setMaximumSize(new Dimension(100, 0));
        textField2.setMaximumSize(new Dimension(100, 0));

        panel.setLayout(layout);
        panel.setBackground(Color.YELLOW);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup().addComponent(label1).addComponent(label2))
                        .addGroup(layout.createParallelGroup().addComponent(textField1).addComponent(textField2).addComponent(submitButton)));
//                        .addGroup(layout.createParallelGroup().addComponent(submitButton)));

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup().addComponent(label1).addComponent(textField1))
                        .addGroup(layout.createParallelGroup().addComponent(label2).addComponent(textField2))
                        .addGroup(layout.createParallelGroup().addComponent(submitButton)));

        panel.setBorder(new BevelBorder(BevelBorder.LOWERED));


        submitButton.setForeground(Color.BLACK);
        submitButton.setBackground(Color.PINK);
        LineBorder line = new LineBorder(Color.BLACK);
        EmptyBorder margin = new EmptyBorder(5, 15, 5, 15);
        CompoundBorder compound = new CompoundBorder(line, margin);
        submitButton.setBorder(compound);



        return panel;
    }

    public static void createDialog(JFrame owner) throws FontFormatException, IOException {
        dialog = new JDialog(owner, JDialog.ModalityType.DOCUMENT_MODAL);

        JLabel label = new JLabel("Info dialog");
        JButton button = new JButton("OK");
        button.setBackground(Color.YELLOW);
//        button.setBorder(BorderFactory.createLineBorder(Color.black));
        button.addActionListener((ActionEvent e) -> {
            dialog.dispose();
        });
        dialog.getContentPane().setLayout(new FlowLayout());
        dialog.getContentPane().add(label);
        dialog.getContentPane().add(button);
        dialog.getContentPane().setBackground(Color.LIGHT_GRAY);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setUndecorated(true);// убираем рамку и тайтл бар
        dialog.setMinimumSize(new Dimension(200, 100));
        dialog.pack();
        dialog.setLocationRelativeTo(owner);
    }

    public App() throws IOException {

        frame = new JFrame("Hello");
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(createStatusBar(), BorderLayout.SOUTH);
        frame.getContentPane().add(createRightSidePanel(), BorderLayout.EAST);
        frame.getContentPane().add(createFormPanel(), BorderLayout.CENTER);
        frame.setJMenuBar(createMenuBar());
        frame.setMinimumSize(new Dimension(500, 300));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        try {
            createDialog(frame);
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException, IOException {
        javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        FontUIResource f = new FontUIResource(new Font("Verdana", 0, 12));
        Enumeration<Object> keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                FontUIResource orig = (FontUIResource) value;
                Font font = new Font(f.getFontName(), orig.getStyle(), f.getSize());
                UIManager.put(key, new FontUIResource(font));
            }
        }
        App javaSwing = new App();
    }

}