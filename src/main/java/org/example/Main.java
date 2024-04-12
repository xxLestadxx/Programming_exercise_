package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public String reverseString(String str){
        char[] charArray = str.toCharArray();

        int left = 0;
        int right = charArray.length - 1;

        //swap characters until it comes to the middle
        while (left<right){
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            //moving the pointers
            left++;
            right--;
        }

        return new String(charArray);
    }

    //given the nature of HashMap, you can only calculate the unique words in a given string
    public int calculateWords(String str){

        // taking into account that the string could have more than just words
        String[] words = str.split("[^a-zA-Z0-9]+");

        Map<String, Integer> wordFrequency = new HashMap<>();

        for (String word : words){

            //removing numbers as the task is to calculate only words
            word = word.replaceAll("\\d", "");

            if(!word.isEmpty()){
                if(wordFrequency.containsKey(word)){
                    // if the word is already in the hashmap add 1
                    wordFrequency.put(word, wordFrequency.get(word) + 1);
                }else {
                    wordFrequency.put(word, 1);
                }
            }
        }
        return wordFrequency.size();
    }

    public <T> void traverseArrayList(ArrayList<T> list){
        System.out.println("for loop");
        for (T t : list) {
            System.out.println(t);
        }

        System.out.println("while loop");
        int i = 0;
        while (i < list.size()){
            System.out.println(i);
            i++;
        }
    }


    //it basically is the same as counting the words, but prints whatever has been more than once
    public Map<Character, Integer> findDuplicateCharacters(String str){
        Map<Character, Integer> charMap = new HashMap<>();

        char[] charArray = str.toCharArray();

        for (char ch : charArray){
            if(charMap.containsKey(ch)){
                charMap.put(ch, charMap.get(ch) + 1);
            }else {
                charMap.put(ch, 1);
            }
        }
        System.out.println("The duplicate characters in the " + str + " are:");
        for (Map.Entry<Character, Integer> entry: charMap.entrySet()){
            if(entry.getValue() > 1){
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
        return charMap;
    }

    public void readExcel(){
        String excelFilePath = "SampleData.xlsx";
        try {
            FileInputStream inputStream = new FileInputStream(excelFilePath);
            Workbook workbook = new XSSFWorkbook(inputStream);

            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        case BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t");
                            break;
                        case BLANK:
                            System.out.print("[BLANK]\t");
                            break;
                        default:
                            System.out.print("[UNKNOWN]\t");
                    }
                }
                System.out.println();
            }
            workbook.close();
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}