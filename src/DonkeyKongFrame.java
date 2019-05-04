import javax.swing.JFrame;

public class DonkeyKongFrame extends JFrame {
	public DonkeyKongFrame() {
		super("Donkey Kong el juego");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(new DonkeyKongJuego());
		this.pack();
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		DonkeyKongFrame dk = new DonkeyKongFrame();
	}

}
