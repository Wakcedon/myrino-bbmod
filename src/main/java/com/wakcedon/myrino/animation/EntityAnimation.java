package com.wakcedon.myrino.animation;

import net.minecraft.entity.Entity;

public abstract class EntityAnimation {
    protected String name;
    protected int duration;
    protected int currentFrame;
    protected boolean isPlaying;

    public EntityAnimation(String name, int duration) {
        this.name = name;
        this.duration = duration;
        this.currentFrame = 0;
        this.isPlaying = false;
    }

    public void play() {
        this.isPlaying = true;
        this.currentFrame = 0;
    }

    public void stop() {
        this.isPlaying = false;
    }

    public void update() {
        if (isPlaying) {
            currentFrame++;
            if (currentFrame >= duration) {
                currentFrame = 0;
                isPlaying = false;
            }
        }
    }

    public abstract void apply(Entity entity);

    public boolean isPlaying() {
        return isPlaying;
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public float getProgress() {
        return (float) currentFrame / duration;
    }

    public String getName() {
        return name;
    }
}
