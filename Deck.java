import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Deck extends Actor
{
    private List <Carta> deck;

    public Deck() {
        this.deck = new ArrayList<>();

        for (int i=0; i<3; i++){

            deck.add(new Capitao());

            deck.add(new Detetive());

            deck.add(new Madame());

            deck.add(new Psicopata());

            deck.add(new Ricaço());
        }

    }

   
    public List <Carta> getDeck(){
        return deck;
    }

    public void embaralhar(){
        Collections.shuffle(deck);
    }

    public String toString(){
        return "Nºde cartas:"+this.deck.size();
    }

    public Carta pegarCarta(){
        Carta carta=deck.get(0);
        deck.remove(0);
        return carta;
    }

    public void devolverCarta(Carta carta){

        deck.add(carta);
    }

    public Carta pegarcartaespecif(Carta carta){
        if(this.deck.remove(carta)){
            return carta;}
        return carta;
    }
}

