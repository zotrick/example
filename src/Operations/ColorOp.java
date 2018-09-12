/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;

import java.awt.image.BufferedImage;

/**
 *
 * @author Juan Eduardo
 */
public class ColorOp {
    
    public static BufferedImage RGBFilter(BufferedImage img,boolean r, boolean g, boolean b){
        int[] pixel;
        if(!r&&!g&&!b)
            return img;
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                pixel = img.getRaster().getPixel(i, j, new int[3]);
                int col = 0; 
                if(r)
                    col += ((pixel[0]) << 16);
                if(g)
                    col += ((pixel[1]) << 8);
                if(b)
                    col += (pixel[2]);
                
                 img.setRGB(i, j, col);
            }
        }
        return img;
    }
    
    public static BufferedImage RedFilter(BufferedImage img){
        int[] pixel;
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                pixel = img.getRaster().getPixel(i, j, new int[3]);
                int col = ((pixel[0]) << 16) + ((0) << 8) + (0); 
                 img.setRGB(i, j, col);
            }
        }
        return img;
    }
    public static BufferedImage GreenFilter(BufferedImage img){
        int[] pixel;
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                pixel = img.getRaster().getPixel(i, j, new int[3]);
                int col = ((0) << 16) + ((pixel[1]) << 8) + (0); 
                 img.setRGB(i, j, col);
            }
        }
        return img;
    }
    public static BufferedImage BlueFilter(BufferedImage img){
        int[] pixel;
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                pixel = img.getRaster().getPixel(i, j, new int[3]);
                int col = ((0) << 16) + ((0) << 8) + (pixel[2]); 
                 img.setRGB(i, j, col);
            }
        }
        return img;
    }
    
    
    public static BufferedImage Negative(BufferedImage img){
        int[] pixel;
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                pixel = img.getRaster().getPixel(i, j, new int[3]);
                  int col = ((255-pixel[0]) << 16) + ((255-pixel[1]) << 8) + (255-pixel[2]); 
                 img.setRGB(i, j, col);
            }
        }
        return img;
    }
    
    
    
    
}
