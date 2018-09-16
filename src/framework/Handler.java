/*
Powered by Pedro Gonçalves nº2344 - BioInformática 2ºAno
 */

/*CLASSE UTILIZADA PARA A CRIAÇÃO E RENDERING DOS ANIMAIS NA FRAME DA QUINTA*/

package framework;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;

import Animais.*;

public class Handler {
    
    public LinkedList<Animal> animallist = new LinkedList <>();
    public ArrayList<Animal> caolist = new ArrayList <>();
    public ArrayList<Animal> gatolist = new ArrayList <>();
    public ArrayList<Animal> ratolist = new ArrayList <>();
    public ArrayList<Animal> passarolist = new ArrayList <>();

    private Animal objectotemp;
    
    public void tick(){
        for (int i=0; i<animallist.size(); i++){
        
            objectotemp = animallist.get(i);
            objectotemp.tick(animallist);
            //objectotemp.checkCollisions(); //Não está acabado
        }
    }
    
    public void render(Graphics g){
        for (int i=0; i<animallist.size(); i++){
        
            objectotemp = animallist.get(i);
            objectotemp.render(g);
        }
    }
    
    public void adicionarObjecto(Animal animal){
        this.animallist.add(animal);

        if ( animal instanceof Rato )
        {
            ratolist.add(animal);
        }
        else if ( animal instanceof Cao )
        {
            caolist.add(animal);
        }
        else if ( animal instanceof Gato )
        {
            gatolist.add(animal);
        } 
        else if ( animal instanceof Passaro )
        {
            passarolist.add(animal);
        } 
               
    }
    
    public void removerObjecto(Animal animal){
        this.animallist.remove(animal);  
    }
    
    public LinkedList<Animal> getAnimallist() {
        return animallist;
    }
    public ArrayList<Animal> getCaolist() {
        return caolist;
    }
    public ArrayList<Animal> getGatolist() {
        return gatolist;
    }
    public ArrayList<Animal> getRatolist() {
        return ratolist;
    }
    public ArrayList<Animal> getPassarolist() {
        return passarolist;
    }
    
    
}
