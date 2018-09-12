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
public class Matrix {
    double[][] kernel;
    public Matrix(){
        
    }
    
    public static BufferedImage applyKernel(BufferedImage img, double[][] kernel,int kernelDivisor){
        int[] pixel;
        System.out.println();
        
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                pixel =  img.getRaster().getPixel(i, j, new int[3]);
                int valuer =0;
                int valueg =0;
                int valueb =0;
                int col=0;
                for (int k = 3-1; k >=0; k--) {
                    for (int l = 3-1; l >=0; l--) {
                        valuer += kernel[k][l] * pixel[0];
                        valueg += kernel[k][l] * pixel[1];
                        valueb += kernel[k][l] * pixel[2];
                        
                        
                    }
                    
                }
                col = (valuer<<16)+(valueg<<8) + valueb;
                img.setRGB(i, j, (int) Math.round(col/kernelDivisor));
               
                
            }
        }
        
        return img;
    }
    
}
