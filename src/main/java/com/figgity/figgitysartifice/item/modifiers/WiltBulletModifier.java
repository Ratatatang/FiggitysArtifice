package com.figgity.figgitysartifice.item.modifiers;

import com.figgity.figgitysartifice.item.modifier.EchoPostHit;
import com.figgity.figgitysartifice.item.modifier.SmiteDamagePostHit;
import com.figgity.figgitysartifice.item.modifier.WitherCostOnShot;
import com.figgity.figgitysartifice.item.modifier.WitherPostHit;
import io.redspace.irons_artifice.data.ShotComponentMap;
import io.redspace.irons_artifice.data.ShotComponents;
import io.redspace.irons_artifice.modifier.GunModifier;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

import java.util.function.Consumer;

public final class WiltBulletModifier implements GunModifier {
    public static final int WITHER_TICKS_PER = 100;
    public static final int WITHER_AMP_PER = 2;

    @Override
    public void apply(ShotComponentMap components) {
        WitherPostHit postHit = components.getOrCreate(ShotComponents.POST_HIT_EFFECTS)
                .getOrCreate(WitherPostHit.class, () -> new WitherPostHit(WITHER_TICKS_PER, -1));
        WitherCostOnShot onShot = components.getOrCreate(ShotComponents.ON_SHOT)
                .getOrCreate(WitherCostOnShot.class, () -> new WitherCostOnShot(WITHER_TICKS_PER, -1));

        postHit.addDuration(WITHER_TICKS_PER);
        postHit.addAmplifier(WITHER_AMP_PER);

        onShot.addDuration(WITHER_TICKS_PER);
        onShot.addAmplifier(WITHER_AMP_PER);
    }

    @Override
    public void getDescriptionText(Consumer<Component> builder) {
        builder.accept(Component.translatable("figgitysartifice.modifier.wilt_bullet_wither", WITHER_TICKS_PER / 20).withStyle(ChatFormatting.GREEN));
        builder.accept(Component.translatable("figgitysartifice.modifier.wilt_bullet_wither_amp", WITHER_AMP_PER).withStyle(ChatFormatting.GREEN));
        builder.accept(Component.translatable("figgitysartifice.modifier.wilt_bullet_wither_self", WITHER_TICKS_PER / 20).withStyle(ChatFormatting.RED));
    }
}
