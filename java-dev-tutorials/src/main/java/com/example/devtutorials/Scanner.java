package com.example.devtutorials;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Collectors;

public final class Scanner {
    public static void main(final String[] args) {
        final var wordsAndNumber = """
                Longing rusted furnace
                daybreak 17 benign
                9 homecoming 1
                freight car
                """;
        try (final var scanner = new java.util.Scanner(wordsAndNumber)) {
            System.out.println(
                    scanner.findAll("d")
                            .map(matchResult -> new Pair<>(matchResult.group(), matchResult.start()))
                            .collect(Collectors.toList())
            );
        }
    }

    record Pair<T, K>(T value, K index) {
        @Contract(pure = true)
        @Override
        public @NotNull String toString() {
            return "{" +
                    "value: " + value +
                    ", index: " + index +
                    '}';
        }
    }
}
