package com.figgity.figgitysartifice.item.modifiers;

import com.figgity.figgitysartifice.item.modifier.GeyserOnHit;
import com.figgity.figgitysartifice.item.modifier.ShrapnelOnHit;
import com.figgity.figgitysartifice.item.modifier.SmiteDamagePostHit;
import io.redspace.irons_artifice.client.particle.ColorTransitionParticleOption;
import io.redspace.irons_artifice.data.PlayableSound;
import io.redspace.irons_artifice.data.ShotComponentMap;
import io.redspace.irons_artifice.data.ShotComponents;
import io.redspace.irons_artifice.modifier.GunModifier;
import com.figgity.figgitysartifice.item.modifier.WaterDamagePostHit;
import io.redspace.irons_artifice.registry.SoundRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;

import java.util.function.Consumer;

public class GeyserCoreModifier implements GunModifier {
    private static final int MUZZLE_TINT = 0x1F96B1;

    @Override
    public void apply(ShotComponentMap components) {
        //components.getOrCreate(ShotComponents.PIERCING).addModifier(new ValueModifier(1.0, ValueModifier.Operation.ADD, ValueModifier.Type.BENEFICIAL));
        components.getOrCreate(ShotComponents.ON_HIT).add(new GeyserOnHit());
        components.getOrCreate(ShotComponents.POST_HIT_EFFECTS).getOrCreate(WaterDamagePostHit.class, WaterDamagePostHit::new).addStack();

        components.getOrCreate(ShotComponents.IMPACT_SOUND).addEntityAccent(PlayableSound.of(BuiltInRegistries.SOUND_EVENT.wrapAsHolder(SoundEvents.AXOLOTL_SPLASH), 2f, 29.3f, 30.3f));
        components.getOrCreate(ShotComponents.IMPACT_SOUND).addBlockAccent(PlayableSound.of(BuiltInRegistries.SOUND_EVENT.wrapAsHolder(SoundEvents.AXOLOTL_SPLASH), 2f, 29.3f, 30.3f));

        components.getOrCreate(ShotComponents.PARTICLE_TRAIL).add(ColorTransitionParticleOption.bulletTrail(
                GeyserOnHit.TRAIL_COLOR_FROM, GeyserOnHit.TRAIL_COLOR_TO
        ));
        components.getOrCreate(ShotComponents.MUZZLE_FLASH).addTint(MUZZLE_TINT);
    }

    @Override
    public void getDescriptionText(Consumer<Component> builder) {
        builder.accept(Component.translatable("figgitysartifice.modifier.geyser_core_water", 3).withStyle(ChatFormatting.GREEN));
        builder.accept(Component.translatable("figgitysartifice.modifier.geyser_core",
                GeyserOnHit.SHRAPNEL_COUNT,
                (int) (GeyserOnHit.DAMAGE_FRACTION * 100)).withStyle(ChatFormatting.AQUA));
    }
}
