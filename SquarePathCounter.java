
//a solution to problem 15 from projecteuler.net

public class SquarePathCounter {
	
	//holds the number of paths from a given location to the goal at each index
	private long[][] grid;
	
	//constructs an empty grid used to count the paths, storing 1 at the end position
	//dimensions of the array are one greater than that of the grid because n adjacent
	//blocks have n + 1 edges to travel along
	public SquarePathCounter(int rows, int cols){
		grid = new long[rows + 1][cols + 1];
		grid[rows][cols] = 1;
	}
	
	/*
	dyanamically compute the number of paths to the end from each spot on the grid by adding
	together the number of paths from the spot below it and to the right
	*/
	public long countPaths(int row, int col){
		if(grid[row][col] != 0){
			return grid[row][col];
		}
		if(row + 1 < grid.length){
			if(col + 1 < grid[0].length){
				grid[row][col] = countPaths(row + 1, col) + countPaths(row, col + 1);
				return grid[row][col];
			}
			else{
				grid[row][col] = countPaths(row + 1, col);
				return grid[row][col];
			}
		}
		else{
			if(col + 1 < grid[0].length){
				grid[row][col] = countPaths(row, col + 1);
				return grid[row][col];
			}
			else{
				grid[row][col] = 1;
				return 1;
			}
			
		}
	}
	
	//the case from the problem, a 20 x 20 grid
	public static void main(String[] args){
		SquarePathCounter s = new SquarePathCounter(20, 20);
		System.out.println(s.countPaths(0, 0));
	}

}
