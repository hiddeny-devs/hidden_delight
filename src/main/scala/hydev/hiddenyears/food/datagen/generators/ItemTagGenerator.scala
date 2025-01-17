package hydev.hiddenyears.food.datagen.generators

import hydev.hiddenyears.food.HdTags
import hydev.hiddenyears.food.item.HdItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider.{
  BlockTagProvider,
  ItemTagProvider
}
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags
import net.minecraft.registry.RegistryWrapper.WrapperLookup

import java.util.concurrent.CompletableFuture

final class ItemTagGenerator(
    output: FabricDataOutput,
    registriesFuture: CompletableFuture[WrapperLookup],
    blockTagGenerator: BlockTagProvider
) extends ItemTagProvider(output, registriesFuture, blockTagGenerator) {
  override def configure(wrapperLookup: WrapperLookup): Unit = {
    getOrCreateTagBuilder(HdTags.COPPER_FOODS)
      .add(HdItems.COPPER_APPLE)
      .add(HdItems.ENCHANTED_COPPER_APPLE)
      .add(HdItems.COPPER_BREAD)
      .add(HdItems.COPPER_CARROT)
      .add(HdItems.COPPER_KELP)
      .add(HdItems.COPPER_MELON_SLICE)
      .add(HdItems.COPPER_POTATO)
      .add(HdItems.COPPER_HODGEPODGE)
    getOrCreateTagBuilder(HdTags.FOODS)
      .add(HdItems.AMETHYST_CHOCOLATE)
      .add(HdItems.AMETHYST_MARSHMALLOW)
      .add(HdItems.CHOCOLATE)
      .add(HdItems.CHOCOLATE_BAR)
      .add(HdItems.CHOCOLATE_PASTE)
      .add(HdItems.HONEY_CANDY)
      .add(HdItems.MARSHMALLOW)
      .add(HdItems.MILK_CHOCOLATE)
      .add(HdItems.SWEET_BERRY_CHOCOLATE)
      .add(HdItems.SWEET_BERRY_MARSHMALLOW)
      .add(HdItems.SYRUP)
      .add(HdItems.MEDICINE)
      .addTag(HdTags.COPPER_FOODS)
    getOrCreateTagBuilder(ConventionalItemTags.FOODS)
      .addTag(HdTags.FOODS)
    getOrCreateTagBuilder(ConventionalItemTags.CANDY_FOODS)
      .add(HdItems.HONEY_CANDY)
    getOrCreateTagBuilder(ConventionalItemTags.FRUIT_FOODS)
      .add(HdItems.COPPER_APPLE)
      .add(HdItems.ENCHANTED_COPPER_APPLE)
  }
}
