package com.russn.pc.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.russn.pc.common.PacketInfusion;
import com.russn.pc.common.PotatoCraft;
import com.russn.pc.container.ContainerInfusion;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiInfusion extends GuiContainer {
	public static final int ID=20;

	private static final ResourceLocation infusionTable=
			new ResourceLocation("PotatoCraft:/textures/gui/infusion_table.png");

	public GuiInfusion(InventoryPlayer p, IInventory i) {
		super(new ContainerInfusion(p, i));

		this.xSize=174;
		this.ySize=199;
	}

	@Override
	public void initGui() {
		super.initGui();
		this.buttonList.add(new GuiButton(1, this.guiLeft+125, this.guiTop+93, 40, 20, "Infuse"));
	}

	@Override
	protected void actionPerformed(GuiButton guibutton) {
		switch(guibutton.id) {
		case 1:
			//PotatoCraft.instance.sendToServer(new PacketInfusion(10, new ItemStack(PotatoCraft.AdamiteIngot)));
			break;
		}
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int x1, int x2) {
		this.drawDefaultBackground();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		this.mc.renderEngine.bindTexture(GuiInfusion.infusionTable);

		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}
}