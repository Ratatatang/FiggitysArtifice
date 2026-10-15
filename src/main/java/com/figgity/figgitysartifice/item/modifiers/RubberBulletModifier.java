package com.figgity.figgitysartifice.item.modifiers;

import io.redspace.irons_artifice.data.PlayableSound;
import io.redspace.irons_artifice.data.ShotComponentMap;
import io.redspace.irons_artifice.data.ShotComponents;
import io.redspace.irons_artifice.data.ValueModifier;
import io.redspace.irons_artifice.modifier.ValueStackModifier;
import io.redspace.irons_artifice.registry.SoundRegistry;

import java.util.Map;

public class RubberBulletModifier extends ValueStackModifier {
    public RubberBulletModifier() {
        super(Map.of(
                ShotComponents.RICOCHET, new ValueModifier(9, ValueModifier.Operation.ADD, ValueModifier.Type.BENEFICIAL),
                ShotComponents.DAMAGE, new ValueModifier(-0.5, ValueModifier.Operation.MULTIPLY_TOTAL, ValueModifier.Type.BENEFICIAL)
        ));
    }

    @Override
    public void apply(ShotComponentMap components) {
        super.apply(components);
        components.getOrCreate(ShotComponents.IMPACT_SOUND).addBlockAccent(PlayableSound.of(SoundRegistry.BULLET_IMPACT_RICOCHET, 0.3f, 29.3f, 30.3f));
    }
}
