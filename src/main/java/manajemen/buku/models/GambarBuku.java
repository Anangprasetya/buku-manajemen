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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gambarbukuId;

    @ManyToOne
    @JoinColumn(name = "gambarbukuBukuId", referencedColumnName = "bukuId")
    private Buku gambarbukuBukuId;

    private String gambarbukuUrlGambar;

    private LocalDateTime gambarbukuCreatedAt;

    private LocalDateTime gambarbukuUpdatedAt;

    @PrePersist
    protected void onCreate(){
        this.gambarbukuCreatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.gambarbukuUpdatedAt = LocalDateTime.now();
    }
}
