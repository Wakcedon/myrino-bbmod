package com.wakcedon.myrino.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.AttackGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class TowerBossEntity extends HostileEntity {
    private final ServerBossBar bossBar = new ServerBossBar(
            Text.literal("Tower Boss"),
            BossBar.Color.PURPLE,
            BossBar.Style.PROGRESS
    );

    private int phase = 1;
    private int phaseChangeThreshold;

    public TowerBossEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.phaseChangeThreshold = (int) (this.getMaxHealth() * 0.5);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(2, new AttackGoal(this, 1.2D, false));
        this.goalSelector.add(5, new WanderAroundGoal(this, 0.8D));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 16.0F));

        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    public static DefaultAttributeContainer.Builder createMobAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 64.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 15.0D)
                .add(EntityAttributes.GENERIC_ARMOR, 5.0D)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 100.0D);
    }

    @Override
    public void tick() {
        super.tick();

        bossBar.setPercent(this.getHealth() / this.getMaxHealth());

        // Phase transition logic
        if (this.getHealth() < phaseChangeThreshold && phase == 1) {
            phase = 2;
            phaseChangeThreshold = (int) (this.getMaxHealth() * 0.25);
            this.onPhaseChange(2);
        }
    }

    @Override
    public void onDamaged(DamageSource damageSource) {
        super.onDamaged(damageSource);
        bossBar.setPercent(this.getHealth() / this.getMaxHealth());
    }

    private void onPhaseChange(int newPhase) {
        // Boss behavior changes based on phase
        if (newPhase == 2) {
            this.getAttributes().get(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue(0.5D);
            this.getAttributes().get(EntityAttributes.GENERIC_ATTACK_DAMAGE).setBaseValue(20.0D);
        }
    }

    @Override
    protected void onDeathAI() {
        super.onDeathAI();
        this.bossBar.clearPlayers();
    }

    @Override
    protected float getActiveEyeHeight(net.minecraft.entity.pose pose, net.minecraft.entity.EntityDimensions dimensions) {
        return 2.0F;
    }

    public ServerBossBar getBossBar() {
        return bossBar;
    }
}
