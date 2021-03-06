package max_sk.MyWork.endpoints;

import lombok.RequiredArgsConstructor;
import max_sk.MyWork.services.TovarService;
import max_sk.MyWork.soap.tovars.GetAllTovarsRequest;
import max_sk.MyWork.soap.tovars.GetAllTovarsResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class TovarEndpoint {

    private static final String NAMESPACE_URI = "http://www.max_sk.com/spring/ws/tovars";
    private final TovarService tovarService;

//  Мой Запрос  http://localhost:8080/app/ws

//            <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:f="http://www.max_sk.com/spring/ws/tovars">
//            <soapenv:Header/>
//            <soapenv:Body>
//                <f:getAllTovarsRequest/>
//            </soapenv:Body>
//        </soapenv:Envelope>

//    Полученный Ответ
//
//            <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
//    <SOAP-ENV:Header/>
//    <SOAP-ENV:Body>
//        <ns2:getAllTovarsResponse xmlns:ns2="http://www.max_sk.com/spring/ws/tovars">
//            <ns2:tovars>
//                <ns2:id>1</ns2:id>
//                <ns2:name>Makaron</ns2:name>
//                <ns2:cost>0</ns2:cost>
//            </ns2:tovars>
//            <ns2:tovars>
//                <ns2:id>2</ns2:id>
//                <ns2:name>Vermishel</ns2:name>
//                <ns2:cost>0</ns2:cost>
//            </ns2:tovars>
//        </ns2:getAllTovarsResponse>
//    </SOAP-ENV:Body>
//</SOAP-ENV:Envelope>

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllTovarsRequest")
    @ResponsePayload
    public GetAllTovarsResponse getAllTovars(@RequestPayload GetAllTovarsRequest request) {
        GetAllTovarsResponse response = new GetAllTovarsResponse();
        tovarService.getAllTovar().forEach(response.getTovars()::add);
        return response;
    }
}
