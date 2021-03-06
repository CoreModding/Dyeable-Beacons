package info.coremodding.dyeableBeacons.render.tileEntity;

import info.coremodding.dyeableBeacons.tileEntity.TileEntityDyableBeacon;
import info.coremodding.dyeableBeacons.DyeableBeacons;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBeacon;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

public class TileEntityDyeableBeaconRenderer extends TileEntitySpecialRenderer{
	private RenderBlocks renderBlocks;
	private static final ResourceLocation beaconTexture = new ResourceLocation("textures/entity/beacon_beam.png");
	private static final ResourceLocation beaconBlockTexture = new ResourceLocation("textures/blocks/beacon.png");


	 private static int colours[][] = {
		 
		 {221,221,221},	//white
		 {219,125,62},	//orange
		 {179,80,188},	//magenta
		 {107,138,201},	//light blue
		 {177,166,38},	//yellow
		 {65,174,56},	//lime
		 {208,132,153},	//pink
		 {64,64,64},	//grey
		 {154,161,161},	//light grey
		 {46,110,137},	//cyan
		 {126,61,181},	//purple
		 {46,56,141},	//blue
		 {79,50,31},	//brown
		 {53,70,27},	//grenn
		 {150,52,48},	//red
		 {25,22,22},	//black
		 };
	 
