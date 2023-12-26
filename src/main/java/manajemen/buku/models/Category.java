package manajemen.buku.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "kategoris", uniqueConstraints = {@UniqueConstraint(columnNames = "KategoriKode")})
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long KategoriId;

    @Column(unique = true)
    private String KategoriKode;

    private String KategoriNama;

    private LocalDateTime KategoriCreatedAt;

    private LocalDateTime KategoriUpdatedAt;

    @PrePersist
    protected void onCreate(){
        this.KategoriCreatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.KategoriUpdatedAt = LocalDateTime.now();
    }

}
