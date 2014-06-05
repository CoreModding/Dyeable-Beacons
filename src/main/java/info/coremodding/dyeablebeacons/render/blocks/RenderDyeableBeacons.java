package info.coremodding.dyeablebeacons.render.blocks;

import org.lwjgl.opengl.GL11;

import info.coremodding.dyeablebeacons.blocks.BlockDyeableBeacon;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderDyeableBeacons implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId,
			RenderBlocks renderer) {
		Tessellator tessellator = Tessellator.instance;
		
		for (int partID = 0; partID < 3; ++partID)
         {
             if (partID == 0)
             {
            	 renderer.setRenderBounds(0.125D, 0.0D, 0.125D, 0.875D, 0.1875D, 0.875D);
            	 renderer.setOverrideBlockTexture(renderer.getBlockIcon(Blocks.obsidian));
             }
             else if (partID == 1)
             {
            	 renderer.setRenderBounds(0.1875D, 0.1875D, 0.1875D, 0.8125D, 0.875D, 0.8125D);
                 renderer.setOverrideBlockTexture(renderer.getBlockIcon(Blocks.beacon));
             }
             else if (partID == 2)
             {
            	 renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
            	 renderer.setOverrideBlockTexture(Blocks.stained_glass.getIcon(0, metadata));
             }

             GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
             tessellator.startDrawingQuads();
             tessellator.setNormal(0.0F, -1.0F, 0.0F);
             renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 0, metadata));
             tessellator.draw();
             tessellator.startDrawingQuads();
             tessellator.setNormal(0.0F, 1.0F, 0.0F);
             renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 1, metadata));
             tessellator.draw();
             tessellator.startDrawingQuads();
             tessellator.setNormal(0.0F, 0.0F, -1.0F);
             renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 2, metadata));
             tessellator.draw();
             tessellator.startDrawingQuads();
             tessellator.setNormal(0.0F, 0.0F, 1.0F);
             renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 3, metadata));
             tessellator.draw();
             tessellator.startDrawingQuads();
             tessellator.setNormal(-1.0F, 0.0F, 0.0F);
             renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 4, metadata));
             tessellator.draw();
             tessellator.startDrawingQuads();
             tessellator.setNormal(1.0F, 0.0F, 0.0F);
             renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 5, metadata));
             tessellator.draw();
             GL11.glTranslatef(0.5F, 0.5F, 0.5F);
         }

		renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
		renderer.clearOverrideBlockTexture();

	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {

        final float lowerHeight = 0.1875F;
        renderer.setOverrideBlockTexture(Blocks.stained_glass.getIcon(0, world.getBlockMetadata(x, y, z)));
        renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
        renderer.renderStandardBlock(block, x, y, z);
        renderer.renderAllFaces = true;
        renderer.setOverrideBlockTexture(renderer.getBlockIcon(Blocks.obsidian));
        renderer.setRenderBounds(0.125D, 0.0062500000931322575D, 0.125D, 0.875D, (double)lowerHeight, 0.875D);
        renderer.renderStandardBlock(block, x, y, z);
        renderer.setOverrideBlockTexture(renderer.getBlockIcon(Blocks.beacon));
        renderer.setRenderBounds(0.1875D, (double)lowerHeight, 0.1875D, 0.8125D, 0.875D, 0.8125D);
        renderer.renderStandardBlock(block, x, y, z);
        renderer.renderAllFaces = false;
        renderer.clearOverrideBlockTexture();
        return true;
        
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getRenderId() {
		// TODO Auto-generated method stub
		return BlockDyeableBeacon.renderID;
	}

}
