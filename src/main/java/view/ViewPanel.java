package view;

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
 * @author Alexis
 */
class ViewPanel extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrame					viewFrame;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;

	private Image diamondBar;
	private Image timerBar;

	private int nsprite = 0;


	public final int tailleB = 64;
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
			this.diamondBar = ImageIO.read(new File("Diamond_Bar.png"));
			this.timerBar = ImageIO.read(new File("Timer_Bar.png"));

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

		//System.out.println("...");
		if( this.getViewFrame().getController().plateau != null) {

			int x;
			int y;
			x =this.getViewFrame().getController().plateau.xplayer * this.tailleB / 3;
			y = this.getViewFrame().getController().plateau.yplayer * this.tailleB / 3;
			for (int n = 0; n < this.getViewFrame().getController().plateau.ymax; n++)
				for (int i = 0; i < this.getViewFrame().getController().plateau.xmax; i++) {
					graphics.drawImage(this.getViewFrame().getController().plateau.blocks[n][i].getImage(),
							i * tailleB - x, n * tailleB - y, i * tailleB + tailleB - x, n * tailleB + tailleB - y,
							this.getViewFrame().getController().plateau.blocks[n][i].ximg[nsprite / 10],
							this.getViewFrame().getController().plateau.blocks[n][i].yimg[nsprite / 10],
							this.getViewFrame().getController().plateau.blocks[n][i].ximg[nsprite / 10] + 16,
							this.getViewFrame().getController().plateau.blocks[n][i].yimg[nsprite / 10] + 16, this);
				}
			nsprite++;
			if(nsprite == 40)
				nsprite = 0;
			graphics.drawImage(diamondBar,1,1,this);
			graphics.drawImage(timerBar,1,61,this);
			graphics.drawString("" + this.getViewFrame().getController().plateau.ndiamond, 70, 44);
			graphics.drawString("" + this.getViewFrame().getController().seconde, 70, 104);
		}
		else{
			this.updateUI();
		}

	}

}
