package com.javarush.task.task19.task1922;
        import java.io.BufferedReader;
        import java.io.FileReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;
/*
Ищем нужные строки
*/
public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        String line;
        while ((line = reader.readLine()) != null) {

            String[] array = line.split("\n");
            for (String str : array) {

                int count = 0;
                for (String word : words) {

                    Pattern pattern = Pattern.compile(word);
                    Matcher matcher = pattern.matcher(str);

                    if (matcher.find() & (Arrays.asList(str.split(" ")).contains(word))) {
                        count++;
                    }
                }

                    if (count == 2) {
                     System.out.println(str);

                        }
                    }
            }
        bufferedReader.close();
        reader.close();
            }
        }