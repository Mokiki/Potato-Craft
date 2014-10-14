package com.russn.pc.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenCoalLumpNether extends WorldGenerator {
	private Block blk;

	public WorldGenCoalLumpNether(Block b) {
		this.blk=b;
	}

	@Override
	public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5) {
		int yAdjustTries=par2Random.nextInt(4);
		//RandomHelper r=new RandomHelper();

		int x,z;

		int height=3;

		if(par1World.getBlock(par3, par4, par5) == Blocks.netherrack) {
			for(int i=0;i<yAdjustTries;i++) {
				if(par1World.getBlock(par3, ++par4, par5) == Blocks.air) { //form the shape of the coal lump
					for(int tall=0;tall<3;tall++) {
						x=par3;
						z=par5;
						for(int i1=0;i1<10;i1++) {
							par1World.setBlock(par3, par4, par5, this.blk);

							if(tall == 1) {
								if(i1==1) {
									par3++;
								} else if(i1==2) {
									par5++;
								} else if(i1==3) {
									par3--;
								} else if(i1==4) {
									par3--;
								} else if(i1==5) {
									par5--;
								} else if(i1==6) {
									par5--;
								} else if(i1==7) {
									par3++;
								} else if(i1==8) {
									par3++;
								}
							}

							if(tall == height-1) {
								if(i1==1) {
									par3++;
								} else if(i1==2) {
									par3--;
								} else if(i1==3) {
									par5++;
								} else if(i1==4) {
									par5--;
								} else if(i1==5) {
									par3--;
								} else if(i1==6) {
									par3++;
								} else if(i1==7) {
									par5--;
								} else if(i1==8) {
									par5++;
								}
								continue;
							}

							if(tall < height && tall != 1) {
								if(i1==1) {
									par3++;
								} else if(i1==2) {
									par3--;
								} else if(i1==3) {
									par5++;
								} else if(i1==4) {
									par5--;
								} else if(i1==5) {
									par3--;
								} else if(i1==6) {
									par3++;
								} else if(i1==7) {
									par5--;
								} else if(i1==8) {
									par5++;
								}
							}
						}
						par4++;
						par3=x;
						par5=z;
					}
					return true;
				}
			}
			return false;
		} else {
			return false;
		}
	}

}