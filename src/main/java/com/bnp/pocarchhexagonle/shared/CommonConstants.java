package com.bnp.pocarchhexagonle.shared;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CommonConstants {
    public static final String CUSTOMER_API="/customer-api";
    public static final String ORDER_API="/order-api";
    public static final String CUSTOMERS="/customers";
    public static final String ORDERS="/orders";
    public static final String PARAM_ID="/{id}";
    public static final String SAVE="/save";
    public static final String UPDATE="/update";
    public static final String DELETE="/delete";
    public static final String CUSTOMER_ID_PARAM="/{idCustomer}";

}
