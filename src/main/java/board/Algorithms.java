package board;

import java.awt.Color;

public class Algorithms {

	private String[] algorithmsList;
	private int bubbleSortIndex, insertionSortIndex;
	private boolean sorted;
	
	public Algorithms()
	{
		algorithmsList = new String[] {"Bubble Sort", "Insertion Sort"};
		bubbleSortIndex = 0;
		insertionSortIndex = 0;
		sorted = false;
	}

	public boolean bubbleSortStep(Line[] board)
	{
		// BubbleSortStep

		// check if sorted stayed true until end of lines (sorted set true after each cycle completed to check if no swaps needed)
		if (sorted && bubbleSortIndex > board.length - 2)
		{
			sorted = false;
			return true;
		}

		if (bubbleSortIndex > board.length - 2) // board.length - 2 to see if it reaches 2nd last line (since we're checking 2nd lastline with 2nd lastline+1 index)
		{
			bubbleSortIndex = 0;
			sorted = true; // set sorted true to see if it stays true after another full cycle (no swaps)
		} 

		// check if need to swap
		if (board[bubbleSortIndex].getY() < board[bubbleSortIndex+1].getY()) // check opposite because smaller number means that it's taller so we're checking if left line is taller than right here
		{
			board[bubbleSortIndex].setColor(Color.RED);
			board[bubbleSortIndex+1].setColor(Color.RED);

			Line temp = board[bubbleSortIndex];
			board[bubbleSortIndex] = board[bubbleSortIndex+1];
			board[bubbleSortIndex+1] = temp;

			int tempX = board[bubbleSortIndex].getX();
			board[bubbleSortIndex].setX(board[bubbleSortIndex+1].getX());
			board[bubbleSortIndex+1].setX(tempX);
			bubbleSortIndex++;

			sorted = false;
		} else // no swap needed
		{
			bubbleSortIndex++;
		}

		board[bubbleSortIndex-1].setColor(Color.BLACK);
		board[bubbleSortIndex].setColor(Color.BLACK);

		return false;
	}
	
	public boolean insertionSortStep(Line[] board)
	{
		if (insertionSortIndex >= board.length)
		{
			sorted = true;
			insertionSortIndex = 0; // reset conditions back to initial state when done sorting
			return true;
		} 
		
		int key = board[insertionSortIndex].getY();
		int i = insertionSortIndex - 1;

		while ( (i > -1) && (board[i].getY() < key) )
		{
			board[i+1].setY(board[i].getY());
			i--;	
		}

		board[i+1].setY(key);
		insertionSortIndex++;

		return false;
	}

	// GETTERS & SETTERS

	public String[] getAlgorithmsList() {
		return algorithmsList;
	}
}
