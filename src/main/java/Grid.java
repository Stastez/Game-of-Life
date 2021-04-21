public class Grid {
    private class Cell{
        boolean isAlive;

        Cell(boolean isAlive){
            this.isAlive = isAlive;
        }
    }

    private Cell[][] grid;
    private final int width;
    private final int height;
    private int iteration;

    public Grid(int width, int height){
        this.width = width;
        this.height = height;
        makeGrid(width, height);
        iteration = 0;
    }

    /**
     * Makes a grid from the given dimensions and saves it in the class variable "grid".
     * @param width Describes the x-dimension of the resulting grid. Must be positive.
     * @param height Describes the y-dimension of the resulting grid. Must be positive.
     * @throws IllegalArgumentException When the arguments are not positive.
     */
    private void makeGrid(int width, int height) throws IllegalArgumentException{
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
        System.out.println("Iteration " + iteration++ + ": ");  //Prints the iteration counter header.
        for(int i = 0; i <= width; i++){
            System.out.print("-\t");
        }
        System.out.println();

        System.out.print("\t");                 //Sets up a counter, so that each row and column of
        for(int i = 0; i < width; i++){         //the resulting print show their respective number.
            System.out.print(i + "\t");
        }
        System.out.println();
        int counterH = 0;

        //int j = 0;

        for(int i = 0; i < height; i++){
            System.out.print(counterH++ + "\t");
            for(Cell[] tmp : grid){
                System.out.print((tmp[i].isAlive ? "✓":"\uD83D\uDFA9")/*countAliveNeighbours(j++,i)*/ + "\t");
            }
            System.out.println();
            //j = 0;
        }
    }

    public void evolveGrid(){
        Grid temp = new Grid(width, height);

        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){
                switch (countAliveNeighbours(x, y)) {
                    case 2 -> temp.setStatus(x, y, grid[x][y].isAlive);
                    case 3 -> temp.setStatus(x, y, true);
                    default -> temp.setStatus(x, y, false);
                }
            }
        }
    }

    int countAliveNeighbours(int x, int y) throws IllegalArgumentException{
        if(x >= width | y >= height | x < 0 | y < 0){
            throw new IllegalArgumentException("Cannot access position (" + x + "," + y + ") on a grid of dimensions (" + (width - 1) + "," + (height - 1) + ").");
        }

        int counter = 0;

        if(x >= 1){
            if(x <= width - 2){
                if(y >= 1){
                    if(y <= height - 2){
                        for(int i = -1; i < 2; i++){
                            counter+=grid[x+i][y-1].isAlive ? 1:0;
                            counter+=grid[x+i][y+1].isAlive ? 1:0;
                        }
                    }else{
                        for(int i = -1; i < 2; i++){
                            counter+=grid[x+i][y-1].isAlive ? 1:0;
                        }
                    }
                }else{
                    for(int i = -1; i < 2; i++){
                        counter+=grid[x+i][y+1].isAlive ? 1:0;
                    }
                }
                counter+=grid[x-1][y].isAlive ? 1:0;
                counter+=grid[x+1][y].isAlive ? 1:0;
            }else{
                if(y >= 1){
                    if(y <= height - 2){
                        for(int i = -1; i < 1; i++){
                            counter+=grid[x+i][y-1].isAlive ? 1:0;
                            counter+=grid[x+i][y+1].isAlive ? 1:0;
                        }
                    }else{
                        for(int i = -1; i < 1; i++){
                            counter+=grid[x+i][y-1].isAlive ? 1:0;
                        }
                    }
                    counter+=grid[x-1][y].isAlive ? 1:0;
                }else{
                    for(int i = -1; i < 1; i++){
                        counter+=grid[x+i][y+1].isAlive ? 1:0;
                    }
                }
                counter+=grid[x-1][y].isAlive ? 1:0;
            }
        }else{
            if(y >= 1){
                if(y <= height - 2){
                    for(int i = 0; i < 2; i++){
                        counter+=grid[x+i][y-1].isAlive ? 1:0;
                        counter+=grid[x+i][y+1].isAlive ? 1:0;
                    }
                }else{
                    for(int i = 0; i < 2; i++){
                        counter+=grid[x+i][y-1].isAlive ? 1:0;
                    }
                }
                counter+=grid[x+1][y].isAlive ? 1:0;
            }else{
                for(int i = 0; i < 2; i++){
                    counter+=grid[x+i][y+1].isAlive ? 1:0;
                }
            }
            counter+=grid[x+1][y].isAlive ? 1:0;
        }

        return counter;
    }

    public void kill(int x, int y){
        grid[x][y].isAlive = false;
    }

    public void revive(int x, int y){
        grid[x][y].isAlive = true;
    }

    public void setStatus(int x, int y, boolean status){
        grid[x][y].isAlive = status;
    }
}
