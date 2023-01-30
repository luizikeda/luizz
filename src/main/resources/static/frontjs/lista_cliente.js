function limpar(){
    window.location.reload();
}

function filtrar() {
    let data = {
        cpf: $('#cpf').val(),
        email: $('#email').val(),
    }

    console.log(data.cpf)

    $('#tabelaClientes').DataTable().destroy();
    $('#tabelaClientes').DataTable()({
        dom: 'r<"tabela-header"<l><"tabela-header"fB>>tip',
        buttons: [{'extend': 'print', 'text': 'Imprimir Dados', 'className': 'btn btn-default'}],
    ajax: {
            url: '/cliente/filtrar',
            type: 'GET',
            async: true,
            dataSrc: '',
            data: data
    },
        columns: [
            {data: 'cep'},
            {data: 'cpf'},
            {data: 'email'},
            {data: 'estado'},
            {data: 'telefone'},
            {data: 'data_nascimento'},
        ],
        language: {
            "sEmptyTable": "Nenhum registro encontrado",
            "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
            "sInfoEmpty": "Mostrando 0 até 0 de 0 registros",
            "sInfoFiltered": "(Filtrados de _MAX_ registros)",
            "sInfoPostFix": "",
            "sInfoThousands": ".",
            "sLengthMenu": "_MENU_ resultados por página",
            "sLoadingRecords": "Carregando...",
            "sProcessing": "Processando...",
            "sZeroRecords": "Nenhum registro encontrado",
            "sSearch": "Pesquisar: ",
            "oPaginate": {
                "sNext": "Próximo",
                "sPrevious": "Anterior",
                "sFirst": "Primeiro",
                "sLast": "Último"
            },
            "oAria": {
                "sSortAscending": ": Ordenar colunas de forma ascendente",
                "sSortDescending": ": Ordenar colunas de forma descendente"
            }
        }
    })
}