import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BotãoNdef here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BotãoNdef extends butao
{  
    /*private GreenfootSound som = new GreenfootSound("Efeito Sonoro do mouse - Sonoro.mp3");

    public void act(){
        som.play();
    }*/

    public boolean mouseclicado(){
        if(Greenfoot.mouseClicked(this)){
            return true;}
        return false;
    }
}
