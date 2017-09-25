package core;
import java.applet.Applet;
public class Repainter extends Thread{
	private Applet applet;
	private final static String NAME="Repainter";
	private boolean shouldRepaint;
	private int delay=30;
	 public Repainter(Applet applet,int delay){
		super(Repainter.NAME);
		this.applet=applet;
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
				this.applet.repaint();
			}
		}
	}


}