package com.mistfist.thisismagicmod.event;

import com.mistfist.thisismagicmod.item.DamageRuneItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.mistfist.thisismagicmod.ThisIsMagic;

/**
 * Handles events related to rune effects
 */
@Mod.EventBusSubscriber(modid = ThisIsMagic.MOD_ID)
public class RuneEventHandler {
    
    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        if (event.getSource().getDirectEntity() instanceof Player player) {
            ItemStack weapon = player.getMainHandItem();
            
            // Check if the weapon has a permanent damage boost from a rune
            float damageBoost = DamageRuneItem.getAppliedDamageBoost(weapon);
            if (damageBoost > 0) {
                // Increase the damage
                event.setAmount(event.getAmount() + damageBoost);
            }
        }
    }
} 