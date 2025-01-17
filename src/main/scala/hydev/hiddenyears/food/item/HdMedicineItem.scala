package hydev.hiddenyears.food.item

import hydev.hiddenyears.food.item.HdMedicineItem.getMaterials
import hydev.hiddenyears.food.util.isHarmful
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.effect.{StatusEffectInstance, StatusEffects}
import net.minecraft.item.Item.Settings
import net.minecraft.item.tooltip.TooltipType
import net.minecraft.item.{Item, ItemStack, Items}
import net.minecraft.text.{MutableText, Text}
import net.minecraft.world.World

import java.util

final class HdMedicineItem extends HdDrinkItem(new Settings().maxCount(1), HdFoodComponents.MEDICINE, HdMedicineItem.onUse) {
  override def appendTooltip(stack: ItemStack, context: Item.TooltipContext, tooltip: util.List[Text], `type`: TooltipType): Unit = {
    val id: Integer = stack.get(HdDataComponentTypes.MEDICINE_ID)
    if (id != null && `type`.isCreative) {
      val text: MutableText = Text.translatable("hidden_delight.medicine.materials")
      getMaterials(id).foreach(item => {
        text.append(item.getName)
      })
      tooltip.add(text)
    }
  }
}
object HdMedicineItem {
  def getMaterials(id: Int): Array[Item] = {
    id match {
      case 1 => Array(Items.DANDELION)
      case 2 => Array(Items.POPPY)
      case 3 => Array(Items.BLUE_ORCHID)
      case 4 => Array(Items.ALLIUM)
      case 5 => Array(Items.AZURE_BLUET)
      case 6 =>
        Array(
          Items.RED_TULIP,
          Items.ORANGE_TULIP,
          Items.WHITE_TULIP,
          Items.PINK_TULIP
        )
      case 7  => Array(Items.OXEYE_DAISY)
      case 8  => Array(Items.CORNFLOWER)
      case 9  => Array(Items.LILY_OF_THE_VALLEY)
      case 10 => Array(Items.WITHER_ROSE)
      case 11 => Array(Items.TORCHFLOWER)
      case 12 => Array(Items.PITCHER_PLANT)
      case 13 => Array(Items.SEAGRASS)
      case 14 => Array(Items.SUNFLOWER)
    }
  }

  def validIds: List[Int] = (1 to 14).toList

  private def onUse(stack: ItemStack, world: World, livingEntity: LivingEntity): Unit = {
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
