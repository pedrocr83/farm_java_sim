/*
Powered by Pedro Gonçalves nº2344 - BioInformática 2ºAno
 */

/*CLASSE DO ANIMAL RATO -- NÃO TEM NENHUMA ACÇÃO ESPECIAL*/

package Animais;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.awt.image.BufferedImage;

import framework.ImageLoader;


public class Rato extends Animal{
    
    ImageLoader  loader = new ImageLoader();
    BufferedImage img1 = loader.loadImage("/Imagens/rato1.png");
    BufferedImage img2 = loader.loadImage("/Imagens/rato2.png");
    BufferedImage img3 = loader.loadImage("/Imagens/rato3.png");
    

    public Rato (float x, float y) {
        
        super(x, y);
        alive = true;
        tempimg = img1;
        energy = 50;
        maxenergy = energy;
        drainenergy = 5;
        energywalking = 3;
        sesta = -10;
    }
    
    public void tick(LinkedList<Animal> animallist) {
    }
    
    public void render(Graphics g) {
        
        if (alive == true){
            g.drawImage(tempimg,(int)x,(int)y,null);
            t.start();
        }
        //else{
        //    animallist.remove(this);
        //    ratolist.remove(this);
        //}
    }
    
    public void actionPerformed(ActionEvent e){
        
        Walking(img1, img2, energy, energywalking);
        Running(drainenergy);
        Sleeping(img3,energy, maxenergy,sesta);
        
    }
    
    

}
