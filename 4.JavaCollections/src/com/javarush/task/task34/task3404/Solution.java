package com.javarush.task.task34.task3404;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.function.DoubleBinaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Рекурсия для мат. выражения
*/
public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "sin(2*(-5+1.5*4)+28)";
        System.out.print(s + " expected output 0.5 6 actually ");
        solution.recurse(s, 0);
        s = "tan(45)";
        System.out.print(s + " expected output 1 1 actually ");
        solution.recurse(s, 0);
        s = "tan(-45)";
        System.out.print(s + " expected output -1 2 actually ");
        solution.recurse(s, 0);
        s = "0.305";
        System.out.print(s + " expected output 0.3 0 actually ");
        solution.recurse(s, 0);
        s = "0.3051";
        System.out.print(s + " expected output 0.31 0 actually ");
        solution.recurse(s, 0);
        s = "(0.3051)";
        System.out.print(s + " expected output 0.31 0 actually ");
        solution.recurse(s, 0);
        s = "1+(1+(1+1)*(1+1))*(1+1)+1";
        System.out.print(s + " expected output 12 8 actually ");
        solution.recurse(s, 0);
        s = "tan(44+sin(89-cos(180)^2))";
        System.out.print(s + " expected output 1 6 actually ");
        solution.recurse(s, 0);
        s = "-2+(-2+(-2)-2*(2+2))";
        System.out.print(s + " expected output -14 8 actually ");
        solution.recurse(s, 0);
        s = "sin(80+(2+(1+1))*(1+1)+2)";
        System.out.print(s + " expected output 1 7 actually ");
        solution.recurse(s, 0);
        s = "1+4/2/2+2^2+2*2-2^(2-1+1)";
        System.out.print(s + " expected output 6 11 actually ");
        solution.recurse(s, 0);
        s = "10-2^(2-1+1)";
        System.out.print(s + " expected output 6 4 actually ");
        solution.recurse(s, 0);
        s = "2^10+2^(5+5)";
        System.out.print(s + " expected output 2048 4 actually ");
        solution.recurse(s, 0);
        s = "1.01+(2.02-1+1/0.5*1.02)/0.1+0.25+41.1";
        System.out.print(s + " expected output 72.96 8 actually ");
        solution.recurse(s, 0);
        s = "0.000025+0.000012";
        System.out.print(s + " expected output 0 1 actually ");
        solution.recurse(s, 0);
        s = "-2-(-2-1-(-2)-(-2)-(-2-2-(-2)-2)-2-2)";
        System.out.print(s + " expected output -3 16 actually ");
        solution.recurse(s, 0);
        s = "cos(3 + 19*3)";
        System.out.print(s + " expected output 0.5 3 actually ");
        solution.recurse(s, 0);
        s = "2*(589+((2454*0.1548/0.01*(-2+9^2))+((25*123.12+45877*25)+25))-547)";
        System.out.print(s + " expected output 8302231.36 14 actually ");
        solution.recurse(s, 0);
        s = "(-1 + (-2))";
        System.out.print(s + " expected output -3 3 actually ");
        solution.recurse(s, 0);
        s = "-sin(2*(-5+1.5*4)+28)";
        System.out.print(s + " expected output -0.5 7 actually ");
        solution.recurse(s, 0);
        s = "sin(100)-sin(100)";
        System.out.print(s + " expected output 0 3 actually ");
        solution.recurse(s, 0);
        s = "-(-22+22*2)";
        System.out.print(s + " expected output -22 4 actually ");
        solution.recurse(s, 0);
        s = "-2^(-2)";
        System.out.print(s + " expected output -0.25 3 actually ");
        solution.recurse(s, 0);
        s = "-(-2^(-2))+2+(-(-2^(-2)))";
        System.out.print(s + " expected output 2.5 10 actually ");
        solution.recurse(s, 0);
        s = "(-2)*(-2)";
        System.out.print(s + " expected output 4 3 actually ");
        solution.recurse(s, 0);
        s = "(-2)/(-2)";
        System.out.print(s + " expected output 1 3 actually ");
        solution.recurse(s, 0);
        s = "sin(-30)";
        System.out.print(s + " expected output -0.5 2 actually ");
        solution.recurse(s, 0);
        s = "cos(-30)";
        System.out.print(s + " expected output 0.87 2 actually ");
        solution.recurse(s, 0);
        s = "tan(-30)";
        System.out.print(s + " expected output -0.58 2 actually ");
        solution.recurse(s, 0);
        s = "2+8*(9/4-1.5)^(1+1)";
        System.out.print(s + " expected output 6.5 6 actually ");
        solution.recurse(s, 0);
        s = "0.005 ";
        System.out.print(s + " expected output 0.01 0 actually ");
        solution.recurse(s, 0);
        s = "0.0049 ";
        System.out.print(s + " expected output 0 0 actually ");
        solution.recurse(s, 0);
        s = "0+0.304";
        System.out.print(s + " expected output 0.3 1 actually ");
        solution.recurse(s, 0);
    }
