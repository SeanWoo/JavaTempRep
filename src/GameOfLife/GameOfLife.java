package GameOfLife;

import java.io.IOException;
import java.util.Random;

enum CellStatus {
    Dead,
    Life
}

public class GameOfLife {
    private int sizeX = 50;
    private int sizeY = 10;

    private CellStatus[][] _map = new CellStatus[sizeX][sizeY];
    private boolean stateChanged = false;

    public void Run() throws IOException, InterruptedException {
        //init
        var rnd = new Random();
        var startCellCount = (sizeX * sizeY) / 5;
        for (int i = 0; i < startCellCount; i++){
            var xCell = rnd.nextInt(sizeX);
            var yCell = rnd.nextInt(sizeY);
            _map[xCell][yCell] = CellStatus.Life;
        }

        //main loop
        while(true){
            handle();
            showMap();
            if (!stateChanged){
                System.out.println("Finish");
                break;
            }
            Thread.sleep(100);
        }
    }

    private void handle(){
        stateChanged = false;
        for (int y = 0; y < sizeY; y++){
            for (int x = 0; x < sizeX; x++){
                var count = getCountNeighbours(x, y);
                if (_map[x][y] == CellStatus.Life){
                    if (count < 2 || count > 3) {
                        _map[x][y] = CellStatus.Dead;
                        stateChanged = true;
                    }
                }
                else
                {
                    if (count == 3) {
                        _map[x][y] = CellStatus.Life;
                        stateChanged = true;
                    }
                }
            }
        }
    }

    private int getCountNeighbours(int x, int y){
        var count = 0;
        for (int cy = Math.max(y - 1, 0); cy <= Math.min(y + 1, sizeY - 1); cy++) {
            for (int cx = Math.max(x - 1, 0); cx <= Math.min(x + 1, sizeX - 1); cx++) {
                if (!(cy == y && cx == x) && _map[cx][cy] == CellStatus.Life)
                    count++;
            }
        }
        return count;
    }

    private void showMap() throws IOException {
        for (int y = 0; y < sizeY; y++) System.out.println("\n"); // тупейщий способ очистки консоли

        System.out.println("-".repeat(sizeX + 2));
        for (int y = 0; y < sizeY; y++){
            System.out.print('|');
            for (int x = 0; x < sizeX; x++){
                if (_map[x][y] == CellStatus.Life)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println('|');
        }
        System.out.println("-".repeat(sizeX + 2));
    }
}
