package info.coremodding.dyableBeacons.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemBlockDyableBeacon extends ItemBlock {

	public ItemBlockDyableBeacon(Block p_i45328_1_) {
		super(p_i45328_1_);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getMetadata(int damageValue) {
		return damageValue;
	}

}
