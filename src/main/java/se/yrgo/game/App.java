package se.yrgo.game;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        JFrame main = new JFrame("Jumping blocks");

        GameSurface gs = new GameSurface();

        main.setSize(400, 400);
        main.setResizable(false);
        main.add(gs);
        main.setDefaultCloseOperation(EXIT_ON_CLOSE);
        main.setVisible(true);
        main.addKeyListener(gs);
    }
}
