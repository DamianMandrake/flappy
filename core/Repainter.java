package core;
import java.awt.Container;
public class Repainter extends Thread{
	private Container container;
	private final static String NAME="Repainter";
	private boolean shouldRepaint;
	private int delay=30;
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
				this.container.repaint();
			}
		}
	}


}