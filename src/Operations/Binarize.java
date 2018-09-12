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
public class Binarize {
    
    BufferedImage img;
    public static BufferedImage AutoBinarize(BufferedImage img){
        Histogram h = new Histogram(img);
        
        double mean = 0;
        int[] pixel;
        double tresh = 0;
        double var=0;
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                pixel = img.getRaster().getPixel(i, j, new int[3]);
                int gl = (pixel[0] + pixel[1] + pixel[2]) / 3;
                
            }
        }
        int totalpixel =h.getNpixels();
        mean = h.getMean();
        
                
        System.out.println("Mean: "+mean);
        int[] pixel2;
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                 pixel2 = img.getRaster().getPixel(i, j, new int[3]);
                 int gl = (pixel2[0] + pixel2[1] + pixel2[2]) / 3;
                 int col = 0;
                 tresh = Math.pow((col-(int)mean),2)/totalpixel;
                 if(gl>tresh){
                 col = (255 << 16) + (255 << 8) + 255; 
                 }
                 img.setRGB(i, j, col);
           }
        }
        
        return img;
    }
    public  static BufferedImage BinarizeTreshold(BufferedImage img,int max,int min){
        int[] pixel;
        int dif =0;
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                pixel = img.getRaster().getPixel(i, j, new int[3]);
                int gl = (pixel[0] + pixel[1] + pixel[2]) / 3;
                int col =0;
                dif = Math.abs(max-gl);
                if(dif<Math.abs(min-gl)){
                    col += (255 << 16) + (255 << 8) + 255; 
                }else{
                    col += (0 << 16) + (0 << 8) + 0; 
                }
                
                 img.setRGB(i, j, col);
            }
        }
        return img;
    }
    public  static BufferedImage BinarizeRGB(BufferedImage img,int max, int min){
        int[] pixel;
        pixel = img.getRaster().getPixel(0, 0, new int[3]);
                
        int dif = 0;
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
            pixel = img.getRaster().getPixel(i, j, new int[3]);
                
                int col = 0;      
                if(Math.abs(max-pixel[0])<Math.abs(min-pixel[0])){
                    col += (255<<16); 
                }else{
                    col += (0<<16); 
                }
                if(Math.abs(max-pixel[1])<Math.abs(min-pixel[1])){
                    col += (255<<8); 
                }else{
                    col += (0<<8); 
                }
                if(Math.abs(max-pixel[2])<Math.abs(min-pixel[2])){
                    col += (255); 
                }else{
                    col += (0); 
                }
                
                img.setRGB(i, j, col);
                
            }
        }
        
        return img;
    }
    
    public  static BufferedImage Grayscale(BufferedImage img){
        int[] pixel;
        pixel = img.getRaster().getPixel(0, 0, new int[3]);
        int gl = (pixel[0] + pixel[1] + pixel[2]) / 3;
        int gr = (gl << 16) + (gl << 8) + gl; 
        System.out.println("Colors: "+pixel[0]+" | "+pixel[1] +" | "+pixel[2]);
        System.out.println("mean: "+gl + "  gl 16"+(gl<<16)+"  gl 8"+(gl<<8)+ "  gl 0"+(gl<<1)+"   gris rgb"+gr);
        
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                pixel = img.getRaster().getPixel(i, j, new int[3]);
                int grayLevel = (pixel[0] + pixel[1] + pixel[2]) / 3;
                int gray = (grayLevel << 16) + (grayLevel << 8) + grayLevel; 
                img.setRGB(i, j, gray);
                
            }
            
        }
        return img;
    }
    
}
