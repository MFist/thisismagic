package com.mistfist.thisismagicmod.system;

import com.mistfist.thisismagicmod.item.RuneItem;
import net.minecraft.world.item.ItemStack;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages the rune system, including rune combinations and effect applications.
 */
public class RuneManager {
    private static final RuneManager INSTANCE = new RuneManager();
    private final Map<String, RuneItem> registeredRunes = new HashMap<>();

    private RuneManager() {}

    @Nonnull
    public static RuneManager getInstance() {
        return INSTANCE;
    }

    /**
     * Register a new rune with the manager
     * @param id The unique identifier for the rune
     * @param rune The rune item to register
     */
    public void registerRune(@Nonnull String id, @Nonnull RuneItem rune) {
        registeredRunes.put(id, rune);
    }

    /**
     * Get a registered rune by its ID
     * @param id The unique identifier of the rune
     * @return The rune item, or null if not found
     */
    @Nullable
    public RuneItem getRune(@Nonnull String id) {
        return registeredRunes.get(id);
    }

    /**
     * Apply a rune's effect to a target item
     * @param runeStack The ItemStack containing the rune
     * @param targetStack The ItemStack to apply the rune effect to
     * @return true if the effect was successfully applied
     */
    public boolean applyRuneEffect(@Nonnull ItemStack runeStack, @Nonnull ItemStack targetStack) {
        if (runeStack.getItem() instanceof RuneItem rune) {
            if (rune.canApplyTo(targetStack)) {
                return rune.applyEffect(targetStack);
            }
        }
        return false;
    }
} 