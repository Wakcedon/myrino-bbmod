package com.wakcedon.myrino.client.renderer;

import com.wakcedon.myrino.entity.TowerBossEntity;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;

public class TowerBossRenderer extends BipedEntityRenderer<TowerBossEntity, BipedEntityModel<TowerBossEntity>> {
    public TowerBossRenderer(EntityRendererFactory.Context context) {
        super(context, new BipedEntityModel<>(context.getPart(EntityModelLayers.PLAYER)), 0.75f);
    }
}
