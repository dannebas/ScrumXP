package dbUtils;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Viggo
 */

public class PictureHandler 
{
    private int width;
    private int height;
    
    public PictureHandler(int width, int height)
    {
        this.width = width;
        this.height = height;
    }
    
    public Image openFile()
    {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "JPG & GIF Images", "jpg", "gif");
        chooser.setFileFilter(filter);
        int returnOption = chooser.showOpenDialog(chooser);
        
        File picture = null;
        
        if(returnOption == JFileChooser.APPROVE_OPTION)
        {
            System.out.println("You chose to open this file: " +
            chooser.getSelectedFile().getName());
            
             picture = chooser.getSelectedFile();
        }
        
        Image myPicture = convertToImageFromFile(picture);
        Image resizedPicture = resize(myPicture);
        
        return resizedPicture;
    }
    
    private Image resize(Image imageFile)
    {
        //Scale the image to the given width and height.
        Image newImage = imageFile.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        
        return newImage;
    }
    
    private Image convertToImageFromFile(File myFile)
    {
        Image image = null;
        try 
        {
            image = ImageIO.read(myFile);
        } catch (IOException ex) 
        {
            ex.printStackTrace();
        }
        
        return image;
    }
}
