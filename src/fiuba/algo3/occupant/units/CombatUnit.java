package fiuba.algo3.occupant.units;

import fiuba.algo3.gameVariables.AttackRange;
import fiuba.algo3.gameVariables.Damage;
import fiuba.algo3.map.Coordinates;
import fiuba.algo3.occupant.Damageable;
import fiuba.algo3.occupant.Occupant;

/**
 * Created by mporto on 04/06/15.
 */
public class CombatUnit extends Unit{

    AttackRange attackRange;
    Damage  damage;

    public void attack(Damageable attacked) {
        if(this.isWithinRange((Occupant) attacked)) {
            // In the meantime the attacked will always receive groundDamage.
            attacked.receiveDamage(damage);
        }else{
            Damage noDamage = new Damage(0, 0);
            attacked.receiveDamage(noDamage);
        }
    }

    public int getGroundAttackRange() {
        return attackRange.getGroundRange();
    }

    public int getAirAttackRange() {
        return attackRange.getAirRange();
    }

    public int getGroundDamage() {
        return damage.getGroundDamage();
    }

    public int getAirDamage() {
        return damage.getAirDamage();
    }

    public boolean isWithinRange(Occupant occupant) {
        Coordinates unitPosition = occupant.getPosition();
        int distance = this.position.distance(unitPosition);
        // In the meantime this will only check with the unit's ground attack range.
        return !(distance > this.getGroundAttackRange());
    }
}
