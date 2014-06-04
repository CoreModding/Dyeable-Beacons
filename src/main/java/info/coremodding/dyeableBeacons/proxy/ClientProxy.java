package info.coremodding.dyeableBeacons.proxy;

import net.minecraft.block.Block;
import info.coremodding.dyeableBeacons.blocks.BlockDyeableBeacon;
import info.coremodding.dyeableBeacons.render.blocks.RenderDyeableBeacons;
import info.coremodding.dyeableBeacons.render.tileEntity.TileEntityDyeableBeaconRenderer;
import info.coremodding.dyeableBeacons.tileEntity.TileEntityDyableBeacon;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	
	public void registerRender() {
		 ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDyableBeacon.class, new TileEntityDyeableBeaconRenderer());
	
		 BlockDyeableBeacon.renderID = RenderingRegistry.getNextAvailableRenderId();
		 ISimpleBlockRenderingHandler renderDyableBeacons = new RenderDyeableBeacons();
		 RenderingRegistry.registerBlockHandler(BlockDyeableBeacon.renderID , renderDyableBeacons);
	
	}
}
