import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class BotaoEspionar extends butao
{
    Imagemtrocado it;

    public BotaoEspionar(){
        it  = new Imagemtrocado();
    }

    /* private GreenfootSound som = new GreenfootSound("Efeito Sonoro do mouse - Sonoro.mp3");

    public void act(){
    som.play();
    }*/

    int efeitobot(List <Player> mesadotabuleiro, int  auxturno, int aux, Deck baralho, Player playeraux, Carta cartaaux ){
        for(int i = 0; i < mesadotabuleiro.get(auxturno).getCartasdamao().
        size(); i++){
            if(mesadotabuleiro.get(auxturno).getCartasdamao().get(i).equals(new Detetive())){

                if(mesadotabuleiro.contains(playeraux)){

                    mesadotabuleiro.get(auxturno).getCartasdamao().get(i).getWorld().addObject(it, 511, 126);
                    Greenfoot.delay(200);
                    mesadotabuleiro.get(auxturno).getCartasdamao().get(i).getWorld().removeObject(it);

                    new Detetive().efeito(baralho, mesadotabuleiro.get(mesadotabuleiro.indexOf(playeraux)), cartaaux);
                    return 1;
                }}}
        return 0;
    }

    public boolean mouseclicado(){
        if(Greenfoot.mouseClicked(this)){
            return true;}
        return false;
    }
}
