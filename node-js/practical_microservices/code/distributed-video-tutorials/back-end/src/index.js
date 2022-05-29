/***
 * Excerpted from "Practical Microservices",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/egmicro for more book information.
***/
const createConfig = require('./config')
const env = require('./env')

const config = createConfig({ env })

function start () {
  config.aggregators.forEach(a => a.start())
  config.components.forEach(s => s.start())

  signalAppStart()
}

function signalAppStart () {
  console.log(`${env.appName} started`)
  console.table([['Environment', env.env]])
}

module.exports = {
  config,
  start
}
