import service.ShipService;

public class ShipCounter {
    ShipService shipService = new ShipService(ships);

    static int[][] ships = {
            {0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, // 0
            {0, 1, 0, 0, 0, 0, 0, 1, 0, 0}, // 1
            {0, 1, 0, 1, 1, 0, 0, 0, 0, 0}, // 2
            {0, 1, 0, 1, 1, 0, 0, 1, 1, 1}, // 3
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, // 4
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // 5
            {1, 1, 1, 1, 0, 1, 0, 0, 0, 0}, // 6
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // 7
            {1, 1, 0, 0, 0, 0, 0, 1, 0, 0}, // 8
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 1}  // 9
    };    // 0  1  2  3  4  5  6  7  8  9

    public int getShipCount() {
        int countShips = shipService.getCountOfShips();
        System.out.println("We found " + countShips + " ships");
        return countShips;
    }
}
