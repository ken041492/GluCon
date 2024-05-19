package org.example.glucon.DrugInfo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DrugInfo")
public class DrugInfo {

    @Id
    @GeneratedValue
    @Column(name = "id", length = 50)
    private String id;

    @Column(name = "drugname", length = 100)
    private String drugName;

    @Column(name = "drug_type")
    private boolean drugType;

    @Column(name = "recorded_at")
    private LocalDateTime recordedAt;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
