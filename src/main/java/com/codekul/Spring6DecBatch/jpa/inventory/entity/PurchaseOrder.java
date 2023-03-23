//package com.codekul.Spring6DecBatch.jpa.inventory.entity;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.OneToMany;
//import org.springframework.data.annotation.Id;
//
//import java.time.LocalDate;
//import java.util.List;
//
////@Table
//@Entity
//public class PurchaseOrder {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    //ref of company
//    private String poNumber;
//    private LocalDate poDate;
//    //ref of vendor id
//    private Double subTotal;
//    private Double amount;
//    private Double freight;
//    private Double tax;
//    private Double orderTotal;
//    @OneToMany
//    private List<PurchaseOrderDetails> purchaseOrderDetails;
//}
