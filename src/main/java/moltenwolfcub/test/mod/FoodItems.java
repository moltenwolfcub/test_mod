package moltenwolfcub.test.mod;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class FoodItems {

    public static final FoodComponent POP_CORN = (new FoodComponent.Builder()).hunger(4).saturationModifier(0.6F).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 25, 9), 1F).statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 25, 4), 1F).statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 25, 0), 1F).snack().alwaysEdible().build();
    
}
