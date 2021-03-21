package com.bank.dto;

import com.bank.model.Currency;
import lombok.*;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {

    private String id;
    private String customerId;
    private Double balance;
    private Currency currency;
}
