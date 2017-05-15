
public class PointCounter {

	private int points = 0;
	private int linesCleared = 0;
	private boolean gotTetris = false;
	private int level;
	public PointCounter(int lines) {
		linesCleared += lines;
		switch(lines)
		{
			case 1: points += 100 * level;
			break;
			case 2: points += 300 * level;
			break;
			case 3: points += 500 * level;
			break;
			case 4: points += 800 * level;
			if(gotTetris) {
				points += 400 * level;
			}
			gotTetris = true;
			break;
		}
		if(linesCleared >= 10) {
			linesCleared -= 10;
			nextLevel();
		}
		
	}
	public int getPoints() {
		return points;
	}
	public void changeLevel(int level) {
		this.level = level;
	}
	public void nextLevel()
	{
		this.level++;
	}
	public void gotTetris(boolean isTrue) {
		gotTetris = isTrue;
	}

}
