package main;

import java.awt.event.KeyEvent;	
import board.Board;
import processing.core.PApplet;

public class DrawingSurface extends PApplet {
	
	private Board board;
	private int w, h, frameRate;
	private boolean windowChanged, sorted;
	
	public DrawingSurface() {
		w = width;
		h = height;
		board = new Board(width, height);
		windowChanged = false;
		sorted = true;
		frameRate = 15;
	}
	
	// The statements in the setup() function execute once when the program begins
	public void setup() {
		registerMethod("pre", this);
		frameRate(frameRate);
	}
	
	public void settings()
	{
		fullScreen();
		board = new Board(width, height);
	}
	
	// The statements in draw() are executed until the program is stopped.
	public void draw() { 
		background(255);	// Clear the screen with a white background
		
		if (windowChanged)
		{
			board = new Board(width, height);
			windowChanged = false;
		}
		
		if (!sorted)
		{
			sorted = board.sort();
		}
		
		board.draw(this);
		text("FPS Counter: " + frameRate, (float) (9.2/10) * width, (float) (0.15/10) * height);
	}
	
	public void keyPressed() 
	{
		if (keyCode == KeyEvent.VK_LEFT)
		{
			board.changeAlgorithm("LEFT");
		} else if (keyCode == KeyEvent.VK_RIGHT)
		{
			board.changeAlgorithm("RIGHT");
		} else if (keyCode == KeyEvent.VK_R)
		{
			board.randomize();
		} else if (keyCode == KeyEvent.VK_SPACE)
		{
			sorted = false; // setting sorted to false instead of calling sort method since want to visualize each sorting step one by one until it is sorted
		} else if (keyCode == KeyEvent.VK_UP)
		{
			if (frameRate + 5 <= 60)
				frameRate += 5;

			frameRate(frameRate);
		} else if (keyCode == KeyEvent.VK_DOWN)
		{
			if (frameRate - 5 > 0)
				frameRate -= 5;

			frameRate(frameRate);
		}
	}
	
	public void pre()
	{
		if (w != width || h != height)
		{
			w = width;
			h = height;
			windowChanged = true;
		}
	}
}










