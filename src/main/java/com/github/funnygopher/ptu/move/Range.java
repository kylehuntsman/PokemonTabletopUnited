package com.github.funnygopher.ptu.move;

public class Range {

    private Ranges ranges;
    private int x;

    public Range(Ranges ranges, int x) {
        this.ranges = ranges;
        this.x = x;
    }

    public enum Ranges {
        BURST, CARDINALLY, CLOSE_BLAST, CONE, MELEE;
    }
}
