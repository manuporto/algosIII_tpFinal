package fiuba.algo3.map;

import fiuba.algo3.occupant.Occupant;
import org.junit.Test;
import org.junit.Before;
import fiuba.algo3.player.Player;
import fiuba.algo3.occupant.buildings.Barracks;
import fiuba.algo3.occupant.buildings.Asimilator;
import fiuba.algo3.occupant.buildings.MineralCenter;
import fiuba.algo3.occupant.units.Marine;
import fiuba.algo3.exceptions.CannotOccupyTileException;

public class MineralTest{

	Player player;
	Tile mineral;
	Occupant barrack;
	Occupant mineralGetter;
	Occupant gasGetter;
	Occupant marine;

	@Before
	public void setUp(){
		player = new Player();
		mineral = new Mineral();
		barrack = new Barracks(player, 0, 0);
		mineralGetter = new MineralCenter(player);
		gasGetter = new Asimilator(player);
		marine = new Marine();
	}

//	tests
//		un gasgetter puede ocupar mineral --> false
//		un mineralgetter puede ocupar mineral --> true
//		una unidad puede ocupar mineral --> false
//		una barraca puede ocupar mineral --> false
//		un mineralGetter puede ocupar mineral ya ocupada --> false
//		un mineralGetter puede desocupar mineral --> true
//		un mineralGetter puede ocupar mineral previamente ocupada --> true

	@Test (expected = CannotOccupyTileException.class)
	public void testMineralCanPutGasGetter() throws CannotOccupyTileException{
		mineral.put(gasGetter);
	}

	@Test
	public void testMineralCanPutMineralGetter() throws CannotOccupyTileException{
		mineral.put(mineralGetter);
	}

	@Test (expected = CannotOccupyTileException.class)
	public void testMineralCanPutMarine() throws CannotOccupyTileException{
		mineral.put(marine);
	}

	@Test (expected = CannotOccupyTileException.class)
	public void testMineralCanPutBarrack() throws CannotOccupyTileException{
		mineral.put(barrack);
	}

	@Test (expected = CannotOccupyTileException.class)
	public void testOccupiedMineralCanPutMineralGetter() throws CannotOccupyTileException{
		mineral.put(mineralGetter);
		mineral.put(mineralGetter);
	}

	@Test
	public void testOccupiedMineralWithMineralGetterCanDraw() throws CannotOccupyTileException{
		mineral.put(mineralGetter);
		mineral.draw();
	}

	@Test
	public void testVacatedMineralCanPutMineralGetter() throws CannotOccupyTileException{
		mineral.put(mineralGetter);
		mineral.draw();
		mineral.put(mineralGetter);
	}

}