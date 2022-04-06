const Bluebird = require('bluebird');
const knex = require('knex');
const { join } = require('path');

const createKnexClient = ({ connectionString, migrationsTableName }) => {
    const client = knex(connectionString);
    const migrationOptions = {
        tableName: migrationsTableName || 'knex_migrations',
        directory: join(__dirname, './app/migrations')
    };

    return Bluebird.resolve(client.migrate.latest(migrationOptions)).then(
        () => client
    );
};

module.exports = createKnexClient;