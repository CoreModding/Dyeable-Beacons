package info.coremodding.dyeableBeacons;

import info.coremodding.dyeableBeacons.blocks.BlockDyeableBeacon;
import info.coremodding.dyeableBeacons.items.ItemBlockDyableBeacon;
import info.coremodding.dyeableBeacons.proxy.CommonProxy;
import info.coremodding.dyeableBeacons.tileEntity.TileEntityDyableBeacon;
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

@Mod(modid = DyeableBeacons.MOD_ID, name = DyeableBeacons.MOD_NAME , version = "1.1")
public class DyeableBeacons {
	public static final String MOD_ID = "DyeableBeacons";
	public static final String MOD_NAME = "Dyeable Beacons";
	
	private static final String[] dyeableBeaconNames = { 
		"White Beacon", "Orange Beacon", "Magenta Beacon", "Light Blue Beacon",
		"Yellow Beacon", "Light Green Beacon", "Pink Beacon", "Dark Grey Beacon",
		"Light Grey Beacon", "Cyan Beacon", "Purple Beacon", "Blue Beacon",
		"Brown Beacon", "Green Beacon", "Red Beacon", "Black Beacon"
	};
	
    @Instance(MOD_ID)
    public static DyeableBeacons instance;
    
    @SidedProxy(clientSide = "info.coremodding.dyableBeacons.proxy.ClientProxy", serverSide = "info.coremodding.dyableBeacons.proxy.CommonProxy", modId = MOD_ID)
  	public static CommonProxy proxy;
    
    private Block dyableBeacon = new BlockDyeableBeacon().setBlockName("dyableBeacon").setLightLevel(1.0F).setBlockTextureName("beacon");
    
    
    @EventHandler
    public void preInitialization(FMLPreInitializationEvent preEvent) {
    	GameRegistry.registerBlock(dyableBeacon, ItemBlockDyableBeacon.class, "dyeableBeacon");
    	GameRegistry.registerTileEntity(TileEntityDyableBeacon.class, "dyeableBeacon");
    	
    	
    	
		for (int ix = 0; ix < 16; ix++) {
			ItemStack glass = new ItemStack(Block.getBlockFromName("stained_glass"), 1, ix);
			ItemStack dyableBeaconItemStack = new ItemStack(dyableBeacon, 1, ix);
			
			LanguageRegistry.addName(dyableBeaconItemStack, dyeableBeaconNames[dyableBeaconItemStack.getItemDamage()]);
			
			GameRegistry.addShapelessRecipe(dyableBeaconItemStack, glass, Block.getBlockFromName("beacon"));
		}
    }
    
    @EventHandler
    public void initialization(FMLInitializationEvent event) {
    	proxy.registerRender();
    }
}
