package hydev.hiddenyears.food.item

import hydev.hiddenyears.food.HiddenDelight
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.{ItemGroup, ItemStack}
import net.minecraft.registry.{Registries, Registry, RegistryKey}
import net.minecraft.text.Text

object HdItemGroups {
  val ITEM_GROUP: ItemGroup = FabricItemGroup
    .builder()
    .icon(() => new ItemStack(HdItems.CHOCOLATE))
    .displayName(Text.translatable("itemGroup.hidden_years.food"))
    .build()
  val ITEM_GROUP_KEY: RegistryKey[ItemGroup] = RegistryKey.of(
    Registries.ITEM_GROUP.getKey,
    HiddenDelight.ofMod("item_group")
  )
  def init(): Unit = {
    Registry.register(Registries.ITEM_GROUP, ITEM_GROUP_KEY, ITEM_GROUP)
  }
}
