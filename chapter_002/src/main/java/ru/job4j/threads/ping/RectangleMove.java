package ru.job4j.threads.ping;

import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {
    private final Rectangle rect;
    private int vSpeed = 3;
    private int hSpeed = 3;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            if (this.rect.getX() >= 290 || this.rect.getX() <= 0) {
                hSpeed *= -1;
            }
            if (this.rect.getY() >= 290 || this.rect.getY() <= 0) {
                vSpeed *= -1;
            }
            this.rect.setX(this.rect.getX() + hSpeed);
            this.rect.setY(this.rect.getY() + vSpeed);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
