package manajemen.buku.controller;

import lombok.extern.slf4j.Slf4j;
import manajemen.buku.Requests.StoreKategoriRequest;
import manajemen.buku.Requests.UpdateKategoriRequest;
import manajemen.buku.Responses.KategoriResponse;
import manajemen.buku.Responses.WebResponse;
import manajemen.buku.services.KategoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(
            path = "/api/kategori",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<List<KategoriResponse>> get(){
        List<KategoriResponse> res = kategoriService.getAll();
        return WebResponse.<List<KategoriResponse>>builder().data(res).build();
    }

    @PutMapping(
            path = "/api/kategori",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<KategoriResponse> update(@RequestBody UpdateKategoriRequest request) {
        KategoriResponse res = kategoriService.update(request);
        return WebResponse.<KategoriResponse>builder().data(res).build();
    }

    @DeleteMapping(
            path = "/api/kategori",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<KategoriResponse> delete(@RequestBody)
}
