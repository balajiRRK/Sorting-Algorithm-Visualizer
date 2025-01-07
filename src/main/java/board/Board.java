package board;

import java.util.Random;

import processing.core.PApplet;

public class Board {

	private Line[] lines;
	private Algorithms algo;
	private int algorithmIndex;
	private String currentAlgorithm;
	private int linesCount;
	private boolean sorted;

	public Board(int width, int height)
	{
		currentAlgorithm = "Bubble Sort";
		algo = new Algorithms();
		linesCount = 50; 
		lines = new Line[linesCount];
		sorted = false;

		// Top left of the PApplet window is (0, 0)
		int x = 70; // starting x position of left-most line
		int y = (int)(height * 8.9/9);
		int y2 = y - 10; // y - 10 since it creates a small length distance between y1 and y2 so creates a small line

		for (int i = 0; i < lines.length; i++)
		{
			lines[i] = new Line(x, y, x, y2);
			x += width/lines.length; // incrementally move each next line to the right after the first one, increase their x-position to the right evenly so that the width of the window is distributed by the amount of lines
			y2 -= ((double)height) / (lines.length * 1.8); // incrementally make each next line taller after the first one (decreasing value means height goes up) 
		}
	}

	public void randomize()
	{
		int random;
		Random r = new Random();

		for (int i = lines.length - 1; i > 0; i--)
		{
			// switch the way the order of the lines are in the list but not visually (since drawer will just draw the same lines but in a different order instead of in different positions)
			random = r.nextInt(i + 1); // random index from 0 to i
			Line temp = lines[random];
			lines[random] = lines[i];
			lines[i] = temp;

			// switch the x-value of the line to make the visual line order match the order of the line in the list
			int tempX = lines[random].getX();
			lines[random].setX(lines[i].getX());
			lines[i].setX(tempX);
		} 
	}

	public boolean sort() 
	{
		String[] algosList = algo.getAlgorithmsList();

		if (algosList[algorithmIndex] == "Bubble Sort")
		{
			sorted = algo.bubbleSortStep(lines);

		} else if (algosList[algorithmIndex] == "Insertion Sort")
		{
			sorted = algo.insertionSortStep(lines);
		}

		return sorted;
	}
	
	public void changeAlgorithm(String s)
	{
		String[] algosList = algo.getAlgorithmsList();

		if (s == "LEFT")
		{
			algorithmIndex = (algorithmIndex - 1 + algosList.length) % algosList.length; // `% algorithms.length` to create the wrap around functionality
			currentAlgorithm = algosList[algorithmIndex]; // sorting algorithm name to display
		} else if (s == "RIGHT")
		{
			algorithmIndex = (algorithmIndex + 1) % algosList.length; // `% algorithms.length` to create the wrap around functionality
			currentAlgorithm = algosList[algorithmIndex]; // sorting algorithm name to display
		}
	}
	
	public void draw(PApplet drawer)
	{
		drawer.fill(0);
		drawer.textSize(26);
		drawer.text(currentAlgorithm, drawer.width/30, drawer.height/10);
		drawer.textSize(20);
		String randomizeInstructions = "Press 'R' to randomize";
		String sortingInstructions = "Press spacebar to sort";
		String algorithmCycleInstructions = "Use the left and right arrow keys to cycle between different algorithms";
		String fpsInstructions = "Use the up and down arrow keys to increase or decrease the fps by 5 frames from a range of 5-60";
		drawer.text(randomizeInstructions + "\n" + sortingInstructions + "\n" + algorithmCycleInstructions + "\n" + fpsInstructions, drawer.width/5, drawer.height/10);
		
		for (int i = 0; i < lines.length; i++)
		{
			lines[i].draw(drawer);
		}
	}

	// GETTERS & SETTERS

	public int getAlgorithmIndex()
	{
		return algorithmIndex;
	}

	public Line[] getBoard()
	{
		return lines;
	}
}
