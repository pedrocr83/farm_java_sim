/*
Powered by Pedro Gonçalves nº2344 - BioInformática 2ºAno
 */
/*CLASSE DE IMAGENS ONDE INICIALIZO O PROCESSO DE UPLOAD DE IMAGENS*/

package framework;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;


public class ImageLoader{
    
    private BufferedImage image;
    public BufferedImage loadImage(String path){
    
        try {
            image = ImageIO.read(getClass().getResource(path));
        } catch (IOException ex){
            System.out.println("A imagem " + path + " não existe");
        }
        return image;
    
    }
}
