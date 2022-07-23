package backjun.basicmath.step1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Snail {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int up = Integer.parseInt(line[0]);
        int down = Integer.parseInt(line[1]);
        int top = Integer.parseInt(line[2]);
        br.close();

        Snail snail = new Snail();
        System.out.println(snail.findDaysToTop(up, down, top));
    }

    private int findDaysToTop(int up, int down, int top) {
        int go = up - down;
        if ((top - down) % go == 0) {
            return (top - down) / go;
        } else {
            return (top - down) / go + 1;
        }
    }
}
