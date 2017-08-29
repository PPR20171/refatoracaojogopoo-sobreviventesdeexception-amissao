import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class mododejogar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class mododejogar extends Menu
{
    private int escolha2 = 0;
    private GreenfootImage cenariomj;
    public mododejogar()
    {

    }

    public void act(){

        MouseInfo mouse = Greenfoot.getMouseInfo();

        if (Greenfoot.mouseClicked(null)) {
            int x = mouse.getX();
            int y = mouse.getY();
            if (Greenfoot.mouseClicked(null)) {
                if (x > 280 && x < 486) {
                    if (y > 737 && y < 825) {
                        Menu menu = new Menu();
                        menu.backg(escolha2);
                        Greenfoot.setWorld(menu);
                        Greenfoot.delay(30);

                    }}

            }}
    }

    public void backg(int teste){
        escolha2 = teste;
        if(escolha2 == 1){
            cenariomj = new GreenfootImage("Modo-de-jogar.png");
        }
        if(escolha2 == 2){
            cenariomj = new GreenfootImage("Modo-de-jogar-Eng.png");
        }
        setBackground(cenariomj);
    }
}

