package com.russn.pc.worldgen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import com.russn.pc.common.PotatoCraft;

import cpw.mods.fml.common.IWorldGenerator;

public class NetherGoldOreGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId) {
		case -1:this.generateNether(world, random, chunkX*16, chunkZ*16);
		}
	}

	private void generateNether(World world, Random random, int blockX, int blockZ) {
		for(int i=0;i<10;i++) {
			int Xcoord=blockX+random.nextInt(16);
			int Ycoord=random.nextInt(60);
			int Zcoord=blockZ+random.nextInt(16);

			new WorldGenMinableNether(PotatoCraft.NetherGoldOre, 7)
			.generate(world, random, Xcoord, Ycoord, Zcoord);
		}
	}
}