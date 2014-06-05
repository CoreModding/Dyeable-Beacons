package info.coremodding.dyeablebeacons.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockBeacon;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
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


	private static final IIcon[] icons = new IIcon[16];

	@Override
	public IIcon getIcon(int side, int meta) {
		return Blocks.stained_glass.getIcon(side, meta);
	}

	@SideOnly(Side.CLIENT)
	public static int func_149997_b(int unknown) {
		return ~unknown & 15;
	}

	@Override
	public int getRenderBlockPass() {
		return 1;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		for (int i = 0; i < icons.length; ++i) {
			// field_149998_a[i] =
			// p_149651_1_.registerIcon(Block.getBlockFromName("stained_glass").getTextureName() + "_" +
			// ItemDye.field_150921_b[func_149997_b(i)]);
		}
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

}
