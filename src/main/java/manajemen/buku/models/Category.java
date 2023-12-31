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
@Table(name = "kategoris", uniqueConstraints = {@UniqueConstraint(columnNames = "kategoriKode")})
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "kategoriId")
    private Long kategoriId;

    @Column(unique = true, name = "kategoriKode")
    private String kategoriKode;

    private String kategoriNama;

    private LocalDateTime kategoriCreatedAt;

    private LocalDateTime kategoriUpdatedAt;

    @PrePersist
    protected void onCreate(){
        this.kategoriCreatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.kategoriUpdatedAt = LocalDateTime.now();
    }

}
