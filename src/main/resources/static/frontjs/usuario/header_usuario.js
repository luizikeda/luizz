$(document).ready(function () {
    $.ajax({
        url: "/home/infousuario",
        type: "GET",
        data: {},
        async: false,
        success: function (data) {
            $('#nomeUsuarioHeader').text(data.nome);
            $('#minhaConta').attr("href", "/usuarios/" + data.id);
            $('#nomeUsuarioHeader2').text(data.nome);
            $('#abreviacaoNomeHeader').text((data.nome).substring(0,1))
            $('#emailUsuarioHeader').text(data.email);
            $('#clienteUsuarioHeader').text("Cliente: " + data.cliente);
        },
        error: function (data) {
            console.log("Erro ao recuperar usuário")
        }
    });
});