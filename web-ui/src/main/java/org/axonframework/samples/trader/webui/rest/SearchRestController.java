package org.axonframework.samples.trader.webui.rest;

import com.fasterxml.jackson.annotation.JsonView;
import org.axonframework.samples.trader.query.JsonViews;
import org.axonframework.samples.trader.query.product.ProductEntry;
import org.axonframework.samples.trader.webui.services.StoreCommandService;
import org.axonframework.samples.trader.webui.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/search")
public class SearchRestController {

    @Autowired
    StoreService storeService;
    @Autowired
    StoreCommandService storeCommandService;

    @RequestMapping(value = "/{queryString}", method = RequestMethod.GET)
    @JsonView(JsonViews.Public.class)
    public List<ProductEntry> getProducts(@PathVariable("queryString")String queryString) {
        return storeService.searchProducts(queryString);
    }
}