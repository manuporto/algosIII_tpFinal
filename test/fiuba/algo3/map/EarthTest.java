package fiuba.algo3.map;

import junit.framework.Assert;
import org.junit.Test;
import fiuba.algo3.player.Player;
import fiuba.algo3.buildings.Building;
import fiuba.algo3.buildings.Barracks;
import fiuba.algo3.buildings.Asimilator;
import fiuba.algo3.buildings.MineralCenter;

public class EarthTest{

	Player player = new Player();
	Buildable earth = new Earth();
	Building barrack = new Barracks(player);
	Building mineralGetter = new MineralCenter(player);
	Building gasGetter = new Asimilator(player);

	@Test
	public void canBuildGasGetterShouldReturnFalse(){
        Assert.assertFalse(earth.canBuild(gasGetter));
	}

	@Test
	public void canBuildMineralGetterShouldReturnFalse(){
        Assert.assertFalse(earth.canBuild(mineralGetter));
	}

	@Test
	public void canBuildBarrackShouldReturnTrue(){
        Assert.assertTrue(earth.canBuild(barrack));
	}

	@Test
	public void canBuildOcupiedShouldReturnFalse(){
		earth.build(barrack);
		Assert.assertFalse(earth.canBuild(barrack));
	}

}