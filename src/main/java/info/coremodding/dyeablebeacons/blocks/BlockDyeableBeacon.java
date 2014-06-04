package info.coremodding.dyeablebeacons.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBeacon;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import info.coremodding.dyeablebeacons.tileentity.TileEntityDyeableBeacon;

public class BlockDyeableBeacon extends BlockBeacon {
  public BlockDyeableBeacon() {
    setBlockName("dyeableBeacon");
    setLightLevel(1.0F);
    setBlockTextureName("beacon");
  }

  public static int renderID;

  @Override
  public int getRenderType() {
    return renderID;
  }

  @Override
  public TileEntity createNewTileEntity(World world, int meta) {
    return new TileEntityDyeableBeacon();
  }

  @Override
  public int damageDropped(int metadata) {
    return metadata;
  }

  @SideOnly(Side.CLIENT)
  @Override
  public void getSubBlocks(Item item, CreativeTabs tab, List list) {
    for (int i = 0; i < 16; ++i) {
      list.add(new ItemStack(item, 1, i));
    }
  }


  private static final IIcon[] field_149998_a = new IIcon[16];

  @Override
  public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
    return Block.getBlockFromName("stained_glass").getIcon(p_149691_1_, p_149691_2_);
  }


  /**
   * Returns the quantity of items to drop on block destruction.
   */
  public int quantityDropped(Random p_149745_1_) {
    return 0;
  }

  @SideOnly(Side.CLIENT)
  public static int func_149997_b(int p_149997_0_) {
    return ~p_149997_0_ & 15;
  }

  @Override
  public int getRenderBlockPass() {
    return 1;
  }

  @SideOnly(Side.CLIENT)
  public void registerBlockIcons(IIconRegister p_149651_1_) {
    for (int i = 0; i < field_149998_a.length; ++i) {
      // field_149998_a[i] =
      // p_149651_1_.registerIcon(Block.getBlockFromName("stained_glass").getTextureName() + "_" +
      // ItemDye.field_150921_b[func_149997_b(i)]);
    }
  }

  /**
   * Return true if a player with Silk Touch can harvest this block directly, and not its normal
   * drops.
   */
  protected boolean canSilkHarvest() {
    return true;
  }

  /**
   * If this block doesn't render as an ordinary block it will return False (examples: signs,
   * buttons, stairs, etc)
   */
  public boolean renderAsNormalBlock() {
    return false;
  }

}
