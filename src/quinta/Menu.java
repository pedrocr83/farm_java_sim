/*
Powered by Pedro Gonçalves nº2344 - BioInformática 2ºAno
 */

package quinta;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;

import framework.Handler;

public class Menu extends JFrame implements ActionListener{
    
    Handler handle;
    Random rand;
    private final JMenuBar bar;
    private final JMenu menu1;
    private final JMenu menu2;
    private final JButton Cao;
    private final JButton Gato;
    private final JButton Rato;
    private final JButton Passaro;
    private final JButton Som;
    private final JButton Exit;
    private final ButtonGroup grupo1;
    private final ButtonGroup grupo2;
    
    public Menu(){
        
        bar = new JMenuBar();
        menu1 = new JMenu("Adicionar Animais");
        menu2 = new JMenu("Outras");
        Cao = new JButton("Cão");
        Gato = new JButton("Gato");
        Rato = new JButton("Rato");
        Passaro = new JButton("Pássaro");
        Som = new JButton ("Som");
        Exit = new JButton("Fechar");
        setSize(400,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Menu");
        setLocationRelativeTo(null);
        grupo1 = new ButtonGroup();
        grupo2 = new ButtonGroup();
        bar.add(menu1);
        bar.add(menu2);
        menu1.add(Cao);
        menu1.add(Gato);
        menu1.add(Rato);
        menu1.add(Passaro);
        menu2.add(Som);
        menu2.add(Exit);
        grupo1.add(Cao);
        grupo1.add(Gato);
        grupo1.add(Rato);
        grupo1.add(Passaro);
        grupo2.add(Exit);
        Cao.addActionListener(this);
        Gato.addActionListener(this);
        Rato.addActionListener(this);
        Passaro.addActionListener(this);
        Som.addActionListener(this);
        Exit.addActionListener(this);
        add(bar);
        
    }
    
    public void actionPerformed(ActionEvent e){
        
        if (e.getSource() == Gato){
            
        }
    
    }
}
