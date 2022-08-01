
import java.io.File;

import org.junit.jupiter.api.Test;

class MazeDriverTest {

	@Test
	void testExecution() throws Exception {
		File file = new File("input/simple-maze.txt");
		Maze maze = new Maze(file);
		MazeDriver mazeDriver = new MazeDriver();
		mazeDriver.execute(file);

	}

}
