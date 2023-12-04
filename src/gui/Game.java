package gui;

public class Game extends Thread {
	static public AquaFrame frame;
	static public boolean isRunning;
	static long threadNum;

	public static void main(String[] args) {//MAIN thread that run the game

		Game g = new Game();
		threadNum=Thread.currentThread().getId();
		g.start();
	}

	public Game() {
		frame = new AquaFrame();
		frame.work();
		isRunning = true;

	}

	//@Override
	public void run() {//run is painting the game non stop

		while (true) {
				frame.panel_2.repaint();
				try {
					this.sleep(10);
					frame.panel_2.repaint();
				} catch (InterruptedException e) {
					e.printStackTrace();

				}

			}
		}




}




