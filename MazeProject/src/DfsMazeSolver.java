import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DfsMazeSolver {
	/*
	 * Defines the four possible directions. In terms of coordinates, these
	 ** coordinates, when added to any given coordinates, will return on of the
	 ** neighboring coordinates
	 */
	private static final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	// If there is a path from entry to exit, then return the path, else return
	// empty list
	public List<Position> solve(Maze maze) {
		List<Position> path = new ArrayList<>();
		if (explore(maze, maze.getEntry().getX(), maze.getEntry().getY(), path)) {
			return path;
		}
		return Collections.emptyList();
	}

	/* This method has three main blocks. First, we discard invalid
	 * nodes i.e. the nodes which are outside the maze or are part of the wall.
	 * After that, we mark the current node as visited so that we don't visit the
	 * same node again and again. Finally, we recursively move in all directions if
	 * the exit is not found
	 */
	private boolean explore(Maze maze, int row, int col, List<Position> path) {
		if (!maze.isValidLocation(row, col) || maze.isWall(row, col) || maze.isExplored(row, col)) {
			return false;
		}

		path.add(new Position(row, col));
		maze.setVisited(row, col, true);

		if (maze.isExit(row, col)) {
			return true;
		}

		for (int[] direction : DIRECTIONS) {
			Position position = getNextPosition(row, col, direction[0], direction[1]);
			if (explore(maze, position.getX(), position.getY(), path)) {
				return true;
			}
		}

		path.remove(path.size() - 1);
		return false;
	}

	// Utility method which will add two coordinates
	private Position getNextPosition(int row, int col, int i, int j) {
		return new Position(row + i, col + j);
	}
}
