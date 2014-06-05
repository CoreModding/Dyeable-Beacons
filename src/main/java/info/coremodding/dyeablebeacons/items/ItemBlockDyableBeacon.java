package info.coremodding.dyeablebeacons.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;

public class ItemBlockDyableBeacon extends ItemBlock {

  public ItemBlockDyableBeacon(Block p_i45328_1_) {
    super(p_i45328_1_);

    setHasSubtypes(true);
  }

  @Override
  public int getMetadata(int damageValue) {
    return damageValue;
  }


  @Override
  public String getUnlocalizedName(ItemStack itemstack) {
    return getUnlocalizedName() + "." + ItemDye.field_150923_a[itemstack.getItemDamage()];
  }
}
