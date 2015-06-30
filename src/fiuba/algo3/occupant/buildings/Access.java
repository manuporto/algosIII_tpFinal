package fiuba.algo3.occupant.buildings;

import fiuba.algo3.exceptions.InsufficientAvailablePopulationException;
import fiuba.algo3.exceptions.InsufficientResourcesException;
import fiuba.algo3.exceptions.SubtractedResourcesGreaterThanStoragedException;
import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.Life;
import fiuba.algo3.map.Coordinates;
import fiuba.algo3.occupant.units.UnitInTraining;
import fiuba.algo3.occupant.units.Zealot;
import fiuba.algo3.player.Player;

import java.util.LinkedList;
import java.util.Queue;

public class Access extends UnitCreator{

    private Queue<UnitInTraining> trainingQueue;

    public Access(Player player, Coordinates coordinate) {
    	super(player, coordinate);
        this.constructionCost = new Cost(150, 0);
        this.constructionTime = 8;
        this.life = new Life(500, 500);
        this.trainingQueue = new LinkedList<UnitInTraining>();
    }

    @Override
    public void trainUnit() throws InsufficientAvailablePopulationException,
            InsufficientResourcesException, SubtractedResourcesGreaterThanStoragedException {
        Zealot aZealotToBeTrained = new Zealot();
        this.owner.canTrain(aZealotToBeTrained);
        this.chargeUnitRequirementsToOwner(aZealotToBeTrained);
        UnitInTraining aZealotInTraining = new UnitInTraining(aZealotToBeTrained);
        this.trainingQueue.add(aZealotInTraining);
    }
}