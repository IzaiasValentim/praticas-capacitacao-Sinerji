/*
    Type annotation: let student : string  = "John";
    Type annotations não são necessárias quando o Typescript puder fazer a inferência do tipo
*/
let student = "John";
let grade1 = 6;
let grade2 = 8;
// Type annotation para isApproved pois não tem um valor inicial.
let isApproved;
/*
    Type annotation em argumentos de uma função
   A função average recebe dois numeros e retorna sua média.
*/
function average(num1, num2) {
    return (num1 + num2) / 2;
}
// Arrays
// O Typescript infere o tipo neste caso como um array de strings (string[])
let grades = ["8", "7", "9", "5", "6"];
// Declarar explicitamente o tipo do argumento como um array de strings
function finalGrade(grades) {
    let sum = 0;
    grades.forEach(grade => sum += parseFloat(grade));
    return sum / grades.length;
}
;
;
// Criada a interface, agora o tipo do argumento da função pode ser definido como Student
function printStudent(student) {
    console.log("Name: ", student.name);
    console.log("Final grade: ", finalGrade(student.grades));
    // isApproved é uma propriedade opcional, portanto deve ser verificado se ela existe
    if (typeof student.isApproved == "boolean") {
        console.log("Is Approved: ", student.isApproved);
    }
}
// Declarar os elementos do array como Student
let students = [
    {
        name: "John",
        grades: ["8", "7", "10", "6"],
        isApproved: false
    },
    {
        name: "Sara",
        grades: ["8", "7"]
    }
];
// Tipos Literais
// Aceitar apenas um valor específico: 'small'. Nenhum outro string será aceito
let size;
// Union Types
// Acept strings ou números
let id;
// Aceitar apenas "small" ou "large" como argumentos da função
function buttonStyle(size) {
    let style;
    if (size == "small") {
        style = {
            height: "60px",
            width: "100px"
        };
    }
    else {
        style = {
            height: "80px",
            width: "140px"
        };
    }
    return style;
}
// Null e Undefined
// Aceitar apenas string, number ou null/undefined
// No caso de null e undefined, deve ser habilitada a regra 'strictNullChecks', senão
// o Typescript não vai testar se o código funciona
function printId(id) {
    if (typeof id == "string") {
        console.log(id.toUpperCase());
    }
    else if (typeof id == "number") {
        console.log(id);
    }
    else {
        console.log("No Id");
    }
}
// Any
// Sempre que um tipo não for declarado e não puder ser inferido,
// o Typescript infere como sendo 'any'
let person;
// Isto deve ser evitado pois o Typescript não fará mais a verificação do código com este tipo
person = 2;
person = "test";
person = new Date();
// "noImplicitAny": Esta regra pode ser usada no tsconfig para
// levantar a inferência de tipo 'any' como um erro, mas
// só funciona com funções. 
// O Typescript gerará a inferência 'any' como um erro
// função doubleNum(num) {
//console.log(num.toFixed(2));
// }
// Se você definir explicitamente o tipo como any, por outro lado,
// O Typescript não fará verificação de tipo. Tenha cuidado, pois isso pode
//causar bugs no seu código como você pode ver na função abaixo
function badFunction(num) {
    console.log(num.toUpperCase());
    console.log(num.toFixed());
    console.log(new Date(num));
}
// Elementos HTML
// Quando definimos um tipo específico de elemento HTML
// O Typescript nos ajudará a validar nosso código
function getName(input) {
    let name = input.value;
    console.log(name);
}
// Nós fazemos type assertion quando temos informações que o Typescript não tem como inferir
// Por exemplo, que tipo de elemento um seletor produzirá
let input = document.querySelector("input#firstName");
getName(input);
