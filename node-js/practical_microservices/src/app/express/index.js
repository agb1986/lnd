const express = require('express');
const { join } = require('path');

const mountMiddleWare = require('./middleware');
const mountRoutes = require('./routes');

const createExpressApp = ({ config, env }) => {
    const app = express();

    app.set('views', join(__dirname, '..'));
    app.set('view engine', 'pug');

    mountMiddleWare(app, env);
    mountRoutes(app, config);

    return app;
};

module.exports = createExpressApp;
