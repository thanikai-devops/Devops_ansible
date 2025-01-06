
def call() {
    // Add your build steps here, e.g., invoking shell commands, calling other scripts, etc.
    stage("Checking the version and install the dep"){
        steps{
            script{
                sh "node -v"
            }
        }
    }
}   
