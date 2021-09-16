/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinthe;


/**
 *  Class Salle.
 *
 * @author kmannarelli
 */
public class Salle implements ISalle {

    
    private int x;
    
    
    private int y;

    /**
     *Constructeur de la classe salle.
     *
     * @param x x de la salle
     * @param y  y de la salle
     */
    public Salle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets  x.
     *
     * @return  x
     */
    public int getX() {
        return x;
    }

    /**
     * Gets  y.
     *
     * @return  y
     */
    public int getY() {
        return y;
    }

    /**
     * Sets  x.
     *
     * @param newX  nouveau x
     */
    public void setX(int newX) {
        this.x = newX;
    }

    /**
     * Sets  y.
     *
     * @param newY  nouveau y
     */
    public void setY(int newY) {
        this.y = newY;
    }

    /**
     * Dit si une salle est adjacente à une autre.
     *
     * @param autre l'autre salle
     * @return true, if successful
     */
    public boolean estAdjacente(ISalle autre) {
        if ((autre.getX() == getX() + 1 || autre.getX() == getX() - 1) && autre.getY() == getY()) {
            return true;
        } else if ((autre.getY() == getY() + 1 || autre.getY() == getY() - 1) && autre.getX() == getX()) {
            return true;
        }

        return false;

    }
    
    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    /**
     * Equals.
     *
     * @param obj the obj
     * @return true, if successful
     */
    @Override
    public boolean equals(Object obj) {
        Salle other = (Salle) obj;
        if (getX() != other.getX()) {
            return false;
        }
        if (getY() != other.getY()) {
            return false;
        }
        return true;
    }

}
