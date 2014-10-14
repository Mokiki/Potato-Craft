package com.russn.pc.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.russn.pc.common.PotatoCraft;

public class ContainerInfusion extends Container {
	public IInventory inventory;
	
	public ContainerInfusion(InventoryPlayer inventoryPlayer, IInventory inventory) {
		int id=0;

		for (int i = 0; i < 4; i++) {
			this.addSlotToContainer(new Slot(inventory, id, 29 + i * 18, 15));
			id++;
		}

		for (int j = 0; j < 4; j++) {
			this.addSlotToContainer(new Slot(inventory, id, 101, 15+j * 18));
			id++;
		}

		for (int k = 4; k > 0; k--) {
			this.addSlotToContainer(new Slot(inventory, id, 29+k * 18, 87));
			id++;
		}

		for (int l = 4; l > 0; l--) {
			this.addSlotToContainer(new Slot(inventory, id, 29, 15+l * 18));
			id++;
		}

		this.addSlotToContainer(new Slot(inventory, id, 65, 51));
		id++;

		for (int m = 0; m < 3; m++) {
			this.addSlotToContainer(new Slot(inventory, id, 136, 33+m * 18));
			id++;
		}
		
		this.inventory=inventory;

		this.bindPlayerInventory(inventoryPlayer);
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}
	
	public void setResults() {
		this.setStack(this.inventory, 0, new ItemStack(PotatoCraft.AdamiteIngot, 2));
	}

	protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 7 + j * 18, 117 + i * 18));
			}
		}

		for (int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(inventoryPlayer, i, 7 + i * 18, 175));
		}
	}

	public void setStack(IInventory inventory, int slot, ItemStack item) {
		inventory.setInventorySlotContents(slot, item);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
		ItemStack stack=null;
		Slot slotObject = (Slot) this.inventorySlots.get(slot);

		if (slotObject != null && slotObject.getHasStack()) {
			ItemStack stackInSlot = slotObject.getStack();
			stack = stackInSlot.copy();

			//merges the item into player inventory since its in the tileEntity
			if (slot < 9) {
				if (!this.mergeItemStack(stackInSlot, 0, 35, true)) {
					return null;
				}
			}

			//places it into the tileEntity is possible since its in the player inventory
			else if (!this.mergeItemStack(stackInSlot, 0, 9, false)) {
				return null;
			}

			if (stackInSlot.stackSize == 0) {
				slotObject.putStack(null);
			} else {
				slotObject.onSlotChanged();
			}

			if (stackInSlot.stackSize == stack.stackSize) {
				return null;
			}
			slotObject.onPickupFromSlot(player, stackInSlot);
		}
		return stack;
	}
}