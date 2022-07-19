package com.javarush.task.task18.task1815;

import java.util.*;
/*
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements TableInterface {

      private TableInterface tableInterface;

        public TableInterfaceWrapper (TableInterface tableInterface) {
            this.tableInterface = tableInterface;   }


           public void setModel (List rows)  {System.out.print(rows.size()); tableInterface.setModel(rows);  }

           public String getHeaderText()  { return tableInterface.getHeaderText().toUpperCase();}

           public void setHeaderText(String newHeaderText)  {tableInterface.setHeaderText(newHeaderText); }
    }

    public interface TableInterface {

        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {



    }
}