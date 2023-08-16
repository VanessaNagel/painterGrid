package Elements;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Brush {

    private Grid grid;
    private int brushSize;
    private int brushColm;
    private int brushRow;
    private Rectangle brush;

    public enum BrushDirection {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public void initBrush(Color brushColor) {
        brush = new Rectangle(Grid.PADDING, Grid.PADDING, brushSize, brushSize);
        brush.setColor(brushColor);
        brush.fill();
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
        brushSize = grid.getCELL_SIZE();
    }

    public int getBrushColm() {
        return brushColm;
    }

    public int getBrushRow() {
        return brushRow;
    }


    public void moveRight() {
        if (brush.getX() < (grid.getWidth() - Grid.PADDING)) {
            brushColm++;
            brush.translate(grid.getCELL_SIZE(), 0);
        }
    }

    public void moveLeft() {
        if (brush.getX() > (Grid.PADDING)) {
            brushColm--;
            brush.translate(-grid.getCELL_SIZE(), 0);
        }
    }

    public void moveDown() {
        if (brush.getY() < (grid.getHeight() - Grid.PADDING)) {
            brushRow++;
            brush.translate(0, grid.getCELL_SIZE());
        }
    }

    public void moveUp() {
        if (brush.getY() > (Grid.PADDING)) {
            brushRow--;
            brush.translate(0, -grid.getCELL_SIZE());
        }
    }

}
