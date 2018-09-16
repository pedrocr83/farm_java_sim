/*
Powered by Pedro Gonçalves nº2344 - BioInformática 2ºAno
 */

/*CLASSE DO ANIMAL CÃO - TEM 2 CONTRUTORES E ACÇÕES DE LUTA E CAÇA*/

package Animais;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.awt.image.BufferedImage;

import framework.ImageLoader;

public class Cao extends Animal{

    String nome;
    ImageLoader  loader = new ImageLoader();
    BufferedImage img2 = loader.loadImage("/Imagens/dog1.png");
    BufferedImage img1 = loader.loadImage("/Imagens/dog2.png");
    BufferedImage img3 = loader.loadImage("/Imagens/dog3.png");

    public Cao(float x, float y, String nome) {
        
        super(x, y);
        this.nome = nome;
        tempimg = img1;
        energy = 1000;
        maxenergy = energy;
        drainenergy = 100;
        energywalking = 10;
        sesta = -30;
       
    }
    
    public Cao(float x, float y, String nome, int energy, int drainenergy, int energywalking, int sesta) {
        
        super(x, y);
        tempimg = img1;
        this.nome = nome; 
        this.energy = energy;
        maxenergy = energy;
        this.drainenergy = drainenergy;
        this.energywalking = energywalking;
        this.sesta = sesta;
    }
    
    public void tick(LinkedList<Animal> animallist) {
    }
    
    public void render(Graphics g) {
        g.drawImage(tempimg,(int)x,(int)y,null);
        g.drawString(nome, (int)x+5,(int)y);
        t.start();
        
    }
    
    public void actionPerformed(ActionEvent e){

        Walking(img1, img2, energy, energywalking);
        Running(drainenergy);
        Sleeping(img3,energy, maxenergy, sesta);

        
        

    }
    
    /*Dois métodos para serem usados no método checkCollisions*/
    public void luta(Animal gato){
        int prob = rand.nextInt(10);
        if (prob == 1 && gato instanceof Gato){
            this.energy = energy - 100;
            gato.energy = energy - 25;
        }
    }
    
    public void caoHunt(Animal rato){
        int prob = rand.nextInt(25);
        if (prob == 1 && rato instanceof Rato){
            this.energy = energy + rato.energy;
            rato.alive = false;
        }
    }
}
