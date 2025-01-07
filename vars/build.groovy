// vars/build.groovy
// Environment variables
def call() {
    // Fetch environment variables
    def imageName = System.getenv("IMAGE_NAME") ?: "hello-world" // Default value if not set
    def imageTag = System.getenv("IMAGE_TAG") ?: "latest"              // Default value if not set
    // def dockerfilePath = System.getenv("DOCKERFILE_PATH") ?: "./Dockerfile" // Default value if not set

    // Step 1: Check Docker version
    echo "Checking Docker version..."
    sh "docker --version"
    // Step 2: Build Docker image
    echo "Pulling Docker image ${imageName}:${imageTag}..."
    sh """
        docker pull ${imageName}:${imageTag}
    """ 
    sh """
        docker run --rm ${imageName}:${imageTag}
    """
    // echo "Building Docker image ${imageName}:${imageTag} from Dockerfile at ${dockerfilePath}..."
    // sh """
    //     docker build -t ${imageName}:${imageTag} -f ${dockerfilePath} .
    // """
}
