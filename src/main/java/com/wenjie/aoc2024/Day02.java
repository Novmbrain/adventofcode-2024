package com.wenjie.aoc2024;

import com.google.common.annotations.VisibleForTesting;
import com.wenjie.aoc2024.utils.Utils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Day02 extends AbstractDay{
    private static final int minGap = 1;
    private static final int maxGap = 3;
    private List<List<Integer>> reports;

    public static void main(String[] args) throws IOException {
        Day02 day02 = new Day02("day2.txt");
        System.out.println(day02.part1());
        System.out.println(day02.part2());
    }


    public Day02(String file) throws IOException {
        String input = Utils.readFile(file);
        String[] lines = StringUtils.split(input, "\n");

        reports = Arrays.stream(lines)
            .map(line ->
                Arrays.stream(StringUtils.split(line, " "))
                    .map(Integer::parseInt).collect(Collectors.toCollection(LinkedList::new))
            ).collect(Collectors.toCollection(LinkedList::new));
    }

    @VisibleForTesting
    public Day02() {
    }

    @Override
    public String part1() {
        long count = reports.stream().filter(this::isSafeReport).count();
        return Long.toString(count);
    }

    @Override
    public String part2() {
        int count = 0;
        for (List<Integer> report : reports) {
            boolean safe = false;

            if (isSafeReport(report)) {
                count++;
            } else {
                for (int index = 0; index < report.size(); index++) {
                    LinkedList<Integer> copy = new LinkedList<>(report);
                    copy.remove(index);
                    safe = safe || isSafeReport(copy);
                }

                if (safe) {
                    count++;
                }
            }

        }

        return String.valueOf(count);
    }


    public boolean isSafeReport(List<Integer> levels) {
        int level1 = levels.get(0);
        int level2 = levels.get(1);

        if (level1 == level2) {
            return false;
        }

        boolean isIncreasing = level1 < level2;
        return check(levels, isIncreasing);
    }

    private boolean check(List<Integer> levels, boolean isIncreasing) {
        for (int i = 0; i < levels.size() - 1; i++) {
            int current = levels.get(i);
            int next = levels.get(i + 1);
            int diff = isIncreasing ?  next - current : current - next;
            if (matchSafeCondition(diff)) {
                return false;
            }
        }

        return true;
    }

    private static boolean matchSafeCondition(int diff) {
        return diff < minGap || diff > maxGap;
    }
}