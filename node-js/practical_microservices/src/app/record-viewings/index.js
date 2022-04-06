const express = require('express');

const createActions = ({ db }) => {
    const recordViewing = (traceId, videoId) => {};

    return {
        recordViewing,
    };
};

const createHandlers = ({ actions }) => {
    const handleRecordViewing = (req, res) => {
        return actions
            .recordViewing(req.context.traceId, req.params.videoId)
            .then(() => res.redirect('/'));
    };

    return {
        handleRecordViewing,
    };
};

const createRecordViewings = ({ db }) => {
    const actions = createActions({ db });
    const handlers = createHandlers({ actions });
    const router = express.Router();

    return {
        actions,
        handlers,
        router,
    };
};

module.exports = createRecordViewings;
