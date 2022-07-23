package backjun.basicmath.step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Hotel {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        Hotel hotel = new Hotel();
        while (T > 0) {
            T--;
            String[] test = br.readLine().split(" ");
            int result = hotel.findHotelRoom(Integer.parseInt(test[0]), Integer.parseInt(test[1]), Integer.parseInt(test[2]));
            list.add(result);
        }
        for (int x : list) {
            System.out.println(x);
        }
    }

    private int findHotelRoom(int H, int W, int N) {
        int high = 0;
        int width = 0;
        if (N % H == 0) {
            high = H;
            width = N / H;
        } else {
            high = N % H;
            width = N / H + 1;
        }
        return high * 100 + width;
    }
}
