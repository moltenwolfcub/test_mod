package moltenwolfcub.test.mod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestMod implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("test_mod_mwc");


	public static final ItemGroup CUSTOM_GROUP = FabricItemGroupBuilder.create(
		new Identifier("test_mod_mwc", "custom_page"))
		.icon(() -> new ItemStack(TestMod.SLATE_PIECE))
		.appendItems(stacks -> {
			stacks.add(new ItemStack(TestMod.SLATE_PIECE));
			stacks.add(new ItemStack(TestMod.SLATE_BLOCK));
			stacks.add(new ItemStack(TestMod.SMOOTH_SLATE_BLOCK));
			stacks.add(ItemStack.EMPTY);
			stacks.add(new ItemStack(TestMod.DISCO_BLOCK));
			stacks.add(new ItemStack(TestMod.NON_FRICTION_BLOCK));
			stacks.add(ItemStack.EMPTY);
			stacks.add(new ItemStack(TestMod.CORN));
			stacks.add(new ItemStack(TestMod.POP_CORN));
		})
		.build();


	public static final Item SLATE_PIECE = new Item(new Item.Settings().group(ItemGroup.MISC).maxCount(64).rarity(Rarity.COMMON));
	public static final Item CORN = new Item(new Item.Settings().group(ItemGroup.MISC).maxCount(64).rarity(Rarity.COMMON));

	public static final Item POP_CORN = new Item(new Item.Settings().group(ItemGroup.FOOD).maxCount(64).rarity(Rarity.COMMON).food(FoodItems.POP_CORN));

	public static final Block SLATE_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength(2.25F, 6F).sounds(BlockSoundGroup.TUFF).breakByTool(FabricToolTags.PICKAXES).requiresTool());
	public static final Block SMOOTH_SLATE_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength(2F, 6F).sounds(BlockSoundGroup.TUFF).breakByTool(FabricToolTags.PICKAXES).requiresTool());
	public static final Block DISCO_BLOCK = new Block(FabricBlockSettings.of(Material.DECORATION).strength(1.5F, 1.4F).sounds(BlockSoundGroup.AMETHYST_BLOCK).breakByTool(FabricToolTags.PICKAXES).luminance(15));
	public static final Block NON_FRICTION_BLOCK = new Block(FabricBlockSettings.of(Material.DECORATION).strength(0F, 0F).breakInstantly().slipperiness(3));


	@Override
	public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("test_mod_mwc", "slate_piece"), SLATE_PIECE);
        Registry.register(Registry.ITEM, new Identifier("test_mod_mwc", "corn"), CORN);

		Registry.register(Registry.ITEM, new Identifier("test_mod_mwc", "pop_corn"), POP_CORN);

		Registry.register(Registry.BLOCK, new Identifier("test_mod_mwc", "slate_block"), SLATE_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier("test_mod_mwc", "smooth_slate_block"), SMOOTH_SLATE_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier("test_mod_mwc", "disco_block"), DISCO_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier("test_mod_mwc", "non_friction_block"), NON_FRICTION_BLOCK);

		Registry.register(Registry.ITEM, new Identifier("test_mod_mwc", "slate_block"), new BlockItem(SLATE_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS).maxCount(64).rarity(Rarity.COMMON)));
		Registry.register(Registry.ITEM, new Identifier("test_mod_mwc", "smooth_slate_block"), new BlockItem(SMOOTH_SLATE_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS).maxCount(64).rarity(Rarity.COMMON)));
		Registry.register(Registry.ITEM, new Identifier("test_mod_mwc", "disco_block"), new BlockItem(DISCO_BLOCK, new Item.Settings().group(ItemGroup.DECORATIONS).maxCount(64).rarity(Rarity.COMMON)));
		Registry.register(Registry.ITEM, new Identifier("test_mod_mwc", "non_friction_block"), new BlockItem(NON_FRICTION_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS).maxCount(64).rarity(Rarity.UNCOMMON)));
	}
}
