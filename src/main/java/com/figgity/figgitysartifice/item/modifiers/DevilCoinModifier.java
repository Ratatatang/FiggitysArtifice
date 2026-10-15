package com.figgity.figgitysartifice.item.modifiers;

import io.redspace.irons_artifice.IronsArtifice;
import io.redspace.irons_artifice.api.GunBones;
import io.redspace.irons_artifice.data.PlayableSound;
import io.redspace.irons_artifice.data.ShotComponentMap;
import io.redspace.irons_artifice.data.ShotComponents;
import io.redspace.irons_artifice.data.ValueModifier;
import io.redspace.irons_artifice.item.AttachmentMap;
import io.redspace.irons_artifice.modifier.ValueStackModifier;
import io.redspace.irons_artifice.registry.DataComponentRegistry;
import io.redspace.irons_artifice.registry.SoundRegistry;
import io.redspace.ironslib.kinetic_weapon.KineticWeapon;
import io.redspace.ironslib.registry.IronsLibRegistries;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponents;
import net.minecraft.util.Unit;

import java.util.Map;
import java.util.Optional;

public class DevilCoinModifier extends ValueStackModifier {
    public DevilCoinModifier() {
        super(Map.of(
                ShotComponents.RICOCHET, new ValueModifier(1, ValueModifier.Operation.ADD, ValueModifier.Type.BENEFICIAL)
        ));
    }

    @Override
    public void apply(ShotComponentMap components) {
        super.apply(components);
        components.getOrCreate(ShotComponents.IMPACT_SOUND).addBlockAccent(PlayableSound.of(SoundRegistry.BULLET_IMPACT_RICOCHET, 2f, .7f, 1.3f));
    }

}
