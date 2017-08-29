import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Botaoafogar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Botaoafogar extends butao
{
    imagemafogado imagemaf ;

    public Botaoafogar(){
        imagemaf = new imagemafogado() ;
    }

    /* private GreenfootSound som = new GreenfootSound("Efeito Sonoro do mouse - Sonoro.mp3");

    public void act(){
    som.play();
    }*/

    public int efeitobot(List <Player> mesadotabuleiro, Deck cemiterio, int  auxturno, int aux, Player playeraux, Carta cartaaux ){
        for(int i = 0; i < mesadotabuleiro.get(auxturno).getCartasdamao().size(); i++){
            if(mesadotabuleiro.get(auxturno).getCartasdamao().get(i).equals(new Psicopata()) && aux == 0){

                mesadotabuleiro.get(auxturno).getCartasdamao().get(i).getWorld().addObject(imagemaf, 511, 126);
                Greenfoot.delay(200);
                mesadotabuleiro.get(auxturno).getCartasdamao().get(i).getWorld().removeObject(imagemaf);

                new Psicopata().efeito(cemiterio, mesadotabuleiro.get(mesadotabuleiro.indexOf(playeraux)),  mesadotabuleiro.get(auxturno), cartaaux);
                return 0;
            }}
        return 6;
    }

    public boolean mouseclicado(){
        if(Greenfoot.mouseClicked(this)){
            return true;}
        return false;
    }

}
