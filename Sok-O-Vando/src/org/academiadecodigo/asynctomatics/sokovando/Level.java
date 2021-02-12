package org.academiadecodigo.asynctomatics.sokovando;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Level {

    //Where the levels are created!


    //  # stands for wall
    //  $ represents the box to move
    //  . represent the 'goal' (where you have to move the box in order to win)
    //  @ represents the player
    //  \n starts a new row of thw world
    // a 'space' represents floor

    //First Level:

    //
    /*
        #######
        #.@ # #
        #$  $ #
        #   $ #
        # .   #
        #  .  #
        #######
     */

    private Grid grid;

    public Level(Grid grid) {
        this.grid =  grid;


        // Faz sentido isto estar aqui? Talvez pertença à Classe Grid...

        Grid g =  new Grid(50,500,500); // Porque é que eu fiz isto?

        // wall
        Rectangle wall = new Rectangle(10,10,100,100);
        wall.setColor(Color.BLACK);
        wall.fill();

        // player
        Ellipse player = new Ellipse(50,50,50,50);
        player.setColor(Color.RED);
        player.fill();

        //boxes
        Rectangle box = new Rectangle(50,50,50,50);
        box.setColor(Color.DARK_GRAY);
        box.fill();



    }




}
