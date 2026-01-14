package com.wakcedon.myrino;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wakcedon.myrino.entity.TowerMobEntity;
import com.wakcedon.myrino.entity.TowerBossEntity;
import com.wakcedon.myrino.entity.EliteGuardianEntity;

public class MyrinoMod implements ModInitializer {
    public static final String MOD_ID = "myrino";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // Entity Types
    public static EntityType<TowerMobEntity> TOWER_MOB;
    public static EntityType<TowerBossEntity> TOWER_BOSS;
    public static EntityType<EliteGuardianEntity> ELITE_GUARDIAN;

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Myrino - Infinite Tower Survival Mod");

        // Register custom entities
        TOWER_MOB = registerEntity(
                "tower_mob",
                FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, TowerMobEntity::new)
                        .dimensions(EntityDimensions.fixed(0.6f, 1.8f))
                        .build()
        );

        TOWER_BOSS = registerEntity(
                "tower_boss",
                FabricEntityTypeBuilder.create(SpawnGroup.BOSS, TowerBossEntity::new)
                        .dimensions(EntityDimensions.fixed(1.0f, 2.5f))
                        .build()
        );

        ELITE_GUARDIAN = registerEntity(
                "elite_guardian",
                FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, EliteGuardianEntity::new)
                        .dimensions(EntityDimensions.fixed(0.8f, 2.0f))
                        .build()
        );

        LOGGER.info("Myrino mod initialized successfully!");
    }

    private static <T extends net.minecraft.entity.Entity> EntityType<T> registerEntity(
            String name, EntityType<T> entityType) {
        return Registry.register(Registries.ENTITY_TYPE, new Identifier(MOD_ID, name), entityType);
    }
}
