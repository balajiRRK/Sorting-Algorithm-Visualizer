package board;

import processing.core.PApplet;

public class Line {

	private int x, y, x2, y2;
	
	public Line(int x, int y, int x2, int y2)
	{
		this.x = x;
		this.y = y;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public void draw(PApplet drawer)
	{
		drawer.line(x, y, x2, y2);
	}
	
	public void setX(int x)
	{
		this.x = x;
		x2 = x;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y2;
	}
	
	public void setY(int y2)
	{
		this.y2 = y2;
	}
}
