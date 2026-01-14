package com.wakcedon.myrino.client.renderer;

import com.wakcedon.myrino.MyrinoMod;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.BipedEntityModel;

import com.wakcedon.myrino.entity.TowerMobEntity;

public class TowerMobRenderer extends BipedEntityRenderer<TowerMobEntity, BipedEntityModel<TowerMobEntity>> {
    public TowerMobRenderer(EntityRendererFactory.Context context) {
        super(context, new BipedEntityModel<>(context.getPart(net.minecraft.client.render.entity.model.EntityModelLayers.PLAYER)), 0.5f);
    }
}
