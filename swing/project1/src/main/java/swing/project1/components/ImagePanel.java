package swing.project1.components;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	private final String DEFAULT_IMG = "./res/image/no_ima.jpg";
	private BufferedImage image;

	public ImagePanel() {
		try {
			// TODO
			image = ImageIO.read(new File(DEFAULT_IMG));
		} catch (IOException ex) {

		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int imgWidth = image.getWidth(null);
		int imgHeight = image.getHeight(null);

		double imgAspect = (double) imgHeight / imgWidth;

		int canvasWidth = getWidth();
		int canvasHeight = getHeight();

		double canvasAspect = (double) canvasHeight / canvasWidth;

		int x1 = 0; // top left X position
		int y1 = 0; // top left Y position
		int x2 = 0; // bottom right X position
		int y2 = 0; // bottom right Y position

		if (imgWidth < canvasWidth && imgHeight < canvasHeight) {
			// the image is smaller than the canvas
			x1 = (canvasWidth - imgWidth) / 2;
			y1 = (canvasHeight - imgHeight) / 2;
			x2 = imgWidth + x1;
			y2 = imgHeight + y1;

		} else {
			if (canvasAspect > imgAspect) {
				y1 = canvasHeight;
				// keep image aspect ratio
				canvasHeight = (int) (canvasWidth * imgAspect);
				y1 = (y1 - canvasHeight) / 2;
			} else {
				x1 = canvasWidth;
				// keep image aspect ratio
				canvasWidth = (int) (canvasHeight / imgAspect);
				x1 = (x1 - canvasWidth) / 2;
			}
			x2 = canvasWidth + x1;
			y2 = canvasHeight + y1;
		}

		g.drawImage(image, x1, y1, x2, y2, 0, 0, imgWidth, imgHeight, null);
	}

	public void setImage(String url) {
		try {
			url = url.isEmpty() ? DEFAULT_IMG : url;
			image = ImageIO.read(new File(url));
			repaint();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
