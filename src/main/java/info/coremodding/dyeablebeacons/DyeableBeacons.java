package info.coremodding.dyeablebeacons;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

import info.coremodding.dyeablebeacons.blocks.BlockDyeableBeacon;
import info.coremodding.dyeablebeacons.items.ItemBlockDyableBeacon;
import info.coremodding.dyeablebeacons.library.Reference;
import info.coremodding.dyeablebeacons.proxy.Proxy;
import info.coremodding.dyeablebeacons.tileentity.TileEntityDyableBeacon;

@Mod(modid = Reference.Mod.ID, name = Reference.Mod.NAME, version = Reference.Mod.VERSION)
public class DyeableBeacons {

  @Instance(Reference.Mod.ID)
  public static DyeableBeacons instance;

  @SidedProxy(clientSide = Reference.Proxy.CLIENT, serverSide = Reference.Proxy.SERVER,
      modId = Reference.Mod.ID)
  public static Proxy proxy;

  private Block dyeableBeacon = new BlockDyeableBeacon();


  @EventHandler
  public void preInitialization(FMLPreInitializationEvent preEvent) {
    GameRegistry.registerBlock(dyeableBeacon, ItemBlockDyableBeacon.class, dyeableBeacon.getUnlocalizedName());
    GameRegistry.registerTileEntity(TileEntityDyableBeacon.class, dyeableBeacon.getUnlocalizedName());
    
    for (int color = 0; color < ItemDye.field_150923_a.length; color++) {
      ItemStack glass = new ItemStack(Blocks.stained_glass, 1, color);
      ItemStack dyableBeaconItemStack = new ItemStack(dyeableBeacon, 1, color);

      GameRegistry.addShapelessRecipe(dyableBeaconItemStack, glass, Blocks.beacon);
    }
  }

  @EventHandler
  public void initialization(FMLInitializationEvent event) {
    proxy.registerRender();
  }
}
