public class Grid {
    private class Cell{
        boolean isAlive;

        Cell(boolean isAlive){
            this.isAlive = isAlive;
        }
    }

    Cell[][] grid;
    int width;
    int height;
    int iteration;

    Grid(int width, int height){
        this.width = width;
        this.height = height;
        makeGrid(width, height);
        iteration = 0;
    }

    /**
     * Makes a grid from the given dimensions and saves it in the class variable "grid".
     * @param width Describes the x-dimension of the resulting grid. Must be positive.
     * @param height Describes the y-dimension of the resulting grid. Must be positive.
     */
    public void makeGrid(int width, int height){
        if(width == 0 | height == 0){
            throw new IllegalArgumentException("width and height always have to be positive.");
        }

        grid = new Cell[width][];

        for(int i = 0; i < width; i++){
            grid[i] = new Cell[height];

            for(int j = 0; j < height; j++){
                grid[i][j] = new Cell(true);
            }
        }
    }

    /**
     * First prints an iteration counter of the grid, then the grid saved in the class variable while also displaying a row and column counter.
     * Cells that are alive will be denoted "✓" and cells that are dead will be shown as "🞩".
     */
    public void printGrid(){
        System.out.println("Iteration " + iteration++ + ": ");
        for(int i = 0; i <= width; i++){
            System.out.print("-\t");
        }
        System.out.println();

        System.out.print("\t");                 //Sets up a counter, so that each row and column of
        for(int i = 0; i < width; i++){         //the resulting print show their respective number.
            System.out.print(i + 1 + "\t");
        }
        System.out.println();
        int counterH = 1;

        for(int i = 0; i < height; i++){
            System.out.print(counterH++ + "\t");
            for(Cell[] tmp : grid){
                System.out.print((tmp[i].isAlive ? "✓":"\uD83D\uDFA9") + "\t");
            }
            System.out.println();
        }
    }

    public void evolveGrid(){

    }
}
