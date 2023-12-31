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
public class BukuResponse {

    private String BukuNama;

    private String BukuPenulis;

    private String BukuKode;

    private Integer BukuTahunTerbit;

    private Boolean BukuStatusPublish;

    private LocalDateTime BukuCreatedAt;

}
