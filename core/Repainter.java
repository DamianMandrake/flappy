package core;
import java.awt.Container;
public class Repainter extends Thread{
	private Container container;
	private final static String NAME="Repainter";
	private boolean shouldRepaint;
	private int delay=30;
	/* repaint counter will tell me fps of the game*/
	private int repaintCounter=0;
	 public Repainter(Container container,int delay){
		super(Repainter.NAME);
		this.container=container;
		this.delay=delay;
		this.shouldRepaint=true;
		this.start();
	}

	public void setShouldRepaint(boolean b){
		this.shouldRepaint=b;
	}
	@Override
	public void run(){
		while(true){
			while(this.shouldRepaint){
				try{
					Thread.sleep(delay);
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
				this.repaintCounter++;
				System.out.println("repaint counter "+this.repaintCounter);
				if(repaintCounter%40==0){
					System.out.println("hit 40");

				}
				this.container.repaint();
			}
		}
	}


}