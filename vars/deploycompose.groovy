def dockercomposer(){
    // Docker composer related Conf composer up and down related Stage
    sh "docker compose up -d api cron"
    sh "docker images && docker ps"
}