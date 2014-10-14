package com.russn.pc.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityInfusion extends TileEntity implements IInventory {
	private ItemStack[] inv;

	public TileEntityInfusion() {
		this.inv = new ItemStack[20];
	}

	@Override
	public int getSizeInventory() {
		return this.inv.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return this.inv[slot];
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		if (stack != null && stack.stackSize > this.getInventoryStackLimit()) {
			stack.stackSize = this.getInventoryStackLimit();
		}
		
		this.inv[slot] = stack;
	}

	@Override
	public ItemStack decrStackSize(int slot, int amt) {
		ItemStack stack = this.getStackInSlot(slot);
		if (stack != null) {
			if (stack.stackSize <= amt) {
				this.setInventorySlotContents(slot, null);
			} else {
				stack = stack.splitStack(amt);
				if (stack.stackSize == 0) {
					this.setInventorySlotContents(slot, null);
				}
			}
		}
		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		ItemStack stack = this.getStackInSlot(slot);
		if (stack != null) {
			this.setInventorySlotContents(slot, null);
		}
		return stack;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this &&
				player.getDistanceSq(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5) < 64;
	}

//	@Override
//	public void readFromNBT(NBTTagCompound tagCompound) {
//		super.readFromNBT(tagCompound);
//
//		NBTTagList tagList = tagCompound.getTagList("Inventory", 0);
//		for (int i = 0; i < tagList.tagCount(); i++) {
//			NBTTagCompound tag = tagList.getCompoundTagAt(i);
//			byte slot = tag.getByte("Slot");
//			if (slot >= 0 && slot < this.inv.length) {
//				this.inv[slot] = ItemStack.loadItemStackFromNBT(tag);
//			}
//		}
//	}
//
//	@Override
//	public void writeToNBT(NBTTagCompound tagCompound) {
//		super.writeToNBT(tagCompound);
//
//		NBTTagList itemList = new NBTTagList();
//		for (int i = 0; i < this.inv.length; i++) {
//			ItemStack stack = this.inv[i];
//			if (stack != null) {
//				NBTTagCompound tag = new NBTTagCompound();
//				tag.setByte("Slot", (byte) i);
//				stack.writeToNBT(tag);
//				itemList.appendTag(tag);
//			}
//		}
//		tagCompound.setTag("Inventory", itemList);
//	}

	@Override
	public String getInventoryName() {
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public void openInventory() {

	}

	@Override
	public void closeInventory() {

	}

	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		return true;
	}
}