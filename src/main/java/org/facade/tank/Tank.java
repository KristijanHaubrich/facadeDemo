package org.facade.tank;

import org.facade.granate.Granate;
import org.facade.shooting_result.ShootingResult;

public interface Tank {
    void shoot(Tank tank);
    int currentHP();
    ShootingResult inflictDMG(Granate granate);
    boolean isDestroyed();
    int getDMG();
    int getKills();
}
