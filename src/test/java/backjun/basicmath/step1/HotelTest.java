package backjun.basicmath.step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HotelTest {

    @Test
    void hotel() {
        int H = 6;
        int W = 12;
        int N = 10;

        assertThat(findHotelRoom(H, W, N)).isEqualTo(402);
        assertThat(findHotelRoom(30, 50, 72)).isEqualTo(1203);
        assertThat(findHotelRoom(6, 12, 18)).isEqualTo(603);
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
        return high * 100 +  width;
    }

}