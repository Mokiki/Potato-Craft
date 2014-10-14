package com.russn.pc.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.russn.pc.common.PotatoCraft;

public class AdamiteOre extends Block {
	public AdamiteOre(Material mat) {
		super(mat);
		this.setCreativeTab(PotatoCraft.TabOres);
		this.setHardness(20);
		this.setHarvestLevel("pickaxe", 3);
		this.setResistance(50F);
	}
}
