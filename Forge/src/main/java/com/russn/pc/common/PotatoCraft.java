package com.russn.pc.common;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;

import com.russn.pc.item.AdamiteIngot;
import com.russn.pc.util.InfusionManager;
import com.russn.pc.worldgen.AdamiteOreGen;
import com.russn.pc.worldgen.CoalLumpGen;
import com.russn.pc.worldgen.InfernalCoalGen;
import com.russn.pc.worldgen.NetherDiamondOreGen;
import com.russn.pc.worldgen.NetherEmeraldOreGen;
import com.russn.pc.worldgen.NetherGoldOreGen;
import com.russn.pc.worldgen.NetherIronOreGen;
import com.russn.pc.worldgen.NetherLapisOreGen;
import com.russn.pc.worldgen.NetherRedstoneOreGen;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

/*
 * @author RussnKyle
 * This class provides a static list of all mod items as well as several methods 
 * for registration and initialization. It serves as a public reference to all 
 * features of the mod as well as handling the creation of mod elements. 
 */
@Mod(modid="PotatoCraft", name="Potato Craft", version="Alpha 1.6")
public class PotatoCraft {
	@Instance
	public static PotatoCraft instance=new PotatoCraft();
	public static InfusionManager infusion=new InfusionManager();

	//creative tabs
	public static CreativeTabs TabPotato;
	public static CreativeTabs TabPotatoBlock;
	public static CreativeTabs TabMat;
	public static CreativeTabs TabOres;
	public static CreativeTabs TabWeapons;
	public static CreativeTabs TabTools;
	
	//worldgen
	public static AdamiteOreGen GenAdamiteOre;
	public static InfernalCoalGen GenInfernalCoal;
	public static CoalLumpGen GenCoalLump;

	public static NetherDiamondOreGen GenNetherDiamondOre;
	public static NetherEmeraldOreGen GenNetherEmeraldOre;
	public static NetherIronOreGen GenNetherIronOre;
	public static NetherGoldOreGen GenNetherGoldOre;
	public static NetherLapisOreGen GenNetherLapisOre;
	public static NetherRedstoneOreGen GenNetherRedstoneOre;

	//tool materials
	public static ToolMaterial ToolAdamantine;
	public static ToolMaterial ToolPotato;

	//tools
	public static Item AdamantineSword;
	public static Item AdamantinePickaxe;
	public static Item AdamantineAxe;
	public static Item AdamantineShovel;
	public static Item AdamantineHoe;

	public static Item PotatoPickaxe;

	//multitools
	public static Item WoodenArmyKnife;
	public static Item StoneArmyKnife;
	public static Item PotatoArmyKnife;
	public static Item IronArmyKnife;
	public static Item GoldArmyKnife;
	public static Item DiamondArmyKnife;
	public static Item AdamantineArmyKnife;


	//items
	public static Item HardenedPotato;

	public static Item AdamiteShard;
	public static Item AdamiteChunk;
	public static Item UnstableAdamiteChunk;
	
	public static Item InfernalCoal;
	
	public static Item AdamiteIngot;
	
	//blocks
	public static Block PotatoBlock;
	public static Block PotatoBricks;
	
	public static Block AdamantineBlock;
	public static Block InfernalCoalBlock;
	
	public static Block InfusionTable;
	
	public static Block AdamiteOre;
	public static Block InfernalCoalOre;
	
	public static Block NetherDiamondOre;
	public static Block NetherGoldOre;
	public static Block NetherEmeraldOre;
	public static Block NetherIronOre;
	public static Block NetherLapisOre;
	public static Block NetherRedstoneOre;
	
