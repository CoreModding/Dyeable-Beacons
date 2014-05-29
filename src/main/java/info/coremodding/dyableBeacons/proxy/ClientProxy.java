package info.coremodding.dyableBeacons.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import info.coremodding.dyableBeacons.render.tileEntity.TileEntityDyableBeaconRenderer;
import info.coremodding.dyableBeacons.tileEntity.TileEntityDyableBeacon;

public class ClientProxy extends CommonProxy {
	
	public void registerRender() {
		 ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDyableBeacon.class, new TileEntityDyableBeaconRenderer());
	}
}
