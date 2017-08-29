import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Botaochantagem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Botaochantagem extends butao
{
    Imagemdoroubo roubo;
    
    public Botaochantagem(){
     roubo = new Imagemdoroubo();
    }
    /*private GreenfootSound som = new GreenfootSound("Efeito Sonoro do mouse - Sonoro.mp3");

    public void act(){
    som.play();
    }*/

    int efeitobot(List <Player> mesadotabuleiro, int  auxturno, int aux, Player playeraux){

        for(int i = 0; i < mesadotabuleiro.get(auxturno).getCartasdamao().size(); i++){
            if(mesadotabuleiro.get(auxturno).getCartasdamao().get(i).equals(new Capitao()) && aux == 0){


                //mesadotabuleiro.get(auxturno).getCartasdamao().get(i).imagemdopoder();
                mesadotabuleiro.get(auxturno).getCartasdamao().get(i).getWorld().addObject(roubo, 640, 126);
                Greenfoot.delay(200);
                mesadotabuleiro.get(auxturno).getCartasdamao().get(i).getWorld().removeObject(roubo);

               
                new Capitao().efeito(mesadotabuleiro.get(mesadotabuleiro.indexOf(playeraux)), mesadotabuleiro.get(auxturno));

                return 0;

            }
        }
        return 6;
    }

    public boolean mouseclicado(){
        if(Greenfoot.mouseClicked(this)){
            return true;}
        return false;
    }
}
