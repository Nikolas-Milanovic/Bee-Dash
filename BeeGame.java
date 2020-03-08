
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class BeeGame extends JFrame {
	ArrayList<Bee> Bees;
	JLabel label;
	ImageIcon img;
	BufferedImage bImage;
	Graphics g;
	Random rand;
	int difficulty, x;
	Beehive beehive;
	int points;
	Timer myTimer, levelTimer;
	int speed = 0, prev = 0, count = 0, level = 1, spawnTime = 8, pointsNeeded = 50, levelCount;
	JLabel splat;
	private static Robot robot = null;
	int x1, y1;
	boolean LevelDisplay;

	public static void Klick(int x, int y) {
		robot.mouseMove(x, y);
		robot.mousePress(MouseEvent.BUTTON1_MASK);
	}

	public static void main(String[] args) throws IOException {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new BeeGame();
			}
		});
	}

	public BeeGame() {
		setTitle("Bee Rush");
		setSize(1000, 800);
		setResizable(false);
		label = new JLabel();
		rand = new Random();
		difficulty = -1;
		points = 0;
		speed = 0;
		x1 = rand.nextInt(700) + 50;
		y1 = rand.nextInt(450) + 50;
		beehive = new Beehive(0);
		Bees = new ArrayList<Bee>();
		bImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
		g = bImage.getGraphics();
		g.setColor(new Color(255, 255, 255));
		g.fillRect(0, 0, getWidth(), getHeight());
		myTimer = new Timer(30, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					drawEverything(g);
					if (points >= pointsNeeded) {
						levelCount = count;
						LevelDisplay = true;
						level++;
						spawnTime -= 2;
						if (level >= 4) {
							spawnTime++;
						}
						if (spawnTime <= 0)
							spawnTime = 1;
						beehive.increaseSpeed();
						pointsNeeded = pointsNeeded * 2;
					}
				} catch (IOException e1) {
				}
			}
		});
		levelTimer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				if (count % spawnTime == 0 || count == 1 || count == 4) {
					int u = rand.nextInt(4) + 1;
					while (u == prev) {
						u = rand.nextInt(4) + 1;
					}
					Bees.add(new Bee(30, 30, 80, 81));
					Bees.get(Bees.size() - 1).setSide(u);
					Bees.get(Bees.size() - 1).autoBee();
					prev = u;

				}
			}
		});
		x = -1;
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				for (int i = 0; i < Bees.size(); i++) {
					if (Bees.get(i).contains(new Point(e.getX(), e.getY()))) {
						x = i;
						for (int j = Bees.get(x).getCount(); j < Bees.get(x).getValX().size(); i++) {
							Bees.get(x).getValX().remove(j);
						}
						for (int j = Bees.get(x).getCount(); j < Bees.get(x).getValY().size(); i++) {
							Bees.get(x).getValY().remove(j);
						}
						break;
					}
				}
			}
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				if (x != -1) {
					try {
						if (Bees.get(x).getCount() == Bees.get(x).getValX().size()) {
							Bees.get(x).setLastX(Bees.get(x).x + 20);
							Bees.get(x).setLastY(Bees.get(x).y + 30);
						}

						if (Bees.get(x).speedAvoid(Bees.get(x).getLastX(), e.getX())
								&& Bees.get(x).speedAvoid(Bees.get(x).getLastY(), e.getY()) && e.getX() >= 20 && e.getX() <= 980
								&& e.getY() >= 30 && e.getY() <= 740) {
							Bees.get(x).valX.add(e.getX());
							Bees.get(x).valY.add(e.getY());
							Bees.get(x).setLastX(e.getX());
							Bees.get(x).setLastY(e.getY());
						}
					} catch (IndexOutOfBoundsException asd) {
					}
				}
			}
		});
		myTimer.start();
		levelTimer.start();
		img = new ImageIcon(bImage);
		label.setIcon(img);
		this.add(label);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public void drawBackground() {
		Color color = new Color(1, 171, 68);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
		ImageIcon img = null;
		Image image;
		g2.fill(new Rectangle(0, 0, 1000, 800));
		try {
			img = new ImageIcon(ImageIO.read(BeeGame.class.getResourceAsStream("/JustInCase.png")));
		} catch (IOException e1) {
		}
		image = img.getImage();

		g2.drawImage(image, x1, y1, null);
		g2.setColor(Color.BLACK);
		g.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
		g2.drawString("Score: " + points, 20, 50);
		g2.drawString("Level: " + level, 180, 50);

	}

	public void drawEverything(Graphics g) throws IOException {
		drawBackground();
		boolean flag = false;
		for (int i = 0; i < Bees.size(); i++) {
			Bees.get(i).draw(g);
			if (beehive.intersects(Bees.get(i)) == 1) {
				points += 10;
				Bees.remove(i);
			} else if (beehive.intersects(Bees.get(i)) == 2) {
				Bees.get(i).bounceBee();
			}
		}
		for (int i = 0; i < Bees.size(); i++) {
			for (int j = 0; j < Bees.size(); j++) {
				if (i != j && Bees.get(i).intersects(Bees.get(j))) {
					flag = true;
					break;
				}
			}
		}
		if (!flag) {
			beehive.draw(g);
			img = new ImageIcon(bImage);
			Graphics2D g2 = (Graphics2D) g;
			g2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 200));
			if (levelCount + 1 >= count) {
				g2.drawString("LEVEL " + level, 120, 450);
			}
			label.setIcon(img);
			this.add(label);
			setVisible(true);
		} else {
			new splat();
			try {
				robot = new Robot();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Klick(850, 230);
			Klick(850, 40);
			setVisible(false);
			dispose();
			myTimer.stop();
		}
	}
}

