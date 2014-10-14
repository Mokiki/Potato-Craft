package com.russn.pc.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.russn.pc.common.PotatoCraft;
import com.russn.pc.common.PotatoCraft;

public class NetherLapisOre extends Block {

	public NetherLapisOre(Material mat) {
		super(mat);
		this.setCreativeTab(PotatoCraft.TabOres);
		this.setHardness(2);
		this.setHarvestLevel("pickaxe", 3);
	}
}