	/*
	 * Initialize items as well as ToolMaterials & CreativeTabs (this is necessary as item initialization
	 * uses both). Provides console output of when item initialization begins and ends.
	 * 
	 * It is necessary for this method to be executed BEFORE initBlocks(), as blocks use CreativeTab as well.
	 */
    public static void initItems() {
    	System.out.println("Item initializaton started...");
//    	ToolPotato=EnumHelper.addToolMaterial("Potato", 2, 250, 5, 5, 10);
//    	ToolAdamantine=EnumHelper.addToolMaterial("Adamantine", 4, 20000, 40, 17, 30);
//    	
//    	TabPotato = new TabPotato("potatos");
//        TabPotatoBlock=new TabPotatoBlock("potatoBlocks");
//    	TabMat=new TabMaterial("potatoMat");
//        TabOres=new TabOre("potatoOres");
//        TabWeapons=new TabWeapon("potatoWeapons");
//    	TabTools=new TabTool("potatoTools");
//    	
//    	AdamantineSword=new AdamantineSword(PotatoCraft.ToolAdamantine).setUnlocalizedName("adamantine_sword").setTextureName("PotatoCraft:adamantine_sword");
//    	AdamantinePickaxe=new AdamantinePickaxe(PotatoCraft.ToolAdamantine).setUnlocalizedName("adamantine_pickaxe").setTextureName("PotatoCraft:adamantine_pickaxe");
//    	AdamantineAxe=new AdamantineAxe(PotatoCraft.ToolAdamantine).setUnlocalizedName("adamantine_axe").setTextureName("PotatoCraft:adamantine_axe");
//    	AdamantineShovel=new AdamantineShovel(PotatoCraft.ToolAdamantine).setUnlocalizedName("adamantine_shovel").setTextureName("PotatoCraft:adamantine_shovel");
//        AdamantineHoe=new AdamantineHoe(PotatoCraft.ToolAdamantine).setUnlocalizedName("adamantine_hoe").setTextureName("PotatoCraft:adamantine_hoe");
//        
//        PotatoPickaxe=new PotatoPickaxe(PotatoCraft.ToolPotato).setUnlocalizedName("potato_pickaxe").setTextureName("PotatoCraft:potato_pickaxe");
//        
//        WoodenArmyKnife=new WoodenArmyKnife(ToolMaterial.WOOD).setUnlocalizedName("wooden_army_knife").setTextureName("PotatoCraft:wooden_spork");
//    	StoneArmyKnife=new WoodenArmyKnife(ToolMaterial.STONE).setUnlocalizedName("stone_army_knife").setTextureName("PotatoCraft:stone_spork");
//    	PotatoArmyKnife=new WoodenArmyKnife(PotatoCraft.ToolPotato).setUnlocalizedName("potato_army_knife").setTextureName("PotatoCraft:wooden_spork");
//    	IronArmyKnife=new WoodenArmyKnife(ToolMaterial.IRON).setUnlocalizedName("iron_army_knife").setTextureName("PotatoCraft:iron_spork");
//        GoldArmyKnife=new WoodenArmyKnife(ToolMaterial.GOLD).setUnlocalizedName("golden_army_knife").setTextureName("PotatoCraft:gold_spork");
//    	DiamondArmyKnife=new WoodenArmyKnife(ToolMaterial.EMERALD).setUnlocalizedName("diamond_army_knife").setTextureName("PotatoCraft:diamond_spork");
//        AdamantineArmyKnife=new WoodenArmyKnife(PotatoCraft.ToolAdamantine).setUnlocalizedName("adamantine_army_knife").setTextureName("PotatoCraft:wooden_spork");
//    	
//    	HardenedPotato=new HardenedPotato().setUnlocalizedName("hardened_potato").setTextureName("PotatoCraft:hardened_potato");
//    			
//    	AdamiteShard=new AdamiteShard().setUnlocalizedName("adamite_shard").setTextureName("PotatoCraft:adamite_shard");
//    	AdamiteChunk=new AdamiteChunk().setUnlocalizedName("adamite_chunk").setTextureName("PotatoCraft:adamite_chunk");
//    	UnstableAdamiteChunk=new UnstableAdamiteChunk().setUnlocalizedName("unstable_adamite_chunk").setTextureName("PotatoCraft:unstable_adamite_chunk");
    	AdamiteIngot=new AdamiteIngot().setUnlocalizedName("adamite_ingot").setTextureName("PotatoCraft:adamite_ingot");
//    	
//    	InfernalCoal=new InfernalCoal().setUnlocalizedName("infernal_coal").setTextureName("PotatoCraft:infernal_coal");
    	System.out.println("Item initializaton finished");
    }
    
