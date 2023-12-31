package manajemen.buku.controller;

import lombok.extern.slf4j.Slf4j;
import manajemen.buku.Requests.StoreKategoriRequest;
import manajemen.buku.Responses.KategoriResponse;
import manajemen.buku.Responses.WebResponse;
import manajemen.buku.services.KategoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CategoryController {

    @Autowired
    private KategoriService kategoriService;
    @PostMapping(
            path = "/api/kategori",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<KategoriResponse> store(@RequestBody StoreKategoriRequest request){
        log.info("masuk store kategori : {}", request);
        KategoriResponse res = kategoriService.store(request);
        log.info("masuk store kategori setelah store service : {}", request);
        return WebResponse.<KategoriResponse>builder().data(res).build();
    }
}
