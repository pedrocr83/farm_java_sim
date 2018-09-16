/*
Powered by Pedro Gonçalves nº2344 - BioInformática 2ºAno
 */
/*CLASSE DO ANIMAL PASSARO -- VOA*/

package Animais;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.awt.image.BufferedImage;
import static java.lang.Math.*;

import framework.ImageLoader;


public class Passaro extends Animal{
    
    ImageLoader  loader = new ImageLoader();
    BufferedImage img2 = loader.loadImage("/Imagens/bird1.png");
    BufferedImage img1 = loader.loadImage("/Imagens/bird2.png");
    BufferedImage img3 = loader.loadImage("/Imagens/bird3.png");
    BufferedImage img4 = loader.loadImage("/Imagens/bird4.png");
    BufferedImage img5 = loader.loadImage("/Imagens/bird5.png");

    public Passaro (float x, float y) {
        super(x, y);
        alive = true;
        tempimg = img1;
        energy = 20;
        maxenergy = energy;
        drainenergy = 2;
        energywalking = 1;
        sesta = -8;
    }
    
    public void tick(LinkedList<Animal> animallist) {
    }
    
    public void render(Graphics g) {
        if (alive == true){
            //g.drawRect((int)x, (int)y, tempimg.getWidth(), tempimg.getHeight());
            g.drawImage(tempimg,(int)x,(int)y,null);
            t.start();
        }
        //else{
        //    animallist.remove(this);
        //    passarolist.remove(this);
        //}
    }
    
    public void actionPerformed(ActionEvent e){
        
        Walking(img1, img2, energy, energywalking);
        Running(drainenergy);
        birdFlying();
        Sleeping(img3,energy, maxenergy, sesta);
    }
    
    public void birdFlying(){
        
        int acaso = rand.nextInt(10);
        energy = energy - energywalking;
        vectorx = velocidade*cos((rand.nextDouble()-1)*Math.PI);
        vectory = velocidade*cos((rand.nextDouble()-1)*Math.PI);
        double tempx = x;
        if (acaso == 1 && tempx >= x && energy > 0 || acaso == 2 && tempx >= x && energy > 0){
            if (x < tempimg.getWidth() || x + tempimg.getWidth()> 1280){
                x += -vectorx;
                if(x > 1280-tempimg.getWidth()){
                    x = 1280-tempimg.getWidth();
                }
            }
            else{
                x += vectorx;
            }
            if (y < tempimg.getHeight() || y + tempimg.getHeight()> 650){
                y += -vectory;
                if(y > 650-tempimg.getHeight()){
                    y = 650-tempimg.getHeight();
                }
            }
            else{
                y += vectory;
            }
            tempimg = img5;
        }
        if (acaso == 1 && tempx < x && energy > 0 || acaso == 2 && tempx < x && energy > 0){
            if (x < tempimg.getWidth() || x + tempimg.getWidth()> 1280){
                x += -vectorx;
                if(x < tempimg.getWidth()){
                x = tempimg.getWidth();
                }
            }
            else{
                x += vectorx;
            }
            if (y < tempimg.getHeight() || y + tempimg.getHeight() > 650){
                y += -vectory;
                if(y < tempimg.getHeight()){
                    y = tempimg.getHeight();
                }
            }
            else{
                y += vectory;
            }
            tempimg = img4;
        }
    }

}
