package hydev.hiddenyears.food.item

import net.minecraft.component.`type`.FoodComponent
import net.minecraft.entity.LivingEntity
import net.minecraft.item.Item.Settings
import net.minecraft.item.ItemStack
import net.minecraft.util.UseAction
import net.minecraft.world.World
import org.apache.commons.lang3.function.TriConsumer

class HdFoodItem(
    settings: Settings,
    foodComponent: FoodComponent,
    onUse: TriConsumer[ItemStack, World, LivingEntity]
) extends HdItem(settings, foodComponent, onUse) {
  def this(settings: Settings, foodComponent: FoodComponent) = {
    this(settings, foodComponent, (_, _, _) => {})
  }

  override final def getUseAction(stack: ItemStack): UseAction = UseAction.EAT
}
