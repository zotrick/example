/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;

import java.awt.Color;

/**
 *
 * @author Juan Eduardo
 */
public class HSLColor {
    private int hue = 1;
    private int saturation = 1;
    private int luminosity = 1;
    private int r,g,b;
    
    public HSLColor(int r, int g, int b){
        
        setRGB(r,g,b);
    }
    
    public void getRGB(){
        float c,x,m;
        float r,g,b;
        
        c = (float) ((1.0-Math.abs(2.0*(this.luminosity/100)))*(this.saturation/100));
        float aux2 = (float) Math.abs((((this.hue/60.0)/ 2.0)%2.0)-1.0);
        x = (float) (c* (1.0-aux2));
        m = (float) ((this.luminosity/100) -(c/2.0));
        
        if(this.hue>=0 && this.hue<60){
            r = c; g=x; b=0;
        }else if(this.hue>=60 && this.hue<120){
            r = x; g=c; b=0;
        }else if(this.hue>=120 && this.hue<180){
            r = 0; g=c; b=x;
        }else if(this.hue>=180 && this.hue<240){
            r = 0; g=x; b=c;
        }else if(this.hue>=240 && this.hue<300){
            r = x; g=0; b=c;
        }else{
            r = c; g=0; b=x;
        }
        m = Math.abs(m);
        this.r = (int) Math.abs((r+m)*255);
        this.g = (int) Math.abs((g+m)*255);
        this.b = (int) Math.abs((b+m)*255);
        
    }
    
    public void setRGB(int red, int green, int blue)
        {
            double r,g,b,h,s,l;
            double Cmax=0, Cmin=0;
            r=red/255.0;
            g=green/255.0;
            b=blue/255.0;
            Cmax = Math.max(Math.max(r, g), b);
            Cmin = Math.min(Math.min(r, g), b);
            double delta = Cmax-Cmin;
            l = (Cmax-Cmin)/2;
            if(Cmax == Cmin){
                h = 0;
                s = 0;
            }else{
                double aux =Math.abs((2.0*l)-1);
                s = delta/(1.0-aux);
                if(Cmax==r){
                    //h = (g-b)/delta;
                    //h = ((g-b)/delta) %6;
                    h = (g-b) /delta + (g<b ? 6:0);
                }else if(Cmax==g){
                    h = (b-r) / delta+2;
                }else{
                    h = (r-g) / delta+4;
                }
                
            }
            this.hue = (int) Math.round(h*60);
            this.saturation = (int) Math.round(s*100);
            this.luminosity = (int) Math.round(l*100);
        }
            
         
    
    

    public void setHue(int hue) {
        this.hue = hue;
    }

    public void setSaturation(int saturation) {
        this.saturation = saturation;
    }

    public void setLuminosity(int luminosity) {
        this.luminosity = luminosity;
    }

    
    public float getHue() {
        return hue;
    }

    public float getSaturation() {
        return saturation;
    }

    public float getLuminosity() {
        return luminosity;
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }
    
    
    
}
