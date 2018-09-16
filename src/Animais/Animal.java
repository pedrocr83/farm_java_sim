/*
Powered by Pedro Gonçalves nº2344 - BioInformática 2ºAno
 */

/*CLASSE ABSTRATA PARA IDENTIFICAR OS ATRIBUTOS E COMPORTAMENTOS TRANSVERSAIS A TODOS OS ANIMAIS -- CLASSE MÃE*/

package Animais;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import static java.lang.Math.cos;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.Timer;

import framework.Handler;

public abstract class Animal implements ActionListener{
    
    BufferedImage tempimg, img1, img2, img3, img4, img5;
    double x,y/*posição X e Y em cada momento na quinta*/,vectorx, vectory, velocidade;
    int sesta/*o tempo que demora a dormir*/, energy/*a nergia que tem em cada momento*/
    , maxenergy/*a energia total que pode ter*/, drainenergy/*a energia que perde a correr*/
    , energywalking/*a energia que perde a andar*/;
    boolean alive;
    public Random rand;
    Timer t;
    
    public Animal (float x, float y){
        
        t = new Timer(500,this);
        rand = new Random();
        velocidade = 5;
        this.x = x;
        this.y = y;  
    }
    
    public abstract void tick(LinkedList<Animal> animallist);
    public abstract void render(Graphics g);

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getVelocidade() {
        return velocidade;
    }
    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }
    public Timer getTimer() {
        return t;
    }
    public void setTimer(Timer timer) {
        this.t = timer;
    }
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, tempimg.getWidth(), tempimg.getHeight());
    }
    //public void checkCollisions() /*Não está acabado*/{

    //   Rectangle r1 = this.getBounds();
    //   for (Animal animal: animallist){
    //   
    //            Rectangle r2 = animal.getBounds();
    //            if(r1.intersects(r2)){
    //                this.x += 10;
    //                this.y += 10;
    //                animal.x -= 10;
    //                animal.y -= 10;
    //                System.out.println("Colisão");
    //            }
    //        
    //    }
    //}
                            /*Acções dos animais*/
    /*
    Os métodos de Walking e Running funcionam com vetores de direção associados a uma velocidade especifica.
    Os vetores funcionam com acesso à função trigonométrica do coseno.
    Consoante a posição atual e a anterior no eixo do X a imagem muda para o lado esquerdo/direito
    O método da sesta muda consoante o animal. Uns dorme mais do que outros consoante o valor da variavel "sesta"
    */
    public int Walking(BufferedImage img1, BufferedImage img2, int energy, int energywalking){
    
        energy = energy - energywalking;
        vectorx = velocidade*cos((rand.nextDouble()-1)*Math.PI);
        vectory = velocidade*cos((rand.nextDouble()-1)*Math.PI);
        double tempx = x;

        
        if (tempx >= x && energy > 0){
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
            tempimg = img1;
        }
        
        if (tempx < x && energy > 0){
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
            tempimg = img2;
        }
        return this.energy = energy;
    }
    public void Running(int drainenergy){
        int prob = rand.nextInt(10);
        if (prob == 1){
            velocidade = 10;
            energy = energy - drainenergy;
        }
        else{
            velocidade = 5;
        }
    }
    public int Sleeping(BufferedImage img3, int energy, int maxenergy, int sesta){
    
        if (energy <= 0 && energy >= sesta ){
          
            vectorx = 0;
            vectory = 0; 
            x += vectorx;
            y += vectory;    
            tempimg = img3;
        }
            
        else if (energy < sesta){
            energy = maxenergy;
        }
        return this.energy = energy;
    }
 
}



