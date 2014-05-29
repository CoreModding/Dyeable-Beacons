package info.coremodding.dyableBeacons;

import info.coremodding.dyableBeacons.blocks.BlockDyableBeacon;
import info.coremodding.dyableBeacons.items.ItemBlockDyableBeacon;
import info.coremodding.dyableBeacons.proxy.CommonProxy;
import info.coremodding.dyableBeacons.tileEntity.TileEntityDyableBeacon;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = DyableBeacons.MOD_ID, name = DyableBeacons.MOD_NAME)
public class DyableBeacons {
	public static final String MOD_ID = "DyableBeacons";
	public static final String MOD_NAME = "Dyable Beacons";
	
    @Instance(MOD_ID)
    public static DyableBeacons instance;
    
    @SidedProxy(clientSide = "info.coremodding.dyableBeacons.proxy.ClientProxy", serverSide = "info.coremodding.dyableBeacons.proxy.CommonProxy", modId = MOD_ID)
  	public static CommonProxy proxy;
    
    private Block dyableBeacon = new BlockDyableBeacon().setBlockName("dyableBeacon").setLightLevel(1.0F).setBlockTextureName("beacon");
    
    
    @EventHandler
    public void preInitialization(FMLPreInitializationEvent preEvent) {
    	GameRegistry.registerBlock(dyableBeacon, ItemBlockDyableBeacon.class, "dyableBeacon");
    	GameRegistry.registerTileEntity(TileEntityDyableBeacon.class, "dyableBeacon");
    	
		for (int ix = 0; ix < 16; ix++) {
			ItemStack cloth = new ItemStack(Block.getBlockFromName("stained_glass"), 1, ix);
			ItemStack multiBlockStack = new ItemStack(dyableBeacon, 1, ix);
			
			GameRegistry.addShapelessRecipe(multiBlockStack, cloth, cloth);
		}
    }
    
    @EventHandler
    public void initialization(FMLInitializationEvent event) {
    	proxy.registerRender();
    }
}
