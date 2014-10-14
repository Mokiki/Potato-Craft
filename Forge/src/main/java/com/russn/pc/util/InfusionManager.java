package com.russn.pc.util;

import com.russn.pc.common.PotatoCraft;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import scala.actors.threadpool.Arrays;

public class InfusionManager {
	public static Item[][] registeredRecipes={ //array of recipes
		{
			Items.iron_ingot, null, new ItemStack(Blocks.stone).getItem(), null,
			Items.iron_ingot, null, new ItemStack(Blocks.stone).getItem(), null,
			Items.iron_ingot, null, new ItemStack(Blocks.stone).getItem(), null,
			Items.iron_ingot, null, new ItemStack(Blocks.stone).getItem(), null,

			Items.potato
		}
	};

	public static ItemStack[][] recipeResults={ //array of recipe results
		{
			null, new ItemStack(PotatoCraft.HardenedPotato), null
		}
	};

	public static ItemStack[] verifyRecipe(IInventory inventory) {
		Item[] inven=new Item[17];

		for(int i=0;i<17;i++) { //gets the contents of the infusion table
			ItemStack invenItem=inventory.getStackInSlot(i);

			if(invenItem == null) { //null check -- if invenItem is null and we do .getItem(), java.lang.NullPointerException
				inven[i]=null;
				continue;
			}

			inven[i]=invenItem.getItem();
		}

		for(int j=0;j<InfusionManager.registeredRecipes.length;j++) {
			if(Arrays.equals(InfusionManager.registeredRecipes[j], inven)) { //test the inventory contents against each recipe
				return InfusionManager.recipeResults[j]; //if match is found, return the recipe result
			}
		}

		return null;
	}
}