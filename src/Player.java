
public class Player {
	private int coorX,
				coorY;
	
	public Player() {
		coorX = 54;
		coorY = 646;
	}
	
	public int getCoorX() {
		return this.coorX;
	}
	public int getCoorY() {
		return this.coorY;
	}
	public void addRightCoorX(int coord) {
		if(this.coorX < 578) {
			this.coorX+=coord;
		}	
	}
	public void addLeftCoorX(int coord) {
		if(this.coorX > 0) {
			this.coorX+=coord;
		}
	}
	public void addCoorY(int coord) {
		this.coorY+=coord;
	}
}