class splat extends JFrame implements ActionListener {
	JButton play, exit;
	ImageIcon img;
	ImageIcon imageIcon;
	Image image;
	Image newimg;
	ImageIcon beeIcon;
	Image beeImage;

	splat() throws IOException {
		this.setVisible(true);
		this.setSize(1000, 800);
		this.setLayout(null);
		setResizable(false);
		setTitle("Bee Rush");
		play = new JButton("Play Again");
		play.setVisible(true);
		play.setOpaque(true);
		play.setBorderPainted(false);
		play.addActionListener(this);
		play.setActionCommand("play");
		imageIcon = new ImageIcon(ImageIO.read(Welcome.class.getResourceAsStream("/Hive2.jpeg")));
		play.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
		image = imageIcon.getImage(); // transform it
		newimg = image.getScaledInstance(140, 90, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		imageIcon = new ImageIcon(newimg); // transform it back
		play.setIcon(imageIcon);
		play.setHorizontalTextPosition(JButton.CENTER);
		play.setVerticalTextPosition(JButton.CENTER);
		play.setBounds(820, 50, 150, 100);
		exit = new JButton("Exit");
		exit.setVisible(true);
		exit.setOpaque(true);
		exit.setBorderPainted(false);
		exit.addActionListener(this);
		exit.setActionCommand("exit");
		imageIcon = new ImageIcon(ImageIO.read(Welcome.class.getResourceAsStream("/Hive2.jpeg")));
		exit.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
		Image image = imageIcon.getImage(); // transform it
		Image newimg = image.getScaledInstance(140, 90, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		imageIcon = new ImageIcon(newimg); // transform it back
		exit.setIcon(imageIcon);
		exit.setHorizontalTextPosition(JButton.CENTER);
		exit.setVerticalTextPosition(JButton.CENTER);
		exit.setBounds(820, 200, 150, 100);
		this.add(play);
		this.add(exit);
	}

	public static void main(String[] args) throws IOException {
		new splat();
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		try {
			beeIcon = new ImageIcon(ImageIO.read(Bee.class.getResourceAsStream("/beeSplat-1.png")));
		} catch (IOException e1) {
		}
		beeImage = beeIcon.getImage();
		g2.setColor(Color.BLACK);
		try {
			img = new ImageIcon(ImageIO.read(BeeGame.class.getResourceAsStream("/splat-png.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		image = img.getImage();
		beeImage = beeIcon.getImage();
		Color color = new Color(1, 171, 68);
		g2.setColor(color);
		g2.fill(new Rectangle(0, 0, 1000, 800));
		g2.drawImage(image, 0, 0, null);
		g2.drawImage(beeImage, 350, 280, null);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if (evt.getActionCommand().equals("play")) {
			new BeeGame();
			this.setVisible(false);
			dispose();

		} else if (evt.getActionCommand().equals("exit")) {
			System.exit(0);
		}

	}
}