package com.javarush.task.task26.task2601;

import java.util.*;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {

     // Integer[] arrayOrigin = new Integer[] {12, 8, 14, 15, 5, 17, 13, 18};
    //   Integer[] arrayOrigin = new Integer[] {13, 8, 15, 5, 17};
    //    Integer [] arrayNew;

  //      arrayNew = sort(arrayOrigin);

   //     for (int test : arrayNew){

   //    System.out.print(test + " "); }
    }

    public static Integer[] sort(Integer[] array) {
        List list = Arrays.asList(array);
        ArrayList<Integer> arrayList = new ArrayList<>(list);
            double mediana = 0;
        LinkedList<Integer> arrayNew = new LinkedList<>();
///------------------------------------------------------
        if ((arrayList.size() % 2) == 0) {
            Collections.sort(arrayList);
            double b = arrayList.size()/2;

            double d = arrayList.get((int) (b - 1));
            double c = arrayList.get((int) b);

            mediana =  ((d + c)/2); }

 //-------------------------------------------------------------------
        else {
            Collections.sort(arrayList);
            double a = arrayList.size() - 1;
            double b = a/2;

            mediana = arrayList.get((int) b);
            }
// -------------------------------------------------------------------------------

            HashMap<Integer, Double> map = new HashMap<>();


            for (int i = 0; i < arrayList.size(); i++){

            if (Double.valueOf((arrayList.get(i) - mediana)) >= 0 ){
                map.put(arrayList.get(i), Double.valueOf((arrayList.get(i) - mediana))); }
            else {
                    map.put(arrayList.get(i), (Double.valueOf((arrayList.get(i) - mediana)) * -1)); }
            }
            Map<Integer, Double> sortedMap = sortByValue(map);

            for(Map.Entry<Integer, Double> item : sortedMap.entrySet()){
               // System.out.printf("Key: %s  Value: %s \n", item.getKey(), item.getValue().getName());
                arrayNew.add(item.getKey());    }


        Integer[] arr = arrayNew.toArray(new Integer[arrayNew.size()]);
        return arr;
    }

    private static Map<Integer, Double> sortByValue(Map<Integer, Double> map) {

        //1. Convert Map to List of Map
        List<Map.Entry<Integer, Double>> list =
                new LinkedList<Map.Entry<Integer, Double>>(map.entrySet());

        //2. Sort list with Collections.sort(), provide a custom Comparator
        //   Try switch the o1 o2 position for a different order
        Collections.sort(list, new Comparator<Map.Entry<Integer, Double>>() {
            public int compare(Map.Entry<Integer, Double> o1,
                               Map.Entry<Integer, Double> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
//3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        Map<Integer, Double> sortedMap = new LinkedHashMap<Integer, Double>();
        for (Map.Entry<Integer, Double> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

          return sortedMap;
         }



}
