package basic.dfs;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BadugiRideTest {

    @Test
    void solution() {
        int weight = 259;
        int n = 5;
        int[] arr = {81, 58, 42, 33, 61};

        Badugis badugis = new Badugis(weight, arr);
        badugis.getMaxWeightRide(0, 0);
        assertThat(badugis.total).isEqualTo(242);
    }

    static class Badugis {
        int maxWeight;
        int[] badugis;

        int total;
        boolean flag;

        public Badugis(int maxWeight, int[] badugis) {
            this.maxWeight = maxWeight;
            this.badugis = badugis;
            this.total = Integer.MIN_VALUE;
        }

        public void getMaxWeightRide(int L, int sum) {
            if (this.maxWeight < sum) {
                return;
            }
            if (L == this.badugis.length) {
                this.total = Math.max(this.total, sum);
            } else {
                getMaxWeightRide(L + 1, sum + this.badugis[L]);
                getMaxWeightRide(L + 1, sum);
            }
        }
    }

}