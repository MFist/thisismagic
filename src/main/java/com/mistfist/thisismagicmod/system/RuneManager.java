package com.mistfist.thisismagicmod.system;

import com.mistfist.thisismagicmod.item.RuneItem;
import net.minecraft.world.item.ItemStack;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages the rune system, including rune combinations and effect applications.
 */
public class RuneManager {
    private static final RuneManager INSTANCE = new RuneManager();
    private final Map<String, RuneItem> registeredRunes = new HashMap<>();

    private RuneManager() {}

    public static RuneManager getInstance() {
        return INSTANCE;
    }

    /**
     * Register a new rune with the manager
     * @param id The unique identifier for the rune
     * @param rune The rune item to register
     */
    public void registerRune(String id, RuneItem rune) {
        registeredRunes.put(id, rune);
    }

    /**
     * Apply a rune's effect
     * @param runeStack The ItemStack containing the rune
     * @return true if the effect was successfully applied
     */
    public boolean applyRuneEffect(ItemStack runeStack) {
        if (runeStack.getItem() instanceof RuneItem rune) {
            return rune.applyEffect(runeStack);
        }
        return false;
    }
} 