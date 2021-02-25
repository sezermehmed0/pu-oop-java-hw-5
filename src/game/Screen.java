package game;

import SerialNumber.SerialNumber;
import pixels.Pixel;
import Modal.Modal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author Sezer Mehmed
 *
 */

public class Screen extends JFrame implements MouseListener {

    private final int pixels = 64;
    private final Pixel[][] pixelContainer = new Pixel[64][64];
    private int burnedPixelsCounter;
    private int totalClicked;
    SerialNumber serialNumber = new SerialNumber();

    /**
     * Constructor
     */
    public Screen() {

        this.serialNumber.renderSerialNumber();
        displayPixel();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 800);
        this.setVisible(true);
        this.setTitle("Serial Number : " + this.serialNumber.renderSerialNumber());
        this.addMouseListener(this);

    }

    /**
     * This method paints the screen
     * @param g Object of Graphics
     */
    @Override
    public void paint(Graphics g) {
        for (int row = 0; row < pixels; row++) {
            for (int col = 0; col < pixels; col++) {
                Pixel pixel = getScreenPixel(row, col);
                pixel.renderPixel(g);
            }
        }
    }

    /**
     * This method allows to click on the screen
     * @param e Object of MouseImplementation
     */
    @Override
    public void mouseClicked(MouseEvent e) {
         int row = getPixelCoordinate(e.getY());
         int col = getPixelCoordinate(e.getX());
        System.out.println("PixelCoordinateY : " + getY() +" " + "PixelCoordinateX : " + getX());
        if (row <= 64 && col <= 64) {
            totalClicked++;
            System.out.println("Total clicked: " + totalClicked);
            Pixel chosenPixel = this.getScreenPixel(row, col);
            if (chosenPixel.getColorID() == 1) {
                if (e.getClickCount() == 3) {
                    this.pixelContainer[row][col].setColor(Color.BLACK);
                    burnedPixelsCounter++;
                }
            } else if (chosenPixel.getColorID() == 3) {
                this.pixelContainer[row][col].setColor(Color.BLACK);
                burnedPixelsCounter++;
            }
            this.repaint();

        }  else {
        Modal.render(this,"STOP!","Out of pixel range,try again");
    }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * This method fills the pixel colors
     * @param randNumber this parameter is used like container  for random number
     * @param row
     * @param col
     */
    private void pixelColorFiller(int randNumber, int row, int col) {

        if (randNumber == 2) {
            Pixel pixel = new Pixel(row, col, Color.GREEN);
            pixel.setColorID(2);
            this.pixelContainer[row][col] = pixel;
        } else if (randNumber == 1) {
            Pixel pixel = new Pixel(row, col, Color.BLUE);
            pixel.setColorID(1);
            this.pixelContainer[row][col] = pixel;
        } else if (randNumber == 3) {
            Pixel pixel = new Pixel(row, col, Color.RED);
            pixel.setColorID(3);
            this.pixelContainer[row][col] = pixel;
        }
    }

    /**
     *
     * @param row
     * @param col
     * @return returned screen pixel
     */
    private Pixel getScreenPixel(int row, int col) {

        return this.pixelContainer[row][col];

    }

    /**
     * This method is used to display pixels
     */
    private void displayPixel() {
        for (int row = 0; row < pixels; row++) {
            for (int col = 0; col < pixels; col++) {
                int randNumber = ThreadLocalRandom.current().nextInt(1, 4);
                pixelColorFiller(randNumber, row, col);
            }
        }
    }
/**
 * This method is used to get pixel coordinates
 */
    private int getPixelCoordinate(int coordinate) {
        return coordinate / 10;
    }

}


