package net.jerickson.javajam.weapon;

import net.jerickson.javajam.weapon.classes.Sword;

/**
 * IceNedStarkSword
 */
public class IceNedStarkSword extends Sword {
    
    public IceNedStarkSword() {
        super(8, 1);
    }

    public String toString() {
        return "Ice, the Sword of Ned Stark";
    }

    public DamageType getDamageType() {
        return DamageType.ICE;
    }
}