import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BfsMazeSolver {
	private static final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

// Instead of recursive traversal, we'll use a FIFO data structure to track neighbors and iterate over them
	public List<Position> solve(Maze maze) {
		LinkedList<Position> nextToVisit = new LinkedList<>();
		Position start = maze.getEntry();
		nextToVisit.add(start);

		while (!nextToVisit.isEmpty()) {
			Position cur = nextToVisit.remove();

			if (!maze.isValidLocation(cur.getX(), cur.getY()) || maze.isExplored(cur.getX(), cur.getY())) {
				continue;
			}

			if (maze.isWall(cur.getX(), cur.getY())) {
				maze.setVisited(cur.getX(), cur.getY(), true);
				continue;
			}

			if (maze.isExit(cur.getX(), cur.getY())) {
				return backtrackPath(cur);
			}

			for (int[] direction : DIRECTIONS) {
				Position coordinate = new Position(cur.getX() + direction[0], cur.getY() + direction[1], cur);
				nextToVisit.add(coordinate);
				maze.setVisited(cur.getX(), cur.getY(), true);
			}
		}
		return Collections.emptyList();
	}

	private List<Position> backtrackPath(Position cur) {
		List<Position> path = new ArrayList<>();
		Position iter = cur;

		while (iter != null) {
			path.add(iter);
			iter = iter.parent;
		}

		return path;
	}
}