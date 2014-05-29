package info.coremodding.dyableBeacons.tileEntity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityDyableBeacon extends TileEntityBeacon {

	@Override
	public double getMaxRenderDistanceSquared() {
		return 65536;
		
	}
	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		return TileEntity.INFINITE_EXTENT_AABB;
	}
}
