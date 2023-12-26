package manajemen.buku.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gambar_bukus")
public class GambarBuku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long GambarBukuId;

    @ManyToOne
    @JoinColumn(name = "GambarBukuBukuId", referencedColumnName = "BukuId")
    private Buku GambarBukuBukuId;

    private String GambarBukuUrlGambar;

    private LocalDateTime GambarBukuCreatedAt;

    private LocalDateTime GambarBukuUpdatedAt;

    @PrePersist
    protected void onCreate(){
        this.GambarBukuCreatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.GambarBukuUpdatedAt = LocalDateTime.now();
    }
}
