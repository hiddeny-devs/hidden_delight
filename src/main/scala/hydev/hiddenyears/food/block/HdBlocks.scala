package hydev.hiddenyears.food.block

import hydev.hiddenyears.food.HiddenDelight
import net.minecraft.block.AbstractBlock.Settings
import net.minecraft.block.{Block, MapColor}
import net.minecraft.registry.{Registries, Registry}
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.{DyeColor, Identifier}

object HdBlocks {
  val CHOCOLATE_BRICKS: Block = register(
    new Block(
      Settings
        .create()
        .solid()
        .sounds(BlockSoundGroup.METAL)
        .mapColor(MapColor.LIGHT_GRAY)
        .hardness(1.9f)
        .resistance(6.0f)
        .requiresTool()
    ),
    "chocolate_bricks"
  )
  val CHOCOLATE_BLOCK: Block = register(
    new Block(
      Settings
        .create()
        .solid()
        .sounds(BlockSoundGroup.METAL)
        .mapColor(MapColor.LIGHT_GRAY)
        .hardness(1.9f)
        .resistance(6.0f)
        .requiresTool()
    ),
    "chocolate_block"
  )
  def init(): Unit = {}
  private def register(block: Block, name: String): Block = {
    val id: Identifier = HiddenDelight.ofMod(name)
    Registry.register(Registries.BLOCK, id, block)
  }
}
