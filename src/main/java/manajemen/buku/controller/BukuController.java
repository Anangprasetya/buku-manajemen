package manajemen.buku.controller;

import lombok.extern.slf4j.Slf4j;
import manajemen.buku.Requests.StoreBukuRequest;
import manajemen.buku.Responses.BukuResponse;
import manajemen.buku.Responses.WebResponse;
import manajemen.buku.services.BukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class BukuController {

    @Autowired
    private BukuService bukuService;

    @PostMapping(
            path = "/api/buku",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<BukuResponse> store(@RequestBody StoreBukuRequest request){
//        log.info("masuk controller store : [ {} ]", request);
        BukuResponse bukuresponse = bukuService.store(request);
//        log.info("berhasil controller store");
        return WebResponse.<BukuResponse>builder().data(bukuresponse).build();
    }

}
