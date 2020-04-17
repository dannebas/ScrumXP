package dbUtils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Viggo
 */
public class PictureHandler {

    private int width;
    private int height;

    public PictureHandler(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Image openFile() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & GIF Images", "jpg", "gif");
        chooser.setFileFilter(filter);
        int returnOption = chooser.showOpenDialog(chooser);

        File picture = null;

        if (returnOption == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: "
                    + chooser.getSelectedFile().getName());

            picture = chooser.getSelectedFile();
        }

        Image myPicture = convertToImageFromFile(picture);
        Image resizedPicture = resize(myPicture);

        return resizedPicture;
    }

    public File openFile2() {

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & GIF Images", "jpg", "gif");
        chooser.setFileFilter(filter);
        int returnOption = chooser.showOpenDialog(chooser);

        File picture = null;

        if (returnOption == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: "
                    + chooser.getSelectedFile().getName());

            picture = chooser.getSelectedFile();
        }

        return picture;
    }

    public Image resize(Image imageFile) {
        //Scale the image to the given width and height.
        Image newImage = imageFile.getScaledInstance(width, height, Image.SCALE_DEFAULT);

        return newImage;
    }

    public Image convertToImageFromFile(File myFile) {
        Image image = null;
        try {
            image = ImageIO.read(myFile);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return image;
    }

     
    
   /* public void convertToImage(String user, ImageIcon img) {
        byte[] bytes = null;

        Icon icon = null;
        BufferedImage abc123 = new BufferedImage(img.getIconWidth(), img.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = abc123.createGraphics();
        img.paintIcon(null, g2d, 0, 0);
        g2d.dispose();
        String s = null;

        try ( ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ImageOutputStream ios = ImageIO.createImageOutputStream(baos);
            try {
                ImageIO.write((RenderedImage) abc123, "png", ios);

                // Set a flag to indicate that the write was successful
            } finally {
                ios.close();
            }

            bytes = baos.toByteArray();

            System.out.println(bytes);
            s = new String(bytes);
            // JOptionPane.showMessageDialog(null, "BYTES: " + s);
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }*/
}
