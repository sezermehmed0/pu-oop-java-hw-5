package pixels;

import java.awt.*;

public class Pixel {

      final int row;
      final int col;
      private Color color;
      int colorID;


    public Pixel(int row , int col, Color color) {
        this.row = row;
        this.col = col;
        this.color = color;
    }
    public void renderPixel(Graphics g){

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
