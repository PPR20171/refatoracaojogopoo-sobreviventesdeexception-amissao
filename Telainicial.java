import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Telainicial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Telainicial extends World
{

    int pt = 1, eng = 2;
    public Telainicial()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1015, 692, 1); 
        Greenfoot.start();  
    }

    public void act(){
        showText("Tecle esc para Pt-br ou enter para Ingês\n\nType esc for Pt-br or enter for English", 500,480);
        if (Greenfoot.isKeyDown("enter")) {
            Menu menu = new Menu();
            menu.backg(pt);
            Greenfoot.setWorld(menu);
            Greenfoot.delay(30);      
        }
        if (Greenfoot.isKeyDown("escape")) {
            Menu menu = new Menu();
            menu.backg(eng);
            Greenfoot.setWorld(menu);
            Greenfoot.delay(30);      
        }

    }
}
