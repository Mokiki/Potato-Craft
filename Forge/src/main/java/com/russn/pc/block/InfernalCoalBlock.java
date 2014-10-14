package com.russn.pc.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.russn.pc.common.PotatoCraft;
import com.russn.pc.common.PotatoCraft;

public class InfernalCoalBlock extends Block {

	public InfernalCoalBlock(Material mat) {
		super(mat);
		this.setCreativeTab(PotatoCraft.TabPotatoBlock);
		this.setHardness(5);
		this.setHarvestLevel("pickaxe", 2);
	}
}
