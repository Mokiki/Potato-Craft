package com.russn.pc.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.russn.pc.container.ContainerInfusion;
import com.russn.pc.gui.GuiInfusion;
import com.russn.pc.tileentity.TileEntityInfusion;

import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tileEntity=world.getTileEntity(x, y, z);

		if(tileEntity instanceof TileEntityInfusion && id == GuiInfusion.ID) {
			return new ContainerInfusion(player.inventory, (TileEntityInfusion)tileEntity);
		}

		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tileEntity=world.getTileEntity(x, y, z);

		if(tileEntity instanceof TileEntityInfusion && id == GuiInfusion.ID) {
			return new GuiInfusion(player.inventory, (TileEntityInfusion)tileEntity);
		}

		return null;
	}
}