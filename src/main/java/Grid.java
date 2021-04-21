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

    Grid(int width, int height){
        this.width = width;
        this.height = height;
        grid = makeGrid(width, height);
    }

    public Cell[][] makeGrid(int width, int height){
        grid = new Cell[width][];

        for(int i = 0; i < width; i++){
            grid[i] = new Cell[height];

            for(int j = 0; j < height; j++){
                grid[i][j] = new Cell(false);
            }
        }

        return grid;
    }

    public void printGrid(){
        System.out.print("\t");
        for(int i = 0; i < width; i++){
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
}
