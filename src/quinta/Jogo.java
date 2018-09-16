/*
Powered by Pedro Gonçalves nº2344 - BioInformática 2ºAno
 */

/*CLASSE UTILIZADA PARA INICIALIZAR E FAZER O RENDERING DO "JOGO" E TODOS OS SEUS COMPONENTES*/

package quinta;

import framework.Handler;
import framework.ImageLoader;
import java.awt.*;
import java.awt.image.*;
import java.util.*;

import Animais.*;

public class Jogo extends Canvas implements Runnable{
    
    private Sound sound;
    private boolean running = false;
    private Thread thread;
    Random rand = new Random();
    /**Objectos**/
    Handler handler;
    private BufferedImage backgrd = null;

    private void init(){
        
        /***adicionar itens de background ***/
        ImageLoader  loader = new ImageLoader();
        backgrd = loader.loadImage("/Imagens/back.png");
        Sound.backsound.play();
        
        /***adicionar animais à quinta -- UTILIZEI UMA FORMA DE ADICIONAR ALEATORIAMENTE OS ANIMAIS***/
        handler = new Handler();
        handler.adicionarObjecto(new Cao(rand.nextInt(1200),rand.nextInt(600), "Bobby"));
        handler.adicionarObjecto(new Gato(rand.nextInt(1200),rand.nextInt(600), "Tareco"));
        handler.adicionarObjecto(new Rato(rand.nextInt(1200),rand.nextInt(600))); 
        handler.adicionarObjecto(new Passaro(rand.nextInt(1200),rand.nextInt(600)));
        handler.adicionarObjecto(new Cao(rand.nextInt(1200),rand.nextInt(600), "Bobby"));
        handler.adicionarObjecto(new Gato(rand.nextInt(1200),rand.nextInt(600), "Tareco"));
        handler.adicionarObjecto(new Rato(rand.nextInt(1200),rand.nextInt(600))); 
        handler.adicionarObjecto(new Passaro(rand.nextInt(1200),rand.nextInt(600)));
        handler.adicionarObjecto(new Cao(rand.nextInt(1200),rand.nextInt(600), "Bobby"));
        handler.adicionarObjecto(new Gato(rand.nextInt(1200),rand.nextInt(600), "Tareco"));
        handler.adicionarObjecto(new Rato(rand.nextInt(1200),rand.nextInt(600))); 
        handler.adicionarObjecto(new Passaro(rand.nextInt(1200),rand.nextInt(600)));
        handler.adicionarObjecto(new Cao(rand.nextInt(1200),rand.nextInt(600), "Bobby"));
        handler.adicionarObjecto(new Gato(rand.nextInt(1200),rand.nextInt(600), "Tareco"));
        handler.adicionarObjecto(new Rato(rand.nextInt(1200),rand.nextInt(600))); 
        handler.adicionarObjecto(new Passaro(rand.nextInt(1200),rand.nextInt(600)));
        
        //System.out.println(handler.animallist.size());
        //System.out.println(handler.caolist.size());

    }
    
    public synchronized void start(){
    
        if(running){
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();

    }

    public void run(){
        
        init();
        
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
		tick();
		updates++;
		delta--;
            }
            render();
            frames++;
			
            if(System.currentTimeMillis() - timer > 1000){
                    timer += 1000;
                    System.out.println("FPS: " + frames + " TICKS: " + updates);
                    frames = 0;
                    updates = 0;
            }
        }
    }
    
    private void tick(){ 
        handler.tick();
    }
    
    private void render(){
        
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics(); 
        /******começa o codigo de graficos******/
        g.drawImage(backgrd, 0, 0, this.getWidth(), this.getHeight(), this);
        handler.render(g);
        /*******acaba o codigo de graficos*******/
        g.dispose();
        bs.show();
    }
    
    
    /*MAIN*/
    public static void main (String args[]){

    Quinta quintadopedro = new Quinta(1280,650, "Quinta do Pedro", new Jogo());
    

    }
    
}
