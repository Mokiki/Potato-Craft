package com.russn.pc.worldgen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import com.russn.pc.common.PotatoCraft;

import cpw.mods.fml.common.IWorldGenerator;

public class AdamiteOreGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId) {
		case -1:this.generateNether(world, random, chunkX*16, chunkZ*16);
		case 0:this.generateSurface(world, random, chunkX*16, chunkZ*16);
		}
	}

	private void generateNether(World world, Random random, int i, int j) {

	}

	private void generateSurface(World world, Random random, int blockX, int blockZ) {
		for(int i=0;i<1;i++) {
			int Xcoord=blockX+random.nextInt(16);
			int Ycoord=random.nextInt(10);
			int Zcoord=blockZ+random.nextInt(16);

			new WorldGenMinable(PotatoCraft.AdamiteOre, 1)
			.generate(world, random, Xcoord, Ycoord, Zcoord);
		}
	}
}
