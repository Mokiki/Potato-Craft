package com.russn.pc.item;

import net.minecraft.item.ItemAxe;

import com.russn.pc.common.PotatoCraft;

public class AdamantineAxe extends ItemAxe {
	public AdamantineAxe(ToolMaterial tool) {
		super(tool);
		this.setCreativeTab(PotatoCraft.TabTools);
		this.setMaxStackSize(1000);
	}
}
