/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class Redimensiona {  
      
    public static BufferedImage rescale(Image image, int height, int width) {  
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
        Graphics2D gg = result.createGraphics();  
        try {  
            gg.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);  
            gg.drawImage(image, 0, 0, width, height, null);  
        } finally {  
            gg.dispose();  
        }  
        return result;  
    }  
}