	public void renderTileEntityAt(TileEntityDyableBeacon tileEntity, double p_147522_2_, double p_147522_4_, double p_147522_6_, float p_147522_8_)
    {
        float f1 = tileEntity.func_146002_i();
        GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
        int blockMeta = tileEntity.getBlockMetadata();
        if (f1 > 0.0F)
        {
            Tessellator tessellator = Tessellator.instance;
            this.bindTexture(beaconTexture);
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, 10497.0F);
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, 10497.0F);
            GL11.glDisable(GL11.GL_LIGHTING);
            GL11.glDisable(GL11.GL_CULL_FACE);
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glDepthMask(true);
            OpenGlHelper.glBlendFunc(770, 1, 1, 0);
            float f2 = (float)tileEntity.getWorldObj().getTotalWorldTime() + p_147522_8_;
            float f3 = -f2 * 0.2F - (float)MathHelper.floor_float(-f2 * 0.1F);
            byte b0 = 1;
            double d3 = (double)f2 * 0.025D * (1.0D - (double)(b0 & 1) * 2.5D);
            tessellator.startDrawingQuads();
            tessellator.setColorRGBA(colours[blockMeta][0], colours[blockMeta][1], colours[blockMeta][2], 32);
            double d5 = (double)b0 * 0.2D;
            double d7 = 0.5D + Math.cos(d3 + 2.356194490192345D) * d5;
            double d9 = 0.5D + Math.sin(d3 + 2.356194490192345D) * d5;
            double d11 = 0.5D + Math.cos(d3 + (Math.PI / 4D)) * d5;
            double d13 = 0.5D + Math.sin(d3 + (Math.PI / 4D)) * d5;
            double d15 = 0.5D + Math.cos(d3 + 3.9269908169872414D) * d5;
            double d17 = 0.5D + Math.sin(d3 + 3.9269908169872414D) * d5;
            double d19 = 0.5D + Math.cos(d3 + 5.497787143782138D) * d5;
            double d21 = 0.5D + Math.sin(d3 + 5.497787143782138D) * d5;
            double d23 = (double)(256.0F * f1);
            double d25 = 0.0D;
            double d27 = 1.0D;
            double d28 = (double)(-1.0F + f3);
            double d29 = (double)(256.0F * f1) * (0.5D / d5) + d28;
            tessellator.addVertexWithUV(p_147522_2_ + d7, p_147522_4_ + d23, p_147522_6_ + d9, d27, d29);
            tessellator.addVertexWithUV(p_147522_2_ + d7, p_147522_4_, p_147522_6_ + d9, d27, d28);
            tessellator.addVertexWithUV(p_147522_2_ + d11, p_147522_4_, p_147522_6_ + d13, d25, d28);
            tessellator.addVertexWithUV(p_147522_2_ + d11, p_147522_4_ + d23, p_147522_6_ + d13, d25, d29);
            tessellator.addVertexWithUV(p_147522_2_ + d19, p_147522_4_ + d23, p_147522_6_ + d21, d27, d29);
            tessellator.addVertexWithUV(p_147522_2_ + d19, p_147522_4_, p_147522_6_ + d21, d27, d28);
            tessellator.addVertexWithUV(p_147522_2_ + d15, p_147522_4_, p_147522_6_ + d17, d25, d28);
            tessellator.addVertexWithUV(p_147522_2_ + d15, p_147522_4_ + d23, p_147522_6_ + d17, d25, d29);
            tessellator.addVertexWithUV(p_147522_2_ + d11, p_147522_4_ + d23, p_147522_6_ + d13, d27, d29);
            tessellator.addVertexWithUV(p_147522_2_ + d11, p_147522_4_, p_147522_6_ + d13, d27, d28);
            tessellator.addVertexWithUV(p_147522_2_ + d19, p_147522_4_, p_147522_6_ + d21, d25, d28);
            tessellator.addVertexWithUV(p_147522_2_ + d19, p_147522_4_ + d23, p_147522_6_ + d21, d25, d29);
            tessellator.addVertexWithUV(p_147522_2_ + d15, p_147522_4_ + d23, p_147522_6_ + d17, d27, d29);
            tessellator.addVertexWithUV(p_147522_2_ + d15, p_147522_4_, p_147522_6_ + d17, d27, d28);
            tessellator.addVertexWithUV(p_147522_2_ + d7, p_147522_4_, p_147522_6_ + d9, d25, d28);
            tessellator.addVertexWithUV(p_147522_2_ + d7, p_147522_4_ + d23, p_147522_6_ + d9, d25, d29);
            tessellator.draw();
            GL11.glEnable(GL11.GL_BLEND);
            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
            GL11.glDepthMask(false);
            tessellator.startDrawingQuads();
            tessellator.setColorRGBA(colours[blockMeta][0], colours[blockMeta][1], colours[blockMeta][2], 32);
            double d30 = 0.2D;
            double d4 = 0.2D;
            double d6 = 0.8D;
            double d8 = 0.2D;
            double d10 = 0.2D;
            double d12 = 0.8D;
            double d14 = 0.8D;
            double d16 = 0.8D;
            double d18 = (double)(256.0F * f1);
            double d20 = 0.0D;
            double d22 = 1.0D;
            double d24 = (double)(-1.0F + f3);
            double d26 = (double)(256.0F * f1) + d24;
            tessellator.addVertexWithUV(p_147522_2_ + d30, p_147522_4_ + d18, p_147522_6_ + d4, d22, d26);
            tessellator.addVertexWithUV(p_147522_2_ + d30, p_147522_4_, p_147522_6_ + d4, d22, d24);
            tessellator.addVertexWithUV(p_147522_2_ + d6, p_147522_4_, p_147522_6_ + d8, d20, d24);
            tessellator.addVertexWithUV(p_147522_2_ + d6, p_147522_4_ + d18, p_147522_6_ + d8, d20, d26);
            tessellator.addVertexWithUV(p_147522_2_ + d14, p_147522_4_ + d18, p_147522_6_ + d16, d22, d26);
            tessellator.addVertexWithUV(p_147522_2_ + d14, p_147522_4_, p_147522_6_ + d16, d22, d24);
            tessellator.addVertexWithUV(p_147522_2_ + d10, p_147522_4_, p_147522_6_ + d12, d20, d24);
            tessellator.addVertexWithUV(p_147522_2_ + d10, p_147522_4_ + d18, p_147522_6_ + d12, d20, d26);
            tessellator.addVertexWithUV(p_147522_2_ + d6, p_147522_4_ + d18, p_147522_6_ + d8, d22, d26);
            tessellator.addVertexWithUV(p_147522_2_ + d6, p_147522_4_, p_147522_6_ + d8, d22, d24);
            tessellator.addVertexWithUV(p_147522_2_ + d14, p_147522_4_, p_147522_6_ + d16, d20, d24);
            tessellator.addVertexWithUV(p_147522_2_ + d14, p_147522_4_ + d18, p_147522_6_ + d16, d20, d26);
            tessellator.addVertexWithUV(p_147522_2_ + d10, p_147522_4_ + d18, p_147522_6_ + d12, d22, d26);
            tessellator.addVertexWithUV(p_147522_2_ + d10, p_147522_4_, p_147522_6_ + d12, d22, d24);
            tessellator.addVertexWithUV(p_147522_2_ + d30, p_147522_4_, p_147522_6_ + d4, d20, d24);
            tessellator.addVertexWithUV(p_147522_2_ + d30, p_147522_4_ + d18, p_147522_6_ + d4, d20, d26);
            tessellator.draw();
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glEnable(GL11.GL_TEXTURE_2D);
            GL11.glDepthMask(true);
        }

		GL11.glAlphaFunc(GL11.GL_GREATER, 0.5F);
	}
	@Override
	public void func_147496_a(World p_147496_1_)
	{
		this.renderBlocks = new RenderBlocks(p_147496_1_);
	}

	@Override
	public void renderTileEntityAt(TileEntity p_147500_1_, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_)
	{
		this.renderTileEntityAt((TileEntityDyableBeacon)p_147500_1_, p_147500_2_, p_147500_4_, p_147500_6_, p_147500_8_);
	}
}
