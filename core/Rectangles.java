package core;
import java.awt.Color;
import java.awt.Graphics;
public class Rectangles{
	private int x,y;
	private int height;
	private final static int BIRD_HEIGHT=50,X_OFFSET=20;
	private final static int WIDTH=50;
	private static int MAX_X;
	private int id;
	private Color c;
	public Rectangles(int intialX,int intialY,int height){
		this(intialX,intialY,height,Color.BLACK);
	}
	public Rectangles(int intialX,int intialY,int height,Color whichColor){
		this.height=height;
		this.x=intialX;
		this.y=intialY;
		this.c=whichColor;
	}
	public void setId(int x){
		this.id=x;
	}
	public void setHeight(int h){
		this.height=h;

	}
	public void move(){
		this.x = this.x<0? MAX_X:this.x-Rectangles.X_OFFSET ;
	}
	public int getY(){
		return this.y;
	}
	public int getX(){
		return this.x;
	}
	public boolean didItHit(Bird bird){
		return false;
	}

	public static int getRectangleWidth(){
		return Rectangles.WIDTH;
	}
	public static void setMaxX(int x){
		Rectangles.MAX_X=x;
	}




	public final void paintTheRect(Graphics g){

		g.fillRect(this.x,this.y,Rectangles.WIDTH,this.height);
	
	}
}