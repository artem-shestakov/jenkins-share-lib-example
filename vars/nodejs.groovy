
def call(Map config=[:]){
    nodejs(nodeJSInstallationName: "${config.name}") {
        // install dependencies
        sh 'npm install'
        // Run
        sh("/home/ubuntu/.nvm/versions/node/v16.10.0/bin/pm2 stop ${config.env} && /home/ubuntu/.nvm/versions/node/v16.10.0/bin/pm2 delete ${config.env} || true")
        sh("PORT=${config.port} /home/ubuntu/.nvm/versions/node/v16.10.0/bin/pm2 start server.js --name ${config.env}")
    }
}