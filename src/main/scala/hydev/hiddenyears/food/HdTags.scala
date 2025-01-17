package hydev.hiddenyears.food

import net.minecraft.item.Item
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.TagKey

object HdTags {
  val COPPER_FOODS: TagKey[Item] = TagKey.of(
    RegistryKeys.ITEM,
    HiddenDelight.ofMod("hidden_years:foods/copper")
  )
}
