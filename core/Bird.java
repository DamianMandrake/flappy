package core;
import java.awt.Color;
import java.awt.Graphics;
public class Bird{
	private int radius;
	private double x,y;
	private final static int xIncrement=10,yIncrement=10;
	private int gravity=10;
	private Color defaultColor=Color.RED;
	private int maxY=300;
	public Bird(final int radius,final int initialX,final int initialY,final int gravity,Color c,int maxY){
		this.radius=radius;
		this.x=initialX;
		this.y=initialY;
		this.gravity=gravity;
		this.defaultColor=c;
		this.maxY=maxY;
	}

	public void goUp(){
		this.y= this.y-(this.y/	yIncrement*gravity);

	}
	public double getX(){
		return this.x;

	}
	public double getY(){
		return this.y;
	}
	/* to be called everytime ... */
	public void goDown(){
		if(this.y < this.maxY - 100){

			this.y= this.y+(yIncrement *gravity) ;
			System.out.println("y changed to "+y);
			return ;
		}
		/* todo end the game */
	}




	public void paintTheBird(Graphics g){
		g.setColor(this.defaultColor);
		g.fillOval((int)this.x,(int)this.y,this.radius,this.radius);
		g.setColor(Color.BLACK);
	}


}