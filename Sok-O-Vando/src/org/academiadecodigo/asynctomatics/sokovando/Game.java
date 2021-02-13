package org.academiadecodigo.asynctomatics.sokovando;

import java.util.LinkedList;

public class Game {

    Position[] level;
    Position[] level2;
    Position[] level3;
    KeyboardListener keyboard = new KeyboardListener();
    Player player;


    public Game(){


        /*KeyboardListener keyboard = new KeyboardListener();
        Player player = new Player(150,150);

        keyboard.setup(player, level2);*/

    }


    public void init(){
        initLevel1();
        drawLevel(level);

            if(CollisionDetector.checkSpots(level)){
                deleteLevel(level);
                deletePlayer();
                initLevel2();
                drawLevel(level2);
            }


        /*if(CollisionDetector.checkSpots(level)){
            for (Position position : level) {
                position
            }

            initLevel2();

        }*/



       /* for (Position position : level2) {
            position.drawIcon();
        }

        if(CollisionDetector.checkSpots(level2)){
            level2 = new Position[0];
        }

        loadLevel3();

        for (Position position : level3) {
            position.drawIcon();
        }

        if(CollisionDetector.checkSpots(level3)){
           level3 = new Position[0];
        }*/
    }


    public void initLevel1(){

        level = new Position[65];
        player = new Player(150,150);
        keyboard.setup(player, level);

        level[0] = new Wall(0, 0);
        level[1] = new Wall(50, 0);
        level[2] = new Wall(100, 0);
        level[3] = new Wall(150, 0);
        level[4] = new Wall(200, 0);
        level[5] = new Wall(250, 0);
        level[6] = new Wall(300, 0);
        level[7] = new Wall(350, 0);
        level[8] = new Wall(400, 0);
        level[9] = new Wall(450, 0);

        level[10] = new Wall(450, 50);
        level[11] = new Wall(450, 100);
        level[12] = new Wall(450, 150);
        level[13] = new Wall(450, 200);
        level[14] = new Wall(450, 250);
        level[15] = new Wall(450, 300);
        level[16] = new Wall(450, 350);
        level[17] = new Wall(450, 400);
        level[18] = new Wall(450, 450);

        level[19] = new Wall(0, 50);
        level[20] = new Wall(0, 100);
        level[21] = new Wall(0, 150);
        level[22] = new Wall(0, 200);
        level[23] = new Wall(0, 250);
        level[24] = new Wall(0, 300);
        level[25] = new Wall(0, 350);
        level[26] = new Wall(0, 400);
        level[27] = new Wall(0, 350);
        level[28] = new Wall(0, 400);
        level[29] = new Wall(0, 450);

        level[30] = new Wall(50, 450);
        level[31] = new Wall(100, 450);
        level[32] = new Wall(150, 450);
        level[33] = new Wall(200, 450);
        level[34] = new Wall(200, 450);
        level[35] = new Wall(250, 450);
        level[36] = new Wall(300, 450);
        level[37] = new Wall(350, 450);
        level[38] = new Wall(400, 450);
        level[39] = new Wall(450, 450);
        // End of Outside Walls

        // Boxes
        level[40] = new Box (400,100);
        level[41] = new Box (150,100);
        level[42] = new Box (300,300);

        // Spots
        level[43] = new Spot (400,350);
        level[44] = new Spot (350,400);
        level[45] = new Spot (400,400);

        // Inside walls
        level[46] = new Wall(200, 50);
        level[47] = new Wall(200, 100);
        level[48] = new Wall(200, 150);
        level[49] = new Wall(200, 200);
        level[50] = new Wall(200, 250);
        level[51] = new Wall(200, 350);

        level[52] = new Wall(50, 200);
        level[53] = new Wall(100, 200);
        level[54] = new Wall(250, 350);
        level[55] = new Wall(300, 350);

        level[56] = new Wall(300, 100);
        level[57] = new Wall(300, 150);
        level[58] = new Wall(300, 200);
        level[59] = new Wall(300, 250);
        level[60] = new Wall(350, 250);
        level[61] = new Wall(350, 100);

        level[62] = new Wall(100, 100);
        level[63] = new Wall(100, 300);
        level[64] = new Wall(100, 350);
    }

