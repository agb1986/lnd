const uuid = require('uuid');

const primeRequestContext = (req, res, next) => {
    req.context = {
        traceId: uuid.v4,
    };
    next();
};

module.exports = primeRequestContext;