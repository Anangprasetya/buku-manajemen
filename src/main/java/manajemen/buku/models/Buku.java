package manajemen.buku.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bukus", uniqueConstraints = {@UniqueConstraint(columnNames = "BukuKode")})
public class Buku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long BukuId;

    private String BukuNama;

    private String BukuPenulis;

    @Column(unique = true)
    private String BukuKode;

    private Integer BukuTahunTerbit;

    @ManyToOne
    @JoinColumn(name = "BukuKategoriId", referencedColumnName = "KategoriId")
    private Category BukuKategoriId;

    @Column(columnDefinition = "TINYINT(1)")
    private Boolean BukuStatusPublish;

    private LocalDateTime BukuCreatedAt;

    private LocalDateTime BukuUpdatedAt;

    @PrePersist
    protected void onCreate(){
        this.BukuCreatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.BukuUpdatedAt = LocalDateTime.now();
    }
}
