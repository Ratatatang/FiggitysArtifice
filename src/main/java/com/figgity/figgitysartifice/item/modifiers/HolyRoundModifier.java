package com.figgity.figgitysartifice.item.modifiers;

import com.figgity.figgitysartifice.item.modifier.EchoPostHit;
import com.figgity.figgitysartifice.item.modifier.SmiteDamagePostHit;
import io.redspace.irons_artifice.client.particle.ColorTransitionParticleOption;
import io.redspace.irons_artifice.data.PlayableSound;
import io.redspace.irons_artifice.data.ShotComponentMap;
import io.redspace.irons_artifice.data.ShotComponents;
import io.redspace.irons_artifice.data.ValueModifier;
import io.redspace.irons_artifice.modifier.GunModifier;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;

import java.util.function.Consumer;

public final class HolyRoundModifier implements GunModifier {

    @Override
    public void apply(ShotComponentMap components) {
        components.getOrCreate(ShotComponents.POST_HIT_EFFECTS).getOrCreate(SmiteDamagePostHit.class, SmiteDamagePostHit::new).addStack();
    }

    @Override
    public void getDescriptionText(Consumer<Component> builder) {
        builder.accept(Component.translatable("figgitysartifice.modifier.holy_round_smite", (SmiteDamagePostHit.DAMAGE)).withStyle(ChatFormatting.GREEN));
        builder.accept(Component.translatable("figgitysartifice.modifier.holy_round_illager", (SmiteDamagePostHit.DAMAGE)).withStyle(ChatFormatting.GREEN));
    }
}
