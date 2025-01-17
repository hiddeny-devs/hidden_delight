package hydev.hiddenyears.food.mixin;

import hydev.hiddenyears.food.HdTags;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @Unique
    private int hidden_delight$copperFoodConsumeTime = 0;

    @Shadow
    public abstract boolean addStatusEffect(StatusEffectInstance effect);

    @Inject(method = "eatFood(Lnet/minecraft/world/World;Lnet/minecraft/item/ItemStack;Lnet/minecraft/component/type/FoodComponent;)Lnet/minecraft/item/ItemStack;", at = @At("RETURN"))
    private void onEatFood(World world, ItemStack stack, FoodComponent foodComponent, CallbackInfoReturnable<ItemStack> cir) {
        if (!stack.isIn(HdTags.COPPER_FOODS())) return;
        if (this.hidden_delight$copperFoodConsumeTime >= 12) {
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100));
            this.hidden_delight$copperFoodConsumeTime = 0;
        }
        hidden_delight$copperFoodConsumeTime++;
    }

    @Inject(method = "writeCustomDataToNbt(Lnet/minecraft/nbt/NbtCompound;)V", at = @At("RETURN"))
    private void onWriteCustomDataToNbt(NbtCompound nbt, CallbackInfo ci) {
        nbt.putInt("hidden_delight$copperFoodConsumeTime", hidden_delight$copperFoodConsumeTime);
    }

    @Inject(method = "readCustomDataFromNbt(Lnet/minecraft/nbt/NbtCompound;)V", at = @At("RETURN"))
    private void onReadCustomDataFromNbt(NbtCompound nbt, CallbackInfo ci) {
        this.hidden_delight$copperFoodConsumeTime = nbt.getInt("hidden_delight$copperFoodConsumeTime");
    }
}
