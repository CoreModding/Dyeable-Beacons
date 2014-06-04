package info.coremodding.dyeablebeacons.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;

import info.coremodding.dyeablebeacons.blocks.BlockDyeableBeacon;
import info.coremodding.dyeablebeacons.render.blocks.RenderDyeableBeacons;
import info.coremodding.dyeablebeacons.render.tileentity.TileEntityDyeableBeaconRenderer;
import info.coremodding.dyeablebeacons.tileentity.TileEntityDyeableBeacon;

public class Client implements Proxy {

  public void registerRender() {
    ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDyeableBeacon.class,
        new TileEntityDyeableBeaconRenderer());

    BlockDyeableBeacon.renderID = RenderingRegistry.getNextAvailableRenderId();
    ISimpleBlockRenderingHandler renderDyableBeacons = new RenderDyeableBeacons();
    RenderingRegistry.registerBlockHandler(BlockDyeableBeacon.renderID, renderDyableBeacons);

  }
}
