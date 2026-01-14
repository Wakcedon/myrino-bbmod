package com.wakcedon.myrino.animation;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.Entity;

public class AnimationController {
    private Map<String, EntityAnimation> animations;
    private String currentAnimation;
    private Entity entity;

    public AnimationController(Entity entity) {
        this.entity = entity;
        this.animations = new HashMap<>();
        this.currentAnimation = null;
    }

    public void registerAnimation(EntityAnimation animation) {
        animations.put(animation.getName(), animation);
    }

    public void playAnimation(String name) {
        if (animations.containsKey(name)) {
            if (currentAnimation != null && !currentAnimation.equals(name)) {
                EntityAnimation current = animations.get(currentAnimation);
                current.stop();
            }
            currentAnimation = name;
            animations.get(name).play();
        }
    }

    public void update() {
        if (currentAnimation != null) {
            EntityAnimation animation = animations.get(currentAnimation);
            animation.update();
            animation.apply(entity);

            if (!animation.isPlaying()) {
                currentAnimation = null;
            }
        }
    }

    public String getCurrentAnimation() {
        return currentAnimation;
    }

    public boolean isAnimationPlaying(String name) {
        return currentAnimation != null && currentAnimation.equals(name);
    }
}
