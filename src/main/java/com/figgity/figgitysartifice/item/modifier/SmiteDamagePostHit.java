package com.figgity.figgitysartifice.item.modifier;

import io.redspace.irons_artifice.entity.Bullet;
import io.redspace.irons_artifice.modifier.PostHitEffect;
import io.redspace.irons_artifice.utils.Utils;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.HitResult;

public class SmiteDamagePostHit implements PostHitEffect {
    public static final int DAMAGE = 4;

    private int stacks;

    public void addStack(){
        stacks++;
    }

    @Override
    public void postHit(ServerLevel level, Bullet bullet, HitResult hitResult, Entity entity) {
        if (!Utils.canHarm(bullet.getOwner(), entity)) {
            return;
        }
        if(entity.isAlive()){
            LivingEntity livingEntity = (LivingEntity) entity;
            if (livingEntity.getType().is(EntityTypeTags.SENSITIVE_TO_SMITE) || livingEntity.getType().is(EntityTypeTags.ILLAGER)) {
                livingEntity.hurt(new DamageSource(level.holderOrThrow(DamageTypes.MAGIC)), DAMAGE * stacks);
            }
        }
    }
}