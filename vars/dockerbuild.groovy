// vars/build.groovy
// Environment variables
def call(String imageName,String imageTag,String dockerfilepath) {
    // Step 1: Check Docker version
    echo "Checking Docker version..."
    sh "docker --version"
    // Step 2: Build Docker image
    echo "Pulling Docker image ${imageName}:${imageTag}..."
    sh """
        docker build -t  ${imageName}/${imageTag} .
    """ 
}


