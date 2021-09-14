/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue2D.javafx;

import labyrinthe.ISalle;

/**
 *
 * @author kmannarelli
 */
public class CoupleDeSalle {
    public ISalle u;
    public ISalle v;
    
    public CoupleDeSalle(ISalle u, ISalle v){
        this.u=u;
        this.v=v;
    }
    
    @Override
    public boolean equals(Object obj) {
        CoupleDeSalle other = (CoupleDeSalle) obj;
        if (!this.u.equals(other.u)) {
            return false;
        }
        if (!this.v.equals(other.v)) {
            return false;
        }
        return true;
    }
}