    /*
     * Initialize all blocks. Provides console output of when block initialization begins and ends.
     * 
     * This method must NOT be called before initItems(), as that method initializes CreativeTabs.
    */
    public static void initBlocks() {
    	System.out.println("Block initializaton started...");
//    	PotatoBlock=new PotatoBlock(Material.rock).setBlockName("potato_block").setBlockTextureName("PotatoCraft:potato_block");
//    	PotatoBricks=new PotatoBricks(Material.rock).setBlockName("potato_bricks").setBlockTextureName("PotatoCraft:potato_bricks");
//    	
//    	AdamantineBlock=new AdamantineBlock(Material.rock).setBlockName("adamantine_block").setBlockTextureName("PotatoCraft:adamantine_potato_block");
//    	InfernalCoalBlock=new InfernalCoalBlock(Material.rock).setBlockName("infernal_coal_block").setBlockTextureName("PotatoCraft:infernal_coal_block");
//    	
//    	InfusionTable=new InfusionTable(Material.iron).setBlockName("infusion_table").setBlockTextureName("PotatoCraft:infusion_table");
//    	
//    	AdamiteOre=new AdamiteOre(Material.rock).setBlockName("adamite_ore").setBlockTextureName("PotatoCraft:adamite_ore");
//    	InfernalCoalOre=new InfernalCoalOre(Material.rock).setBlockName("infernal_coal_ore").setBlockTextureName("PotatoCraft:infernal_coal_ore");
//    	
//    	NetherDiamondOre=new NetherDiamondOre(Material.rock).setBlockName("nether_diamond_ore").setBlockTextureName("PotatoCraft:nether_diamond_ore");
//    	NetherGoldOre=new NetherGoldOre(Material.rock).setBlockName("nether_gold_ore").setBlockTextureName("PotatoCraft:nether_gold_ore");
//    	NetherEmeraldOre=new NetherEmeraldOre(Material.rock).setBlockName("nether_emerald_ore").setBlockTextureName("PotatoCraft:nether_emerald_ore");
//    	NetherIronOre=new NetherIronOre(Material.rock).setBlockName("nether_iron_ore").setBlockTextureName("PotatoCraft:nether_iron_ore");
//    	NetherLapisOre=new NetherLapisOre(Material.rock).setBlockName("nether_lapis_ore").setBlockTextureName("PotatoCraft:nether_lapis_ore");
//    	NetherRedstoneOre=new NetherRedstoneOre(Material.rock).setBlockName("nether_redstone_ore").setBlockTextureName("PotatoCraft:nether_redstone_ore");
    	System.out.println("Block initializaton ended.");
    }
    
    /*
     * Initialize mod worldgen features. Provides console output of when worldgen initialization begins and ends.
     */
    public static void initWorldgen() {
    	System.out.println("Worldgen initializaton started...");
//    	GenNetherDiamondOre=new NetherDiamondOreGen();
//    	GenNetherEmeraldOre=new NetherEmeraldOreGen();
//    	GenNetherIronOre=new NetherIronOreGen();
//    	GenNetherGoldOre=new NetherGoldOreGen();
//    	GenNetherLapisOre=new NetherLapisOreGen();
//    	GenNetherRedstoneOre=new NetherRedstoneOreGen();
//    	
//    	GenAdamiteOre=new AdamiteOreGen();
//    	GenInfernalCoal=new InfernalCoalGen();
//    	GenCoalLump=new CoalLumpGen();
       	System.out.println("Worldgen initializaton ended.");
    }
    
	/*
	 * Register all items. Calls GameRegistry.registerItem().
	 */
    public static void registerItems() {
    	System.out.println("Item registration started...");
//		GameRegistry.registerItem(PotatoCraft.AdamantineSword, "adamantine_sword");
//		GameRegistry.registerItem(PotatoCraft.AdamantinePickaxe, "adamantine_pickaxe");
//		GameRegistry.registerItem(PotatoCraft.AdamantineAxe, "adamantine_axe");
//		GameRegistry.registerItem(PotatoCraft.AdamantineShovel, "adamantine_shovel");
//		GameRegistry.registerItem(PotatoCraft.AdamantineHoe, "adamantine_hoe");
//		
//		GameRegistry.registerItem(PotatoCraft.PotatoPickaxe, "potato_pickaxe");
//		
//		GameRegistry.registerItem(PotatoCraft.WoodenArmyKnife, "wooden_army_knife");
//		GameRegistry.registerItem(PotatoCraft.StoneArmyKnife, "stone_army_knife");
//		GameRegistry.registerItem(PotatoCraft.PotatoArmyKnife, "potato_army_knife");
//		GameRegistry.registerItem(PotatoCraft.IronArmyKnife, "iron_army_knife");
//		GameRegistry.registerItem(PotatoCraft.GoldArmyKnife, "gold_army_knife");
//		GameRegistry.registerItem(PotatoCraft.DiamondArmyKnife, "diamond_army_knife");
//		GameRegistry.registerItem(PotatoCraft.AdamantineArmyKnife, "adamantine_army_knife");
//		
//		GameRegistry.registerItem(PotatoCraft.HardenedPotato, "hardened_potato");
//		
//		GameRegistry.registerItem(PotatoCraft.AdamiteShard, "adamite_shard");
//		GameRegistry.registerItem(PotatoCraft.AdamiteChunk, "adamite_chunk");
//		GameRegistry.registerItem(PotatoCraft.UnstableAdamiteChunk, "unstable_adamite_chunk");
		GameRegistry.registerItem(PotatoCraft.AdamiteIngot, "adamite_ingot");
//		
//		GameRegistry.registerItem(PotatoCraft.InfernalCoal, "infernal_coal");
    	System.out.println("Item registration ended.");
    }
    
