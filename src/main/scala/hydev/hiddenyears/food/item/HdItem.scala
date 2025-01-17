package hydev.hiddenyears.food.item

import net.minecraft.component.DataComponentTypes
import net.minecraft.component.`type`.FoodComponent
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item.Settings
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.util.{Hand, TypedActionResult}
import net.minecraft.world.World
import org.apache.commons.lang3.function.TriConsumer

abstract class HdItem(settings: Settings, foodComponent: FoodComponent, private val onUse: TriConsumer[ItemStack, World, LivingEntity])
    extends Item(settings.food(foodComponent)) {
  override final def use(world: World, user: PlayerEntity, hand: Hand): TypedActionResult[ItemStack] = {
    val itemStack: ItemStack = user.getStackInHand(hand)
    val foodComponent: FoodComponent = itemStack.get(DataComponentTypes.FOOD)
    if (user.canConsume(foodComponent.canAlwaysEat)) {
      user.setCurrentHand(hand)
      TypedActionResult.consume(itemStack)
    } else TypedActionResult.fail(itemStack)
  }

  override final def finishUsing(stack: ItemStack, world: World, user: LivingEntity): ItemStack = {
    val newItemStack: ItemStack = user.eatFood(world, stack, stack.get(DataComponentTypes.FOOD))
    onUse.accept(stack, world, user)
    newItemStack
  }

  override final def getMaxUseTime(stack: ItemStack, user: LivingEntity): Int =
    stack.get(DataComponentTypes.FOOD).getEatTicks
}
