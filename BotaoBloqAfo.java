import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class BotaoBloqAfo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BotaoBloqAfo extends butao
{
    imagembloqueado ib; 
    
    public BotaoBloqAfo(){
    ib = new imagembloqueado();
    }
    /* private GreenfootSound som = new GreenfootSound("Efeito Sonoro do mouse - Sonoro.mp3");

    public void act(){
    som.play();
    }*/
    public int efeitobot(Deck cemiterio, List <Player> mesadotabuleiro, int aux, Player playeraux, Carta cartaaux, int auxataque){
        for(int i = 0; i < mesadotabuleiro.get(auxataque).getCartasdamao().
        size(); i++){
            if(mesadotabuleiro.get(auxataque).getCartasdamao().get(i).equals(new Madame()) && aux == 0){

                mesadotabuleiro.get(auxataque).getCartasdamao().get(i).getWorld().addObject(ib, 511, 126);
                Greenfoot.delay(200);
                mesadotabuleiro.get(auxataque).getCartasdamao().get(i).getWorld().removeObject(ib);

                new Madame().efeito(cemiterio, mesadotabuleiro.get(mesadotabuleiro.indexOf(playeraux)), cartaaux);
                return 1;
            }}
        return 0;
    }

    public boolean mouseclicado(){
        if(Greenfoot.mouseClicked(this)){
            return true;}
        return false;
    }
}
