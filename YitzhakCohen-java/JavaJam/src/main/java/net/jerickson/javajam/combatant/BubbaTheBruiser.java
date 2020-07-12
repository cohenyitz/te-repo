package net.jerickson.javajam.combatant;

import net.jerickson.javajam.combatant.classes.Fighter;
import net.jerickson.javajam.weapon.DamageType;

/**
 * BubbaTheBruiser extends Fighter
 */
public class BubbaTheBruiser extends Fighter {

    public BubbaTheBruiser() {
        super(100, 10);
    }

    @Override
    public int takeDamage(int damage, DamageType type) {
        // Bubba don't like the ice
        if(type.equals(DamageType.ICE)) {
            damage *= 2;
        }

        return super.takeDamage(damage, type);
    }

    public String toString() {
        return "Bubba the Bruiser";
    }
}