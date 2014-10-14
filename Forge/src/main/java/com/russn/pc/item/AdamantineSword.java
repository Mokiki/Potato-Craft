package com.russn.pc.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

import com.russn.pc.common.PotatoCraft;

import cpw.mods.fml.common.Mod.EventHandler;

public class AdamantineSword extends ItemSword {
	public static boolean cooldownInactive=true;

	public AdamantineSword(ToolMaterial tool) {
		super(tool);
		this.setCreativeTab(PotatoCraft.TabTools);
	}

	@Override
	@EventHandler
	public boolean hitEntity(ItemStack i, EntityLivingBase e, EntityLivingBase e2) {
		e.setHealth(e.getHealth()-41);
		return true;
	}
}

