package com.wenjie.aoc2024;

import com.wenjie.aoc2024.utils.Utils;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03 extends AbstractDay {
    private final String input;

    public Day03() throws IOException {
        this.input = Utils.readFile("day3.txt");
    }

    public static void main(String[] args) throws IOException {
        Day03 day = new Day03();
        System.out.println(day.part1());
        System.out.println(day.part2());
    }

    @Override
    public String part1() {
        Pattern pattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)");
        Matcher matcher = pattern.matcher(input);

        int sum = 0;
        while (matcher.find()) {
            sum += Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(2));
        }

        return String.valueOf(sum);
    }

    @Override
    public String part2() {
        Pattern pattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)|do\\(\\)|don't\\(\\)");
        Matcher matcher = pattern.matcher(input);

        int sum = 0;
        boolean isEnable = true;

        while (matcher.find()) {
            if (matcher.group().equals("don't()")) {
                isEnable = false;
            } else if (matcher.group().equals("do()")) {
                isEnable = true;
            } else {
                if (isEnable) {
                    sum += Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(2));
                }
            }
        }

        return String.valueOf(sum);
    }
}