package com.russn.pc.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.russn.pc.common.PotatoCraft;

public class PotatoBlock extends Block {

	public PotatoBlock(Material mat) { //the very first block of PotatoCraft
		super(mat);
		this.setCreativeTab(PotatoCraft.TabPotatoBlock);
		this.setHardness(4);
		this.setHarvestLevel("pickaxe", 1);
	}
}
