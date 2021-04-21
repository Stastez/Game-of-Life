public class Control {
    Grid g = new Grid(5,3);

    public void start(){
        for(int i = 0; i < 10; i++){
            g.printGrid();
            g.evolveGrid();
        }
        g.printGrid();
    }
}
