/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelLibraries;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Admin
 */
public class Img {

    public static Image resizer(Image img_input, int width, int height) {
        return img_input.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }

    public static byte[] img_to_array(Image img_input, String type) {
        BufferedImage bi = new BufferedImage(img_input.getWidth(null), img_input.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = bi.createGraphics();
        g2.drawImage(img_input, 0, 0, null);
        g2.dispose();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(bi, type, baos);
        } catch (IOException ex) {
        }
        return baos.toByteArray();
    }

    public static Image create_img_from_byte(byte[] input_data) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(input_data);
        BufferedImage bi = ImageIO.read(bais);
        return bi.getScaledInstance(bi.getWidth(), bi.getHeight(), Image.SCALE_SMOOTH);
    }

}
