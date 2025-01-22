def cleanup(){
    // Cleanup Docker images 
    sh "docker system prune -a -f"
}