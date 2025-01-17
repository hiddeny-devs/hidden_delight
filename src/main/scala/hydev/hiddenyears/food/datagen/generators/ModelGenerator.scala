package hydev.hiddenyears.food.datagen.generators

import hydev.hiddenyears.food.block.HdBlocks
import hydev.hiddenyears.food.item.HdItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.client.{BlockStateModelGenerator, ItemModelGenerator, Models}

final class ModelGenerator(
    output: FabricDataOutput
) extends FabricModelProvider(output) {
  override def generateBlockStateModels(blockStateModelGenerator: BlockStateModelGenerator): Unit = {
    blockStateModelGenerator.registerSimpleCubeAll(HdBlocks.CHOCOLATE_BLOCK)
    blockStateModelGenerator.registerSimpleCubeAll(HdBlocks.CHOCOLATE_BRICKS)
  }
  override def generateItemModels(itemModelGenerator: ItemModelGenerator): Unit = {
    itemModelGenerator.register(HdItems.AMETHYST_CHOCOLATE, Models.GENERATED)
    itemModelGenerator.register(HdItems.AMETHYST_MARSHMALLOW, Models.GENERATED)
    itemModelGenerator.register(HdItems.CHOCOLATE, Models.GENERATED)
    itemModelGenerator.register(HdItems.CHOCOLATE_BAR, Models.GENERATED)
    itemModelGenerator.register(HdItems.CHOCOLATE_PASTE, Models.GENERATED)
    itemModelGenerator.register(HdItems.COPPER_APPLE, Models.GENERATED)
    itemModelGenerator.register(HdItems.ENCHANTED_COPPER_APPLE, Models.GENERATED)
    itemModelGenerator.register(HdItems.COPPER_BREAD, Models.GENERATED)
    itemModelGenerator.register(HdItems.COPPER_CARROT, Models.GENERATED)
    itemModelGenerator.register(HdItems.COPPER_KELP, Models.GENERATED)
    itemModelGenerator.register(HdItems.COPPER_MELON_SLICE, Models.GENERATED)
    itemModelGenerator.register(HdItems.COPPER_POTATO, Models.GENERATED)
    itemModelGenerator.register(HdItems.COPPER_HODGEPODGE, Models.GENERATED)
    itemModelGenerator.register(HdItems.HONEY_CANDY, Models.GENERATED)
    itemModelGenerator.register(HdItems.MILK_CHOCOLATE, Models.GENERATED)
    itemModelGenerator.register(HdItems.SWEET_BERRY_MARSHMALLOW, Models.GENERATED)
    itemModelGenerator.register(HdItems.SWEET_BERRY_CHOCOLATE, Models.GENERATED)
    itemModelGenerator.register(HdItems.SYRUP, Models.GENERATED)
  }
}
