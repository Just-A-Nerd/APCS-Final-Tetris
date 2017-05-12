
public class PointCounter {

	public PointCounter() {
		// TODO Auto-generated constructor stub
	}
	public static int linesCleared(int lines) {
		int points = 0;
		switch(lines) 
		{
		case 1: points = 100;
		break;
		case 2: points = 300;
		break;
		case 3: points = 500;
		break;
		case 4: points = 800;
		break;
		}
		
		return points;
	}
}
