package com.russn.pc.common;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {
		if(fuel.getItem()==PotatoCraft.InfernalCoal){
			return 3200;
		} else if(fuel.getItem()==Item.getItemFromBlock(PotatoCraft.InfernalCoalBlock)) {
			return 29760;
		} else {
			return 0;
		}
	}
}