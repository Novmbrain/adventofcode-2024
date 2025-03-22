import com.wenjie.aoc2024.Day02;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TestDay02 {

    public static final String DAY_02_EXAMPLE_TXT = "day02-example.txt";

    @Test
    void part1_example_input() throws IOException {
        Day02 day02 = new Day02(DAY_02_EXAMPLE_TXT);
        assertThat(day02.part1()).isEqualTo("2");
    }

    @Test
    void part2_example_input() throws IOException {
        Day02 day02 = new Day02(DAY_02_EXAMPLE_TXT);
        assertThat(day02.part2()).isEqualTo("4");
    }

    @Test
    void test() {
        List<Integer> levels = List.of(10, 6, 5, 3, 1);
        Day02 day02 = new Day02();
        System.out.println(day02.isSafeReport(levels));
    }
}