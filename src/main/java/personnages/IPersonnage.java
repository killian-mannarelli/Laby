package personnages;

import java.util.Collection;
import labyrinthe.ISalle;
import labyrinthe.Salle;

/**
*
* @author INFO Professors team
*/
public interface IPersonnage {
    
    // renvoie une salle parmi sallesAccesibles
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles);

    // renvoie sa position courante
    public ISalle getPosition();
    
    // definit sa position courante
    public void setPosition( ISalle s);
    
    @Override
    public boolean equals(Object obj);
        
}
