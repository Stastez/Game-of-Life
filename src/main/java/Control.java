import java.io.*;

public class Control {
    Grid g = new Grid(20,16);

    public void start(int iterations, int sleepTime, String source){
        /*try {
            createGridFromFile(source);
        }catch(Exception e){
            System.out.println("Fault.");
        }*/

        g.revive(3,1);
        g.revive(4,2);
        g.revive(2,3);
        g.revive(3,3);
        g.revive(4,3);

        for(int i = 0; i < iterations; i++){
            g.printGrid(sleepTime);
            g.evolveGrid();
        }
        g.printGrid(sleepTime);
    }

    /**
     * Tries to push the screen clear in order to be able to watch the evoltion.
     */
    public static void clearScreen(int sleepTime) {
        try {
            Thread.sleep(sleepTime);
        }catch (Exception e){
            System.out.println("Could not sleep.");
        }
        System.out.print("\n".repeat(65));

        //System.out.println("\033[2J");
    }

    /**
     * Creates grid from the given .txt file.
     * @param path The path of the file from which to read.
     * @throws IOException If the FileReader encounters a problem.
     */
    public void createGridFromFile(String path) throws IOException {
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);

        int width = Integer.parseInt(br.readLine());
        int height = Integer.parseInt(br.readLine());

        String[] lines = new String[height];

        for(int i = 0; i < height; i++){
            lines[i] = br.readLine();
        }

        br.close();
        fr.close();

        g = new Grid(width, height);

        for(int j = 0; j < lines.length; j++){
            for(int i = 0; i < lines[j].length(); i++){
                g.setStatus(i, j, lines[j].charAt(i) == '#');
            }
        }
    }
}
