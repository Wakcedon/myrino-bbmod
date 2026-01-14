package com.wakcedon.myrino.animation;

import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.HostileEntity;

public class AttackAnimation extends EntityAnimation {
    private float rotationAmount;

    public AttackAnimation(String name, int duration, float rotationAmount) {
        super(name, duration);
        this.rotationAmount = rotationAmount;
    }

    @Override
    public void apply(Entity entity) {
        if (isPlaying && entity instanceof HostileEntity hostile) {
            float progress = getProgress();
            // Apply swing animation based on progress
            float yaw = hostile.getYaw() + (rotationAmount * progress);
            hostile.setYaw(yaw);
        }
    }
}