//----------------------------------------------------------------------------------------------------------------------
    public void recurse(final String expression, int countOperation) {

        //implement
        String temp = new String(expression);
        boolean complete = false;
// operation's patterns
        Pattern mindetect = Pattern.compile( "[^\\d)?]-|^-" );//патерн для определения унарных минусов, если цифра или выражение меняет знак на противопожный
        Pattern patPar = Pattern.compile( "\\(([^()]*)\\)" );//внутренние скобки
        Pattern patrem = Pattern.compile(" \\((-?[\\d.]+)\\)" );//поиск готовых цифр в скобках для раскрытия
        Pattern pow = Pattern.compile( "(-?[\\d.]+)(\\^)(-?[\\d.]+)" );//степень удаленно из начала (?:-|\+)
        Pattern sinCosTan = Pattern.compile( "()(sin|cos|tan)(-?[\\d.]+)" );//тригонометрия
        Pattern mulDv = Pattern.compile( "(-?[\\d.]+)([*/])(-?[\\d.]+)" );//умножение деление
        Pattern additive = Pattern.compile( "(-?[\\d.]+)?([+M])(-?[\\d.]+)" );//сложение вычитание
        Pattern plusser = Pattern.compile( "()(--)([\\d.]+)" );//поиск двойных плюсов после различных операций
        Pattern round = Pattern.compile( "(-?[\\d.]+)" );//поиск готовых цифр для округления


        if(countOperation == 0){//добавляем унарные минусы в качестве операций возможно не потреб-ся. переименовываем все - в М
            Matcher matcher = mindetect.matcher(temp);
            temp = temp.replaceAll("-","M");//теперь все необработанные - это M
        }
        temp = temp.replaceAll(" +", "");//выпиливаем пробелы

        String calctemp = temp;
        int start = 0;
        int end = calctemp.length();

        Matcher mathPar = patPar.matcher(temp);//поехали! скобки
        if (mathPar.find()) { //возвращает true, если в строке есть подстрока, которая совпадает с шаблоном, и переходит к этой подстроке
            calctemp = mathPar.group(1); // не понимаю почему в параметрах 1 , возвращает подстроку, которая совпала с шаблоном в результате вызова метода find. Если совпадение отсутствует, то метод генерирует исключение IllegalStateException.
            start = mathPar.start() + 1; // не понимаю почему +1, возвращает индекс текущего совпадения
            end = mathPar.end() - 1; // не понимаю почему -1, возвращает индекс следующего совпадения после текущего
        }

        String result = calc(calctemp, sinCosTan);//тригонометрия
        if (!result.equals("")) {
            countOperation++;
            temp = temp.substring(0,start) + result + (temp.length() == end? "" :temp.substring(end));
            recurse(temp, countOperation);
            return;
        }

        result = calc(calctemp, pow);//степень
        if (!result.equals("")) {
            countOperation++;
            temp = temp.substring(0,start) + result + (temp.length() == end? "" :temp.substring(end));
            recurse(temp, countOperation);
            return;
        }

        result = calc(calctemp, mulDv);
        if (!result.equals("")) {
            countOperation++;
            temp = temp.substring(0,start) + result + (temp.length() == end? "" :temp.substring(end));
            recurse(temp, countOperation);
            return;
        }
        result = calc(calctemp, plusser);
        if (!result.equals("")) {
            temp = temp.substring(0,start) + result + (temp.length() == end? "" :temp.substring(end));
            recurse(temp, countOperation);
            return;
        }

        result = calc(calctemp, additive);
        if (!result.equals("")) {
            countOperation++;
            temp = temp.substring(0,start) + result + (temp.length() == end? "" :temp.substring(end));
            recurse(temp, countOperation);
            return;
        }

        mathPar = patrem.matcher(temp);
        if (mathPar.find()) {
            temp = temp.substring(0,start - 1) + mathPar.group(1) + temp.substring(end + 1);;
            recurse(temp, countOperation);
            return;
        }
        NumberFormat nf = new DecimalFormat("#.##");
        Double d = Double.parseDouble(temp);
        System.out.println(String.format("%s %d", nf.format(d),countOperation).replace(",","."));

    }
