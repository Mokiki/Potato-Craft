package com.russn.pc.tab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.russn.pc.common.PotatoCraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabOre extends CreativeTabs {

	public TabOre(String tab){
		super(tab);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem(){
		return Item.getItemFromBlock(PotatoCraft.AdamiteOre);
	}

}