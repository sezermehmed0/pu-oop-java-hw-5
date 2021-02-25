package pixels;

import java.awt.*;

public class Pixel {

      private int row;
      private int col;
      private Color color;
      private int pixelSize;
      int colorID;


    public Pixel(int row , int col, Color color) {
        this.row = row;
        this.col = col;
        this.color = color;
        this.pixelSize = 12;
    }
    public void renderPixel(Graphics g){
        int tileX = this.col * this.pixelSize;
        int tileY = this.row * this.pixelSize;

        g.setColor(this.color);
        g.fillRect(tileX,tileY,this.pixelSize, this.pixelSize);

    }
    public void setColor(Color color){
        this.color = color;
    }
    public int getColorID(){
        return colorID;
    }
    public void setColorID(int colorID){
        this.colorID = colorID;
    }

}
