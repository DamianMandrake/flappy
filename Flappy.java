import java.applet.Applet;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.Graphics;
import java.awt.Color;
import core.Bird;
import core.Repainter;


/* <applet code="Flappy.class" height="300" width="200" >
</applet>*/
public class Flappy extends Applet {
	private int initialXVelocity=0,initialYVelocity=0;
	private int gravity=2;
	private Bird bird;
	private final static int midH=150,midW=100,initRad=50;
	private final static int DELAY=300;
	Repainter repainter=null;
	@Override
	public void init(){
		this.addKeyListener();
		this.requestFocus();


		
		this.bird=new Bird(Flappy.initRad,Flappy.midH,Flappy.midW,gravity,Color.RED);
	}


	private void addKeyListener(){
		this.addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent ke){

				switch(ke.getKeyChar()){
					case KeyEvent.VK_SPACE:
					Flappy.this.bird.goUp();
					System.out.println("oh the space");
					if(Flappy.this.repainter==null)
						Flappy.this.repainter=new Repainter(Flappy.this,Flappy.DELAY);			
				}

			}
		});
	}

	@Override
	public void paint(Graphics g){
		bird.paintTheBird(g);
	}


	@Override
	public void repaint(){
		super.repaint();
		this.bird.goDown();
		/* changing a few params*/

	}

	@Override
	public void destroy(){

	}


}