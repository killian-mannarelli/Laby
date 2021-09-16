/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinthe;

/**
 *
 * @author kmannarelli
 */
public class Salle implements ISalle {

    private int x;
    private int y;

    public Salle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int newX) {
        this.x = newX;
    }

    public void setY(int newY) {
        this.y = newY;
    }

    public boolean estAdjacente(ISalle autre) {
        if ((autre.getX() == getX() + 1 || autre.getX() == getX() - 1) && autre.getY() == getY()) {
            return true;
        } else if ((autre.getY() == getY() + 1 || autre.getY() == getY() - 1) && autre.getX() == getX()) {
            return true;
        }

        return false;

    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

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
