import java.io.File;
import java.util.List;
import java.util.logging.Logger;

public class MazeDriver {
	private static final Logger logger = Logger.getLogger(MazeDriver.class.getName());

	public static void main(String[] args) throws Exception {
		File maze1 = new File("input/simple-maze.txt");
		File maze2 = new File("input/bigger-maze.txt");

		execute(maze1);
		execute(maze2);
	}

	static void execute(File file) throws Exception {
		Maze maze = new Maze(file);
		dfs(maze);
		bfs(maze);
	}

	private static void dfs(Maze maze) {
		DfsMazeSolver dfs = new DfsMazeSolver();
		List<Position> path = dfs.solve(maze);
		logger.info("DFS algorith evaluated for given maze and returned: ");
		maze.printPath(path);
		maze.reset();
	}

	private static void bfs(Maze maze) {
		BfsMazeSolver bfs = new BfsMazeSolver();
		List<Position> path = bfs.solve(maze);
		logger.info("BFS algorith evaluated for given maze and returned: ");
		maze.printPath(path);
		maze.reset();
	}
}