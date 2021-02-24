package game;

import pixels.Pixel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Screen extends JFrame {
    private final int pixels = 64;
    private final Pixel[][] pixelContainer = new Pixel[64][64];
    private Pixel chosenPixel;
    Random rand = new Random();

public Screen(){
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(800, 800);
    this.setVisible(true);
}

    @Override
    public void paint(Graphics g){
        for(int row = 0; row < 64;row++){
            for(int col = 0; col < 64;col++){
            }
        }
    }
}


