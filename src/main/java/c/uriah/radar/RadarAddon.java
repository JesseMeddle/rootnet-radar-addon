package c.uriah.radar;

import dev.rootnet.addons.api.addon.Addon;
import dev.rootnet.addons.api.annotations.RootnetAddon;

import org.apache.logging.log4j.Level;

@RootnetAddon(name = "Radar", author = "Uriah C.", version = "#VERSION#")

public final class RadarAddon extends Addon {

    public RadarAddon() {
    }

    @Override
    public void init() {
        super.init();
        log(Level.INFO, "Initializing Radar-Addon");
        getRootnet().registerModule(this, new RadarModule());
    }

}