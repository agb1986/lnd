const express = require('express');
const uuid = require('uuid');

const createActions = ({ messageStore }) => {
    const recordViewing = (traceId, videoId, userId) => {
        const viewedEvent = {
            id: uuid,
            type: 'VideoViewed',
            metadata: {
                traceId,
                userId,
            },
            data: {
                userId,
                videoId,
            },
        };
        const steamName = `viewing-${videoId}`;
        return messageStore.write(steamName, viewedEvent);
    };
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

const createRecordViewings = ({ messageStore }) => {
    const actions = createActions({ messageStore });
    const handlers = createHandlers({ actions });
    const router = express.Router();

    return {
        actions,
        handlers,
        router,
    };
};

module.exports = createRecordViewings;
