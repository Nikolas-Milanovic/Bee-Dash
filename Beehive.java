
 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
public class Beehive {
	public int x, y;
	public boolean[] isEntrance = new boolean[6];
	public int[] X = new int[6];
	public int[] Y = new int[6];
	public int[] xpoints = new int[3];
	public int[] ypoints = new int[3];
	public static final int size = 60;
	public int V;
	public int vx = 1;
	public int vy = 1;
	public static final double sqrt3 = 1.7320508075688772;

	/**
	 * x and y are the coordinates of the center of the beehive
	 * 
	 * @param V speed between 0 and 10
	 */
	public Beehive(int V) {
		int entrance = (int) (6 * Math.random());
		if (entrance == 0) {
			isEntrance[0] = true;
			isEntrance[5] = true;
		} else {
			isEntrance[entrance] = true;
			isEntrance[entrance - 1] = true;
		}
		x = 300 + (int) (Math.random() * 400);
		y = 300 + (int) (Math.random() * 200);

		this.V = V;
		Y[0] = y - size;
		Y[1] = Y[5] = y - size / 2;
		Y[2] = Y[4] = y + size / 2;
		Y[3] = y + size;

		X[4] = X[5] = x - (int) (size * sqrt3 / 2 + 0.5);
		X[0] = X[3] = x;
		X[1] = X[2] = x + (int) (size * sqrt3 / 2 + 0.5);
		t1 = new Timer(Integer.MAX_VALUE, (ActionEvent e) -> {
			int v = (int) (15 * Math.random()) + 1;
			vx = v & 3;
			vy = v >> 2;
			if (this.x > 500)
				vx *= -1;
			if (this.y > 400)
				vy *= -1;
		});
		t = new Timer(Integer.MAX_VALUE, (ActionEvent e) -> {
			update();
		});
		t1.start();
		t.start();
	}

	public Timer t;
	public Timer t1;

	public void increaseSpeed() {
		V++;
		// System.out.println(V);
		t1 = new Timer(15000 / V, (ActionEvent e) -> {
			int v = (int) (15 * Math.random()) + 1;
			vx = v & 3;
			vy = v >> 2;
			if (this.x > 500)
				vx *= -1;
			if (this.y > 400)
				vy *= -1;
		});
		t = new Timer(200 / V, (ActionEvent e) -> {
			update();
		});
		t1.restart();
		t.restart();
	}

	public void update() {
		for (int i = 0; i < 6; i++) {
			X[i] += vx;
			Y[i] += vy;
		}
		x += vx;
		y += vy;
	}

	/**
	 * 
	 * @param o the Bee
	 * @return 2 if the Bee collides with a wall, 1 if the Bee enters the Beehive, 0 otherwise.
	 */
	public int intersects(Bee o) {
		boolean isTouched = false;

		int dx = o.x - x;
		int dy = o.y - y;
		int ret = intersects0(dx, -dy);
		if (ret == 1)
			return 1;
		else if (ret == 2)
			isTouched = true;
		// System.out.println();
		dx = o.x + o.width - x;
		dy = o.y - y;
		ret = intersects0(dx, -dy);
		if (ret == 1)
			return 1;
		else if (ret == 2)
			isTouched = true;
		// System.out.println();
		dx = o.x + o.width - x;
		dy = o.y + o.height - y;
		ret = intersects0(dx, -dy);
		if (ret == 1)
			return 1;
		else if (ret == 2)
			isTouched = true;
		// System.out.println();
		dx = o.x - x;
		dy = o.y + o.height - y;
		ret = intersects0(dx, -dy);
		if (ret == 1)
			return 1;
		else if (ret == 2)
			isTouched = true;
		// System.out.println();
		System.out.println();
		if (isTouched)
			return 2;
		return 0;
	}

