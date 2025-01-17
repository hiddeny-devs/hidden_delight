package hydev.hiddenyears.food.item

import hydev.hiddenyears.food.injected.FoodComponent$BuilderInjector
import net.minecraft.component.`type`.FoodComponent
import net.minecraft.entity.effect.{StatusEffectInstance, StatusEffects}
import net.minecraft.item.Items

object HdFoodComponents {
  // candies
  val AMETHYST_CHOCOLATE: FoodComponent = new FoodComponent.Builder()
    .nutrition(1)
    .saturationModifier(0.6f)
    .alwaysEdible()
    .build()
  val AMETHYST_MARSHMALLOW: FoodComponent = new FoodComponent.Builder()
    .saturationModifier(0.6f)
    .alwaysEdible()
    .build()
  val CHOCOLATE: FoodComponent = new FoodComponent.Builder()
    .nutrition(8)
    .saturationModifier(0.6f)
    .alwaysEdible()
    .build()
  val CHOCOLATE_BAR: FoodComponent = new FoodComponent.Builder()
    .nutrition(14)
    .saturationModifier(0.6f)
    .alwaysEdible()
    .build()
  val CHOCOLATE_PASTE: FoodComponent = new FoodComponent.Builder()
    .nutrition(10)
    .saturationModifier(0.6f)
    .alwaysEdible()
    .statusEffect(
      new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 45 * 20),
      1.0f
    )
    .build()
  val HONEY_CANDY: FoodComponent = new FoodComponent.Builder()
    .nutrition(20)
    .saturationModifier(0.6f)
    .alwaysEdible()
    .statusEffect(
      new StatusEffectInstance(StatusEffects.SATURATION, 30 * 20),
      1.0f
    )
    .build()
  val MARSHMALLOW: FoodComponent = new FoodComponent.Builder()
    .nutrition(5)
    .saturationModifier(0.6f)
    .alwaysEdible()
    .statusEffect(
      new StatusEffectInstance(StatusEffects.LEVITATION, 5 * 20),
      0.5f
    )
    .build()
  val MILK_CHOCOLATE: FoodComponent = new FoodComponent.Builder()
    .nutrition(10)
    .saturationModifier(0.6f)
    .alwaysEdible()
    .build()
  val SWEET_BERRY_CHOCOLATE: FoodComponent = new FoodComponent.Builder()
    .nutrition(8)
    .saturationModifier(0.6f)
    .alwaysEdible()
    .statusEffect(
      new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 1),
      1.0f
    )
    .build()
  val SWEET_BERRY_MARSHMALLOW: FoodComponent = new FoodComponent.Builder()
    .nutrition(5)
    .saturationModifier(0.6f)
    .alwaysEdible()
    .statusEffect(
      new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1),
      1.0f
    )
    .build()
  val SYRUP: FoodComponent = new FoodComponent.Builder()
    .nutrition(2)
    .saturationModifier(1.0f)
    .alwaysEdible()
    .usingConvertsTo(Items.GLASS_BOTTLE)
    .statusEffect(
      new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1),
      1.0f
    )
    .asInstanceOf[FoodComponent$BuilderInjector]
    .hidden_delight$setEatSeconds(2.0f)
    .build()
  // copper_foods
  val COPPER_APPLE: FoodComponent = new FoodComponent.Builder()
    .nutrition(8)
    .saturationModifier(0.6f)
    .alwaysEdible()
    .statusEffect(
      new StatusEffectInstance(StatusEffects.ABSORPTION, 600),
      1.0f
    )
    .statusEffect(
      new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 200),
      1.0f
    )
    .build()
  val ENCHANTED_COPPER_APPLE: FoodComponent = new FoodComponent.Builder()
    .nutrition(8)
    .saturationModifier(0.6f)
    .alwaysEdible()
    .statusEffect(
      new StatusEffectInstance(StatusEffects.ABSORPTION, 1200),
      1.0f
    )
    .statusEffect(
      new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 1200),
      1.0f
    )
    .statusEffect(
      new StatusEffectInstance(StatusEffects.SPEED, 200),
      1.0f
    )
    .build()
  val COPPER_BREAD: FoodComponent = new FoodComponent.Builder()
    .nutrition(9)
    .saturationModifier(0.6f)
    .alwaysEdible()
    .build()
  val COPPER_CARROT: FoodComponent = new FoodComponent.Builder()
    .nutrition(7)
    .saturationModifier(0.6f)
    .alwaysEdible()
    .build()
  val COPPER_KELP: FoodComponent = new FoodComponent.Builder()
    .nutrition(5)
    .saturationModifier(0.6f)
    .alwaysEdible()
    .build()
  val COPPER_MELON_SLICE: FoodComponent = new FoodComponent.Builder()
    .nutrition(6)
    .saturationModifier(0.6f)
    .alwaysEdible()
    .build()
  val COPPER_POTATO: FoodComponent = new FoodComponent.Builder()
    .nutrition(8)
    .saturationModifier(0.6f)
    .alwaysEdible()
    .build()
  val COPPER_HODGEPODGE: FoodComponent = new FoodComponent.Builder()
    .nutrition(20)
    .saturationModifier(0.6f)
    .alwaysEdible()
    .usingConvertsTo(Items.BOWL)
    .build()
  // medicines
  val MEDICINE: FoodComponent = new FoodComponent.Builder()
    .nutrition(2)
    .saturationModifier(1.0f)
    .alwaysEdible()
    .usingConvertsTo(Items.GLASS_BOTTLE)
    .asInstanceOf[FoodComponent$BuilderInjector]
    .hidden_delight$setEatSeconds(2.0f)
    .build()
}