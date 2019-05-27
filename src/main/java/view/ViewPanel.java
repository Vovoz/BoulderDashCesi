package view;

import controller.Controller;
import model.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * The Class ViewPanel.
 *
 * @author Jean-Aymeric Diet
 */
class ViewPanel extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrame					viewFrame;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;

	private Image diamondImage;

	private int nsprite = 0;

	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
		try {
			this.diamondImage = ImageIO.read(new File("Diamond_Bar.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame
	 *          the new view frame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(final Graphics graphics) {
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		Font fonte = new Font(" TimesRoman ",Font.BOLD,30);
		graphics.setFont(fonte);
		graphics.setColor(Color.white);

		System.out.println("update");
		if( this.getViewFrame().getController() != null) {

			for (int n = 0; n < 15; n++)
				for (int i = 0; i < 32; i++) {
					graphics.drawImage(this.getViewFrame().getController().plateau.blocks[n][i].getImage(), i * 32, n * 32, i * 32 + 32, n * 32 + 32, this.getViewFrame().getController().plateau.blocks[n][i].ximg[nsprite], this.getViewFrame().getController().plateau.blocks[n][i].yimg[nsprite], this.getViewFrame().getController().plateau.blocks[n][i].ximg[nsprite] + 16, this.getViewFrame().getController().plateau.blocks[n][i].yimg[nsprite] + 16, this);
				}
			nsprite++;
			if(nsprite == 4)
				nsprite = 0;
			graphics.drawImage(diamondImage,1,1,this);
			graphics.drawString("" + this.getViewFrame().getController().plateau.ndiamond, 70, 45);
		}
		else{
			this.updateUI();
		}

	}

}
