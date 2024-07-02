/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gymm;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author erick
 */
public class loadphoto {
     public static BufferedImage loadImage(String urlGambar){
        BufferedImage bimg = null;
        try {
            bimg = ImageIO.read(new File(urlGambar) );
        } catch (IOException e) {
            System.out.println("gagal load gambar;"+e.getMessage());
        }
        return bimg;
    }
}