//----------------------------------------------------------------------------------------------------------------------
    private String calc(String temp, Pattern pattern) {

        String result = "";
        String temporar = new String(temp);
        Matcher matcher = pattern.matcher(temporar);

        if (matcher.find()) {
            result = temporar.replaceFirst(pattern.pattern(), numerate(matcher));
        }
        return result;
    }
//----------------------------------------------------------------------------------------------------------------------
    private String numerate(Matcher matcher) {
        HashMap<String, DoubleBinaryOperator> hashMap = new HashMap();
        hashMap.put("*", (DoubleBinaryOperator) (double a, double b) -> a * b);
        hashMap.put("/", (DoubleBinaryOperator) (double a, double b) -> a / b);
        hashMap.put("M", (DoubleBinaryOperator) (double a, double b) -> a - b);
        hashMap.put("+", (DoubleBinaryOperator) (double a, double b) -> a + b);
        hashMap.put("++", (DoubleBinaryOperator) (double a, double b) -> b);
        hashMap.put("M-", (DoubleBinaryOperator) (double a, double b) -> b);
        hashMap.put("^", (DoubleBinaryOperator) (double a, double b) -> Math.pow(a, b));
        hashMap.put("cos", (DoubleBinaryOperator) (double a, double b) -> Math.cos(Math.toRadians(b)));
        hashMap.put("sin", (DoubleBinaryOperator) (double a, double b) -> Math.sin(Math.toRadians(b)));
        hashMap.put("tan", (DoubleBinaryOperator) (double a, double b) -> Math.tan(Math.toRadians(b)));
        String left = "0";
        String right = "0";
        String prefix = "";
        boolean unar;
        try {
            left = matcher.group(1).equals("") ? "0" : matcher.group(1);
        } catch (Exception e) {
        }
        try {
            right = matcher.group(3).equals("") ? "0" : matcher.group(3);
        } catch (Exception e) {
        }

        Double dleft = Double.parseDouble(left);
        Double dright = Double.parseDouble(right);
        Double result = hashMap.get(matcher.group(2)).applyAsDouble(dleft, dright);

        NumberFormat nf = new DecimalFormat("#.##");

        return String.format("%s", nf.format(result)).replace(",",".");
    }
//----------------------------------------------------------------------------------------------------------------------
    public Solution() {
        //don't delete
    }
}

