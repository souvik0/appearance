package com.amex;

import java.util.Arrays;
public class EffectiveHashCode {

    String name;
    long id;
    int age;
    float weight;
    boolean isMember;
    double credits;
    String[] interests;

    public EffectiveHashCode(String name, long id, int age, float weight, boolean isMember,
                             double credits, String[] interests) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.weight = weight;
        this.isMember = isMember;
        this.credits = credits;
        this.interests = interests;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 17;

        result = prime * result + this.name == null ? 0 : name.hashCode();
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + age;
        result = prime * result + Float.floatToIntBits(weight); // Float can be converted to ints only
        result = prime * result + (isMember ? 1 : 0);
        long creditsLong = Double.doubleToLongBits(credits); // Double can only converted to Long
        result = prime * result + (int) (creditsLong ^ (creditsLong >>> 32));
        result = prime * result + Arrays.hashCode(interests);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof EffectiveHashCode)) {
            return false;
        }

        EffectiveHashCode effective = (EffectiveHashCode) obj;
        return this.id == effective.id &&
               this.name.equals(effective.name) &&
               this.age == effective.age &&
               this.weight == effective.weight &&
               this.isMember == effective.isMember &&
               this.credits == effective.credits &&
               Arrays.equals(this.interests, effective.interests);
    }
}
