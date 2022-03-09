package se.yrgo.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.Serializable;

public class AccelBox implements Serializable {
    private static final long serialVersionUID = 126058262246325L;

    private static final double GRAVITY = 3;
    private static final double NANOSECOND = 1_000_000_000L;

    private final Rectangle box = new Rectangle(220, 180, 40, 40);
    private double velocity = 0;
    private long jumpStart = 0;

    // this is just here to keep it still until first jump
    private boolean started = false;

    public void jump(long time) {
        started = true;
        jumpStart = time;
        velocity = 25;
    }

    public void tick(long time) {
        if (!started) {
            return;
        }

        double deltaTime = ((time - jumpStart) / NANOSECOND);
        box.y -= velocity * deltaTime;
        velocity -= Math.min(20, GRAVITY * deltaTime);
    }

    public void paint(Graphics g) {
        g.setColor(Color.MAGENTA);
        g.fillRect((int)box.getX(), (int)box.getY(), (int)box.getWidth(), (int)box.getHeight());
    }
}
