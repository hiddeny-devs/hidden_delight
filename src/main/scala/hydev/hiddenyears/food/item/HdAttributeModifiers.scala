package hydev.hiddenyears.food.item

import net.minecraft.component.`type`.{AttributeModifierSlot, AttributeModifiersComponent}
import net.minecraft.entity.attribute.{EntityAttributeModifier, EntityAttributes}
import net.minecraft.item.Item

object HdAttributeModifiers {
  val CHOCOLATE_BAR: AttributeModifiersComponent = createAttributeModifiers(2)

  private def createAttributeModifiers(
      attackDamage: Int
  ): AttributeModifiersComponent = {
    AttributeModifiersComponent.builder
      .add(
        EntityAttributes.GENERIC_ATTACK_DAMAGE,
        new EntityAttributeModifier(
          Item.BASE_ATTACK_DAMAGE_MODIFIER_ID,
          attackDamage,
          EntityAttributeModifier.Operation.ADD_VALUE
        ),
        AttributeModifierSlot.MAINHAND
      )
      .build
  }
}
