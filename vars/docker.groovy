def call(String dockerImages){
    sh "docker images "
    sh "docker --version"
}