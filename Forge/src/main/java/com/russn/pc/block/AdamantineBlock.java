package com.russn.pc.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.russn.pc.common.PotatoCraft;

public class AdamantineBlock extends Block {
	public AdamantineBlock(Material mat) {
		super(mat);
		this.setCreativeTab(PotatoCraft.TabPotatoBlock);
		this.setResistance(99999999999999999F); //don't even try.
		this.setHardness(50F);
		this.setHarvestLevel("pickaxe", 4);
	}
}