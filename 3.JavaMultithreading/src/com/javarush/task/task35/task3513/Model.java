package com.javarush.task.task35.task3513;
import java.util.*;

public class Model {
      private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    Stack<Tile[][]> previousStates = new Stack<>();
    Stack<Integer> previousScores = new Stack<>();
    protected int score;
    protected int maxTile;
    boolean isSaveNeeded = true;

    public Tile[][] getGameTiles() { return gameTiles; }

    public Model() {
        resetGameTiles();
    }
    // сохраняет последнии позиции игрового поля и очки
    private void  saveState (Tile[][] tiles) {
      //  Tile[][] tile = tiles.clone();
        Tile[][] tile = new Tile[tiles.length][tiles[0].length];
        for (int y = 0; y < tiles.length; y++) {
            for (int x = 0; x < tiles[0].length; x++) {
                tile[y][x] = new Tile(tiles[y][x].value);
            }
        }


        int newScore = score;
        previousStates.push(tile);
        previousScores.push(newScore);
        isSaveNeeded = false;
    }
    // выдаёт последнии позиции игрового поля и очки
    public void rollback () {
        if (previousStates.size() != 0 && previousScores.size() != 0) {
            gameTiles = previousStates.pop();
            score = previousScores.pop(); }
    }
    // Предлагаю создать приватный метод addTile, который будет смотреть какие плитки пустуют и,
    // если такие имеются, менять вес одной из них, выбранной случайным образом, на 2 или 4
    // (на 9 двоек должна приходиться 1 четверка). Получить случайный объект из списка можешь
    // использовав следующее выражение:
    //(размер Списка * случайное Число От Нуля До Единицы).
    private void addTile() {
        List<Tile> array = getEmptyTiles();
        if (array.size() == 0) {
            return;
        }
        int a = (int) (Math.random() * array.size());
        Tile tile = array.get(a);
        int b = Math.random() < 0.9 ? 2 : 4;
        tile.value = b;
    }
    // Также получение свободных плиток можно вынести в отдельный приватный метод getEmptyTiles,
// возвращающий список свободных плиток в массиве gameTiles.
    private List<Tile> getEmptyTiles() {
        ArrayList<Tile> array = new ArrayList<>();
        for (int x = 0; x < FIELD_WIDTH; x++) {
            for (int y = 0; y < FIELD_WIDTH; y++) {
                if (gameTiles[x][y].isEmpty()) {
                    array.add(gameTiles[x][y]);
                }
            }
        }
        return array;
    }
    protected void resetGameTiles() {
        // заполнения массива gameTiles новыми объектами типа Tile.
        for (int x = 0; x < FIELD_WIDTH; x++) {
            for (int y = 0; y < FIELD_WIDTH; y++) {
                gameTiles[x][y] = new Tile();
            }
        }
        addTile();
        addTile();
        score = 0;
        maxTile = 0;
    }
    // а) Сжатие плиток, таким образом, чтобы все пустые плитки были справа,
// т.е. ряд {4, 2, 0, 4} становится рядом {4, 2, 4, 0}
    private boolean compressTiles(Tile[] tiles) {
        Tile[] tileOld = new Tile[tiles.length];
        System.arraycopy(tiles, 0, tileOld, 0, tiles.length);

        Arrays.sort(tiles, (o1, o2) -> {
            if (!o1.isEmpty() && o2.isEmpty()) {
                return -1;
            } else return 0;
        });
        return !Arrays.equals(tiles, tileOld);
    }
    // б) Слияние плиток одного номинала, т.е. ряд {4, 4, 2, 0} становится рядом {8, 2, 0, 0}.
    //Обрати внимание, что ряд {4, 4, 4, 4} превратится в {8, 8, 0, 0}, а {4, 4, 4, 0} в {8, 4, 0, 0}.
    private boolean mergeTiles(Tile[] tiles) {
            boolean a = false;
        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].value == tiles[i + 1].value && !tiles[i].isEmpty()) {
                a = true;
                tiles[i].value += tiles[i + 1].value;
                tiles[i + 1].value = 0;
                compressTiles(tiles);
                score += tiles[i].value;

                if (tiles[i].value > maxTile) {
                    maxTile = tiles[i].value;
                }
            }
        }
        return a; }
        // метод разворачивает по часовой стрелки массив на 90 градусов
        private void rotateClock () {
        Tile [][] array = new Tile[gameTiles.length][gameTiles.length];
            for (int i = 0; i < gameTiles.length; i++) {
                for (int j = 0; j < gameTiles[i].length; j++) {
                    array[j][gameTiles.length - i - 1] = gameTiles[i][j];
                }
            }
            gameTiles = array;
    }
    //метод left, который будет для каждой строки массива gameTiles
    // вызывать методы compressTiles и mergeTiles и добавлять одну
    // плитку с помощью метода addTile в том случае, если это необходимо.
    protected void left() {
        if (isSaveNeeded){ saveState(gameTiles);}
        boolean a = false;
        for (int i = 0; i < gameTiles.length; i++) {
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) {
                a = true;}}

                if (a && getEmptyTiles().size() != 0) {
                    addTile();
                }
        isSaveNeeded = true;
            }
    // поворачиваем массив так что мог сработать метод left();
    public void right (){
        saveState(gameTiles);
       rotateClock();
       rotateClock();
        left();
       rotateClock();
       rotateClock();
    }
    public void up (){
       saveState(gameTiles);
       rotateClock();
       rotateClock();
       rotateClock();
       left();
       rotateClock();
    }
    public void down (){
       saveState(gameTiles);
       rotateClock();
       left();
       rotateClock();
       rotateClock();
       rotateClock();
    }
