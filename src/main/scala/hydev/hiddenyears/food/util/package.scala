package hydev.hiddenyears.food

import net.minecraft.entity.effect.{StatusEffect, StatusEffectCategory}

package object util {

  extension (effect: StatusEffect) {
    def isHarmful: Boolean = {
      effect.getCategory == StatusEffectCategory.HARMFUL
    }
  }
}
