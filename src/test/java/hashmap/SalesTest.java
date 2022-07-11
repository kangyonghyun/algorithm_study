package hashmap;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class SalesTest {

    @Test
    void sales() {
        int days = 7;
        int section = 4;
        int[] sales = {20, 12, 20, 10, 23, 17, 10};
        assertThat(makeTypeOfSales(days, section, sales)).containsExactly(3, 4, 4, 3);
    }
    @Test
    void sales_1() {
        int days = 7;
        int section = 3;
        int[] sales = {20, 12, 20, 10, 23, 17, 10};
        assertThat(makeTypeOfSales(days, section, sales)).containsExactly(2, 3, 3, 3, 3);
    }


    private List<Integer> makeTypeOfSales(int days, int section, int[] sales) {
        List<Integer> typeOfSales = new ArrayList<>();

        Map<Integer, Integer> sectionMap = new HashMap<>();
        for (int i = 0; i < section - 1; i++) {
            sectionMap.put(sales[i], sectionMap.getOrDefault(sales[i], 0) + 1);
        }
        int lt = 0;
        for (int rt = section - 1; rt < days; rt++) {
            sectionMap.put(sales[rt], sectionMap.getOrDefault(sales[rt], 0) + 1);
            typeOfSales.add(sectionMap.size());
            sectionMap.put(sales[lt], sectionMap.get(sales[lt]) - 1);
            if (sectionMap.get(sales[lt]) == 0) {
                sectionMap.remove(sales[lt]);
            }
            lt++;
        }
        return typeOfSales;
    }

}