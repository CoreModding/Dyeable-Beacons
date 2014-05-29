package info.coremodding.dyableBeacons.blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import info.coremodding.dyableBeacons.tileEntity.TileEntityDyableBeacon;
import net.minecraft.block.BlockBeacon;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.world.World;

public class BlockDyableBeacon extends BlockBeacon {

	@Override
	public int getRenderType()
    {
        return 34;
    }
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta)
    {
        return new TileEntityDyableBeacon();
    }
	
	@Override
	public int damageDropped (int metadata) {
		return metadata;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
	     for (int i = 0; i < 16; ++i)
	     {
	            list.add(new ItemStack(item, 1, i));
	     }
	}
	
	
}
