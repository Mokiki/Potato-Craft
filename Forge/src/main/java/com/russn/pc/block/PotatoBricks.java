package com.russn.pc.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.russn.pc.common.PotatoCraft;

public class PotatoBricks extends Block {

	public PotatoBricks(Material mat) {
		super(mat);
		this.setCreativeTab(PotatoCraft.TabPotatoBlock);
		this.setHardness(4);
		this.setHarvestLevel("pickaxe", 1);
	}
}