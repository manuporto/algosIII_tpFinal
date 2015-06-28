package fiuba.algo3.occupant.buildings;

import fiuba.algo3.exceptions.BuildingNotReadyException;
import fiuba.algo3.map.AlgoCraftMap;
import fiuba.algo3.map.Coordinates;
import fiuba.algo3.player.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mporto on 30/05/15.
 */
public class BuildingInConstructionTest {

    private Player player;
    private MineralGetter aMineralGetter;
    private BuildingInConstruction aBuildingInConstruction;

    @Before
    public void setUp() throws Exception {
        this.player = new Player((new AlgoCraftMap(1)).testMap());
        this.aMineralGetter = new MineralNexus(player, new Coordinates(0, 0));
        this.aBuildingInConstruction = new BuildingInConstruction(aMineralGetter, new Coordinates(0, 0));
    }

    @Test
    public void testBuildingTimeEqualsToTheOneOfTheBuildingOnInitialize() throws Exception {
        assertEquals(this.aMineralGetter.getConstructionTime(), this.aBuildingInConstruction.getRemainingTurns());
    }

    @Test
    public void testBuildingTimeAfterOneTurnDecreases() throws Exception {
        aBuildingInConstruction.passTurn();

        assertEquals(this.aMineralGetter.getConstructionTime() - 1, this.aBuildingInConstruction.getRemainingTurns());
    }

    @Test (expected = BuildingNotReadyException.class)
    public void testGetBuildingInConstructionRaisesAnExceptionWhenNotReady() throws Exception {
        assertEquals(this.aMineralGetter, this.aBuildingInConstruction.getBuildingInConstruction());
    }

    @Test
    public void testBuildingIsNotFinishedWhileTrainingTimeIsGreaterThanZero() throws Exception {
        assertFalse(this.aBuildingInConstruction.isReady());
    }

    @Test
    public void testVitalityIsTheSameAsBuildingBeingConstructed() {
        assertEquals(250, this.aBuildingInConstruction.getVitality());
    }

    @Test
    public void testMineralGeterGetterInConstructionCannotOccupyGas() {
        assertFalse(this.aBuildingInConstruction.canOccupyGas());
    }
}