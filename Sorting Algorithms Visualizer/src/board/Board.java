package board;

import java.util.Random;

import processing.core.PApplet;

public class Board {

	private Line[] board;
	private Algorithms algo;
	private int algorithmIndex;
	private String algorithm;

	public Board(int width, int height)
	{
		algorithm = "BubbleSort";
		algo = new Algorithms();
		board = new Line[250];

		int x = 70, y = (int)(height * 8.9/9), y2 = y - 2;

		for (int i = 0; i < board.length; i++)
		{
			board[i] = new Line(x, y, x, y2);
			x += width/board.length;
			y2 -= ((double)height)/(board.length * 1.8);
		}

		randomize(board);
	}

	public void randomize(Line[] array)
	{
		int random, temp;
		Random r = new Random();

		for (int i = array.length - 1; i > 0; i--)
		{
			random = r.nextInt(i + 1);
			temp = array[random].getX();
			array[random].setX(array[i].getX());
			array[i].setX(temp);;
		} 
	}

	public void sort() 
	{
		if (algorithmIndex == 0)
		{
			algo.bubbleSort(board);
			algorithm = "BubbleSort";
		} else if (algorithmIndex == 1)
		{
			algo.insertionSort(board);
			algorithm = "InsertionSort";
		}
	}
	
	public void changeAlgorithm(int x)
	{
		if (x < 0)
		{
			algorithmIndex = 0;
		}
		{
			algorithmIndex = x;
		}
	}
	
	public int getAlgorithmIndex()
	{
		return algorithmIndex;
	}

	public void draw(PApplet drawer)
	{
		drawer.fill(0);
		drawer.textSize(26);
		drawer.text(algorithm, drawer.width/30, drawer.height/10);
		drawer.textSize(20);
		drawer.text("Mouse Scroll Wheel to randomize \n Click mouse to sort \n Left and Right Arrow Keys to swap Algorithms", drawer.width/5, drawer.height/10);
		
		for (int i = 0; i < board.length; i++)
		{
			board[i].draw(drawer);
		}
	}

	public Line[] getBoard()
	{
		return board;
	}
}
