package com.wenjie.aoc2024;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static com.wenjie.aoc2024.utils.Utils.readFile;

public class Day01 extends AbstractDay{

    private final List<Integer> l1;
    private final List<Integer> l2;

    public Day01() throws IOException {
        String s = readFile("day1.txt");

        List<int[]> list = Arrays.stream(StringUtils.split(s, "\n")).map(line -> StringUtils.split(line, " "))
            .map(pair -> new int[]{Integer.parseInt(pair[0]), Integer.parseInt(pair[1])})
            .toList();

        l1 = list.stream().map(pair -> pair[0]).sorted().toList();
        l2 = list.stream().map(pair -> pair[1]).sorted().toList();
    }

    @Override
    public String part1() {
        long sum = IntStream.range(0, l1.size())
            .mapToLong(
                i -> Math.abs(l1.get(i) - l2.get(i)))
            .sum();

        return String.valueOf(sum);
    }

    @Override
    public String part2() {
        Map<Integer, Integer> l2IdToCount = new HashMap<>();
        l2.forEach(id -> l2IdToCount.put(id, l2IdToCount.getOrDefault(id, 0) + 1));
        long sum = l1.stream().map(id -> l2IdToCount.getOrDefault(id, 0) * id).mapToLong(i -> i).sum();

        return String.valueOf(sum);
    }

    public static void main(String[] args) throws IOException {
        Day01 day01 = new Day01();
        System.out.println(day01.part1());
        System.out.println(day01.part2());
    }
}