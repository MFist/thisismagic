package com.mistfist.thisismagicmod.item;

import com.mistfist.thisismagicmod.registry.ModRuneTypes;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import javax.annotation.Nonnull;

/**
 * Base class for all rune items in the mod.
 * Provides common functionality and properties for runes.
 */
public abstract class RuneItem extends Item {
    private final ModRuneTypes runeType;
    public static final String RUNES_APPLIED_TAG = "applied_runes";

    public RuneItem(@Nonnull Properties properties, @Nonnull ModRuneTypes runeType) {
        super(properties.stacksTo(16)); // Runes stack to 16 by default
        this.runeType = runeType;
    }

    /**
     * Gets the type of rune this item represents.
     * @return The rune type
     */
    @Nonnull
    public ModRuneTypes getRuneType() {
        return runeType;
    }

    @Override
    @Nonnull
    public InteractionResultHolder<ItemStack> use(@Nonnull Level level, @Nonnull Player player, @Nonnull InteractionHand hand) {
        ItemStack runeStack = player.getItemInHand(hand);
        ItemStack otherHand = player.getItemInHand(hand == InteractionHand.MAIN_HAND ? 
                                                  InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND);

        // Try to apply the rune to the item in the other hand
        if (canApplyTo(otherHand) && !hasRuneApplied(otherHand, this.runeType)) {
            if (applyEffect(otherHand)) {
                // Play success sound and show particles
                level.playSound(null, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS,
                        1.0F, 1.0F);

                // Consume one rune
                runeStack.shrink(1);

                // Send success message
                if (!level.isClientSide) {
                    player.displayClientMessage(
                        Component.translatable("message.thisismagicmod.rune_applied"), true);
                }

                return InteractionResultHolder.success(runeStack);
            }
        }

        return InteractionResultHolder.pass(runeStack);
    }

    /**
     * Check if this rune can be applied to the given item.
     * @param stack The ItemStack to check
     * @return true if the rune can be applied to this item
     */
    public abstract boolean canApplyTo(@Nonnull ItemStack stack);

    /**
     * Apply the rune's effect to the target item.
     * @param stack The ItemStack to apply the effect to
     * @return true if the effect was successfully applied
     */
    public abstract boolean applyEffect(@Nonnull ItemStack stack);

    /**
     * Get the effect description for tooltips.
     * @return A string describing the rune's effect
     */
    @Nonnull
    public abstract String getEffectDescription();

    /**
     * Check if a specific rune type has already been applied to an item.
     * @param stack The ItemStack to check
     * @param runeType The rune type to check for
     * @return true if the rune type has already been applied
     */
    protected boolean hasRuneApplied(@Nonnull ItemStack stack, @Nonnull ModRuneTypes runeType) {
        return stack.getOrCreateTag().contains(runeType.getId());
    }
} 