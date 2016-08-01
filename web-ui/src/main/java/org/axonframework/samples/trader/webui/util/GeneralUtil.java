package org.axonframework.samples.trader.webui.util;

import org.axonframework.samples.trader.api.orders.LineItem;
import org.axonframework.samples.trader.query.users.LineItemEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL-PC on 7/4/2016.
 */
public class GeneralUtil {

    public static List<LineItem> convertLineItemEntryList(List<LineItemEntry> lineItemEntryList) {
        List<LineItem> lineItemList = new ArrayList<>();
        for(LineItemEntry lineItemEntry: lineItemEntryList) {
            String productId = lineItemEntry.getProductId();
            int productQuantity = lineItemEntry.getProductQuantity();
            LineItem lineItem = new LineItem(productId, productQuantity);
            lineItemList.add(lineItem);
        }
        return lineItemList;
    }
}
