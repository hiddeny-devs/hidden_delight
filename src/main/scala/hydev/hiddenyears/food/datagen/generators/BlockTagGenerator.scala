package hydev.hiddenyears.food.datagen.generators

import hydev.hiddenyears.food.block.HdBlocks
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider.BlockTagProvider
import net.minecraft.registry.RegistryWrapper.WrapperLookup
import net.minecraft.registry.tag.BlockTags

import java.util.concurrent.CompletableFuture

final class BlockTagGenerator(
    output: FabricDataOutput,
    registriesFuture: CompletableFuture[WrapperLookup]
) extends BlockTagProvider(output, registriesFuture) {
  override def configure(wrapperLookup: WrapperLookup): Unit = {
    getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
      .add(HdBlocks.CHOCOLATE_BLOCK)
      .add(HdBlocks.CHOCOLATE_BRICKS)
  }
}
