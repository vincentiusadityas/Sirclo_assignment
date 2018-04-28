import java.util.Scanner;

public class Sirclo_HourGlass {
    

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        
        int height;
        String type;
        
        Scanner scan = new Scanner(System.in);
        
        while(true) {
            height = Integer.parseInt(scan.nextLine());
            type = scan.nextLine();
            hourGlass(height, type);
            System.out.println();
        }
    }

    public static void hourGlass(int height, String type) {
        int totalHeight = 2 * height + 1;
        String row = "";

        for (int i = 0; i < height + 1; i++) {
            
            for (int j = totalHeight - i; j < totalHeight; j++) {
                System.out.print(" ");
            }
            
            if (type.equals("PENUH") && i > 0 && i < height) {
                
                for (int j = 0; j <= totalHeight - 2 * i - 3; j++) {
                    row += " ";
                }
                System.out.print("*" + row + "*");
                row = "";
                
            } else {
                
                for (int j = 0; j < totalHeight - 2 * i; j++) {             
                    System.out.print("*");
                }
            }
            
            System.out.println();
        }
        
        for (int i = height-1; i >= 0; i--) {
            
            for (int j = totalHeight; j > totalHeight - i; j--) {
                System.out.print(" ");
            }
            
            if (type.equals("KOSONG") && i > 0 && i < height) {
                
                for (int j = totalHeight - 2 * i - 2; j > 0; j--) {
                    row += " ";
                }
                System.out.print("*" + row + "*");
                row = "";
                
            } else {
                
                for (int j = totalHeight - 2 * i; j > 0; j--) {
                    System.out.print("*");
                }
            }
            
            System.out.println();
        }

    }

}
