def ContainerAndImagesPrune(){
    echo "Cleanup the COntainer in JenkinsWorker"
    sh "docker system prune -f -a"
}

def dockercontainercompose(){
    echo "DOcker Container Clean up "
    def containerRunning = sh(script "docker ps -q",returnStdout: true).trim()
    if (containerRunning){
        echo "Container Found .Stopping Container"
        sh "docker compose down"
    } else{
        echo "No running Container found .Skipping Stages >> "
    }
}

def containerprune(){
    echo "Docker Container Stopping"
    def containerprune = sh(script "docker ps -q",returnStdout: true).trim()
    if (containerprune){
        echo "delete all container"
        sh "docker container stop && docker container prune -d"
    }
}