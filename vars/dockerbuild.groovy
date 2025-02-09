// vars/build.groovy
// Environment variables
def buildimage(String imageName,String imageTag,String dockerfilepath,
 String dockerimagename="gooplusapi") {
    // Step 1: Check Docker version
    echo "Checking Docker version..."
    sh "docker --version"

    
    def tag = env.BUILD_ID
    // Step 2: Build Docker image
    echo "Pulling Docker image ${imageName}:${imageTag}..."
    sh """
        docker build -t  ${imageName}:${imageTag} -f ${dockerfilepath} .
    """ 

}


