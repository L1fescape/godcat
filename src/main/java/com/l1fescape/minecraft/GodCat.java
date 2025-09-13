package com.l1fescape.minecraft;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(GodCat.MODID)
public class GodCat
{
    public static final String MODID = "godcat";
    private static final Logger LOGGER = LogUtils.getLogger();

    public GodCat(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Bus.FORGE)
    public static class CatHitEvent
    {
        @SubscribeEvent
        public static void onCatHit(LivingHurtEvent event)
        {
            LivingEntity entity = event.getEntity();
            if (entity == null) return;
            Component name = entity.getName();
            if (name == null) return;

            if (name.getString().equals("Cat")) {
                event.setCanceled(true);
                entity.setHealth(entity.getMaxHealth());
                LOGGER.info("Damage to {} blocked", name.getString());
                return;
            }
        }
    }
}