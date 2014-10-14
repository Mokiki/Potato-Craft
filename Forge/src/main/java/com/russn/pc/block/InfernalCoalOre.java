package com.russn.pc.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;

import com.russn.pc.common.PotatoCraft;

public class InfernalCoalOre extends Block {

	public InfernalCoalOre(Material mat) {
		super(mat);
		this.setCreativeTab(PotatoCraft.TabOres);
		this.setHardness(2);
		this.setHarvestLevel("pickaxe", 2);
	}

	@Override
	public Item getItemDropped(int metadata, Random random, int fortune) {
		return PotatoCraft.InfernalCoal;
	}

	@Override
	public int getExpDrop(IBlockAccess block, int metadata, int fortune) {
		return 3;
	}

}
