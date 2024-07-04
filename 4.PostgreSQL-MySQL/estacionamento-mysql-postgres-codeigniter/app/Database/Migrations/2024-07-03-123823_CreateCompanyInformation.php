<?php

namespace App\Database\Migrations;

use CodeIgniter\Database\Migration;

class CreateCompanyInformation extends Migration
{
    # Conexão definida no arquivo .env
    # Está migração será aplicada no PostgreSQL

    protected $DBGroup = 'company';

    public function up()
    {
        // Define as colunas
        $this->forge->addField([
            // Nome do campo e propriedades.

            'id' => [
                'type'           => 'INT', // Tipo 
                'constraint'     => 5,     // Tamanho
                'unsigned'       => true,  // Não aceita valores negativos
                'auto_increment' => true,  // Auto incremento.
            ],

            'name' => [
                'type'       => 'VARCHAR',
                'constraint' => 100,
            ],

            'phone' => [
                'type'       => 'VARCHAR',
                'constraint' => 20,
            ],

            'address' => [
                'type'       => 'VARCHAR',
                'constraint' => 128,
            ],

            'message' => [
                'type'       => 'TEXT',
                'null'       => true,
                'default'    => null,
            ],

        ]);

        // Instrução da primary key
        $this->forge->addKey('id', true);

        // Instrução de criação da 'information' tabela no PSQL
        $this->forge->createTable('information');
    }

    // Definições para rollsbacks.
    public function down()
    {
        // Exclui a tabela criada acima.
        $this->forge->dropTable('information');
    }
}
