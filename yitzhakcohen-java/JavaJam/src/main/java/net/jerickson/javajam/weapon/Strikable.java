package net.jerickson.javajam.weapon;

/**
 * Strikable
 * 
 * Interface that defines a weapon or spell or other object that is usable as a damage
 * dealer in Java Jam.
 */
public interface Strikable {

    /**
     * Run every round in order to calculate damage to another fighter. Could also do
     * other things, like skip a round to recharge.
     */
    int dealDamage();

    /**
     * Specifies the type of damage that this Strikable deals. From the {@link DamageType} enum.
     */
    DamageType getDamageType();

    /**
     * Returns the printable name for the Strikable
     * 
     * @return the name you want the Strikable to be known by
     */
    String toString();
}