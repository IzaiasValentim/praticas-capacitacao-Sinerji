
    // Migração que cria a tabela 'users'.
exports.up = function (knex, Promise) {
    return knex.schema.createTable('users', table => {
        table.increments('id').primary()
        table.string('name').notNull()
        table.string('email').notNull().unique()
        table.string('password').notNull()
    })
};
    // Desfaz a migração de criação da tabela 'users'
exports.down = function (knex, Promise) {
    return knex.schema.dropTable('users')
};
