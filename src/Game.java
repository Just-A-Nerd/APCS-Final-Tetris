 class Game
{
	public static void main(String[] args)
	{
		new Window();
		update();
	}
	public static void update()
	{
		PlayingField.makeBlockAppear();
	}
}
