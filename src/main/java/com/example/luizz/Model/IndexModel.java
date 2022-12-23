package com.example.luizz.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "index")
public class IndexModel {

    @Id
    @Column(name = "id")
    private Long Id;

    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    @Column(name = "dtcriacao")
    private Date dtcricao;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Date getDtcricao() {
        return dtcricao;
    }

    public void setDtcricao(Date dtcricao) {
        this.dtcricao = dtcricao;
    }
}
