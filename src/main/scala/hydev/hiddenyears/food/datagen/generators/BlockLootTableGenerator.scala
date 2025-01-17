package hydev.hiddenyears.food.datagen.generators

import hydev.hiddenyears.food.block.HdBlocks
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.minecraft.registry.RegistryWrapper.WrapperLookup

import java.util.concurrent.CompletableFuture

final class BlockLootTableGenerator(
    output: FabricDataOutput,
    registriesFuture: CompletableFuture[WrapperLookup]
) extends FabricBlockLootTableProvider(output, registriesFuture) {
  override def generate(): Unit = {
    addDrop(HdBlocks.CHOCOLATE_BLOCK)
    addDrop(HdBlocks.CHOCOLATE_BRICKS)
  }
}
