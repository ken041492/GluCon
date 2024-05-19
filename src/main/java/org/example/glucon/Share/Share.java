package org.example.glucon.Share;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Share")
public class Share {

    @Id
    @GeneratedValue
    @Column(name = "id", length = 50)
    private Long id;

    @Column(name = "fid", length = 50)
    @Builder.Default
    private String fid = "";

    @Column(name = "data_type", length = 100)
    private int data_type;

    @Column(name = "relation_type", length = 100)
    private int relation_type;
}
