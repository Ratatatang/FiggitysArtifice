package com.figgity.figgitysartifice.item.modifiers;

import io.redspace.irons_artifice.data.PlayableSound;
import io.redspace.irons_artifice.data.ShotComponentMap;
import io.redspace.irons_artifice.data.ShotComponents;
import io.redspace.irons_artifice.data.ValueModifier;
import io.redspace.irons_artifice.modifier.ValueStackModifier;
import io.redspace.irons_artifice.registry.SoundRegistry;

import java.util.Map;

public class HighVelocityBulletModifier extends ValueStackModifier {
    public HighVelocityBulletModifier() {
        super(Map.of(
                ShotComponents.SPREAD, new ValueModifier(-1, ValueModifier.Operation.ADD, ValueModifier.Type.HARMFUL),
                ShotComponents.BULLET_SPEED, new ValueModifier(0.3, ValueModifier.Operation.ADD, ValueModifier.Type.NEUTRAL)
        ));
    }
}
