const Bluebird = require('bluebird')
const pg = require('pg')

function createDatabase ({ connectionString }) {
  const client = new pg.Client({ connectionString, Promise: Bluebird }) // (1)

  let connectedClient = null // (2)

  function connect () {
    if (!connectedClient) {
      connectedClient = client.connect()
        .then(() => client.query('SET search_path = message_store, public'))
        .then(() => client)
    }

    return connectedClient
  }

  function query (sql, values = []) { // (3)
    return connect()
      .then(client => client.query(sql, values))
  }

  return { // (4)
    query,
    stop: () => client.end()
  }
}

module.exports = createDatabase