    public void initLevel2(){

        level2 = new Position[63];
        player = new Player(250,250);
        keyboard.setup(player, level2);

        // Top walls
        level2[0] = new Wall(0, 0);
        level2[1] = new Wall(50, 0);
        level2[2] = new Wall(100, 0);
        level2[3] = new Wall(150, 0);
        level2[4] = new Wall(200, 0);
        level2[5] = new Wall(250, 0);
        level2[6] = new Wall(300, 0);
        level2[7] = new Wall(350, 0);
        level2[8] = new Wall(400, 0);
        level2[9] = new Wall(450, 0);
        level2[10] = new Wall (500, 0);

        // Right walls
        level2[11] = new Wall(500, 50);
        level2[12] = new Wall(500, 100);
        level2[13] = new Wall(500, 150);
        level2[14] = new Wall(500, 200);
        level2[15] = new Wall(500, 250);
        level2[16] = new Wall(500, 300);
        level2[17] = new Wall(500, 350);
        level2[18] = new Wall(500, 400);
        level2[19] = new Wall(500, 450);
        level2[20] = new Wall(500,500);

        // Left walls
        level2[21] = new Wall(0, 50);
        level2[22] = new Wall(0, 100);
        level2[23] = new Wall(0, 150);
        level2[24] = new Wall(0, 200);
        level2[25] = new Wall(0, 250);
        level2[26] = new Wall(0, 300);
        level2[27] = new Wall(0, 350);
        level2[28] = new Wall(0, 400);
        level2[29] = new Wall(0, 350);
        level2[30] = new Wall(0, 400);
        level2[31] = new Wall(0, 450);
        level2[32] = new Wall(0,500);

        // Bottom walls
        level2[33] = new Wall(50, 500);
        level2[34] = new Wall(100, 500);
        level2[35] = new Wall(150, 500);
        level2[36] = new Wall(200, 500);
        level2[37] = new Wall(200, 500);
        level2[38] = new Wall(250, 500);
        level2[39] = new Wall(300, 500);
        level2[40] = new Wall(350, 500);
        level2[41] = new Wall(400, 500);
        level2[42] = new Wall(450, 500);

        // Boxes
        level2[43] = new Box (200,200);
        level2[44] = new Box (250,200);
        level2[45] = new Box (300,200);
        level2[46] = new Box (200,250);
        level2[47] = new Box (300,250);
        level2[48] = new Box (200,300);
        level2[49] = new Box (250,300);
        level2[50] = new Box (300,300);

        // Spots
        level2[51] = new Spot (50,50);
        level2[52] = new Spot (450,50);
        level2[53] = new Spot (450,450);
        level2[54] = new Spot (50,450);
        level2[55] = new Spot (150,200);
        level2[56] = new Spot (350,200);
        level2[57] = new Spot(150, 300);
        level2[58] = new Spot(350, 300);

        // Inside walls
        level2[59] = new Wall(150, 150);
        level2[60] = new Wall(350, 150);
        level2[61] = new Wall(350, 350);
        level2[62] = new Wall(150, 350);

    }


