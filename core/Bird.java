package core;
import java.awt.Color;
import java.awt.Graphics;
public class Bird{
	private int radius;
	private double x,y;
	private final static int xIncrement=10,yIncrement=10;
	private int gravity=10;
	private Color defaultColor=Color.RED;
	private final static int MAXY=300;
	public Bird(final int radius,final int initialX,final int initialY,final int gravity,Color c){
		this.radius=radius;
		this.x=initialX;
		this.y=initialY;
		this.gravity=gravity;
		this.defaultColor=c;
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
		if(this.y < Bird.MAXY - 100){

			this.y= this.y+(yIncrement *gravity) ;
			System.out.println("y changed to "+y);
		}
	}




	public void paintTheBird(Graphics g){
		g.fillOval((int)this.x,(int)this.y,this.radius,this.radius);
	}


}