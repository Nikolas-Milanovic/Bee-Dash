
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class Welcome extends JFrame implements ActionListener {
	int tPage = 0;
	JPanel buttonsPanel, t1, t2, t3, t4, t5, t6, LeftPane, panel2, panelfinalother, LeftPanel;
	JLabel label1, tutorialLabel1, firstSlide, secondSlide, thirdSlide, tutorialLabel2, tutorialLabel3;
	JButton forward, back;
	ImageIcon image;
	Image background, img;
	JButton play, tutorial, play1, play2, play3, play4, play5, play6;
	Graphics2D g2;
	Timer myTimer;
	static int count = 0;
	private static Robot robot = null;

	@SuppressWarnings("deprecation")
	public static void Klick(int x, int y) {
		robot.mouseMove(x, y);
		robot.mousePress(MouseEvent.BUTTON1_MASK);
	}

	public Welcome() throws IOException {
		// label1-image>>
		setResizable(false);
		label1 = new JLabel();
		image = new ImageIcon(ImageIO.read(Welcome.class.getResourceAsStream("/biodiversity_illy_bees.v1 (1).jpeg")));
		System.out.println(image);
		label1.setIcon(image);
		LeftPanel = new JPanel(new CardLayout());
		buttonsPanel = new JPanel(new FlowLayout());
		t1 = new JPanel(new BorderLayout());
		t2 = new JPanel(new BorderLayout());
		t3 = new JPanel(new BorderLayout());
//		t4 = new JPanel(new BorderLayout());
//		t5 = new JPanel(new FlowLayout());
//		t6 = new JPanel(new FlowLayout());
//		play1 = new JButton("Level 1");
//		play2 = new JButton("Level 2");
//		play3 = new JButton("Level 3");
//		play4 = new JButton("Level 4");
//		play5 = new JButton("Level 5");
//		play6 = new JButton("Level 6");
//		play1.setOpaque(true);
//		play2.setOpaque(true);
//		play3.setOpaque(true);
//		play4.setOpaque(true);
//		play5.setOpaque(true);
//		play6.setOpaque(true);
//		// t4.setLayout(new BoxLayout(t4));
//		play1.setBorderPainted(false);
//		play1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
//		play1.addActionListener(this);
//		play1.setActionCommand("play");
//		ImageIcon imageIcon = null;
//		try {
//			imageIcon = new ImageIcon(ImageIO.read(Welcome.class.getResourceAsStream("/Hive2.jpeg")));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		play1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
//		Image image = imageIcon.getImage(); // transform it
//		Image newimg = image.getScaledInstance(160, 140, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
//		imageIcon = new ImageIcon(newimg); // transform it back
//		play1.setIcon(imageIcon);
//		play1.setHorizontalTextPosition(JButton.CENTER);
//		play1.setVerticalTextPosition(JButton.CENTER);
//		play2.setBorderPainted(false);
//		play2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
//		play2.addActionListener(this);
//		play2.setActionCommand("play");
//		imageIcon = null;
//		try {
//			imageIcon = new ImageIcon(ImageIO.read(Welcome.class.getResourceAsStream("/Hive2.jpeg")));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		play2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
//		image = imageIcon.getImage(); // transform it
//		newimg = image.getScaledInstance(160, 140, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
//		imageIcon = new ImageIcon(newimg); // transform it back
//		play2.setIcon(imageIcon);
//		play2.setHorizontalTextPosition(JButton.CENTER);
//		play2.setVerticalTextPosition(JButton.CENTER);
//		play3.setBorderPainted(false);
//		play3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
//		play3.addActionListener(this);
//		play3.setActionCommand("play");
//		imageIcon = null;
//		try {
//			imageIcon = new ImageIcon(ImageIO.read(Welcome.class.getResourceAsStream("/Hive2.jpeg")));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		play3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
//		image = imageIcon.getImage(); // transform it
//		newimg = image.getScaledInstance(160, 140, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
//		imageIcon = new ImageIcon(newimg); // transform it back
//		play3.setIcon(imageIcon);
//		play3.setHorizontalTextPosition(JButton.CENTER);
//		play3.setVerticalTextPosition(JButton.CENTER);
//		play4.setBorderPainted(false);
//		play4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
//		play4.addActionListener(this);
//		play4.setActionCommand("play");
//		imageIcon = null;
//		try {
//			imageIcon = new ImageIcon(ImageIO.read(Welcome.class.getResourceAsStream("/Hive2.jpeg")));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		play4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
//		image = imageIcon.getImage(); // transform it
//		newimg = image.getScaledInstance(160, 140, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
//		imageIcon = new ImageIcon(newimg); // transform it back
//		play4.setIcon(imageIcon);
//		play4.setHorizontalTextPosition(JButton.CENTER);
//		play4.setVerticalTextPosition(JButton.CENTER);
//		play5.setBorderPainted(false);
//		play5.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
//		play5.addActionListener(this);
//		play5.setActionCommand("play");
//		imageIcon = null;
//		try {
//			imageIcon = new ImageIcon(ImageIO.read(Welcome.class.getResourceAsStream("/Hive2.jpeg")));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		play5.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
//		image = imageIcon.getImage(); // transform it
//		newimg = image.getScaledInstance(160, 140, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
//		imageIcon = new ImageIcon(newimg); // transform it back
//		play5.setIcon(imageIcon);
//		play5.setHorizontalTextPosition(JButton.CENTER);
//		play5.setVerticalTextPosition(JButton.CENTER);
//		play6.setBorderPainted(false);
//		play6.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
//		play6.addActionListener(this);
//		play6.setActionCommand("play");
//		imageIcon = null;
//		try {
//			imageIcon = new ImageIcon(ImageIO.read(Welcome.class.getResourceAsStream("/Hive2.jpeg")));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		play6.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
//		image = imageIcon.getImage(); // transform it
//		newimg = image.getScaledInstance(160, 140, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
//		imageIcon = new ImageIcon(newimg); // transform it back
//		play6.setIcon(imageIcon);
//		play6.setHorizontalTextPosition(JButton.CENTER);
//		play6.setVerticalTextPosition(JButton.CENTER);
//		t5.add(play1);
//		t5.add(play2);
//		t5.add(play3);
//		t6.add(play4);
//		t6.add(play5);
//		t6.add(play6);
//		t4.add(t5);
//		t4.add(t6);
		forward = new JButton(">>");
		back = new JButton("<<");
		tutorialLabel1 = new JLabel("How To Play Game");
		tutorialLabel1.setFont(new Font("Arial", Font.BOLD, 70));
		tutorialLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		tutorialLabel2 = new JLabel("How To Play Game");
		tutorialLabel2.setFont(new Font("Arial", Font.BOLD, 70));
		tutorialLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		tutorialLabel3 = new JLabel("How To Play Game");
		tutorialLabel3.setFont(new Font("Arial", Font.BOLD, 70));
		tutorialLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		firstSlide = new JLabel();
		firstSlide.setText(
				"<html>Help the bees rebuild their hive! Click anywhere on the bee to drag to their home.<br/>Beware the bee can only bee dragged so fast.<br/>To reset bee's path, click bee again.</html>");
		firstSlide.setHorizontalAlignment(SwingConstants.CENTER);
		firstSlide.setFont(new Font("Calibri", Font.BOLD, 30));
		secondSlide = new JLabel();
		secondSlide.setText("<html>Lead the bees towards the unbuilt (black) beehive <br/>to rack up points.");
		secondSlide.setHorizontalAlignment(SwingConstants.CENTER);
		secondSlide.setFont(new Font("Calibri", Font.BOLD, 30));
		thirdSlide = new JLabel();
		thirdSlide.setText("<html>Avoid causing the bees to splat by them colliding <br/>into eachother.</html>");
		thirdSlide.setHorizontalAlignment(SwingConstants.CENTER);
		thirdSlide.setFont(new Font("Calibri", Font.BOLD, 30));
		LeftPanel.setBackground(new Color(255, 110, 0));
		LeftPanel.add(label1, "picture");
		t3.add(tutorialLabel3, BorderLayout.NORTH);
		t3.add(thirdSlide, BorderLayout.CENTER);
		t2.add(tutorialLabel2, BorderLayout.NORTH);
		t2.add(secondSlide, BorderLayout.CENTER);
		t1.add(tutorialLabel1, BorderLayout.NORTH);
		t1.add(firstSlide, BorderLayout.CENTER);
		t1.setBackground(new Color(255, 110, 0));
		t2.setBackground(new Color(255, 110, 0));
		t3.setBackground(new Color(255, 110, 0));
//		t4.setBackground(new Color(255, 110, 0));
//		t5.setBackground(new Color(255, 110, 0));
//		t6.setBackground(new Color(255, 110, 0));
		buttonsPanel.setBackground(new Color(255, 110, 0));
		LeftPanel.add(t1, "tutorial");
		LeftPanel.add(t2, "tutorial2");
		LeftPanel.add(t3, "tutorial3");
		// LeftPanel.add(t4, "Level Selector");
		// LeftPanel.add(tutorialLabel1, "tutorial2");
		back.setActionCommand("back");
		back.setActionCommand("forward");
		back.setVisible(false);
		forward.setVisible(false);
		back.addActionListener(a -> {
			if (tPage > 0) {
				tPage--;
				buttons.tutorialClicked = true;
			}
		});
		forward.addActionListener(b -> {
			tPage++;
			buttons.tutorialClicked = true;
		});
		buttonsPanel.add(back);
		buttonsPanel.add(forward);

		this.add(buttonsPanel, BorderLayout.SOUTH);
		this.add(new buttons(), BorderLayout.EAST);
		this.add(LeftPanel);
		// frame
		setSize(1000, 650);
		setTitle("Bee Rush");
		// asetLayout(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		myTimer = new Timer(20, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				CardLayout cl = (CardLayout) (LeftPanel.getLayout());
				if (buttons.tutorialClicked == true) {
					// System.out.println(tPage);
					if (tPage == 0) {
						cl.show(LeftPanel, "tutorial");
					}
					if (tPage == 1) {
						cl.show(LeftPanel, "tutorial2");
					}
					if (tPage == 2) {
						cl.show(LeftPanel, "tutorial3");
					}
					back.setVisible(true);
					forward.setVisible(true);
					buttons.tutorialClicked = false;
				}
				if ((buttons.playClicked == true)) {
					// cl.show(LeftPanel, "picture");
					new BeeGame();
					setVisible(false);
					dispose();
					buttons.playClicked = false;
					repaint();
				}
			}
		});
		myTimer.start();
		setVisible(true);
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 70));
		g2.drawString("BEE ", 40, 110);
		g2.drawString("RUSH", 100, 200);
	}

	public static void main(String[] args) throws IOException {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					new Welcome();
					robot = new Robot();
				} catch (IOException e) {
				} catch (AWTException e) {
				}
				Klick(900, 250);
				Klick(900, 450);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}

