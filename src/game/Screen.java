package game;

import pixels.Pixel;


import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Screen extends JFrame {
    private final int pixels = 64;
    private final Pixel[][] pixelContainer = new Pixel[64][64];
    private Pixel chosenPixel;




public Screen(){
    displayPixel();
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(800, 800);
    this.setVisible(true);
}

    @Override
    public void paint(Graphics g){
        for(int row = 0; row < 64;row++){
            for(int col = 0; col < 64;col++){
                Pixel pixel = getScreenPixel(row,col);
                pixel.renderPixel(g);
            }
        }
    }
    private void pixelColorFiller(int randNumber,int row,int col){

        if(randNumber == 1){
            Pixel pixel = new Pixel(row,col,Color.GREEN);
            pixel.setColorID(1);
            this.pixelContainer[row][col] = pixel;
        } else if(randNumber == 2){
            Pixel pixel = new Pixel(row,col,Color.BLUE);
            pixel.setColorID(2);
            this.pixelContainer[row][col] = pixel;
        } else if(randNumber == 3){
            Pixel pixel = new Pixel(row,col,Color.RED);
            pixel.setColorID(3);
            this.pixelContainer[row][col] = pixel;
        }
    }
    private  Pixel getScreenPixel(int row,int col){

    return this.pixelContainer[row][col];

    }
    private void displayPixel(){
        for(int row = 0; row < 64;row++){
            for(int col = 0; col < 64;col++){
                int randNumber = ThreadLocalRandom.current().nextInt(1,4);
                pixelColorFiller(randNumber,row,col);
            }
        }
    }
}




