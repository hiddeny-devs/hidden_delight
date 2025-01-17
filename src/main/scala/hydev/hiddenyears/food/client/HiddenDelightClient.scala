package hydev.hiddenyears.food.client

import hydev.hiddenyears.food.HiddenDelight
import hydev.hiddenyears.food.item.{HdDataComponentTypes, HdItems}
import net.fabricmc.api.{ClientModInitializer, EnvType, Environment}
import net.minecraft.client.item.ModelPredicateProviderRegistry
import net.minecraft.item.ItemStack

@Environment(EnvType.CLIENT)
object HiddenDelightClient extends ClientModInitializer {
  override def onInitializeClient(): Unit = {
    ModelPredicateProviderRegistry.register(
      HdItems.MEDICINE,
      HiddenDelight.ofMod("id"),
      (stack: ItemStack, _, _, _) => {
        stack.get(HdDataComponentTypes.MEDICINE_ID).floatValue()
      }
    )
  }
}
