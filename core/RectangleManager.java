package core;
import core.Rectangles;
public class RectangleManager{
	private ArrayList<Rectangles> rect; 
	public RectangleManager(){
		this.rect=new ArrayList<>();

	}


	public void addRectangle(Rectangles r){
		this.rect.add(r);
	}

	public void updateValues(){
		for(Rectangles rect:this.rect){
			//will lead to an issue...  will fix soon
			rect.increaseHeight();
		}
	}
	public void paintThemAll(Graphics g){
		for(Rectangles r:this.rect){
			r.paintTheRect(g);
		}
	}


}