package net.jerickson.javajam.combatant;

import net.jerickson.javajam.weapon.DamageType;
import net.jerickson.javajam.weapon.Strikable;

/**
 * Fightable
 * 
 * Defines a fighter's methods used in the FightingPit. A fighter is expected to have
 * health that will dwindle as they takeDamage(). They are given a weapon at the start
 * and their dealDamage() would, in theory, use that weapon to deal damage.
 */
public interface Fightable {
    /**
     * Calculate how much damage a strike from this Fightable will deal and return it.
     * 
     * @return the damage dealt
     */
    int dealDamage();

    /**
     * Return how much health this Fightable currently has.
     * 
     * @return current health
     */
    int getHealth();

    /**
     * Apply this much damage to this Fightable. Might take all of some of the damage
     * depending on how they take damage and what type of damage it is.
     * 
     * @param damage the amount of damage
     * @param type the type of damage
     * @return how much of the damage they actually took
     */
    int takeDamage(int damage, DamageType type);

    /**
     * Gets the type of damage this Fightable currently deals. Could be from the weapon
     * or from some other means.
     * 
     * @return the type of damage that this Fightable deals
     */
    DamageType getDamageType();

    /**
     * Is this Fightable out of the fight?
     * 
     * @return true if the Fightable is done, false otherwise
     */
    boolean isDead();

    /**
     * Used to assign a new weapon to a Fightable.
     * 
     * @param newWeapon the new weapon to assign to this fighter
     */
    void setWeapon(Strikable newWeapon);

    /**
     * Turn this object into a printable name.
     * 
     * @return a String that is the name you want this Fightable to be known by
     */
    String toString();

    /**
     * Return this Fightable's Strikable
     * 
     * @return the Strikable assigned to this Fightable
     */
    Strikable getWeapon();
}