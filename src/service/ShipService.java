package service;

import model.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShipService {

    public static final int SHIP_POSITION = 1;

    private int[][] arr;

    private List<Position> ship = new ArrayList<>();
    private Map<Integer, List<Position>> ships = new HashMap<>();

    private List<Position> allPoints = new ArrayList<>();

    private int count = 0;

    private final int maxRow;

    public ShipService(int[][] arr) {
        this.arr = arr;
        this.maxRow = arr.length - 1;
    }

    public boolean hasDown(int rowPosition, int columnPosition) {
        if (rowPosition < maxRow) {
            return arr[++rowPosition][columnPosition] == SHIP_POSITION;
        }

        return false;
    }

    private void calculation() {
        boolean isShip = false;

        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr[x].length; y++) {

                if (!isShip && !ship.isEmpty()) {
                    ships.put(count++, ship);
                    ship = new ArrayList<>();
                }

                if (!duplicatePosition(x, y) && containsShipPosition(x, y)) {
                    isShip = true;
                    if (hasDown(x, y)) {
                        calculateVertical(x, y);
                    } else {
                        addShip(x, y);
                    }

                    if (isFinalPoint(x, y)) {
                        ships.put(count++, ship);
                    }
                } else {
                    isShip = false;
                }
            }
        }

    }

    private void calculateVertical(int x, int y) {
        while (true) {
            if (!hasDown(x, y)) {
                addShip(x, y);
                break;
            }
            addShip(x++, y);
        }
    }

    private void addShip(int x, int y) {
        allPoints.add(new Position(x, y));
        ship.add(new Position(x, y));
    }

    public int getCountOfShips() {
        calculation();
        return this.count;
    }

    private boolean containsShipPosition(int x, int y) {
        return arr[x][y] == SHIP_POSITION;
    }

    private boolean duplicatePosition(int x, int y) {
        return allPoints.contains(new Position(x, y));
    }

    private boolean isFinalPoint(int x, int y) {
        return x == maxRow &&
                y == arr[maxRow].length - 1;
    }
}
