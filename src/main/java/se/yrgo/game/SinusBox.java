package se.yrgo.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.Serializable;

public class SinusBox implements Serializable {
    private static final long serialVersionUID = 126058262246325L;

    private static final long JUMP_TIME_NS = 1_500_000_000L; // 1.5 seconds
    private static final int JUMP_HEIGHT_PX = 100;

    private final Rectangle box = new Rectangle(100, 180, 40, 40);
    private int jumpHeight = 0;
    private long jumpStart = 0;

    public void jump(long time) {
        if (jumpStart == 0) {
            jumpStart = time;
        }
    }

    public void tick(long time) {
        if (jumpStart != 0) {
            // ns since start of jump
            long diff = time - jumpStart;

            double input = (diff / (double)JUMP_TIME_NS) * StrictMath.PI;
            double output = Math.sin(input) * JUMP_HEIGHT_PX;

            if (output < 0) {
                jumpStart = 0;
                jumpHeight = 0;
            }
            else {
                jumpHeight = (int) output;
            }
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int)box.getX(), (int)box.getY() - jumpHeight, (int)box.getWidth(), (int)box.getHeight());
    }
}