//import java.text.DecimalFormat;
//import java.util.*;
//
///*
//Рекурсия для мат. выражения
//*/
//public class Solution {
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//     //   solution.recurse("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
//        solution.recurse("tan(2025 ^ 0.5)", 0);  //expected output 1 2
//    }
//    // Вспомогательные методы для token
////----------------------------------------------------------------------------------------------------------------------
//    private static String delimiters() { return "()" + operators(); }
//    private static String operators() { return "+-*/^"; }
//    private static boolean isOperator(String token) {
//        if (token.equals("u-")) return true; // унарный минус
//        for (int i = 0; i < operators().length(); i++) { // проходим по операторам "+-*/^"
//            if (token.charAt(0) == operators().charAt(i)) return true; // ищем совпадения параметра (String token;) и "+-*/^"
//        }
//        return false;
//    }
//    private static boolean isFunction(String token) { return token.equals("sin") || token.equals("cos") || token.equals("tan"); } // ищем совпадения параметра  и функций
//    private static boolean isDelimiter(String token) { // поиск скобок
//        if (token.length() != 1) return false;
//        for (int i = 0; i < delimiters().length(); i++) {
//            if (token.charAt(0) == delimiters().charAt(i)) return true; // ищет скобки - совпадает ли параметр (String token) со скобками в методе delimiters();
//        }
//        return false;
//    }
//    private static int priority(String token) {
//        switch (token) {
//            case "(":
//                return 0;
//            case "+":
//            case "-":
//                return 1;
//            case "*":
//            case "/":
//                return 2;
//            case "^":
//                return 3;
//        }
//        return 4;
//    }
//    //----------------------------------------------------------------------------------------------------------------------
////----------------------------------------------------------------------------------------------------------------------
//    public void recurse(final String expression, int countOperation) {
//        //implement
//        Locale.setDefault(Locale.ENGLISH); // утанавливает по умолчанию кодовую страницу English
//
//        if (countOperation > 0){ // если колличество операций больше нуля
//            System.out.println(expression + " " + countOperation);
//        }
//        else {
//            List<String> out = new ArrayList<>();
//            Deque<String> stringArrayDeque = new ArrayDeque<>(); //очередь лексем и операторов
//            Deque<Double> doubleArrayDeque = new ArrayDeque<>(); // очередь цифр
//            // Разложение строки , убираем пробелы, делаем все буквы маленькими, и делим через функции deLimiters(); -> operators(); - сами функции ниже
//            StringTokenizer tokenizer = new StringTokenizer(expression.replace(" ", "").toLowerCase(), delimiters(), true);
//            String strPrev = "";
//            String strCurr = ""; // лексемы
////-----------------------------------------------------------------------------------------------------------------------
//            while (tokenizer.hasMoreTokens()) { // Функция определения наличия лексем (элементов). Возвращает true, если в строке еще есть слова, и false, если слов больше нет
//                strCurr = tokenizer.nextToken(); // Возвращает лексему (строку), на который указывает токенайзер согласно разделителя delim
//
//                if (!tokenizer.hasMoreTokens() && isOperator(strCurr)){ // если слов нет и лексема равна унарному минусу или "+-*/^"
//                    System.out.println("Некорректное выражение.");
//                    break;
//                }
//                if (isFunction(strCurr)) stringArrayDeque.push(strCurr); // если strCurr это sin, cos, tan то добавляет в начало очереди
//                else if (isDelimiter(strCurr)) { // проходим по строке и ищем скобки и другие операторы
//                    if (strCurr.equals("(")) stringArrayDeque.push(strCurr); // если открывающая скобка то добавляем в начало очереди
//                        //----
//                    else if (strCurr.equals(")")) { // если закрывающая скобка
//                        while (!stringArrayDeque.peek().equals("(")) { // возвращает без удаления и сравнивает с открывающей скобкой "("
//                            out.add(stringArrayDeque.pop()); // возвращает с удалением элемента из очереди и  элемент добавляет в коллекцию out
//                            if (stringArrayDeque.isEmpty()) { // если очередь пуста
//                                System.out.println("Скобки не согласованы.");
//                            }
//                        }
//                        stringArrayDeque.pop(); // возвращает с удалением элемента из очереди
//                        if (!stringArrayDeque.isEmpty() && isFunction(stringArrayDeque.peek())) { // peek(); -> peekFirst() возвращвет первый элемент
//                            out.add(stringArrayDeque.pop()); // возвращает с удалением элемента из очереди и  элемент добовляет в коллекцию out
//                        }
//                    }
//                    //------
//                    else {
//                        if (strCurr.equals("-") && (strPrev.equals("") || (isDelimiter(strPrev) && !strPrev.equals(")")))) {
//                            strCurr = "u-"; // тогда curr  унарный минус
//                        }
//                        else {
//                            while (!stringArrayDeque.isEmpty() && (priority(strCurr) <= priority(stringArrayDeque.peek()))){
//                                out.add(stringArrayDeque.pop());
//                            }
//                        }
//                        stringArrayDeque.push(strCurr);
//                    }
//                }
//
//                else {
//                    out.add(strCurr);
//                }
//                strPrev = strCurr;
//            }
////----------------------------------------------------------------------------------------------------------------------
//            while (!stringArrayDeque.isEmpty()) {
//                if (isOperator(stringArrayDeque.peek())) out.add(stringArrayDeque.pop());
//                else {
//                    System.out.println("Скобки не согласованы.");
//                    break;
//                }
//            }
//            for (String x: out){
//                switch (x) {
//                    case "sin":
//                        doubleArrayDeque.push(Math.sin(Math.toRadians(doubleArrayDeque.pop())));
//                        countOperation++;
//                        break;
//                    case "cos":
//                        doubleArrayDeque.push(Math.cos(Math.toRadians(doubleArrayDeque.pop())));
//                        countOperation++;
//                        break;
//                    case "tan":
//                        doubleArrayDeque.push(Math.tan(Math.toRadians(doubleArrayDeque.pop())));
//                        countOperation++;
//                        break;
//                    case "^": {
//                        Double b = doubleArrayDeque.pop(), a = doubleArrayDeque.pop();
//                        doubleArrayDeque.push(Math.pow(a, b));
//                        countOperation++;
//                        break;
//                    }
//                    case "+":
//                        doubleArrayDeque.push(doubleArrayDeque.pop() + doubleArrayDeque.pop());
//                        countOperation++;
//                        break;
//                    case "-": {
//                        Double b = doubleArrayDeque.pop(), a = doubleArrayDeque.pop();
//                        doubleArrayDeque.push(a - b);
//                        countOperation++;
//                        break;
//                    }
//                    case "*":
//                        doubleArrayDeque.push(doubleArrayDeque.pop() * doubleArrayDeque.pop());
//                        countOperation++;
//                        break;
//                    case "/": {
//                        Double b = doubleArrayDeque.pop(), a = doubleArrayDeque.pop();
//                        doubleArrayDeque.push(a / b);
//                        countOperation++;
//                        break;
//                    }
//                    case "u-":
//                        doubleArrayDeque.push(-doubleArrayDeque.pop());
//                        countOperation++;
//                        break;
//                    default:
//                        doubleArrayDeque.push(Double.valueOf(x));
//                        break;
//                }
//            }
//
//            recurse(new DecimalFormat("#.##").format(doubleArrayDeque.pop()), countOperation);
//        }
//    }
//    //----------------------------------------------------------------------------------------------------------------------
////----------------------------------------------------------------------------------------------------------------------
//    public Solution() {
//        //don't delete
//    }
//}





