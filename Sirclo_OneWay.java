import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sirclo_OneWay {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        String[] fLine = scan.nextLine().split(" ");
        
        int row = Integer.parseInt(fLine[0]);
        int col = Integer.parseInt(fLine[1]);

        int startRow = -1;
        int startCol = -1;
        
        String[][] map = new String[row][col];

        for (int i = 0; i < row; i++) {
            String[] rows = scan.nextLine().split("");
            for (int j = 0; j < rows.length; j++) {
                map[i][j] = rows[j];
                if (rows[j].equals("S")) {
                    startRow = i;
                    startCol = j;
                }
            }
        }
        
        List<String> visited = new ArrayList<String>();
        findWay(map, startRow, startCol, visited);

    }
    
    
    public static void findWay(String[][] map, int row, int col, List<String> visited) {
       
        visited.add(row + "" + col);
        String up = (row-1) + "" + col;
        String down = (row+1) + "" + col;
        String left = row + "" + (col-1);
        String right = row + "" + (col+1);
        
        if (!visited.contains(up) && canGo(map, row-1, col)) {
            System.out.print("U");
            findWay(map, row-1, col, visited);
        } else if (!visited.contains(down) && canGo(map, row+1, col)) {
            System.out.print("D");
            findWay(map, row+1, col, visited);
        } else if (!visited.contains(left) && canGo(map, row, col-1)) {
            System.out.print("L");
            findWay(map, row, col-1, visited);
        } else if (!visited.contains(right) && canGo(map, row, col+1)) {
            System.out.print("R");
            findWay(map, row, col+1, visited);
        } 
    }
    
    public static boolean canGo(String[][] map, int row, int col) {
        int length = map.length - 1;
        int width = map[0].length - 1;
        
        if(row < 0 | row > length | col < 0 | col > width) return false;
        else return map[row][col].equals(".") || map[row][col].equals("E");
    }
    
    public static boolean isFinish(String[][] map, int row, int col) {
        return map[row][col].equals("E");
    }

    public static void checkMap(String[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
