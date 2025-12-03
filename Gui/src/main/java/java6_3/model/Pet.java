package java6_3.model;

import java.util.ArrayList;
import java.util.List;

public class Pet {
    private final List<double[]> segments = new ArrayList<>();
    private final double speed = 3.0;

    public Pet(double x, double y) {
        segments.add(new double[]{x, y});
    }

    public List<double[]> getSegments() {
        return segments;
    }

    public void moveTowards(double targetX, double targetY) {
        double[] head = segments.get(0);
        double dx = targetX - head[0];
        double dy = targetY - head[1];
        double dist = Math.sqrt(dx * dx + dy * dy);

        if (dist > speed) {
            head[0] += dx / dist * speed;
            head[1] += dy / dist * speed;
        } else {
            head[0] = targetX;
            head[1] = targetY;
        }
    }
}
