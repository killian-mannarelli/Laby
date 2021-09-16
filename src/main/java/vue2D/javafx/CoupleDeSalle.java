
package vue2D.javafx;

import java.util.Objects;
import labyrinthe.ISalle;


/**
 *  Class CoupleDeSalle.
 *
 * @author kmannarelli
 */
public class CoupleDeSalle {
    
   
    public ISalle u;
    
   
    public ISalle v;
    
    /**
     * Constructeur de couple de salle.
     *
     * @param u première salle
     * @param v seconde salle
     */
    public CoupleDeSalle(ISalle u, ISalle v){
        this.u=u;
        this.v=v;
    }
    
    /**
     * Equals.
     *
     * @param obj the obj
     * @return true, if successful
     */
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

    /**
     * Hash code.
     *
     * @return hashcode
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.u);
        hash = 23 * hash + Objects.hashCode(this.v);
        return hash;
    }
}
