import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Sirclo_chainBall {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine;

        ArrayList<String> lineOfBall = new ArrayList<String>();
        Map<String, Integer> bagOfBall = new HashMap<String, Integer>();

        String[] balls = br.readLine().split("");
        for (String ball : balls) {
            lineOfBall.add(ball);
        }

        String[] bag = br.readLine().split(",");

        for (int i = 0; i < bag.length; i++) {
            String[] col_val = bag[i].split(":");
            String color = col_val[0];
            int val = Integer.parseInt(col_val[1]);

            if (bagOfBall.containsKey(color)) {
                bagOfBall.put(color, bagOfBall.get(color) + val);
            } else {
                bagOfBall.put(color, val);
            }
        }

        while ((inputLine = br.readLine()) != null) {
            String[] inputArr = inputLine.split(" ");
            String cmd = inputArr[0];

            if (cmd.equals("SELIP")) {
                String color = inputArr[1];
                int idx = Integer.parseInt(inputArr[2]);

                if (idx <= lineOfBall.size() && bagOfBall.get(color) > 0) {
                    lineOfBall.add(idx, color);
                    bagOfBall.put(color, bagOfBall.get(color) - 1);
                }

            } else if (cmd.equals("AMBIL")) {
                int idx = Integer.parseInt(inputArr[1]);

                if (idx < lineOfBall.size()) {
                    String ballTaken = lineOfBall.remove(idx);

                    if (bagOfBall.containsKey(ballTaken)) {
                        bagOfBall.put(ballTaken, bagOfBall.get(ballTaken) + 1);
                    } else {
                        bagOfBall.put(ballTaken, 1);
                    }
                }
            } else {
                break;
            }
        }

        for (String ball : lineOfBall) {
            System.out.print(ball);
        }
        System.out.println();

        String print = "";
        for (String key : bagOfBall.keySet()) {
            if (bagOfBall.get(key) != 0) {
                print += (key + ":" + bagOfBall.get(key) + ",");
            }
        }
        System.out.println(print.substring(0, print.length() - 1));

    }

}
