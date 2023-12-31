package manajemen.buku.Responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KategoriResponse {
    private String kode_kategori;

    private String nama_kategori;

    private LocalDateTime createdat_kategori;
}
