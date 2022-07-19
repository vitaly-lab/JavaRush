package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* c
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader fileNameRead = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = fileNameRead.readLine();
        String fileName2 = fileNameRead.readLine();

        fileNameRead.close();

        BufferedReader file1Read = new BufferedReader(new FileReader(fileName1));
        BufferedReader file2Read = new BufferedReader(new FileReader(fileName2));

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        while (file1Read.ready()) {
            list1.add(file1Read.readLine());
        }

        file1Read.close();

        while (file2Read.ready()) {
            list2.add(file2Read.readLine());
        }

        file2Read.close();

        int i = 0;
        int j = 0;
        try {

            while (j != list2.size()) {
                if (list1.get(i).equals(list2.get(j))) {
                    lines.add(new LineItem(Type.SAME, list1.get(i)));
                    i++;
                    j++;
                    continue;
                }

                if (!list1.get(i).equals(list2.get(j)) && list1.get(i + 1).equals(list2.get(j))) { // т.к. после REMOVED идёт всегда SAME
                    lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                    i++;
                    continue;
                }

                if (!list1.get(i).equals(list2.get(j)) && !list1.get(i + 1).equals(list2.get(j))) { // т.к. после ADDED идёт всегда SAME
                    lines.add(new LineItem(Type.ADDED, list2.get(j)));
                    j++;
                    continue;
                }
            }

        } catch (IndexOutOfBoundsException e) { lines.add(new LineItem(Type.ADDED, list2.get(j)));
        }

        // if (i < list1.size()) {
        //     lines.add(new LineItem(Type.REMOVED, list1.get(list1.size() - 1)));
        //  }

        while (i < list1.size()) {
            lines.add(new LineItem(Type.REMOVED, list1.get(i)));
            i++;
        }

        for (int p = 0; p < lines.size(); p++) {
            System.out.println(lines.get(p).type + " " + lines.get(p).line);  }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
