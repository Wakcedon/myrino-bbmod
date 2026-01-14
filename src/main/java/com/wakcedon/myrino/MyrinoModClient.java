package com.wakcedon.myrino;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

import com.wakcedon.myrino.client.renderer.TowerMobRenderer;
import com.wakcedon.myrino.client.renderer.TowerBossRenderer;
import com.wakcedon.myrino.client.renderer.EliteGuardianRenderer;

public class MyrinoModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MyrinoMod.LOGGER.info("Initializing Myrino client");

        // Register entity renderers
        EntityRendererRegistry.register(MyrinoMod.TOWER_MOB, TowerMobRenderer::new);
        EntityRendererRegistry.register(MyrinoMod.TOWER_BOSS, TowerBossRenderer::new);
        EntityRendererRegistry.register(MyrinoMod.ELITE_GUARDIAN, EliteGuardianRenderer::new);

        MyrinoMod.LOGGER.info("Myrino client initialized successfully!");
    }
}
