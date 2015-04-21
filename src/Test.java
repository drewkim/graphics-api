
public class Test 
{

	public static void main(String[] args) 
	{
		Draw.window(500, 500);
		
		Draw.line(250, 400, 150, (int)(400 - (200*Math.sqrt(3))/2));
		Draw.line(150, (int)(400 - (200*Math.sqrt(3))/2), 350, (int)(400 - (200*Math.sqrt(3))/2));
		Draw.line(350, (int)(400 - (200*Math.sqrt(3))/2), 250, 400);
		
		Draw.oval(250, (int)((Math.sqrt(3) * 200)/6) + (int)(400 - (200*Math.sqrt(3))/2), (int)((Math.sqrt(3) * 200)/3), (int)((Math.sqrt(3) * 200)/3));
		
		Draw.line(250, (int)(400 - (200*Math.sqrt(3))/2), 250, 400);
		
		Draw.text("H.P", 240, (int)(400 - (200*Math.sqrt(3))/2) - 20);

		System.out.println(Draw.mouseX);
		System.out.println(Draw.mouseY);
		System.out.println(Draw.mousePressX);
		System.out.println(Draw.mousePressY);
	}
}