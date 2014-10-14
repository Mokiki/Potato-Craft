package com.russn.pc.common;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.UseHoeEvent;

import com.google.common.collect.Sets;

import cpw.mods.fml.common.eventhandler.Event.Result;

public class ItemMultitool extends ItemTool {
	private static final Set field_150917_c = Sets.newHashSet(new Block[] {});
	private static ToolMaterial t;

	protected ItemMultitool(Item.ToolMaterial p_i45327_1_) {
		super(1.0F, p_i45327_1_, ItemMultitool.field_150917_c);
		ItemMultitool.t=p_i45327_1_;
	}

	@Override
	public boolean func_150897_b(Block p_150897_1_) {
		return p_150897_1_ == Blocks.obsidian ?
				this.toolMaterial.getHarvestLevel() == 3 : p_150897_1_ != Blocks.diamond_block && p_150897_1_ != Blocks.diamond_ore ?
						p_150897_1_ != Blocks.emerald_ore && p_150897_1_ != Blocks.emerald_block ?
								p_150897_1_ != Blocks.gold_block && p_150897_1_ != Blocks.gold_ore ?
										p_150897_1_ != Blocks.iron_block && p_150897_1_ != Blocks.iron_ore ?
												p_150897_1_ != Blocks.lapis_block && p_150897_1_ != Blocks.lapis_ore ?
														p_150897_1_ != Blocks.redstone_ore && p_150897_1_ != Blocks.lit_redstone_ore ?
																p_150897_1_.getMaterial() == Material.rock ? true : p_150897_1_.getMaterial() == Material.iron ?
																		true : p_150897_1_.getMaterial() == Material.anvil : this.toolMaterial.getHarvestLevel() >= 2 :
																			this.toolMaterial.getHarvestLevel() >= 1 : this.toolMaterial.getHarvestLevel() >= 1 :
																				this.toolMaterial.getHarvestLevel() >= 2 : this.toolMaterial.getHarvestLevel() >= 2 :
																					this.toolMaterial.getHarvestLevel() >= 2;
	}

	@Override
	public float func_150893_a(ItemStack p_150893_1_, Block p_150893_2_) {
		return this.efficiencyOnProperMaterial;
	}

	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack)) {
			return false;
		}
		else {
			UseHoeEvent event = new UseHoeEvent(par2EntityPlayer, par1ItemStack, par3World, par4, par5, par6);
			if (MinecraftForge.EVENT_BUS.post(event)) {
				return false;
			}

			if (event.getResult() == Result.ALLOW) {
				par1ItemStack.damageItem(1, par2EntityPlayer);
				return true;
			}

			Block block = par3World.getBlock(par4, par5, par6);

			if (par7 != 0 && par3World.getBlock(par4, par5 + 1, par6).isAir(par3World, par4, par5 + 1, par6) && (block == Blocks.grass || block == Blocks.dirt)) {
				Block block1 = Blocks.farmland;
				par3World.playSoundEffect(par4 + 0.5F, par5 + 0.5F, par6 + 0.5F, block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

				if (par3World.isRemote) {
					return true;
				}
				else {
					par3World.setBlock(par4, par5, par6, block1);
					par1ItemStack.damageItem(1, par2EntityPlayer);
					return true;
				}
			}
			else {
				return false;
			}
		}
	}

	@Override
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase) {
		par1ItemStack.damageItem(1, par3EntityLivingBase);
		par2EntityLivingBase.setHealth(par2EntityLivingBase.getHealth()-ItemMultitool.t.getDamageVsEntity());
		return true;
	}
}