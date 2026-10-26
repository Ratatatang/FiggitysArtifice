package com.figgity.figgitysartifice.item.modifier;

import com.figgity.figgitysartifice.item.modifiers.WiltBulletModifier;
import io.redspace.irons_artifice.entity.Bullet;
import io.redspace.irons_artifice.gun.ShotProfile;
import io.redspace.irons_artifice.modifier.OnShotEffect;
import io.redspace.irons_artifice.modifier.modifiers.LeechModifier;
import io.redspace.irons_artifice.utils.Utils;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.HitResult;

public final class WitherCostOnShot implements OnShotEffect {
    private int durationTicks;
    private int amplifier;

    public WitherCostOnShot(int durationTicks, int amplifier) {
        this.durationTicks = durationTicks;
        this.amplifier = amplifier;
    }

    public void addDuration(int ticks) {
        this.durationTicks += ticks;
    }

    public void addAmplifier(int amount) {
        this.amplifier += amount;
    }

    public int getDurationTicks() {
        return durationTicks;
    }

    public int getAmplifier() {
        return amplifier;
    }

    @Override
    public void onShot(ServerLevel level, LivingEntity shooter, ShotProfile profile) {
        MobEffectInstance existing = shooter.getEffect(MobEffects.WITHER);
        int amp = existing != null ? Math.max(existing.getAmplifier(), amplifier) : amplifier;
        shooter.addEffect(new MobEffectInstance(MobEffects.WITHER, durationTicks / 2, Math.max(0, amp)), shooter);
    }
}
