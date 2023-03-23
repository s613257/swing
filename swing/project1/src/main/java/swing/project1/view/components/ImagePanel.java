package swing.project1.view.components;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImagePanel extends JPanel {
	private final String DEFAULT_IMG = "./res/image/no_ima.jpg";
	private BufferedImage image;
	private boolean isEditable;

	public ImagePanel() {
		isEditable = false;
		setDefaultImg();
		addMouseListener(new MouseAdapter() {
			private ImagePanel parent;

			public MouseAdapter init(ImagePanel parent) {
				this.parent = parent;
				return this;
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!isEditable) {
					return;
				}
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("圖片", "jpg", "jpeg", "png");
				fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				fileChooser.setFileFilter(filter);
				int option = fileChooser.showOpenDialog(parent);
				if (option == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					setImage(file);
				}
			}
		}.init(this));
	}

	public void setEditable(boolean isEditable) {
		this.isEditable = isEditable;
	}

	public void setImage(String url) {
		url = (url == null || url.isEmpty()) ? DEFAULT_IMG : url;
		if(url.startsWith("http")) {
			showImage(url);
		}else {
			setImage(new File(url));	
		}
		
	}
	
	private void showImage(String path) {
		 try {
			URL url = new URL(path);
			image = ImageIO.read(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void setImage(File f) {
		try {
			image = ImageIO.read(f);
		} catch (IOException e) {
			e.printStackTrace();
			setDefaultImg();
		} finally {
			revalidate();
			repaint();
		}
	}

	private void setDefaultImg() {
		try {
			image = ImageIO.read(new File(DEFAULT_IMG));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			revalidate();
			repaint();
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
}
