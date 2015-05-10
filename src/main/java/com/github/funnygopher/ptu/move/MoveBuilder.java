package com.github.funnygopher.ptu.move;

import com.github.funnygopher.ptu.move.MoveClass;
import com.github.funnygopher.ptu.move.contest.ContestEffect;
import com.github.funnygopher.ptu.move.contest.ContestStat;
import com.github.funnygopher.ptu.pokemon.species.Type;

public class MoveBuilder {

    private String name;
    private Type type;
    private String frequency;
    private int accuracyCheck;
    private int damageBase;
    private MoveClass moveClass;
    private String range;
    private String effect;
    private ContestStat contestStat;
    private ContestEffect contestEffect;
    private String special;

    public boolean bName, bType, bFrequency, bAccCheck, bDamageBase, bMoveClass, bRange, bEffect, bConStat, bConEffect, bSpecial;

    public MoveBuilder() {
        damageBase = -1;
        special = "";
    }

    public MoveBuilder name(String name) {
        if(!bName) {
            this.name = name;
            bName = true;
        }
        return this;
    }

    public MoveBuilder type(Type type) {
        if(!bType) {
            this.type = type;
            bType = true;
        }
        return this;
    }

    public MoveBuilder frequency(String frequency) {
        if(!bFrequency) {
            this.frequency = frequency;
            bFrequency = true;
        }
        return this;
    }

    public MoveBuilder accuracyCheck(int accuracyCheck) {
        if(!bAccCheck) {
            this.accuracyCheck = accuracyCheck;
            bAccCheck = true;
        }
        return this;
    }

    public MoveBuilder damageBase(int damageBase) {
        if(!bDamageBase) {
            this.damageBase = damageBase;
            bDamageBase = true;
        }
        return this;
    }

    public MoveBuilder range(String range) {
        if(!bRange) {
            this.range = range;
            bRange = true;
        }
        return this;
    }

    public MoveBuilder moveClass(MoveClass moveClass) {
        if(!bMoveClass) {
            this.moveClass = moveClass;
            bMoveClass = true;
        }
        return this;
    }

    public MoveBuilder effect(String effect) {
        if(!bEffect) {
            this.effect = effect;
            bEffect = true;
        }
        return this;
    }

    public MoveBuilder contestStat(ContestStat contestStat) {
        if(!bConStat) {
            this.contestStat = contestStat;
            bConStat = true;
        }
        return this;
    }

    public MoveBuilder contestEffect(ContestEffect contestEffect) {
        if(!bConEffect) {
            this.contestEffect = contestEffect;
            bConEffect = true;
        }
        return this;
    }

    public MoveBuilder special(String special) {
        if(!bSpecial) {
            this.special = special;
            bSpecial = true;
        }
        return this;
    }

    public Move build() {
        return new Move(
                name, type, frequency, accuracyCheck, damageBase, moveClass, range, effect, contestStat, contestEffect, special
        );
    }
}
