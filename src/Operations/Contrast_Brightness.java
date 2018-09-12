/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;

import java.awt.Color;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;

/**
 *
 * @author Juan Eduardo
 */
public class Contrast_Brightness {
    
    public static BufferedImage changeBrightness(BufferedImage img, int level){
        int[] pixel;
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                pixel = img.getRaster().getPixel(i, j, new int[3]);
                HSLColor color = new HSLColor(pixel[0], pixel[1], pixel[2]);
                
            }
        }
    
        return img;
    }
    public static BufferedImage linealExpansion(BufferedImage img, int level){
        Histogram h = new Histogram(img);
        //BufferedImage im = new BufferedImage(img.getWidth(), img.getHeight(), ColorSpace.TYPE_HLS);
        //im.setData(img.getData());
        int[] pixel;
        float[] hsb;
        float minBri = h.getMin()/255;
        float maxBri= h.getMax()/255;
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
            pixel = img.getRaster().getPixel(i, j, new int[3]);
            //HSLColor hsl = new HSLColor(pixel[0], pixel[1], pixel[2]);
             hsb = Color.RGBtoHSB(pixel[0], pixel[1], pixel[2], new float[3]);
           //System.out.println(hsl.getLuminosity());
            float l =(hsb[2]-minBri) / (maxBri - minBri);
            hsb[2] = l;
            int col = Color.HSBtoRGB(hsb[0], hsb[1],hsb[2]);
          //  System.out.println(col);
            //int gl = (pixel[0] + pixel[1] + pixel[2]) / 3;
            //int col = (pixel[0]+level<<16) + (pixel[1]+level<<8) + (pixel[2]+level);
            img.setRGB(i, j, col);
            }
        }
        return img;
    }
    
}
