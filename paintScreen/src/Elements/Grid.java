package Elements;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    public static final int PADDING = 10;
    private final int width = 400;
    private final int height = 400;
    private final int CELL_SIZE = 20;
    private final int cols = width / CELL_SIZE;
    private final int rows = height / CELL_SIZE;
    public Cell[][] cells = new Cell[cols][rows];
    Rectangle background;


    public Grid() {
        this.background = new Rectangle(PADDING, PADDING, width, height);

    }


    public void init() {
        drawCells();
    }

    public int getCELL_SIZE() {
        return CELL_SIZE;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    public void drawCells() {
        for (int i = 0; i < cols; i++) {
            //col = i;
            for (int j = 0; j < rows; j++) {
                //row = j;
                cells[i][j] = new Cell(this, i, j);

            }
        }
    }

    public Cell getCell(int col, int row) {
        return cells[col][row];
    }


    public void stringToGrid(String readFile) {
        int index = 0;

        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {

                Cell cell = cells[col][row];

                if (readFile.charAt(index) == '0') {
                    cell.erase();
                } else {
                    cell.paint();
                }

                index++;
            }
            index++; //jump line ("\n")

        }
    }

    @Override
    public String toString() {

        StringBuilder grid = new StringBuilder();

        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                grid.append(cells[col][row]);
            }
            grid.append("\n");
        }
        System.out.println(grid);
        return grid.toString();
    }

    public void clearScreen() {
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                cells[col][row].erase();
            }
        }
    }
}








