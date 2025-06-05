package com.mistfist.thisismagicmod.item;

import com.mistfist.thisismagicmod.registry.ModRuneTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.nbt.CompoundTag;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * A rune that permanently enhances a weapon's damage when applied.
 */
public class DamageRuneItem extends RuneItem {
    private final float damageAmount;
    private static final String RUNES_APPLIED_TAG = "applied_runes";

    public DamageRuneItem(@Nonnull Properties properties, float damageAmount) {
        super(properties, ModRuneTypes.DAMAGE);
        this.damageAmount = damageAmount;
    }

    @Override
    public boolean canApplyTo(@Nonnull ItemStack stack) {
        return stack.getItem() instanceof SwordItem;
    }

    @Override
    public boolean applyEffect(@Nonnull ItemStack stack) {
        if (canApplyTo(stack)) {
            CompoundTag tag = stack.getOrCreateTag();
            // Store the damage boost using the rune type ID as the key
            tag.putFloat(getRuneType().getId(), damageAmount);
            
            // Add to the list of applied runes
            String appliedRunes = tag.getString(RUNES_APPLIED_TAG);
            tag.putString(RUNES_APPLIED_TAG, 
                (appliedRunes.isEmpty() ? "" : appliedRunes + ",") + getRuneType().getId());
            
            // Update the item's name to show it's enhanced
            if (!stack.hasCustomHoverName()) {
                stack.setHoverName(Component.translatable("item.thisismagicmod.runed_weapon", 
                    stack.getHoverName()));
            }
            return true;
        }
        return false;
    }

    /**
     * Gets the current damage boost applied to the item, if any.
     * @param stack The ItemStack to check
     * @return The amount of damage boost applied, or 0 if none
     */
    public static float getAppliedDamageBoost(@Nonnull ItemStack stack) {
        CompoundTag tag = stack.getTag();
        return tag != null ? tag.getFloat(ModRuneTypes.DAMAGE.getId()) : 0.0f;
    }

    @Override
    @Nonnull
    public String getEffectDescription() {
        return String.format("+%.1f Attack Damage", damageAmount);
    }

    @Override
    public void appendHoverText(@Nonnull ItemStack stack, @Nullable Level level, 
                              @Nonnull List<Component> tooltipComponents, 
                              @Nonnull TooltipFlag isAdvanced) {
        super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
        tooltipComponents.add(Component.translatable("item.thisismagicmod.rune_force.tooltip", getEffectDescription()));
        tooltipComponents.add(Component.translatable("item.thisismagicmod.rune_force.usage"));
    }

    /**
     * Gets the amount of damage this rune adds when applied.
     * @return The damage boost amount
     */
    public float getDamageAmount() {
        return damageAmount;
    }
} 