    public void initLevel3(){

        level3 = new Position[100];
        player = new Player(300,50);
        keyboard.setup(player, level3);

        level3[0] = new Wall(0, 0);
        level3[1] = new Wall(50, 0);
        level3[2] = new Wall(100, 0);
        level3[3] = new Wall(150, 0);
        level3[4] = new Wall(200, 0);
        level3[5] = new Wall(250, 0);
        level3[6] = new Wall(300, 0);
        level3[7] = new Wall(350, 0);
        level3[8] = new Wall(400, 0);
        level3[9] = new Wall(450, 0);
        level3[58] = new Wall (500, 0);

        level3[10] = new Wall(500, 50);
        level3[11] = new Wall(500, 100);
        level3[12] = new Wall(500, 150);
        level3[13] = new Wall(500, 200);
        level3[14] = new Wall(500, 250);
        level3[15] = new Wall(500, 300);
        level3[16] = new Wall(500, 350);
        level3[17] = new Wall(500, 400);
        level3[18] = new Wall(500, 450);
        level3[59] = new Wall(500,500);

        level3[19] = new Wall(0, 50);
        level3[20] = new Wall(0, 100);
        level3[21] = new Wall(0, 150);
        level3[22] = new Wall(0, 200);
        level3[23] = new Wall(0, 250);
        level3[24] = new Wall(0, 300);
        level3[25] = new Wall(0, 350);
        level3[26] = new Wall(0, 400);
        level3[27] = new Wall(0, 350);
        level3[28] = new Wall(0, 400);
        level3[29] = new Wall(0, 450);
        level3[60] = new Wall(0,500);

        level3[30] = new Wall(50, 500);
        level3[31] = new Wall(100, 500);
        level3[32] = new Wall(150, 500);
        level3[33] = new Wall(200, 500);
        level3[34] = new Wall(200, 500);
        level3[35] = new Wall(250, 500);
        level3[36] = new Wall(300, 500);
        level3[37] = new Wall(350, 500);
        level3[38] = new Wall(400, 500);
        level3[39] = new Wall(450, 500);



        // Boxes
        level3[40] = new Box (300,150);
        level3[41] = new Box (250,100);
        level3[42] = new Box (200,100);
        level3[53] = new Box (300,250);


        // Spots
        level3[43] = new Spot (200,450);
        level3[44] = new Spot (250,450);
        level3[45] = new Spot (200,400);
        level3[46] = new Spot (150,250);



        // Inside walls
        level3[50] = new Wall(50, 200);
        level3[51] = new Wall(50, 250);
        level3[52] = new Wall(50, 300);
        level3[63] = new Wall(50, 350);
        level3[64] = new Wall(50, 400);
        level3[65] = new Wall(50, 450);
        level3[66] = new Wall(100, 250);
        level3[67] = new Wall(100, 300);
        level3[49] = new Wall(100, 350);
        level3[68] = new Wall(100, 400);
        level3[69] = new Wall(100, 450);
        level3[70] = new Wall(150, 300);
        level3[71] = new Wall(150, 350);
        level3[72] = new Wall(150, 400);
        level3[73] = new Wall(150, 450);
        level3[74] = new Wall(450, 200);
        level3[75] = new Wall(450, 250);
        level3[76] = new Wall(450, 300);
        level3[77] = new Wall(450, 350);
        level3[78] = new Wall(450, 400);
        level3[79] = new Wall(450, 450);
        level3[80] = new Wall(400, 250);
        level3[81] = new Wall(400, 300);
        level3[82] = new Wall(400, 350);
        level3[83] = new Wall(400, 400);
        level3[84] = new Wall(400, 450);
        level3[85] = new Wall(350, 300);
        level3[86] = new Wall(350, 350);
        level3[87] = new Wall(350, 400);
        level3[88] = new Wall(350, 450);
        level3[89] = new Wall(300, 100);
        level3[90] = new Wall(350, 100);
        level3[91] = new Wall(200, 150);


    }

    public Position[] loadLevel(){
        return level;
    }

    public void drawLevel(Position[] level){
        for (Position position : level) {
            position.drawIcon();
        }
    }

    public void deleteLevel(Position[] level) {
        for (Position position : level) {
            position.deleteIcon();
        }
    }

    public void deletePlayer(){
        player.deleteIcon();
    }

    /*public static boolean checkSpots(Position[] level) {

        //run through array, collect spots and boxes, check if they are on same position

        LinkedList<Position> spotList = new LinkedList<>();
        LinkedList<Position> boxList = new LinkedList<>();

        for (Position element : level){

            if (element instanceof Box) boxList.add(element);
            if (element instanceof Spot) spotList.add(element);

        }

        int validation = 0;

        for (Position box : boxList) {
            for (Position spot : spotList) {
                if ((box.getY() == spot.getY()) && (box.getX() == spot.getX())) validation++;
            }
        }

        if ((validation == spotList.size()) && (validation != 0)){
            System.out.println("Ganhou modafoca!!!!!");
            return true;

        }

        return false;
    }
*/
}