    /*
     * Register all blocks. Calls GameRegistry.registerBlock().
     * 
     * Must be called after initBlocks(), as block fields are required parameters.
     */
    public static void registerBlocks() {
    	System.out.println("Block initializaton started...");
//    	GameRegistry.registerBlock(PotatoCraft.InfernalCoalBlock, "infernal_coal_block");
//    	GameRegistry.registerBlock(PotatoCraft.AdamantineBlock, "adamantine_block");
//    	
//    	GameRegistry.registerBlock(PotatoCraft.InfusionTable, "infusion_table");
//    	
//		GameRegistry.registerBlock(PotatoCraft.AdamiteOre, "adamite_ore");
//		GameRegistry.registerBlock(PotatoCraft.InfernalCoalOre, "infernal_coal_ore");
//
//		GameRegistry.registerBlock(PotatoCraft.NetherDiamondOre, "nether_diamond_ore");
//		GameRegistry.registerBlock(PotatoCraft.NetherGoldOre, "nether_gold_ore");
//		GameRegistry.registerBlock(PotatoCraft.NetherEmeraldOre, "nether_emerald_ore");
//		GameRegistry.registerBlock(PotatoCraft.NetherIronOre, "nether_iron_ore");
//		GameRegistry.registerBlock(PotatoCraft.NetherLapisOre, "nether_lapis_ore");
//		GameRegistry.registerBlock(PotatoCraft.NetherRedstoneOre, "nether_redstone_ore");
    	System.out.println("Block initializaton ended.");
    }
    
    /*
     * Register all world generation related things. Calls GameRegistry.registerWorldGeneration().
     */
    public static void registerWorldgen() {
    	System.out.println("Worldgen registration started...");
//		GameRegistry.registerWorldGenerator(PotatoCraft.GenAdamiteOre, 1);
//		GameRegistry.registerWorldGenerator(PotatoCraft.GenInfernalCoal, 1);
//		GameRegistry.registerWorldGenerator(PotatoCraft.GenCoalLump, 1);
//
//		GameRegistry.registerWorldGenerator(PotatoCraft.GenNetherDiamondOre, 1);
//		GameRegistry.registerWorldGenerator(PotatoCraft.GenNetherEmeraldOre, 1);
//		GameRegistry.registerWorldGenerator(PotatoCraft.GenNetherIronOre, 1);
//		GameRegistry.registerWorldGenerator(PotatoCraft.GenNetherGoldOre, 1);
//		GameRegistry.registerWorldGenerator(PotatoCraft.GenNetherLapisOre, 1);
//		GameRegistry.registerWorldGenerator(PotatoCraft.GenNetherRedstoneOre, 1);
       	System.out.println("Worldgen registration ended.");
    }
    
    /*
     * Register tile entities. Calls GameRegistry.registerTileEntity().
     */
    public static void registerTileEntities() {
    	//GameRegistry.registerTileEntity(TileEntityInfusion.class, "TileEntityInfusion");
    }
    /*
     * Register required handlers. Calls GameRegistry.register[HandlerType]().
     */
    public static void registerHandlers() {
    	System.out.println("Handler registration started...");
    	NetworkRegistry.INSTANCE.registerGuiHandler(PotatoCraft.class, new GuiHandler());
    	GameRegistry.registerFuelHandler(new FuelHandler());
    	System.out.println("Handler registration ended.");
    }
    
