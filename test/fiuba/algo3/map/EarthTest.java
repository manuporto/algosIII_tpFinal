package fiuba.algo3.map;

import fiuba.algo3.occupant.Occupant;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import fiuba.algo3.player.Player;
import fiuba.algo3.occupant.buildings.Barracks;
import fiuba.algo3.occupant.buildings.Asimilator;
import fiuba.algo3.occupant.buildings.MineralCenter;
import fiuba.algo3.occupant.units.Marine;

public class EarthTest{

	Player player;
	Tile earth;
	Occupant barrack;
	Occupant mineralGetter;
	Occupant gasGetter;
	Occupant marine;

	@Before
	public void setUp(){
		player = new Player();
		earth = new Earth();
		barrack = new Barracks(player);
		mineralGetter = new MineralCenter(player);
		gasGetter = new Asimilator(player);
		marine = new Marine();
	}

//	tests
//		un gasgetter puede ocupar tierra --> false
//		un mineralgetter puede ocupar tierra --> false
//		una unidad puede ocupar tierra --> true
//		una barraca puede ocupar tierra --> true
//		una unidad puede ocupar tierra ya ocupada --> false
//		una barraca puede ocupar tierra ya ocupada --> false
//		una unidad puede desocupar tierra --> true
//		una barraca puede desocupar tierra --> true
//		una unidad puede ocupar tierra previamente ocupada --> true
//		una barraca puede ocupar tierra previamente ocupada --> true

	@Test
	public void testEarthCanPutGasGetter(){
		Assert.assertFalse(earth.put(gasGetter));
	}

	@Test
	public void testEarthCanPutMineralGetter(){
		Assert.assertFalse(earth.put(mineralGetter));
	}

	@Test
	public void testEarthCanPutMarine(){
		Assert.assertTrue(earth.put(marine));
	}

	@Test
	public void testEarthCanPutBarrack(){
		Assert.assertTrue(earth.put(barrack));
	}

	@Test
	public void testOccupiedEarthCanPutMarine(){
		earth.put(barrack);
		Assert.assertFalse(earth.put(marine));
	}

	@Test
	public void testOccupiedEarthCanPutBarrack(){
		earth.put(marine);
		Assert.assertFalse(earth.put(barrack));
	}

	@Test
	public void testOccupiedEarthWithMarineCanDraw(){
		earth.put(barrack);
		Assert.assertTrue(earth.draw());
	}

	@Test
	public void testOccupiedEarthWithBarrackCanDraw(){
		earth.put(marine);
		Assert.assertTrue(earth.draw());
	}

	@Test
	public void testVacatedEarthCanPutMarine(){
		earth.put(barrack);
		earth.draw();
		Assert.assertTrue(earth.put(marine));
	}

	@Test
	public void testVacatedEarthCanPutBarrack(){
		earth.put(marine);
		earth.draw();
		Assert.assertTrue(earth.put(barrack));
	}

}