package hydev.hiddenyears.food.mixin;

import hydev.hiddenyears.food.injected.FoodComponent$BuilderInjector;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.component.type.FoodComponent;

@Mixin(FoodComponent.Builder.class)
public final class FoodComponent$BuilderMixin implements FoodComponent$BuilderInjector {
    @Shadow
    private float eatSeconds;

    @Override
    public FoodComponent.Builder hidden_delight$setEatSeconds(float time) {
        this.eatSeconds = time;
        return (FoodComponent.Builder) (Object) this;
    }
}
