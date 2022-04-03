const createExpressApp = require('./app/express/index');
const createConfig = require('./config');
const env = require('./env');

const config = createConfig({ env });
const app = createExpressApp(config, env);

const start = () => {
    app.listen(env.port, signalAppStart);
};

const signalAppStart = () => {
    console.log(`${env.appName} STARTING`);
    console.table([
        ['PORT', env.port],
        ['ENVIRONMENT', env.env],
        ['VERSION', env.version],
    ]);
};

module.exports = {
    app,
    config,
    start,
};
