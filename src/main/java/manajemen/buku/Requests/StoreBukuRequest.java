package manajemen.buku.Requests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import manajemen.buku.models.Category;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreBukuRequest {
    @Size(max = 200)
    @NotBlank
    private String bukuNama;

    @Size(max = 200)
    private String bukuPenulis;

    private Integer bukuTahunTerbit;

//    @JsonIgnore
    @NotBlank
    private Long bukuKategoriId;
}
