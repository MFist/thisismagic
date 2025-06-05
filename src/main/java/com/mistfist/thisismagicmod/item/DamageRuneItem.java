package com.mistfist.thisismagicmod.item;

import com.mistfist.thisismagicmod.registry.ModRuneTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.nbt.CompoundTag;
import java.util.List;
import javax.annotation.Nullable;

/**
 * A rune that applies damage effects when used.
 */
public class DamageRuneItem extends RuneItem {
    private final float damageAmount;
    private static final String RUNE_DAMAGE_TAG = "rune_damage_boost";

    public DamageRuneItem(Properties properties, float damageAmount) {
        super(properties, ModRuneTypes.DAMAGE);
        this.damageAmount = damageAmount;
    }

    @Override
    public boolean applyEffect(ItemStack stack) {
        if (stack.getItem() instanceof SwordItem) {
            CompoundTag tag = stack.getOrCreateTag();
            tag.putFloat(RUNE_DAMAGE_TAG, damageAmount);
            return true;
        }
        return false;
    }

    /**
     * Gets the current damage boost applied to the item, if any
     */
    public static float getAppliedDamageBoost(ItemStack stack) {
        CompoundTag tag = stack.getTag();
        return tag != null ? tag.getFloat(RUNE_DAMAGE_TAG) : 0.0f;
    }

    @Override
    public String getEffectDescription() {
        return String.format("+%.1f Attack Damage", damageAmount);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
        tooltipComponents.add(Component.translatable("item.thisismagicmod.rune_force.tooltip", getEffectDescription()));
        tooltipComponents.add(Component.translatable("item.thisismagicmod.rune_force.usage"));
    }

    public float getDamageAmount() {
        return damageAmount;
    }
} 