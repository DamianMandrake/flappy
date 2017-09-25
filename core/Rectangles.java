public class Rectangles{
	private int x,y;
	private int height;
	private final static int BIRD_HEIGHT=50;
	private final static int width=30;
	private int finalX;
	private Color c;
	public Rectangles(int intialX,int intialY,int height,Color whichColorm,boolean isPassable){
		this.height=height;
		this.finalX=intialX+height;
		this.x=intialX;
		this.y=intialY;
		this.c=whichColor;
	}
	public void increaseHeight(){
		this.height+=20;

	}
	public int getY(){
		return this.y;
	}
	public int getX(){
		return this.x;
	}




	public final void paintTheRect(Graphics g){
		g.fillRect(this.x,this.y,this.height,Rectangles.width);s
	}
}