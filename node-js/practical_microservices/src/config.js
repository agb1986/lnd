const createKnexClient = require('./knex-client');
const createHomeApp = require('./app/home');
const createRecordViewingApp = require('./app/record-viewings');
const createPostgresClient = require('./postgres-client');
const createMessageStore = require('./message-store');

const createConfig = ({ env }) => {
    console.log(env);

    const db = createKnexClient({
        connectionString: env.databaseUrl,
    });

    const postgresClient = createPostgresClient({
        connectionString: env.messageStoreConnectionString,
    });

    const messageStore = createMessageStore({
        db: postgresClient,
    });

    const homeApp = createHomeApp({ db });
    const recordViewingApp = createRecordViewingApp({ messageStore });

    return {
        env,
        db,
        homeApp,
        recordViewingApp,
        messageStore,
    };
};

module.exports = createConfig;
