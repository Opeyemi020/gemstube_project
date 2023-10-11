package io.sulty.gemstube.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Sender {
    private final String name;
    private final String email;

    public Sender(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
