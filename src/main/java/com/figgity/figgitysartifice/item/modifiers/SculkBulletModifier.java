package com.figgity.figgitysartifice.item.modifiers;

import com.figgity.figgitysartifice.item.modifier.EchoPostHit;
import io.redspace.irons_artifice.data.ShotComponentMap;
import io.redspace.irons_artifice.data.ShotComponents;
import io.redspace.irons_artifice.data.ValueModifier;
import io.redspace.irons_artifice.modifier.GunModifier;
import io.redspace.irons_artifice.modifier.ValueStackModifier;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

import java.util.Map;
import java.util.function.Consumer;

public final class SculkBulletModifier implements GunModifier {
    public static final int ECHO_TICKS_PER = 100;
    public static final double RECOIL_MOD = 0.20;
    public static final double DAMAGE_MOD = 0.15;

    @Override
    public void apply(ShotComponentMap components) {
        components.modifyValue(ShotComponents.CAMERA_RECOIL_MULTIPLIER, new ValueModifier(RECOIL_MOD, ValueModifier.Operation.MULTIPLY_TOTAL, ValueModifier.Type.BENEFICIAL));
        components.modifyValue(ShotComponents.DAMAGE, new ValueModifier(DAMAGE_MOD, ValueModifier.Operation.MULTIPLY_TOTAL, ValueModifier.Type.BENEFICIAL));

        EchoPostHit postHit = components.getOrCreate(ShotComponents.POST_HIT_EFFECTS)
                .getOrCreate(EchoPostHit.class, () -> new EchoPostHit(ECHO_TICKS_PER, -1));
        postHit.addDuration(ECHO_TICKS_PER);
        postHit.addAmplifier(1);

        components.getOrCreate(ShotComponents.MUZZLE_FLASH).addTint(0x0E4C5C);
    }

    @Override
    public void getDescriptionText(Consumer<Component> builder) {
        builder.accept(Component.translatable("figgitysartifice.modifier.sculk_bullet", ECHO_TICKS_PER / 20).withStyle(ChatFormatting.GREEN));
        builder.accept(Component.translatable("figgitysartifice.modifier.sculk_bullet_damage", DAMAGE_MOD).withStyle(ChatFormatting.GREEN));
        builder.accept(Component.translatable("figgitysartifice.modifier.sculk_bullet_recoil", RECOIL_MOD).withStyle(ChatFormatting.RED));
    }
}
