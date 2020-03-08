
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Bee extends Rectangle {
	public ArrayList<Integer> getValX() {
		return valX;
	}

	public void setValX(ArrayList<Integer> valX) {
		this.valX = valX;
	}

	public ArrayList<Integer> getValY() {
		return valY;
	}

	public void setValY(ArrayList<Integer> valY) {
		this.valY = valY;
	}

	public int getAutoX() {
		return autoX;
	}

	public void setAutoX(int autoX) {
		this.autoX = autoX;
	}

	public int getAutoY() {
		return autoY;
	}

	public void setAutoY(int autoY) {
		this.autoY = autoY;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}

	public boolean isAutoEntered() {
		return autoEntered;
	}

	public void setAutoEntered(boolean autoEntered) {
		this.autoEntered = autoEntered;
	}

	ArrayList<Integer> valX = new ArrayList<Integer>();
	ArrayList<Integer> valY = new ArrayList<Integer>();

	public int getLastX() {
		return lastX;
	}

	public void setLastX(int lastX) {
		this.lastX = lastX;
	}

	public int getLastY() {
		return lastY;
	}

	public void setLastY(int lastY) {
		this.lastY = lastY;
	}

	private int autoX = 1, autoY = (int) (Math.random() * 4 + -4), count = 0, side, lastX, lastY;
	private ImageIcon beeIcon;
	private boolean autoEntered = true;
	private Image image;
	private double deg = 0;
	private double lastdeg = 0;
	private AffineTransform tx;
	private AffineTransformOp op;
	private int entered = 0;
	// ImageIcon img;

	public Bee(int x, int y, int width, int height) {
		super(x, y, 50, 60);
		// this.img = img;
	}

	public void autoBee() {
		if (side == 1) {
			x = -80;
			y = (int) (Math.random() * 4 + 3) * 100;
			autoX = 1;
			if (y % 2 == 0) {
				autoY = (int) (Math.random() * 2 + 1);
			} else {
				autoY = (int) (Math.random() * -1 + -2);
			}
		} else if (side == 2) {
			x = (int) (Math.random() * 7 + 3) * 100;
			y = -80;
			autoY = (int) (Math.random() * 2 + 1);
			if (x % 2 == 0) {
				autoX = 1;
			} else {
				autoX = -1;
			}
		} else if (side == 3) {
			x = 1000;
			y = (int) (Math.random() * 4 + 3) * 100;
			autoX = -1;
			if (y % 2 == 0) {
				autoY = (int) (Math.random() * 2 + 1);
			} else {
				autoY = (int) (Math.random() * -1 + -2);
			}
		} else if (side == 4) {
			x = (int) (Math.random() * 7 + 3) * 100;
			y = 800;
			autoY = (int) (Math.random() * -1 + -2);
			if (x % 2 == 0) {
				autoX = 1;
			} else {
				autoX = -1;
			}
		}
	}

	public void bounceBee() {
		if (5 >= x) {
			autoX = 1;

		}
		if (x >= 930) {
			autoX = -1;

		}
		if (5 >= y && autoY < 0) {
			autoY = autoY * (-1);

		}
		if (y >= 720 && autoY > 0) {
			autoY = autoY * (-1);

		}
	}

	public double angleInRelation(int x1, int y1, int x2, int y2) {
		// Point 1 in relation to point 2
		int xdiff = Math.abs(x2 - x1);
		int ydiff = Math.abs(y2 - y1);
		double deg = 361;
		if ((x2 > x1) && (y2 < y1)) {
			// Quadrant 1
			deg = Math.toDegrees(Math.atan(Math.toRadians(ydiff) / Math.toRadians(xdiff)));

		} else if ((x2 > x1) && (y2 > y1)) {
			// Quadrant 2
			deg = 90 + Math.toDegrees(Math.atan(Math.toRadians(ydiff) / Math.toRadians(xdiff)));

		} else if ((x2 < x1) && (y2 > y1)) {
			// Quadrant 3
			deg = 180 + Math.toDegrees(Math.atan(Math.toRadians(xdiff) / Math.toRadians(ydiff)));

		} else if ((x2 < x1) && (y2 < y1)) {
			// Quadrant 4
			deg = 270 + Math.toDegrees(Math.atan(Math.toRadians(ydiff) / Math.toRadians(xdiff)));

		} else if ((x2 == x1) && (y2 < y1)) {
			deg = 0;

		} else if ((x2 == x1) && (y2 > y1)) {
			deg = 180;

		} else if ((y2 == y1) && (x2 > x1)) {
			deg = 90;

		} else if ((y2 == y1) && (x2 < x1)) {
			deg = 270;

		}
		if (deg == 361) {
			deg = lastdeg;
		}

		return deg;
	}

	public boolean speedAvoid(int intial, int fin) {
		int diff = Math.abs(fin - intial);
		if (diff >= 15 && count != valX.size()) { // the value represent the max distance allowed between coordinates

			return false;
		}
		if (count == valX.size() && diff >= image.getWidth(null)) {
			return false;
		}
		return true;
	}

	public void BeeAutoMovement(int x1, int y1, int x2, int y2) {
		// System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);
		try {
			autoY = (y2 - y1) / (x2 - x1);
		} catch (Exception e) {
			if (y2 > y1) {
				autoY = 1;
			} else {
				autoY = -1;
			}
		}

		// System.out.println(autoY);
		if (x1 < x2) {
			autoX = 1;
		} else if (x1 > x2) {
			autoY = -1 * autoY;
			autoX = -1;
		} else if (x1 == x2) {
			autoX = 0;
		}
		autoEntered = false;
	}

	public void draw(Graphics g) throws IOException {
		Graphics2D g2 = (Graphics2D) g;
		beeIcon = new ImageIcon(ImageIO.read(Bee.class.getResourceAsStream("/bee-3.png")));
		image = beeIcon.getImage();
		g2.setColor(Color.BLACK);
		double locationX = image.getWidth(null) / 2;
		double locationY = image.getHeight(null) / 2;
		if (entered == 0) {
			tx = AffineTransform.getRotateInstance(Math.toRadians(0), locationX, locationY);
			op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		}
		entered++;
		if (count < valX.size()) {
			autoEntered = true;
			for (int i = count; i < valX.size(); i += 5) { // draw dots
				g2.fillOval(valX.get(i), valY.get(i), 4, 4);
			}
			if (count % 4 == 0) {
				try {
					deg = angleInRelation(valX.get(count), valY.get(count), valX.get(count + 5), valY.get(count + 5));
					lastdeg = deg;

				} catch (Exception e) {
					deg = lastdeg;
				}
			}
			tx = AffineTransform.getRotateInstance(Math.toRadians(deg), locationX, locationY);
			op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
			x = valX.get(count) - image.getWidth(null) / 2;
			y = valY.get(count) - image.getHeight(null) / 2;
			g2.drawImage(op.filter((BufferedImage) image, null), x, y, null);
			count++;
		} else {
			if (valX.size() > 0) { // if no more values then prints objects last position
				if (autoEntered == true) {
					try {
						BeeAutoMovement(valX.get(count - 10), valY.get(count - 10), valX.get(count - 1), valY.get(count - 1));
					} catch (Exception e) {
						BeeAutoMovement(valX.get(count - 1), valY.get(count - 1), valX.get(count - 1), valY.get(count - 1));
					}
					x = valX.get(count - 1) - image.getWidth(null) / 2;
					y = valY.get(count - 1) - image.getHeight(null) / 2;
				}
				bounceBee();
				deg = angleInRelation(x, y, x + autoX, y + autoY);
				tx = AffineTransform.getRotateInstance(Math.toRadians(deg), locationX, locationY);
				op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
				g2.drawImage(op.filter((BufferedImage) image, null), x, y, null);
				if (autoY > 3) {

					autoY = 3;

				}
				if (autoY < -3) {
					autoY = -3;

				}
				x += autoX;
				y += autoY;

			} else {
				bounceBee();
				deg = angleInRelation(x, y, x + autoX, y + autoY);
				tx = AffineTransform.getRotateInstance(Math.toRadians(deg), locationX, locationY);
				op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

				g2.drawImage(op.filter((BufferedImage) image, null), x, y, null);
				x += autoX;
				y += autoY;
			}
		}
	}
}