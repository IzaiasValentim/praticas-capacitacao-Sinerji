/*
    - Este projeto possui o intuíto de  realizar a construção de uma tabela com informações sobre estudantes
      em HTML orquestrada pelo TypesScript.
    - A lista de estudantes está localizada em 'data.ts' a fim de simular a consulta de uma API externa.
*/
// Import da lista de estudantes
import data from './data.js';
const studantes = JSON.parse(data);
function addRow(table, estudante) {
    // Insere o valor do nome do aluno no campo do nome da tabela.
    let tr = table.querySelector("tbody").insertRow();
    const name = tr.insertCell();
    name.appendChild(document.createTextNode(`${estudante.firstName}  ${estudante.lastName}`));
    // Insere o valor da idade do aluno no campo da idade da tabela.
    const age = tr.insertCell();
    age.appendChild(document.createTextNode((new Date().getFullYear() - parseInt(estudante.birthYear)).toString()));
    /*
        Lógica que insere o valor da área do estudo do estudante que é um dado opicional na interface.
         - Se houver uma ou mais áreas elas serão exibidas em sequência.
         - Caso não haja uma área, será enviado apenas '--'
    */
    const majors = tr.insertCell();
    if (estudante.focusArea) {
        if (typeof estudante.focusArea == "string") {
            majors.appendChild(document.createTextNode(estudante.focusArea));
        }
        else {
            let areas = "";
            estudante.focusArea.forEach(area => {
                areas += area + ", ";
            });
            majors.appendChild(document.createTextNode(areas.slice(0, -2)));
        }
    }
    else {
        majors.appendChild(document.createTextNode("--"));
    }
    /*
       Lógica que insere o status de registro do estudante, também é um valor opicional.
    */
    const status = tr.insertCell();
    if (estudante.dateRegistrationSuspended) {
        status.appendChild(document.createTextNode("Inativo"));
    }
    else {
        status.appendChild(document.createTextNode("Ativo"));
    }
}
// Seleciona a tabela presente em index.html.
function selectTable() {
    return document.querySelector("#students-table");
}
/*
    refreshTable() realiza a atualização dos valores da tabela.
        - Recebece a tabela selecionada em selectTable() e a lista completa de estudantes.
        - A campo da tabela é selecionado em table.querySelector("tbody")
        - O loop forEach itera sob todos os estudantes adicionando uma linha para cada ocorrência
          a partir de addRow(tabela, estudante).
*/
function refreshTable(table, estudantes) {
    table.querySelector("tbody").innerHTML = "";
    estudantes.forEach(estudante => {
        addRow(table, estudante);
    });
}
// Inicia a aplicação ao carregar a página.
window.onload = function () {
    refreshTable(selectTable(), studantes);
};
