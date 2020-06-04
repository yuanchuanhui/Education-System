package org.thealphalab.education.entity;

import lombok.Data;

@Data
public class Pair<K, V> {
    private K first;
    private V second;
}
