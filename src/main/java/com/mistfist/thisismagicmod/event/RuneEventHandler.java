package com.mistfist.thisismagicmod.event;

import com.mistfist.thisismagicmod.item.DamageRuneItem;
import com.mistfist.thisismagicmod.item.RuneItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.mistfist.thisismagicmod.ThisIsMagic;

@Mod.EventBusSubscriber(modid = ThisIsMagic.MOD_ID)
public class RuneEventHandler {
    
    @SubscribeEvent
    public static void onPlayerAttack(AttackEntityEvent event) {
        Player player = event.getEntity();
        
        // Check main hand and offhand for runes
        ItemStack mainHand = player.getMainHandItem();
        ItemStack offHand = player.getOffhandItem();
        
        // Apply rune effects if player is holding a rune and a weapon
        if (mainHand.getItem() instanceof RuneItem rune) {
            // Rune in main hand, check if offhand has a weapon
            if (isWeapon(offHand)) {
                rune.applyEffect(offHand);
            }
        } else if (offHand.getItem() instanceof RuneItem rune && isWeapon(mainHand)) {
            // Rune in offhand, weapon in main hand
            rune.applyEffect(mainHand);
        }
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        if (event.getSource().getDirectEntity() instanceof Player player) {
            ItemStack weapon = player.getMainHandItem();
            
            // Check if the weapon has a damage boost from a rune
            float damageBoost = DamageRuneItem.getAppliedDamageBoost(weapon);
            if (damageBoost > 0) {
                // Increase the damage
                event.setAmount(event.getAmount() + damageBoost);
            }
        }
    }
    
    private static boolean isWeapon(ItemStack stack) {
        // For now, we'll just check if it's a sword via the tag
        return stack.is(net.minecraft.tags.ItemTags.SWORDS);
    }
} 