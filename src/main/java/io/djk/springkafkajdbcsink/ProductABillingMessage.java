package io.djk.springkafkajdbcsink;

public class ProductABillingMessage {
    private String client;
    private String orderId;
    private String product;
    private Float amount;


    public ProductABillingMessage() {
    }

    public ProductABillingMessage(String client, String orderId, String product, Float amount) {
        this.client = client;
        this.orderId = orderId;
        this.product = product;
        this.amount = amount;
    }



    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }


}
