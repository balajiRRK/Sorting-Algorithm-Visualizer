package board;

public class Algorithms {
	
	private int bubbleIndex, insertionIndex;
	
	public Algorithms()
	{
		bubbleIndex = 0;
		insertionIndex = 1;
	}
	
	public void bubbleSort(Line[] board)
	{
		if (bubbleIndex >= board.length - 1)
		{
			bubbleIndex = 0;
		} else if (board[bubbleIndex].getX() > board[bubbleIndex+1].getX())
		{
			int temp = board[bubbleIndex].getX();
			board[bubbleIndex].setX(board[bubbleIndex+1].getX());
			board[bubbleIndex+1].setX(temp);
			bubbleIndex++;
		} else
		{
			bubbleIndex++;
		}
	}
	
	public void insertionSort(Line[] board)
	{
		if (insertionIndex > board.length - 1)
		{
			insertionIndex = 1;
		} else
		{
			int key = board[insertionIndex].getX();
			int i = insertionIndex-1;
			while ( (i > -1) && (board[i].getX() > key))
			{
				board[i+1].setX(board[i].getX());
				i--;	
			}
			
			board[i+1].setX(key);
			insertionIndex++;
		}
	}
}