@SuppressWarnings("serial")
class buttons extends JPanel implements ActionListener {
	JPanel panel2;
	JButton play;
	JButton tutorial;
	JPanel space1;
	JPanel space2;
	JPanel space3;
	ImageIcon imageIcon;
	static boolean tutorialClicked = false;
	static boolean playClicked = false;

	public buttons() throws IOException {
		// setPanel
		this.setSize(200, 650);
		// button-play>>
		// String twoLines = "PLAY\nGAME";
		play = new JButton("PLAY");
		play.setOpaque(true);
		play.setBorderPainted(false);
		play.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		play.addActionListener(this);
		play.setActionCommand("play");
		imageIcon = new ImageIcon(ImageIO.read(Welcome.class.getResourceAsStream("/Hive2.jpeg")));
		play.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		Image image = imageIcon.getImage(); // transform it
		Image newimg = image.getScaledInstance(160, 140, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		imageIcon = new ImageIcon(newimg); // transform it back
		play.setIcon(imageIcon);
		play.setHorizontalTextPosition(JButton.CENTER);
		play.setVerticalTextPosition(JButton.CENTER);
		// play.setMargin(new Insets(0, 0, 0, 0));
		// play.setBorder(BorderFactory.createEmptyBorder());
		// play.setContentAreaFilled(false);
		// button-tutorial>>
		tutorial = new JButton("TUTORIAL");
		tutorial.setOpaque(true);
		tutorial.setBorderPainted(false);
		tutorial.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		tutorial.addActionListener(this);
		tutorial.setActionCommand("tutorial");
		imageIcon = new ImageIcon(ImageIO.read(Welcome.class.getResourceAsStream("/Hive2.jpeg")));
		tutorial.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		image = imageIcon.getImage(); // transform it
		newimg = image.getScaledInstance(160, 140, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		imageIcon = new ImageIcon(newimg); // transform it back
		tutorial.setIcon(imageIcon);
		tutorial.setHorizontalTextPosition(JButton.CENTER);
		tutorial.setVerticalTextPosition(JButton.CENTER);
		// play.setMargin(new Insets(0, 0, 0, 0));
		// play.setBorder(BorderFactory.createEmptyBorder());
		// tutorial.setContentAreaFilled(false);
		// panel space>>
		space1 = new JPanel();
		space1.setPreferredSize(new Dimension(50, 102));
		// panel space>>
		space2 = new JPanel();
		space2.setPreferredSize(new Dimension(50, 110));
		// panel space>>
		space3 = new JPanel();
		space3.setPreferredSize(new Dimension(50, 200));
		// panel2>>
		panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		panel2.add(space1);
		panel2.add(play);
		panel2.add(space2);
		panel2.add(tutorial);
		panel2.add(space3);
		this.add(panel2);
		this.setLocation(800, 0);
		this.setVisible(true);
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		Color Background = new Color(255, 110, 0);
		g2.setColor(Background);
		g2.fillRect(0, 0, 300, 650);
		Color border = new Color(225, 210, 0);
		g2.setColor(border);
		g2.fillRect(5, 102, 188, 164);
		g2.fillRect(5, 362, 188, 164);
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		g2.drawString("MENU:", 20, 50);
	}

	public void actionPerformed(ActionEvent evt) {
		if (evt.getActionCommand().equals("play")) {
			playClicked = true;
		}
		if (evt.getActionCommand().equals("tutorial")) {
			tutorialClicked = true;
			Welcome.Klick(900, 250);
			Welcome.Klick(900, 450);
		}
	}

	public static boolean getPlayClicked() {
		return playClicked;
	}

	public static boolean getTutorialClicked() {
		return tutorialClicked;
	}
}

@SuppressWarnings("serial")
class LeftPanel extends JPanel {
	JLabel label1;
	ImageIcon image;

	LeftPanel() throws IOException {
		this.setLayout(null);
		this.setBounds(0, 0, 800, 650);
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		Color Border = new Color(225, 210, 0);
		g2.setColor(Border);
		g2.fillRect(0, 0, 800, 650);
		Color Background = new Color(255, 110, 0);
		g2.setColor(Background);
		g2.fillRect(10, 10, 770, 610);
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 50));
		g2.drawString("HOW TO PLAY", 50, 100);
	}
}