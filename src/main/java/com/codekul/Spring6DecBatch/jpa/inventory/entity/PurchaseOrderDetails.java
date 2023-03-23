//package com.codekul.Spring6DecBatch.jpa.inventory.entity;
//
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import org.springframework.data.annotation.Id;
//
//public class PurchaseOrderDetails {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//
//
//    // ref item
//   private Integer quantity;
//   private Double unitPrice;
//   private Double amount;
//   @ManyToOne
//   @JoinColumn(name = "purchase_order_id")
//   private PurchaseOrder purchaseOrder;
//    //ref @
//    poId
//}
