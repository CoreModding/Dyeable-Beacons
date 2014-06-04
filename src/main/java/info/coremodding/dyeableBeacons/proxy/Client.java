package info.coremodding.dyeableBeacons.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;

import info.coremodding.dyeableBeacons.blocks.BlockDyeableBeacon;
import info.coremodding.dyeableBeacons.render.blocks.RenderDyeableBeacons;
import info.coremodding.dyeableBeacons.render.tileEntity.TileEntityDyeableBeaconRenderer;
import info.coremodding.dyeableBeacons.tileEntity.TileEntityDyableBeacon;

public class Client implements Proxy {

  public void registerRender() {
    ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDyableBeacon.class,
        new TileEntityDyeableBeaconRenderer());

    BlockDyeableBeacon.renderID = RenderingRegistry.getNextAvailableRenderId();
    ISimpleBlockRenderingHandler renderDyableBeacons = new RenderDyeableBeacons();
    RenderingRegistry.registerBlockHandler(BlockDyeableBeacon.renderID, renderDyableBeacons);

  }
}
