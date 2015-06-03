package fiuba.algo3.buildings;

import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.Life;
import fiuba.algo3.player.Player;
import fiuba.algo3.units.Marine;
import fiuba.algo3.units.UnitInTraining;

/**
 * Created by mporto on 30/05/15.
 */
public class Barracks extends Building{

    public Barracks(Player owner) {
    	this.owner = owner;
        this.constructionCost = new Cost(150, 0);
        this.constructionTime = 12;
        this.life = new Life(1000, 0);
    }

    public UnitInTraining trainMarine() {
        Marine aMarineToBeTrained = new Marine();
        UnitInTraining aMarineInTraining = new UnitInTraining(aMarineToBeTrained);
        return aMarineInTraining;
    }
}