    /*
     * Register crafting recipes. Calls GameRegistry.registerCrafting() and GameRegistry.registerSmelting().
     * 
     * This method must be called AFTER initItems() and initBlocks(), since it uses mod elements.
     */
    public static void registerCrafting() {
    	System.out.println("Crafting registration started...");
//		GameRegistry.addShapelessRecipe(new ItemStack(Item.getItemById(392), 9), PotatoCraft.PotatoBlock);
//		GameRegistry.addShapelessRecipe(new ItemStack(PotatoCraft.AdamiteIngot, 9), PotatoCraft.AdamantineBlock);
//		GameRegistry.addShapelessRecipe(new ItemStack(PotatoCraft.InfernalCoal, 9), PotatoCraft.InfernalCoalBlock);
//		
//		GameRegistry.addRecipe(new ItemStack(Items.chainmail_helmet, 1), new Object[] {"BBB", "B B", 'B', Blocks.iron_bars});
//		GameRegistry.addRecipe(new ItemStack(Items.chainmail_chestplate, 1), new Object[] {"B B", "BBB", "BBB", 'B', Blocks.iron_bars});
//		GameRegistry.addRecipe(new ItemStack(Items.chainmail_leggings, 1), new Object[] {"BBB", "B B", "B B", 'B', Blocks.iron_bars});
//		GameRegistry.addRecipe(new ItemStack(Items.chainmail_boots, 1), new Object[] {"B B", "B B", 'B', Blocks.iron_bars});
//		
//		GameRegistry.addRecipe(new ItemStack(PotatoCraft.PotatoBlock, 1), new Object[] {"XXX", "XXX", "XXX", 'X', Items.potato});
//		GameRegistry.addRecipe(new ItemStack(PotatoCraft.PotatoBricks, 4), new Object[] {"XX ", "XX ", 'X', PotatoCraft.PotatoBlock});
//
//		GameRegistry.addRecipe(new ItemStack(PotatoCraft.AdamantineBlock, 1), new Object[] {"XXX", "XXX", "XXX", 'X', PotatoCraft.AdamiteIngot});
//		GameRegistry.addRecipe(new ItemStack(PotatoCraft.InfernalCoalBlock, 1), new Object[] {"XXX", "XXX", "XXX", 'X', PotatoCraft.InfernalCoal});
    	System.out.println("Crafting registration ended.");
    }
    
    /*
     * Register smelting recipes. Calls GameRegistry.registerSmelting().
     * 
     * This method must be called AFTER initItems() and initBlocks() as it uses mod elements.
     */
    public static void registerSmelting() {
    	System.out.println("Smelting registration started...");
//		GameRegistry.addSmelting(PotatoCraft.AdamiteOre, new ItemStack(PotatoCraft.AdamiteShard), 10.0F);
//
//		GameRegistry.addSmelting(PotatoCraft.NetherDiamondOre, new ItemStack(Items.diamond, 2), 10.0F);
//		GameRegistry.addSmelting(PotatoCraft.NetherEmeraldOre, new ItemStack(Items.emerald, 2), 10.0F);
//		GameRegistry.addSmelting(PotatoCraft.NetherIronOre, new ItemStack(Items.iron_ingot, 2), 10.0F);
//		GameRegistry.addSmelting(PotatoCraft.NetherGoldOre, new ItemStack(Items.gold_ingot, 2), 10.0F);
//		GameRegistry.addSmelting(PotatoCraft.NetherLapisOre, new ItemStack(Items.dye, 8, 4), 10.0F);
//		GameRegistry.addSmelting(PotatoCraft.NetherRedstoneOre, new ItemStack(Items.redstone, 8), 10.0F);
//		GameRegistry.addSmelting(PotatoCraft.UnstableAdamiteChunk, new ItemStack(PotatoCraft.AdamiteIngot, 1), 20F);
		System.out.println("Smelting registration ended.");

    }
    
	@EventHandler
	public void init(FMLInitializationEvent event) {
		PotatoCraft.initItems();
		PotatoCraft.registerItems();
		
		PotatoCraft.initBlocks();
		PotatoCraft.registerBlocks();
		
		
		PotatoCraft.registerCrafting();
		PotatoCraft.registerSmelting();
		
		PotatoCraft.registerWorldgen();
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event) {
		//PotatoCraft.registerHandlers();
	}
}