package org.facade.model.granates;

import org.facade.granate.Granate;

public class LightTankGranate implements Granate {
    private int dmg;
    private int penetration;

    public LightTankGranate(){
        this.dmg = 350;
        this.penetration = 303;
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
