package manajemen.buku.Requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateKategoriRequest {
    @NotBlank
    @Size(max = 200)
    private String kategori_nama;

    @NotBlank
    private String kategori_kode;
}
