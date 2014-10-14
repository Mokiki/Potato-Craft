package com.russn.pc.item;

import net.minecraft.item.ItemSpade;

import com.russn.pc.common.PotatoCraft;

public class AdamantineShovel extends ItemSpade {

	public AdamantineShovel(ToolMaterial tool) {
		super(tool);
		this.setCreativeTab(PotatoCraft.TabTools);
	}
}