	public int intersects0(int dx, int dy) {
		int r = (int) Math.sqrt(dx * dx + dy * dy);
		double t = Math.acos((dx + 0.0) / (r + 0.0));
		if (dy < 0)
			t = Math.PI * 2.0 - t;
		boolean isTouched = false;
		// System.out.println(r+" "+t);
		int R = (int) (size / (Math.sin(t) - (1.0 / sqrt3) * Math.cos(t)));
		// System.out.print(R+" ");
		if (t >= Math.PI / 2.0 && t <= 5.0 * Math.PI / 6.0 && r < R) {

			if (isEntrance[0])
				return 1;
			else isTouched = true;
		}
		/*
		 * else if(t>=Math.PI/2.0&&t<=5.0*Math.PI/6.0){ System.out.println(R+"*0"); }
		 */
		R *= -1;
		if (t >= 3.0 * Math.PI / 2.0 && t <= 11.0 * Math.PI / 6.0 && r < R) {

			if (isEntrance[3])
				return 1;
			else isTouched = true;
		}
		/*
		 * else if(t>=3.0*Math.PI/2.0&&t<=11.0*Math.PI/6.0){ System.out.println(R+"*3"); }
		 */
		R = (int) (size / (Math.sin(t) + (1.0 / sqrt3) * Math.cos(t)));
		// System.out.print(R+" ");
		if (t >= Math.PI / 6.0 && t <= Math.PI / 2.0 && r < R) {

			if (isEntrance[1])
				return 1;
			else isTouched = true;
		}
		/*
		 * else if(t>=Math.PI/6.0&&t<=Math.PI/2.0){ System.out.println(R+"*1"); }
		 */
		R *= -1;
		if (t >= 7.0 * Math.PI / 6.0 && t <= 3.0 * Math.PI / 2.0 && r < R) {

			if (isEntrance[4])
				return 1;
			else isTouched = true;
		}
		/*
		 * else if(t>=7.0*Math.PI/6.0&&t<=3.0*Math.PI/2.0){ System.out.println(R+"*4"); }
		 */
		R = (int) (size * sqrt3 / (2 * Math.cos(t)));
		// System.out.println(R+" "+Math.cos(t));
		if ((t >= 11.0 * Math.PI / 6.0 || t <= Math.PI / 6.0) && r < R) {

			if (isEntrance[2])
				return 1;
			else isTouched = true;
		}
		/*
		 * else if(t>=11.0*Math.PI/6.0||t<=Math.PI/6.0){ System.out.println(R+" "+Math.cos(t)+"*2"); }
		 */
		R *= -1;
		if (t >= 5.0 * Math.PI / 6.0 && t <= 7.0 * Math.PI / 6.0 && r < R) {

			if (isEntrance[5])
				return 1;
			else isTouched = true;
		}
		/*
		 * else if(t>=5.0*Math.PI/6.0&&t<=7.0*Math.PI/6.0){ System.out.println(R+" "+Math.cos(t)+"*5"); }
		 */
		if (isTouched)
			return 2;
		return 0;
	}

	public void draw(Graphics g) {
		xpoints[0] = x;
		ypoints[0] = y;
		xpoints[1] = X[5];
		ypoints[1] = Y[5];
		for (int i = 0; i < 6; i++) {
			if ((i & 1) == 0) {
				xpoints[2] = X[i];
				ypoints[2] = Y[i];
			} else {
				xpoints[1] = X[i];
				ypoints[1] = Y[i];
			}
			if (!isEntrance[i])
				g.setColor(new Color(255, 255, 0));
			g.fillPolygon(xpoints, ypoints, 3);
			g.setColor(new Color(0, 0, 0));
			g.drawPolygon(xpoints, ypoints, 3);
		}
	}
}
//class Testing extends JFrame {
//  // Beehive hive = new Beehive(Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Speed between 0 and 10", "", 1)));
//
//  public static void main(String[] args) {
//      Testing test = new Testing();
//  }
//
//  public Testing() {
//      setSize(1000, 800);
//      setVisible(true);
//      setDefaultCloseOperation(3);
//      JLabel l = new JLabel();
//      BufferedImage bi = new BufferedImage(1000, 800, 2);
//      Graphics g = bi.getGraphics();
//      Timer t = new Timer(2, (ActionEvent e) -> {
//          g.setColor(new Color(0, 255, 0));
//          g.fillRect(0, 0, 1000, 800);
//          g.setColor(new Color(0, 0, 0));
//          hive.draw(g);
//          l.setIcon(new ImageIcon(bi));
//          add(l);
//          setVisible(true);
//      });
//      t.start();
//  }
//}
