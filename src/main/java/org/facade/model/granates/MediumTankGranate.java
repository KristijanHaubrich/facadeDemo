package org.facade.model.granates;

import org.facade.granate.Granate;

public class MediumTankGranate implements Granate {
    private int dmg;
    private int penetration;
    public MediumTankGranate(){
        this.dmg = 250;
        this.penetration = 301;
    }
    @Override
    public int getDmg() {
        return dmg;
    }
    @Override
    public int getPenetrarion() {
        return penetration;
    }
}