package manajemen.buku.services;

import lombok.extern.slf4j.Slf4j;
import manajemen.buku.Requests.StoreKategoriRequest;
import manajemen.buku.Responses.KategoriResponse;
import manajemen.buku.models.Category;
import manajemen.buku.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Slf4j
public class KategoriService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public KategoriResponse store(StoreKategoriRequest request){
//        log.info("Request Service [ {} ]", request);
        Category kategori = new Category();
        kategori.setKategoriKode(UUID.randomUUID().toString());
        kategori.setKategoriNama(request.getKategori_nama());

        categoryRepository.save(kategori);

        return api_response(kategori);
    }

    private KategoriResponse api_response(Category kategori){
        return KategoriResponse.builder()
                .kode_kategori(kategori.getKategoriKode())
                .nama_kategori(kategori.getKategoriNama())
                .createdat_kategori(kategori.getKategoriCreatedAt())
                .build();
    }
}
