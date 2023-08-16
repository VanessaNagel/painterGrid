package Elements;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {

    Rectangle rectangle;
    private boolean painted;

    public Cell(Grid grid, int colm, int row) {
        rectangle = new Rectangle(colm * grid.getCELL_SIZE() + Grid.PADDING, row * grid.getCELL_SIZE() + Grid.PADDING, grid.getCELL_SIZE(), grid.getCELL_SIZE());
        rectangle.setColor(Color.BLACK);
        rectangle.draw();
    }

    private void setPainted(Boolean status) {
        this.painted = status;
    }

    public void paint() {
        setPainted(true);
        rectangle.fill();
    }

    public void erase() {
        setPainted(false);
        rectangle.draw();
    }

    public boolean isPainted() {
        return painted;
    }

    @Override
    public String toString() {
        return painted ? "1" : "0";
    }
}
