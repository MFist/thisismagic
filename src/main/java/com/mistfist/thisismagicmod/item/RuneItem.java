package com.mistfist.thisismagicmod.item;

import com.mistfist.thisismagicmod.registry.ModRuneTypes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

/**
 * Base class for all rune items in the mod.
 * Provides common functionality and properties for runes.
 */
public abstract class RuneItem extends Item {
    private final ModRuneTypes runeType;

    public RuneItem(Properties properties, ModRuneTypes runeType) {
        super(properties);
        this.runeType = runeType;
    }

    public ModRuneTypes getRuneType() {
        return runeType;
    }

    /**
     * Apply the rune's effect. To be implemented by specific rune types.
     * @param stack The ItemStack containing this rune
     * @return true if the effect was successfully applied
     */
    public abstract boolean applyEffect(ItemStack stack);

    public abstract String getEffectDescription();
} 