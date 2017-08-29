import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class BloquearRecurso here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BloquearRecurso extends butao
{
    imagembloqueado ib;

    public BloquearRecurso(){
        ib = new imagembloqueado(); 
    }

    /* private GreenfootSound som = new GreenfootSound("Efeito Sonoro do mouse - Sonoro.mp3");

    public void act(){
    som.play();
    }*/
    public int efeitobot(List <Player> mesadotabuleiro, Player playeraux, int aux, int auxataque, int auxturno){
        for(int i = 0; i < mesadotabuleiro.get(auxataque).getCartasdamao().size(); i++){
            if(mesadotabuleiro.get(auxataque).getCartasdamao().get(i).equals(new Ricaço()) && aux == 0){

                mesadotabuleiro.get(auxataque).getCartasdamao().get(i).getWorld().addObject(ib, 511, 126);
                Greenfoot.delay(200);
                mesadotabuleiro.get(auxataque).getCartasdamao().get(i).getWorld().removeObject(ib);

                new Ricaço().efeito(2,  mesadotabuleiro.get(auxturno), mesadotabuleiro.get(mesadotabuleiro.indexOf(playeraux)));
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
