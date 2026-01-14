package com.wakcedon.myrino.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.AttackGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class EliteGuardianEntity extends HostileEntity {
    private int shieldCooldown = 0;
    private boolean hasShield = false;

    public EliteGuardianEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(2, new AttackGoal(this, 1.1D, false));
        this.goalSelector.add(5, new WanderAroundGoal(this, 1.0D));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 10.0F));

        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    public static DefaultAttributeContainer.Builder createMobAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 40.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.22D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 8.0D)
                .add(EntityAttributes.GENERIC_ARMOR, 4.0D)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 35.0D);
    }

    @Override
    public void tick() {
        super.tick();

        if (shieldCooldown > 0) {
            shieldCooldown--;
        } else if (!hasShield) {
            activateShield();
        }
    }

    private void activateShield() {
        hasShield = true;
        shieldCooldown = 100; // 5 seconds cooldown
        this.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 60, 1));
    }

    @Override
    protected float getActiveEyeHeight(net.minecraft.entity.pose pose, net.minecraft.entity.EntityDimensions dimensions) {
        return 1.8F;
    }
}
