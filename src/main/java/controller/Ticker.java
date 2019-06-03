package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Class Ticker.
 *
 * @author Alexis
 */


class Ticker implements ActionListener {
    /**
     * The controller.
     */
    private Controller controller;
    /**
     * The n.
     */
    private int n;
    /**
     * The fin.
     */
    private boolean fin;


    /**
     * Instantiates a new controller.
     *
     * @param controller  the controller
     */

    public Ticker(Controller controller) {
        this.fin = false;
        this.controller = controller;
        n = 0;
    }

    public void actionPerformed(ActionEvent event) {
        if (n % 20 == 0)
            this.controller.plateau.update();

        this.controller.model.update();

        if (n % 50 == 0)
            this.controller.time();

        if (n % 100 == 0) {
            if (this.controller.plateau.exit) {

                if (fin)
                    System.exit(1);

                fin = true;
            }
            System.out.println(fin);
        }


        n++;

        if (n == 10000)
            n = 0;
    }}
