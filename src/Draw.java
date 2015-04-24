import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;			
import java.awt.event.MouseMotionListener;
import java.text.DateFormat.Field;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

public class Draw extends JFrame implements ActionListener, KeyListener, MouseListener, MouseMotionListener 
{
	private static final long serialVersionUID = 1L;
	final int DELAY_IN_MILLISEC = 1000;
	static Draw di = new Draw();
	public static int mouseX;
	public static int mouseY;
	public static int mousePressX;
	public static int mousePressY;
	public static char keyPressed;
	private static int windowHeight;
	private static HashMap<String, Color> colors = new HashMap<String, Color>();
	private static Color currentColor = new Color(0, 0, 0);
	static ArrayList<Drawable> objs = new ArrayList<Drawable>();

	public Draw()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Timer clock= new Timer(DELAY_IN_MILLISEC, this);
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		clock.start();
	}

	public static void main(String[] args) 
	{
		colors = fillColors(colors);
	}

	public static void window(int width, int height)
	{
		di.setSize(width, height);
		di.setVisible(true);

		windowHeight = height;
		System.out.println(windowHeight);
	}

	public static void line(int x1, int y1, int x2, int y2)
	{
		Drawable obj = new Drawable(x1, windowHeight - y1, x2, windowHeight - y2, "line", null);
		objs.add(obj);
	}

	public static void rect(int x, int y, int width, int height)
	{
		Drawable obj = new Drawable(x, windowHeight - y - height, width, height, "rect", null);
		objs.add(obj);
	}

	public static void oval(int x, int y, int width, int height)
	{
		Drawable obj = new Drawable(x - width/2, windowHeight - y - height + height/2, width, height, "oval", null);
		objs.add(obj);
	}

	public static void image(String imageName, int x, int y, int width, int height)
	{
		Drawable obj = new Drawable(x, windowHeight - y - height, width, height, "image", imageName);
		objs.add(obj);
	}

	public static void text(String text, int x, int y)
	{
		Drawable obj = new Drawable(x, windowHeight - y, 0, 0, "text", text);
		objs.add(obj);
	}

	public static void color(String color)
	{
		color = color.toLowerCase();
		Color newColor = currentColor;
		System.out.println(newColor);
		System.out.println(color);
		if(colors.keySet().contains(color))
		{
			newColor = colors.get(color);
			System.out.println(newColor);
		}
		
		currentColor = newColor;
	}

	private static HashMap<String, Color> fillColors(HashMap<String, Color> colors)
	{
		colors.put("red", Color.red);
		colors.put("orange", Color.orange);
		colors.put("yellow", Color.yellow);
		colors.put("green", Color.green);
		colors.put("blue", Color.blue);
		colors.put("magenta", Color.magenta);
		colors.put("white", Color.white);
		colors.put("black", Color.black);
		
		return colors;
	}
	
	public void paint(Graphics g)
	{
		for(int i = 0; i < objs.size(); i++)
		{
			Drawable obj = objs.get(i);
			obj.draw(g, currentColor);
		}
	}

	public void actionPerformed(ActionEvent e) 
	{
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseMoved(MouseEvent e) 
	{
		mouseX = e.getX();
		mouseY = e.getY();
	}

	public void mouseClicked(MouseEvent e) 
	{
		mousePressX = e.getX();
		mousePressY = e.getY();
	}

	public void mousePressed(MouseEvent e) 
	{
		mousePressX = e.getX();
		mousePressY = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyPressed(KeyEvent e) 
	{
		keyPressed = e.getKeyChar();

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
