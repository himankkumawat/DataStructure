package com.himank.leetcode.problems;

import java.util.*;

public class Problem17 {
    public static void main(String[] args) {
        String digits = "234";
        List<String> output = letterCombinations(digits);
        System.out.println("Size : " + output.size());
        output.forEach(str -> System.out.println(str));
    }

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return Collections.EMPTY_LIST;
        Map<String, List<String>> mapper = getMapper();


        List<String> result = mapper.get(String.valueOf(digits.charAt(0)));

        for (int i = 1; i < digits.length(); i++) {
            String ch = String.valueOf(digits.charAt(i));
            result = getNewCombination(result, ch);
        }

        return result;
    }

    private static List<String> getNewCombination(List<String> inputCombination, String ch) {
        List<String> result = new ArrayList<>();
        for (String comb : inputCombination) {

            List<String> newCombinations = getMapper().get(ch);

            for (String newComb : newCombinations) {
                result.add(comb + newComb);
            }
        }
        return result;
    }

    public static Map<String, List<String>> getMapper() {
        Map<String, List<String>> mapper = new HashMap<>();
        mapper.put("2", List.of("a", "b", "c"));
        mapper.put("3", List.of("d", "e", "f"));
        mapper.put("4", List.of("g", "h", "i"));
        mapper.put("5", List.of("j", "k", "l"));
        mapper.put("6", List.of("m", "n", "o"));
        mapper.put("7", List.of("p", "q", "r", "s"));
        mapper.put("8", List.of("t", "u", "v"));
        mapper.put("9", List.of("w", "x", "y", "z"));

        return mapper;
    }
}
