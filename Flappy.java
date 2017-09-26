import java.applet.Applet;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.Graphics;
import java.awt.Color;

import java.awt.Dimension;
import java.awt.Frame;


import core.Bird;
import core.Repainter;
import core.RectangleManager;
import core.Rectangles;
/* <applet code="Flappy.class" height="300" width="200" >
</applet>*/
public class Flappy extends Frame {
	private int initialXVelocity=0,initialYVelocity=0;
	private int gravity=2;
	private Bird bird;
	private RectangleManager rectangleManager;
	private final static int midH=200,midW=200,initRad=50,xDim=400,yDim=400;
	private final static int DELAY=100;
	Repainter repainter=null;
	
	public Flappy(){
		this.init();
	}


	private void init(){
		this.addKeyListener();
		this.requestFocus();
		this.setResizable(false);
		Rectangles.setMaxX(Flappy.xDim);
		this.rectangleManager=new RectangleManager(Flappy.yDim,Flappy.initRad);

		this.setSize(Flappy.xDim,Flappy.yDim);
		this.setVisible(true);
		this.bird=new Bird(Flappy.initRad,Flappy.midH,Flappy.midH,gravity,Color.RED,yDim);
	}


	private void addKeyListener(){
		this.addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent ke){

				switch(ke.getKeyChar()){
					case KeyEvent.VK_SPACE:
					Flappy.this.bird.goUp();
					/* will change this... have setShouldRepaint in Repainter...*/
					if(Flappy.this.repainter==null)
						Flappy.this.repainter=new Repainter(Flappy.this,Flappy.DELAY);			
				}

			}
		});
	}

	@Override
	public void paint(Graphics g){
		bird.paintTheBird(g);
		this.rectangleManager.paintThemAll(g);
	}


	@Override
	public void repaint(){
		super.repaint();
		this.bird.goDown();
		/* changing a few params*/

	}
	/*@Override
	public void destroy(){

	}*/

	

	public static void main(String arp[]){
		new Flappy();
	}


}