package com.wakcedon.myrino.client.renderer;

import com.wakcedon.myrino.entity.EliteGuardianEntity;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;

public class EliteGuardianRenderer extends BipedEntityRenderer<EliteGuardianEntity, BipedEntityModel<EliteGuardianEntity>> {
    public EliteGuardianRenderer(EntityRendererFactory.Context context) {
        super(context, new BipedEntityModel<>(context.getPart(EntityModelLayers.PLAYER)), 0.6f);
    }
}
