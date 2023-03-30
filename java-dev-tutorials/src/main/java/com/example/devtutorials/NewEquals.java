package com.example.devtutorials;

public class NewEquals {
    private final String value;

    public NewEquals(String value) {
        this.value = value;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (obj == this) return true;
//        return obj instanceof NewEquals newEquals &&
//                newEquals.value.equalsIgnoreCase(value);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NewEquals newEquals)) return false;

        return value.equalsIgnoreCase(newEquals.value);
    }

}

record NewEqualsSimplified(String value) {
}
