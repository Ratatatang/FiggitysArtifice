package com.figgity.figgitysartifice.effect;

import net.minecraft.client.Minecraft;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.entity.PartEntity;


public class EchoingEffect extends MobEffect {
    //public static boolean shouldRender(Entity self) {
    //    if (!(self instanceof ItemEntity) &&
    //            !(self instanceof Projectile) &&
    //            !(self instanceof LivingEntity) &&
    //            !(self instanceof PartEntity<?>))
    //        return false;
    //    Player player = Proxy.getPlayer();
    //    if (player != null && player.hasEffect(TDEffects.AURORA_GLOWING))
    //        return true;
    //    if (self instanceof LivingEntity le && L2LibReg.EFFECT.type().isProper(le)) {
    //        return L2LibReg.EFFECT.type().getExisting(le).map(x -> x.map.get(TDEffects.AURORA_GLOWING)).isPresent();
    //    }
    //    return false;
    //}

    public EchoingEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

}