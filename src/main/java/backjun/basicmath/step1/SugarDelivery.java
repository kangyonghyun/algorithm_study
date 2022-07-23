package backjun.basicmath.step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SugarDelivery {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int sugar = Integer.parseInt(line[0]);
        br.close();

        SugarDelivery sugarDelivery = new SugarDelivery();
        System.out.println(sugarDelivery.findNumberOfBags(sugar));
    }

    private int findNumberOfBags(int sugar) {
        if (sugar == 4 || sugar == 7) {
            return -1;
        }
        if (sugar % 5 == 0) {
            return sugar / 5;
        }
        if (sugar % 5 == 1 || sugar % 5 == 3) {
            return sugar / 5 + 1;
        }
        if (sugar % 5 == 2 || sugar % 5 == 4) {
            return sugar / 5 + 2;
        }
        return -1;
    }
}
