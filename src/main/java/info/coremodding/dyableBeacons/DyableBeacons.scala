package info.coremodding.dyableBeacons

import net.minecraft.block.Block
import net.minecraft.item.ItemStack
import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.Mod.Instance
import cpw.mods.fml.common.SidedProxy
import cpw.mods.fml.common.event.FMLInitializationEvent
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import cpw.mods.fml.common.registry.GameRegistry
import cpw.mods.fml.common.registry.LanguageRegistry
import DyableBeacons._
import scala.collection.JavaConversions._
import info.coremodding.dyableBeacons.DyableBeacons
import info.coremodding.dyableBeacons.DyableBeacons
import info.coremodding.dyableBeacons.blocks.BlockDyableBeacon
import info.coremodding.dyableBeacons.tileEntity.TileEntityDyableBeacon
import info.coremodding.dyableBeacons.items.ItemBlockDyableBeacon
import info.coremodding.dyableBeacons.proxy.CommonProxy
import info.coremodding.dyableBeacons.Constants

@Mod(modid = "DyableBeacons", name = "Dyable Beacons", modLanguage = "scala")
object DyableBeacons {

  val MOD_ID = "DyableBeacons"

  val MOD_NAME = "Dyable Beacons"

  private val dyableBeaconNames = Array("White Beacon", "Orange Beacon", "Magenta Beacon", "Light Blue Beacon", "Yellow Beacon", "Light Green Beacon", "Pink Beacon", "Dark Grey Beacon", "Light Grey Beacon", "Cyan Beacon", "Purple Beacon", "Blue Beacon", "Brown Beacon", "Green Beacon", "Red Beacon", "Black Beacon")


  @SidedProxy(clientSide = "info.coremodding.dyableBeacons.proxy.ClientProxy", serverSide = "info.coremodding.dyableBeacons.proxy.CommonProxy", modId = "DyableBeacons")
  var proxy: CommonProxy = _

  private var dyableBeacon: Block = new BlockDyableBeacon().setBlockName("dyableBeacon").setLightLevel(1.0F).setBlockTextureName("beacon")

  @EventHandler
  def preInitialization(preEvent: FMLPreInitializationEvent) {
    GameRegistry.registerBlock(dyableBeacon, classOf[ItemBlockDyableBeacon], "dyableBeacon")
    GameRegistry.registerTileEntity(classOf[TileEntityDyableBeacon], "dyableBeacon")
    for (ix <- 0 until 16) {
      val glass = new ItemStack(Block.getBlockFromName("stained_glass"), 1, ix)
      val dyableBeaconItemStack = new ItemStack(dyableBeacon, 1, ix)
      LanguageRegistry.addName(dyableBeaconItemStack, dyableBeaconNames(dyableBeaconItemStack.getItemDamage))
      GameRegistry.addShapelessRecipe(dyableBeaconItemStack, glass, Block.getBlockFromName("beacon"))
    }
  }

  @EventHandler
  def initialization(event: FMLInitializationEvent) {
    proxy.registerRender()
  }
}
