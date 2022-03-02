package se.yrgo.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import javax.swing.JPanel;

public class GameSurface extends JPanel implements KeyListener {
    private static final long serialVersionUID = 1260582674762246325L;
    
    private final SinusBox sinus = new SinusBox();
    private final AccelBox accel = new AccelBox();

    public GameSurface() {
        Timer timer = new Timer(16, e -> {
            long time = System.nanoTime();
            sinus.tick(time);
            accel.tick(time);
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        final Dimension d = this.getSize();
        
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, d.width, d.height);

        sinus.paint(g);
        accel.paint(g);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        final int kc = e.getKeyCode();
        if (kc == KeyEvent.VK_SPACE) {
            final long time = System.nanoTime();
            sinus.jump(time);
            accel.jump(time);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // do nothing
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // do nothing
        
    }
}
