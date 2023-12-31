package manajemen.buku.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bukus", uniqueConstraints = {@UniqueConstraint(columnNames = "bukuKode")})
public class Buku {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bukuId;

    private String bukuNama;

    private String bukuPenulis;

    @Column(unique = true)
    private String bukuKode;

    private Integer bukuTahunTerbit;

    @ManyToOne
    @JoinColumn(name = "bukuKategoriId", referencedColumnName = "kategoriId")
    private Category bukuKategoriId;

    @Column(columnDefinition = "TINYINT(1)")
    private Boolean bukuStatusPublish;

    private LocalDateTime bukuCreatedAt;

    private LocalDateTime bukuUpdatedAt;

    @PrePersist
    protected void onCreate(){
        this.bukuCreatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.bukuUpdatedAt = LocalDateTime.now();
    }
}
