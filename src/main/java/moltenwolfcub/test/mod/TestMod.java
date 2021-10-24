package moltenwolfcub.test.mod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestMod implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("test_mod_mwc");


	public static final Item SLATE_PIECE = new Item(new Item.Settings().group(ItemGroup.MISC).maxCount(64).rarity(Rarity.COMMON));

	public static final Block SLATE_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength(2.25F, 6F).sounds(BlockSoundGroup.TUFF).breakByTool(FabricToolTags.PICKAXES).requiresTool());
	public static final Block SMOOTH_SLATE_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength(2F, 6F).sounds(BlockSoundGroup.TUFF).breakByTool(FabricToolTags.PICKAXES).requiresTool());

	@Override
	public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("test_mod_mwc", "slate_piece"), SLATE_PIECE);

		Registry.register(Registry.BLOCK, new Identifier("test_mod_mwc", "slate_block"), SLATE_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier("test_mod_mwc", "smooth_slate_block"), SMOOTH_SLATE_BLOCK);

		Registry.register(Registry.ITEM, new Identifier("test_mod_mwc", "slate_block"), new BlockItem(SLATE_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS).maxCount(64).rarity(Rarity.COMMON)));
		Registry.register(Registry.ITEM, new Identifier("test_mod_mwc", "smooth_slate_block"), new BlockItem(SMOOTH_SLATE_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS).maxCount(64).rarity(Rarity.COMMON)));
	}
}
