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
public class Histogram {
    private int data[];
    private int mean=0, max=-1,min=-1,npixels=0;
    private int mode=0,median=0;
    private double stdDesv,variance;
    
    public Histogram(BufferedImage img){
        calculateHistogram(img);
        calculateMinMax();
        calculateMedian();
        calculateMode();
        calculateVariance(img);
       // calculateStdDesv();
       HSLColor hsl = new HSLColor(185, 25, 200);
       System.out.println("h: "+hsl.getHue()+" s:"+hsl.getSaturation()+" l:"+hsl.getLuminosity());
       hsl.getRGB();
       System.out.println("r: "+hsl.getR()+" g:"+hsl.getG()+" b:"+hsl.getB());
       System.out.println();
    }
//    private void calculateStdDesv(){
//        int sum = 0;
//        for (int i = 0; i < this.data.length; i++) {
//            sum+= Math.pow(data[i]-this.mean, 2);
//        }
//        double v=0,d=0;
//        v = sum/npixels;
//        d = Math.sqrt(v);
//        System.out.println("Var2: "+v+"  stdesv2: "+d);
//    }
    
    private void calculateVariance(BufferedImage img){
        int[] pixel;
        int sum = 0;
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                pixel = img.getRaster().getPixel(i, j, new int[3]);
                int gl = (pixel[0] + pixel[1] + pixel[2]) / 3;
                sum += Math.pow(gl-this.mean, 2);
            }
        }
        double v=0,d=0;
        v = sum/npixels;
        d = Math.sqrt(v);
       // System.out.println("Var1: "+v+"  stdesv1: "+d);
        this.variance = sum/npixels;
        this.stdDesv =Math.sqrt(this.variance);
    }

    private void calculateHistogram(BufferedImage img) {
        data = new int[256];
        int[] pixel;
        npixels = img.getWidth()*img.getHeight();
        int sum =0;
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                pixel = img.getRaster().getPixel(i, j, new int[3]);
                int gl = (pixel[0] + pixel[1] + pixel[2]) / 3;
                data[gl]++;
                sum += gl;
            }
        }
        
        mean= sum/npixels;
    }
    private void calculateMedian(){
        int half = this.npixels/2;
        int value=0;
        for (; median < data.length; median++) {
            value+=data[median];
            if(value>=half){
                break;
            }
        }
    }
    private void calculateMode() {
        
        for (int i = 1; i < data.length; i++) {
            if(data[i] > data[mode])
                {
                    mode = i;
                }
        }
    }
    private void calculateMinMax(){
        for (int i = 0; i < data.length; i++) {
           if(data[i]>0) {
               min = i;
               break;
           }
           min =255;
        }
        
        for (int i = data.length-1; i >=0; i--) {
           if(data[i]>0) {
               max = i;
               break;
           }
           max =0;
        }
        
    }
    
    
    
    public int[] getHistogram(){
        return this.data;
    }

    public int getMean() {
        return mean;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public int getNpixels() {
        return npixels;
    }

    public int getMode() {
        return mode;
    }

    public int getMedian() {
        return median;
    }

    public double getStdDesv() {
        return stdDesv;
    }
    
    

    
    
    
    
    
}
