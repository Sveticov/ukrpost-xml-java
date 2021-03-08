package com.svetikov.ukrpostxmljava.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Currency {

    private int r030;
    private String txt;
    private float rate;
    @Id
    private String cc;

}
