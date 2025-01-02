
def call(String project) {
    // Add your build steps here, e.g., invoking shell commands, calling other scripts, etc.
    stage("Checking Nodejs Version"){
        steps{
            script{
                sh "node -v"
            }
        }
    }
    stage("Cleanup the exiting process"){
        steps{
            script{
                def pm2status = sh(script: "pm2 list",return: true).trim()

                if (pm2status.contains("No process Found")) {
                    echo "currently Not runing process in pm2"
                } else {
                    sh "pm2 delete all"
                    echo "delete application runing using pm2"
                }
            }
        }
    }
}
