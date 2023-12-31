package manajemen.buku.services;

import lombok.extern.slf4j.Slf4j;
import manajemen.buku.Requests.StoreBukuRequest;
import manajemen.buku.Responses.BukuResponse;
import manajemen.buku.models.Buku;
import manajemen.buku.models.Category;
import manajemen.buku.repositories.BukuRepository;
import manajemen.buku.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
@Slf4j
public class BukuService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BukuRepository bukuRepository;

    @Transactional
    public BukuResponse store(StoreBukuRequest request) {

//        log.info("masuk service store", request);
//        Category kategori = categoryRepository
//                .findBykategoriId(request.getBukuKategoriId())
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Kategori yang dipilih tidak ditemukan"));
//
//        log.info("service store ambil kategori");
//        Buku bukumodel = new Buku();
//        bukumodel.setBukuNama(request.getBukuNama());
//        bukumodel.setBukuPenulis(request.getBukuPenulis());
//        bukumodel.setBukuKode(UUID.randomUUID().toString());
//        bukumodel.setBukuTahunTerbit(request.getBukuTahunTerbit());
//        bukumodel.setBukuKategoriId(kategori);
//        bukumodel.setBukuStatusPublish(false);
//
//        bukuRepository.save(bukumodel);

//        return api_response(bukumodel);

        return api_response(new Buku());
    }

    private BukuResponse api_response(Buku buku){
        return BukuResponse.builder()
                .BukuNama(buku.getBukuNama())
                .BukuPenulis(buku.getBukuPenulis())
                .BukuKode(buku.getBukuKode())
                .BukuTahunTerbit(buku.getBukuTahunTerbit())
                .BukuStatusPublish(buku.getBukuStatusPublish())
                .BukuCreatedAt(buku.getBukuCreatedAt())
                .build();
    }
}