// метод canMove возвращающий true в случае, если в текущей позиции возможно сделать ход так,
// чтобы состояние игрового поля изменилось. Иначе - false.
    public boolean canMove () {
        for (int x = 0; x < gameTiles.length; x++){
            for (int y = 0; y < gameTiles[0].length; y++){
             if (gameTiles[x][y].value == 0) {return true;}
             if (x != 0 && (gameTiles[x - 1][y].value == gameTiles[x][y].value)) {return true;}
                if (y != 0 && (gameTiles[x][y - 1].value == gameTiles[x][y].value)) {return true;}
            }
        }
        return false;
    }
    // этот метод будет вызывать один из методов движения случайным образом.
    public void randomMove () {
        int n = ((int) (Math.random() * 100)) % 4;

        switch (n) {
            case (0): left(); break;
            case (1): right(); break;
            case (2): up(); break;
            case (3): down(); break;
        }
    }
    // будет возвращать true, в случае, если вес плиток в массиве gameTiles отличается от веса плиток в верхнем
    // массиве стека previousStates. Обрати внимание на то, что мы не должны удалять из стека верхний элемент, используй метод peek.
    public boolean hasBoardChanged () {
        int totalArray = 0;
        int totalStack = 0;

        for (int x = 0; x < gameTiles.length; x++) {
            for (int y = 0; y < gameTiles[x].length; y++) {
                totalArray += gameTiles[x][y].value;
            }
        }
            Tile[][]tiles = previousStates.peek();
        for (int x = 0; x < tiles.length; x++) {
            for (int y = 0; y < tiles[x].length; y++) {
                totalStack += tiles[x][y].value;
            }
        }
        if (totalArray != totalStack) return true;
        else return false;
            }
       //  принимает один параметр типа move, и возвращает объект типа MoveEfficiency описывающий эффективность переданного хода.
      public MoveEfficiency getMoveEfficiency (Move move) {
          move.move();

        if (hasBoardChanged()) {
            rollback();
            return new MoveEfficiency(getEmptyTiles().size(),  score, move);
        }
        rollback();
        return new MoveEfficiency(-1, 0, move);
    }
}






