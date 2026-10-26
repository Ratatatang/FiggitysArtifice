package com.figgity.figgitysartifice.item.modifiers;

import com.figgity.figgitysartifice.item.modifier.EchoPostHit;
import io.redspace.irons_artifice.client.particle.ColorTransitionParticleOption;
import io.redspace.irons_artifice.data.*;
import io.redspace.irons_artifice.modifier.GunModifier;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;

import java.util.function.Consumer;

public final class SculkBulletModifier implements GunModifier {
    public static final int ECHO_TICKS_PER = 100;
    public static final double RECOIL_MOD = 0.20;
    public static final double DAMAGE_MOD = 0.15;

    private static final int MUZZLE_TINT = 0x29DEEA;
    public static final int TRAIL_COLOR_FROM = 0x29DEEA;
    public static final int TRAIL_COLOR_TO = 0x138D98;

    @Override
    public void apply(ShotComponentMap components) {
        components.modifyValue(ShotComponents.CAMERA_RECOIL_MULTIPLIER, new ValueModifier(RECOIL_MOD, ValueModifier.Operation.MULTIPLY_TOTAL, ValueModifier.Type.BENEFICIAL));
        components.modifyValue(ShotComponents.DAMAGE, new ValueModifier(DAMAGE_MOD, ValueModifier.Operation.MULTIPLY_TOTAL, ValueModifier.Type.BENEFICIAL));

        EchoPostHit postHit = components.getOrCreate(ShotComponents.POST_HIT_EFFECTS)
                .getOrCreate(EchoPostHit.class, () -> new EchoPostHit(ECHO_TICKS_PER, -1));
        postHit.addDuration(ECHO_TICKS_PER);
        postHit.addAmplifier(1);

        components.getOrCreate(ShotComponents.GUNSHOT_SOUND).addAccent(PlayableSound.of(BuiltInRegistries.SOUND_EVENT.wrapAsHolder(SoundEvents.WARDEN_SONIC_BOOM), 0.7f, 29.3f, 30.3f));

        components.getOrCreate(ShotComponents.MUZZLE_FLASH).addTint(MUZZLE_TINT);

        components.getOrCreate(ShotComponents.PARTICLE_TRAIL).add(ColorTransitionParticleOption.bulletTrail(
                TRAIL_COLOR_FROM, TRAIL_COLOR_TO
        ));
        components.getOrCreate(ShotComponents.MUZZLE_FLASH).addTint(MUZZLE_TINT);
    }

    @Override
    public void getDescriptionText(Consumer<Component> builder) {
        builder.accept(Component.translatable("figgitysartifice.modifier.sculk_bullet", ECHO_TICKS_PER / 20).withStyle(ChatFormatting.GREEN));
        builder.accept(Component.translatable("figgitysartifice.modifier.sculk_bullet_damage",  (int) (DAMAGE_MOD * 100)).withStyle(ChatFormatting.GREEN));
        builder.accept(Component.translatable("figgitysartifice.modifier.sculk_bullet_recoil",  (int) (RECOIL_MOD * 100)).withStyle(ChatFormatting.RED));
    }
}
