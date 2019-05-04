import java.util.Random;

public class Barrel {
	private int coorX,
				coorY;
	private int[] optionsDirection;
	
	public Barrel() {
		coorX = 120;
		coorY = 155;
		this.optionsDirection = new int[5];
		Random rnd = new Random();
		for (int i = 0;i<5;i++) {
			if(i==0 || i==3 || i==4) {
				this.optionsDirection[i] = rnd.nextInt(3);
			} else if (i==1 || i==2) {
				this.optionsDirection[i] = rnd.nextInt(4);			
			}
		}
	}
	public int getCoorX() {
		return this.coorX;
	}
	public int getCoorY() {
		return this.coorY;
	}
	public void addCoorX(int coord) {
		this.coorX += coord;
	}
	public void addCoorY(int coord) {
		this.coorY += coord;
	}
	
	public int[] getOptionsDirection() {
		return this.optionsDirection;
	}
	
	public void setCoorX(int coord) {
		this.coorX = coord;
	}
	
	public void setCoorY(int coord) {
		this.coorY = coord;
	}
}
