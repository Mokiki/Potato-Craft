package com.russn.pc.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.russn.pc.common.PotatoCraft;
import com.russn.pc.common.PotatoCraft;

public class AdamantinePickaxe extends ItemPickaxe {
	public AdamantinePickaxe(ToolMaterial tool) {
		super(tool);
		this.setHarvestLevel("pickaxe", 4);
		this.setCreativeTab(PotatoCraft.TabTools);
	}
}