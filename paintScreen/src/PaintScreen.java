import Elements.Brush;
import Elements.Cell;
import Elements.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;

public class PaintScreen {

    private final Grid myGrid;
    private final Brush myBrush;
    private boolean painting;

    public PaintScreen() {
        this.myGrid = new Grid();
        this.myBrush = new Brush();
        Command command = new Command(this);
        myBrush.setGrid(myGrid);
    }

    public void init() {
        myGrid.init();
        myBrush.initBrush(Color.BLUE);
    }

    public void moveBrush(Brush.BrushDirection direction) {

        switch (direction) {
            case RIGHT -> myBrush.moveRight();
            case LEFT -> myBrush.moveLeft();
            case DOWN -> myBrush.moveDown();
            case UP -> myBrush.moveUp();
        }

        if (painting) {
            paintCell();
        }
    }

    public void paintCell() {
        Cell cell = myGrid.getCell(myBrush.getBrushColm(), myBrush.getBrushRow());
        if (cell.isPainted()) {
            cell.erase();
            return;
        }
        cell.paint();
    }

    public void save() {
        GridSaver.writeFile(myGrid.toString());
    }

    public void load() {
        myGrid.stringToGrid(GridSaver.readFile());
    }

    public void clear() {
        myGrid.clearScreen();
    }


    public void setPainting(boolean painting) {
        this.painting = painting;
    }

}
