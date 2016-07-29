package com.tw.bootcamp.stringcalculator;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numberStr) {
        if (numberStr == null || numberStr.trim().length() == 0) {
            return 0;
        }

        String croppedNumbersStr = crop(numberStr);
        String[] numbersString = croppedNumbersStr.split(getDelimiter(numberStr));

        List<Integer> numbers = convertToInt(numbersString);

        Integer sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }

    private String crop(String numbersStr) {
        Pattern DELIMITER_PATTERN = Pattern.compile("^//.{1}\n(.*)");
        Matcher matcher = DELIMITER_PATTERN.matcher(numbersStr);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return numbersStr;
    }

    private String getDelimiter(String numberStr) {
        Pattern DELIMITER_PATTERN = Pattern.compile("^//(.{1})\n.*");
        Matcher matcher = DELIMITER_PATTERN.matcher(numberStr);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "[,\n]";
    }

    private List<Integer> convertToInt(String[] numbersString) {
        List<Integer> numbers = new LinkedList<Integer>();
        for (String number : numbersString) {
            try {
                Integer intNumber = Integer.valueOf(number);
                if (intNumber < 0) {
                    throw new NumberFormatException();
                }
                numbers.add(intNumber);
            } catch (NumberFormatException e) {
                throw new StringInvalidFormat();
            }
        }
        return numbers;
    }

}
