import java.awt.event.KeyEvent;	
import board.Board;
import processing.core.PApplet;
import processing.event.MouseEvent;


public class DrawingSurface extends PApplet {
	
	private Board b;
	private int w, h;
	private boolean changed, mousePressed;
	
	public DrawingSurface() {
		w = width;
		h = height;
		changed = true;
		mousePressed = false;
	}
	
	// The statements in the setup() function 
	// execute once when the program begins
	public void setup() {
		registerMethod("pre", this);
		frameRate(60);
	}
	
	public void settings()
	{
		fullScreen();
		b = new Board(width, height);
	}
	
	// The statements in draw() are execut	ed until the 
	// program is stopped. Each statement is executed in 
	// sequence and after the last line is read, the first 
	// line is executed again.
	public void draw() { 
		background(255);   // Clear the screen with a white background
		if (changed)
		{
			b = new Board(width, height);
			changed = false;
		}
		
		if (mousePressed)
		{
			b.sort();
		}
		
		b.draw(this);
	}
		

	public void mouseWheel(MouseEvent event) {
		b.randomize(b.getBoard());
	}
	
	public void mousePressed(MouseEvent event)
	{
		mousePressed = true;
	}
	
	public void keyPressed() 
	{
		if (keyCode == KeyEvent.VK_LEFT)
		{
			b.changeAlgorithm(b.getAlgorithmIndex() - 1);
		} else if (keyCode == KeyEvent.VK_RIGHT)
		{
			b.changeAlgorithm(b.getAlgorithmIndex() + 1);
		}
	}
	
	public void pre()
	{
		if (w != width || h != height)
		{
			w = width;
			h = height;
			changed = true;
		}
	}
}










