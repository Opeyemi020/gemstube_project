package io.sulty.gemstube.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@Entity
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String url;
    @OneToOne(fetch = FetchType.EAGER)
    private User uploader;
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    Type type;
    @PrePersist
    public void setCreatedAt(){
        this.createdAt=LocalDateTime.now();
    }
}

