/*
Powered by Pedro Gonçalves nº2344 - BioInformática 2ºAno
 */

/*CLASSE DE SOM ONDE INICIALIZO O PROCESSO DE UPLOAD DE SONS*/
package quinta;

import java.applet.Applet;
import java.applet.AudioClip;

public class Sound {
    
    public static final Sound backsound = new Sound("../Som/backgroundnoise.wav");
    private AudioClip clip;
    
    public Sound(String filename){
        try{
            clip = Applet.newAudioClip(Sound.class.getResource(filename));
        }catch(Exception ex){
            System.out.println("O som " + filename + " não existe");
        }
    }
    
    public void play(){
        try{
            new Thread(){
                public void run(){
                    clip.play();
                }
            }.start();
        }catch(Exception ex){}
        
    }
}
