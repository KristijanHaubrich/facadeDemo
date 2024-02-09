package org.facade.model.granates;

import org.facade.granate.Granate;

public class HeavyTankGranate implements Granate {
    private int dmg;
    private int penetration;
    public HeavyTankGranate(){
        this.dmg = 500;
        this.penetration = 202;
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
