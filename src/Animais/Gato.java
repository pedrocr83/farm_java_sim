/*
Powered by Pedro Gonçalves nº2344 - BioInformática 2ºAno
 */

/*CLASSE DO ANIMAL GATO - TEM 2 CONTRUTORES E ACÇÃO DE CAÇA DE RATO E DE PASSAROS*/

package Animais;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.awt.image.BufferedImage;

import framework.ImageLoader;

public class Gato extends Animal{
    
    String nome;
    ImageLoader  loader = new ImageLoader();
    BufferedImage img2 = loader.loadImage("/Imagens/cat1.png");
    BufferedImage img1 = loader.loadImage("/Imagens/cat2.png");
    BufferedImage img3 = loader.loadImage("/Imagens/cat3.png");
    

    public Gato(float x, float y, String nome) {
        super(x, y);
        this.nome = nome;
        tempimg = img1;
        energy = 500;
        maxenergy = energy;
        drainenergy = 25;
        energywalking = 6;
        sesta = -20;
    }
    
    public Gato(float x, float y, String nome, int energy, int drainenergy, int energywalking, int sesta) {
        super(x, y);
        this.nome = nome;
        tempimg = img1;
        this.energy = energy;
        maxenergy = energy;
        this.drainenergy = drainenergy;
        this.energywalking = energywalking;
        this.sesta = sesta;
    }
    
    public void tick(LinkedList<Animal> animallist) {
    }
    
    public void render(Graphics g) {
        //g.drawRect((int)x, (int)y, tempimg.getWidth(), tempimg.getHeight());
        g.drawImage(tempimg,(int)x,(int)y,null);
        g.drawString(nome, (int)x,(int)y);
        
        t.start();
    }
    
    public void actionPerformed(ActionEvent e){
        
        Walking(img1, img2, energy, energywalking);
        Running(drainenergy);
        Sleeping(img3,energy, maxenergy, sesta);
       
    }
    
    /*Método para ser usado no método checkCollisions*/

    public void gatoHunt(Animal animal){
        if (animal instanceof Rato){
            int prob = rand.nextInt(5);
            if(prob == 1){
            this.energy = energy + animal.energy;
            animal.alive = false;
            }
        }
        if (animal instanceof Passaro){
            int prob = rand.nextInt(10);
            if(prob == 1){
            this.energy = energy + animal.energy;
            animal.alive = false;
            }
        }
    }
}
