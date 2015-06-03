package fiuba.algo3.map;

import fiuba.algo3.buildings.Building;
import fiuba.algo3.units.Unit;

public class Earth extends Tile{

	public boolean canBuild(Building b){
		return (b.isEarthBuildable() && building.canOccupy() && unit.canOccupy());
	}

	public void build(Building b){
		if (this.canBuild(b)){
			building = b;
		}
	}

	public boolean canStand(){
		return (building.canOccupy() && unit.canOccupy());
	}

	public void stand(Unit u){
		if (this.canStand()){
			unit = u;
		}
	}

}