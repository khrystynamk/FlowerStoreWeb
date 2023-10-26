package com.lab.flowerstore.flower;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Getter;

public enum FlowerColor {
    RED("red"), BLUE("blue"), BLACK("black"), PINK("pink");
    @Getter
    private final String stringRepresentation;

    FlowerColor(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    @Override
    public String toString() {
        return stringRepresentation;
    }

    @JsonValue
    public String getValue() {
        return stringRepresentation;
    }
}
