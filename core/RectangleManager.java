package core;
import core.Rectangles;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;
public class RectangleManager{
	private ArrayList<Rectangles> rect; 
	private int maxY,birdRadius,remainingSpace;
	private final static int BIRD_PADDING=20,SCREEN_TOP=0,X_PADDING=100,QUEUE_SIZE=20,NUM_RECT_ON_SCREEN=4;
	private int initX;
	private int qPointer=0,oldQPointer=0;

	public RectangleManager(int maxY,int birdRadius){
		this.rect=new ArrayList<>();
		this.maxY=maxY;
		
		this.initX=0;
		this.birdRadius=birdRadius;
		this.remainingSpace=(maxY-birdRadius-RectangleManager.BIRD_PADDING);
		this.addSomeRects(QUEUE_SIZE);
	}

	private void addSomeRects(int x){
		
		for(int i=0,j=0;i<x/2;i++){
			System.out.println("initX "+this.initX);
			this.initX+=Rectangles.getRectangleWidth() + RectangleManager.X_PADDING;
			int a=generateRandomHeight(),b=this.remainingSpace-a;
			Rectangles r=new Rectangles(this.initX,RectangleManager.SCREEN_TOP,a);
			r.setId(j++);
			this.rect.add(r);
			r=new Rectangles(this.initX, a + this.birdRadius + RectangleManager.BIRD_PADDING ,b);
			r.setId(j++);
			this.rect.add(r);
		}
	}


	private int generateRandomHeight(){
		return ThreadLocalRandom.current().nextInt(0,this.remainingSpace);
	}
	public void update(){
		qPointer= (qPointer+2) %QUEUE_SIZE;
		System.out.println("qPtr is "+qPointer);
		int x=this.generateRandomHeight(),y=this.remainingSpace-x;
		int i=qPointer - 1 <0? this.rect.size()-1:qPointer -1;
		int j=qPointer -2 <0?this.rect.size()-2:qPointer-2;
		this.rect.get(i).setHeight(x);
		this.rect.get(j).setHeight(y);
		
	}
	public void paintThemAll(Graphics g){
		
		System.out.println("gere");
		for(int i=qPointer;i < qPointer+NUM_RECT_ON_SCREEN -1;i = (i+2) ){
			System.out.println("painting "+i +" and "+(i+1));
			Rectangles r=this.rect.get(i % QUEUE_SIZE ),r2=this.rect.get((i+1)%QUEUE_SIZE);
			r.paintTheRect(g);
			r2.paintTheRect(g);

			
			//r.setHeight(x);r2.setHeight(y);
			r.move();r2.move();
		}

		

	


	}
	public int clear(){
		this.rect.clear();
		addSomeRects(QUEUE_SIZE);
		return 0;
	}
	public boolean isAlive(Bird bird){
		return ( this.rect.get(qPointer).didItHit(bird) || this.rect.get((qPointer+1) % QUEUE_SIZE).didItHit(bird));
	}
		


}