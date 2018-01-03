/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class f_image {

    private static double angle = 0.01;
    private static AffineTransform xform;
    private static JPanel drawPanel;
    private static BufferedImage image;
    private static boolean startRotation = false;

    public static void rotateImage() {

        if (image != null) {
            xform.rotate(angle, image.getWidth() / 2, image.getHeight() / 2);
        }

    }

    public static void paintCircle() {

        Graphics2D g = (Graphics2D) drawPanel.getGraphics();

        g.fillOval(10, 10, 20, 20);

    }

    public static void paintImage() {

        Graphics2D g = (Graphics2D) drawPanel.getGraphics();

        g.drawImage(image, xform, drawPanel);

    }

    public static void reflectImage() {

        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-image.getWidth(), 0);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        image = op.filter(image, null);

    }

    public static JPanel createDrawPanel() {

        drawPanel = new JPanel();

        drawPanel.setBackground(Color.white);

        return drawPanel;

    }

    public static JPanel createButtonPanel() {

        JPanel buttonPanel = new JPanel();

        JButton addImageButton = new JButton("Add image");
        JButton startRotationButton = new JButton("Start rotation");
        JButton stopRotationButton = new JButton("Stop rotation");
        JButton changeDirectionButton = new JButton("Change direction");
        JButton reflectImageButtonByBuiltInFunction = new JButton("Reflect image");
        JButton reflectImageButtonByMyself = new JButton("Reflect image 2");

        addImageButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                try {
                    image = ImageIO.read(new File("E:\\Univ\\java_projects\\swing_sem\\src\\rainbow-background-3-big.jpg"));

                    addImageButton.setEnabled(false);
                } catch (IOException ex) {
                    Logger.getLogger(f_image.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        changeDirectionButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                angle = -angle;
            }

        });

        startRotationButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                startRotation = true;
            }

        });

        stopRotationButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                startRotation = false;
            }

        });

        reflectImageButtonByBuiltInFunction.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                reflectImage();
            }

        });

        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));

        buttonPanel.add(addImageButton);
        buttonPanel.add(Box.createVerticalStrut(3));
        buttonPanel.add(startRotationButton);
        buttonPanel.add(Box.createVerticalStrut(3));
        buttonPanel.add(stopRotationButton);
        buttonPanel.add(Box.createVerticalStrut(3));
        buttonPanel.add(changeDirectionButton);
        buttonPanel.add(Box.createVerticalStrut(3));
        buttonPanel.add(reflectImageButtonByBuiltInFunction);
        buttonPanel.add(Box.createVerticalStrut(3));
        buttonPanel.add(reflectImageButtonByMyself);

        return buttonPanel;

    }

    public static JPanel createFramePanel() {

        JPanel panel = new JPanel();

        panel.setLayout(new BorderLayout());

        panel.add(createDrawPanel(), BorderLayout.CENTER);
        panel.add(createButtonPanel(), BorderLayout.EAST);

        return panel;

    }

    public static JFrame createFrame() {

        JFrame frame = new JFrame("Rotate image application");

        frame.setContentPane(createFramePanel());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 470);
        frame.setVisible(true);

        return frame;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame f = createFrame();
        xform = new AffineTransform();
        xform.translate(150, 100);
        paintCircle();
        while (true) {
            try {
                //drawPanel.repaint(); // Остаётся след
                drawPanel.update(drawPanel.getGraphics()); // Да и в целом, этот вариант лучше.
                if (startRotation) {
                    rotateImage();
                }
                paintImage();
                paintCircle();
                Thread.sleep(1000/24);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
