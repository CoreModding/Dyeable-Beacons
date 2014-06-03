package info.coremodding.dyableBeacons.proxy;

import net.minecraft.block.Block;
import info.coremodding.dyableBeacons.blocks.BlockDyableBeacon;
import info.coremodding.dyableBeacons.render.blocks.RenderDyableBeacons;
import info.coremodding.dyableBeacons.render.tileEntity.TileEntityDyableBeaconRenderer;
import info.coremodding.dyableBeacons.tileEntity.TileEntityDyableBeacon;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	
	public void registerRender() {
		 ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDyableBeacon.class, new TileEntityDyableBeaconRenderer());
	
		 BlockDyableBeacon.renderID = RenderingRegistry.getNextAvailableRenderId();
		 ISimpleBlockRenderingHandler renderDyableBeacons = new RenderDyableBeacons();
		 RenderingRegistry.registerBlockHandler(BlockDyableBeacon.renderID , renderDyableBeacons);
	
	}
}
