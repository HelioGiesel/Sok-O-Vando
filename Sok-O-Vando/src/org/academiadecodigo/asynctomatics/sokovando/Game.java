package org.academiadecodigo.asynctomatics.sokovando;


import org.academiadecodigo.bootcamp.Sound;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import java.util.LinkedList;
import java.util.Timer;


public class Game {

    int currentLevelIndex = 1;
    int numberOfLevels = 5;
    Position[] currentLevel;
    Position[] level;
    Position[] level2;
    Position[] level3;
    Position[] level4;
    Position[] level5;
    KeyboardListener keyboard;
    Player player;
    Picture background;
    Picture startMenu;
    Picture level4Transition;
    Picture levelClear;
    Picture levelClear600;
    Picture win;
    boolean started = false;
    boolean restartedLevel = false;
    Sound menu = new Sound("/resources/startScreen.wav");
    Sound gameCoin =  new Sound("/resources/gamecoin.wav");
    Sound main = new Sound("/resources/main.wav");
    Sound laugh = new Sound ("/resources/evilLaugh.wav");
    Sound main2 = new Sound("/resources/level4_5.wav");


    public Game(){
        this.keyboard =  new KeyboardListener();
        keyboard.setup(this);
    }


    public void loadLevel1(){

        level = new Position[65];

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

    public void loadLevel2(){

        level2 = new Position[63];
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

    public void loadLevel3(){

        level3 = new Position[84];

        // Top walls

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
        level3[10] = new Wall (500, 0);

        // Right walls

        level3[11] = new Wall(500, 50);
        level3[12] = new Wall(500, 100);
        level3[13] = new Wall(500, 150);
        level3[14] = new Wall(500, 200);
        level3[15] = new Wall(500, 250);
        level3[16] = new Wall(500, 300);
        level3[17] = new Wall(500, 350);
        level3[18] = new Wall(500, 400);
        level3[19] = new Wall(500, 450);
        level3[20] = new Wall(500,500);

        // Left walls

        level3[21] = new Wall(0, 50);
        level3[22] = new Wall(0, 100);
        level3[23] = new Wall(0, 150);
        level3[24] = new Wall(0, 200);
        level3[25] = new Wall(0, 250);
        level3[26] = new Wall(0, 300);
        level3[27] = new Wall(0, 350);
        level3[28] = new Wall(0, 400);
        level3[29] = new Wall(0, 350);
        level3[30] = new Wall(0, 400);
        level3[31] = new Wall(0, 450);
        level3[32] = new Wall(0,500);


        // Right walls

        level3[33] = new Wall(50, 500);
        level3[34] = new Wall(100, 500);
        level3[35] = new Wall(150, 500);
        level3[36] = new Wall(200, 500);
        level3[37] = new Wall(200, 500);
        level3[38] = new Wall(250, 500);
        level3[39] = new Wall(300, 500);
        level3[40] = new Wall(350, 500);
        level3[41] = new Wall(400, 500);
        level3[42] = new Wall(450, 500);

        // Boxes
        level3[43] = new Box (300,150);
        level3[44] = new Box (250,100);
        level3[45] = new Box (200,100);
        level3[46] = new Box (300,250);


        // Spots
        level3[47] = new Spot (200,450);
        level3[48] = new Spot (250,450);
        level3[49] = new Spot (200,400);
        level3[50] = new Spot (150,250);




        // Inside walls
        level3[51] = new Wall(50, 200);
        level3[52] = new Wall(50, 250);
        level3[53] = new Wall(50, 300);
        level3[54] = new Wall(50, 350);
        level3[55] = new Wall(50, 400);
        level3[56] = new Wall(50, 450);
        level3[57] = new Wall(100, 250);
        level3[58] = new Wall(100, 300);
        level3[59] = new Wall(100, 350);
        level3[60] = new Wall(100, 400);
        level3[61] = new Wall(100, 450);
        level3[62] = new Wall(150, 300);
        level3[63] = new Wall(150, 350);
        level3[64] = new Wall(150, 400);
        level3[65] = new Wall(150, 450);
        level3[66] = new Wall(450, 200);
        level3[67] = new Wall(450, 250);
        level3[68] = new Wall(450, 300);
        level3[69] = new Wall(450, 350);
        level3[70] = new Wall(450, 400);
        level3[71] = new Wall(450, 450);
        level3[72] = new Wall(400, 250);
        level3[73] = new Wall(400, 300);
        level3[74] = new Wall(400, 350);
        level3[75] = new Wall(400, 400);
        level3[76] = new Wall(400, 450);
        level3[77] = new Wall(350, 300);
        level3[78] = new Wall(350, 350);
        level3[79] = new Wall(350, 400);
        level3[80] = new Wall(350, 450);
        level3[81] = new Wall(300, 100);
        level3[82] = new Wall(350, 100);
        level3[83] = new Wall(200, 150);


    }

    public void loadLevel4(){

        level4 = new Position[129];

        level4[0] = new Wall(0, 0);
        level4[1] = new Wall(50, 0);
        level4[2] = new Wall(100, 0);
        level4[3] = new Wall(150, 0);
        level4[4] = new Wall(200, 0);
        level4[5] = new Wall(250, 0);
        level4[6] = new Wall(300, 0);
        level4[7] = new Wall(350, 0);
        level4[8] = new Wall(400, 0);
        level4[9] = new Wall(450, 0);
        level4[10] = new Wall(500, 0);
        level4[11] = new Wall(550, 0);
        level4[12] = new Wall(600, 0);

        level4[13] = new Wall(600, 50);
        level4[14] = new Wall(600, 100);
        level4[15] = new Wall(600, 150);
        level4[16] = new Wall(600, 200);
        level4[17] = new Wall(600, 250);
        level4[18] = new Wall(600, 300);
        level4[19] = new Wall(600, 350);
        level4[20] = new Wall(600,400);
        level4[21] = new Wall(600, 450);
        level4[22] = new Wall(600, 500);
        level4[23] = new Wall(600, 550);
        level4[24] = new Wall(600, 600);

        level4[25] = new Wall(0, 50);
        level4[26] = new Wall(0, 100);
        level4[27] = new Wall(0, 150);
        level4[28] = new Wall(0, 200);
        level4[29] = new Wall(0, 250);
        level4[30] = new Wall(0, 300);
        level4[31] = new Wall(0, 350);
        level4[32] = new Wall(0, 400);
        level4[33] = new Wall(0, 450);
        level4[34] = new Wall(0, 500);
        level4[35] = new Wall(0, 550);
        level4[36] = new Wall(0, 600);

        level4[37] = new Wall(50, 600);
        level4[38] = new Wall(100, 600);
        level4[39] = new Wall(150, 600);
        level4[40] = new Wall(200, 600);
        level4[41] = new Wall(250, 600);
        level4[42] = new Wall(300, 600);
        level4[43] = new Wall(350,600);
        level4[44] = new Wall(400,600);
        level4[45] = new Wall(450,600);
        level4[46] = new Wall(500,600);
        level4[47] = new Wall(550,600);
        level4[48] = new Wall(0, 600);

        // Inside walls
        level4[49] = new Wall(50,  50);
        level4[50] = new Wall(50,  100);
        level4[51] = new Wall(50,  150);
        level4[52] = new Wall(50,  200);
        level4[53] = new Wall(50,  250);
        level4[54] = new Wall(50,  300);
        level4[55] = new Wall(50,  350);
        level4[56] = new Wall(50,  400);
        level4[57] = new Wall(50,  450);
        level4[58] = new Wall(50,  500);
        level4[59] = new Wall(50,  550);
        level4[60] = new Wall(100,  50);
        level4[61] = new Wall(150,  50);
        level4[62] = new Wall(200,  50);
        level4[63] = new Wall(250,  50);
        level4[64] = new Wall(300,  50);
        level4[65] = new Wall(500,  50);
        level4[66] = new Wall(100, 100);
        level4[67] = new Wall(150, 100);
        level4[68] = new Wall(200, 100);
        level4[69] = new Wall(250, 100);
        level4[70] = new Wall(300, 100);
        level4[71] = new Wall(500, 100);
        level4[72] = new Wall(550, 100);
        level4[73] = new Wall(100, 150);
        level4[74] = new Wall(150, 150);
        level4[75] = new Wall(400, 150);
        level4[76] = new Wall(500, 150);
        level4[77] = new Wall(550, 150);
        level4[78] = new Wall(100, 200);
        level4[79] = new Wall(150, 200);
        level4[80] = new Wall(100, 250);
        level4[81] = new Wall(150, 250);
        level4[82] = new Wall(250, 250);
        level4[83] = new Wall(350, 250);
        level4[84] = new Wall(400, 250);
        level4[85] = new Wall(100, 300);
        level4[86] = new Wall(150, 300);
        level4[87] = new Wall(250, 300);
        level4[88] = new Wall(400, 300);
        level4[89] = new Wall(250, 350);
        level4[90] = new Wall(300, 350);
        level4[91] = new Wall(400, 350);
        level4[92] = new Wall(550, 350);
        level4[93] = new Wall(400, 400);
        level4[94] = new Wall(550, 400);
        level4[95] = new Wall(100, 450);
        level4[96] = new Wall(200, 450);
        level4[97] = new Wall(250, 450);
        level4[98] = new Wall(300, 450);
        level4[99] = new Wall(400, 450);
        level4[100] = new Wall(450, 450);
        level4[101] = new Wall(550, 450);
        level4[102] = new Wall(100, 500);
        level4[103] = new Wall(550, 500);
        level4[104] = new Wall(100, 550);
        level4[105] = new Wall(150, 550);
        level4[106] = new Wall(200, 550);
        level4[107] = new Wall(250, 550);
        level4[108] = new Wall(300, 550);
        level4[109] = new Wall(450, 550);
        level4[110] = new Wall(500, 550);
        level4[111] = new Wall(550, 550);

        //  Boxes

        level4[112] = new Box(250, 200);
        level4[113] = new Box(400, 200);
        level4[114] = new Box(500, 200);
        level4[115] = new Box(500, 250);
        level4[116] = new Box(450, 300);
        level4[117] = new Box(150, 400);
        level4[118] = new Box(250, 400);
        level4[119] = new Box(500, 400);

        // Spots

        level4[120] = new Spot(300, 150);
        level4[121] = new Spot(300, 200);
        level4[122] = new Spot(300, 250);
        level4[123] = new Spot(300, 300);
        level4[124] = new Spot(350, 300);
        level4[125] = new Spot(350, 350);
        level4[126] = new Spot(350, 400);
        level4[127] = new Spot(350, 450);

        level4[128] = new Wall (550,50);

    }

    public void loadLevel5(){

        level5 = new Position[129];

        level5[0] = new Wall(0, 0);
        level5[1] = new Wall(50, 0);
        level5[2] = new Wall(100, 0);
        level5[3] = new Wall(150, 0);
        level5[4] = new Wall(200, 0);
        level5[5] = new Wall(250, 0);
        level5[6] = new Wall(300, 0);
        level5[7] = new Wall(350, 0);
        level5[8] = new Wall(400, 0);
        level5[9] = new Wall(450, 0);
        level5[10] = new Wall(500, 0);
        level5[11] = new Wall(550, 0);
        level5[12] = new Wall(600, 0);

        level5[13] = new Wall(600, 50);
        level5[14] = new Wall(600, 100);
        level5[15] = new Wall(600, 150);
        level5[16] = new Wall(600, 200);
        level5[17] = new Wall(600, 250);
        level5[18] = new Wall(600, 300);
        level5[19] = new Wall(600, 350);
        level5[20] = new Wall(600,400);
        level5[21] = new Wall(600, 450);
        level5[22] = new Wall(600, 500);
        level5[23] = new Wall(600, 550);
        level5[24] = new Wall(600, 600);

        level5[25] = new Wall(0, 50);
        level5[26] = new Wall(0, 100);
        level5[27] = new Wall(0, 150);
        level5[28] = new Wall(0, 200);
        level5[29] = new Wall(0, 250);
        level5[30] = new Wall(0, 300);
        level5[31] = new Wall(0, 350);
        level5[32] = new Wall(0, 400);
        level5[33] = new Wall(0, 450);
        level5[34] = new Wall(0, 500);
        level5[35] = new Wall(0, 550);
        level5[36] = new Wall(0, 600);

        level5[37] = new Wall(50, 600);
        level5[38] = new Wall(100, 600);
        level5[39] = new Wall(150, 600);
        level5[40] = new Wall(200, 600);
        level5[41] = new Wall(250, 600);
        level5[42] = new Wall(300, 600);
        level5[43] = new Wall(350,600);
        level5[44] = new Wall(400,600);
        level5[45] = new Wall(450,600);
        level5[46] = new Wall(500,600);
        level5[47] = new Wall(550,600);
        level5[48] = new Wall(600, 0);

        // Boxes
        level5[49] = new Box(100, 150);
        level5[50] = new Box(100, 250);
        level5[51] = new Box(100, 350);
        level5[52] = new Box(100, 450);
        level5[53] = new Box(150, 100);
        level5[54] = new Box(150, 200);
        level5[55] = new Box(150, 300);
        level5[56] = new Box(150, 400);
        level5[57] = new Box(150, 500);
        level5[58] = new Box(200, 150);
        level5[59] = new Box(200, 250);
        level5[60] = new Box(200, 350);
        level5[61] = new Box(200, 450);
        level5[62] = new Box(250, 100);
        level5[63] = new Box(250, 200);
        level5[64] = new Box(250, 300);
        level5[65] = new Box(250, 400);
        level5[66] = new Box(250, 500);
        level5[67] = new Box(300, 150);
        level5[68] = new Box(300, 250);
        level5[69] = new Box(300, 350);
        level5[70] = new Box(300, 450);
        level5[71] = new Box(350, 100);
        level5[72] = new Box(350, 200);
        level5[73] = new Box(350, 300);
        level5[74] = new Box(350, 400);
        level5[75] = new Box(350, 500);
        level5[76] = new Box(400, 150);
        level5[77] = new Box(400, 250);
        level5[78] = new Box(400, 350);
        level5[79] = new Box(400, 450);
        level5[80] = new Box(450, 100);
        level5[81] = new Box(450, 200);
        level5[82] = new Box(450, 300);
        level5[83] = new Box(450, 400);
        level5[84] = new Box(450, 500);
        level5[85] = new Box(500, 150);
        level5[86] = new Box(500, 250);
        level5[87] = new Box(500, 350);
        level5[88] = new Box(500, 450);

        // Spots

        level5[89] = new Spot(100, 100);
        level5[90] = new Spot(100, 200);
        level5[91] = new Spot(100, 300);
        level5[92] = new Spot(100, 400);
        level5[93] = new Spot(100, 500);
        level5[94] = new Spot(150, 150);
        level5[95] = new Spot(150, 250);
        level5[96] = new Spot(150, 350);
        level5[97] = new Spot(150, 450);
        level5[98] = new Spot(200, 100);
        level5[99] = new Spot(200, 200);
        level5[100] = new Spot(200, 300);
        level5[101] = new Spot(200, 400);
        level5[102] = new Spot(200, 500);
        level5[103] = new Spot(250, 150);
        level5[104] = new Spot(250, 250);
        level5[105] = new Spot(250, 350);
        level5[106] = new Spot(250, 450);
        level5[107] = new Spot(300, 100);
        level5[108] = new Spot(300, 200);
        level5[109] = new Spot(300, 400);
        level5[110] = new Spot(300, 500);
        level5[111] = new Spot(350, 150);
        level5[112] = new Spot(350, 250);
        level5[113] = new Spot(350, 350);
        level5[114] = new Spot(350, 450);
        level5[115] = new Spot(400, 100);
        level5[116] = new Spot(400, 200);
        level5[117] = new Spot(400, 300);
        level5[118] = new Spot(400, 400);
        level5[119] = new Spot(400, 500);
        level5[120] = new Spot(450, 150);
        level5[121] = new Spot(450, 250);
        level5[122] = new Spot(450, 350);
        level5[123] = new Spot(450, 450);
        level5[124] = new Spot(500, 100);
        level5[125] = new Spot(500, 200);
        level5[126] = new Spot(500, 300);
        level5[127] = new Spot(500, 400);
        level5[128] = new Spot(500, 500);

    }

    public void movePlayer(Directions directions){
        try {

            if (currentLevelIndex <= numberOfLevels) {
                switch (directions) {
                    case UP:
                        player.checkMove(Directions.UP, currentLevel);
                        break;

                    case DOWN:
                        player.checkMove(Directions.DOWN, currentLevel);
                        break;

                    case LEFT:
                        player.checkMove(Directions.LEFT, currentLevel);
                        break;

                    case RIGHT:
                        player.checkMove(Directions.RIGHT, currentLevel);
                        break;
                }
            }
        } catch (WinningException ex) {

            System.out.println("Won level " + currentLevelIndex);
            player.deleteShape();
            currentLevelIndex++;
            init();
        }
    }

    public void restartLevel(){

        for (Position element : currentLevel) element.deleteShape();
        player.deleteShape();
        setRestartedLevel(true);
        init();
    }

    public void setStarted(boolean started){
        this.started = started;
    }

    public void setRestartedLevel(boolean restarted) {
        this.restartedLevel = restarted;
    }

    public void initMenu() throws InterruptedException {

        menu.play(true);

        while(!started) {
            startMenu = new Picture(0, 0, "resources/startMenu.png");
            startMenu.draw();
        }
        deleteStartMenu();
        menu.stop();
        gameCoin.play(true);
        init();
        main.play(true);
    }

    public void deleteStartMenu() {
        startMenu.delete();
    }

    public void init(){

        switch (currentLevelIndex) {
            case 1:
                background = new Picture (0,0, "resources/background500.png");
                background.draw();
                loadLevel1();
                player = new Player(150,150);
                player.playerShape.draw();
                currentLevel = level;
                break;

            case 2:
                player = null;
                levelClear = new Picture(0, 0, "resources/levelClear550.png");
                levelClear.draw();
                Timer t1 = new java.util.Timer();
                t1.schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                levelClear.delete();
                                background = new Picture(0, 0, "resources/background500.png");
                                background.draw();
                                loadLevel2();
                                player = new Player(250, 250);
                                player.playerShape.draw();
                                currentLevel = level2;
                                t1.cancel();
                                }
                            },
                            3000
                    );

                break;

            case 3:
                player = null;
                levelClear = new Picture (0, 0, "resources/levelClear550.png");
                levelClear.draw();
                Timer t2 = new java.util.Timer();
                t2.schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                levelClear.delete();
                                background = new Picture(0, 0, "resources/background500.png");
                                background.draw();
                                loadLevel3();
                                player = new Player(300, 50);
                                player.playerShape.draw();
                                currentLevel = level3;
                                t2.cancel();
                            }
                        },
                            3000
                );
                break;

            case 4:
                player = null;
                main.stop();
                main2.stop();
                laugh.play(true);
                level4Transition = new Picture(0,0, "resources/level4Transition.png");
                level4Transition.draw();
                Timer t3 = new java.util.Timer();
                t3.schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                level4Transition.delete();
                                main2.play(true);
                                background = new Picture (0,0, "resources/background600.png");
                                background.draw();
                                loadLevel4();
                                player = new Player(200, 300);
                                player.playerShape.draw();
                                currentLevel = level4;
                                t3.cancel();
                            }
                        },
                        5000
                );
                break;

            case 5:
                player = null;
                levelClear600 = new Picture (0,0, "resources/levelClear600.png");
                levelClear600.draw();
                Timer t4 = new java.util.Timer();
                t4.schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                levelClear600.delete();
                                background = new Picture(0, 0, "resources/background600.png");
                                background.draw();
                                loadLevel5();
                                player = new Player(300, 300);
                                player.playerShape.draw();
                                currentLevel = level5;
                                t4.cancel();
                            }
                        },
                            3000
                );
                break;
        }

        if (currentLevelIndex > numberOfLevels) {
            System.out.println("You are a beast!! You deserve a clap from Leandro and one 'Até já' from you know who");
            win = new Picture(0,0, "/resources/youwin.png");
            player.playerShape.delete();
            win.draw();
        }
    }
}


