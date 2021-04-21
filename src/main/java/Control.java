public class Control {
    Grid g = new Grid(30,40);

    public void start(){
        g.setStatus(3,1,true);
        g.setStatus(4,2,true);
        g.setStatus(2,3,true);
        g.setStatus(3,3,true);
        g.setStatus(4,3,true);

        for(int i = 0; i < 100; i++){
            g.printGrid();
            g.evolveGrid();
        }
        g.printGrid();
    }

    public static void clearScreen() {
        /*try {
            Thread.sleep(125);
        }catch (Exception e){

        }
        String s = "";
        for(int i = 0; i < 50; i++){
            s = s + "\n";
        }
        System.out.print(s);*/

        System.out.println("\033[2J");
    }
}
