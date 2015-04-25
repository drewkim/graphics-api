import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;			
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.ImageIcon;

/***************************************************************************
 * Main class for simple graphics API. Users can include this file in their
 * projects and then implement the user-friendly methods in their programs
 * for simple graphics. The library makes it easy for beginning programmers
 * to learn the basics of Java coding. It includes packaged methods to create
 * new graphics objects in one line of code, without the hassle of having
 * to implement multiple methods, define lots of variable, and generally go
 * through lots of work. The API uses a class called Drawable; this is a class
 * that takes different parameters and then draws graphics objects based on
 * different commands it is given.
 * Note: Instead of the traditional java graphics system, this library draws
 * objects with the point (0, 0) in the bottom left corner of the screen.
 * 
 * Date: 4/24/15
 * 
 * @author Drew Kim
 *
 ***************************************************************************/
public class Draw extends JFrame implements ActionListener, KeyListener, MouseListener, MouseMotionListener 
{
	private static final long serialVersionUID = 1L;
	final int DELAY_IN_MILLISEC = 20;
	static Draw di = new Draw();
	public static int mouseX;
	public static int mouseY;
	public static int mousePressX;
	public static int mousePressY;
	public static char keyPressed;
	private static int windowHeight;
	private static HashMap<String, Color> colors = new HashMap<String, Color>();
	private static Color currentColor = Color.black;
	static ArrayList<Drawable> objs = new ArrayList<Drawable>();

	/**
	 * Constructor. Sets crucial attributes for graphics to function
	 */
	public Draw()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Timer clock= new Timer(DELAY_IN_MILLISEC, this);
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		clock.start();
	}

	/**
	 * Creates a new window. Size determined by user.
	 * @param width
	 * @param height
	 */
	public static void window(int width, int height)
	{
		di.setSize(width, height);
		di.setVisible(true);

		windowHeight = height;
	}

	/**
	 * Draws a line
	 * @param x1 X-coordinate of first point
	 * @param y1 Y-coordinate of first point
	 * @param x2 X-coordinate of second point
	 * @param y2 Y-coordinate of second point
	 */
	public static void line(int x1, int y1, int x2, int y2)
	{
		Drawable obj = new Drawable(x1, windowHeight - y1, x2, windowHeight - y2, "line", null, null);
		objs.add(obj);
	}

	/**
	 * Draws a rectangle
	 * @param x X-coordinate of the bottom right corner
	 * @param y Y-coordinate of the bottom right corner
	 * @param width
	 * @param height
	 */
	public static void rect(int x, int y, int width, int height)
	{
		Drawable obj = new Drawable(x, windowHeight - y - height, width, height, "rect", null, null);
		objs.add(obj);
	}

	/**
	 * Draws an oval
	 * @param x X-Coordinate of the bottom right corner
	 * @param y Y-coordinate of the bottom right corner
	 * @param width
	 * @param height
	 */
	public static void oval(int x, int y, int width, int height)
	{
		Drawable obj = new Drawable(x - width/2, windowHeight - y - height + height/2, width, height, "oval", null, null);
		objs.add(obj);
	}

	/**
	 * Draws an image based on a path the user provides
	 * @param imageName Path of the image
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public static void image(String imageName, int x, int y, int width, int height)
	{
		Drawable obj = new Drawable(x, windowHeight - y - height, width, height, "image", imageName, null);
		objs.add(obj);
	}

	/**
	 * Draws text
	 * @param text Text to be displayed
	 * @param x
	 * @param y
	 */
	public static void text(String text, int x, int y)
	{
		Drawable obj = new Drawable(x, windowHeight - y, 0, 0, "text", text, null);
		objs.add(obj);
	}

	/**
	 * Sets the color for subsequent figures to b drawn in
	 * @param color
	 */
	public static void color(String color)
	{
		colors = fillColors();
		color = color.toLowerCase();
		Color newColor = currentColor;
		if(colors.containsKey(color))
			newColor = colors.get(color);
		Drawable obj = new Drawable(0, 0, 0, 0, "color", null, newColor);
		objs.add(obj);
	}

	/**
	 * Fills a library with color names and their corresponding Color objects
	 * @return
	 */
	private static HashMap<String, Color> fillColors()
	{
		HashMap<String, Color> c = new HashMap<String, Color>();
		
		c.put("red", Color.red);
		c.put("orange", Color.orange);
		c.put("yellow", Color.yellow);
		c.put("green", Color.green);
		c.put("blue", Color.blue);
		c.put("magenta", Color.magenta);
		c.put("white", Color.white);
		c.put("black", Color.black);
		c.put("gray", Color.gray);
		c.put("cyan", Color.cyan);
		c.put("pink", Color.pink);
		
		return c;
	}
	
	/**
	 * Draws all figures on screen
	 */
	public void paint(Graphics g)
	{
		for(int i = 0; i < objs.size(); i++)
		{
			Drawable obj = objs.get(i);
			obj.draw(g);
		}
	}

	/**
	 * Calls the paint method every 20 milliseconds
	 */
	public void actionPerformed(ActionEvent e) 
	{
		repaint();
	}

	/**
	 * Updates mouse coordinates whenever mouse moved
	 */
	public void mouseMoved(MouseEvent e) 
	{
		mouseX = e.getX();
		mouseY = e.getY();
	}

	/**
	 * Updates press coordinates whenever mouse pressed
	 */
	public void mousePressed(MouseEvent e) 
	{
		mousePressX = e.getX();
		mousePressY = e.getY();
	}
	
	/**
	 * Stores latest key pressed
	 */
	public void keyPressed(KeyEvent e) 
	{
		keyPressed = e.getKeyChar();

	}

	public void mouseClicked(MouseEvent e) {}
	
	public void mouseDragged(MouseEvent e) {}
	
	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

	public void keyTyped(KeyEvent e) {}

	public void keyReleased(KeyEvent e) {}
}

/***************************************************************************
 * Drawable class. Accepts a mutitude of different parameters, each utilized
 * in a different way based on what figure is being drawn.
 * 
 * @author Drew Kim
 *
 ***************************************************************************/
class Drawable 
{
	int x1;
	int y1;
	int x2;
	int y2;
	String type;
	String text;
	Color color;
	
	/**
	 * Constructor. Initializes different varibales sent over
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param type
	 * @param text
	 * @param color
	 */
	public Drawable(int x1, int y1, int x2, int y2, String type, String text, Color color)
	{
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.type = type;
		this.text = text;
		this.color = color;
	}
		
	/**
	 * Draws figures
	 * @param g
	 */
	public void draw(Graphics g)
	{		
		g.setColor(color);
		
		if(type.equals("line"))
			g.drawLine(x1, y1, x2, y2);
		else if(type.equals("rect"))
			g.drawRect(x1, y1, x2, y2);
		else if(type.equals("oval"))
			g.drawOval(x1, y1, x2, y2);
		else if(type.equals("text"))
			g.drawString(text, x1, y1);
		else if(type.equals("image"))
			g.drawImage(new ImageIcon(text).getImage(), x1, y1, x2, y2, null);
		else if(type.equals("color"))
			g.setColor(color);
	}
}

