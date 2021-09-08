package c.uriah.radar;

import java.awt.Color;
import java.util.Iterator;

import dev.rootnet.addons.api.addon.AddonModule;
import dev.rootnet.addons.api.annotations.RootnetModule;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.player.EntityPlayer;

@RootnetModule(name = "Radar", colour = 0x6EB251)
public final class RadarModule extends AddonModule {
	
	public int y;
	private static Minecraft mc = Minecraft.getMinecraft();
	
	@SuppressWarnings({ "rawtypes", "unused" })
	@Override
    public void renderOverlay() {	
		FontRenderer fr = mc.fontRenderer;	
			int y=2;
		    Iterator iterator = mc.world.playerEntities.iterator();
			Gui.drawRect(108, 12, 2,  29, 0x50000000);
			Gui.drawRect(106, 14, 4,  27, new Color(50,205,50, 240).getRGB());
			fr.drawString("Radar-Addon", 6, 17, 0xffffff);

		    for(boolean enabled = true;;){
		         EntityPlayer nextPlayer;
		         do{
		            if (!iterator.hasNext()) {
		            	Gui.drawRect(108, y+27, 2, y+29, 0x50000000);
						return;
		            }

		            nextPlayer = (EntityPlayer)iterator.next();
		         } while(nextPlayer.getName().equals(mc.player.getName()));
		            Gui.drawRect(108, y+27, 2, y+38, 0x50000000);
					Gui.drawRect(106, y+27, 4, y+38, 0x50000000);
		            fr.drawStringWithShadow(nextPlayer.getName()+" " +(int)mc.player.getDistance(nextPlayer), 5, y+29, 0xffffff);
		            y+= fr.FONT_HEIGHT+2;	            
		      }			
		}
}
