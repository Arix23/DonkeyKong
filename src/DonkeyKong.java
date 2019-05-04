import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class DonkeyKong extends JFrame implements Runnable, KeyListener {
	public class Barrel {
		int x = 105;
		int y = 80;
	}
	public class Player {
		int x = 60;
		double y = 455;
		int speedX = 0;
		double speedY = 0;
		int lives = 5;
	}
	Barrel barrel = new Barrel();
	Player player = new Player();
	
	int[] ladderX = {
		(int)(Math.random() * 330 + 70),
		(int)(Math.random() * 330 + 45),
		(int)(Math.random() * 330 + 70),
		(int)(Math.random() * 330 + 45),
		(int)(Math.random() * 330 + 70)
	};
	boolean gameRunning = true;

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(25, 100, 360, 20);
		g.fillRect(50, 175, 360, 20);
		g.fillRect(25, 250, 360, 20);
		g.fillRect(50, 325, 360, 20);
		g.fillRect(25, 400, 360, 20);
		g.fillRect(50, 475, 360, 20);
		g.drawString("Lives: " + player.lives, 10, 20);
		g.setColor(Color.GREEN);
		g.fillRect(ladderX[0], 420, 20, 55);
		g.fillRect(ladderX[1], 345, 20, 55);
		g.fillRect(ladderX[2], 270, 20, 55);
		g.fillRect(ladderX[3], 195, 20, 55);
		g.fillRect(ladderX[4], 120, 20, 55);
		g.setColor(Color.BLACK);
		g.fillOval(barrel.x, barrel.y, 20, 20);
		g.setColor(Color.RED);
		g.fillRect(player.x, (int)player.y, 10, 20);
		if (!gameRunning) {
			for (int i = 0; i < 10000; i++) {
				g.setColor(new Color(0, 0, 0, 10));
				g.fillRect(0, 0, 448, 536);
				g.setColor(Color.RED);
				g.setFont(new Font("Press Start K", Font.PLAIN, 60)); 
				g.drawString("Wasted", 40, 320);
				try {
					Thread.sleep(20);
				} catch (InterruptedException Ex) {}
			}	
		}
	}
	@Override
	public void run() {
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		while(gameRunning) {
			if (barrel.y == 155 || barrel.y == 305 || barrel.y == 455) {
				barrel.x--;
			}
			if (barrel.y == 80 || barrel.y == 230 || barrel.y == 380) {
				barrel.x++;
			}
			if ((barrel.x == 30 && !(barrel.y == 80 || barrel.y == 230 || barrel.y == 380)) || (barrel.x == 385 && !(barrel.y == 155 || barrel.y == 305 || barrel.y == 455))) {
				barrel.y++;
			}
			if (barrel.y > 700) {
				barrel.x = 105;
				barrel.y = 80;
				player.lives--;
			}
			if (player.y > 700 || (Math.abs(player.y - barrel.y) < 30 && Math.abs(player.x - barrel.x) < 10)) {
				barrel.x = 105;
				barrel.y = 80;
				player.x = 60;
				player.y = 455;
				player.lives--;
			}
			if (!((player.x >= 50 && player.x <= 405 && ((player.y >= 155 && player.y <= 175) || (player.y >= 305 && player.y <= 225) || (player.y >= 455 && player.y <= 475))) || (player.x >= 5 && player.x <= 385 && ((player.y >= 80 && player.y <= 100) || (player.y >= 230 && player.y <= 250) || (player.y >= 380 && player.y <= 400))))) {
				player.speedY += .1;
			} else {
				player.speedY = 0;
			}
			if ((player.y > 380 && player.y < 420 && Math.abs(player.x - ladderX[0]) < 30) || (player.y > 305 && player.y < 345 && Math.abs(player.x - ladderX[1]) < 30) || (player.y > 230 && player.y < 270 && Math.abs(player.x - ladderX[2]) < 30) || (player.y > 800 && player.y < 120 && Math.abs(player.x - ladderX[3]) < 30)) {
				player.y--;
			}
			player.x += player.speedX;
			player.y += player.speedY;
			repaint();
			if (player.lives <= 0) {
				gameRunning = false;
			}
			try {
				Thread.sleep(3);
			} catch (InterruptedException Ex) {}
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 37) { // Left
			player.speedX -= 1;
		}
		if (e.getKeyCode() == 39) { // Right
			player.speedX += 1;
		}
		if (e.getKeyCode() == 38) { // Up
			if (((player.x >= 50 && player.x <= 405 && ((player.y >= 155 && player.y <= 175) || (player.y >= 305 && player.y <= 225) || (player.y >= 455 && player.y <= 475))) || (player.x >= 5 && player.x <= 385 && ((player.y >= 80 && player.y <= 100) || (player.y >= 230 && player.y <= 250) || (player.y >= 380 && player.y <= 400))))) {
				player.y -= 10;
				player.speedY -= 3;
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		player.speedX = 0;
	}
}