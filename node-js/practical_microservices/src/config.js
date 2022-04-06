const createKnexClient = require('./knex-client');
const createHomeApp = require('./app/home');
const createRecordViewingApp = require('./app/record-viewings');

const createConfig = ({ env }) => {
    console.log(env);

    const db = createKnexClient({
        connectionString: env.databaseUrl,
    });

    const homeApp = createHomeApp({ db });
    const recordViewingApp = createRecordViewingApp({ db });

    return {
        env,
        db,
        homeApp,
        recordViewingApp,
    };
};

module.exports = createConfig;
