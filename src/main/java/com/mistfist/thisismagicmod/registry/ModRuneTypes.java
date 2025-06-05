package com.mistfist.thisismagicmod.registry;

/**
 * Defines the different types of runes available in the mod.
 * Each type represents a different magical effect that can be applied.
 */
public enum ModRuneTypes {
    DAMAGE("damage", "Applies damage effects"),
    // More rune types will be added here
    ;

    private final String id;
    private final String description;

    ModRuneTypes(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
} 