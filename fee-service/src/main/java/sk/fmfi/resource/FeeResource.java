package sk.fmfi.resource;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sk.fmfi.model.Fee;
import sk.fmfi.resource.dto.TransactionDTO;
import sk.fmfi.service.FeeService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import java.util.List;

// pridajte REST anotáciu @Path ktorá vystavuje resource na ceste "fee"
@Path("/fee")
public class FeeResource {

    private final FeeService service;

    @Inject
    public FeeResource(FeeService service) {
        this.service = service;
    }

    // pridajte anotáciu @Produces so správnym typom MediaType pre vrátenie dát vo formáte JSON
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("user")
    public Response getFees(@QueryParam("iban") String iban) {
        // implementujte načítanie poplatkov pomocou service
        //    - v prípade že iban je prázdny vráťte všetky poplatky
        //    - v prípade že iban nie je prázdny vráťte len tie poplatky, ktoré sa viažu na daný iban
        List<Fee> fees = (iban == null || iban.isBlank()) ?
            service.getAllFees() :
            service.getFeesForIban(iban);

        return Response.ok(fees).build();
    }

    // pridajte anotáciu @Consumes so správnym typom MediaType pre spracovanie dát vo formáte JSON
    // pridajte anotáciu @Produces so správnym typom MediaType pre vrátenie dát vo formáte JSON
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    public Response createFee(TransactionDTO transactionDTO) {
        // implementujte vytvorenie poplatku pomocou service
        service.createFee(transactionDTO.getTransactionId(), transactionDTO.getIban(), transactionDTO.getAmount());
        return Response.ok().build();
    }
}
