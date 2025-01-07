// vars/build.groovy
def call(String imageName , String imageTag,dockerfile) {
    // Add your build steps here, e.g., invoking shell commands, calling other scripts, etc.
    echo "Checking Docker version"
    sh "docker --version"

    echo "Build Docker Images ${imageName}:${imageTag}"
    sh "docker build -t ${imageName}:${imageTag} -f ${dockerfile} ."
    
}   
// Environment variables
// vars/build.groovy
def call() {
    // Fetch environment variables
    def imageName = System.getenv("IMAGE_NAME") ?: "default-image-name" // Default value if not set
    def imageTag = System.getenv("IMAGE_TAG") ?: "latest"              // Default value if not set
    def dockerfilePath = System.getenv("DOCKERFILE_PATH") ?: "./Dockerfile" // Default value if not set

    // Step 1: Check Docker version
    echo "Checking Docker version..."
    sh "docker --version"

    // Step 2: Build Docker image
    echo "Building Docker image ${imageName}:${imageTag} from Dockerfile at ${dockerfilePath}..."
    sh """
        docker build -t ${imageName}:${imageTag} -f ${dockerfilePath} .
    """

    // Optionally, push the Docker image to a registry if required
    // Example: docker push ${imageName}:${imageTag}
    // sh "docker push ${imageName}:${imageTag}"
}
