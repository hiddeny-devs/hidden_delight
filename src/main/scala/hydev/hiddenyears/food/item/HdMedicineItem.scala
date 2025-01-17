package hydev.hiddenyears.food.item

import hydev.hiddenyears.food.util.isHarmful
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.effect.{StatusEffectInstance, StatusEffects}
import net.minecraft.item.Item.Settings
import net.minecraft.item.tooltip.TooltipType
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.text.Text
import net.minecraft.world.World

import java.util

final class HdMedicineItem
    extends HdDrinkItem(
      new Settings().maxCount(1),
      HdFoodComponents.MEDICINE,
      HdMedicineItem.onUse
    ) {
  override def appendTooltip(
      stack: ItemStack,
      context: Item.TooltipContext,
      tooltip: util.List[Text],
      `type`: TooltipType
  ): Unit = {
    val id: Integer = stack.get(HdDataComponentTypes.MEDICINE_ID)
    if (id != null && `type`.isCreative) {
      tooltip.add(
        Text.translatable(
          "filled_map.id", // So we do not need any other translate key
          id
        )
      )
    }
  }
}
private object HdMedicineItem {
  private def onUse(
      stack: ItemStack,
      world: World,
      livingEntity: LivingEntity
  ): Unit = {
    if (world.isClient) {
      return
    }
    stack.get(HdDataComponentTypes.MEDICINE_ID) match
      case 1 =>
        livingEntity.addStatusEffect(
          new StatusEffectInstance(StatusEffects.SATURATION, 400)
        )
        livingEntity.removeStatusEffect(StatusEffects.NAUSEA)
        livingEntity.removeStatusEffect(StatusEffects.HUNGER)
      case 2 =>
        livingEntity.getActiveStatusEffects
          .keySet()
          .forEach(entry => {
            if (entry.value().isHarmful) {
              livingEntity.removeStatusEffect(entry)
            }
          })
      case 3 =>
        livingEntity.addStatusEffect(
          new StatusEffectInstance(StatusEffects.NIGHT_VISION, 400)
        )
        livingEntity.removeStatusEffect(StatusEffects.DARKNESS)
        livingEntity.removeStatusEffect(StatusEffects.BLINDNESS)
      case 4 =>
        livingEntity.addStatusEffect(
          new StatusEffectInstance(StatusEffects.BLINDNESS, 600)
        )
        livingEntity.addStatusEffect(
          new StatusEffectInstance(StatusEffects.DARKNESS, 600)
        )
        livingEntity.removeStatusEffect(StatusEffects.NIGHT_VISION)
      case 5 =>
        livingEntity.addStatusEffect(
          new StatusEffectInstance(StatusEffects.ABSORPTION, 400)
        )
        livingEntity.removeStatusEffect(StatusEffects.WITHER)
        livingEntity.removeStatusEffect(StatusEffects.POISON)
      case 6 =>
        livingEntity.addStatusEffect(
          new StatusEffectInstance(StatusEffects.STRENGTH, 400)
        )
        livingEntity.removeStatusEffect(StatusEffects.WEAKNESS)
      case 7 =>
        livingEntity.addStatusEffect(
          new StatusEffectInstance(StatusEffects.SPEED, 600)
        )
        livingEntity.removeStatusEffect(StatusEffects.SLOWNESS)
      case 8 =>
        livingEntity.addStatusEffect(
          new StatusEffectInstance(StatusEffects.JUMP_BOOST, 600)
        )
        livingEntity.removeStatusEffect(StatusEffects.SLOWNESS)
      case 9 =>
        livingEntity.addStatusEffect(
          new StatusEffectInstance(StatusEffects.POISON, 400)
        )
        livingEntity.addStatusEffect(
          new StatusEffectInstance(StatusEffects.SLOWNESS, 400)
        )
        livingEntity.addStatusEffect(
          new StatusEffectInstance(StatusEffects.WEAKNESS, 400)
        )
      case 10 =>
        livingEntity
          .damage(livingEntity.getDamageSources.magic(), Float.MaxValue)
      case 11 =>
        livingEntity.getActiveStatusEffects
          .keySet()
          .forEach(entry => {
            if (entry.value().isBeneficial) {
              livingEntity.removeStatusEffect(entry)
            }
          })
      case 12 =>
        livingEntity.addStatusEffect(
          new StatusEffectInstance(
            StatusEffects.HERO_OF_THE_VILLAGE,
            3000
          )
        )
        livingEntity.removeStatusEffect(StatusEffects.BAD_OMEN)
      case 13 =>
        livingEntity.addStatusEffect(
          new StatusEffectInstance(StatusEffects.WATER_BREATHING, 300)
        )
        livingEntity.removeStatusEffect(StatusEffects.MINING_FATIGUE)
      case 14 =>
        livingEntity.addStatusEffect(
          new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 400)
        )
      case 15 =>
        livingEntity.addStatusEffect(
          new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 6000)
        )
  }
}
