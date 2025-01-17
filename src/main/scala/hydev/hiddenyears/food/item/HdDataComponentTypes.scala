package hydev.hiddenyears.food.item

import com.mojang.serialization.Codec
import hydev.hiddenyears.food.HiddenDelight
import net.minecraft.component.ComponentType
import net.minecraft.registry.{Registries, Registry}

object HdDataComponentTypes {
  val MEDICINE_ID: ComponentType[Integer] = Registry.register(
    Registries.DATA_COMPONENT_TYPE,
    HiddenDelight.ofMod("medicine_id"),
    ComponentType.builder().codec(Codec.INT).build()
  )
}
