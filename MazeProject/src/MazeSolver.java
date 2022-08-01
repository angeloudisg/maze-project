import java.util.LinkedList;

public class MazeSolver {
	
	//if it was not static, we could not access it from the main method below
	static int[] [] maze = {
			{2, 0, 0, 1},
			{1, 1, 0, 1},
			{0, 1, 1, 1}
	};
	//	0=WALL, 1=PATH, 2= END the goal is to find the END

	static LinkedList<Position> path = new LinkedList<>();
	public static void main(String[] args) {
		Position p = new Position(3,0);
		path.push(p); //adds it to the beginning of the list
		maze[path.peek().y] [path.peek().x] =0;

	}

}
