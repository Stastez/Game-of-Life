import java.io.*;

public class Control {
    Grid g = new Grid(30,40);

    public void start(){
        try {
            createGridFromFile("C:\\Users\\Sandr\\OneDrive - Universität Potsdam\\Desktop\\factory.txt");
        }catch(Exception e){
            System.out.println("Fault.");
        }

        for(int i = 0; i < 100; i++){
            g.printGrid();
            g.evolveGrid();
        }
        g.printGrid();
    }

    /**
     * Tries to push the screen clear in order to be able to watch the evoltion.
     */
    public static void clearScreen() {
        try {
            Thread.sleep(125);
        }catch (Exception e){
            System.out.println("Could not sleep.");
        }
        System.out.print("\n".repeat(50));

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
