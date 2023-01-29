package com.example.ikeda.Model;

public enum Estados {

    ACRE(1,"Acre"),
    ALAGOAS(2,"Alagoas"),
    AMAPA(3,"Amapá"),
    AMAZONAS(4,"Amazonas"),
    BAHIA(5,"Bahia"),
    CEARA(6,"Ceará"),
    DISTRITOFEDERAL(7,"Distrito Federal"),
    ESPIRITOSANTO(8,"Espírito Santo"),
    GOIAS(9,"Goiás"),
    MARANHAO(10,"Maranhão"),
    MATOGROSSO(11,"Mato Grosso"),
    MATOGROSSODOSUL(12,"Mato Grosso do Sul"),
    MINASGERAIS(13,"Minas Gerais"),
    PARA(14,"Pará"),
    PARAIBA(15,"Paraíba"),
    PARANA(16,"Paraná"),
    PERNAMBUCO(17,"Pernambuco"),
    PIAUI(18,"Piauí"),
    RIODEJANEIRO(19,"Rio de Janeiro"),
    RIOGRANDEDONORTE(20,"Rio Grande do Norte"),
    RIOGRANDEDOSUL(21,"Rio Grande do Sul"),
    RONDONIA(22,"Rondônia"),
    RORAIMA(23,"Roraima"),
    SANTACATARINA(24,"Santa Catarina"),
    SAOPAULO(25,"São Paulo"),
    SERGIPE(26,"Sergipe"),
    TOCANTINS(27,"Tocantins");

    private final Integer id;
    private final String descricao;

    Estados(Integer id,String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
}