// ВАЛИК РУГАЕТСЯ НЕТ РЕКУРСИИ
//------------------------------------------------------------------------------------------------------------------------
//package com.javarush.task.task34.task3404;
//
//import java.util.ArrayList;
//import java.util.List;
//
///*
//Рекурсия для мат. выражения
//*/
//public class Solution {
//    //------------------------------------------------------------------------------------------------------------------
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.recurse("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
//    }
//    //------------------------------------------------------------------------------------------------------------------
//    public void recurse(final String expression, int countOperation) {
//        //implement
//        List<Lexeme> lexemes = new ArrayList<>(); // хранилище объектов лексем
//        countOperation = lexAnalyze(lexemes, expression); // колличество математических операций
//
//        // получение и вывод результата
//        LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes); // заполняем конструктор объекта коллекцией с лексемами
//        double result = Math.round(endMetod(lexemeBuffer) * 100) / 100.0; // округление результата
//        if (result % 1.0 == 0.0) // определяет есть ли дробная часть
//            System.out.println((long)result + " " + countOperation);
//        else
//            System.out.println(result + " " + countOperation);
//    }
//
////----------------------------------------------------------------------------------------------------------------------
//// вспомогательный класс для представления отдельной лексемы
//    private static class Lexeme {
//        private TokenType type;
//        private double value;
//        private String title;
//
//        public Lexeme(TokenType type, char title) {
//            this.type = type;
//            value = Double.NaN;
//            this.title = String.valueOf(title);
//        }
//
//        public Lexeme(TokenType type, double value) { // для дробных чисел
//            this.type = type;
//            this.value = value;
//            title = String.valueOf(value);
//        }
//
//        public Lexeme(TokenType type, String title) {
//            this.type = type;
//            value = Double.NaN;
//            this.title = title;
//        }
//    }
//    //------------------------------------------------------------------------------------------------------------------
//    // класс обертка для перемещения по списку токенов
//    private static class LexemeBuffer {
//        private List<Lexeme> arrLexemes;
//        private int i;
//
//        public LexemeBuffer(List<Lexeme> arrLexemes) {
//            this.arrLexemes = arrLexemes;
//        }
//
//        public Lexeme next() {
//            return arrLexemes.get(i++);
//        }
//
//        public void back() {
//            i--;
//        }
//
//        public int getIndex() {
//            return i;
//        }
//    }
//    //----------------------------------------------------------------------------------------------------------------------
//    private enum TokenType {
//        ADD, SUB,           // сложение, вычитание
//        MUL, DIV,           // умножение, деление
//        POW,                // степень
//        NUM,                // число
//        L_BR, R_BR,         // левая скобка, правая скобка
//        COS, SIN, TAN,      // тригонометрические функции
//        EOF                 // конец выражения
//    }
//    //----------------------------------------------------------------------------------------------------------------------
//    // лексический анализ - разбор выражения на лексемы (токены)
//    public static int lexAnalyze(List<Lexeme> lexemes, String expression) {
//        int countOperation = 0; // будет подсчитывать колличество операция
//
////        List<Token> tokens = new ArrayList<>();
//        char[] arr = expression.toCharArray(); // строку втсавляем в массив символов
//        int i = 0;
//        while (i < arr.length) {
//            switch (arr[i]) {
//                case ' ':
//                    i++;
//                    break;
//
//                case '+':
//                    lexemes.add(new Lexeme(TokenType.ADD, arr[i]));
//                    i++;
//                    countOperation++;
//                    break;
//
//                case '-':
//                    lexemes.add(new Lexeme(TokenType.SUB, arr[i]));
//                    i++;
//                    countOperation++;
//                    break;
//
//                case '*':
//                    lexemes.add(new Lexeme(TokenType.MUL, arr[i]));
//                    i++;
//                    countOperation++;
//                    break;
//
//                case '/':
//                    lexemes.add(new Lexeme(TokenType.DIV, arr[i]));
//                    i++;
//                    countOperation++;
//                    break;
//
//                case '^':
//                    lexemes.add(new Lexeme(TokenType.POW, arr[i]));
//                    i++;
//                    countOperation++;
//                    break;
//
//                case '(':
//                    lexemes.add(new Lexeme(TokenType.L_BR, arr[i]));
//                    i++;
//                    break;
//
//                case ')':
//                    lexemes.add(new Lexeme(TokenType.R_BR, arr[i]));
//                    i++;
//                    break;
//
//                case '.':
//                case '0': case '1': case '2': case '3': case '4':
//                case '5': case '6': case '7': case '8': case '9':
//                    if (arr[i] == '.' &&                                       // если первый символ десятичный разделитель и
//                            (i + 1 >= arr.length ||                            // это последний символ выражения или
//                                    arr[i + 1] < '0' || arr[i + 1] > '9'))    // следующий символ не цифра
//                        throw new RuntimeException("Unexpected character: " + arr[i] + " at position " + i);
//                    double value = 0.0;
//                    for ( ; i < arr.length && arr[i] >= '0' && arr[i] <= '9'; i++)
//                        value = 10 * value + (arr[i] - '0');                   // накопление целой части
//                    if (i < arr.length && arr[i] == '.') {
//                        i++;
//                        double factor = 1.0;                                    // множитель для десятичных разрядов
//                        for ( ; i < arr.length && arr[i] >= '0' && arr[i] <= '9'; i++) {
//                            factor *= 0.1;                                      // уменьшение множителя в 10 раз
//                            value += (arr[i] - '0') * factor;                  // добавление десятичной позиции
//                        }
//                    }
//                    lexemes.add(new Lexeme(TokenType.NUM, value));
//                    break;
//
//                default: // расспозаём cos, sin, tan и загружжаем их в массив lexemes
//                    if (i + 3 < arr.length &&
//                            arr[i] == 'c' && arr[i + 1] == 'o' && arr[i + 2] == 's' && arr[i + 3] == '(') {
//                        lexemes.add(new Lexeme(TokenType.COS, "cos("));
//                        i += 4;
//                        countOperation++;
//                    }
//                    else if (i + 3 < arr.length &&
//                            arr[i] == 's' && arr[i + 1] == 'i' && arr[i + 2] == 'n' && arr[i + 3] == '(') {
//                        lexemes.add(new Lexeme(TokenType.SIN, "sin("));
//                        i += 4;
//                        countOperation++;
//                    }
//                    else if (i + 3 < arr.length &&
//                            arr[i] == 't' && arr[i + 1] == 'a' && arr[i + 2] == 'n' && arr[i + 3] == '(') {
//                        lexemes.add(new Lexeme(TokenType.TAN, "tan("));
//                        i += 4;
//                        countOperation++;
//                    }
//                    else
//                        throw new RuntimeException("Unexpected character: " + arr[i] + " at position " + i);
//                    break;
//            }
//        } // конец оператора while -------------------------------------------------------------------------------------
//        if (lexemes.size() == 0)                                                 // если выражение пустое
//            lexemes.add(new Lexeme(TokenType.NUM, 0.0));                    // оно равно нулю
//        lexemes.add(new Lexeme(TokenType.EOF, ""));
////        return tokens;
//
//        return countOperation;
//    }
//    //------------------------------------------------------------------------------------------------------------------
//    // Грамматика:
//    // endMetod : add_sub EOF
//    // add_sub : mul_div ( ( '+' | '-' ) mul_div )*
//    // mul_div : pow ( ( '*' | '/' ) pow )*
//    // pow : primary ( '^' primary )*
//    // startMetod : NUM | '-' pow | ( '(' | 'cos(' | 'sin(' | 'tan(' ) add_sub ')'
////----------------------------------------------------------------------------------------------------------------------
//    // endMetod : add_sub EOF
//    public static double endMetod(LexemeBuffer lexemeBuffer) {
//        double value = add_sub(lexemeBuffer); // значение которе возвращает метод add_sub();
//        Lexeme lexeme = lexemeBuffer.next(); // следующая позиция в массиве arrLexemes
//        if (lexeme.type != TokenType.EOF) // если коонец строки
//            throw new RuntimeException("Unexpected token: " + lexeme.title + " at position " + lexemeBuffer.getIndex());
//        return value; // и возвращем число double
//    }
//        // add_sub : mul_div ( ( '+' | '-' ) mul_div )*
//    public static double add_sub(LexemeBuffer lexemeBuffer) {
//        double value = mul_div(lexemeBuffer); // значение которе возвращает метод mul_div();
//        while (true) {
//            Lexeme lexeme = lexemeBuffer.next(); // следующая позиция в массиве arrLexemes
//            switch (lexeme.type) {
//                case ADD: // если сложение
//                    value += mul_div(lexemeBuffer); // делаем сложение
//                    break;
//                case SUB: // если вычитание
//                    value -= mul_div(lexemeBuffer); // делаем вычитание
//                    break;
//                default:
//                    lexemeBuffer.back(); // возвращаемся на одну позицию
//                    return value; // и возвращем число double
//            }
//        }
//    }
//    // mul_div : pow ( ( '*' | '/' ) pow )*
//    public static double mul_div(LexemeBuffer lexemeBuffer) {
//        double value = pow(lexemeBuffer); // значение которе возвращает метод pow();
//        while (true) {
//            Lexeme lexeme = lexemeBuffer.next(); // следующая позиция в массиве arrLexemes
//            switch (lexeme.type) {
//                case MUL: // если умножение
//                    value *= pow(lexemeBuffer); // делаем умножение
//                    break;
//                case DIV: // если деление
//                    value /= pow(lexemeBuffer); // делаем деление
//                    break;
//                default: // если ничего нет из перечисленного
//                    lexemeBuffer.back(); // возвращаемся на одну позицию
//                    return value; // и возвращем число double
//            }
//        }
//    }
//        // pow : startMetod ( '^' startMetod )*
//    public static double pow(LexemeBuffer lexemeBuffer) {
//        double value = startMetod(lexemeBuffer); // значение которе возвращает метод startMetod();
//        while (true) {
//            Lexeme lexeme = lexemeBuffer.next(); // следующая позиция в массиве arrLexemes
//            switch (lexeme.type) {
//                case POW: // если есть возведение в степень
//                    value = Math.pow(value, startMetod(lexemeBuffer)); // возведение в степень
//                    break;
//                default: // если нет возведении в степень
//                    lexemeBuffer.back(); // отступаем на одну позицию назад в массиве arrLexemes
//                    return value;
//            }
//        }
//    }
//        // startMetod : NUM | '-' pow | ( '(' | 'cos(' | 'sin(' | 'tan(' ) add_sub ')'
//    public static double startMetod(LexemeBuffer lexemeBuffer) {
//        Lexeme lexeme = lexemeBuffer.next(); // следующая позиция в массиве arrLexemes
//        switch (lexeme.type) {
//            case NUM:                       // если число
//                return lexeme.value;        // если число то возвращаем double в методе startMetod();
//            case SUB:                       // если вычитание
//                return - pow(lexemeBuffer); // , то передаём в метод pow();
//            case L_BR:                      // если левая скобка
//            case COS: case SIN: case TAN:   // и если cos, sin, tan
//                double value = 0.0;
//                if (lexeme.type == TokenType.L_BR)
//                    value = add_sub(lexemeBuffer);
//                else if (lexeme.type == TokenType.COS)
//                    value = Math.cos(Math.toRadians(add_sub(lexemeBuffer)));
//                else if (lexeme.type == TokenType.SIN)
//                    value = Math.sin(Math.toRadians(add_sub(lexemeBuffer)));
//                else if (lexeme.type == TokenType.TAN)
//                    value = Math.tan(Math.toRadians(add_sub(lexemeBuffer)));
//                lexeme = lexemeBuffer.next();
//                if (lexeme.type != TokenType.R_BR) // если нет правой скобки
//                    throw new RuntimeException("Unexpected token: " + lexeme.title + " at position " + lexemeBuffer.getIndex());
//                return value;            // результат cos, sin, tan возвращаем double в методе startMetod();
//            default:                    // если нет ничего из перечисленных сверху
//                throw new RuntimeException("Unexpected token: " + lexeme.title + " at position " + lexemeBuffer.getIndex());
//        }
//    }
//
//    public Solution() {
//        //don't delete
//    }
//}