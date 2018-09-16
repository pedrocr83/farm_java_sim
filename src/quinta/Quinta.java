/*
Powered by Pedro Gonçalves nº2344 - BioInformática 2ºAno
 */

/*CLASSE DA QUINTA -- ONDE INICIALIZEI A MINHA FRAME*/
package quinta;

import java.awt.*;
import javax.swing.*;

public class Quinta{
    
    int quintawidth,quintaheight;
    
    public Quinta (int a, int b, String d, Jogo jogo){
        
        quintawidth = a;
        quintaheight = b;
        jogo.setPreferredSize(new Dimension(a,b));
        jogo.setMaximumSize(new Dimension(a,b));
        jogo.setMinimumSize(new Dimension(a,b));
        JFrame frame = new JFrame (d);

        frame.add(jogo);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); 
        
        jogo.start();
    
    }
    
    

    public int getQuintawidth() {
        return quintawidth;
    }
    public int getQuintaheight() {
        return quintaheight;
    }
    
    
}
