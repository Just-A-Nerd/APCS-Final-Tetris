 class Game
{
	public static void main(String[] args)
	{
		PlayingField.changeField();
		new Window();
		update();
	}
	public static void update()
	{
		PlayingField.makeBlockAppear();
	}
}
