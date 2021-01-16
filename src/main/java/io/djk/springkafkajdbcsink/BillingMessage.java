package io.djk.springkafkajdbcsink;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillingMessage {
    private String client;
    private String orderId;
    private String product;
    private BigDecimal amount;
}
