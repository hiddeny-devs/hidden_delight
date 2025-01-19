package hydev.hiddenyears.food

import hydev.hiddenyears.food.block.HdBlocks
import hydev.hiddenyears.food.item.{HdItemGroups, HdItems}
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.{ItemGroup, ItemStack}
import net.minecraft.registry.{Registries, Registry}
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import org.slf4j.{Logger, LoggerFactory}

object HiddenDelight extends ModInitializer {
  val MOD_ID: String = "hidden_delight"
  val LOGGER: Logger = LoggerFactory.getLogger("Hidden Delight")

  override def onInitialize(): Unit = {
    HdBlocks.init()
    HdItems.init()
    HdItemGroups.init()
    LOGGER.info("Mod initialized! Thank you for playing!")
  }
  def ofMod(path: String): Identifier = {
    Identifier.of(HiddenDelight.MOD_ID, path)
  }
}
