package net.jerickson.javajam.combatant.classes;

import net.jerickson.javajam.combatant.Fightable;
import net.jerickson.javajam.weapon.DamageType;
import net.jerickson.javajam.weapon.Strikable;

/**
 
 */
public abstract class Fighter implements Fightable {

    private Strikable weapon;
    private int health;
    private int damageModifier;

    public Fighter(int health, int damageModifier) {
        this.health = health;
        this.damageModifier = damageModifier;
    }

	public int dealDamage() {
		return weapon.dealDamage() + damageModifier;
	}

	public int getHealth() {
		return health;
	}

	public int takeDamage(int damage, DamageType type) {
		health -= damage;
		return damage;
	}

	public DamageType getDamageType() {
		return weapon.getDamageType();
	}

	public boolean isDead() {
		return health <= 0;
	}

	public void setWeapon(Strikable newWeapon) {
		weapon = newWeapon;
	}

	public Strikable getWeapon() {
		return weapon;
	}

    
}