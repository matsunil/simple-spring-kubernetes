package edu.vyurik.spring.kubernetes.simpleserver.controller;

import edu.vyurik.spring.kubernetes.simpleserver.model.SimpleDeal;
import edu.vyurik.spring.kubernetes.simpleserver.repository.SimpleDealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Random;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class SimpleServerController {

    @Autowired
    private SimpleDealRepository simpleDealRepository;

    private static final Log log = LogFactory.getLog(SimpleServerController.class);

    @RequestMapping(method = GET, path = "/deals")
    public String deals() {
        log.info("Client is requesting new deals!");

        List<SimpleDeal> simpleDealList = simpleDealRepository.findAll();
        if (!simpleDealList.isEmpty()) {
            int randomDeal = new Random().nextInt(simpleDealList.size());
            return simpleDealList.get(randomDeal)
                .toString();
        } else {
            return "NO DEALS";
        }
    }

    @RequestMapping(method = GET, path = "/")
    @ResponseBody
    public String get() throws UnknownHostException {

        StringBuilder stringBuilder = new StringBuilder();
        //vitaly
        log.info("hostname = " + InetAddress.getLocalHost().getHostName());
        log.info("canonical hostname = " + InetAddress.getLocalHost().getCanonicalHostName());
        stringBuilder.append("The simple server hostname is ")
            .append(InetAddress.getLocalHost()
                .getHostName())
            .append("<br/>");
        return stringBuilder.toString();
    }
}
