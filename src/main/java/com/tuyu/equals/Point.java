package com.tuyu.equals;

/**
 * 坐标点
 * @author tuyu
 * @date 7/17/18
 * Stay Hungry, Stay Foolish.
 */
public class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Point)) {
            return false;
        }
        Point oo = (Point) obj;

        return oo.x == x && oo.y == y;
    }
}
